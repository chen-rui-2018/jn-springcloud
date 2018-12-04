package com.jn.message;

import com.google.gson.Gson;
import com.jn.common.channel.MessageSink;
import com.jn.common.model.Result;
import com.jn.news.api.EmailClient;
import com.jn.news.vo.EmailVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    Logger logger = LoggerFactory.getLogger(EmailSink.class);

    @Autowired
    private EmailClient emailClient;

    private static Logger log = LoggerFactory.getLogger(EmailSink.class);

    @StreamListener(MessageSink.EMAIL)
    public void listenEmail(String emailVo) {
        log.info("收到Email的信息:{}",emailVo) ;
       // throw new JnSpringCloudException(CommonExceptionEnum.UN_KNOW);
        // TODO: 2018/11/8 请陈苗按这个模式来完成异步的功能
        Gson gson = new Gson();
        Result result = emailClient.sendEmail(gson.fromJson(emailVo,EmailVo.class));
        logger.info("邮件消息推送结果{}",result);
    }


}
