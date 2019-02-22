package com.jn.news.sms.service.impl;

import com.jn.news.sms.service.SmsService;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SmsServiceImplTest {
    Logger logger = LoggerFactory.getLogger(SmsServiceImplTest.class);

    private String content = "【白下高新区】欢迎使用白下高新区无线网络，您的短信验证码是XXXXXX。若非本人发送，请忽略此短信。";

    private String mobile = "18613075773";

    @Autowired
    private SmsService smsService;

    @Test
    public void sendMsgByTemplate() {
        String result = smsService.sendMsgByTemplate(mobile,content);
        logger.info("短信发送测试结果：{}",result);
    }

    @Test
    @Ignore
    public void getSmsStateReport() {
        String result = smsService.getSmsStateReport();
        logger.info("主动获取短信状态报告测试结果：{}",result);
    }
}