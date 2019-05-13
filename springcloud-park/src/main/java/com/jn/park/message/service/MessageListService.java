package com.jn.park.message.service;

import com.jn.park.message.model.AddMessageModel;
import com.jn.park.message.model.FindAllMessageListVo;
import com.jn.park.message.model.MessageListModel;
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
    List<FindAllMessageListVo> findAll(Integer messageOneTort,Integer messageTowTort,Integer isRead, User user);


    /**
     * 添加消息
     * @param addMessageModel
     */
    void addMessage(AddMessageModel addMessageModel);


    /**
     * 根据ID查询单个消息
     * @param id
     * @return
     */
    MessageListModel findByMessage(String id);


    /**
     * 修改消息
     * @param messageListModel
     */
    void  updateMessage(MessageListModel messageListModel);

    /**
     * 删除消息
     * @param id
     */
    void deleteMessage(String id);

    /**
     * 修改已读状态
     * @param id
     */
    void updateIsReadStatus(String id);
}
