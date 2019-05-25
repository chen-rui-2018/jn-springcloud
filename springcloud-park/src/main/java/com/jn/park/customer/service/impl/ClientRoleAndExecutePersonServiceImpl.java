package com.jn.park.customer.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.park.customer.dao.TbClientRolePersonInfoMapper;
import com.jn.park.customer.entity.TbClientRolePersonInfo;
import com.jn.park.customer.entity.TbClientRolePersonInfoCriteria;
import com.jn.park.customer.service.ClientRoleAndExecutePersonService;
import com.jn.park.enums.CustomerCenterExceptionEnum;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysRole;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: yangph
 * @Date: 2019/5/16 22:38
 * @Version v1.0
 * @modified By:
 */
@Service
public class ClientRoleAndExecutePersonServiceImpl implements ClientRoleAndExecutePersonService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ClientRoleAndExecutePersonServiceImpl.class);

    /**
     * 日期格式
     */
    private static final String PATTERN="yyyy-MM-dd HH:mm:ss";

    @Autowired
    private SystemClient systemClient;

    @Autowired
    private TbClientRolePersonInfoMapper personInfoMapper;


    /**
     * 添加角色和用户信息
     * @param roleName      角色名称
     * @param loginAccount  用户账号
     * @return
     */
    @Override
    @ServiceLog(doAction = "添加角色和用户信息")
    public int addRoleAndExecutePersonInfo(String roleName, String loginAccount) {
        //根据角色获取角色对应的信息
        Result<SysRole> roleByNameData= systemClient.getRoleByName(roleName);
        if(roleByNameData==null ||roleByNameData.getData()==null){
            logger.warn("添加角色和用户信息失败，当前角色名称信息在系统中不存在");
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.CURRENT_ROLE_NAME_INFO_NOT_EXIST);
        }
        SysRole sysRole = roleByNameData.getData();
        TbClientRolePersonInfo tcr=new TbClientRolePersonInfo();
        tcr.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        tcr.setRoleId(sysRole.getId());
        tcr.setRoleName(sysRole.getRoleName());
        tcr.setCreatedTime(DateUtils.parseDate(DateUtils.getDate(PATTERN)));
        tcr.setCreatorAccount(loginAccount);
        tcr.setRecordStatus(RecordStatusEnum.EFFECTIVE.getValue());
        //调用根据角色获取角色所属用户信息接口，设置用户id,用户账号信息
        Result<List<User>> userByRole = systemClient.getUserByRole(sysRole);
        if(userByRole==null || userByRole.getData()==null){
            logger.warn("添加角色和用户信息失败，获取当前角色下的用户信息失败");
            throw new JnSpringCloudException(CustomerCenterExceptionEnum.CURRENT_ROLE_NOT_HAVE_USER);
        }
        List<User> userList = userByRole.getData();
        List<String>userIdList=new ArrayList<>(16);
        List<String>userAccountList=new ArrayList<>(16);
        for(User user:userList){
            userIdList.add("user"+user.getId());
            userAccountList.add(user.getAccount());
        }
        tcr.setUserId(StringUtils.join(userIdList,","));
        tcr.setUserAccount(StringUtils.join(userAccountList,","));
        //判断数据库表中是否已存在，若存在，更新，不存在，新增
        TbClientRolePersonInfoCriteria example=new TbClientRolePersonInfoCriteria();
        example.createCriteria().andRoleIdEqualTo(tcr.getRoleId()).andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue());
        List<TbClientRolePersonInfo> rolePersonInfoList = personInfoMapper.selectByExample(example);
        if(rolePersonInfoList==null || rolePersonInfoList.isEmpty()){
            return personInfoMapper.insertSelective(tcr);
        }else{
            tcr.setCreatedTime(null);
            tcr.setCreatorAccount(null);
            tcr.setModifiedTime(DateUtils.parseDate(DateUtils.getDate()));
            tcr.setModifierAccount(loginAccount);
            return personInfoMapper.updateByExampleSelective(tcr,example);
        }
    }
}
