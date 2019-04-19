package com.jn.park.message.service.impl;

import com.jn.park.finance.dao.FinanceExpensesDao;
import com.jn.park.message.dao.MessageListDao;
import com.jn.park.message.service.MessageListService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: tangry
 * @Date: 2019/4/19
 * @Version 1.0
 */
public class MessageListServiceImpl implements MessageListService {

    @Autowired
    private MessageListDao messageListDao;
}
