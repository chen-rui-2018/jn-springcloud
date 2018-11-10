package com.jn.common.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 消息 输入通道
 *
 * @author： fengxh
 * @date： Created on 2018/11/8 16:45
 * @version： v1.0
 * @modified By:
 */
public interface MessageSink {

    String EMAIL = "email" ;

    String APP = "app" ;

    String WET_CHAT = "wetChat" ;

    String SMS = "sms" ;


    @Input(EMAIL)
    SubscribableChannel  inputEmail();

    @Input(APP)
    SubscribableChannel  inputApp();

    @Input(WET_CHAT)
    SubscribableChannel  inputWetChat();

    @Input(SMS)
    SubscribableChannel inputSms();



}
