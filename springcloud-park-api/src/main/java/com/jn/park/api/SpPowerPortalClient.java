package com.jn.park.api;

import com.jn.common.model.Result;
import com.jn.park.spPower.model.SpAdModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 行政审批客户端
 * @Author: huxw
 * @Date: 2019-4-16 10:07:51
 * @Version v1.0
 * @modified By:
 */
@FeignClient("springcloud-park")
public interface SpPowerPortalClient {

    /**
     * 获取行政审批轮播图
     * @return
     */
    @RequestMapping(value = "/api/sp/power/getAdvertising", method = RequestMethod.POST)
    Result<List<SpAdModel>> getAdvertising();

}
