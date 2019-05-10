package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.api.MessageClient;
import com.jn.park.message.service.MessageListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: tangry
 * @Date: 2019/4/22
 * @Version 1.0
 */

@RestController
public class MessageServiceController extends BaseController implements MessageClient{


    @Autowired
    private MessageListService messageListService;

    /*@Override
    public Result addMessage(addMessageModel addMessageModel) {
        messageListService.addMessage(addMessageModel);
        return new Result();
    }*/


}
