package com.jn.common.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 消息 输出通道
 *
 * @author： fengxh
 * @date： Created on 2018/11/8 16:45
 * @version： v1.0
 * @modified By:
 */
public interface MessageSource {



    @Output(MessageSink.EMAIL)
    MessageChannel outputEmail();

    @Output(MessageSink.APP)
    MessageChannel outputApp();

    @Output(MessageSink.WET_CHAT)
    MessageChannel outputWetChat();

    @Output(MessageSink.SMS)
    MessageChannel outputSms();



}
