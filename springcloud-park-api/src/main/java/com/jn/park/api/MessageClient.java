package com.jn.park.api;

import com.jn.common.model.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: tangry
 * @Date: 2019/4/22
 * @Version 1.0
 */

@FeignClient("springcloud-park")
public interface MessageClient {

    /**
     * 修改用户角色信息
     *
     * @param addMessageModel
     * @return
     */
    //@RequestMapping(value = "/api/message/addMessage", method = RequestMethod.POST)
    //Result<String> addMessage(@RequestBody addMessageModel addMessageModel);

}
