package com.jn.nodify.send;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jn.common.channel.MessageSource;
import com.jn.news.vo.EmailVo;
import com.jn.nodify.SendService;
import com.jn.nodify.domain.NotifierProperties;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.messaging.support.MessageBuilder;

/**
 * 邮件发送
 *
 * @author： fengxh
 * @date： Created on 2018/12/5 15:13
 * @version： v1.0
 * @modified By:
 */
public class EmailSend implements SendService {


    @Override
    public void sendMessage(MessageSource messageSource,String message,NotifierProperties notifierProperties) throws JsonProcessingException {
        EmailVo emailVo = new EmailVo();
        emailVo.setEmail(String.join(",",notifierProperties.getNotifier().getReceivedMail()));
        emailVo.setEmailSubject(notifierProperties.getNotifier().getTitle());
        emailVo.setEmailContent(message);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(emailVo);
        messageSource.outputEmail().send(MessageBuilder.withPayload(json).build());

    }
}
