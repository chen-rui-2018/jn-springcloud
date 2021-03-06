package org.xxpay.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.pay.api.PayOrderClient;
import com.jn.pay.enums.ChannelIdEnum;
import com.jn.pay.model.PayOrderQueryReq;
import com.jn.pay.model.PayOrderQueryRsp;
import com.jn.pay.model.PayOrderReq;
import com.jn.pay.model.PayOrderRsp;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.xxpay.common.constant.CommonConstants;
import org.xxpay.common.constant.PayConstant;
import org.xxpay.common.constant.PayEnum;
import org.xxpay.common.util.*;
import org.xxpay.dal.dao.model.MchInfo;
import org.xxpay.web.service.MchInfoService;
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
public class PayOrderController extends BaseController implements PayOrderClient {


    private final MyLog _log = MyLog.getLog(PayOrderController.class);

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private PayOrderServiceClient payOrderServiceClient;

    @Autowired
    private PayChannelServiceClient payChannelServiceClient;

    @Autowired
    private MchInfoService mchInfoService;



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
    public Result<PayOrderRsp> createPayOrder(@RequestBody @Validated PayOrderReq payOrderReq) {
        _log.info("###### 开始接收商户统一下单请求 ######");
        String logPrefix = "【商户统一下单】";
        ServiceInstance instance = client.getLocalServiceInstance();
        _log.info("{}/pay/createPayOrder, host:{}, service_id:{}, params:{}", logPrefix, instance.getHost(), instance.getServiceId(), payOrderReq.toString());

        try {

            /** step1  校验参数 **/
            JSONObject payOrder = null;
            // 验证参数有效性
            Object object = validatePayParams(payOrderReq);
            if (object instanceof String) {
                _log.info("{}参数校验不通过:{}", logPrefix, object);
                _log.info("###### 结束商户统一下单请求 ######");
                return new Result(PayEnum.ERR_0014.getCode(),(String)object);
            }
            if (object instanceof JSONObject) {
                payOrder = (JSONObject) object;
            }
            if(payOrder == null) {
                _log.info("{} validatePayParams验证参数方法异常 ：返回payOrder(JSONObject类型) is null" ,logPrefix);
                _log.info("###### 结束商户统一下单请求 ######");
                return new Result(PayEnum.ERR_0010.getCode(),"支付中心下单失败");
            }

            /** step2  创建支付订单 **/
            String resultStr = payOrderServiceClient.createPayOrder(payOrder.toJSONString());
            _log.info("{}创建支付订单,结果:{}", logPrefix, resultStr);
            if(StringUtils.isEmpty(resultStr)) {
                _log.info("{} 创建支付订单失败 service响应结果返回空值! " ,logPrefix);
                _log.info("###### 结束商户统一下单请求 ######");
                return new Result(PayEnum.ERR_0010.getCode(),"创建支付订单失败 service响应结果返回空值!");
            }
            JSONObject resObj = JSON.parseObject(resultStr);
            if(resObj == null || !CommonConstants.SUCCESS_CODE.equals(resObj.getString("code"))) {
                _log.info("{} 创建支付订单失败 service响应结果 = {} " ,resObj.toJSONString());
                _log.info("###### 结束商户统一下单请求 ######");
                return new Result(PayEnum.ERR_0010.getCode(),"创建支付订单失败");
            }

            /** step3  请求第三方支付系统下单 **/
            //获取支付渠道ID
            String channelId = payOrder.getString("channelId");
            //响应密钥
            String resKey = payOrder.getString("resKey");
            //根据支付渠道ID 执行不同的支付方式
            switch (ChannelIdEnum.getCode(channelId)) {
                case WX_APP :
                    String wxAppParam = payOrderServiceClient.doWxPayReq(getJsonParam(new String[]{"tradeType", "payOrder"}, new Object[]{PayConstant.WxConstant.TRADE_TYPE_APP, payOrder}));
                    return returnResult(wxAppParam,resKey);

                case WX_JSAPI :
                    String wxJsapiParam =  payOrderServiceClient.doWxPayReq(getJsonParam(new String[]{"tradeType", "payOrder"}, new Object[]{PayConstant.WxConstant.TRADE_TYPE_JSPAI, payOrder}));
                    return returnResult(wxJsapiParam,resKey);

                case WX_PROGRAM:
                    String wxProgramParam =  payOrderServiceClient.doWxPayReq(getJsonParam(new String[]{"tradeType", "payOrder"}, new Object[]{PayConstant.WxConstant.TRADE_TYPE_JSPAI, payOrder}));
                    return returnResult(wxProgramParam,resKey);

                case WX_NATIVE :
                    String wxNativeParam =  payOrderServiceClient.doWxPayReq(getJsonParam(new String[]{"tradeType", "payOrder"}, new Object[]{PayConstant.WxConstant.TRADE_TYPE_NATIVE, payOrder}));
                    return returnResult(wxNativeParam,resKey);

                case WX_MWEB :
                    String wxMwebParam = payOrderServiceClient.doWxPayReq(getJsonParam(new String[]{"tradeType", "payOrder"}, new Object[]{PayConstant.WxConstant.TRADE_TYPE_MWEB, payOrder}));
                    return returnResult(wxMwebParam,resKey);

                case ALIPAY_MOBILE :
                    String aliPayMobileParam =  payOrderServiceClient.doAliPayMobileReq(getJsonParam("payOrder", payOrder));
                    return returnResult(aliPayMobileParam,resKey);

                case ALIPAY_PC :
                    String jsonParam = payOrderServiceClient.doAliPayPcReq(getJsonParam("payOrder", payOrder));
                    return returnResult(jsonParam,resKey);

                case ALIPAY_WAP :
                   String aliPayWapParam =  payOrderServiceClient.doAliPayWapReq(getJsonParam("payOrder", payOrder));
                   return returnResult(aliPayWapParam,resKey);

                case ALIPAY_QR :
                    String aliPayQrParam =  payOrderServiceClient.doAliPayQrReq(getJsonParam("payOrder", payOrder));
                    return returnResult(aliPayQrParam,resKey);

                default:
                    return new Result(PayEnum.ERR_0016.getCode(),PayEnum.ERR_0016.getMessage());
            }
        }catch (Exception e) {
            _log.error(e, "支付异常");
            _log.info("###### 结束商户统一下单请求 ######");
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
        _log.info("{}/pay/payOrderQuery, host:{}, service_id:{}, params:{}", logPrefix, instance.getHost(), instance.getServiceId(), payOrderQueryReq.toString());
        try {

            /**step1   校验请求参数 **/
            JSONObject payContext = new JSONObject();
            // 验证参数有效性
            String errorMessage = validateQueryParams(payOrderQueryReq, payContext);
            if (!PayConstant.RETURN_VALUE_SUCCESS.equalsIgnoreCase(errorMessage)) {
                _log.info("{} 参数校验不通过 :{}",logPrefix,errorMessage);
                _log.info("###### 结束商户查询支付订单请求 ######");
                return new Result(PayEnum.ERR_0010.getCode(),errorMessage);
            }
            _log.debug("请求参数及签名校验通过");


            /**step2  获取订单信息 **/
            // 支付订单号
            String payOrderId = payOrderQueryReq.getPayOrderId();
            // 是否执行回调
            String executeNotify = String.valueOf(payOrderQueryReq.getExecuteNotify());

            JSONObject payOrder;
            String retStr = payOrderServiceClient.queryPayOrder(getJsonParam(new String[]{"payOrderId", "executeNotify"}, new Object[]{payOrderId, executeNotify}));
            JSONObject retObj = JSON.parseObject(retStr);
            _log.info("{}查询支付订单,结果:{}", logPrefix, retObj);
            if(!GlobalConstants.SUCCESS_CODE.equals(retObj.getString("code"))) {
                _log.info("{} 请求service获取订单信息失败 retObj = {}",logPrefix,retObj.toJSONString());
                _log.info("###### 结束商户查询支付订单请求 ######");
                return new Result(PayEnum.ERR_0010.getCode(),retObj.getString("msg"));
            }
            payOrder = retObj.getJSONObject("result");
            if (payOrder == null) {
                _log.info("{} 请求service获取订单信息为空 retObj = {}",logPrefix,retObj.toJSONString());
                _log.info("###### 结束商户查询支付订单请求 ######");
                return new Result(PayEnum.ERR_0112.getCode(),PayEnum.ERR_0112.getMessage());
            }

            PayOrderQueryRsp payOrderQueryRsp =  JSON.parseObject(payOrder.toJSONString(), PayOrderQueryRsp.class);
            //生成响应签名
            String sign = PayDigestUtil.getSign(BeanToMap.toMap(payOrderQueryRsp), payContext.getString("resKey"), PayConstant.RESULT_PARAM_SIGN);
            payOrderQueryRsp.setSign(sign);

            _log.info("商户查询订单成功,payOrderQueryRsp = {}", payOrderQueryRsp);
            _log.info("###### 商户查询订单处理完成 ######");
            return new Result(payOrderQueryRsp);

        }catch (Exception e) {
            _log.error(e, "查询订单失败！");
            _log.info("###### 结束商户查询支付订单请求 ######");
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
        String errorMessage = "";

        if(null == payOrderReq) {
            errorMessage = "request params  payOrderReq is null.";
            return errorMessage;
        }

        // 商户ID
        String mchId = payOrderReq.getMchId();
        // 商户订单号
        String mchOrderNo = payOrderReq.getMchOrderNo();
        // 渠道ID
        String channelId = payOrderReq.getChannelId();
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
        // springCloud 回调服务的ID
        String serviceId = payOrderReq.getServiceId();
        // springCloud 回调服务的URL
        String serviceUrl = payOrderReq.getServiceUrl();
        // 商品主题
        String subject = payOrderReq.getSubject();
        // 商品描述信息
        String body = payOrderReq.getBody();
        //签名
        String sign = payOrderReq.getSign();
        //支付宝支付完成的跳转页面
        String aliPayReturnUrl = payOrderReq.getAliPayReturnUrl();
        //订单最晚付款时长
        Integer duration = payOrderReq.getDuration();

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
        if(null == payOrderReq.getAmount() || payOrderReq.getAmount() <= 0){
            errorMessage = "request params[amount] error：支付金额必须大于0";
            return errorMessage;
        }

        // notifyUrl如果为空,serviceId和serviceUrl为必传
        //serviceId和serviceUrl如果为空,notifyUrl为必传
        if(StringUtils.isBlank(notifyUrl) && (StringUtils.isBlank(serviceId) || StringUtils.isBlank(serviceUrl))) {
            errorMessage = "request params[notifyUrl or (serviceId and serviceUrl)] is null ";
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
        if(ChannelIdEnum.WX_JSAPI.getCode().equalsIgnoreCase(channelId)
        || ChannelIdEnum.WX_PROGRAM.getCode().equalsIgnoreCase(channelId)) {
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
        // 签名信息
        if (StringUtils.isEmpty(sign)) {
            errorMessage = "request params[sign] error.";
            return errorMessage;
        }
        //订单最晚付款时长
        if(null != payOrderReq.getDuration()){
            if(duration > PayConstant.PAY_ORDER_MAX_DURATION){
                errorMessage = "request params[duration] 订单最晚付款时长超出120分钟";
                return errorMessage;
            }else if(duration < PayConstant.PAY_ORDER_MIN_DURATION){
                errorMessage = "request params[duration] 订单最晚付款时长不能小于一分钟";
                return errorMessage;
            }
        }


        // 查询商户信息
        MchInfo mchInfo = mchInfoService.getMchInfoById(mchId);
        if(null == mchInfo){
            errorMessage = "Can't found mchInfo[mchId="+mchId+"] record in db.";
            return errorMessage;
        }
        if(mchInfo.getState() != 1){
            errorMessage = "mchInfo not available [mchId="+mchId+"] record in db.";
            return errorMessage;
        }

        if(StringUtils.isBlank(mchInfo.getReqKey())){
             errorMessage = "reqKey is null[mchId="+mchId+"] record in db.";
            return errorMessage;
        }
        //请求密钥
        String reqKey = mchInfo.getReqKey();


        //查询返回结果
        String retStr;
        //JSONObject对象
        JSONObject retObj;

        // 查询商户对应的支付渠道
        JSONObject payChannel;
        retStr = payChannelServiceClient.selectPayChannel(getJsonParam(new String[]{"channelId", "mchId"}, new String[]{channelId, mchId}));
        retObj = JSON.parseObject(retStr);
        if(GlobalConstants.SUCCESS_CODE.equals(retObj.getString("code"))) {
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

        // 验证签名数据
        boolean verifyFlag = XXPayUtil.verifyPaySign(BeanToMap.toMap(payOrderReq), reqKey);
        if(!verifyFlag) {
            errorMessage = "Verify XX pay sign failed.";
            return errorMessage;
        }

        // 验证参数通过,返回JSONObject对象
        JSONObject payOrder = new JSONObject();
        payOrder.put("payOrderId", MySeq.getPay());
        payOrder.put("mchId", mchId);
        payOrder.put("mchOrderNo", mchOrderNo);
        payOrder.put("channelId", channelId);
        payOrder.put("amount", payOrderReq.getAmount());
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
        payOrder.put("serviceId", serviceId);
        payOrder.put("serviceUrl", serviceUrl);
        //响应密钥
        payOrder.put("resKey",mchInfo.getResKey());
        payOrder.put("aliPayReturnUrl",aliPayReturnUrl);
        payOrder.put("duration",duration);

        return payOrder;
    }

    /**
     * 封装统一支付接口返回结果
     * @param jsonParam 统一下单接口返回的参数
     * @[aram resKey 请求密钥(用于生成签名)
    * */
    Result returnResult(String jsonParam,String resKey ){
        if(StringUtils.isBlank(jsonParam)){
            _log.info(" 第三方支付系统下单失败 service响应结果 jsonParam is null ");
            _log.info("###### 结束商户统一下单请求 ######");
            return new Result(PayEnum.ERR_0010.getCode(),PayEnum.ERR_0010.getMessage());
        }
        //转成JSON对象
        JSONObject paramObj = JSON.parseObject(jsonParam);
        //判断通信是否成功
        String retCode = paramObj.getString("retCode");
        if (!retCode.equals(PayConstant.RETURN_VALUE_SUCCESS)){
            String retMsg = paramObj.getString("retMsg");
            _log.info(" 第三方支付系统下单失败 service通信响应结果 :{} ",paramObj.toJSONString());
            _log.info("###### 结束商户统一下单请求 ######");
            return new Result(PayEnum.ERR_0010.getCode(),retMsg);
        }
        //判断业务是否成功
        String resCode = paramObj.getString("resCode");
        if (!resCode.equals(PayConstant.RETURN_VALUE_SUCCESS)){
            String errCode = paramObj.getString("errCode");
            String errCodeDes = paramObj.getString("errCodeDes");
            _log.info(" 第三方支付系统下单失败 service业务响应结果 :{} ",paramObj.toJSONString());
            _log.info("###### 结束商户统一下单请求 ######");
            return new Result(errCode,errCodeDes);
        }

        //JSON字符串转对象
        PayOrderRsp payOrderRsp = JSON.parseObject(jsonParam, PayOrderRsp.class);
        //生成响应签名
        String sign =  PayDigestUtil.getSign(BeanToMap.toMap(payOrderRsp), resKey,PayConstant.RESULT_PARAM_SIGN);
        payOrderRsp.setSign(sign);

        _log.info("  第三方支付系统下单成功 响应结果 payOrderRsp = {} " ,payOrderRsp.toString());
        _log.info("###### 商户统一下单请求处理完成 ######");
        return  new Result(payOrderRsp);
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
        // 支付订单号
        String payOrderId = payOrderQueryReq.getPayOrderId();
        // 签名
        String sign = payOrderQueryReq.getSign();


        if(StringUtils.isBlank(payOrderId)) {
            errorMessage = "request params[payOrderId] error.";
            return errorMessage;
        }
        // 签名信息
        if (StringUtils.isEmpty(sign)) {
            errorMessage = "request params[sign] error.";
            return errorMessage;
        }

        // 查询商户信息
        MchInfo mchInfo = mchInfoService.getMchInfoByPayOrderId(payOrderId);
        if(null == mchInfo){
            errorMessage = "Can't found mchInfo[payOrderId="+payOrderId+"] record in db.";
            return errorMessage;
        }
        if(mchInfo.getState() != 1){
            errorMessage = "mchInfo not available [payOrderId="+payOrderId+"] record in db.";
            return errorMessage;
        }
        if(StringUtils.isBlank(mchInfo.getReqKey())){
            errorMessage = "reqKey is null[payOrderId="+payOrderId+"] record in db.";
            return errorMessage;
        }

        //商户的请求密钥
        String reqKey = mchInfo.getReqKey();
        //商户的响应密钥
        String resKey = mchInfo.getResKey();
        payContext.put("resKey", resKey);

        // 验证签名数据
        boolean verifyFlag = XXPayUtil.verifyPaySign(BeanToMap.toMap(payOrderQueryReq), reqKey);
        if(!verifyFlag) {
            errorMessage = "Verify XX pay sign failed.";
            return errorMessage;
        }

        return PayConstant.RETURN_VALUE_SUCCESS;
    }





}
