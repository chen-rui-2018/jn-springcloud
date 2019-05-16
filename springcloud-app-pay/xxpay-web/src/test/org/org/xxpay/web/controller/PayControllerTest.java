package org.xxpay.web.controller;

import com.jn.common.model.Result;
import com.jn.pay.api.PayOrderClient;
import com.jn.pay.api.RefundOrderClient;
import com.jn.pay.enums.ChannelIdEnum;
import com.jn.pay.enums.MchIdEnum;
import com.jn.pay.model.*;
import com.jn.pay.model.alipay.AlipayWapPayRsp;
import com.jn.pay.utils.BeanToMap;
import com.jn.pay.utils.PayDigestUtil;
import com.jn.pay.utils.XXPayUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * @ClassName：
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/9 10:55
 * @Version： v1.0
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PayControllerTest {

    @Autowired
    private PayOrderClient payOrderClient;
    @Autowired
    private RefundOrderClient refundOrderClient;


    /**
     *创建支付订单
    * */
    @Test
    public void createPayOrder() {

        /*******step 1 封装参数 ********/
        System.out.println("开始支付下单========================");
        PayOrderReq payOrder = new PayOrderReq();
        payOrder.setMchId(MchIdEnum.MCH_BASE.getCode());
        //payOrder.setMchOrderNo(UUID.randomUUID().toString().substring(0,20));
        payOrder.setMchOrderNo("123");
        payOrder.setChannelId(ChannelIdEnum.ALIPAY_WAP.getCode());
        payOrder.setAmount(10000L);
        payOrder.setSubject("商品测试标题");
        payOrder.setBody("阳的测试消费");
        payOrder.setParam1("param1");
        //payOrder.setNotifyUrl("http://192.168.10.80:3010/pay/notice");
        payOrder.setServiceId("springcloud-enterprise");
        payOrder.setServiceUrl("/api/payment/payBill/payCallBack");
        payOrder.setAliPayReturnUrl("http://www.taobao.com");


        /*******step 2 生成签名(签名后必须要确保参数都不变,否则影响验签结果) ********/
        //生成签名
        payOrder.setSign(PayDigestUtil.getSign(BeanToMap.toMap(payOrder),MchIdEnum.MCH_BASE.getReqKey()));

        /*******step 3 调用接口 ********/
        //执行下单
        Result<AlipayWapPayRsp> result  =   payOrderClient.createPayOrder(payOrder);

        /*******step 4 验证响应签名 ********/
        //验证响应签名
        boolean verifyFlag = XXPayUtil.verifyPaySign(BeanToMap.toMap(result.getData()), MchIdEnum.MCH_BASE.getRspKey());
        if(!verifyFlag) {
            System.out.println(" 支付验证响应签名失败  fail ！");
            return;
        }

        /*******step 5 验签通过后进行业务处理 ********/
        System.out.println("成功下单:");
        System.out.println("result数据:"+result.toString());
        System.out.println("结束支付下单========================");

    }


    /**
     * 查询订单
    * */
    @Test
    public void payOrderQuery() {
        System.out.println("开始查询========================");
        /*******step 1 封装参数 ********/
        PayOrderQueryReq payOrderQueryReq = new PayOrderQueryReq();
        payOrderQueryReq.setPayOrderId("P0020190516145820000004");

        /*******step 2 生成签名(签名后必须要确保参数都不变,否则影响验签结果) ********/
        //生成密钥
        payOrderQueryReq.setSign(PayDigestUtil.getSign(BeanToMap.toMap(payOrderQueryReq),MchIdEnum.MCH_BASE.getReqKey()));

        /*******step 3 调用接口 ********/
        //执行查询
        Result<PayOrderQueryRsp>  result= payOrderClient.payOrderQuery(payOrderQueryReq);

        /*******step 4 验证响应签名 ********/
        //验证签名  成功返回 true  失败返回 false
        boolean verifyFlag =  XXPayUtil.verifyPaySign(BeanToMap.toMap(result.getData()), MchIdEnum.MCH_BASE.getRspKey());
        if(!verifyFlag){
            System.out.println( "支付查询响应签名验证不通过========================");
            return ;
        }

        /*******step 5 验签通过后进行业务处理 ********/
        System.out.println("result 数据返回："+result.toString());
        System.out.println("结束查询订单========================");

    }


    /**
     * 退款
     * */
    @Test
    public void refundOrder () {
        System.out.println("开始退款========================");
        /*******step 1 封装参数 ********/
        RefundOrderReq refundOrderReq = new RefundOrderReq();
        refundOrderReq.setMchRefundNo(UUID.randomUUID().toString().substring(0,20));
        refundOrderReq.setChannelUser("cldgug1107@sandbox.com");
        //refundOrderReq.setNotifyUrl("http://192.168.10.80:3010/refund/notice");
        refundOrderReq.setServiceId("springcloud-enterprise");
        refundOrderReq.setServiceUrl("/api/payment/payBill/refundCallBack");
        refundOrderReq.setChannelId(ChannelIdEnum.ALIPAY_WAP.getCode());
        refundOrderReq.setAmount(10000L);
        refundOrderReq.setMchId(MchIdEnum.MCH_BASE.getCode());
        refundOrderReq.setPayOrderId("P0020190516144807000003");
        refundOrderReq.setParam2("测试参数2");

        /*******step 2 生成签名(签名后必须要确保参数都不变,否则影响验签结果) ********/
        refundOrderReq.setSign(PayDigestUtil.getSign(BeanToMap.toMap(refundOrderReq),MchIdEnum.MCH_BASE.getReqKey()));

        /*******step 3 调用接口 ********/
        Result<RefundOrderRsp>  result= refundOrderClient.createRefundOrder(refundOrderReq);

        /*******step 4 验证响应签名 ********/
        //验证响应签名
        Boolean  resSignIsOk =  XXPayUtil.verifyPaySign(BeanToMap.toMap(result.getData()),MchIdEnum.MCH_BASE.getRspKey());
        if(!resSignIsOk){
            System.out.println("退款响应签名失败！");
        }

        /*******step 5 验签通过后进行业务处理 ********/
        System.out.println("result 数据返回："+result.toString());
        System.out.println("结束退款订单========================");

    }

}