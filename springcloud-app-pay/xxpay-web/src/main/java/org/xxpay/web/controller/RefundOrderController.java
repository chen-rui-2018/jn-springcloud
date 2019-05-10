package org.xxpay.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jn.common.model.Result;
import com.jn.pay.api.RefundOrderClient;
import com.jn.pay.model.RefundOrderReq;
import com.jn.pay.model.RefundOrderRsp;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.xxpay.common.constant.PayConstant;
import org.xxpay.common.constant.PayEnum;
import org.xxpay.common.util.MyLog;
import org.xxpay.common.util.MySeq;
import org.xxpay.web.service.MchInfoServiceClient;
import org.xxpay.web.service.PayChannelServiceClient;
import org.xxpay.web.service.PayOrderServiceClient;
import org.xxpay.web.service.RefundOrderServiceClient;

/**
 * @Description: 退款订单
 * @author dingzhiwei jmdhappy@126.com
 * @date 2017-10-30
 * @version V1.0
 * @Copyright: www.xxpay.org
 */
@RestController
public class RefundOrderController implements RefundOrderClient {

    private final MyLog _log = MyLog.getLog(RefundOrderController.class);

    @Autowired
    private RefundOrderServiceClient refundOrderServiceClient;

    @Autowired
    private MchInfoServiceClient mchInfoServiceClient;

    @Autowired
    private PayChannelServiceClient payChannelServiceClient;

    @Autowired
    private PayOrderServiceClient payOrderServiceClient;

    /**
     * 统一退款接口:
     * 1)先验证接口参数以及签名信息
     * 2)验证通过创建退款订单
     * 3)根据商户选择渠道,调用退款服务进行下单
     * 4)返回下单数据
     * @param refundOrderReq
     * @return
    */
    @Override
    public Result<RefundOrderRsp> createRefundOrder(@RequestBody @Validated RefundOrderReq refundOrderReq) {
        _log.info("###### 开始接收商户统一退款请求 ######");
        String logPrefix = "【商户统一退款】";
        try {
            JSONObject refundContext = new JSONObject();
            JSONObject refundOrder = null;
            // 验证参数有效性
            Object object = validateParams(refundOrderReq, refundContext);
            if (object instanceof String) {
                _log.info("{}参数校验不通过:{}", logPrefix, object);
                return new Result(PayEnum.ERR_0014.getCode(),(String)object);
            }
            if (object instanceof JSONObject) {
                refundOrder = (JSONObject) object;
            }
            if(refundOrder == null) {
                return new Result(PayEnum.ERR_0010.getCode(),"支付中心退款失败");
            }
            //创建退款单
            String result = refundOrderServiceClient.createRefundOrder(refundOrder.toJSONString());
            _log.info("{}创建退款订单,结果:{}", logPrefix, result);
            if(StringUtils.isEmpty(result)) {
                return new Result(PayEnum.ERR_0010.getCode(),"创建退款订单失败");
            }
            // 发送异步退款消息
            String refundOrderId = refundOrder.getString("refundOrderId");
            String channelName = refundContext.getString("channelName");
            refundOrderServiceClient.sendRefundNotify(refundOrderId, channelName);
            _log.info("{}发送退款任务完成,transOrderId={}", logPrefix, refundOrderId);
            //返回结果
            RefundOrderRsp refundOrderRsp = new RefundOrderRsp();
            refundOrderRsp.setRefundOrderId(refundOrder.getString("refundOrderId"));
            return new Result(refundOrderRsp);
        }catch (Exception e) {
            _log.error(e, "退款下单失败!");
            return new Result(PayEnum.ERR_0010.getCode(),"支付中心系统异常");
        }
    }

    /**
     * 验证创建退款订单请求参数,参数通过返回JSONObject对象,否则返回错误文本信息
     * @param refundOrderReq
     * @param refundContext
     * @return
     */
    private Object validateParams(RefundOrderReq refundOrderReq, JSONObject refundContext) {
        // 验证请求参数,参数有问题返回错误提示
        String errorMessage;
        // -------------------支付参数------------------------
        //商品ID(mchIdEnum枚举类)
        String mchId = refundOrderReq.getMchId();
        // 支付订单号
        String payOrderId = refundOrderReq.getPayOrderId();
        // 商户支付单号
        String mchOrderNo = refundOrderReq.getMchOrderNo();
        // 商户退款单号
        String mchRefundNo = refundOrderReq.getMchRefundNo();
        // 渠道ID
        String channelId = refundOrderReq.getChannelId();
        // 退款金额（单位分）
        String amount = refundOrderReq.getAmount().toString();
        // 币种
        String currency = PayConstant.PAY_RMB;
        // 客户端IP
        String clientIp = refundOrderReq.getClientIp();
        // 设备
        String device = refundOrderReq.getDevice();
        // 特定渠道发起时额外参数
        String extra = refundOrderReq.getExtra();
        // 扩展参数1
        String param1 = refundOrderReq.getParam1();
        // 扩展参数2
        String param2 = refundOrderReq.getParam2();
        // 转账结果回调URL
        String notifyUrl = refundOrderReq.getNotifyUrl();

        // 渠道用户标识,如微信openId,支付宝账号
        String channelUser = refundOrderReq.getChannelUser();
        // 用户姓名
        String userName = refundOrderReq.getUserName();
        // 备注
        String remarkInfo = refundOrderReq.getRemarkInfo();


        if(StringUtils.isBlank(mchId)) {
            errorMessage = "request params[mchId]  Can't find.";
            return errorMessage;
        }
        if(StringUtils.isBlank(payOrderId) && StringUtils.isBlank(mchOrderNo)) {
            errorMessage = "request params[payOrderId,mchOrderNo] error.";
            return errorMessage;
        }
        if(StringUtils.isBlank(mchRefundNo)) {
            errorMessage = "request params[mchRefundNo] error.";
            return errorMessage;
        }
        if(StringUtils.isBlank(channelId)) {
            errorMessage = "request params[channelId] error.";
            return errorMessage;
        }
        if(!NumberUtils.isNumber(amount)) {
            errorMessage = "request params[amount] error.";
            return errorMessage;
        }
        if(StringUtils.isBlank(notifyUrl)) {
            errorMessage = "request params[notifyUrl] error.";
            return errorMessage;
        }
        if(StringUtils.isBlank(channelUser)) {
            errorMessage = "request params[channelUser] error.";
            return errorMessage;
        }

        // 查询商户信息
        JSONObject mchInfo;
        String retStr = mchInfoServiceClient.selectMchInfo(getJsonParam("mchId", mchId));

        JSONObject retObj = JSON.parseObject(retStr);
        if("0000".equals(retObj.getString("code"))) {
            mchInfo = retObj.getJSONObject("result");
            if (mchInfo == null) {
                errorMessage = "Can't found mchInfo[mchId="+mchId+"] record in db.";
                return errorMessage;
            }
            if(mchInfo.getByte("state") != 1) {
                errorMessage = "mchInfo not available [mchId="+mchId+"] record in db.";
                return errorMessage;
            }
        }else {
            errorMessage = "Can't found mchInfo[mchId="+mchId+"] record in db.";
            _log.info("查询商户没有正常返回数据,code={},msg={}", retObj.getString("code"), retObj.getString("msg"));
            return errorMessage;
        }

        // 查询商户对应的支付渠道
        JSONObject payChannel;
        retStr = payChannelServiceClient.selectPayChannel(getJsonParam(new String[]{"channelId", "mchId"}, new String[]{channelId, mchId}));
        retObj = JSON.parseObject(retStr);
        if("0000".equals(retObj.getString("code"))) {
            payChannel = JSON.parseObject(retObj.getString("result"));
            if(payChannel == null) {
                errorMessage = "Can't found payChannel[channelId="+channelId+",mchId="+mchId+"] record in db.";
                return errorMessage;
            }
            if(payChannel.getByte("state") != 1) {
                errorMessage = "channel not available [channelId="+channelId+",mchId="+mchId+"]";
                return errorMessage;
            }
        }else {
            errorMessage = "Can't found payChannel[channelId="+channelId+",mchId="+mchId+"] record in db.";
            _log.info("查询渠道没有正常返回数据,code={},msg={}", retObj.getString("code"), retObj.getString("msg"));
            return errorMessage;
        }
        refundContext.put("channelName", payChannel.getString("channelName"));

        // 验证支付订单是否存在
        JSONObject payOrder;
        retStr = payOrderServiceClient.queryPayOrder(getJsonParam(new String[]{"payOrderId","mchId"}, new String[]{payOrderId,mchId}));
        retObj = JSON.parseObject(retStr);
        if("0000".equals(retObj.getString("code"))) {
            payOrder = JSON.parseObject(retObj.getString("result"));
            if(payOrder == null) {
                errorMessage = "Can't found payOrder[payOrderId="+payOrderId+",mchId="+mchId+"] record in db.";
                return errorMessage;
            }
        }else {
            errorMessage = "Can't found payOrder[payOrderId="+payOrderId+",mchId="+mchId+"] record in db.";
            _log.info("查询支付订单没有正常返回数据,code={},msg={}", retObj.getString("code"), retObj.getString("msg"));
            return errorMessage;
        }

        // 渠道测支付单号
        String channelPayOrderNo = payOrder.getString("channelOrderNo");
        //支付金额
        Long payAmount = payOrder.getLong("amount");

        // 验证参数通过,返回JSONObject对象
        JSONObject refundOrder = new JSONObject();
        refundOrder.put("refundOrderId", MySeq.getRefund());
        refundOrder.put("payOrderId", payOrderId);
        refundOrder.put("channelPayOrderNo", channelPayOrderNo);
        refundOrder.put("mchId", mchId);
        refundOrder.put("mchRefundNo", mchRefundNo);
        refundOrder.put("channelId", channelId);
        refundOrder.put("refundAmount", Long.parseLong(amount));    // 退款金额
        refundOrder.put("payAmount", payAmount);                    // 支付金额
        refundOrder.put("currency", currency);
        refundOrder.put("clientIp", clientIp);
        refundOrder.put("device", device);
        refundOrder.put("channelUser", channelUser);
        refundOrder.put("userName", userName);
        refundOrder.put("remarkInfo", remarkInfo);
        refundOrder.put("extra", extra);
        refundOrder.put("channelMchId", payChannel.getString("channelMchId"));
        refundOrder.put("param1", param1);
        refundOrder.put("param2", param2);
        refundOrder.put("notifyUrl", notifyUrl);
        return refundOrder;
    }

    String getJsonParam(String[] names, Object[] values) {
        JSONObject jsonParam = new JSONObject();
        for (int i = 0; i < names.length; i++) {
            jsonParam.put(names[i], values[i]);
        }
        return jsonParam.toJSONString();
    }

    String getJsonParam(String name, Object value) {
        JSONObject jsonParam = new JSONObject();
        jsonParam.put(name, value);
        return jsonParam.toJSONString();
    }
}
