package com.jn.park.message.dao;

import com.jn.park.message.model.FindAllMessageListVo;
import com.jn.park.message.model.MessageListModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: tangry
 * @Date: 2019/4/19
 * @Version 1.0
 */
public interface MessageListDao {

    /**
     * 查询所有消息
     * @param messageTowTort 一级消息类别
     * @return
     */
    List<FindAllMessageListVo> findAll(@Param("messageTowTort") Integer messageTowTort, @Param("account") String account);

    /**
     * 添加消息
     * @param addMessageModel
     */
    //void addMessage(addMessageModel addMessageModel);


    /**
     * 根据ID查询单个消息
     * @param id
     * @return
     */
    MessageListModel findByMessage(@Param("id") String id);


    /**
     * 修改消息
     * @param messageListModel
     */
    void  updateMessage(MessageListModel messageListModel);

    /**
     * 删除消息
     * @param id
     */
    void deleteMessage(@Param("id") String id);


    /**
     * 修改已读状态
     * @param id
     */
    void updateIsReadStatus(@Param("id") String id);
}
