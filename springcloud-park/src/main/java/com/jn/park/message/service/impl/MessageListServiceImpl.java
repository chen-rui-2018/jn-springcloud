package com.jn.park.message.service.impl;

import com.jn.park.message.dao.MessageListDao;
import com.jn.park.message.model.AddMessageModel;
import com.jn.park.message.model.FindAllMessageListVo;
import com.jn.park.message.model.MessageListModel;
import com.jn.park.message.service.MessageListService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @Author: tangry
 * @Date: 2019/4/19
 * @Version 1.0
 */
@Service
@Transactional
public class MessageListServiceImpl implements MessageListService {

    @Autowired
    private MessageListDao messageListDao;


    @ServiceLog(doAction = "消息列表")
    @Override
    public List<FindAllMessageListVo> findAll(Integer messageOneTort,Integer messageTowTort,Integer isRead, User user) {
        List<FindAllMessageListVo> findAllMessageListVoList = messageListDao.findAll(messageOneTort,messageTowTort,isRead,user.getAccount());
        return findAllMessageListVoList;
    }

    @ServiceLog(doAction = "添加消息")
    @Override
    public void addMessage(AddMessageModel model) {
       //设置创建人
        model.setCreatorAccount(model.getCreatorAccount());
        //设置UUID作为ID
        model.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        messageListDao.addMessage(model);
    }

    @ServiceLog(doAction = "根据ID查询单个消息")
    @Override
    public MessageListModel findByMessage(String id) {
        return messageListDao.findByMessage(id);
    }


    @ServiceLog(doAction = "修改消息")
    @Override
    public void updateMessage(MessageListModel messageListModel) {
        //获取用户信息
        User user= (User) SecurityUtils.getSubject().getPrincipal();
        messageListModel.setCreatorAccount(user.getAccount());
        messageListDao.updateMessage(messageListModel);
    }


    @ServiceLog(doAction = "删除消息")
    @Override
    public void deleteMessage(String id) {
        messageListDao.deleteMessage(id);

    }

    @ServiceLog(doAction = "修改已读状态")
    @Override
    public void updateIsReadStatus(String id) {
        messageListDao.updateIsReadStatus(id);
    }
}
