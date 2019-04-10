package com.jn.enterprise.servicemarket.org.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.org.model.OrgColleagueParam;

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
     * @param orgColleagueParam 机构同事列表查询入参（是否分页）
     * @return
     */
    PaginationData getOrgColleagueList(String account, OrgColleagueParam orgColleagueParam);

    /**
     * 设置为联系人
     * @param account 设置为联系人的账号
     * @return
     */
    int setAsContact(String account);

    /**
     *
     */
    /**
     * 取消联系人
     * @param account 取消联系人的账号
     * @return
     */
    int cancelAsContact(String account);

    /**
     * 删除联系人或顾问
     * @param loginAccount 登录用户账号
     * @param accountList 删除联系人或顾问的账号
     * @return
     */
    int deleteContactOrAdvisor(String loginAccount,String[] accountList);
}
