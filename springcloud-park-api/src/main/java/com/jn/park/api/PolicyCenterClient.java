package com.jn.park.api;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.policy.model.PolicyCenterHomeParam;
import com.jn.park.policy.model.PolicyCenterHomeShow;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 政策中心客户端
 * @Author: huxw
 * @Date: 2019-4-16 10:07:51
 * @Version v1.0
 * @modified By:
 */
@FeignClient("springcloud-park")
public interface PolicyCenterClient {

    /**
     * 获取政策中心首页列表
     * @param policyCenterHomeParam
     * @return
     */
    @RequestMapping(value = "/api/policy/getPolicyList", method = RequestMethod.POST)
    Result<PaginationData<List<PolicyCenterHomeShow>>> getPolicyList(@RequestBody @Validated PolicyCenterHomeParam policyCenterHomeParam);

}
