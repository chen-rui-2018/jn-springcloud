package com.jn.oa.message.service.impl;


import com.jn.common.channel.MessageSource;
import com.jn.news.vo.SmsTemplateVo;
import com.jn.oa.message.model.MessageCode;
import com.jn.oa.message.service.MessageService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


/**
 * 短信service
 *
 * @author： yuanyy
 * @date： Created on 2019/4/17 10:49
 * @version： v1.0
 * @modified By:
 */
@Service
@EnableBinding(value = {MessageSource.class})
public class MessageServiceImpl implements MessageService {

    private static Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    private MessageSource messageSource;


    /**
     * 发送指定验证码
     *
     * @param messageCode
     */
    @Override
    @ServiceLog(doAction = "发送指定验证码")
    public void sendMessageCode(MessageCode messageCode) {
        SmsTemplateVo smsTemplateVo = new SmsTemplateVo();
        smsTemplateVo.setTemplateId("1000");
        smsTemplateVo.setMobiles(messageCode.getPhones());
        String[] t = {messageCode.getMessageCode()};
        smsTemplateVo.setContents(t);
        logger.info("短信发送成功：接收号码：{},验证码：{}",messageCode.getPhones(),messageCode.getMessageCode());
        messageSource.outputSms().send(MessageBuilder.withPayload(smsTemplateVo).build());

    }
}
