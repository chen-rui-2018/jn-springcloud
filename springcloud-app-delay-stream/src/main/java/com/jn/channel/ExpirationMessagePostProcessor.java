package com.jn.channel;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;

/**
 * 设置过期时间
 *
 * @author： fengxh
 * @date： Created on 2019/1/3 19:14
 * @version： v1.0
 * @modified By:
 */
public class ExpirationMessagePostProcessor implements MessagePostProcessor {
    /**
     * 毫秒
     */
    private final Long ttl;

    public ExpirationMessagePostProcessor(Long ttl) {
        this.ttl = ttl;
    }

    @Override
    public Message postProcessMessage(Message message) throws AmqpException {
        message.getMessageProperties()
               .setExpiration(ttl.toString());
        message.getMessageProperties().setContentType("application/json");
        return message;
    }
}
