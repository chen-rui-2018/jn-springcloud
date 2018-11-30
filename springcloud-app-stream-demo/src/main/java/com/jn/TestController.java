package com.jn;

import com.jn.common.channel.MessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发送邮件的TEST测试
 *
 * @author： fengxh
 * @date： Created on 2018/11/9 10:41
 * @version： v1.0
 * @modified By:
 */
@RestController
@RequestMapping("/guest/test")
@EnableBinding(value = {MessageSource.class})
public class TestController{
    @Autowired
    private MessageSource messageSource;


    @RequestMapping("/sendSms")
    public void sinkSenderTester() {
        String object = "{\"account\":\"wangsong\"}";
        System.out.println("User用户信息："+object);
        messageSource.outputSms().send(MessageBuilder.withPayload(object).build());
    }
    @RequestMapping("/sendEmail")
    public void sinkSenderEmail() {
        String object = "发送邮件测试" ;
        System.out.println(object);
        messageSource.outputEmail().send(MessageBuilder.withPayload(object).build());
    }
}
