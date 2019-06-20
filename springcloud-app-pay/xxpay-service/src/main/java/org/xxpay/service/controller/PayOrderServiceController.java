package org.xxpay.service.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xxpay.common.constant.CommonConstants;
import org.xxpay.common.constant.PayConstant;
import org.xxpay.common.constant.PayEnum;
import org.xxpay.common.util.MyBase64;
import org.xxpay.common.util.MyLog;
import org.xxpay.dal.dao.model.PayOrder;
import org.xxpay.service.service.PayOrderService;

/**
 * @Description: 支付订单接口
 * @author dingzhiwei jmdhappy@126.com
 * @date 2017-07-05
 * @version V1.0
 * @Copyright: www.xxpay.org
 */
@RestController
public class PayOrderServiceController extends Notify4BasePay {

    private final MyLog _log = MyLog.getLog(PayOrderServiceController.class);

    @Autowired
    private PayOrderService payOrderService;

    @RequestMapping(value = "/pay/create")
    public String createPayOrder(@RequestParam String jsonParam) {
        _log.info("###### 开始接收创建订单请求  ######");
        _log.info("创建订单请求参数jsonParam(加密)={}", jsonParam);

        JSONObject retObj = new JSONObject();
        if(StringUtils.isBlank(jsonParam)) {
            retObj.put("code", PayEnum.ERR_0014.getCode());
            retObj.put("msg", "参数为空");
            _log.info("返回响应参数   retObj = {}",retObj.toJSONString());
            _log.info("###### 结束接收创建订单请求  ######");
            return retObj.toJSONString();
        }
        try {
            //解密请求参数
            String decryptionParam = new String(MyBase64.decode(jsonParam));
            _log.info(" 请求参数解密为 decryptionParam = {}", decryptionParam);
            PayOrder payOrder = JSON.parseObject(decryptionParam, PayOrder.class);
            int result = payOrderService.createPayOrder(payOrder);
            if(1 == result){
                retObj.put("code", CommonConstants.SUCCESS_CODE);
                retObj.put("msg", "支付订单创建成功!");
            }else{
                retObj.put("code", PayEnum.ERR_0118.getCode());
                retObj.put("msg", "DB操作错误 result = " + result);
            }

        }catch (Exception e) {
            _log.info("创建支付订单失败： {}", e.getMessage());
            retObj.put("code", PayEnum.ERR_0010.getCode());
            retObj.put("msg", "创建支付订单失败");
        }
        _log.info("返回响应参数   retObj = {}",retObj.toJSONString());
        _log.info("###### 结束接收创建订单请求  ######");
        return retObj.toJSONString();
    }

    @RequestMapping(value = "/pay/query")
    public String queryPayOrder(@RequestParam String jsonParam) {
        _log.info("<==查询支付订单 start==> ,jsonParam(加密)={}", jsonParam);
        JSONObject retObj = new JSONObject();
        retObj.put("code", CommonConstants.SUCCESS_CODE);
        if(StringUtils.isBlank(jsonParam)) {
            // 参数错误
            retObj.put("code", PayEnum.ERR_0014.getCode());
            retObj.put("msg", "缺少参数");
            return retObj.toJSONString();
        }
        JSONObject paramObj = JSON.parseObject(new String(MyBase64.decode(jsonParam)));
        _log.info("jsonParam(解密后)={}", paramObj.toJSONString());
        String payOrderId = paramObj.getString("payOrderId");
        PayOrder payOrder = payOrderService.selectPayOrder(payOrderId);

        if(payOrder == null) {
            retObj.put("code", PayEnum.ERR_0112.getCode());
            retObj.put("msg", "支付订单不存在");
            return retObj.toJSONString();
        }
        _log.info("根据 payOrderId获取订单信息 payOrderId(订单ID)={}，payOrder(订单对象)={}",payOrderId,payOrder.toString());

        //
        boolean executeNotify = paramObj.getBooleanValue("executeNotify");
        // 如果选择回调且支付状态为支付成功,则回调业务系统
        if(executeNotify && payOrder.getStatus() == PayConstant.PAY_STATUS_SUCCESS) {
            this.doNotify(payOrder,true);
        }
        retObj.put("result", JSON.toJSON(payOrder));
        _log.info("#==查询支付订单  end==# 返回结果>> {}", retObj);
        return retObj.toJSONString();
    }

}
