package com.jn.enterprise.usercenterindex.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.RequireExceptionEnum;
import com.jn.enterprise.servicemarket.require.dao.RequireManagementMapper;
import com.jn.enterprise.servicemarket.require.model.RequireOtherParam;
import com.jn.enterprise.servicemarket.require.model.RequireReceivedParam;
import com.jn.enterprise.servicemarket.require.service.RequireManagementService;
import com.jn.enterprise.usercenterindex.controller.UserCenterIndexController;
import com.jn.enterprise.usercenterindex.dao.UserCenterIndexDao;
import com.jn.enterprise.usercenterindex.enums.UserCenterExceptionEnum;
import com.jn.enterprise.usercenterindex.model.ActivityListApply;
import com.jn.enterprise.usercenterindex.model.EmployeeRequisitionModel;
import com.jn.enterprise.usercenterindex.model.RequirementManageModel;
import com.jn.enterprise.usercenterindex.service.UserCenterIndexService;
import com.jn.park.activity.model.ActivityApplyListParam;
import com.jn.park.api.ActivityClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    @Autowired
    private RequireManagementService getRequireReceivedList;

    @Autowired
    private ActivityClient activityClient;

    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(UserCenterIndexServiceImpl.class);

    private static String str;



    @ServiceLog(doAction = "员工申请")
    @Override
    public String findEmployeeRequisition(User user) {
        //判断当前账号是否是企业用户或者是机构用户
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(user.getAccount());
        if(userExtension==null || userExtension.getData()==null){
            throw new JnSpringCloudException(UserCenterExceptionEnum.NETWORK_ANOMALY);
        }
        /*//获取机构code 和 企业code 判断是否是企业用户或者是机构用户
        String affiliateCode= userExtension.getData().getAffiliateCode();
        String companyCode= userExtension.getData().getCompanyCode();

        if(StringUtils.isBlank(affiliateCode) && StringUtils.isBlank(companyCode)){
            throw new JnSpringCloudException(UserCenterExceptionEnum.IS_ENTERPRISE_OR_ORGANIZATION_USER_NOT_LOOK);
        }*/

        //查询
        EmployeeRequisitionModel emodel=userCenterIndexDao.findEmployeeRequisition(userExtension.getData().getCompanyCode());

        String content="已收到"+emodel.getTotal()+"条企业员工申请,"+emodel.getUnExamine()+"条仍未审批.";
        //都为空 则返回空
        /*StringUtils.isBlank(emodel.getTotal()) && StringUtils.isBlank(emodel.getUnExamine())*/
        if(StringUtils.isBlank(emodel.getUnExamine()) || ("0").equals(emodel.getUnExamine()) ){
            content="";
        }

        return content;
    }



    @ServiceLog(doAction = "顾问管理")
    @Override
    public String findAdviserInvitation(User user) {
        // 企业用户是提交   机构用户是接到
        //判断当前账号是否是企业用户或者是机构用户
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(user.getAccount());
        if(userExtension==null || userExtension.getData()==null){
            throw new JnSpringCloudException(UserCenterExceptionEnum.NETWORK_ANOMALY);
        }
        //机构编码
        String affiliateCode= userExtension.getData().getAffiliateCode();
        /*if(StringUtils.isBlank(affiliateCode)){
            throw new JnSpringCloudException(UserCenterExceptionEnum.IS_ENTERPRISE_OR_ORGANIZATION_USER_NOT_LOOK_2);
        }*/

        //获取机构下的所有信息
        String s=userCenterIndexDao.findAdviserInvitation("",affiliateCode);
        //查询机构下未审批的信息
        String s1=userCenterIndexDao.findAdviserInvitation("1",affiliateCode);

        String str="已收到"+s+"条顾问邀请的回馈,"+s1+"条仍未审批。";

        if(StringUtils.isBlank(s) && StringUtils.isBlank(s1)){
            str="";
        }
        if(("0").equals(s) && ("0").equals(s1)){
            str="";
        }

        return str;
    }

    @ServiceLog(doAction = "需求管理")
    @Override
    public String findRequirementManage(User user) {
        // 企业用户是提交   机构用户是接到
        //判断当前账号是否是企业用户或者是机构用户
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(user.getAccount());
        if(userExtension==null || userExtension.getData()==null){
            throw new JnSpringCloudException(UserCenterExceptionEnum.NETWORK_ANOMALY);
        }
        //机构
        String affiliateCode= userExtension.getData().getAffiliateCode();
        //企业
        String companyCode= userExtension.getData().getCompanyCode();
        //都为空时不能查看
        /*if(StringUtils.isBlank(affiliateCode) && StringUtils.isBlank(companyCode)){
            throw new JnSpringCloudException(UserCenterExceptionEnum.IS_ENTERPRISE_OR_ORGANIZATION_USER_NOT_LOOK_1);
        }*/

        String str="";

        //如果机构编码不为空则查询接到的需求
        if(StringUtils.isNotBlank(affiliateCode)){
            //我收到的需求
            RequireReceivedParam requireReceivedParam=new RequireReceivedParam();
            requireReceivedParam.setNeedPage("1");
            //获取全部的需求数
            PaginationData requireReceivedList = getRequireReceivedList.getRequireReceivedList(requireReceivedParam, user.getAccount());
            long s=requireReceivedList.getTotal();
            //获取未处理的条数
            requireReceivedParam.setDataStatus("1");
            PaginationData requireReceivedList1 = getRequireReceivedList.getRequireReceivedList(requireReceivedParam, user.getAccount());
            long s1=requireReceivedList1.getTotal();
            str="已接到"+s+"条服务需求,"+s1+"条仍未处理";
            if(StringUtils.isBlank(Long.toString(s)) && StringUtils.isBlank(Long.toString(s1))){
                str="";
            }
            if(("0").equals(Long.toString(s)) && ("0").equals(Long.toString(s1))){
                str="";
            }
        }
        //如果企业编码不为空则查询提交的需求
        if(StringUtils.isNotBlank(companyCode)){
            //对他人的需求
            RequireOtherParam requireOtherParam=new RequireOtherParam();
            requireOtherParam.setNeedPage("1");
            PaginationData requireOtherList = getRequireReceivedList.getRequireOtherList(requireOtherParam, user.getAccount());
            long s=requireOtherList.getTotal();
            requireOtherParam.setDataStatus("1");
            PaginationData requireOtherList1 = getRequireReceivedList.getRequireOtherList(requireOtherParam, user.getAccount());
            long s1=requireOtherList1.getTotal();
            str="已提交"+s+"条服务需求,"+s1+"条仍在处理中";
            if(StringUtils.isBlank(Long.toString(s)) && StringUtils.isBlank(Long.toString(s1))){
                str="";
            }
            if(("0").equals(Long.toString(s)) && ("0").equals(Long.toString(s1))){
                str="";
            }
        }
        //测试代码
        /*if(status.equals("0")){
            //我收到的需求
            RequireReceivedParam requireReceivedParam=new RequireReceivedParam();
            requireReceivedParam.setNeedPage("1");
            //获取全部的需求数
            PaginationData requireReceivedList = getRequireReceivedList.getRequireReceivedList(requireReceivedParam, user.getAccount());
            long s=requireReceivedList.getTotal();
            //获取未处理的条数
            requireReceivedParam.setDataStatus("1");
            PaginationData requireReceivedList1 = getRequireReceivedList.getRequireReceivedList(requireReceivedParam, user.getAccount());
            long s1=requireReceivedList1.getTotal();
            logger.info("=========================>:{}",requireReceivedList,requireReceivedList1);

        }
        if(status.equals("1")){
            //对他人的需求
            RequireOtherParam requireOtherParam=new RequireOtherParam();
            requireOtherParam.setNeedPage("1");
            PaginationData requireOtherList = getRequireReceivedList.getRequireOtherList(requireOtherParam, user.getAccount());
            long s=requireOtherList.getTotal();
            requireOtherParam.setDataStatus("1");
            PaginationData requireOtherList1 = getRequireReceivedList.getRequireOtherList(requireOtherParam, user.getAccount());
            long s1=requireOtherList1.getTotal();
            logger.info("=========================>:{}",requireOtherList);
        }*/

        return str;
    }

    @ServiceLog(doAction = "评价管理")
    @Override
    public String findEvaluateManage(User user) {
        // 企业用户是提交   机构用户是接到
        //判断当前账号是否是企业用户或者是机构用户
        /*Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(user.getAccount());
        if(userExtension==null || userExtension.getData()==null){
            throw new JnSpringCloudException(UserCenterExceptionEnum.NETWORK_ANOMALY);
        }*/
        //企业
        //String companyCode= userExtension.getData().getCompanyCode();

        //为空时不能查看
        /*if(StringUtils.isBlank(companyCode)){
            throw new JnSpringCloudException(UserCenterExceptionEnum.IS_ENTERPRISE_USER_NOT_LOOK);
        }*/

        RequireOtherParam requireOtherParam=new RequireOtherParam();
        requireOtherParam.setNeedPage("1");
        //总条数
        PaginationData requireOtherList = getRequireReceivedList.getRequireOtherList(requireOtherParam, user.getAccount());
        long s=requireOtherList.getTotal();
        //待评价的条数
        requireOtherParam.setDataStatus("2");
        PaginationData requireOtherList1 = getRequireReceivedList.getRequireOtherList(requireOtherParam, user.getAccount());
        long s1=requireOtherList1.getTotal();
        String str="已完成"+s+"笔交易,"+s1+"笔仍未评价";
        if(StringUtils.isBlank(Long.toString(s)) && StringUtils.isBlank(Long.toString(s1))){
            str="";
        }

        if(("0").equals(Long.toString(s)) && ("0").equals(Long.toString(s1))){
            str="";
        }

        return str;
    }

    @ServiceLog(doAction = "活动管理")
    @Override
    public String findActivityManage(User user) {
        ActivityApplyListParam activityApplyListParam=new ActivityApplyListParam();
        activityApplyListParam.setAccount(user.getAccount());
        activityApplyListParam.setApplyStatus("1");
        //获取有效活动总数
        Result<PaginationData> activitySuccessfulRegistration = activityClient.findActivitySuccessfulRegistration(activityApplyListParam, true);

        long s=activitySuccessfulRegistration.getData().getTotal();

        List<Object> rows = (List<Object>)activitySuccessfulRegistration.getData().getRows();
        List<ActivityListApply> activityListApplies = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        for (Object obj : rows) {
            activityListApplies.add(objectMapper.convertValue(obj, ActivityListApply.class));
        }
        int j=0;
        for(int i=0;i < activityListApplies.size();i++){
            ActivityListApply activityListApply1=new ActivityListApply();
            activityListApply1 =activityListApplies.get(i);
            if(activityListApply1.getActiStatus().equals("2")){
                j=j+1;
            }
        }

        String str="已报名"+s+"项活动,其中"+j+"项仍未结束。";
        if(StringUtils.isBlank(Long.toString(s)) && StringUtils.isBlank(String.valueOf(j))){
            str="";
        }

        if(("0").equals(Long.toString(s)) && ("0").equals(Long.toString(j))){
            str="";
        }

        return str;
    }

    @ServiceLog(doAction = "数据上报")
    @Override
    public String findReportedData(User user) {
        return null;
    }
}
