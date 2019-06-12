package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.api.MessageClient;

import com.jn.park.message.model.MessageListModel;
import com.jn.park.message.service.MessageListService;

import com.jn.park.message.model.AddMessageModel;

import com.jn.system.model.User;
import org.apache.shiro.SecurityUtils;

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
    public Result addMessage(@RequestBody  AddMessageModel addMessageModel) {
        messageListService.addMessage(addMessageModel);
        return new Result();
    }

    @Override
    public Result<MessageListModel> findByMessage(String id) {
        MessageListModel byMessage = messageListService.findByMessage(id);
        return new Result(byMessage);
    }
}
