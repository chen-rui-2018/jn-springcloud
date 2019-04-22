package com.jn.park.message.service.impl;

import com.jn.common.util.StringUtils;
import com.jn.park.finance.dao.FinanceExpensesDao;
import com.jn.park.message.dao.MessageListDao;
import com.jn.park.message.model.FindAllMessageListVo;
import com.jn.park.message.model.addMessageModel;
import com.jn.park.message.service.MessageListService;
import com.jn.system.model.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


    @Override
    public List<FindAllMessageListVo> findAll(Integer messageTowTort, User user) {
        List<FindAllMessageListVo> findAllMessageListVoList = messageListDao.findAll(messageTowTort,user.getAccount());
        return findAllMessageListVoList;
    }

    @Override
    public void addMessage(addMessageModel model) {
        //获取用户信息
       User user= (User) SecurityUtils.getSubject().getPrincipal();
       //
        if(StringUtils.isBlank(model.getCreatorAccount())){
            model.setCreatorAccount(user.getAccount());
        }
        messageListDao.addMessage(model);
    }
}
