package org.xxpay.service.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.binarywang.wxpay.bean.request.WxPayRefundRequest;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderResult;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.constant.WxPayConstants;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import com.github.binarywang.wxpay.util.SignUtils;
import com.jn.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xxpay.common.constant.PayConstant;
import org.xxpay.common.constant.PayEnum;
import org.xxpay.common.domain.BaseParam;
import org.xxpay.common.enumm.RetEnum;
import org.xxpay.common.util.*;
import org.xxpay.dal.dao.model.MchInfo;
import org.xxpay.dal.dao.model.PayChannel;
import org.xxpay.dal.dao.model.PayOrder;
import org.xxpay.dal.dao.model.RefundOrder;
import org.xxpay.service.channel.wechat.WxPayProperties;
import org.xxpay.service.channel.wechat.WxPayUtil;
import org.xxpay.service.service.MchInfoService;
import org.xxpay.service.service.PayChannelService;
import org.xxpay.service.service.PayOrderService;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 支付渠道接口:微信
 * @author dingzhiwei jmdhappy@126.com
 * @date 2017-07-05
 * @version V1.0
 * @Copyright: www.xxpay.org
 */
@RestController
public class PayChannel4WxController{

    private final MyLog _log = MyLog.getLog(PayChannel4WxController.class);

    @Autowired
    private PayOrderService payOrderService;

    @Autowired
    private PayChannelService payChannelService;

    @Autowired
    private MchInfoService mchInfoService;

    @Resource
    private WxPayProperties wxPayProperties;

    /**
     * 发起微信支付(统一下单)
     * @return
     */
    @RequestMapping(value = "/pay/channel/wx")
    public String doWxPayReq(@RequestParam String jsonParam) {
        String logPrefix = "【微信支付统一下单】";
        _log.info("###### 开始接收" + logPrefix + "请求  ######");
        _log.info("创建订单请求参数  jsonParam(加密) = {}", jsonParam);
        try{
            //解密请求参数
            jsonParam = new String(MyBase64.decode(jsonParam));
            _log.info(" 请求参数解密后   jsonParam(解密后) = {}", jsonParam);
            JSONObject paramObj = JSON.parseObject(jsonParam);
            PayOrder payOrder = paramObj.getObject("payOrder", PayOrder.class);
            String tradeType = paramObj.getString("tradeType");
            String mchId = payOrder.getMchId();
            String channelId = payOrder.getChannelId();
            MchInfo mchInfo = mchInfoService.selectMchInfo(mchId);
            String resKey = mchInfo.getResKey();
            if(StringUtils.isBlank(resKey)) {
                _log.info(" 运营平台的商户响应密钥为空！ 商户ID ： {}",mchId);
                _log.info("###### 结束" + logPrefix + "请求  ######");
                return XXPayUtil.makeRetFail(XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_FAIL, "商户的响应密钥为空！", PayConstant.RETURN_VALUE_FAIL, PayEnum.ERR_0001));
            }
            //获取支付渠道信息
            PayChannel payChannel = payChannelService.selectPayChannel(channelId, mchId);
            _log.info(" 根据channelId(支付渠道ID) = {}，mchId(商户ID) = {}   获取支付渠道信息： {}",channelId,mchId,payChannel.toString());
            //获取微信支付配置
            WxPayConfig wxPayConfig = WxPayUtil.getWxPayConfig(payChannel.getParam(), tradeType, wxPayProperties.getCertRootPath(), wxPayProperties.getNotifyUrl());
            //封装参数并且请求微信支付
            WxPayService wxPayService = new WxPayServiceImpl();
            wxPayService.setConfig(wxPayConfig);
            WxPayUnifiedOrderRequest wxPayUnifiedOrderRequest = buildUnifiedOrderRequest(payOrder, wxPayConfig);
            String payOrderId = payOrder.getPayOrderId();
            WxPayUnifiedOrderResult wxPayUnifiedOrderResult;
            try {
                wxPayUnifiedOrderResult = wxPayService.unifiedOrder(wxPayUnifiedOrderRequest);
                _log.info("{} >>> 下单成功   ", logPrefix);

                //更新订单状态
                int result = payOrderService.updateStatus4Ing(payOrderId, wxPayUnifiedOrderResult.getPrepayId());
                _log.info("更新第三方支付订单号:payOrderId={},prepayId={},result={}", payOrderId, wxPayUnifiedOrderResult.getPrepayId(), result);

                //----------------------封装返回参数----------------------------------------
                Map<String, Object> map = XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_SUCCESS, "", PayConstant.RETURN_VALUE_SUCCESS, null);
                map.put("payOrderId", payOrderId);
                map.put("channelId", payOrder.getChannelId());
                //封装orderInfo(发起支付需要的参数JSON格式)
                JSONObject orderInfo = new JSONObject();
                //预支付会话ID
                orderInfo.put("prepayId",wxPayUnifiedOrderResult.getPrepayId());

                switch (tradeType) {
                    case PayConstant.WxConstant.TRADE_TYPE_NATIVE : {
                        // 二维码支付链接
                        orderInfo.put("codeUrl",wxPayUnifiedOrderResult.getCodeURL());
                        break;
                    }
                    case PayConstant.WxConstant.TRADE_TYPE_APP : {
                        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
                        String nonceStr = String.valueOf(System.currentTimeMillis());
                        // APP支付绑定的是微信开放平台上的账号，APPID为开放平台上绑定APP后发放的参数
                        String appId = wxPayConfig.getAppId();
                        Map<String, String> configMap = new HashMap<>();
                        // 此map用于参与调起sdk支付的二次签名,格式全小写，timestamp只能是10位,格式固定，切勿修改
                        String partnerId = wxPayConfig.getMchId();
                        configMap.put("prepayid", wxPayUnifiedOrderResult.getPrepayId());
                        configMap.put("partnerid", partnerId);
                        String packageValue = "Sign=WXPay";
                        configMap.put("package", packageValue);
                        configMap.put("timestamp", timestamp);
                        configMap.put("noncestr", nonceStr);
                        configMap.put("appid", appId);
                        // 此信息用于客户端与微信服务器交互
                        orderInfo.put("paySign", SignUtils.createSign(configMap, wxPayConfig.getMchKey(), null));
                        orderInfo.put("partnerId", partnerId);
                        orderInfo.put("appId", appId);
                        orderInfo.put("packageValue", packageValue);
                        orderInfo.put("timeStamp", timestamp);
                        orderInfo.put("nonceStr", nonceStr);
                        break;
                    }
                    case PayConstant.WxConstant.TRADE_TYPE_JSPAI : {
                        Map<String, String> payInfoMap = new HashMap<>();
                        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
                        String nonceStr = String.valueOf(System.currentTimeMillis());
                        //=================此map用来签名=================================
                        payInfoMap.put("appId", wxPayUnifiedOrderResult.getAppid());
                        payInfoMap.put("timeStamp", timestamp);
                        payInfoMap.put("nonceStr", nonceStr);
                        payInfoMap.put("package", "prepay_id=" + wxPayUnifiedOrderResult.getPrepayId());
                        payInfoMap.put("signType", WxPayConstants.SignType.MD5);

                        //=========此JSON用来返回前台参数================
                        orderInfo.put("appId", wxPayUnifiedOrderResult.getAppid());
                        // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
                        orderInfo.put("timeStamp", timestamp);
                        orderInfo.put("nonceStr", nonceStr);
                        orderInfo.put("packageValue", "prepay_id=" + wxPayUnifiedOrderResult.getPrepayId());
                        orderInfo.put("signType", WxPayConstants.SignType.MD5);
                        //生成签名
                        orderInfo.put("paySign", SignUtils.createSign(payInfoMap, wxPayConfig.getMchKey(), null));
                        break;
                    }
                    case PayConstant.WxConstant.TRADE_TYPE_MWEB : {
                        // h5支付链接地址
                        orderInfo.put("payUrl", wxPayUnifiedOrderResult.getMwebUrl());
                        break;
                    }
                }

                map.put("orderInfo",orderInfo.toJSONString());
                _log.info("###### " + logPrefix + "处理完成  ######");
                return XXPayUtil.makeRetData(map, resKey);
            } catch (WxPayException e) {
                _log.error(e, logPrefix + "下单失败");
                //出现业务错误
                _log.info("{}下单返回失败", logPrefix);
                _log.info("微信错误码  err_code:{}", e.getErrCode());
                _log.info("微信错误描述 err_code_des:{}", e.getErrCodeDes());
                _log.info("###### 结束" + logPrefix + "请求  ######");
                return XXPayUtil.makeRetData(XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_SUCCESS, "", PayConstant.RETURN_VALUE_FAIL, "0111", "调用微信支付失败," + e.getErrCode() + ":" + e.getErrCodeDes()), resKey);
            }
        }catch (Exception e) {
            _log.error(e, "微信支付统一下单异常");
            _log.info("###### 结束" + logPrefix + "请求  ######");
            return XXPayUtil.makeRetFail(XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_FAIL, "微信支付统一下单异常", PayConstant.RETURN_VALUE_FAIL, PayEnum.ERR_0010));
        }
    }

    /**
     * 发起微信退款
     * @param jsonParam
    * */
    public Map doWxRefundReq(String jsonParam) {
        String logPrefix = "【微信退款】";
        BaseParam baseParam = JsonUtil.getObjectFromJson(jsonParam, BaseParam.class);
        Map<String, Object> bizParamMap = baseParam.getBizParamMap();
        try{
            if (ObjectValidUtil.isInvalid(bizParamMap)) {
                _log.warn("{}失败, {}. jsonParam={}", logPrefix, RetEnum.RET_PARAM_NOT_FOUND.getMessage(), jsonParam);
                return RpcUtil.createFailResult(baseParam, RetEnum.RET_PARAM_NOT_FOUND);
            }
            JSONObject refundOrderObj = baseParam.isNullValue("refundOrder") ? null : JSONObject.parseObject(bizParamMap.get("refundOrder").toString());
            RefundOrder refundOrder = JSON.toJavaObject(refundOrderObj, RefundOrder.class);
            if (ObjectValidUtil.isInvalid(refundOrder)) {
                _log.warn("{}失败, {}. jsonParam={}", logPrefix, RetEnum.RET_PARAM_INVALID.getMessage(), jsonParam);
                return RpcUtil.createFailResult(baseParam, RetEnum.RET_PARAM_INVALID);
            }
            //获取支付渠道信息
            String mchId = refundOrder.getMchId();
            String channelId = refundOrder.getChannelId();
            PayChannel payChannel = payChannelService.selectPayChannel(channelId, mchId);
            //封装微信请求参数
            WxPayConfig wxPayConfig = WxPayUtil.getWxPayConfig(payChannel.getParam(), "", wxPayProperties.getCertRootPath(), wxPayProperties.getNotifyUrl());
            WxPayService wxPayService = new WxPayServiceImpl();
            wxPayService.setConfig(wxPayConfig);
            WxPayRefundRequest wxPayRefundRequest = buildWxPayRefundRequest(refundOrder, wxPayConfig);
            String refundOrderId = refundOrder.getRefundOrderId();
            Map<String, Object> map = new HashMap<>();
            WxPayRefundResult result;
            try {
                result = wxPayService.refund(wxPayRefundRequest);
                _log.info("{} >>> 下单成功", logPrefix);
                map.put("isSuccess", true);
                map.put("refundOrderId", refundOrderId);
                map.put("channelOrderNo", result.getRefundId());
            } catch (WxPayException e) {
                _log.error(e, "下单失败");
                //出现业务错误
                _log.info("{}下单返回失败", logPrefix);
                _log.info("err_code:{}", e.getErrCode());
                _log.info("err_code_des:{}", e.getErrCodeDes());
                map.put("isSuccess", false);
                map.put("channelErrCode", e.getErrCode());
                map.put("channelErrMsg", e.getErrCodeDes());
            }
            return RpcUtil.createBizResult(baseParam, map);
        }catch (Exception e) {
            _log.error(e, "微信退款异常");
            return RpcUtil.createFailResult(baseParam, RetEnum.RET_BIZ_WX_PAY_CREATE_FAIL);
        }
    }

    /**
     * 构建微信退款请求数据
     * @param refundOrder
     * @param wxPayConfig
     * @return
     */
    WxPayRefundRequest buildWxPayRefundRequest(RefundOrder refundOrder, WxPayConfig wxPayConfig) {
        // 微信退款请求对象
        WxPayRefundRequest request = new WxPayRefundRequest();
        request.setTransactionId(refundOrder.getChannelPayOrderNo());
        request.setOutTradeNo(refundOrder.getPayOrderId());
        request.setDeviceInfo(refundOrder.getDevice());
        request.setOutRefundNo(refundOrder.getRefundOrderId());
        request.setRefundDesc(refundOrder.getRemarkInfo());
        request.setRefundFee(refundOrder.getRefundAmount().intValue());
        request.setRefundFeeType("CNY");
        request.setTotalFee(refundOrder.getPayAmount().intValue());
        return request;
    }

    /**
     * 构建微信统一下单请求数据
     * @param payOrder
     * @param wxPayConfig
     * @return
     */
    WxPayUnifiedOrderRequest buildUnifiedOrderRequest(PayOrder payOrder, WxPayConfig wxPayConfig) {
        String tradeType = wxPayConfig.getTradeType();
        String payOrderId = payOrder.getPayOrderId();
        Integer totalFee = payOrder.getAmount().intValue();// 支付金额,单位分
        String deviceInfo = payOrder.getDevice();
        String body = payOrder.getBody();
        String detail = null;
        String attach = null;
        String outTradeNo = payOrderId;
        String feeType = "CNY";
        //终端IP
        String spBillCreateIP ;
        if(StringUtils.isBlank(payOrder.getClientIp())){
            spBillCreateIP = XXPayUtil.getHostAddress();
        }else{
            spBillCreateIP = payOrder.getClientIp();
        }

        String timeStart = null;
        //订单失效时间，格式为yyyyMMddHHmmss
        String timeExpire = createTimeExpire(payOrder.getDuration());
        String goodsTag = null;
        String notifyUrl = wxPayConfig.getNotifyUrl();
        String productId = null;
        if(tradeType.equals(PayConstant.WxConstant.TRADE_TYPE_NATIVE)) {
            productId = JSON.parseObject(payOrder.getExtra()).getString("productId");
        }
        String limitPay = null;
        String openId = null;
        if(tradeType.equals(PayConstant.WxConstant.TRADE_TYPE_JSPAI) ) {
            openId = JSON.parseObject(payOrder.getExtra()).getString("openId");
        }
        String sceneInfo = null;
        if(tradeType.equals(PayConstant.WxConstant.TRADE_TYPE_MWEB)) {
            sceneInfo = JSON.parseObject(payOrder.getExtra()).getString("sceneInfo");
        }
        // 微信统一下单请求对象
        WxPayUnifiedOrderRequest request = new WxPayUnifiedOrderRequest();
        request.setDeviceInfo(deviceInfo);
        request.setBody(body);
        request.setDetail(detail);
        request.setAttach(attach);
        request.setOutTradeNo(outTradeNo);
        request.setFeeType(feeType);
        request.setTotalFee(totalFee);
        request.setSpbillCreateIp(spBillCreateIP);
        request.setTimeStart(timeStart);
        request.setTimeExpire(timeExpire);
        request.setGoodsTag(goodsTag);
        request.setNotifyURL(notifyUrl);
        request.setTradeType(tradeType);
        request.setProductId(productId);
        request.setLimitPay(limitPay);
        request.setOpenid(openId);
        request.setSceneInfo(sceneInfo);

        return request;
    }

    /**
     * 构建订单失效时间，格式为yyyyMMddHHmmss
     * @param duration 订单有效时长(单位分钟)
    * */
    private String createTimeExpire(Integer duration){
        //1.获取当前时间
        long currentTime = System.currentTimeMillis() ;
        // 2、在这个基础上加上有效时长分钟：
        if(null == duration){
            duration = PayConstant.PAY_ORDER_MAX_DURATION;
        }
        currentTime += duration * 60 * 1000;
        //3、格式化时间，获取到的就是当前时间加有效时长之后的时间
        Date date = new Date(currentTime);
        // 4、建立时间格式化对象：
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return  dateFormat.format(date);
    }
}
