package com.jn.park.pmpaybill.service;

import com.jn.SpringCloudParkApplication;
import com.jn.park.property.model.PayCallBackNotify;
import com.jn.park.repair.enums.PaymentBillEnum;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringCloudParkApplication.class})
@FixMethodOrder(MethodSorters.JVM)
public class PmPayBillServiceTest {

    @Autowired
    private PmPayBillService pmPayBillService;

    @Test
    public void autoGeneratePmPayBillDeatils(){
        pmPayBillService.createPmPayBillByQuarter();
    }

    @Test
    public void updatePmPayBillItemExpireStatus(){
        pmPayBillService.updatePmPayBillItemExpireStatus();
    }

    @Test
    public void pmPayBillCallBack(){
        PayCallBackNotify payCallBackNotify = new PayCallBackNotify();
        payCallBackNotify.setBillId("1affb666-64d9-4c6d-9a55-bd702d5b47ce");
        payCallBackNotify.setPaymentState(PaymentBillEnum.BILL_ORDER_IS_PAY.getCode());
        pmPayBillService.pmPayBillCallBack(payCallBackNotify);
    }

    @Test
    public void createPmPayBillByQuarter(){
        pmPayBillService.createPmPayBillByQuarter();
    }

}