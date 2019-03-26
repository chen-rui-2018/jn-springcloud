package com.jn.enterprise.servicemarket.advisor.service;

/**
 * 接受机构邀请
 * @Author: yangph
 * @Date: 2019/2/25 14:58
 * @Version v1.0
 * @modified By:
 */
public interface AcceptOrgInvitationService {
    /**
     * 接受机构邀请
     * @param advisorAccount 顾问账号
     */
    int acceptOrgInvitation(String advisorAccount);

    /**
     * 拒绝机构邀请
     * @param advisorAccount  顾问账号
     */
    int refuseInvitation(String advisorAccount);
}
