package com.jn.news.message;

import com.jn.common.channel.MessageSink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * 消息处理
 *
 * @author： fengxh
 * @date： Created on 2018/11/8 16:53
 * @version： v1.0
 * @modified By:
 */
@EnableBinding({MessageSink.class })
public class SmsSink {

    private static Logger log = LoggerFactory.getLogger(SmsSink.class);


    @StreamListener(MessageSink.SMS)
    public void listenSms(String smsBody) {
        log.info("收到sms的信息:{}",smsBody) ;
        // TODO: 2018/11/8 请陈苗按这个模式来完成异步的功能
    }




}
