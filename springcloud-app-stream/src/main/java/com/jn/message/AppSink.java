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
public class AppSink {

    private static Logger log = LoggerFactory.getLogger(AppSink.class);

    @StreamListener(MessageSink.APP)
    public void listenApp(String appBody) {
        log.info("收到App的信息:{}",appBody) ;
       // throw new JnSpringCloudException(CommonExceptionEnum.UN_KNOW);
        // TODO: 2018/11/8 请陈苗按这个模式来完成异步的功能

    }


}
