package com.jn.enterprise.servicemarket.org.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.org.model.OrgColleagueQuery;

/**
 * 机构同事
 * @Author: yangph
 * @Date: 2019/2/26 10:10
 * @Version v1.0
 * @modified By:
 */
public interface OrgColleagueService {
    /**
     * 机构同事列表查询
     * @param account  当前登录用户账号
     * @param orgColleagueQuery 机构同事列表查询入参（是否分页）
     * @return
     */
    PaginationData getOrgColleagueList(String account, OrgColleagueQuery orgColleagueQuery);

    /**
     * 设置为联系人
     * @param account 设置为联系人的账号
     */
    void setAsContact(String account);

    /**
     * 取消联系人
     * @param account 取消联系人的账号
     */
    void cancelAsContact(String account);

    /**
     * 删除联系人或顾问
     * @param loginAccount 登录用户账号
     * @param account 删除联系人或顾问的账号
     */
    void deleteContactOrAdvisor(String loginAccount,String account);
}
