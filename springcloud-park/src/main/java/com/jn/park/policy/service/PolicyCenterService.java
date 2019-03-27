package com.jn.park.policy.service;

import com.jn.common.model.PaginationData;
import com.jn.park.policy.model.PolicyCenterHomeParam;
import com.jn.park.policy.model.PolicyClassShow;
import com.jn.park.policy.model.PolicyLevelShow;

import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/3/27 14:06
 * @Version v1.0
 * @modified By:
 */
public interface PolicyCenterService {
    /**
     * 政策级别列表
     * @return
     */
    List<PolicyLevelShow> getPolicyLevelList();

    /**
     * 政策分类列表
     * @return
     */
    List<PolicyClassShow>getPolicyClassList();

    /**
     * 政策中心首页
     * @param policyCenterHomeParam
     * @return
     */
    PaginationData getPolicyCenterList(PolicyCenterHomeParam policyCenterHomeParam);
}
