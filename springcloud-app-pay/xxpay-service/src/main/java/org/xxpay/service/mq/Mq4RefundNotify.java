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
import org.xxpay.common.constant.PayConstant;
import org.xxpay.common.util.MyLog;
import org.xxpay.common.util.RpcUtil;
import org.xxpay.common.util.StrUtil;
import org.xxpay.dal.dao.model.RefundOrder;
import org.xxpay.service.controller.PayChannel4AlipayController;
import org.xxpay.service.controller.PayChannel4WxController;
import org.xxpay.service.service.RefundOrderService;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 退款业务通知MQ实现
 * @author dingzhiwei jmdhappy@126.com
 * @date 2017-10-30
 * @version V1.0
 * @Copyright: www.xxpay.org
 */
@Component
public class Mq4RefundNotify  {


    @Autowired
    private RefundOrderService refundOrderService;

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    @Autowired
    private PayChannel4AlipayController payChannel4AlipayController;

    @Autowired
    private PayChannel4WxController payChannel4WxController;

    private static final MyLog _log = MyLog.getLog(Mq4RefundNotify.class);

    /**
     * 消息生产者
     * */
    public void send(String msg) {
        _log.info("退款业务发送MQ消息:msg={}", msg);
        this.rabbitmqTemplate.convertAndSend(MqConfig.REFUND_NOTIFY_QUEUE_NAME, msg);
    }


    /**
     * 发送延迟消息
     * @param msg
     * @param delay
     */
    public void send(String msg,final long delay) {
        _log.info("发送退款MQ延时消息:msg={},delay={}", msg, delay);
        this.rabbitmqTemplate.convertAndSend(MqConfig.PAY_NOTIFY_EXCHANGE_NAME, MqConfig.REFUND_NOTIFY_QUEUE_NAME, msg, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setDelay((int) delay);
                return message;
            }
        });
    }
    /**
     * 接收处理退款消息
     * @param msg
     * */
    @RabbitListener(queues = MqConfig.REFUND_NOTIFY_QUEUE_NAME)
    @RabbitHandler
    public void receive(String msg) {
        _log.info("处理退款任务.msg={}", msg);
        JSONObject msgObj = JSON.parseObject(msg);
        String refundOrderId = msgObj.getString("refundOrderId");
        String channelName = msgObj.getString("channelName");
        //根据退款订单ID获取退款信息
        RefundOrder refundOrder = refundOrderService.selectRefundOrder(refundOrderId);
        if(refundOrder == null) {
            _log.warn("查询退款订单为空,不能退款.refundOrderId={}", refundOrderId);
            return;
        }
        if(refundOrder.getStatus() != PayConstant.REFUND_STATUS_INIT) {
            _log.warn("退款状态不是初始({})或失败({}),不能退款.refundOrderId={}", PayConstant.REFUND_STATUS_INIT, PayConstant.REFUND_STATUS_FAIL, refundOrderId);
            return;
        }
        int result = refundOrderService.updateStatus4Ing(refundOrderId, "");
        if(result != 1) {
            _log.warn("更改退款为退款中({})失败,不能退款.refundOrderId={}", PayConstant.REFUND_STATUS_REFUNDING, refundOrderId);
            return;
        }

        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("refundOrder", refundOrder);
        String jsonParam = RpcUtil.createBaseParam(paramMap);
        Map resultMap;
        if(PayConstant.CHANNEL_NAME_WX.equalsIgnoreCase(channelName)) {
            resultMap = payChannel4WxController.doWxRefundReq(jsonParam);
        }else if(PayConstant.CHANNEL_NAME_ALIPAY.equalsIgnoreCase(channelName)) {
            resultMap = payChannel4AlipayController.doAliRefundReq(jsonParam);
        }else {
            _log.warn("不支持的退款渠道,停止退款处理.refundOrderId={},channelName={}", refundOrderId, channelName);
            return;
        }
        if(!RpcUtil.isSuccess(resultMap)) {
            _log.warn("发起退款返回异常,停止退款处理.refundOrderId={}", refundOrderId);
            return;
        }
        Map bizResult = (Map) resultMap.get("bizResult");
        Boolean isSuccess = false;
        if(bizResult.get("isSuccess") != null) {
            isSuccess = Boolean.parseBoolean(bizResult.get("isSuccess").toString());
        }
        if(isSuccess) {
            // 更新退款状态为成功
            String channelOrderNo = StrUtil.toString(bizResult.get("channelOrderNo"));
            result = refundOrderService.updateStatus4Success(refundOrderId, channelOrderNo);
            _log.info("更新退款订单状态为成功({}),refundOrderId={},返回结果:{}", PayConstant.REFUND_STATUS_SUCCESS, refundOrderId, result);
            // 发送商户通知
            //根据退款订单ID获取退款信息
            refundOrder = refundOrderService.selectRefundOrder(refundOrderId);
            refundOrderService.doNotify(refundOrder, true);
        }else {
            // 更新退款状态为失败
            String channelErrCode = StrUtil.toString(bizResult.get("channelErrCode"));
            String channelErrMsg = StrUtil.toString(bizResult.get("channelErrMsg"));
            result = refundOrderService.updateStatus4Fail(refundOrderId, channelErrCode, channelErrMsg);
            _log.info("更新退款订单状态为失败({}),refundOrderId={},返回结果:{}", PayConstant.REFUND_STATUS_FAIL, refundOrderId, result);
            // 发送商户通知
            //根据退款订单ID获取退款信息
            refundOrder = refundOrderService.selectRefundOrder(refundOrderId);
            refundOrderService.doNotify(refundOrder, true);
        }

    }
}
