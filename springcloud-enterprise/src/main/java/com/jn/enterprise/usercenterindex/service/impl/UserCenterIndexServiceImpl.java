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
     * ????????????
     */
    private static Logger logger = LoggerFactory.getLogger(UserCenterIndexServiceImpl.class);

    private static String str;



    @ServiceLog(doAction = "????????????")
    @Override
    public String findEmployeeRequisition(User user) {
        //????????????????????????????????????????????????????????????
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(user.getAccount());
        if(userExtension==null || userExtension.getData()==null){
            throw new JnSpringCloudException(UserCenterExceptionEnum.NETWORK_ANOMALY);
        }
        /*//????????????code ??? ??????code ????????????????????????????????????????????????
        String affiliateCode= userExtension.getData().getAffiliateCode();
        String companyCode= userExtension.getData().getCompanyCode();

        if(StringUtils.isBlank(affiliateCode) && StringUtils.isBlank(companyCode)){
            throw new JnSpringCloudException(UserCenterExceptionEnum.IS_ENTERPRISE_OR_ORGANIZATION_USER_NOT_LOOK);
        }*/

        //??????
        EmployeeRequisitionModel emodel=userCenterIndexDao.findEmployeeRequisition(userExtension.getData().getCompanyCode());

        String content="?????????"+emodel.getTotal()+"?????????????????????,"+emodel.getUnExamine()+"???????????????.";
        //????????? ????????????
        /*StringUtils.isBlank(emodel.getTotal()) && StringUtils.isBlank(emodel.getUnExamine())*/
        if(StringUtils.isBlank(emodel.getUnExamine()) || ("0").equals(emodel.getUnExamine()) ){
            content="";
        }

        return content;
    }



    @ServiceLog(doAction = "????????????")
    @Override
    public String findAdviserInvitation(User user) {
        // ?????????????????????   ?????????????????????
        //????????????????????????????????????????????????????????????
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(user.getAccount());
        if(userExtension==null || userExtension.getData()==null){
            throw new JnSpringCloudException(UserCenterExceptionEnum.NETWORK_ANOMALY);
        }
        //????????????
        String affiliateCode= userExtension.getData().getAffiliateCode();
        /*if(StringUtils.isBlank(affiliateCode)){
            throw new JnSpringCloudException(UserCenterExceptionEnum.IS_ENTERPRISE_OR_ORGANIZATION_USER_NOT_LOOK_2);
        }*/

        //??????????????????????????????
        String s=userCenterIndexDao.findAdviserInvitation("",affiliateCode);
        //?????????????????????????????????
        String s1=userCenterIndexDao.findAdviserInvitation("1",affiliateCode);

        String str="?????????"+s+"????????????????????????,"+s1+"??????????????????";

        if(StringUtils.isBlank(s) && StringUtils.isBlank(s1)){
            str="";
        }
        if(("0").equals(s) && ("0").equals(s1)){
            str="";
        }

        return str;
    }

    @ServiceLog(doAction = "????????????")
    @Override
    public String findRequirementManage(User user) {
        // ?????????????????????   ?????????????????????
        //????????????????????????????????????????????????????????????
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(user.getAccount());
        if(userExtension==null || userExtension.getData()==null){
            throw new JnSpringCloudException(UserCenterExceptionEnum.NETWORK_ANOMALY);
        }
        //??????
        String affiliateCode= userExtension.getData().getAffiliateCode();
        //??????
        String companyCode= userExtension.getData().getCompanyCode();
        //????????????????????????
        /*if(StringUtils.isBlank(affiliateCode) && StringUtils.isBlank(companyCode)){
            throw new JnSpringCloudException(UserCenterExceptionEnum.IS_ENTERPRISE_OR_ORGANIZATION_USER_NOT_LOOK_1);
        }*/

        String str="";

        //???????????????????????????????????????????????????
        if(StringUtils.isNotBlank(affiliateCode)){
            //??????????????????
            RequireReceivedParam requireReceivedParam=new RequireReceivedParam();
            requireReceivedParam.setNeedPage("1");
            //????????????????????????
            PaginationData requireReceivedList = getRequireReceivedList.getRequireReceivedList(requireReceivedParam, user.getAccount());
            long s=requireReceivedList.getTotal();
            //????????????????????????
            requireReceivedParam.setDataStatus("1");
            PaginationData requireReceivedList1 = getRequireReceivedList.getRequireReceivedList(requireReceivedParam, user.getAccount());
            long s1=requireReceivedList1.getTotal();
            str="?????????"+s+"???????????????,"+s1+"???????????????";
            if(StringUtils.isBlank(Long.toString(s)) && StringUtils.isBlank(Long.toString(s1))){
                str="";
            }
            if(("0").equals(Long.toString(s)) && ("0").equals(Long.toString(s1))){
                str="";
            }
        }
        //???????????????????????????????????????????????????
        if(StringUtils.isNotBlank(companyCode)){
            //??????????????????
            RequireOtherParam requireOtherParam=new RequireOtherParam();
            requireOtherParam.setNeedPage("1");
            PaginationData requireOtherList = getRequireReceivedList.getRequireOtherList(requireOtherParam, user.getAccount());
            long s=requireOtherList.getTotal();
            requireOtherParam.setDataStatus("1");
            PaginationData requireOtherList1 = getRequireReceivedList.getRequireOtherList(requireOtherParam, user.getAccount());
            long s1=requireOtherList1.getTotal();
            str="?????????"+s+"???????????????,"+s1+"??????????????????";
            if(StringUtils.isBlank(Long.toString(s)) && StringUtils.isBlank(Long.toString(s1))){
                str="";
            }
            if(("0").equals(Long.toString(s)) && ("0").equals(Long.toString(s1))){
                str="";
            }
        }
        //????????????
        /*if(status.equals("0")){
            //??????????????????
            RequireReceivedParam requireReceivedParam=new RequireReceivedParam();
            requireReceivedParam.setNeedPage("1");
            //????????????????????????
            PaginationData requireReceivedList = getRequireReceivedList.getRequireReceivedList(requireReceivedParam, user.getAccount());
            long s=requireReceivedList.getTotal();
            //????????????????????????
            requireReceivedParam.setDataStatus("1");
            PaginationData requireReceivedList1 = getRequireReceivedList.getRequireReceivedList(requireReceivedParam, user.getAccount());
            long s1=requireReceivedList1.getTotal();
            logger.info("=========================>:{}",requireReceivedList,requireReceivedList1);

        }
        if(status.equals("1")){
            //??????????????????
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

    @ServiceLog(doAction = "????????????")
    @Override
    public String findEvaluateManage(User user) {
        // ?????????????????????   ?????????????????????
        //????????????????????????????????????????????????????????????
        /*Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(user.getAccount());
        if(userExtension==null || userExtension.getData()==null){
            throw new JnSpringCloudException(UserCenterExceptionEnum.NETWORK_ANOMALY);
        }*/
        //??????
        //String companyCode= userExtension.getData().getCompanyCode();

        //?????????????????????
        /*if(StringUtils.isBlank(companyCode)){
            throw new JnSpringCloudException(UserCenterExceptionEnum.IS_ENTERPRISE_USER_NOT_LOOK);
        }*/

        RequireOtherParam requireOtherParam=new RequireOtherParam();
        requireOtherParam.setNeedPage("1");
        //?????????
        PaginationData requireOtherList = getRequireReceivedList.getRequireOtherList(requireOtherParam, user.getAccount());
        long s=requireOtherList.getTotal();
        //??????????????????
        requireOtherParam.setDataStatus("2");
        PaginationData requireOtherList1 = getRequireReceivedList.getRequireOtherList(requireOtherParam, user.getAccount());
        long s1=requireOtherList1.getTotal();
        String str="?????????"+s+"?????????,"+s1+"???????????????";
        if(StringUtils.isBlank(Long.toString(s)) && StringUtils.isBlank(Long.toString(s1))){
            str="";
        }

        if(("0").equals(Long.toString(s)) && ("0").equals(Long.toString(s1))){
            str="";
        }

        return str;
    }

    @ServiceLog(doAction = "????????????")
    @Override
    public String findActivityManage(User user) {
        ActivityApplyListParam activityApplyListParam=new ActivityApplyListParam();
        activityApplyListParam.setAccount(user.getAccount());
        activityApplyListParam.setApplyStatus("1");
        //????????????????????????
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

        String str="?????????"+s+"?????????,??????"+j+"??????????????????";
        if(StringUtils.isBlank(Long.toString(s)) && StringUtils.isBlank(String.valueOf(j))){
            str="";
        }

        if(("0").equals(Long.toString(s)) && ("0").equals(Long.toString(j))){
            str="";
        }

        return str;
    }

    @ServiceLog(doAction = "????????????")
    @Override
    public String findReportedData(User user) {
        return null;
    }
}
