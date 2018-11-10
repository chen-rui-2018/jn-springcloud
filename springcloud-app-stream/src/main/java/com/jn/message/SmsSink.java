package com.jn.message;

import com.jn.api.SystemClient;
import com.jn.common.channel.MessageSink;
import com.jn.common.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SystemClient systemClient;

    private static Logger log = LoggerFactory.getLogger(SmsSink.class);


    @StreamListener(MessageSink.SMS)
    public void listenSms(String smsBody) {
        log.info("收到sms的信息:{}",smsBody) ;
        //以下是测试
        Result<Object> object = systemClient.getUser(smsBody);
        log.info("调用测试成功：{}",object.toString());
        // TODO: 2018/11/8 请陈苗按这个模式来完成异步的功能
    }




}
