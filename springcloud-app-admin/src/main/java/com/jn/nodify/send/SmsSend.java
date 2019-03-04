package com.jn.nodify.send;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jn.common.channel.MessageSource;
import com.jn.news.vo.SmsTemplateVo;
import com.jn.nodify.SendService;
import com.jn.nodify.domain.NotifierProperties;
import org.springframework.messaging.support.MessageBuilder;

/**
 * 邮件发送
 *
 * @author： fengxh
 * @date： Created on 2018/12/5 15:13
 * @version： v1.0
 * @modified By:
 */
public class SmsSend implements SendService {


    @Override
    public void sendMessage(MessageSource messageSource,String message,NotifierProperties notifierProperties) throws JsonProcessingException {
        SmsTemplateVo smsTemplateVo = new SmsTemplateVo();
        smsTemplateVo.setMobiles(notifierProperties.getNotifier().getReceivedPhone());
        //系统监控短信模板ID:999
        smsTemplateVo.setTemplateId("999");
        String[] smsContents = {message};
        smsTemplateVo.setContents(smsContents);
        messageSource.outputSms().send(MessageBuilder.withPayload(smsTemplateVo).build());
    }
}
