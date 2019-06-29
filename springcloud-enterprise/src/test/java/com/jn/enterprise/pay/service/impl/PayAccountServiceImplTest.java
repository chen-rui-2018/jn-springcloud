package com.jn.enterprise.pay.service.impl;

import cn.hutool.json.JSONUtil;
import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.company.enums.CompanyExceptionEnum;
import com.jn.enterprise.pay.service.MyPayAccountService;
import com.jn.enterprise.pd.declaration.model.DeclarationPlatformModel;
import com.jn.pay.api.PayClient;
import com.jn.pay.model.*;
import com.jn.pay.vo.PayAccountAndAccountBookVo;
import com.jn.pay.vo.PayBillCreateParamVo;
import com.jn.system.model.User;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xxpay.common.util.JsonUtil;
import springfox.documentation.spring.web.json.Json;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertThat;

/**
 * @Author: wzy
 * @Date: 2019-4-15 16:37:55
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudEnterpriseApplication.class})
public class PayAccountServiceImplTest {

    // 日志组件
    private static Logger logger = LoggerFactory.getLogger(PayAccountServiceImplTest.class);

    @Autowired
    private MyPayAccountService myPayAccountService;

    @Autowired
    private PayClient payClient;


    @Before
    public void setUp() throws Exception {
       String userId = "13586415994";
    }

    @Test
    public void queryPayAccountBookMoney() {
        try {
            PayAccountBookMoney payAccountBookMoney = new PayAccountBookMoney();
            payAccountBookMoney.setAcBookId("156170997200058032");
            PayAccountBook payAccountBook = myPayAccountService.queryPayAccountBookMoney(payAccountBookMoney);
            logger.info("获取账本明细{}", payAccountBook.toString());
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("获取获取账本明细数据异常");
        }
    }
    @Test
    public void billCreate() {
        PayBillCreateParamVo payBillCreateParamVo = new PayBillCreateParamVo();
        payBillCreateParamVo.setBillId(UUID.randomUUID().toString().replaceAll("-", ""));
        //账单名称
        payBillCreateParamVo.setBillName("物业费账单");
        //账单来源
        payBillCreateParamVo.setBillSource("企业");
        //账单费用
        payBillCreateParamVo.setBillExpense(new BigDecimal("12.3"));
        //对象类型【1：企业，2：个人】
        payBillCreateParamVo.setObjType("1");
        //对象Id（传企业ID或用户ID）
        payBillCreateParamVo.setObjId("wangsong");
        //对象名称（传企业名称或用户名称）
        payBillCreateParamVo.setObjName("xx企业");
        //账本类型ID【1：电费，2：物业费】
        payBillCreateParamVo.setAcBookType("2");
        //回调ID
        payBillCreateParamVo.setCallbackId("");
        //回调URL
        payBillCreateParamVo.setCallbackUrl("");
        //创建时间
        payBillCreateParamVo.setCreatedTime(new Date());
        //创建人
        payBillCreateParamVo.setCreatorAccount("wangsong");
        //最迟缴费时间
        payBillCreateParamVo.setLatePayment(new Date());
        //缴费详情【存list对象集合】
        List<PayBillDetails> payBillDetails = new ArrayList<>();
        payBillCreateParamVo.setPayBillDetails(payBillDetails);
        Result billCreateResult = payClient.billCreate(payBillCreateParamVo);
        logger.info("获取账本明细{}", JsonUtil.object2Json(billCreateResult));
    }

    @Test
    public void createPayAccountBook() {
        PayAccountBookCreateParam param = new PayAccountBookCreateParam();
        User user = new User();
        user.setAccount("13586415994");
        param.setComAdmin("13586415994");
        param.setEnterId("fbb2cf99e5b5487289b1e341d68980fb");
        Result result = myPayAccountService.createPayAccountBook(param,user);
        logger.info("创建账户账本{}", JsonUtil.object2Json(result));
    }

    @Test
    public void queryAccountBook() {
        PayAccountBookEntIdOrUserIdParam param = new PayAccountBookEntIdOrUserIdParam();
        User user = new User();
        user.setAccount("wangsong");
        param.setObjType("1");
        param.setObjId("fbb2cf99e5b5487289b1e341d68980fb");
        Result result = myPayAccountService.queryAccountBook(param);
        logger.info("查询账户下账本{}", JsonUtil.object2Json(result));
    }


}