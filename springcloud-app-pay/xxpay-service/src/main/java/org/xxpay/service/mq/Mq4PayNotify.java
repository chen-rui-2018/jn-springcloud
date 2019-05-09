package org.xxpay.service.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.xxpay.common.util.MyLog;
import org.xxpay.service.service.MchNotifyService;
import org.xxpay.service.service.PayOrderService;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 支付业务通知MQ实现
 * @author dingzhiwei jmdhappy@126.com
 * @date 2017-07-05
 * @version V1.0
 * @Copyright: www.xxpay.org
 */
@Component
public class Mq4PayNotify extends BaseMq{

    @Autowired
    private PayOrderService payOrderService;

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    @Autowired
    private MchNotifyService mchNotifyService;

    /**
     * 日志
    * */
    private static final MyLog _log = MyLog.getLog(Mq4PayNotify.class);



    /**
     * 消息生产者
     * */
    public void send(String msg) {
        _log.info("发送MQ消息:msg={}", msg);
        this.rabbitmqTemplate.convertAndSend(MqConfig.PAY_NOTIFY_QUEUE_NAME, msg);
    }


    /**
     * 发送延迟消息
     * @param msg
     * @param delay
     */
    public void send(String msg,final long delay) {
        _log.info("发送MQ延时消息:msg={},delay={}", msg, delay);
        this.rabbitmqTemplate.convertAndSend( MqConfig.PAY_NOTIFY_QUEUE_NAME, (Object) msg, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setDelay((int) delay);
                return message;
            }
        });
    }


    private static class TrustAnyTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }
        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[] {};
        }
    }


    /**
     * 接收处理支付消息
     * @param msg
    * */
    @RabbitListener(queues = MqConfig.PAY_NOTIFY_QUEUE_NAME)
    @RabbitHandler
    public void receive(String msg) {
        _log.info("do notify task, msg={}", msg);
        JSONObject msgObj = JSON.parseObject(msg);
        String respUrl = msgObj.getString("url");
        String orderId = msgObj.getString("orderId");
        int count = msgObj.getInteger("count");
        if(StringUtils.isEmpty(respUrl)) {
            _log.warn("notify url is empty. respUrl={}", respUrl);
            return;
        }
        try {
            _log.info("==>MQ支付结果通知业务系统开始[orderId：{}][count：{}][time：{}]", orderId, count, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            //根据回调地址进行通知业务系统
            String httpResult = httpPost(respUrl, (10 * 1000),(5 * 1000));
            _log.info("<==MQ支付结果通知业务系统结束[orderId：{}][count：{}][time：{}]", orderId, count, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            //通知次数
            int cnt = count+1;
            // 验证结果
            _log.info("notify response , OrderID={}", orderId);
            if(httpResult.equalsIgnoreCase("success")){
                //_log.info("{} notify success, url:{}", _notifyInfo.getBusiId(), respUrl);
                //修改订单表
                try {
                    int result = payOrderService.updateStatus4Complete(orderId);
                    _log.info("修改payOrderId={},订单状态为处理完成->{}", orderId, result == 1 ? "成功" : "失败");
                } catch (Exception e) {
                    _log.error(e, "修改订单状态为处理完成异常");
                }
                // 修改商户通知
                try {
                    //修改支付订单表的通知次数
                    int payOrderResult = payOrderService.updateNotify(orderId, (byte) cnt);
                    //修改商户通知为成功
                    int MchNotifyResult = mchNotifyService.updateMchNotifySuccess(orderId, httpResult, (byte) cnt);

                    _log.info("修改payOrderId={},通知业务系统次数->{}", orderId, (MchNotifyResult == 1 && payOrderResult == 1) ? "成功" : "失败");
                }catch (Exception e) {
                    _log.error(e, "修改通知次数异常");
                }
                return ; // 通知成功结束
            }else {
                // 通知失败，延时再通知
                _log.info("notify count={}", cnt);
                // 修改商户通知
                try {
                    //修改支付订单表的通知次数
                    int payOrderResult = payOrderService.updateNotify(orderId, (byte) cnt);
                    //修改商户通知为失败
                    int MchNotifyResult = mchNotifyService.updateMchNotifyFail(orderId, httpResult, (byte) cnt);
                    _log.info("修改payOrderId={},通知业务系统次数->{}", (MchNotifyResult == 1 && payOrderResult == 1) ? "成功" : "失败");
                }catch (Exception e) {
                    _log.error(e, "修改通知次数异常");
                }
                //通知次数大于6次则不再通知
                if (cnt > 5) {
                    _log.info("notify count>5 stop. url={}", respUrl);
                    return ;
                }
                msgObj.put("count", cnt);
                this.send(msgObj.toJSONString(), cnt * 60 * 1000);
            }
            _log.warn("notify failed. url:{}, response body:{}", respUrl, httpResult);
        } catch(Exception e) {
            _log.info("<==MQ通知业务系统结束[orderId：{}][count：{}][time：{}]", orderId, count, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            _log.error(e, "notify exception. url:%s", respUrl);
        }
    }
}
