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
import org.xxpay.common.constant.PayConstant;
import org.xxpay.common.util.MyLog;
import org.xxpay.service.service.MchNotifyService;
import org.xxpay.service.service.RefundOrderService;

import java.text.SimpleDateFormat;
import java.util.Date;

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
     * 如果存在http方式回调 则不用springCloud方式
     * @param msg
     * */
    @RabbitListener(queues = MqConfig.MCH_REFUND_NOTIFY_QUEUE_NAME)
    public void receive(String msg) {
        String logPrefix = "【商户退款通知】";
        _log.info("{}接收消息:msg={}", logPrefix, msg);
        JSONObject msgObj = JSON.parseObject(msg);
        String orderId = msgObj.getString("orderId");
        //http回调通知地址
        String respUrl = msgObj.getString("url");
        //springCloud 回调通知参数
        String serviceId = msgObj.getString("serviceId");
        String serviceUrl = msgObj.getString("serviceUrl");
        //通知次数
        int count = msgObj.getInteger("count");

        if(StringUtils.isEmpty(respUrl) && (StringUtils.isEmpty(serviceId) || StringUtils.isEmpty(serviceUrl))) {
            _log.warn("{}商户通知httpURL 或者 springCloud回调 serviceId 和 serviceUrl 为空,respUrl={},serviceId={},serviceUrl={}", logPrefix, respUrl,serviceId,serviceUrl);
            return;
        }

        _log.info("==>MQ退款结果通知业务系统开始[orderId：{}][count：{}][time：{}]", orderId, count, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        _log.info("{}前参数respUrl={},serviceId={},serviceUrl={}",logPrefix,respUrl,serviceId,serviceUrl);
        //回调通知接收的结果（success 成功 ，非success 如：fail 则会继续隔段时间回调）
        //根据回调地址进行通知业务系统，如果存在http方式回调 则不用springCloud方式
        String noticeResult = callbackNotice(msgObj);
        _log.info("<==MQ退款结果通知业务系统结束[orderId：{}][count：{}][time：{}] 通知结果：{}", orderId, count, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),noticeResult);

        //更新通知次数
        int cnt = count + 1;
        _log.info("{}notifyCount={}", logPrefix, cnt);
        if(PayConstant.MCH_NOTICE_REQUEST_SUCCESS.equalsIgnoreCase(noticeResult)){
            // 修改退款订单表为 4-业务处理完成
            try {
                int result = refundOrderService.updateStatus4Complete(orderId);
                _log.info("{}修改payOrderId={},订单状态为处理完成->{}", logPrefix, orderId, result == 1 ? "成功" : "失败");
            } catch (Exception e) {
                _log.error(e, "修改订单状态为处理完成异常");
            }
            // 修改通知
            try {
                int result = mchNotifyService.updateMchNotifySuccess(orderId, noticeResult, (byte) cnt);
                _log.info("{}修改商户通知,orderId={},result={},notifyCount={},结果:{}", logPrefix, orderId, noticeResult, cnt, result == 1 ? "成功" : "失败");
            }catch (Exception e) {
                _log.error(e, "修改商户支付通知异常");
            }
            return ; // 通知成功结束
        }else {
            // 修改通知次数
            try {
                int result = mchNotifyService.updateMchNotifyFail(orderId, noticeResult, (byte) cnt);
                _log.info("{}修改商户通知,orderId={},result={},notifyCount={},结果:{}", logPrefix, orderId, noticeResult, cnt, result == 1 ? "成功" : "失败");
            }catch (Exception e) {
                _log.error(e, "修改商户支付通知异常");
            }
            if (cnt > 5) {
                _log.info("respUrl={},serviceId={},serviceUrl={} 通知次数notifyCount()>5,停止通知", respUrl,serviceId,serviceUrl, cnt);
                return ;
            }
            // 通知失败，延时再通知
            msgObj.put("count", cnt);
            this.send(msgObj.toJSONString(), cnt * 60 * 1000);
            _log.info("respUrl={},serviceId={},serviceUrl={} 发送延时通知完成,通知次数:{},{}秒后执行通知", respUrl,serviceId,serviceUrl, cnt, cnt * 60);
        }
    }
}
