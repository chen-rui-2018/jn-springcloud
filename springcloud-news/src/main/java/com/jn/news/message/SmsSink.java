package com.jn.news.message;

import com.jn.common.channel.MessageSink;
import com.jn.news.sms.model.SmsBaseResult;
import com.jn.news.sms.service.SmsService;
import com.jn.news.vo.SmsTemplateVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * 消息处理
 *
 * @author： cm
 * @date： Created on 2018/11/8 16:53
 * @version： v1.0
 * @modified By:
 */
@EnableBinding({MessageSink.class })
public class SmsSink {

    private static Logger log = LoggerFactory.getLogger(SmsSink.class);

    @Autowired
    private SmsService smsService;

    @StreamListener(MessageSink.SMS)
    public void listenSms(SmsTemplateVo smsTemplateVo) {
        log.info("\n短信下发接收的参数内容：【{}】",smsTemplateVo.toString());
        SmsBaseResult smsBaseResult = smsService.sendMsgByTemplate(smsTemplateVo);
        log.info("\n短信下发返回状态：{},返回结果{}",smsBaseResult.getResult(),smsBaseResult.getDesc());
    }




}
