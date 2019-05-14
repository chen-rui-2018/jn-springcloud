package com.jn.park.message.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.park.finance.vo.FinanceExpendHistoryVo;
import com.jn.park.message.dao.MessageListDao;
import com.jn.park.message.model.AddMessageModel;
import com.jn.park.message.model.FindAllMessageListVo;
import com.jn.park.message.model.MessageListModel;
import com.jn.park.message.model.findAllMessageListModel;
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
    public PaginationData<PaginationData<List<FindAllMessageListVo>>> findAll(findAllMessageListModel fModel, User user) {

        Page<Object> objects = PageHelper.startPage(fModel.getPage(), fModel.getRows());

        List<FindAllMessageListVo> findAllMessageListVoList = messageListDao.findAll(fModel.getMessageOneTort(),fModel.getMessageTowTort(),fModel.getIsRead(),user.getAccount());
        return new  PaginationData(findAllMessageListVoList,objects.getTotal());
    }

    @Override
    public int getIsRead(User user) {
        int getIsRead=messageListDao.getIsRead(user.getAccount());
        if(getIsRead>0){
            getIsRead=0;
        }else{
            getIsRead=1;
        }
        return getIsRead;
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
