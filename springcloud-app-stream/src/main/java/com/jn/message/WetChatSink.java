package com.jn.message;

import com.jn.common.channel.MessageSink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * 消息处理
 * 需要自己捕获异常，打印
 *
 * @author： fengxh
 * @date： Created on 2018/11/8 16:53
 * @version： v1.0
 * @modified By:
 */
@EnableBinding({MessageSink.class })
public class WetChatSink {

    private static Logger log = LoggerFactory.getLogger(WetChatSink.class);

    @StreamListener(MessageSink.WET_CHAT)
    public void listenWetChat(String wetChatBody) {
        log.info("收到WET_CHAT的信息:{}",wetChatBody) ;
       // throw new JnSpringCloudException(CommonExceptionEnum.UN_KNOW);
        // TODO: 2018/11/8 请陈苗按这个模式来完成异步的功能

    }


}
