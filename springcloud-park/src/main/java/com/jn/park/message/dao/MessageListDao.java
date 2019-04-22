package com.jn.park.message.dao;

import com.jn.park.message.model.FindAllMessageListVo;
import com.jn.park.message.model.addMessageModel;
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
    void addMessage(addMessageModel addMessageModel);
}
