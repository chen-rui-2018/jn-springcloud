package com.jn;

import com.jn.channel.DelayMessageSend;
import com.jn.send.model.Delay;
import com.jn.utils.ChangeDate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * delay的发送
 *
 * @author： fengxh
 * @date： Created on 2019/1/3 18:13
 * @version： v1.0
 * @modified By:
 */
public abstract class DefaultDelayMessageSend implements DelayMessageSend {


    @Autowired
    protected RabbitTemplate rabbitTemplate;



    @Override
    public void send(Delay delay)  {
       Long ttl = ChangeDate.handleDate(delay);
       this.send(delay,ttl);
    }


    /**
     * 发送的抽象子类
     * @param delay
     * @param ttl
     * @return
     */
    protected abstract boolean send(Delay delay , Long ttl);



}
