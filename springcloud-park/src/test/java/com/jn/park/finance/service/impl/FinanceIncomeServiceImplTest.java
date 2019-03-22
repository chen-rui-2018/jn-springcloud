package com.jn.park.finance.service.impl;

import com.jn.common.util.Assert;
import com.jn.park.finance.service.FinanceIncomeService;
import com.jn.park.finance.vo.FianceDynamicTableVo;
import com.jn.park.finance.vo.FinanceIncomeLastYearContrastVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FinanceIncomeServiceImplTest {
    @Autowired
    private FinanceIncomeService financeIncomeService;

    @Test
    public void periodContrast() {
    }

    @Test
    public void summarizingProportion() {
    }

    private static Logger logger = LoggerFactory.getLogger(FinanceBudgetServiceImplTest.class);

    @Test
    public void lastYearContrast() {

        FianceDynamicTableVo<List<FinanceIncomeLastYearContrastVo>> list=financeIncomeService.lastYearContrast("201902","201912");
        logger.info("========>{}",list.getRows());
    }
}