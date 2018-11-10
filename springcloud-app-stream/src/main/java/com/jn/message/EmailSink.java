package com.jn.message;

import com.jn.common.channel.MessageSink;
import com.jn.common.enums.CommonExceptionEnum;
import com.jn.common.exception.JnSpringCloudException;
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
public class EmailSink {

    private static Logger log = LoggerFactory.getLogger(EmailSink.class);

    @StreamListener(MessageSink.EMAIL)
    public void listenEmail(String emailBody) {
        log.info("收到Email的信息:{}",emailBody) ;
       // throw new JnSpringCloudException(CommonExceptionEnum.UN_KNOW);
        // TODO: 2018/11/8 请陈苗按这个模式来完成异步的功能

    }


}
