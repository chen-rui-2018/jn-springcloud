package com.jn.nodify.send;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jn.common.channel.MessageSource;
import com.jn.nodify.SendService;
import com.jn.nodify.domain.NotifierProperties;

/**
 * 邮件发送
 *
 * @author： fengxh
 * @date： Created on 2018/12/5 15:13
 * @version： v1.0
 * @modified By:
 */
public class WetChatSend implements SendService {


    @Override
    public void sendMessage(MessageSource messageSource,String message,NotifierProperties notifierProperties) throws JsonProcessingException {
        // TODO: 2018/12/5 fengxh，等待微信的通信完成，再补充(陈苗)

    }
}
