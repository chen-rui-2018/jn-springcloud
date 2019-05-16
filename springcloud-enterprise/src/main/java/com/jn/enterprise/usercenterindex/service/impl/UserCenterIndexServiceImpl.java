package com.jn.enterprise.usercenterindex.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.RequireExceptionEnum;
import com.jn.enterprise.usercenterindex.controller.UserCenterIndexController;
import com.jn.enterprise.usercenterindex.dao.UserCenterIndexDao;
import com.jn.enterprise.usercenterindex.enums.UserCenterExceptionEnum;
import com.jn.enterprise.usercenterindex.model.EmployeeRequisitionModel;
import com.jn.enterprise.usercenterindex.model.RequirementManageModel;
import com.jn.enterprise.usercenterindex.service.UserCenterIndexService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: tangry
 * @Date: 2019/5/13
 * @Version 1.0
 */
@Transactional
@Service
public class UserCenterIndexServiceImpl implements UserCenterIndexService {

    @Autowired
    private UserCenterIndexDao userCenterIndexDao;

    @Autowired
    private UserExtensionClient userExtensionClient;

    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(UserCenterIndexServiceImpl.class);

    @ServiceLog(doAction = "企业邀请")
    @Override
    public String findBusinessInvitation(User user) {
        //判断当前账号是否是企业用户
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(user.getAccount());
        if(userExtension==null || userExtension.getData()==null){
            logger.warn("我收到的需求列表查询根据账号获取用户信息失败");
            throw new JnSpringCloudException(UserCenterExceptionEnum.NETWORK_ANOMALY);
        }
        //获取企业code  如果为空则不是企业用户,能查询到信息,如果不为空则已经是企业用户,不能查看消息
        String companyCode= userExtension.getData().getCompanyCode();
        if(companyCode != null){
            throw new JnSpringCloudException(UserCenterExceptionEnum.ENTERPRISE_USER_NOT_LOOK);
        }
        //查询消息列表表中类型为 企业邀请  类型的消息

        String findBusinessInvitation=userCenterIndexDao.findBusinessInvitation(user.getAccount());

        return findBusinessInvitation;
    }

    @ServiceLog(doAction = "员工申请")
    @Override
    public String findEmployeeRequisition(User user) {
        //判断当前账号是否是企业用户或者是机构用户
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(user.getAccount());
        if(userExtension==null || userExtension.getData()==null){
            logger.warn("我收到的需求列表查询根据账号获取用户信息失败");
            throw new JnSpringCloudException(UserCenterExceptionEnum.NETWORK_ANOMALY);
        }
        //获取机构code 和 企业code 判断是否是企业用户或者是机构用户
        String affiliateCode= userExtension.getData().getAffiliateCode();
        String companyCode= userExtension.getData().getCompanyCode();

        if(affiliateCode == null || companyCode == null){
            //throw new JnSpringCloudException(UserCenterExceptionEnum.IS_ENTERPRISE_OR_ORGANIZATION_USER_NOT_LOOK);
        }
        //查询
        EmployeeRequisitionModel emodel=userCenterIndexDao.findEmployeeRequisition(user.getAccount());

        String content="已收到"+emodel.getTotal()+"条企业员工申请,"+emodel.getUnExamine()+"条仍未审批.";

        return content;
    }

    @ServiceLog(doAction = "机构邀请")
    @Override
    public String findOrganizationInvitation(User user) {
        return null;
    }

    @ServiceLog(doAction = "顾问管理")
    @Override
    public String findAdviserInvitation(User user) {
        return null;
    }

    @ServiceLog(doAction = "需求管理")
    @Override
    public String findRequirementManage(User user) {
        // 企业用户是提交   机构用户是接到
        //判断当前账号是否是企业用户或者是机构用户
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(user.getAccount());
        if(userExtension==null || userExtension.getData()==null){
            logger.warn("我收到的需求列表查询根据账号获取用户信息失败");
            throw new JnSpringCloudException(UserCenterExceptionEnum.NETWORK_ANOMALY);
        }
        //机构
        String affiliateCode= userExtension.getData().getAffiliateCode();
        //企业
        String companyCode= userExtension.getData().getCompanyCode();
        //都为空时不能查看
        if(StringUtils.isBlank(affiliateCode) && StringUtils.isBlank(companyCode)){
            throw new JnSpringCloudException(UserCenterExceptionEnum.IS_ENTERPRISE_OR_ORGANIZATION_USER_NOT_LOOK_1);
        }

        //如果机构编码不为空则查询接到的需求
        if(!StringUtils.isBlank(affiliateCode)){
            RequirementManageModel rModel=userCenterIndexDao.findRequirementManage("0",user.getAccount());
        }
        //如果企业编码不为空再
        if(!StringUtils.isBlank(companyCode)){
            RequirementManageModel rModel=userCenterIndexDao.findRequirementManage("1",user.getAccount());
        }

        return null;
    }

    @ServiceLog(doAction = "评价管理")
    @Override
    public String findEvaluateManage(User user) {
        return null;
    }

    @ServiceLog(doAction = "活动管理")
    @Override
    public String findActivityManage(User user) {
        return null;
    }

    @ServiceLog(doAction = "数据上报")
    @Override
    public String findReportedData(User user) {
        return null;
    }
}
