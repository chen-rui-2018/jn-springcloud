package com.jn.park.api;

import com.jn.common.model.Result;
import com.jn.park.message.model.AddMessageModel;
import com.jn.park.message.model.MessageListModel;
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
     * 添加消息
     *
     * @param addMessageModel
     * @return
     */
    @RequestMapping(value = "/api/message/addMessage", method = RequestMethod.POST)
    Result<String> addMessage(@RequestBody AddMessageModel addMessageModel);


    /**
     * 根据ID查询当个消息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/api/message/findByMessage", method = RequestMethod.POST)
    Result<MessageListModel> findByMessage(@RequestBody String id);


}
