package com.jn.im.service;

import com.jn.common.model.PaginationData;
import com.jn.im.entity.TbImMessage;
import com.jn.im.model.Message;

import java.util.List;

/**
 * IM ImService
 *
 * @author： shenph
 * @date： Created on 2019/5/10 21:34
 * @version： v1.0
 * @modified By:
 */
public interface ImService {

    /**
     * 查询聊天记录
     *
     * @param message
     * @return
     */
    PaginationData<List<TbImMessage>> selectMsg(Message message);

    /**
     * 消息设置已读
     *
     * @param tbImMessage
     */
    void isSended(TbImMessage tbImMessage);
}
