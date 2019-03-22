package com.jn.enterprise.technologyfinancial.investors.service.impl;

import com.jn.SpringCloudEnterpriseApplication;
import com.jn.enterprise.technologyfinancial.investors.service.InvestorManagementService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: yangph
 * @Date: 2019/3/21 20:55
 * @Version v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudEnterpriseApplication.class})
public class InvestorManagementServiceImplTest {
    /**
     * 日志组件
     */
    private Logger logger = LoggerFactory.getLogger(InvestorManagementServiceImplTest.class);

    @Autowired
    private InvestorManagementService investorManagementService;

    @Before
    public void setUp() throws Exception {
    }

    /**
     * 投资人管理列表查询
     */
    @Test
    public void getInvestorManagementList() {
    }

    /**
     * 投资人管理姓名查询
     */
    @Test
    public void getInvestorManagementNames() {
    }

    /**
     * 投资人上架/下架
     */
    @Test
    public void investorUpOrDown() {
    }
}