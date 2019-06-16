package com.jn.channel;

import com.jn.DefaultDelayMessageSend;
import com.jn.send.model.Delay;
import com.jn.utils.ChangeDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * delay的发送
 *
 * @author： fengxh
 * @date： Created on 2019/1/3 18:13
 * @version： v1.0
 * @modified By:
 */
@Service
public class MqDelayMessageSend extends DefaultDelayMessageSend {

    private static Logger log = LoggerFactory.getLogger(MqDelayMessageSend.class);



    @Override
    protected boolean send(Delay delay, Long ttl) {
        log.info("开始发送，延迟：{}",ttl);
        rabbitTemplate.convertAndSend(QueueConfig.DELAY_QUEUE_PER_MESSAGE_TTL_NAME, delay, new ExpirationMessagePostProcessor(ttl));
        return Boolean.TRUE;
    }


}
