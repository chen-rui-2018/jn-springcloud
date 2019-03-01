package com.jn.news.message;

import com.jn.common.channel.MessageSink;
import com.jn.news.email.service.EmailService;
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
 * @author： cm
 * @date： Created on 2018/11/8 16:53
 * @version： v1.0
 * @modified By:
 */
@EnableBinding({MessageSink.class })
public class EmailSink {
    private static Logger log = LoggerFactory.getLogger(EmailSink.class);

    @Autowired
    private EmailService emailService;

    @StreamListener(MessageSink.EMAIL)
    public void listenEmail(EmailVo emailVo) {
        log.info("收到Email的信息:{}",emailVo.toString()) ;
        emailService.sendEmail(emailVo);
        log.info("邮件发送成功,邮件信息:{}",emailVo.toString());
    }


}
