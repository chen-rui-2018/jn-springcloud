package com.jn.park.message.service;

import com.jn.common.model.PaginationData;
import com.jn.park.message.model.*;
import com.jn.system.model.User;

import java.util.List;

/**
 * @Author: tangry
 * @Date: 2019/4/19
 * @Version 1.0
 */
public interface MessageListService {


    /**
     * 获取二级消息类别
     * @param messageOneTort 一级消息类别
     * @return
     */
    List<MessageTowListModel> getMessageOneTort(String messageOneTort,User user);


    PaginationData<List<MessageListModel>> findAllApp(findAllAppMessageListModel findAllAppMessageListModel, User user);

    /**
     * 查询所有消息
     * @param findAllMessageListModel
     * @return
     */
    PaginationData<List<MessageListModel>> findAll(findAllMessageListModel findAllMessageListModel, User user);

    /**
     * 获取是否有已读消息
     * @return
     */
    int getIsRead(String messageOneTort,String messageTowTort,User user);

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
