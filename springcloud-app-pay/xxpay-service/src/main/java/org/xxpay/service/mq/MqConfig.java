package org.xxpay.service.mq;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @Description:
 * @author dingzhiwei jmdhappy@126.com
 * @date 2017-07-05
 * @version V1.0
 * @Copyright: www.xxpay.org
 */
@Configuration
public class MqConfig {

    ///======================消息队列=====================================
    /**
     * 支付通知队列
     * */
    public static final String PAY_NOTIFY_QUEUE_NAME = "pay.notify.queue";
    /**
     * 退款通知队列
     * */
    public static final String REFUND_NOTIFY_QUEUE_NAME = "refund.notify.queue";
    /**
     * 商户支付通知队列
     * */
    public static final String MCH_PAY_NOTIFY_QUEUE_NAME = "mch.pay.notify.queue";
    /**
     * 商户退款通知队列
     * */
    public static final String MCH_REFUND_NOTIFY_QUEUE_NAME = "mch.refund.notify.queue";



    //////----------------------交换机----------------------------------
    /**
     * 支付通知交换机
     * */
    public static final String PAY_NOTIFY_EXCHANGE_NAME = "pay.notify.exchange";
    /**
     * 商户退款通知交换机
     * */
    public static final String MCH_REFUND_NOTIFY_EXCHANGE_NAME = "mch.refund.notify.exchange";

    @Bean
    public Queue payNotifyQueue() {
        return new Queue(PAY_NOTIFY_QUEUE_NAME);
    }
    @Bean
    public Queue refundNotifyQueue() {
        return new Queue(REFUND_NOTIFY_QUEUE_NAME);
    }
    @Bean
    public Queue mchRefundNotifyQueue() {
        return new Queue(MCH_REFUND_NOTIFY_QUEUE_NAME);
    }



    /**
     * 信道配置
     * */
    @Bean
    public DirectExchange mchRfundNotifyExchange() {
        return new DirectExchange(MCH_REFUND_NOTIFY_EXCHANGE_NAME, true, false);

    }
}
