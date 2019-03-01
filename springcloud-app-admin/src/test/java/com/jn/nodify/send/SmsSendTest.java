package com.jn.nodify.send;

import com.jn.common.channel.MessageSource;
import com.jn.news.vo.SmsTemplateVo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableBinding(value = {MessageSource.class})
public class SmsSendTest {
    @Autowired
    private MessageSource messageSource;

    @Test
    @Ignore
    public void sendMessage() {
        SmsTemplateVo smsTemplateVo = new SmsTemplateVo();
        smsTemplateVo.setTemplateId("1000");
        String[] m = {"18613075773"};
        smsTemplateVo.setMobiles(m);
        String[] t = {"12345666"};
        smsTemplateVo.setContents(t);
        messageSource.outputSms().send(MessageBuilder.withPayload(smsTemplateVo).build());
    }
}