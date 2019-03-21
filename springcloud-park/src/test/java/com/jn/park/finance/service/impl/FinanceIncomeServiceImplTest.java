package com.jn.park.finance.service.impl;

import com.jn.common.util.Assert;
import com.jn.park.finance.service.FinanceIncomeService;
import com.jn.park.finance.vo.FinanceIncomeLastYearContrastVo;
import org.junit.Test;
import org.junit.runner.RunWith;
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

    @Test
    public void lastYearContrast() {

        List<FinanceIncomeLastYearContrastVo> list=financeIncomeService.lastYearContrast("201902","201912");
        Assert.isTrue(list.size()>0);
    }
}