package com.jn.park.attractinvest.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jn.common.channel.MessageSource;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.company.api.CompanyClient;
import com.jn.company.model.UpdateCompanyInfoParam;
import com.jn.news.vo.EmailVo;
import com.jn.news.vo.SmsTemplateVo;
import com.jn.park.api.RoomOrderClient;
import com.jn.park.asset.dao.TbTowerInformationMapper;
import com.jn.park.asset.entity.TbTowerInformation;
import com.jn.park.attractinvest.dao.ProjectInfoMapper;
import com.jn.park.attractinvest.dao.TbProjectInfoMapper;
import com.jn.park.attractinvest.domain.ProjectProperties;
import com.jn.park.attractinvest.enmus.*;
import com.jn.park.attractinvest.entity.TbProjectEnterDetails;
import com.jn.park.attractinvest.entity.TbProjectInfo;
import com.jn.park.attractinvest.entity.TbProjectInfoCriteria;
import com.jn.park.attractinvest.entity.TbProjectInfoWithBLOBs;
import com.jn.park.attractinvest.model.ProjectInfo;
import com.jn.park.attractinvest.service.ProjectInfoService;
import com.jn.park.attractinvest.vo.ProjectInfoVo;
import com.jn.park.pmpaybill.entity.TbPmPriceRuleDeatils;
import com.jn.park.pmpaybill.enums.CalcmodeEnums;
import com.jn.park.pmpaybill.enums.PmPayBillStatusEnums;
import com.jn.park.pmpaybill.service.PmPayBillService;
import com.jn.park.pmpaybill.service.PmPriceRuleService;
import com.jn.park.pmpaybill.vo.PmPriceRuleVo;
import com.jn.send.api.DelaySendMessageClient;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysRole;
import com.jn.system.model.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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

    @Autowired
    private RoomOrderClient roomOrderClient;

    @Autowired
    private PmPriceRuleService pmPriceRuleService;

    @Autowired
    private PmPayBillService pmPayBillService;

    @Autowired
    private TbTowerInformationMapper towerInformationMapper;

    @Autowired
    private CompanyClient companyClient;

    @Autowired
    private DelaySendMessageClient delaySendMessageClient;


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
     * 企业入驻流程后置处理
     *
     * @param projectInfoVo 企业入驻详情信息
     */
    @Override
    @ServiceLog(doAction = "企业入驻流程后置处理")
    @Transactional(rollbackFor = Exception.class)
    public void enterpriseEnterHandle(ProjectInfoVo projectInfoVo, User user) {
        //企业名称
        String companyName = projectInfoVo.getCompanyName();
        //获取企业id
        String companyId = projectInfoVo.getCompanyId();
        //企业管理人账号
        String userAccount = projectInfoVo.getComAdmin();
        //获取企业主题楼宇
        String mainTowerId = projectInfoVo.getMainTowerId();

        //获取主体楼宇信息
        String towerName;
        if (StringUtils.isNotBlank(mainTowerId) && !StringUtils.equals("0", mainTowerId)) {
            //获取楼宇信息
            TbTowerInformation tbTowerInformation = towerInformationMapper.selectByPrimaryKey(mainTowerId);
            if (tbTowerInformation == null) {
                logger.error("[招商管理] 获取楼宇信息失败,楼宇id:{}", mainTowerId);
                throw new JnSpringCloudException(BusinessAdExceptionEnmus.GET_TOWER_INFO_FAILER);
            }

            towerName = tbTowerInformation.getName();
        } else {
            //企业入驻楼宇信息只有一栋楼
            List<TbProjectEnterDetails> tb_project_enter_details = projectInfoVo.getTb_project_enter_details();
            mainTowerId = tb_project_enter_details.get(0).getTowerId();
            towerName = tb_project_enter_details.get(0).getEnterTower();
        }

        //更新企业的主题楼宇信息
        updateCompanyInfo(companyId, mainTowerId, towerName);

        //项目id
        String id = projectInfoVo.getId();
        //企业联系人
        String contactName;
        if (StringUtils.isNotBlank(projectInfoVo.getLinker())) {
            contactName = projectInfoVo.getLinker();
        } else {
            contactName = projectInfoVo.getLegalPersoner();
        }
        //联系人联系方式
        String contactPhone;
        if (StringUtils.isNotBlank(projectInfoVo.getLinkerPhone())) {
            contactPhone = projectInfoVo.getLinkerPhone();
        } else {
            contactPhone = projectInfoVo.getLegalPersoner();
        }
        //起租时间
        Date comStartTime = projectInfoVo.getRentStartTime();
        java.sql.Date leaseStartTime = new java.sql.Date(comStartTime.getTime());
        //租赁月份
        Integer rentMonthNum = projectInfoVo.getRentMonthNum();

        //物业费规则id
        String pmRuleId = UUID.randomUUID().toString();

        List<TbProjectEnterDetails> tb_project_enter_details = projectInfoVo.getTb_project_enter_details();
        //物业费单价管理规则明细集合
        List<TbPmPriceRuleDeatils> pmPriceRuleDeatilsList = new ArrayList<>(16);
        StringBuffer roomIds = new StringBuffer();
        for (TbProjectEnterDetails tbProjectEnterDetails : tb_project_enter_details) {
            //获取房间id
            roomIds.append(tbProjectEnterDetails.getRoomId()).append(",");

            //设置物业费单价明细
            TbPmPriceRuleDeatils tbPmPriceRuleDeatils = getTbPmPriceRuleDeatils(user, pmRuleId, tbProjectEnterDetails);
            pmPriceRuleDeatilsList.add(tbPmPriceRuleDeatils);
        }
        //判断企业租赁了房租信息
        if (roomIds.length() > 0) {
            //1.调用房间生成订单接口
            Result result = roomOrderClient.addRoomOrders(roomIds.substring(0, roomIds.length() - 1), contactName, contactPhone
                    , leaseStartTime, rentMonthNum.toString(), userAccount);
            String orderId = null;
            if (result != null && result.getData() != null) {
                orderId = (String) result.getData();
                logger.info("[项目管理] 生成企业租赁信息生成订单成功,订单号:{},企业管理员:{}", orderId, userAccount);
            } else {
                logger.error("[项目管理] 生成企业租赁信息生成订单失败,企业管理员:{}", userAccount);
                throw new JnSpringCloudException(BusinessAdExceptionEnmus.ROOM_ORDER_FAILER);
            }

            //2.获取到订单号,生成缴费单
            createRoomBill(id, userAccount, orderId);

            //3.设置物业费单价规则信息
            PmPriceRuleVo pmPriceRuleVo = getPmPriceRuleVo(projectInfoVo, user, pmRuleId, pmPriceRuleDeatilsList);

            //4.生成企业物业费规则
            pmPriceRuleService.createPmPriceRule(pmPriceRuleVo);
            logger.info("[项目管理] 为企业插入缴费规则信息成功,企业管理员:{}", userAccount);

            //5.生成物业缴费单并将缴费单推送给企业
            pmPayBillService.createPmBill(companyId, projectInfoVo.getRentStartTime());
            logger.info("[项目管理] 为企业生成缴费单,并将缴费单推送给企业成功,企业管理员:{}", userAccount);
        }
    }

    /**
     * 更新企业楼宇信息
     *
     * @param companyId   企业id
     * @param mainTowerId 楼宇id
     * @param towerName   楼宇名称
     */
    private void updateCompanyInfo(String companyId, String mainTowerId, String towerName) {
        UpdateCompanyInfoParam company = new UpdateCompanyInfoParam();
        company.setComId(companyId);
        company.setParkBuildId(mainTowerId);
        company.setParkBuildName(towerName);
        companyClient.updateCompanyInfoAfterPay(company);
        logger.info("[企业入驻] 更新企业楼宇信息成功,企业id:{}", companyId);
    }

    /**
     * 生成房间缴费单
     *
     * @param id          项目id
     * @param userAccount 企业管理员账号
     * @param orderId     房间订单id
     */
    private void createRoomBill(String id, String userAccount, String orderId) {
        Result createBillResult = roomOrderClient.createRoomOrderBillByOrder(orderId);
        if (createBillResult != null && createBillResult.getData() != null) {
            String billId = (String) createBillResult.getData();
            //将订单号保存至数据库中
            TbProjectInfoWithBLOBs tbProjectInfoWithBLOBs = tbProjectInfoMapper.selectByPrimaryKey(id);
            tbProjectInfoWithBLOBs.setRoomBillId(billId);
            //更新企业状态为企业缴费中
            tbProjectInfoWithBLOBs.setStatus(new Byte(ProjectStatusEnums.PAYING.getCode()));
            tbProjectInfoMapper.updateByPrimaryKeySelective(tbProjectInfoWithBLOBs);
            logger.info("[项目管理] 生成企业租赁信息生成缴费单成功,缴费单id:{},企业管理员:{}", billId, userAccount);
        } else {
            logger.error("[项目管理] 生成企业租赁信息生成缴费单失败,企业管理员:{}", userAccount);
            throw new JnSpringCloudException(BusinessAdExceptionEnmus.BILL_CRATE_FAILER);
        }
    }

    /**
     * 获取物业费规则明细
     *
     * @param projectInfoVo
     * @param user                   用户id
     * @param pmRuleId               规则id
     * @param pmPriceRuleDeatilsList 明细集合
     * @return
     */
    private PmPriceRuleVo getPmPriceRuleVo(ProjectInfoVo projectInfoVo, User user, String pmRuleId, List<TbPmPriceRuleDeatils> pmPriceRuleDeatilsList) {
        PmPriceRuleVo pmPriceRuleVo = new PmPriceRuleVo();
        //id
        pmPriceRuleVo.setId(pmRuleId);
        //公司id
        pmPriceRuleVo.setCompanyId(projectInfoVo.getCompanyId());
        //公司名称
        pmPriceRuleVo.setCompanyName(projectInfoVo.getCompanyName());
        //设置有效
        pmPriceRuleVo.setRecordStatus(new Byte(PmPayBillStatusEnums.EFFECTIVE.getCode()));
        //创建人
        pmPriceRuleVo.setCreatorAccount(user.getAccount());
        //计费方式
        pmPriceRuleVo.setPricingWay(CalcmodeEnums.COMMON.getCode());
        //创建时间
        pmPriceRuleVo.setCreatedTime(new Date());
        //最新修改时间
        pmPriceRuleVo.setModifiedTime(new Date());
        //设置规则明细
        pmPriceRuleVo.setTbPmPriceRuleDeatilsList(pmPriceRuleDeatilsList);
        return pmPriceRuleVo;
    }

    /**
     * 获取物业费单价规则明细
     *
     * @param user
     * @param pmRuleId
     * @param tbProjectEnterDetails
     * @return
     */
    private TbPmPriceRuleDeatils getTbPmPriceRuleDeatils(User user, String pmRuleId, TbProjectEnterDetails tbProjectEnterDetails) {
        //封装物业费规则详情实体信息
        TbPmPriceRuleDeatils tbPmPriceRuleDeatils = new TbPmPriceRuleDeatils();
        //id
        tbPmPriceRuleDeatils.setId(UUID.randomUUID().toString());
        //规则id
        tbPmPriceRuleDeatils.setRuleId(pmRuleId);
        //楼宇id
        tbPmPriceRuleDeatils.setTowerId(tbProjectEnterDetails.getTowerId());
        //楼宇名称
        tbPmPriceRuleDeatils.setTowerName(tbProjectEnterDetails.getEnterTower());
        //房间id
        tbPmPriceRuleDeatils.setRoomId(tbProjectEnterDetails.getRoomId());
        //房间名称
        tbPmPriceRuleDeatils.setRoomName(tbProjectEnterDetails.getRoomName());
        //设置有效
        tbPmPriceRuleDeatils.setRecordStatus(new Byte(PmPayBillStatusEnums.EFFECTIVE.getCode()));
        //设置创建人
        tbPmPriceRuleDeatils.setCreatorAccount(user.getAccount());
        //物业费单价
        tbPmPriceRuleDeatils.setPmUnitPrice(tbProjectEnterDetails.getPmUnitPrice());
        //设置房间面积
        BigDecimal decimal = new BigDecimal(0);
        if (StringUtils.isNotBlank(tbProjectEnterDetails.getRoomArea())) {
            decimal = new BigDecimal(tbProjectEnterDetails.getRoomArea());
        }
        //房间平方
        tbPmPriceRuleDeatils.setRoomArea(decimal);
        return tbPmPriceRuleDeatils;
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
        if (projectInfoList == null || projectInfoList.size() == 0) {
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
                            .formatDate(tbProjectInfo.getCompactStartTime(), "yyyy-MM-dd HH:mm:ss"));
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
            if (StringUtils.isNotBlank(id) && id.startsWith("user")) {
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
