package org.xxpay.service.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.xxpay.common.util.MyLog;
import org.xxpay.service.service.MchNotifyService;
import org.xxpay.service.service.RefundOrderService;

/**
 * @Description: 商户通知MQ统一处理
 * @author dingzhiwei jmdhappy@126.com
 * @date 2017-10-31
 * @version V1.0
 * @Copyright: www.xxpay.org
 */
@Component
public class Mq4MchRefundNotify extends BaseMq{

    /**
     * 日志
    * */
    private static final MyLog _log = MyLog.getLog(Mq4MchRefundNotify.class);

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    @Autowired
    private RefundOrderService refundOrderService;

    @Autowired
    private MchNotifyService mchNotifyService;

    @Autowired
    private AmqpAdmin amqpAdmin;

   /* @PostConstruct
    public void init() {
        DirectExchange exchange = new DirectExchange(MqConfig.MCH_REFUND_NOTIFY_EXCHANGE_NAME);
        exchange.setDelayed(true);
        Queue queue = new Queue(MqConfig.MCH_REFUND_NOTIFY_QUEUE_NAME);
        Binding binding = BindingBuilder.bind(queue).to(exchange).withQueueName();
        amqpAdmin.declareExchange(exchange);
        amqpAdmin.declareQueue(queue);
        amqpAdmin.declareBinding(binding);
    }*/

    /**
     * 消息生产者
     * */
    public void send(String msg) {
        _log.info("发送MQ消息:msg={}", msg);
        this.rabbitmqTemplate.convertAndSend(MqConfig.MCH_REFUND_NOTIFY_QUEUE_NAME, msg);
    }


    /**
     * 发送延迟消息
     * @param msg
     * @param delay
     */
    public void send(String msg,final long delay) {
        _log.info("发送MQ延时消息:msg={},delay={}", msg, delay);
        this.rabbitmqTemplate.convertAndSend( MqConfig.MCH_REFUND_NOTIFY_QUEUE_NAME,(Object) msg, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setDelay((int) delay);
                return message;
            }
        });
    }


    /**
     * 接收处理商户退款通知消息
     * @param msg
     * */
    @RabbitListener(queues = MqConfig.MCH_REFUND_NOTIFY_QUEUE_NAME)
    public void receive(String msg) {
        String logPrefix = "【商户退款通知】";
        _log.info("{}接收消息:msg={}", logPrefix, msg);
        JSONObject msgObj = JSON.parseObject(msg);
        String respUrl = msgObj.getString("url");
        String orderId = msgObj.getString("orderId");
        int count = msgObj.getInteger("count");
        if(StringUtils.isEmpty(respUrl)) {
            _log.warn("{}商户通知URL为空,respUrl={}", logPrefix, respUrl);
            return;
        }
        //回调通知业务系统
        String httpResult = httpPost(respUrl,(30 * 1000),(60 * 1000));
        int cnt = count + 1;
        _log.info("{}notifyCount={}", logPrefix, cnt);
        if("success".equalsIgnoreCase(httpResult)){
            // 修改退款订单表为 4-业务处理完成
            try {
                int result = refundOrderService.updateStatus4Complete(orderId);
                _log.info("{}修改payOrderId={},订单状态为处理完成->{}", logPrefix, orderId, result == 1 ? "成功" : "失败");
            } catch (Exception e) {
                _log.error(e, "修改订单状态为处理完成异常");
            }
            // 修改通知
            try {
                int result = mchNotifyService.updateMchNotifySuccess(orderId, httpResult, (byte) cnt);
                _log.info("{}修改商户通知,orderId={},result={},notifyCount={},结果:{}", logPrefix, orderId, httpResult, cnt, result == 1 ? "成功" : "失败");
            }catch (Exception e) {
                _log.error(e, "修改商户支付通知异常");
            }
            return ; // 通知成功结束
        }else {
            // 修改通知次数
            try {
                int result = mchNotifyService.updateMchNotifyFail(orderId, httpResult, (byte) cnt);
                _log.info("{}修改商户通知,orderId={},result={},notifyCount={},结果:{}", logPrefix, orderId, httpResult, cnt, result == 1 ? "成功" : "失败");
            }catch (Exception e) {
                _log.error(e, "修改商户支付通知异常");
            }
            if (cnt > 5) {
                _log.info("{}通知次数notifyCount()>5,停止通知", respUrl, cnt);
                return ;
            }
            // 通知失败，延时再通知
            msgObj.put("count", cnt);
            this.send(msgObj.toJSONString(), cnt * 60 * 1000);
            _log.info("{}发送延时通知完成,通知次数:{},{}秒后执行通知", respUrl, cnt, cnt * 60);
        }
    }
}
