package com.jn.enterprise.servicemarket.advisor.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorManagementParam;
import com.jn.enterprise.servicemarket.advisor.model.ApprovalParam;
import com.jn.enterprise.servicemarket.advisor.model.InviteAdvisorInfo;

/**
 * 顾问管理
 * @Author: yangph
 * @Date: 2019/2/19 16:17
 * @Version v1.0
 * @modified By:
 */
public interface AdvisorManagementService {
    /**
     * 邀请顾问
     * @param inviteAdvisorInfo  邀请顾问入参（被邀请人和邀请人账号）
     */
    void inviteAdvisor(InviteAdvisorInfo inviteAdvisorInfo);

    /**
     * 顾问管理
     * @param advisorManagementParam  顾问管理查询页面入参（顾问姓名，审批状态）
     * @return
     */
    PaginationData getAdvisorManagementInfo(AdvisorManagementParam advisorManagementParam);

    /**
     * 审批顾问填写信息
     * @param approvalParam  审批顾问信息入参(顾问账号，审批结果，审批说明)
     */
    void approvalAdvisorInfo(ApprovalParam approvalParam);
}
