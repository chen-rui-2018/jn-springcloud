package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.api.MessageClient;
<<<<<<< HEAD
import com.jn.park.message.model.addMessageModel;
import com.jn.park.message.service.MessageListService;
=======
import com.jn.park.message.model.AddMessageModel;
import com.jn.park.message.service.MessageListService;
import com.jn.system.model.User;
import org.apache.shiro.SecurityUtils;
>>>>>>> origin/develop-jn
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    protected User getUser(){
        return  (User) SecurityUtils.getSubject().getPrincipal();
    }


    @Override
<<<<<<< HEAD
    public Result addMessage(@RequestBody  addMessageModel addMessageModel) {
        messageListService.addMessage(addMessageModel);
=======
    public Result addMessage(AddMessageModel addMessageModel) {
        messageListService.addMessage(addMessageModel,getUser());
>>>>>>> origin/develop-jn
        return new Result();
    }


}
