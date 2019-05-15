package org.xxpay.web.controller;

import com.jn.common.model.Result;
import com.jn.pay.api.PayOrderClient;
import com.jn.pay.api.RefundOrderClient;
import com.jn.pay.enums.ChannelIdEnum;
import com.jn.pay.enums.MchIdEnum;
import com.jn.pay.model.PayOrderReq;
import com.jn.pay.model.alipay.AlipayWapPayRsp;
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
    private PayOrderClient payClient;
    @Autowired
    private RefundOrderClient refundOrderClient;
    @Autowired
    private KeyController keyController;


    @Test
    public void createPayOrder() {

        PayOrderReq payOrder = new PayOrderReq();
        payOrder.setMchId(MchIdEnum.MCH_BASE.getCode());
        payOrder.setMchOrderNo(UUID.randomUUID().toString().substring(0,20));
        payOrder.setChannelId(ChannelIdEnum.ALIPAY_WAP.getCode());
        payOrder.setAmount(new Long(10000));
        payOrder.setSubject("商品测试标题");
        payOrder.setBody("阳的测试消费");
        payOrder.setNotifyUrl("http:465");
        payOrder.getSign();
        Result<AlipayWapPayRsp> result = payClient.createPayOrder(payOrder);
        System.out.println("============================结果前===========================");
        System.out.println(result);
        System.out.println(result.getData().getPayUrl());

        System.out.println("============================结果后===========================");
    }


    @Test
    public void setKeyController() {
        Result<String> result = keyController.getRequestKey(MchIdEnum.MCH_BASE.getCode());

        String reqKey = result.getData();
        System.out.println( "==============reqKey==========" + reqKey);


        Result<String> result2 = keyController.getResponseKey(MchIdEnum.MCH_BASE.getCode());

        String resKey = result2.getData();
        System.out.println( "==============resKey==========" + resKey);
    }

   /* @Test
    public void payOrderQuery() {
        PayOrderQueryReq query = new PayOrderQueryReq();
        query.setMchId(MchIdEnum.MCH_BASE.getCode());
        query.setMchOrderNo("8423b7ee-561b-47bc-b");
        System.out.println("============================结果前===========================");
        Result<PayOrderQueryRsp> result  = payClient.payOrderQuery(query);
        System.out.println(result.getData().toString());
        System.out.println("============================结果后===========================");

    }*/

  /*  @Test
    public void refundOrder() {
        RefundOrderReq refundOrderReq = new RefundOrderReq();
        refundOrderReq.setMchId(MchIdEnum.MCH_BASE.getCode());
        refundOrderReq.setMchRefundNo(UUID.randomUUID().toString().substring(0,20));
        refundOrderReq.setPayOrderId("P0020190509165436000000");
        refundOrderReq.setMchOrderNo("8423b7ee-561b-47bc-b");
        refundOrderReq.setChannelId(ChannelIdEnum.ALIPAY_WAP.getCode());
        refundOrderReq.setAmount(new Long(1000));
        refundOrderReq.setNotifyUrl("http");
        refundOrderReq.setChannelUser("123");

        System.out.println("============================退款结果前===========================");
        Result<RefundOrderRsp>  result = refundOrderClient.createRefundOrder(refundOrderReq);
        System.out.println(result);
        System.out.println("============================退款结果后===========================");


    }*/
}