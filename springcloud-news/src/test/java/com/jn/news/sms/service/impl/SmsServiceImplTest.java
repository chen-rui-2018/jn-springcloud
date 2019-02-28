package com.jn.news.sms.service.impl;

import com.jn.news.sms.model.SmsBaseResult;
import com.jn.news.sms.service.SmsService;
import com.jn.news.sms.vo.SmsAnswersResult;
import com.jn.news.sms.vo.SmsReportsResult;
import com.jn.news.vo.SmsTemplateVo;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SmsServiceImplTest {
    Logger logger = LoggerFactory.getLogger(SmsServiceImplTest.class);

    @Autowired
    private SmsService smsService;

    @Test
    public void sendMsgByTemplate() {
        SmsTemplateVo smsTemplateVo = new SmsTemplateVo();
        smsTemplateVo.setTemplateId("1000");
        String[] s = {"123456"};
        smsTemplateVo.setContents(s);
        String[] m = {"18613075773"};
        smsTemplateVo.setMobiles(m);
        SmsBaseResult result = smsService.sendMsgByTemplate(smsTemplateVo);
        logger.info("短信发送测试结果：{}",result.getResult());
    }

    @Test
    public void getSmsStateReport() {
        SmsReportsResult result = smsService.getSmsReportInfo();
        logger.info("主动获取短信状态报告测试结果：{}",result.toXml());
    }

    @Test
    public void getSmsAnswerInfo() {
        SmsAnswersResult result = smsService.getSmsAnswerInfo();
        logger.info("主动获取短信回复信息测试结果：{}",result.toXml());
    }
}