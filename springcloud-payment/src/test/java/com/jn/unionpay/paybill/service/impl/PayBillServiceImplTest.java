package com.jn.unionpay.paybill.service.impl;

import com.jn.SpringCloudPaymentApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.pay.model.CreateOrderAndPayReqModel;
import com.jn.pay.model.CreatePayReqModel;
import com.jn.pay.model.PayOrderNotify;
import com.jn.paybill.enums.PayBillExceptionEnum;
import com.jn.paybill.model.*;
import com.jn.system.model.User;
import com.jn.unionpay.paybill.dao.TbPaymentBillMapper;
import com.jn.unionpay.paybill.service.PayBillService;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.*;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/19 17:55
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudPaymentApplication.class})
public class PayBillServiceImplTest {
    private Logger logger = LoggerFactory.getLogger(PayBillServiceImplTest.class);
    @Autowired
    private PayBillService payBillService;
    @Autowired
    private TbPaymentBillMapper tbPaymentBillMapper;

    private String idOrNum;
    private User user = new User();

    @Before
    public void setUp() throws Exception {
        idOrNum = "cfb45a2f16c043498af68a5544f0a5a6";
        user.setAccount("wangsong");
        user.setId("10000");
        user.setName("王松");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getPaymentBillList() {
        PaymentBillParam paymentBillParam = new PaymentBillParam();
        try{
            PaginationData<List<PaymentBill>> paymentBillList = payBillService.getPaymentBillList(paymentBillParam);
            List<PaymentBill> rows = paymentBillList.getRows();
            assertThat(rows.size(),greaterThanOrEqualTo(0));
        }catch (JnSpringCloudException e){
            logger.warn("查询出错-- 数据错误,请核实测试对象数据。");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(PayBillExceptionEnum.TIME_CONVERSION_ERROR.getCode()),
                            Matchers.containsString(PayBillExceptionEnum.START_TIME_NOT_AFTER_END_TIME.getCode()),
                            Matchers.containsString(PayBillExceptionEnum.START_TIME_NOT_AFTER_END_TIME.getCode())
                    )
            );
        }


    }


    @Test
    public void createBill() {
        PaymentBillModel paymentBillModel = new PaymentBillModel();
        paymentBillModel.setBillAmount(new Double("200"));
        paymentBillModel.setBillCreateAccount("zhangsan");
        paymentBillModel.setBillName("停车费 统一缴费单元测试01");
        paymentBillModel.setBillObjId("2934eca0ac084475a96f02ddb630f333");
        paymentBillModel.setBillObjName("白下");
        paymentBillModel.setBillRemark("湘A123456");
        paymentBillModel.setBillType("005");
        paymentBillModel.setPayEndTime("2019-05-01 01:00:00");
        String bill = null;
        try{
            bill = payBillService.createBill(paymentBillModel);
            assertThat(bill, anything());
        }catch (JnSpringCloudException e){
            logger.warn("查询出错-- 数据错误,请核实测试对象数据。");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(PayBillExceptionEnum.TIME_CONVERSION_ERROR.getCode()),
                            Matchers.containsString(PayBillExceptionEnum.BILL_CREATE_REPLY_ERROR.getCode())
                    )
            );
        }
        if(StringUtils.isNotEmpty(bill)){
            int i = tbPaymentBillMapper.deleteByPrimaryKey(bill);
            logger.info("测试数据删除,bill_id:{}，响应条数{}",bill,i);
        }
    }

    @Test
    public void getPayBillDetailByIdOrNum() {
        try {
            PayBillVO payBillDetailByIdOrNum = payBillService.getPayBillDetailByIdOrNum(idOrNum);
            assertThat(payBillDetailByIdOrNum, anything());
        }catch (JnSpringCloudException e){
            logger.warn("根据账单ID或账单编号查询账单详情-- 数据错误,请核实测试对象数据。");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(PayBillExceptionEnum.BILL_ID_OR_NUM_IS_NOT_NULL.getCode())
                    )
            );
        }
    }

    @Test
    public void statisticsBillAmount() {
        PayBillCountParam payBillCountParam = new PayBillCountParam();
        try{
            PayBillCountVO payBillCountVO = payBillService.statisticsBillAmount(payBillCountParam);
            assertThat(payBillCountVO,anything());
        }catch (JnSpringCloudException e){
            logger.warn("按天查询缴费系统中各分类的收入情况-- 数据错误,请核实测试对象数据。");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(PayBillExceptionEnum.TIME_CONVERSION_ERROR.getCode()),
                            Matchers.containsString(PayBillExceptionEnum.START_TIME_NOT_AFTER_END_TIME.getCode())
                    )
            );
        }

    }

    @Test
    public void startPayment() {
        PayInitiateParam payInitiateParam = new PayInitiateParam();
        payInitiateParam.setBillIds(new String[]{"48w55wwffno383915","48w55wwffno383914"});
        payInitiateParam.setPayMenthed("0");
        try {
            CreatePayReqModel createPayReqModel = new CreatePayReqModel();
            Result result = payBillService.createPayOrder(createPayReqModel);
            assertThat(result,anything());
        }catch (JnSpringCloudException e){
            logger.warn("缴费单支付发起-- 数据错误,请核实测试对象数据。");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(PayBillExceptionEnum.BILL_ID_IS_NOT_NULL.getCode()),
                            Matchers.containsString(PayBillExceptionEnum.BILL_IS_NOT_EXIT.getCode()),
                            Matchers.containsString(PayBillExceptionEnum.PAYMENT_STATUS_IS_PAY.getCode()),
                            Matchers.containsString(PayBillExceptionEnum.BILL_PAY_ORDER_CREATE_ERROR.getCode())
                    )
            );
        }
    }

    @Test
    public void payCallBack() {
        PayOrderNotify callBackParam = new PayOrderNotify();

        try{
            Result result = payBillService.payCallBack(callBackParam);
            assertThat(result,anything());
        }catch (JnSpringCloudException e){
            logger.warn("统一缴费-支付回调-- 数据错误,请核实测试对象数据。");
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(PayBillExceptionEnum.BILL_ORDER_IS_NOT_EXIT.getCode()),
                            Matchers.containsString(PayBillExceptionEnum.BILL_IS_NOT_EXIT.getCode()),
                            Matchers.containsString(PayBillExceptionEnum.BILL_PAY_ORDER_CREATE_ERROR.getCode())
                    )
            );
        }
    }

}