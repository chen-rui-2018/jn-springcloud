package com.jn.enterprise.servicemarket.org.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.model.OrgColleagueQuery;

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
}
