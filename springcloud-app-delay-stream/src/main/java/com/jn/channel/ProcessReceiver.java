package com.jn.channel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.LoadBalancerUtil;
import com.jn.common.util.StringUtils;
import com.jn.send.model.Delay;
import com.rabbitmq.client.Channel;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
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

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void onMessage(Message message, Channel channel) {
        Delay delay = null;
        try {
            Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
            delay = (Delay) jackson2JsonMessageConverter.fromMessage(message);
            processMessage(delay);
        }
        catch (Exception e) {
            log.error("失败了",e);
            Map<String,Object> errorMap = new HashMap();
            errorMap.put("delay",delay);
            errorMap.put("exception", ExceptionUtils.getStackTrace(e));
            rabbitTemplate.convertAndSend(QueueConfig.DLQ, errorMap);
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
     * @param realMessage
     * @throws Exception
     */
    private void processMessage(Delay realMessage){
        //回调开始
        Result<Object> result =loadBalancerUtil.getClientPostForEntity(realMessage.getServiceId(),realMessage.getServiceUrl(),realMessage.getDataString());
        log.info("回调反馈的结果是：【{}】",result.toString());
        if(!StringUtils.equals(GlobalConstants.SUCCESS_CODE,result.getCode())){
            throw new RuntimeException(result.getResult()) ;
        }
        throw new RuntimeException(result.getResult()) ;
    }
}
