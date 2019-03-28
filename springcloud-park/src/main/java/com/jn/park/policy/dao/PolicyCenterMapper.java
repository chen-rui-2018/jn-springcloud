package com.jn.park.policy.dao;

import com.jn.park.policy.model.PolicyCenterHomeParam;
import com.jn.park.policy.model.PolicyCenterHomeShow;
import com.jn.park.policy.model.PolicyDetailsShow;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/3/27 19:31
 * @Version v1.0
 * @modified By:
 */
@Repository
public interface PolicyCenterMapper {
    /**
     * 政策中心首页--政策一览
     * @param policyCenterHomeParam
     * @param thematicType  专题类型
     * @return
     */
    List<PolicyCenterHomeShow> getPolicyCenterList(@Param("policyCenterHomeParam")PolicyCenterHomeParam policyCenterHomeParam, @Param("thematicType") String thematicType);

    /**
     * 政策指南详情
     * @param policyId 政策id
     * @return
     */
    PolicyDetailsShow getPolicyDetails(@Param("policyId") String policyId);

}
