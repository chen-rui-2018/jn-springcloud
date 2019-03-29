package com.jn.park.policy.dao;

import com.jn.park.policy.model.PolicyInfoShow;
import com.jn.park.policy.model.PolicyManagementParam;
import com.jn.park.policy.model.PolicyManagementShow;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/3/29 11:37
 * @Version v1.0
 * @modified By:
 */
@Repository
public interface PolicyGuideMapper {
    /**
     * 政策管理
     * @param policyManagementParam
     * @return
     */
    List<PolicyManagementShow> getPolicyManagementList(PolicyManagementParam policyManagementParam);

    /**
     * 关联图解政策信息/关联政策原文信息
     * @param policyType
     * @return
     */
    List<PolicyInfoShow> getPolicyInfo(String policyType);
}
