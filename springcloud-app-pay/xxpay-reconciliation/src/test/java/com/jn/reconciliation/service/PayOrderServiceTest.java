package com.jn.reconciliation.service;

import com.jn.XxPayReconciliationApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {XxPayReconciliationApplication.class})
public class PayOrderServiceTest {

    @Autowired
    private PayOrderService payOrderService;


    /**
     *
    * */
    @Test
    public void getSuccessPayOrder() {

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

     //   Date billDate = DateUtil.addDay(new Date(), -1);

        System.out.println(" 日期" );
    }


}
