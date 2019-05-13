package com.jn.enterprise.pay.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.enterprise.company.enums.CompanyExceptionEnum;
import com.jn.enterprise.pay.service.MyPayAccountService;
import com.jn.pay.vo.PayAccountAndAccountBookVo;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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


    @Before
    public void setUp() throws Exception {
       String userId = "wangsong";
    }




}