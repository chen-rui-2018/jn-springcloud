package com.jn.hr.employee.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.hr.common.enums.HrStatusEnums;
import com.jn.hr.employee.dao.TbManpowerEmployeeBasicInfoMapper;
import com.jn.hr.employee.dao.TbManpowerEntryManagementMapper;
import com.jn.hr.employee.entity.TbManpowerEmployeeBasicInfo;
import com.jn.hr.employee.entity.TbManpowerEntryManagement;
import com.jn.hr.employee.enums.EmployStatusEnum;
import com.jn.hr.employee.enums.EmployeeRelationsExceptionEnum;
import com.jn.hr.employee.enums.EmployeeTypeEnum;
import com.jn.hr.employee.model.EmployeeRelationsConfirmParam;
import com.jn.hr.employee.model.EmployeeRelationsPositiveParam;
import com.jn.hr.employee.model.EmployeeRelationsQuitParam;
import com.jn.hr.employee.model.EmployeeRelationsRetireParam;
import com.jn.hr.employee.service.EmployeeRelationsService;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * 员工关系业务实现层
 *
 * @author： wzy
 * @date： Created on 2019/6/11 20:18
 * @version： v1.0
 * @modified By:
 */
@Service
public class EmployeeRelationsServiceImpl implements EmployeeRelationsService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeRelationsServiceImpl.class);

    @Autowired
    private TbManpowerEmployeeBasicInfoMapper tbManpowerEmployeeBasicInfoMapper;

    @Autowired
    private TbManpowerEntryManagementMapper tbManpowerEntryManagementMapper;

    @Autowired
    private SystemClient systemClient;

    @Override
    @ServiceLog(doAction = "员工关系-转正管理（更新员工为正式员工）")
    public Result updateBecomeStatus(EmployeeRelationsPositiveParam employeeRelationsPositiveParam, User user) {
        logger.info("进入【员工关系-转正管理（更新员工为正式员工）】业务层方法,查询员工入參【{}】",JSONObject.toJSON(employeeRelationsPositiveParam));
        TbManpowerEmployeeBasicInfo tbManpowerEmployeeBasicInfo = tbManpowerEmployeeBasicInfoMapper.selectByPrimaryKey(employeeRelationsPositiveParam.getId());
        if(tbManpowerEmployeeBasicInfo == null){
            throw new JnSpringCloudException(EmployeeRelationsExceptionEnum.EMPLOYEE_NOT_EXISTS);
        }
        tbManpowerEmployeeBasicInfo.setEmployeeType(EmployeeTypeEnum.FORMAL.getCode());
        logger.info("【员工关系-转正管理（更新员工为正式员工）】更新员工状态入參【{}】",JSONObject.toJSON(tbManpowerEmployeeBasicInfo));
        int i = tbManpowerEmployeeBasicInfoMapper.updateByPrimaryKeySelective(tbManpowerEmployeeBasicInfo);
        if(i == 0){
            Result result = new Result();
            result.setCode(EmployeeRelationsExceptionEnum.EMPLOYEE_DATA_STATUS_ERROR.getCode());
            result.setData("更新员工为正式员工失败！");
            return result;
        }
        return new Result("更新员工为正式员工成功！");
    }

    @Override
    @ServiceLog(doAction = "员工关系-退休管理（更新员工状态为退休）")
    public Result updateRetireStatus(EmployeeRelationsRetireParam employeeRelationsRetireParam, User user) {
        logger.info("进入【员工关系-退休管理（更新员工状态为退休）】业务层方法,查询员工入參【{}】",JSONObject.toJSON(employeeRelationsRetireParam));
        TbManpowerEmployeeBasicInfo tbManpowerEmployeeBasicInfo = tbManpowerEmployeeBasicInfoMapper.selectByPrimaryKey(employeeRelationsRetireParam.getId());
        if(tbManpowerEmployeeBasicInfo == null){
            throw new JnSpringCloudException(EmployeeRelationsExceptionEnum.EMPLOYEE_NOT_EXISTS);
        }
        tbManpowerEmployeeBasicInfo.setEmployStatus(Byte.parseByte(EmployStatusEnum.JOB_3.getCode()));
        logger.info("【员工关系-退休管理（更新员工状态为退休）】更新员工状态入參【{}】",JSONObject.toJSON(tbManpowerEmployeeBasicInfo));
        int i = tbManpowerEmployeeBasicInfoMapper.updateByPrimaryKeySelective(tbManpowerEmployeeBasicInfo);
        if(i == 0){
            Result result = new Result();
            result.setCode(EmployeeRelationsExceptionEnum.EMPLOYEE_DATA_STATUS_ERROR.getCode());
            result.setData("更新员工状态为退休失败！");
            return result;
        }
        return new Result("更新员工状态为退休成功！");
    }

    @Override
    @ServiceLog(doAction = "员工关系-离职管理（更新员工状态为离职）")
    public Result updateQuitStatus(EmployeeRelationsQuitParam employeeRelationsQuitParam, User user) {
        logger.info("进入【员工关系-离职管理（更新员工状态为离职）】业务层方法,查询员工入參【{}】",JSONObject.toJSON(employeeRelationsQuitParam));
        TbManpowerEmployeeBasicInfo tbManpowerEmployeeBasicInfo = tbManpowerEmployeeBasicInfoMapper.selectByPrimaryKey(employeeRelationsQuitParam.getId());
        if(tbManpowerEmployeeBasicInfo == null){
            throw new JnSpringCloudException(EmployeeRelationsExceptionEnum.EMPLOYEE_NOT_EXISTS);
        }
        tbManpowerEmployeeBasicInfo.setEmployStatus(Byte.parseByte(EmployStatusEnum.JOB_4.getCode()));
        logger.info("【员工关系-离职管理（更新员工状态为离职）】更新员工状态入參【{}】",JSONObject.toJSON(tbManpowerEmployeeBasicInfo));
        int i = tbManpowerEmployeeBasicInfoMapper.updateByPrimaryKeySelective(tbManpowerEmployeeBasicInfo);
        if(i == 0){
            Result result = new Result();
            result.setCode(EmployeeRelationsExceptionEnum.EMPLOYEE_DATA_STATUS_ERROR.getCode());
            result.setData("更新员工状态为离职失败！");
            return result;
        }
        return new Result("更新员工状态为离职成功！");
    }

    @Override
    @ServiceLog(doAction = "员工关系-入职管理（确认入职&发送邀请）")
    @Transactional(rollbackFor = Exception.class)
    public Result confirmationAdmis(EmployeeRelationsConfirmParam employeeRelationsConfirmParam, User user) {
        logger.info("进入【员工关系-入职管理（确认入职&发送邀请）】业务层方法,查询员工入參【{}】",JSONObject.toJSON(employeeRelationsConfirmParam));
        TbManpowerEntryManagement tbManpowerEntryManagement = tbManpowerEntryManagementMapper.selectByPrimaryKey(employeeRelationsConfirmParam.getId());
        if(tbManpowerEntryManagement == null){
            throw new JnSpringCloudException(EmployeeRelationsExceptionEnum.EMPLOYEE_NOT_EXISTS);
        }
        /**1.更新入职员工状态和发送邀请状态*/
        tbManpowerEntryManagement.setIsEntryRegistration(Byte.parseByte(EmployStatusEnum.RELATIONS_ENTRY_IS_REGIST_1.getCode()));
        tbManpowerEntryManagement.setStatus(Byte.parseByte(EmployStatusEnum.RELATIONS_ENTRY_STATUS_2.getCode()));
        tbManpowerEntryManagement.setConfirmEntryDate(new Date());
        logger.info("【员工关系-入职管理（确认入职&发送邀请）】更新员工入职状态和发送邀请状态入參【{}】",JSONObject.toJSON(tbManpowerEntryManagement));
        tbManpowerEntryManagementMapper.updateByPrimaryKeySelective(tbManpowerEntryManagement);
        logger.info("【员工关系-入职管理（确认入职&发送邀请）】结束员工入职状态和发送邀请状态修改");
        /**2.新增一条数据到user表并返回用户id和用户账号*/
        User addUser = new User();
        /**用户名默认为手机号码*/
        addUser.setAccount(tbManpowerEntryManagement.getPhone());
        addUser.setPassword("123456");
        addUser.setName(tbManpowerEntryManagement.getName());
        addUser.setPhone(tbManpowerEntryManagement.getPhone());
        addUser.setEmail(tbManpowerEntryManagement.getMailbox());
        logger.info("【员工关系-入职管理（确认入职&发送邀请）】调用新增用户接口addSysUser,入參【{}】",JSONObject.toJSON(addUser));
        Result result = systemClient.addSysUser(addUser);
        logger.info("【员工关系-入职管理（确认入职&发送邀请）】调用新增用户接口addSysUser,返回参数【{}】",JSONObject.toJSON(result));
        if(!StringUtils.equals(result.getCode(),"0000") || result.getData() == null){
            logger.error("调用新增用户接口addSysUser调用失败,入參【{}】",JSONObject.toJSON(addUser));
            throw new JnSpringCloudException(EmployeeRelationsExceptionEnum.EMPLOYEE_DATA_ADD_USER_ERROR);
        }
        TbManpowerEmployeeBasicInfo tbEmployeeBasicInfo = new TbManpowerEmployeeBasicInfo();
        BeanUtils.copyProperties(tbManpowerEntryManagement,tbEmployeeBasicInfo);
        tbEmployeeBasicInfo.setId(UUID.randomUUID().toString().replaceAll("_",""));
        tbEmployeeBasicInfo.setRecordStatus(Byte.parseByte(HrStatusEnums.EFFECTIVE.getCode()));
        tbEmployeeBasicInfo.setCreatedTime(new Date());
        tbEmployeeBasicInfo.setCreatorAccount(user.getAccount());
        tbEmployeeBasicInfo.setEntryDate(new Date());
        tbEmployeeBasicInfo.setUserId(((Map<String, String>) result.getData()).get("id"));
        tbEmployeeBasicInfo.setUserAccount(((Map<String, String>) result.getData()).get("account"));
        tbEmployeeBasicInfo.setSupplyStatus(EmployStatusEnum.RELATIONS_SUPPLY_STATUS_1.getCode());
        tbEmployeeBasicInfo.setStatus(EmployStatusEnum.RELATIONS_STATUS_4.getCode());
        logger.info("【员工关系-入职管理（确认入职&发送邀请）】将入职员工信息插入基础表,入參【{}】",JSONObject.toJSON(tbEmployeeBasicInfo));
        int i= tbManpowerEmployeeBasicInfoMapper.insertSelective(tbEmployeeBasicInfo);
        if(i == 0){
            Result result2 = new Result();
            result2.setCode(EmployeeRelationsExceptionEnum.EMPLOYEE_DATA_STATUS_ERROR.getCode());
            result2.setData("确认入职&发送邀请失败！");
            return result2;
        }
        logger.info("【员工关系-入职管理（确认入职&发送邀请）】将入职员工信息插入基础表成功！");
        return new Result("确认入职&发送邀请成功！");
    }
}
