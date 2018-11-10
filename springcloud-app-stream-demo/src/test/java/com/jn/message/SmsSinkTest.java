package com.jn.message;

import com.google.gson.JsonObject;
import com.jn.SpringCloudAppStreamDemoApplication;
import com.jn.common.channel.MessageSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 发送测试
 *
 * @author： fengxh
 * @date： Created on 2018/11/8 19:38
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@EnableBinding(value = {MessageSource.class})
@SpringBootTest(classes={SpringCloudAppStreamDemoApplication.class})
public class SmsSinkTest {



    @Autowired
    private MessageSource messageSource;



    @Test
    public void sinkSenderTester() {
        JsonObject object = new JsonObject();
        object.addProperty("account","wangsong");
        System.out.println("User用户信息："+object.toString());
        messageSource.outputSms().send(MessageBuilder.withPayload(object.toString()).build());


    }



}