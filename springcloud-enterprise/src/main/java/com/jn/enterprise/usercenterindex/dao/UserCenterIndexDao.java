package com.jn.enterprise.usercenterindex.dao;

import com.jn.enterprise.usercenterindex.model.EmployeeRequisitionModel;
import com.jn.enterprise.usercenterindex.model.RequirementManageModel;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: tangry
 * @Date: 2019/5/13
 * @Version 1.0
 */
public interface UserCenterIndexDao {

    /**
     * 企业邀请
     * @param account
     * @return
     */
    String findBusinessInvitation(@Param("account") String account);

    /**
     * 员工申请
     * @param account
     * @return
     */
    EmployeeRequisitionModel findEmployeeRequisition(@Param("account") String account);


    RequirementManageModel findRequirementManage(@Param("status") String status,@Param("account") String account);

    /**
     *顾问管理
     * @param approvalStatus 审批状态
     * @param orgId 机构ID
     * @return
     */
    String findAdviserInvitation(@Param("approvalStatus") String approvalStatus,@Param("orgId") String orgId);
}
