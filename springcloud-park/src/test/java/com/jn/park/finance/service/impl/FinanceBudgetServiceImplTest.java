package com.jn.park.finance.service.impl;

import com.ctc.wstx.util.DataUtil;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.DateUtils;
import com.jn.park.finance.model.FinanceBudgetHistoryModel;
import com.jn.park.finance.model.FinanceBudgetMoneyModel;
import com.jn.park.finance.service.FinanceBudgetService;
import com.jn.park.finance.vo.FinanceBudgetHistoryVo;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author： huangbq
 * @date： Created on 2019/3/4 19:18
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FinanceBudgetServiceImplTest {
    private static Logger logger = LoggerFactory.getLogger(FinanceBudgetServiceImplTest.class);
    @Autowired
    private FinanceBudgetService financeBudgetService;

    @Test
    public void totalList() {
    }

    @Test
    public void historyList() {
    }

    @Test
    public void add() {
        FinanceBudgetHistoryVo financeBudgetHistoryVo =new FinanceBudgetHistoryVo();
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,1);
        financeBudgetHistoryVo.setDepartmentId("01");
        financeBudgetHistoryVo.setDepartmentName("销售部");
        financeBudgetHistoryVo.setCostTypeId(1);
        financeBudgetHistoryVo.setCostTypeName("差旅支出");
        financeBudgetHistoryVo.setBudgetType(new Byte("0"));
        financeBudgetHistoryVo.setBudgetMoneyModels(new ArrayList<FinanceBudgetMoneyModel>());
        for(int i=1;i<=5;i++){
            FinanceBudgetMoneyModel model=new FinanceBudgetMoneyModel();
            calendar.set(Calendar.MONTH,i);
            model.setMonth(calendar.getTime());
            model.setMoney(new BigDecimal(i*10));
            financeBudgetHistoryVo.getBudgetMoneyModels().add(model);
        }
        try{
            financeBudgetService.add(financeBudgetHistoryVo,"huangbq02");
        }catch (JnSpringCloudException ex){
            logger.info("业务异常",ex);
        }
    }
}