package com.jn.enterprise.servicemarket.advisor.service;

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
}
