package com.jn.channel;

import com.jn.DefaultDelayMessageSend;
import com.jn.send.model.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 发送
 *
 * @author： fengxh
 * @date： Created on 2019/1/3 18:13
 * @version： v1.0
 * @modified By:
 */
@Service
public class MqMessageSend implements DelayMessageSend {

    private static Logger log = LoggerFactory.getLogger(MqMessageSend.class);

    @Autowired
    protected RabbitTemplate rabbitTemplate;


    @Override
    public void send(Delay delay) {
        log.info("马上发送消息到消费队列进行消费");
        rabbitTemplate.convertAndSend(QueueConfig.DELAY_PROCESS_QUEUE_NAME, delay, new MessagePostProcessor(){
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setContentType("application/json");
                return message;
            }
        });
    }
}
