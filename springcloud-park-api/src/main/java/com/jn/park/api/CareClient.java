package com.jn.park.api;

import com.jn.common.model.Result;
import com.jn.park.care.model.CareParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 点评
 * @author： jiangyl
 * @date： Created on 2019/4/25 15:30
 * @version： v1.0
 * @modified By:
 */
@FeignClient("springcloud-park")
public interface CareClient {

    /**
     * 获取评论信息
     * @param careParam
     * @return
     */
    @RequestMapping(value = "/api/care/findCompanyCareInfo", method = RequestMethod.POST)
    Result findCompanyCareInfo(@RequestBody CareParam careParam);

}
