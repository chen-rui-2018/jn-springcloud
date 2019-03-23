package com.jn.unionpay.payremind.service.impl;

import com.jn.SpringCloudPaymentApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.paybill.enums.PayBillExceptionEnum;
import com.jn.paybill.model.PayBillEntryCallbackParam;
import com.jn.unionpay.paybill.dao.TbPaymentBillMapper;
import com.jn.unionpay.paybill.entity.TbPaymentBillCriteria;
import com.jn.unionpay.payremind.dao.TbPaymentRemindMapper;
import com.jn.unionpay.payremind.entity.TbPaymentRemindCriteria;
import com.jn.unionpay.payremind.model.PayBillEntryParam;
import com.jn.unionpay.payremind.model.PayRemindCheckParam;
import com.jn.unionpay.payremind.model.PayRemindParam;
import com.jn.unionpay.payremind.model.PayRemindVO;
import com.jn.unionpay.payremind.service.PayRemindService;
import org.checkerframework.checker.units.qual.A;
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

import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.*;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/20 15:18
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudPaymentApplication.class})
public class PayRemindServiceImplTest {
    private static Logger logger = LoggerFactory.getLogger(PayRemindServiceImplTest.class);

    @Autowired
    private PayRemindService payRemindService;
    @Autowired
    private TbPaymentRemindMapper tbPaymentRemindMapper;
    @Autowired
    private TbPaymentBillMapper tbPaymentBillMapper;

    private String account;
    private String payType;
    private String remindId;

    @Before
    public void setUp() throws Exception {
        account  = "zhangsan";
        remindId = "45w4fcwr3582";
        payType = "3";
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveCheckRemind() {
        PayRemindParam payRemindParam = new PayRemindParam();
        payRemindParam.setBillIds(new String[]{"48w55wwffno383918","48w55wwffno383919"});
        payRemindParam.setBankName("中国农业银行");
        payRemindParam.setBankId("6228481121111111444");
        payRemindParam.setBankAccount("思维");
        payRemindParam.setPayAmount(new Double("20"));
        payRemindParam.setPayRemark("缴费缴费就将计就计说明----------------");
        payRemindParam.setPayImg("jjjkls/jij/png");
        try{
            int i = payRemindService.saveCheckRemind(payRemindParam, account);
            assertThat(i,greaterThanOrEqualTo(0));
        }catch (JnSpringCloudException e){
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(PayBillExceptionEnum.CHECK_ORDER_EXIST_CHECKED_BILL.getCode()),
                            Matchers.containsString(PayBillExceptionEnum.PAYMENT_STATUS_IS_PAY_NOT_CHECK.getCode()),
                            Matchers.containsString(PayBillExceptionEnum.COMMIT_AMOUNT_NOT_EQUAL_BILL_AMOUNT.getCode())
                    )
            );
        }
        TbPaymentRemindCriteria remindCriteria = new TbPaymentRemindCriteria();
        remindCriteria.createCriteria().andPayRemarkEqualTo("缴费缴费就将计就计说明----------------");
        int i = tbPaymentRemindMapper.deleteByExample(remindCriteria);
        logger.info("删除测试数据{}条",i);
    }

    @Test
    public void getBillRemindDetail() {
        try {
            PayRemindVO billRemindDetail = payRemindService.getBillRemindDetail(remindId);
            assertThat(billRemindDetail,anything());
        }catch (JnSpringCloudException e){
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(PayBillExceptionEnum.PAY_REMIND_IS_NOT_EXIT.getCode())
                    )
            );
        }
    }

    @Test
    public void checkBillRemind() {
        PayRemindCheckParam payRemindCheckParam = new PayRemindCheckParam();
        payRemindCheckParam.setId("48w55wwffno383918");
        payRemindCheckParam.setRemindStatus("4");
        payRemindCheckParam.setCheckRemark("审核通过");
        try{
            int i = payRemindService.checkBillRemind(payRemindCheckParam, account, payType);
            assertThat(i,greaterThanOrEqualTo(0));
        }catch (JnSpringCloudException e){
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(PayBillExceptionEnum.PAY_REMIND_IS_NOT_EXIT.getCode())
                    )
            );
        }
    }

    @Test
    public void createBillRemind() {
        PayBillEntryParam payBillEntryParam = new PayBillEntryParam();
        payBillEntryParam.setBillNum("2018010111223212");
        payBillEntryParam.setBillType("005");
        payBillEntryParam.setBillName("湘A11122停车费");
        payBillEntryParam.setBillObjType("2");
        payBillEntryParam.setBillObjId("10000");
        payBillEntryParam.setBillObjName("王松");
        payBillEntryParam.setBillAmount(new Double("20"));
        payBillEntryParam.setPayEndTime("2018-10-10 10:00:00");
        try{
            int billRemind = payRemindService.createBillRemind(payBillEntryParam, account);
            assertThat(billRemind,greaterThanOrEqualTo(0));
        }catch (JnSpringCloudException e){
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(PayBillExceptionEnum. TIME_CONVERSION_ERROR.getCode())
                    )
            );
        }
        TbPaymentBillCriteria  billCriteria = new TbPaymentBillCriteria();
        billCriteria.createCriteria().andBillNumEqualTo("2018010111223212");
        int i = tbPaymentBillMapper.deleteByExample(billCriteria);
        logger.info("删除测试数据{}条",i);
    }

    @Test
    public void createBillCallback() {
        PayBillEntryCallbackParam payBillEntryCallbackParam = new PayBillEntryCallbackParam();
        payBillEntryCallbackParam.setBillId("eb58bfcf254f4ef7a3fc52949be8c545");
        payBillEntryCallbackParam.setBillStatus("1");
        try{
            int billCallback = payRemindService.createBillCallback(payBillEntryCallbackParam);
            assertThat(billCallback,greaterThanOrEqualTo(0));
        }catch (JnSpringCloudException e){
            assertThat(e.getCode(),
                    Matchers.anyOf(
                            Matchers.containsString(PayBillExceptionEnum.BILL_ID_IS_NOT_NULL.getCode()),
                            Matchers.containsString(PayBillExceptionEnum.BILL_STATUS_IS_NOT_NULL.getCode()),
                            Matchers.containsString(PayBillExceptionEnum.BILL_IS_NOT_EXIT.getCode()),
                            Matchers.containsString(PayBillExceptionEnum.PAYMENT_STATUS_IS_NOT_CHECK.getCode())
                    )
            );
        }
    }
}