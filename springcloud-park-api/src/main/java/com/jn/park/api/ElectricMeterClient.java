package com.jn.park.api;

import com.jn.common.model.Result;
import com.jn.park.message.model.AddMessageModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author： yangh
 * @date： Created on 2019/5/18 13:00
 * @version： v1.0
 * @modified By:
 */
@FeignClient("springcloud-park")
public interface ElectricMeterClient {
    @RequestMapping(value = "/api/meter/getDataFromHardare", method = RequestMethod.GET)
    void getDataFromHardare();
}
