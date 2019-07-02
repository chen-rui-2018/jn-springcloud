package com.jn.enterprise.servicemarket.advisor.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorManagementParam;
import com.jn.enterprise.servicemarket.advisor.model.ApprovalParam;

/**
 * 专员管理
 * @Author: yangph
 * @Date: 2019/2/19 16:17
 * @Version v1.0
 * @modified By:
 */
public interface AdvisorManagementService {
    /**
     * 邀请专员
     * @param registerAccount   被邀请人手机号或邮箱
     * @param loginAccount      当前登录用户账号
     * @return
     */
    int inviteAdvisor(String registerAccount,String loginAccount);

    /**
     * 专员管理
     * @param advisorManagementParam  专员管理查询页面入参（专员姓名，审批状态）
     * @param loginAccount 当前登录用户账号
     * @return
     */
    PaginationData getAdvisorManagementInfo(AdvisorManagementParam advisorManagementParam,String loginAccount);

    /**
     * 审批专员填写信息
     * @param approvalParam  审批专员信息入参(专员账号，审批结果，审批说明)
     */
    int approvalAdvisorInfo(ApprovalParam approvalParam);

    /**
     * 再次邀请
     * @param advisorAccount 专员账号
     * @param loginAccount  当前登录用户
     * @return
     */
    int inviteAgain(String advisorAccount,String loginAccount);
}
