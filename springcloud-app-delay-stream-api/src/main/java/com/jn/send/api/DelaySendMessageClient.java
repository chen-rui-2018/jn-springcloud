package com.jn.send.api;

import com.jn.common.model.Result;
import com.jn.send.model.Delay;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 延迟发送API
 *
 * @author： fengxh
 * @date： Created on 2019/1/7 17:42
 * @version： v1.0
 * @modified By:
 */
@FeignClient("springcloud-app-delay-stream")
public interface DelaySendMessageClient {

    /**
     * 延迟发送API
     * @param var
     * @return
     */
    @RequestMapping(value = "/api/delay/send", method = RequestMethod.POST)
    Result<Boolean> delaySend(@RequestBody Delay var);


}
