package com.jn.park.message.service;

import com.jn.park.message.model.FindAllMessageListVo;
import com.jn.park.message.model.addMessageModel;
import com.jn.system.model.User;

import java.util.List;

/**
 * @Author: tangry
 * @Date: 2019/4/19
 * @Version 1.0
 */
public interface MessageListService {

    /**
     * 查询所有消息
     * @param messageTowTort 一级消息类别
     * @return
     */
    List<FindAllMessageListVo> findAll(Integer messageTowTort, User user);


    /**
     * 添加消息
     * @param addMessageModel
     */
    void addMessage(addMessageModel addMessageModel);
}
