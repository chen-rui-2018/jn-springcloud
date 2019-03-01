package com.jn.news.message;

import com.jn.common.channel.MessageSink;
import com.jn.common.model.Result;
import com.jn.wechat.api.WechatClient;
import com.jn.wechat.model.TemplateMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * 消息处理
 * 需要自己捕获异常，打印
 *
 * @author： cm
 * @date： Created on 2018/11/8 16:53
 * @version： v1.0
 * @modified By:
 */
@EnableBinding({MessageSink.class })
public class WetChatSink {

    @Autowired
    private WechatClient wechatClient;

    private static Logger log = LoggerFactory.getLogger(WetChatSink.class);

    @StreamListener(MessageSink.WET_CHAT)
    public void listenWetChat(TemplateMessage templateMessage) {
        log.info("收到WET_CHAT的信息:{}",templateMessage.toString()) ;
        Result<String> result = wechatClient.pushTemplateInfo(templateMessage);
        log.info("推送模板消息接口返回结果:{}",result.getResult());
    }


}
