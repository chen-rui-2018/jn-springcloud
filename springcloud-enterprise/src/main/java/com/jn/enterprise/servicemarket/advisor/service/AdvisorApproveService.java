package com.jn.enterprise.servicemarket.advisor.service;

import com.jn.enterprise.servicemarket.advisor.model.OrgInfoShow;

import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/4/9 9:51
 * @Version v1.0
 * @modified By:
 */
public interface AdvisorApproveService {
    /**
     * 选择机构
     * @param orgName 机构名称
     * @return
     */
    List<OrgInfoShow> selectOrgInfo(String orgName);
}
