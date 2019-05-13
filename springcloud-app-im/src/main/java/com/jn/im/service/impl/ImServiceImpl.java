package com.jn.im.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.im.dao.ImMapper;
import com.jn.im.dao.TbImMessageMapper;
import com.jn.im.entity.TbImMessage;
import com.jn.im.model.Message;
import com.jn.im.service.ImService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * IM ImServiceImpl
 *
 * @author： shenph
 * @date： Created on 2019/5/10 21:34
 * @version： v1.0
 * @modified By:
 */
@Service
public class ImServiceImpl implements ImService {

    @Autowired
    private ImMapper imMapper;

    @Autowired
    private TbImMessageMapper tbImMessageMapper;

    @Override
    public PaginationData<List<TbImMessage>> selectMsg(Message message) {
        Page<Object> objects = PageHelper.startPage(message.getPage(), message.getRows());
        List<TbImMessage> selectMsgList = imMapper.selectMsg(message);
        PaginationData data = new PaginationData(selectMsgList, objects.getTotal());
        return data;
    }

    @Override
    public void isSended(TbImMessage tbImMessage) {
        tbImMessage.setSendId(null);
        tbImMessage.setMsgType(null);
        tbImMessage.setContent(null);
        tbImMessage.setReceiveId(null);
        tbImMessage.setCreateTime(null);
        tbImMessage.setSendTime(new Date());
        tbImMessage.setIsSended("Y");
        tbImMessageMapper.updateByPrimaryKeySelective(tbImMessage);
    }

    @Override
    public PaginationData<List<TbImMessage>> selectMsgList(Message message) {
        Page<Object> objects = PageHelper.startPage(message.getPage(), message.getRows());
        List<TbImMessage> selectMsgList = imMapper.selectMsgList(message);
        PaginationData data = new PaginationData(selectMsgList, objects.getTotal());
        return data;
    }
}
