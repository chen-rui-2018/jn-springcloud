package com.jn.channel;

import com.jn.channel.ProcessReceiver;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 队列配置
 *
 * @author： fengxh
 * @date： Created on 2019/1/3 19:14
 * @version： v1.0
 * @modified By:
 */
@Configuration
public class QueueConfig {

    /**
     * 发送到该队列的message会在一段时间后过期进入到delay_process_queue
     * 每个message可以控制自己的失效时间
     */
    final static String DELAY_QUEUE_PER_MESSAGE_TTL_NAME = "delay_queue_per_message_ttl";
    /**
     * message失效后进入的队列，也就是实际的消费队列
     */
    final static String DELAY_PROCESS_QUEUE_NAME = "delay_process_queue";
    /**
     * 实际消费队列的exchange
     */
    final static String DELAY_EXCHANGE_NAME = "delay_exchange";
    /**
     * 创建DLX exchange
     *
     * @return
     */
    @Bean
    DirectExchange delayExchange() {
        return new DirectExchange(DELAY_EXCHANGE_NAME);
    }
    /**
     * 创建delay_queue_per_message_ttl队列
     *
     * @return
     */
    @Bean
    Queue delayQueuePerMessageTTL() {
        return QueueBuilder.durable(DELAY_QUEUE_PER_MESSAGE_TTL_NAME)
                           .withArgument("x-dead-letter-exchange", DELAY_EXCHANGE_NAME)
                           .withArgument("x-dead-letter-routing-key", DELAY_PROCESS_QUEUE_NAME)
                           .build();
    }
    /**
     * 创建delay_process_queue队列，也就是实际消费队列
     *
     * @return
     */
    @Bean
    Queue delayProcessQueue() {
        return QueueBuilder.durable(DELAY_PROCESS_QUEUE_NAME)
                .build();
    }
    /**
     * 将DLX绑定到实际消费队列
     *
     * @param delayProcessQueue
     * @param delayExchange
     * @return
     */
    @Bean
    Binding dlxBinding(Queue delayProcessQueue, DirectExchange delayExchange) {
        return BindingBuilder.bind(delayProcessQueue)
                             .to(delayExchange)
                             .with(DELAY_PROCESS_QUEUE_NAME);
    }

  /*  *//**
     * 创建delay_process_queue.dlq队列
     *
     * @return
     *//*
    @Bean
    Queue delayProcessDlqQueue() {
        return QueueBuilder.durable(DELAY_PROCESS_FAIL_QUEUE_NAME)
                .build();
    }
    *//**
     * 将DLq绑定到DLX
     *
     * @param delayProcessDlqQueue
     * @param delayExchange
     * @return
     *//*
    @Bean
    Binding dlqBinding(Queue delayProcessDlqQueue) {
        return BindingBuilder.bind(delayProcessDlqQueue)
                .to(delayExchange)
                .with(DELAY_PROCESS_QUEUE_NAME);
    }*/



    /**
     * 定义delay_process_queue队列的Listener Container
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    SimpleMessageListenerContainer processContainer(ConnectionFactory connectionFactory, ProcessReceiver processReceiver) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(DELAY_PROCESS_QUEUE_NAME);
        MessageListenerAdapter adapter = new MessageListenerAdapter(processReceiver);
        container.setMessageListener(adapter);
        return container;
    }


    @Bean
    @Primary
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }
}
