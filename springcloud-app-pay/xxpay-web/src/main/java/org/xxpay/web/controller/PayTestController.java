package org.xxpay.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jn.common.model.Result;
import com.jn.pay.api.PayOrderClient;
import com.jn.pay.api.RefundOrderClient;
import com.jn.pay.enums.ChannelIdEnum;
import com.jn.pay.enums.MchIdEnum;
import com.jn.pay.model.*;
import com.jn.pay.utils.BeanToMap;
import com.jn.pay.utils.PayDigestUtil;
import com.jn.pay.utils.XXPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName：
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/10 14:38
 * @Version： v1.0
 * @Modified By:
 */
@RestController
public class PayTestController {

    @Autowired
    private PayOrderClient payOrderClient;
    @Autowired
    private RefundOrderClient refundOrderClient;

    
    /**
     * 请求下单
    * */
    @RequestMapping("/pay/payOrder")
    @ResponseBody
    public String payOrder(String channelId,Long amount) {

        System.out.println("开始========================");
        PayOrderReq payOrder = new PayOrderReq();
        payOrder.setMchId(MchIdEnum.MCH_BASE.getCode());
        //payOrder.setMchOrderNo(UUID.randomUUID().toString().substring(0,20));
        payOrder.setMchOrderNo("123");
        payOrder.setChannelId(channelId);
        payOrder.setAmount(amount);
        payOrder.setSubject("商品测试标题");
        payOrder.setBody("阳的测试消费");
        payOrder.setParam1("param1");
        //payOrder.setNotifyUrl("http://192.168.10.80:3010/pay/notice");
        payOrder.setServiceId("springcloud-enterprise");
        payOrder.setServiceUrl("/api/payment/payBill/payCallBack");
        payOrder.setAliPayReturnUrl("http://www.taobao.com");
        //生成签名
        payOrder.setSign(PayDigestUtil.getSign(BeanToMap.toMap(payOrder),MchIdEnum.MCH_BASE.getReqKey()));

        //执行下单
        Result<PayOrderRsp> result  =   payOrderClient.createPayOrder(payOrder);

        //验证响应签名
        boolean verifyFlag = XXPayUtil.verifyPaySign(BeanToMap.toMap(result.getData()), MchIdEnum.MCH_BASE.getRspKey());
        if(!verifyFlag) {
            return " 支付验证响应签名失败  fail ！";
        }

        return JSON.parseObject(result.getData().getOrderInfo()).getString("payUrl");

    }



    /**
     * 支付订单查询
     *
    * */
    @RequestMapping("/que/queryOrder")
    @ResponseBody
    public String queryOrder(String payOrderId) {
        PayOrderQueryReq payOrderQueryReq = new PayOrderQueryReq();
        payOrderQueryReq.setPayOrderId(payOrderId);
       // payOrderQueryReq.setExecuteNotify(false);

        payOrderQueryReq.setSign(PayDigestUtil.getSign(BeanToMap.toMap(payOrderQueryReq),MchIdEnum.MCH_BASE.getReqKey()));



        Result<PayOrderQueryRsp>  result= payOrderClient.payOrderQuery(payOrderQueryReq);


        //验证签名  成功返回 true  失败返回 false
        boolean verifyFlag =  XXPayUtil.verifyPaySign(BeanToMap.toMap(result.getData()), MchIdEnum.MCH_BASE.getRspKey());
        if(!verifyFlag){
            return "支付查询响应签名验证不通过========================";
        }

        return JSONObject.toJSON(result).toString();
    }



    /**
     * 退款
     * */
    @RequestMapping("/refund/refundOrder")
    @ResponseBody
    public String refundOrder(String payOrderId) {

        RefundOrderReq refundOrderReq = new RefundOrderReq();
        refundOrderReq.setMchRefundNo(UUID.randomUUID().toString().substring(0,20));
        refundOrderReq.setChannelUser("cldgug1107@sandbox.com");
        //refundOrderReq.setNotifyUrl("http://192.168.10.80:3010/refund/notice");
        refundOrderReq.setServiceId("springcloud-enterprise");
        refundOrderReq.setServiceUrl("/api/payment/payBill/refundCallBack");
        refundOrderReq.setChannelId(ChannelIdEnum.ALIPAY_WAP.getCode());
        refundOrderReq.setAmount(new Long(10000));
        refundOrderReq.setMchId(MchIdEnum.MCH_BASE.getCode());
        refundOrderReq.setPayOrderId(payOrderId);
        refundOrderReq.setParam2("打撒");



        refundOrderReq.setSign(PayDigestUtil.getSign(BeanToMap.toMap(refundOrderReq),MchIdEnum.MCH_BASE.getReqKey()));

        Result<RefundOrderRsp>  result= refundOrderClient.createRefundOrder(refundOrderReq);

        //验证响应签名
        Boolean  resSignIsOk =  XXPayUtil.verifyPaySign(BeanToMap.toMap(result.getData()),"321");
        if(!resSignIsOk){
            return "退款响应签名失败！";
        }


        return JSONObject.toJSON(result).toString();
    }


    /**
     * 支付结果回调通知
    * */
    @RequestMapping("/pay/notice")
    @ResponseBody
    public String payNotice(@ModelAttribute PayOrderNotify payOrderNotify) {

        System.out.println("回调通知结果 ： " + payOrderNotify.toString());

        //验证签名
        Boolean isOk = XXPayUtil.verifyPaySign(BeanToMap.toMap(payOrderNotify),"321");

        if(!isOk){
            return "支付结果回调通知   响应签名验证失败！";
        }

        return payOrderNotify.toString();
    }

    /**
     * 退款结果回调通知
     * */
    @RequestMapping("/refund/notice")
    @ResponseBody
    public String refundNotice(@ModelAttribute RefundOrderNotify refundOrderNotify) {

        System.out.println("回调通知结果 ： " + refundOrderNotify.toString());

        //验证签名
        Boolean isOk = XXPayUtil.verifyPaySign(BeanToMap.toMap(refundOrderNotify),"321");

        if(!isOk){
            return "退款结果回调通知   响应签名验证失败！";
        }

        return refundOrderNotify.toString();
    }


}
