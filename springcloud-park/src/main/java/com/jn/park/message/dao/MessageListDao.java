package com.jn.park.message.dao;

import com.jn.park.message.model.*;
import com.jn.system.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: tangry
 * @Date: 2019/4/19
 * @Version 1.0
 */
public interface MessageListDao {


    List<MessageListModel> findAllList(@Param("messageOneSort") String messageOneSort,@Param("isRead") String isRead,@Param("account")  String account);

    List<MessageTowListModel> getMessageOneTort(@Param("account") String account, @Param("messageOneTort") String messageOneTort);


    List<MessageListModel> findAllApp(@Param("messageOneSort") String messageOneSort,@Param("isRead") Integer isRead, @Param("account") String account);


    /**
     * 查询所有消息
     * @param
     * @return
     */
    List<MessageListModel> findAll(@Param("messageTowTort") String messageTowTort,@Param("isRead") Integer isRead, @Param("account") String account);

    /**
     * 获取是否有已读消息
     * @return
     */
    int getIsRead(@Param("messageOneTort") String messageOneTort,@Param("messageTowTort") String messageTowTort,@Param("account") String account);


    /**
     * 添加消息
     * @param addMessageModel
     */
    int addMessage(AddMessageModel addMessageModel);


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
