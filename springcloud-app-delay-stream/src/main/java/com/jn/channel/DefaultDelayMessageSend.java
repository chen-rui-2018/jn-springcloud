package com.jn.channel;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.send.enums.DelayStreamExceptionEnum;
import com.jn.send.model.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;

/**
 * delay的发送
 *
 * @author： fengxh
 * @date： Created on 2019/1/3 18:13
 * @version： v1.0
 * @modified By:
 */
@Service
public class DefaultDelayMessageSend implements DelayMessageSend{

    private static Logger log = LoggerFactory.getLogger(DefaultDelayMessageSend.class);
    /**
     * 日期转化规则
     */
    private final static String PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(Delay delay)  {
        Long ttl = this.handleDate(delay);
        log.info("开始发送，延迟：{}",ttl);
        rabbitTemplate.convertAndSend(QueueConfig.DELAY_QUEUE_PER_MESSAGE_TTL_NAME, delay, new ExpirationMessagePostProcessor(ttl));
    }


    /**
     * 处理延迟消息的ttl
     * @param delay
     * @return
     */
    private Long handleDate(Delay delay) {
        if(StringUtils.isBlank(delay.getDateString()) && StringUtils.isBlank(delay.getTtl())){
            throw new JnSpringCloudException(DelayStreamExceptionEnum.DATE_NOT_NULL);
        }
        Long ttl ;
        if(StringUtils.isNotBlank(delay.getTtl())){
            ttl = Long.valueOf(delay.getTtl());
        }else {
            Date startDate;
            try {
                startDate = DateUtils.parseDate(delay.getDateString(),PATTERN);
            } catch (ParseException e) {
                throw new JnSpringCloudException(DelayStreamExceptionEnum.DATE_FORMAT_FAIL);
            }
            ttl= (startDate.getTime() - System.currentTimeMillis());
        }
        if(ttl <= 0L){
            throw new JnSpringCloudException(DelayStreamExceptionEnum.DATE_NOT_LETTER_NOW);
        }

        return ttl;
    }
}
