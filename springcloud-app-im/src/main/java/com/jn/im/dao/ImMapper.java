package com.jn.im.dao;

import com.jn.im.entity.TbImMessage;
import com.jn.im.model.Message;

import java.util.List;

/**
 * IM ImMapper
 *
 * @author： shenph
 * @date： Created on 2019/5/10 21:34
 * @version： v1.0
 * @modified By:
 */
public interface ImMapper {

    /**
     * 查询聊天记录
     *
     * @param message
     * @return
     */
    List<TbImMessage> selectMsg(Message message);

    /**
     * 根据用户查找离线未读消息，根据发送人分组
     *
     * @param userId
     * @return
     */
    List selectOffLineUser(String userId);

    /**
     * 根据用户查找离线未读消息
     *
     * @param userId
     * @param sendId
     * @return
     */
    List<TbImMessage> selectOffLineMsg(String userId, String sendId);

    /**
     * 查询聊天列表
     *
     * @param message
     * @return
     */
    List<TbImMessage> selectMsgList(Message message);
}
