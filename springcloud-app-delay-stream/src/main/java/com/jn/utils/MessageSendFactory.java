package com.jn.utils;

import com.jn.channel.DelayMessageSend;
import com.jn.common.util.StringUtils;
import com.jn.common.util.bean.BeanHeader;
import com.jn.send.model.Delay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息发送工厂
 *
 * @author： fengxh
 * @date： Created on 2019/6/16 14:55
 * @version： v1.0
 * @modified By:
 */
@Component
public class MessageSendFactory {

    public DelayMessageSend createDelayMessageSend(Delay delay){
        DelayMessageSend delayMessageSend ;
        if(StringUtils.isBlank(delay.getTtl()) && StringUtils.isBlank(delay.getDateString())){
            //返回马上发送实例
            delayMessageSend = BeanHeader.getBean("mqMessageSend");
        }else{
            //返回redis的延时发送实例
            delayMessageSend = BeanHeader.getBean("redisMessageProvider");
        }
        return delayMessageSend ;
    }
}
