package org.xxpay.service.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.*;
import com.alipay.api.request.*;
import com.alipay.api.response.AlipayTradeRefundResponse;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xxpay.common.constant.AlipayConstant;
import org.xxpay.common.constant.PayConstant;
import org.xxpay.common.constant.PayEnum;
import org.xxpay.common.domain.BaseParam;
import org.xxpay.common.enumm.RetEnum;
import org.xxpay.common.util.*;
import org.xxpay.dal.dao.model.MchInfo;
import org.xxpay.dal.dao.model.PayChannel;
import org.xxpay.dal.dao.model.PayOrder;
import org.xxpay.dal.dao.model.RefundOrder;
import org.xxpay.service.channel.alipay.AlipayConfig;
import org.xxpay.service.service.MchInfoService;
import org.xxpay.service.service.PayChannelService;
import org.xxpay.service.service.PayOrderService;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 支付渠道接口:支付宝
 * @author dingzhiwei jmdhappy@126.com
 * @date 2017-07-05
 * @version V1.0
 * @Copyright: www.xxpay.org
 */
@RestController
public class PayChannel4AlipayController {

    private final MyLog _log = MyLog.getLog(PayChannel4AlipayController.class);

    @Autowired
    private PayOrderService payOrderService;

    @Autowired
    private PayChannelService payChannelService;

    @Autowired
    private AlipayConfig alipayConfig;

    @Autowired
    private MchInfoService mchInfoService;

    /**
     * 支付宝手机网站支付
     * 文档：https://docs.open.alipay.com/203/107090/
     * @param jsonParam
     * @return
     */
    @RequestMapping(value = "/pay/channel/ali_wap")
    public String doAliPayWapReq(@RequestParam String jsonParam) {
        String logPrefix = "【支付宝WAP支付下单】";
        _log.info("###### 开始接收创建" + logPrefix + "请求  ######");

        _log.info("创建订单请求参数  jsonParam(加密) = {}", jsonParam);
        jsonParam = new String(MyBase64.decode(jsonParam));
        _log.info(" 请求参数解密后   jsonParam(解密后) = {}", jsonParam);
        JSONObject paramObj = JSON.parseObject(jsonParam);
        PayOrder payOrder = paramObj.getObject("payOrder", PayOrder.class);
        String payOrderId = payOrder.getPayOrderId();
        String mchId = payOrder.getMchId();
        String channelId = payOrder.getChannelId();
        MchInfo mchInfo = mchInfoService.selectMchInfo(mchId);
        String resKey = mchInfo.getResKey();
        if(StringUtils.isBlank(resKey)) {
            _log.info(" 运营平台的商户响应密钥为空！ 商户ID ： {}",mchId);
            _log.info("###### 结束创建" + logPrefix + "请求  ######");
            return XXPayUtil.makeRetFail(XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_FAIL, "商户的响应密钥为空", PayConstant.RETURN_VALUE_FAIL, PayEnum.ERR_0001));
        }
        //获取支付渠道信息
        PayChannel payChannel = payChannelService.selectPayChannel(channelId, mchId);
        _log.info(" 根据channelId(支付渠道ID) = {}，mchId(商户ID) = {}   获取支付渠道信息： {}",channelId,mchId,payChannel.toString());
        //获取支付宝配置信息
        alipayConfig.init(payChannel.getParam());
        AlipayClient client = new DefaultAlipayClient(alipayConfig.getUrl(), alipayConfig.getApp_id(), alipayConfig.getRsa_private_key(), AlipayConfig.FORMAT, AlipayConfig.CHARSET, alipayConfig.getAlipay_public_key(), AlipayConfig.SIGNTYPE);
        AlipayTradeWapPayRequest alipay_request = new AlipayTradeWapPayRequest();
        // 封装请求支付信息
        AlipayTradeWapPayModel model = new AlipayTradeWapPayModel();
        model.setOutTradeNo(payOrderId);
        model.setSubject(payOrder.getSubject());
        model.setTotalAmount(AmountUtil.convertCent2Dollar(payOrder.getAmount().toString()));
        model.setBody(payOrder.getBody());
        model.setProductCode("QUICK_WAP_PAY");
        model.setStoreId(AlipayConstant.ALIPAY_STORE_ID);
        model.setTimeoutExpress(createTimeoutExpress(payOrder.getDuration()));
        // 获取objParams参数
        String objParams = payOrder.getExtra();
        if (StringUtils.isNotEmpty(objParams)) {
            try {
                JSONObject objParamsJson = JSON.parseObject(objParams);
                if(StringUtils.isNotBlank(objParamsJson.getString("quit_url"))) {
                    model.setQuitUrl(objParamsJson.getString("quit_url"));
                }
            } catch (Exception e) {
                _log.error("{}objParams参数格式错误！", logPrefix);
            }
        }
        alipay_request.setBizModel(model);
        // 设置异步通知地址
        alipay_request.setNotifyUrl(alipayConfig.getNotify_url());
        // 设置同步地址
        alipay_request.setReturnUrl(payOrder.getAliPayReturnUrl());
        _log.info(" 请求支付宝参数 支付网关url = {} ，notifyUrl(回调异步通知地址) = {} ,",alipayConfig.getUrl(),alipay_request.getNotifyUrl());
        String payUrl = null;
        try {
            payUrl = client.pageExecute(alipay_request).getBody();
        } catch (AlipayApiException e) {
            _log.error("订单号：{} 支付下单报错 ",payOrderId,e);
            _log.info("###### 结束创建" + logPrefix + "请求  ######");
            Map<String, Object> map = XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_SUCCESS, "", PayConstant.RETURN_VALUE_FAIL, PayEnum.ERR_0019);
            return XXPayUtil.makeRetData(map, resKey);
        }
        _log.info("{}生成跳转路径：payUrl={}", logPrefix, payUrl);
        payOrderService.updateStatus4Ing(payOrderId, null);

        //----------------------封装返回参数----------------------------------------
        Map<String, Object> map = XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_SUCCESS, "", PayConstant.RETURN_VALUE_SUCCESS, null);
        //支付系统订单ID
        map.put("payOrderId", payOrderId);
        //渠道ID
        map.put("channelId",payOrder.getChannelId());
        //封装orderInfo(发起支付需要的参数JSON格式)
        JSONObject orderInfo = new JSONObject();
        orderInfo.put("payUrl",payUrl);
        map.put("orderInfo",orderInfo.toJSONString());
        _log.info("###### 创建" + logPrefix + "请求处理完成  ######");
        return XXPayUtil.makeRetData(map, resKey);
    }

    /**
     * 支付宝电脑网站支付
     * 文档：https://docs.open.alipay.com/270/105899/
     * @param jsonParam
     * @return
     */
    @RequestMapping(value = "/pay/channel/ali_pc")
    public String doAliPayPcReq(@RequestParam String jsonParam) {
        String logPrefix = "【支付宝PC支付下单】";
        _log.info("###### 开始接收创建" + logPrefix + "请求  ######");

        _log.info("创建订单请求参数  jsonParam(加密) = {}", jsonParam);
        jsonParam = new String(MyBase64.decode(jsonParam));
        _log.info(" 请求参数解密后   jsonParam(解密后) = {}", jsonParam);
        JSONObject paramObj = JSON.parseObject(jsonParam);
        PayOrder payOrder = paramObj.getObject("payOrder", PayOrder.class);
        String payOrderId = payOrder.getPayOrderId();
        String mchId = payOrder.getMchId();
        String channelId = payOrder.getChannelId();
        MchInfo mchInfo = mchInfoService.selectMchInfo(mchId);
        String resKey = mchInfo.getResKey();
        if(StringUtils.isBlank(resKey)) {
            _log.info(" 运营平台的商户响应密钥为空！ 商户ID ： {}",mchId);
            _log.info("###### 结束创建" + logPrefix + "请求  ######");
            return XXPayUtil.makeRetFail(XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_FAIL, "商户的响应密钥为空", PayConstant.RETURN_VALUE_FAIL, PayEnum.ERR_0001));
        }
        //获取支付渠道信息
        PayChannel payChannel = payChannelService.selectPayChannel(channelId, mchId);
        _log.info(" 根据channelId(支付渠道ID) = {}，mchId(商户ID) = {}   获取支付渠道信息： {}",channelId,mchId,payChannel.toString());
        //获取支付宝配置信息
        alipayConfig.init(payChannel.getParam());
        AlipayClient client = new DefaultAlipayClient(alipayConfig.getUrl(), alipayConfig.getApp_id(), alipayConfig.getRsa_private_key(), AlipayConfig.FORMAT, AlipayConfig.CHARSET, alipayConfig.getAlipay_public_key(), AlipayConfig.SIGNTYPE);
        AlipayTradePagePayRequest alipay_request = new AlipayTradePagePayRequest();
        // 封装请求支付信息
        AlipayTradePagePayModel model=new AlipayTradePagePayModel();
        model.setOutTradeNo(payOrderId);
        model.setSubject(payOrder.getSubject());
        model.setTotalAmount(AmountUtil.convertCent2Dollar(payOrder.getAmount().toString()));
        model.setBody(payOrder.getBody());
        model.setProductCode("FAST_INSTANT_TRADE_PAY");
        model.setStoreId(AlipayConstant.ALIPAY_STORE_ID);
        model.setTimeoutExpress(createTimeoutExpress(payOrder.getDuration()));
        // 获取objParams参数
        String objParams = payOrder.getExtra();
        String qr_pay_mode = "2";
        String qrcode_width = "200";
        if (StringUtils.isNotEmpty(objParams)) {
            try {
                JSONObject objParamsJson = JSON.parseObject(objParams);
                qr_pay_mode = ObjectUtils.toString(objParamsJson.getString("qr_pay_mode"), "2");
                qrcode_width = ObjectUtils.toString(objParamsJson.getString("qrcode_width"), "200");
            } catch (Exception e) {
                _log.error("{}objParams参数格式错误！", logPrefix);
            }
        }
        model.setQrPayMode(qr_pay_mode);
        model.setQrcodeWidth(Long.parseLong(qrcode_width));
        alipay_request.setBizModel(model);
        // 设置异步通知地址
        alipay_request.setNotifyUrl(alipayConfig.getNotify_url());
        // 设置同步地址
        alipay_request.setReturnUrl(payOrder.getAliPayReturnUrl());
        _log.info(" 请求支付宝参数 支付网关url = {} ，notifyUrl(回调异步通知地址) = {} ,",alipayConfig.getUrl(),alipay_request.getNotifyUrl());
        String payUrl = null;
        try {
            payUrl = client.pageExecute(alipay_request).getBody();
        } catch (AlipayApiException e) {
            _log.error("订单号：{} 支付下单报错 ",payOrderId,e);
            Map<String, Object> map = XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_SUCCESS, "", PayConstant.RETURN_VALUE_FAIL, PayEnum.ERR_0019);
            _log.info("###### 结束创建" + logPrefix + "请求  ######");
            return XXPayUtil.makeRetData(map, resKey);
        }
        _log.info("{}生成跳转路径：payUrl={}", logPrefix, payUrl);
        payOrderService.updateStatus4Ing(payOrderId, null);


        //----------------------封装返回参数----------------------------------------
        Map<String, Object> map = XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_SUCCESS, "", PayConstant.RETURN_VALUE_SUCCESS, null);
        //支付系统订单ID
        map.put("payOrderId", payOrderId);
        //渠道ID
        map.put("channelId",payOrder.getChannelId());
        //封装orderInfo(发起支付需要的参数JSON格式)
        JSONObject orderInfo = new JSONObject();
        orderInfo.put("payUrl",payUrl);
        map.put("orderInfo",orderInfo.toJSONString());
        _log.info("###### 创建" + logPrefix + "请求处理完成  ######");
        return XXPayUtil.makeRetData(map, resKey);
    }

    /**
     * 支付宝APP支付,生产签名及请求支付宝的参数(注:不会向支付宝发请求)
     * 文档: https://docs.open.alipay.com/204/105465/
     * @param jsonParam
     * @return
     */
    @RequestMapping(value = "/pay/channel/ali_mobile")
    public String doAliPayMobileReq(@RequestParam String jsonParam) {
        String logPrefix = "【支付宝APP支付下单】";
        _log.info("###### 开始接收创建" + logPrefix + "请求  ######");

        _log.info("创建订单请求参数  jsonParam(加密) = {}", jsonParam);
        jsonParam = new String(MyBase64.decode(jsonParam));
        _log.info(" 请求参数解密后   jsonParam(解密后) = {}", jsonParam);
        JSONObject paramObj = JSON.parseObject(jsonParam);
        PayOrder payOrder = paramObj.getObject("payOrder", PayOrder.class);
        String payOrderId = payOrder.getPayOrderId();
        String mchId = payOrder.getMchId();
        String channelId = payOrder.getChannelId();
        MchInfo mchInfo = mchInfoService.selectMchInfo(mchId);
        String resKey = mchInfo.getResKey();
        if(StringUtils.isBlank(resKey)) {
            _log.info(" 运营平台的商户响应密钥为空！ 商户ID ： {}",mchId);
            _log.info("###### 结束创建" + logPrefix + "请求  ######");
            return XXPayUtil.makeRetFail(XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_FAIL, "商户的响应密钥为空", PayConstant.RETURN_VALUE_FAIL, PayEnum.ERR_0001));
        }
        //获取支付渠道信息
        PayChannel payChannel = payChannelService.selectPayChannel(channelId, mchId);
        _log.info(" 根据channelId(支付渠道ID) = {}，mchId(商户ID) = {}   获取支付渠道信息： {}",channelId,mchId,payChannel.toString());
        //获取支付宝配置信息
        alipayConfig.init(payChannel.getParam());
        AlipayClient client = new DefaultAlipayClient(alipayConfig.getUrl(), alipayConfig.getApp_id(), alipayConfig.getRsa_private_key(), AlipayConfig.FORMAT, AlipayConfig.CHARSET, alipayConfig.getAlipay_public_key(), AlipayConfig.SIGNTYPE);
        AlipayTradeAppPayRequest alipay_request = new AlipayTradeAppPayRequest();
        // 封装请求支付信息
        AlipayTradeAppPayModel model=new AlipayTradeAppPayModel();
        model.setOutTradeNo(payOrderId);
        model.setSubject(payOrder.getSubject());
        model.setTotalAmount(AmountUtil.convertCent2Dollar(payOrder.getAmount().toString()));
        model.setBody(payOrder.getBody());
        model.setProductCode("QUICK_MSECURITY_PAY");
        model.setStoreId(AlipayConstant.ALIPAY_STORE_ID);
        model.setTimeoutExpress(createTimeoutExpress(payOrder.getDuration()));
        alipay_request.setBizModel(model);
        // 设置异步通知地址
        alipay_request.setNotifyUrl(alipayConfig.getNotify_url());
        // 设置同步地址
        alipay_request.setReturnUrl(payOrder.getAliPayReturnUrl());
        _log.info(" 请求支付宝参数 支付网关url = {} ，notifyUrl(回调异步通知地址) = {} ,",alipayConfig.getUrl(),alipay_request.getNotifyUrl());
        String payParams = null;
        try {
            payParams = client.pageExecute(alipay_request).getBody();
        } catch (AlipayApiException e) {
            _log.error("订单号：{} 支付下单报错 ",payOrderId,e);
            _log.info("###### 结束创建" + logPrefix + "请求  ######");
            Map<String, Object> map = XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_SUCCESS, "", PayConstant.RETURN_VALUE_FAIL, PayEnum.ERR_0019);
            return XXPayUtil.makeRetData(map, resKey);
        }
        payOrderService.updateStatus4Ing(payOrderId, null);
        _log.info("{}生成请求支付宝数据,payParams={}", logPrefix, payParams);


        //----------------------封装返回参数----------------------------------------
        Map<String, Object> map = XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_SUCCESS, "", PayConstant.RETURN_VALUE_SUCCESS, null);
        //支付系统订单ID
        map.put("payOrderId", payOrderId);
        //渠道ID
        map.put("channelId",payOrder.getChannelId());
        //封装orderInfo(发起支付需要的参数JSON格式)
        JSONObject orderInfo = new JSONObject();
        orderInfo.put("payParams",payParams);
        map.put("orderInfo",orderInfo.toJSONString());
        _log.info("###### 创建" + logPrefix + "请求处理完成  ######");
        return XXPayUtil.makeRetData(map, resKey);


    }

    /**
     * 支付宝当面付之扫码支付
     * 文档：https://docs.open.alipay.com/api_1/alipay.trade.precreate
     * @param jsonParam
     * @return
     */
    @RequestMapping(value = "/pay/channel/ali_qr")
    public String doAliPayQrReq(@RequestParam String jsonParam) {
        String logPrefix = "【支付宝当面付之扫码支付下单】";
        _log.info("###### 开始接收创建" + logPrefix + "请求  ######");

        _log.info("创建订单请求参数  jsonParam(加密) = {}", jsonParam);
        jsonParam = new String(MyBase64.decode(jsonParam));
        _log.info(" 请求参数解密后   jsonParam(解密后) = {}", jsonParam);
        JSONObject paramObj = JSON.parseObject(jsonParam);
        PayOrder payOrder = paramObj.getObject("payOrder", PayOrder.class);
        String payOrderId = payOrder.getPayOrderId();
        String mchId = payOrder.getMchId();
        String channelId = payOrder.getChannelId();
        MchInfo mchInfo = mchInfoService.selectMchInfo(mchId);
        String resKey = mchInfo.getResKey();
        if(StringUtils.isBlank(resKey)) {
            _log.info(" 运营平台的商户响应密钥为空！ 商户ID ： {}",mchId);
            _log.info("###### 结束创建" + logPrefix + "请求  ######");
            return XXPayUtil.makeRetFail(XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_FAIL, "商户的响应密钥为空", PayConstant.RETURN_VALUE_FAIL, PayEnum.ERR_0001));
        }
        //获取支付渠道信息
        PayChannel payChannel = payChannelService.selectPayChannel(channelId, mchId);
        _log.info(" 根据channelId(支付渠道ID) = {}，mchId(商户ID) = {}   获取支付渠道信息： {}",channelId,mchId,payChannel.toString());
        //获取支付宝配置信息
        alipayConfig.init(payChannel.getParam());
        AlipayClient client = new DefaultAlipayClient(alipayConfig.getUrl(), alipayConfig.getApp_id(), alipayConfig.getRsa_private_key(), AlipayConfig.FORMAT, AlipayConfig.CHARSET, alipayConfig.getAlipay_public_key(), AlipayConfig.SIGNTYPE);
        AlipayTradePrecreateRequest alipay_request = new AlipayTradePrecreateRequest();
        // 封装请求支付信息
        AlipayTradePrecreateModel model=new AlipayTradePrecreateModel();
        model.setOutTradeNo(payOrderId);
        model.setSubject(payOrder.getSubject());
        model.setTotalAmount(AmountUtil.convertCent2Dollar(payOrder.getAmount().toString()));
        model.setBody(payOrder.getBody());
        model.setStoreId(AlipayConstant.ALIPAY_STORE_ID);
        model.setTimeoutExpress(createTimeoutExpress(payOrder.getDuration()));
        // 获取objParams参数
        String objParams = payOrder.getExtra();
        if (StringUtils.isNotEmpty(objParams)) {
            try {
                JSONObject objParamsJson = JSON.parseObject(objParams);
                if(StringUtils.isNotBlank(objParamsJson.getString("discountable_amount"))) {
                    //可打折金额
                    model.setDiscountableAmount(objParamsJson.getString("discountable_amount"));
                }
                if(StringUtils.isNotBlank(objParamsJson.getString("undiscountable_amount"))) {
                    //不可打折金额
                    model.setUndiscountableAmount(objParamsJson.getString("undiscountable_amount"));
                }
            } catch (Exception e) {
                _log.error("{}objParams参数格式错误！", logPrefix);
            }
        }
        alipay_request.setBizModel(model);
        // 设置异步通知地址
        alipay_request.setNotifyUrl(alipayConfig.getNotify_url());
        // 设置同步地址
        alipay_request.setReturnUrl(payOrder.getAliPayReturnUrl());
        _log.info(" 请求支付宝参数 支付网关url = {} ，notifyUrl(回调异步通知地址) = {} ,",alipayConfig.getUrl(),alipay_request.getNotifyUrl());
        String payUrl = null;
        try {
            payUrl = client.pageExecute(alipay_request).getBody();
        } catch (AlipayApiException e) {
            _log.error("订单号：{} 支付下单报错 ",payOrderId,e);
            _log.info("###### 结束创建" + logPrefix + "请求  ######");
            Map<String, Object> map = XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_SUCCESS, "", PayConstant.RETURN_VALUE_FAIL, PayEnum.ERR_0019);
            return XXPayUtil.makeRetData(map, resKey);
        }
        _log.info("{}生成跳转路径：payUrl={}", logPrefix, payUrl);
        payOrderService.updateStatus4Ing(payOrderId, null);
        _log.info("{}生成请求支付宝数据,req={}", logPrefix, alipay_request.getBizModel());
        _log.info("###### 商户统一下单处理完成 ######");

        //----------------------封装返回参数----------------------------------------
        Map<String, Object> map = XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_SUCCESS, "", PayConstant.RETURN_VALUE_SUCCESS, null);
        //支付系统订单ID
        map.put("payOrderId", payOrderId);
        //渠道ID
        map.put("channelId",payOrder.getChannelId());
        //封装orderInfo(发起支付需要的参数JSON格式)
        JSONObject orderInfo = new JSONObject();
        orderInfo.put("payUrl",payUrl);
        map.put("orderInfo",orderInfo.toJSONString());
        _log.info("###### 创建" + logPrefix + "请求处理完成  ######");
        return XXPayUtil.makeRetData(map, resKey);

    }


    /**
     *
     * 支付宝退款
     * 文档：https://docs.open.alipay.com/api_1/alipay.trade.refund
     * @param jsonParam
     * @return
     */
    public Map doAliRefundReq(String jsonParam) {
        String logPrefix = "【支付宝退款】";
        //JSON格式转换为对象(refundOrder退款对象)
        BaseParam baseParam = JsonUtil.getObjectFromJson(jsonParam, BaseParam.class);
        Map<String, Object> bizParamMap = baseParam.getBizParamMap();
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
        //退款订单号
        String refundOrderId = refundOrder.getRefundOrderId();
        //获取支付渠道信息
        String mchId = refundOrder.getMchId();
        String channelId = refundOrder.getChannelId();
        PayChannel payChannel = payChannelService.selectPayChannel(channelId, mchId);
        //初始化支付宝配置参数
        alipayConfig.init(payChannel.getParam());
        AlipayClient client = new DefaultAlipayClient(alipayConfig.getUrl(), alipayConfig.getApp_id(), alipayConfig.getRsa_private_key(), AlipayConfig.FORMAT, AlipayConfig.CHARSET, alipayConfig.getAlipay_public_key(), AlipayConfig.SIGNTYPE);
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        AlipayTradeRefundModel model = new AlipayTradeRefundModel();
        model.setOutTradeNo(refundOrder.getPayOrderId());
        model.setTradeNo(refundOrder.getChannelPayOrderNo());
        model.setOutRequestNo(refundOrderId);
        model.setRefundAmount(AmountUtil.convertCent2Dollar(refundOrder.getRefundAmount().toString()));
        model.setRefundReason("正常退款");
        model.setStoreId(AlipayConstant.ALIPAY_STORE_ID);
        request.setBizModel(model);
        Map<String, Object> map = new HashMap<>();
        map.put("refundOrderId", refundOrderId);
        map.put("isSuccess", false);
        try {
            AlipayTradeRefundResponse response = client.execute(request);
            if(response.isSuccess()){
                map.put("isSuccess", true);
                map.put("channelOrderNo", response.getTradeNo());
            }else {
                _log.info("{}返回失败", logPrefix);
                _log.info("sub_code:{},sub_msg:{}", response.getSubCode(), response.getSubMsg());
                map.put("channelErrCode", response.getSubCode());
                map.put("channelErrMsg", response.getSubMsg());
            }
        } catch (AlipayApiException e) {
            _log.error(e, "");
        }
        return RpcUtil.createBizResult(baseParam, map);
    }



    /**
     * 构建订单允许的最晚付款时间，逾期将关闭交易。
     * 取值范围：m-分钟 （支付宝还支持其他单位 ，请查看官方文档，这里只取分钟做单位）
     * 为空则默认为120分钟
     * @param duration 订单有效时长(单位分钟)
     * */
    private String createTimeoutExpress(Integer duration){
        //有效时长
        String  timeoutExpress ;
        if(null != duration){
            timeoutExpress = duration + AlipayConstant.ALIPAY_TIME_UNIT_MINUTE;
        }else{
            timeoutExpress = PayConstant.PAY_ORDER_MAX_DURATION + AlipayConstant.ALIPAY_TIME_UNIT_MINUTE;
        }
        return  timeoutExpress;
    }
}
