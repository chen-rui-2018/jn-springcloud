package org.xxpay.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jn.common.model.Result;
import com.jn.pay.api.PayOrderClient;
import com.jn.pay.enums.ChannelIdEnum;
import com.jn.pay.model.PayOrderQueryReq;
import com.jn.pay.model.PayOrderQueryRsp;
import com.jn.pay.model.PayOrderReq;
import com.jn.pay.model.alipay.AlipayMobilePayRsp;
import com.jn.pay.model.alipay.AlipayPcPayRsp;
import com.jn.pay.model.alipay.AlipayWapPayRsp;
import com.jn.pay.model.wx.WxMwebPayRsp;
import com.jn.pay.model.wx.WxNativePayRsp;
import com.jn.pay.vo.wx.WxAppPayRsp;
import com.jn.pay.vo.wx.WxJsapiPayRsp;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

/**
 * @Description: 支付订单,包括:统一下单,订单查询,补单等接口
 * @author dingzhiwei jmdhappy@126.com
 * @date 2017-07-05
 * @version V1.0
 * @Copyright: www.xxpay.org
 */
@RestController
public class PayOrderController implements PayOrderClient {


    private final MyLog _log = MyLog.getLog(PayOrderController.class);

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private PayOrderServiceClient payOrderServiceClient;

    @Autowired
    private MchInfoServiceClient mchInfoServiceClient;

    @Autowired
    private PayChannelServiceClient payChannelServiceClient;


    /**
     * 统一下单接口:
     * 1)先验证接口参数以及签名信息
     * 2)验证通过创建支付订单
     * 3)根据商户选择渠道,调用支付服务进行下单
     * 4)返回下单数据
     * @param payOrderReq
     * @return
     */
    @Override
    public Result createPayOrder(@RequestBody @Validated PayOrderReq payOrderReq) {
        _log.info("###### 开始接收商户统一下单请求 ######");
        String logPrefix = "【商户统一下单】";
        ServiceInstance instance = client.getLocalServiceInstance();
        _log.info("{}/pay/create_order, host:{}, service_id:{}, params:{}", logPrefix, instance.getHost(), instance.getServiceId(), payOrderReq.toString());

        try {
            JSONObject payOrder = null;
            // 验证参数有效性
            Object object = validatePayParams(payOrderReq);
            if (object instanceof String) {
                _log.info("{}参数校验不通过:{}", logPrefix, object);
                return new Result(PayEnum.ERR_0014.getCode(),(String)object);
            }
            if (object instanceof JSONObject) {
                payOrder = (JSONObject) object;
            }
            if(payOrder == null) {
                return new Result(PayEnum.ERR_0010.getCode(),"支付中心下单失败");
            }
            //创建支付订单
            String resultStr = payOrderServiceClient.createPayOrder(payOrder.toJSONString());
            _log.info("{}创建支付订单,结果:{}", logPrefix, resultStr);
            if(StringUtils.isEmpty(resultStr)) {
                return new Result(PayEnum.ERR_0010.getCode(),"创建支付订单失败");
            }
            JSONObject resObj = JSON.parseObject(resultStr);
            if(resObj == null || !"1".equals(resObj.getString("result"))) {
                return new Result(PayEnum.ERR_0010.getCode(),"创建支付订单失败");
            }
            //获取支付渠道ID
            String channelId = payOrder.getString("channelId");
            //根据支付渠道ID 执行不同的支付方式
            switch (ChannelIdEnum.getCode(channelId)) {
                case WX_APP :
                    String wxAppParam = payOrderServiceClient.doWxPayReq(getJsonParam(new String[]{"tradeType", "payOrder"}, new Object[]{PayConstant.WxConstant.TRADE_TYPE_APP, payOrder}));
                    return returnResult(wxAppParam,ChannelIdEnum.getCode(channelId));
                case WX_JSAPI :
                    String wxJsapiParam =  payOrderServiceClient.doWxPayReq(getJsonParam(new String[]{"tradeType", "payOrder"}, new Object[]{PayConstant.WxConstant.TRADE_TYPE_JSPAI, payOrder}));
                    return returnResult(wxJsapiParam,ChannelIdEnum.getCode(channelId));
                case WX_NATIVE :
                    String wxNativeParam =  payOrderServiceClient.doWxPayReq(getJsonParam(new String[]{"tradeType", "payOrder"}, new Object[]{PayConstant.WxConstant.TRADE_TYPE_NATIVE, payOrder}));
                    return returnResult(wxNativeParam,ChannelIdEnum.getCode(channelId));
                case WX_MWEB :
                    String wxMwebParam = payOrderServiceClient.doWxPayReq(getJsonParam(new String[]{"tradeType", "payOrder"}, new Object[]{PayConstant.WxConstant.TRADE_TYPE_MWEB, payOrder}));
                    return returnResult(wxMwebParam,ChannelIdEnum.getCode(channelId));
                case ALIPAY_MOBILE :
                    String aliPayMobileParam =  payOrderServiceClient.doAliPayMobileReq(getJsonParam("payOrder", payOrder));
                    return returnResult(aliPayMobileParam,ChannelIdEnum.getCode(channelId));
                case ALIPAY_PC :
                    String jsonParam = payOrderServiceClient.doAliPayPcReq(getJsonParam("payOrder", payOrder));
                    return returnResult(jsonParam,ChannelIdEnum.getCode(channelId));
               case ALIPAY_WAP :
                   String aliPayWapParam =  payOrderServiceClient.doAliPayWapReq(getJsonParam("payOrder", payOrder));
                   return returnResult(aliPayWapParam,ChannelIdEnum.getCode(channelId));
                default:
                    return new Result(PayEnum.ERR_0016.getCode(),PayEnum.ERR_0016.getMessage());
            }
        }catch (Exception e) {
            _log.error(e, "支付异常");
            return new Result(PayEnum.ERR_0010.getCode(),"支付中心系统异常");
        }
    }

    /**
     * 查询支付订单接口:
     * 1)先验证接口参数以及签名信息
     * 2)根据参数查询订单
     * 3)返回订单数据
     * @param payOrderQueryReq
     * @return
     */
    @Override
    public Result<PayOrderQueryRsp> payOrderQuery(@RequestBody @Validated PayOrderQueryReq payOrderQueryReq) {
        _log.info("###### 开始接收商户查询支付订单请求 ######");
        String logPrefix = "【商户支付订单查询】";
        ServiceInstance instance = client.getLocalServiceInstance();
        _log.info("{}/pay/query_order, host:{}, service_id:{}, params:{}", logPrefix, instance.getHost(), instance.getServiceId(), payOrderQueryReq.toString());
        try {
            JSONObject payContext = new JSONObject();
            // 验证参数有效性
            String errorMessage = validateQueryParams(payOrderQueryReq, payContext);
            if (!"success".equalsIgnoreCase(errorMessage)) {
                _log.warn(errorMessage);
                return new Result(PayEnum.ERR_0010.getCode(),errorMessage);
            }
            _log.debug("请求参数及签名校验通过");
            // 商户Id
            String mchId = payOrderQueryReq.getMchId();
            // 商户订单号
            String mchOrderNo = payOrderQueryReq.getMchOrderNo();
            // 支付订单号
            String payOrderId = payOrderQueryReq.getPayOrderId();
            // 是否执行回调
            String executeNotify = String.valueOf(payOrderQueryReq.isExecuteNotify());

            JSONObject payOrder;
            String retStr = payOrderServiceClient.queryPayOrder(getJsonParam(new String[]{"mchId", "payOrderId", "mchOrderNo", "executeNotify"}, new Object[]{mchId, payOrderId, mchOrderNo, executeNotify}));
            JSONObject retObj = JSON.parseObject(retStr);
            _log.info("{}查询支付订单,结果:{}", logPrefix, retObj);
            if(!"0000".equals(retObj.getString("code"))) {
                return new Result(PayEnum.ERR_0010.getCode(),retObj.getString("msg"));
            }
            payOrder = retObj.getJSONObject("result");
            if (payOrder == null) {
                return new Result(PayEnum.ERR_0112.getCode(),PayEnum.ERR_0112.getMessage());
            }
            _log.info("商户查询订单成功,payOrder={}", payOrder);
            _log.info("###### 商户查询订单处理完成 ######");
            PayOrderQueryRsp payOrderQueryRsp =  JSON.parseObject(payOrder.toJSONString(), PayOrderQueryRsp.class);
            return new Result(payOrderQueryRsp);

        }catch (Exception e) {
            _log.error(e, "查询订单失败！");
            return new Result(PayEnum.ERR_0010.getCode(),"支付中心系统异常");
        }
    }



    /**
     * 验证创建订单请求参数,参数通过返回JSONObject对象,否则返回错误文本信息
     * @param payOrderReq
     * @return
     */
    private Object validatePayParams(PayOrderReq payOrderReq) {
        // 验证请求参数,参数有问题返回错误提示
        String errorMessage;

        if(null == payOrderReq) {
            errorMessage = "request params  payOrderReq is null.";
            return errorMessage;
        }

        //商户ID
        String mchId = payOrderReq.getMchId();
        // 商户订单号
        String mchOrderNo = payOrderReq.getMchOrderNo();
        // 渠道ID
        String channelId = payOrderReq.getChannelId();
        // 支付金额（单位分）
        String amount = payOrderReq.getAmount().toString();
        // 币种
        String currency = PayConstant.PAY_RMB;
        // 客户端IP
        String clientIp = payOrderReq.getClientIp();
        // 设备
        String device = payOrderReq.getDevice();
        // 特定渠道发起时额外参数
        String extra = payOrderReq.getExtra();
        // 扩展参数1
        String param1 = payOrderReq.getParam1();
        // 扩展参数2
        String param2 = payOrderReq.getParam2();
        // 支付结果回调URL
        String notifyUrl = payOrderReq.getNotifyUrl();
        // 商品主题
        String subject = payOrderReq.getSubject();
        // 商品描述信息
        String body = payOrderReq.getBody();


        // 验证请求参数有效性（必选项）
        if(StringUtils.isBlank(mchId)) {
            errorMessage = "request params[mchId] Can't find.";
            return errorMessage;
        }

        if(StringUtils.isBlank(mchOrderNo)) {
            errorMessage = "request params[mchOrderNo] error.";
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
        if(StringUtils.isBlank(subject)) {
            errorMessage = "request params[subject] error.";
            return errorMessage;
        }
        if(StringUtils.isBlank(body)) {
            errorMessage = "request params[body] error.";
            return errorMessage;
        }
        // 根据不同渠道,判断extra参数
        if(ChannelIdEnum.WX_JSAPI.getCode().equalsIgnoreCase(channelId)) {
            if(StringUtils.isEmpty(extra)) {
                errorMessage = "request params[extra] error.";
                return errorMessage;
            }
            JSONObject extraObject = JSON.parseObject(extra);
            String openId = extraObject.getString("openId");
            if(StringUtils.isBlank(openId)) {
                errorMessage = "request params[extra.openId] error.";
                return errorMessage;
            }
        }else if(ChannelIdEnum.WX_NATIVE.getCode().equalsIgnoreCase(channelId)) {
            if(StringUtils.isEmpty(extra)) {
                errorMessage = "request params[extra] error.";
                return errorMessage;
            }
            JSONObject extraObject = JSON.parseObject(extra);
            String productId = extraObject.getString("productId");
            if(StringUtils.isBlank(productId)) {
                errorMessage = "request params[extra.productId] error.";
                return errorMessage;
            }
        }else if(ChannelIdEnum.WX_MWEB.getCode().equalsIgnoreCase(channelId)) {
            if(StringUtils.isEmpty(extra)) {
                errorMessage = "request params[extra] error.";
                return errorMessage;
            }
            JSONObject extraObject = JSON.parseObject(extra);
            String productId = extraObject.getString("sceneInfo");
            if(StringUtils.isBlank(productId)) {
                errorMessage = "request params[extra.sceneInfo] error.";
                return errorMessage;
            }
            if(StringUtils.isBlank(clientIp)) {
                errorMessage = "request params[clientIp] error.";
                return errorMessage;
            }
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

        String reqKey = mchInfo.getString("reqKey");
        if (StringUtils.isBlank(reqKey)) {
            errorMessage = "reqKey is null[mchId="+mchId+"] record in db.";
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

        // 验证参数通过,返回JSONObject对象
        JSONObject payOrder = new JSONObject();
        payOrder.put("payOrderId", MySeq.getPay());
        payOrder.put("mchId", mchId);
        payOrder.put("mchOrderNo", mchOrderNo);
        payOrder.put("channelId", channelId);
        payOrder.put("amount", Long.parseLong(amount));
        payOrder.put("currency", currency);
        payOrder.put("clientIp", clientIp);
        payOrder.put("device", device);
        payOrder.put("subject", subject);
        payOrder.put("body", body);
        payOrder.put("extra", extra);
        payOrder.put("channelMchId", payChannel.getString("channelMchId"));
        payOrder.put("param1", param1);
        payOrder.put("param2", param2);
        payOrder.put("notifyUrl", notifyUrl);
        return payOrder;
    }

    /**
     * 封装统一支付接口返回结果
     * @param jsonParam 统一下单接口返回的参数
     * @param channelIdEnum 渠道ID枚举
    * */
    Result returnResult(String jsonParam, ChannelIdEnum channelIdEnum ){
        if(StringUtils.isBlank(jsonParam)){
            return new Result(PayEnum.ERR_0010.getCode(),PayEnum.ERR_0010.getMessage());
        }
        //转成JSON对象
        JSONObject paramObj = JSON.parseObject(jsonParam);
        //判断通信是否成功
        String retCode = paramObj.getString("retCode");
        if (!retCode.equals(PayConstant.RETURN_VALUE_SUCCESS)){
            String retMsg = paramObj.getString("retMsg");
            return new Result(PayEnum.ERR_0010.getCode(),retMsg);
        }
        //判断业务是否成功
        String resCode = paramObj.getString("resCode");
        if (!resCode.equals(PayConstant.RETURN_VALUE_SUCCESS)){
            String errCode = paramObj.getString("errCode");
            String errCodeDes = paramObj.getString("errCodeDes");
            return new Result(errCode,errCodeDes);
        }

        //根据渠道ID返回对应的实体类
        switch (channelIdEnum) {
                case WX_APP :
                    return  new Result(JSON.parseObject(jsonParam, WxAppPayRsp.class));
                case WX_JSAPI :
                    return  new Result(JSON.parseObject(jsonParam, WxJsapiPayRsp.class));
                case WX_NATIVE :
                    return  new Result(JSON.parseObject(jsonParam, WxNativePayRsp.class));
                case WX_MWEB :
                    return  new Result(JSON.parseObject(jsonParam, WxMwebPayRsp.class));
                case ALIPAY_MOBILE :
                    return  new Result(JSON.parseObject(jsonParam, AlipayMobilePayRsp.class));
                case ALIPAY_PC :
                    return  new Result(JSON.parseObject(jsonParam, AlipayPcPayRsp.class));
                case ALIPAY_WAP :
                    return new Result(JSON.parseObject(jsonParam, AlipayWapPayRsp.class));
            default:
                return new Result(PayEnum.ERR_0010.getCode(),PayEnum.ERR_0010.getMessage());
        }
    }




    /**
     * 验证查询请求参数,参数通过返回success,否则返回错误文本信息
     * @param payOrderQueryReq 查询对象
     * @param payContext
     * @return
     */
    private String validateQueryParams(PayOrderQueryReq payOrderQueryReq, JSONObject payContext) {
        // 验证请求参数,参数有问题返回错误提示
        String errorMessage;

        if(null == payOrderQueryReq ) {
            errorMessage = "request params is null error.";
            return errorMessage;
        }


        // ----------------支付参数------------------------
        //商户ID
        String mchId = payOrderQueryReq.getMchId();
        // 商户订单号
        String mchOrderNo = payOrderQueryReq.getMchOrderNo();
        // 支付订单号
        String payOrderId = payOrderQueryReq.getPayOrderId();

        // 验证请求参数有效性（必选项）
        if(StringUtils.isBlank(mchId)) {
            errorMessage = "request params[mchId] error.";
            return errorMessage;
        }
        if(StringUtils.isBlank(mchOrderNo) && StringUtils.isBlank(payOrderId)) {
            errorMessage = "request params[mchOrderNo or payOrderId] error.";
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
        return "success";
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
