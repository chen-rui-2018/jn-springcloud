package com.jn.park.attractinvest.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jn.common.channel.MessageSource;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.news.vo.EmailVo;
import com.jn.news.vo.SmsTemplateVo;
import com.jn.park.attractinvest.dao.ProjectInfoMapper;
import com.jn.park.attractinvest.dao.TbProjectInfoMapper;
import com.jn.park.attractinvest.domain.ProjectProperties;
import com.jn.park.attractinvest.enmus.CompactStatusEnums;
import com.jn.park.attractinvest.enmus.ProjectNoticesTemplateEnums;
import com.jn.park.attractinvest.enmus.ProjectProcessEnums;
import com.jn.park.attractinvest.entity.TbProjectInfo;
import com.jn.park.attractinvest.entity.TbProjectInfoCriteria;
import com.jn.park.attractinvest.model.ProjectInfo;
import com.jn.park.attractinvest.service.ProjectInfoService;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysRole;
import com.jn.system.model.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 项目管理service实现
 *
 * @author： shaobao
 * @date： Created on 2019/4/29 9:42
 * @version： v1.0
 * @modified By:
 **/
@Service
public class ProjectInfoServiceImpl implements ProjectInfoService {

    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ProjectInfoServiceImpl.class);

    @Autowired
    private ProjectInfoMapper projectInfoMapper;

    @Autowired
    private TbProjectInfoMapper tbProjectInfoMapper;

    @Autowired
    private SystemClient systemClient;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ProjectProperties projectProperties;


    /**
     * 定时更新项目管理拟制合同状态
     */
    @Override
    @ServiceLog(doAction = "定时更新项目管理拟制合同状态")
    @Transactional(rollbackFor = Exception.class)
    public void updateProjectInfoStatus() {
        //更新拟制合同超出3个工作日的项目状态
        projectInfoMapper.updateProjectStatus1();

        //更新拟制合同超出5个工作日的项目状态
        projectInfoMapper.updateProjectStatus2();
    }

    /**
     * 项目管理，拟制合同状态不正常提醒功能
     */
    @Override
    @ServiceLog(doAction = "项目管理，拟制合同状态不正常提醒功能")
    public void projectRemind() {
        //1.查询拟制合同超过三天还未完成的用户
        remind1();

        //2.查询拟制合同超出5天未完成录入的项目，发送邮件，提醒相关园区负责人
        remind2();

    }

    /**
     * 查询拟制合同超出5天未完成录入的项目，发送邮件，提醒相关园区负责人
     */
    private void remind2() {
        TbProjectInfoCriteria tbProjectInfoCriteria = new TbProjectInfoCriteria();
        TbProjectInfoCriteria.Criteria criteria = tbProjectInfoCriteria.createCriteria();
        //查询项目进度处于项目洽谈阶段
        criteria.andProjectProcessEqualTo(ProjectProcessEnums.TALKING.getCode());
        //查询拟制合同超过3天的数据
        criteria.andCompactStatusEqualTo(CompactStatusEnums.ABNORMALITY.getCode());
        //查询拟制合同结束时间为空的数据
        criteria.andCompactEndTimeIsNull();
        List<TbProjectInfo> projectInfoList = tbProjectInfoMapper.selectByExample(tbProjectInfoCriteria);
        if(projectInfoList == null || projectInfoList.size() == 0){
            return;
        }

        //2.根据角色id,查询拟制合同管理员信息
        String roleId = projectProperties.getRoleId();
        if (StringUtils.isNotBlank(roleId)) {
            SysRole role = new SysRole();
            role.setId(roleId);
            Result<List<User>> userByRole = systemClient.getUserByRole(role);
            List<User> userList = userByRole.getData();
            //如果管理员信息不为空,获取管理员邮箱信息
            StringBuffer buffer = new StringBuffer();
            if (userList != null) {
                for (User user : userList) {
                    String email = user.getEmail();
                    if (StringUtils.isNotBlank(email)) {
                        buffer.append(email).append(",");
                    }
                }
            }
            String email = null;
            if (buffer.length() > 0) {
                email = buffer.substring(0, buffer.length() - 1);
            }

            //3.如果用户邮箱不为空,调用邮件发送接口
            if (StringUtils.isNotBlank(email)) {
                EmailVo emailVo = new EmailVo();
                emailVo.setEmail(email);
                emailVo.setEmailSubject("[白下智慧园区]项目管理拟制合同异常提醒");
                emailVo.setTemplatesName("parkProjectRemindTemplate");

                List<ProjectInfo> projectInfos = new ArrayList<>(16);
                //封装需要的数据
                for (TbProjectInfo tbProjectInfo : projectInfoList) {
                    String creatorAccount = tbProjectInfo.getCreatorAccount();
                    Object parse = JSONValue.parse(creatorAccount);
                    JSONArray array = (JSONArray) parse;
                    JSONObject obj2 = (JSONObject) array.get(0);
                    String creator = (String) obj2.get("name");

                    ProjectInfo projectInfo = new ProjectInfo();
                    projectInfo.setProjectName(tbProjectInfo.getProjectName());
                    projectInfo.setCreatorAccount(creator);
                    projectInfo.setCompactStartTime(DateUtils
                            .formatDate(tbProjectInfo.getCompactStartTime(),"yyyy-MM-dd HH:mm:ss"));
                    projectInfos.add(projectInfo);

                }

                //封装数据
                Map map = new HashMap();
                map.put("currentTime", DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
                map.put("projectInfoList", projectInfos);
                emailVo.setTemplatesDataMap(map);
                emailVo.setTemplateFlag(true);

                boolean sendStatus = messageSource.outputEmail().send(MessageBuilder.withPayload(emailVo).build());
                if (sendStatus) {
                    logger.info("[项目管理] 拟制合同异常提醒发送成功,email:{}", email);
                } else {
                    logger.error("[项目管理] 拟制合同异常提醒发送失败,email:{}", email);
                }
            }
        }
    }

    /**
     * 拟制合同,时间超过3天,项目录入人提箱功能
     */
    private void remind1() {
        TbProjectInfoCriteria tbProjectInfoCriteria = new TbProjectInfoCriteria();
        TbProjectInfoCriteria.Criteria criteria = tbProjectInfoCriteria.createCriteria();
        //查询项目进度处于项目洽谈阶段
        criteria.andProjectProcessEqualTo(ProjectProcessEnums.TALKING.getCode());
        //查询拟制合同超过3天的数据
        criteria.andCompactStatusEqualTo(CompactStatusEnums.UNNOMAL.getCode());
        //查询拟制合同结束时间为空的数据
        criteria.andCompactEndTimeIsNull();
        List<TbProjectInfo> tbProjectInfos = tbProjectInfoMapper.selectByExample(tbProjectInfoCriteria);
        for (TbProjectInfo tbProjectInfo : tbProjectInfos) {
            //获取录入人信息
            String creator = tbProjectInfo.getCreatorAccount();
            Object parse = JSONValue.parse(creator);
            JSONArray array = (JSONArray) parse;
            JSONObject obj2 = (JSONObject) array.get(0);
            User user = new User();
            user.setId((String) obj2.get("id"));
            //获取录入人id
            String id = user.getId();
            if (StringUtils.isNotBlank(id) && id.startsWith("user")){
                user.setId(id.substring(4));
            }
            Result<User> result = systemClient.getUser(user);
            User user1 = result.getData();
            if (user1 != null && StringUtils.isNotBlank(user1.getPhone())) {
                //为项目录入人发送短信提醒通知
                SmsTemplateVo smsTemplateVo = new SmsTemplateVo();
                smsTemplateVo.setTemplateId(ProjectNoticesTemplateEnums.MESSAGE_TEMPLATE.getCode());
                String[] m = {user1.getPhone()};
                smsTemplateVo.setMobiles(m);
                String[] t = {tbProjectInfo.getProjectName()};
                smsTemplateVo.setContents(t);
                messageSource.outputSms().send(MessageBuilder.withPayload(smsTemplateVo).build());
                logger.info("[项目管理] 拟制合同异常提醒发送成功,userId:{}", user1.getId());
            }
        }
    }
}
