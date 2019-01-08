package com.jn.channel;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.LoadBalancerUtil;
import com.jn.common.util.StringUtils;
import com.jn.send.model.Delay;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * 接收者
 *
 * @author： fengxh
 * @date： Created on 2019/1/3 19:14
 * @version： v1.0
 * @modified By:
 */
@Component
public class ProcessReceiver implements ChannelAwareMessageListener {

    private static Logger log = LoggerFactory.getLogger(ProcessReceiver.class);

    public static CountDownLatch latch;


    @Override
    public void onMessage(Message message, Channel channel) {
        try {
            processMessage(message);
        }
        catch (Exception e) {
            log.error("失败了",e);
           throw e;
            // TODO: 2019/1/7 需要补充失败的后续操作
        }
        if(latch != null)  {
            latch.countDown();
        }
    }

    @Autowired
    private LoadBalancerUtil loadBalancerUtil;


    /**
     * 模拟消息处理。如果当消息内容为FAIL_MESSAGE的话，则需要抛出异常
     *
     * @param message
     * @throws Exception
     */
    private void processMessage(Message message){
        Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
        Delay realMessage = (Delay) jackson2JsonMessageConverter.fromMessage(message);
        //回调开始
        Result<Object> result =loadBalancerUtil.getClientPostForEntity(realMessage.getServiceId(),realMessage.getServiceUrl(),realMessage.getDataString());
        log.info("回调反馈的结果是：【{}】",result.toString());
        if(!StringUtils.equals(GlobalConstants.SUCCESS_CODE,result.getCode())){
            throw new JnSpringCloudException(result) ;
        }
    }
}
