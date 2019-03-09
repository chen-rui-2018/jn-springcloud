package com.jn.park.finance.service.impl;

import com.ctc.wstx.util.DataUtil;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.DateUtils;
import com.jn.park.finance.dao.TbFinanceBudgetHistoryMapper;
import com.jn.park.finance.dao.TbFinanceTotalBudgetMapper;
import com.jn.park.finance.entity.TbFinanceBudgetHistory;
import com.jn.park.finance.entity.TbFinanceTotalBudget;
import com.jn.park.finance.model.FinanceBudgetHistoryModel;
import com.jn.park.finance.model.FinanceBudgetMoneyModel;
import com.jn.park.finance.model.FinanceBudgetQueryModel;
import com.jn.park.finance.service.FinanceBudgetService;
import com.jn.park.finance.vo.FinanceBudgetHistoryVo;
import com.jn.park.finance.vo.FinanceTotalBudgetVo;
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
    @Autowired
    private TbFinanceBudgetHistoryMapper tbFinanceBudgetHistoryMapper;
    @Autowired
    private TbFinanceTotalBudgetMapper tbFinanceTotalBudgetMapper;



    /**
     * 初始化数据
     * 1、录入 行政综合部(281f4005-0363-4528-92a3-60a730532e53) 的 差旅支出 预算（年初），1-10月（除了3月）
     * 2、录入 行政综合部(281f4005-0363-4528-92a3-60a730532e53) 的 差旅支出 预算（临时），1-3月
     * 3、录入 行政综合部(281f4005-0363-4528-92a3-60a730532e53) 的 办公支出 预算（年初），1-10月（除了3月）
     */
    @Test
    public void t000_init() {
        //1、
        FinanceBudgetHistoryVo financeBudgetHistoryVo =new FinanceBudgetHistoryVo();
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,1);
        financeBudgetHistoryVo.setDepartmentId("281f4005-0363-4528-92a3-60a730532e53");
        financeBudgetHistoryVo.setDepartmentName("行政综合部");
        financeBudgetHistoryVo.setCostTypeId(4);
        financeBudgetHistoryVo.setCostTypeName("差旅支出");
        financeBudgetHistoryVo.setBudgetType(new Byte("0"));
        financeBudgetHistoryVo.setBudgetMoneyModels(new ArrayList<FinanceBudgetMoneyModel>());
        for(int i=1;i<10;i++){
            //跳过3月
            if(i==3){
                continue;
            }
            FinanceBudgetMoneyModel model=new FinanceBudgetMoneyModel();
            calendar.set(Calendar.MONTH,i-1);
            model.setMonth(DateUtils.formatDate(calendar.getTime(),"yyyyMM"));
            model.setMoney(new BigDecimal(i*10));
            financeBudgetHistoryVo.getBudgetMoneyModels().add(model);
        }
        financeBudgetService.add(financeBudgetHistoryVo,"huangbq");


        //2、
        financeBudgetHistoryVo=new  FinanceBudgetHistoryVo();
        financeBudgetHistoryVo.setDepartmentId("281f4005-0363-4528-92a3-60a730532e53");
        financeBudgetHistoryVo.setDepartmentName("行政综合部");
        financeBudgetHistoryVo.setCostTypeId(4);
        financeBudgetHistoryVo.setCostTypeName("差旅支出");
        financeBudgetHistoryVo.setBudgetType(new Byte("1"));
        financeBudgetHistoryVo.setBudgetMoneyModels(new ArrayList<FinanceBudgetMoneyModel>());
        for(int i=1;i<=3;i++){
            FinanceBudgetMoneyModel model=new FinanceBudgetMoneyModel();
            calendar.set(Calendar.MONTH,i-1);
            model.setMonth(DateUtils.formatDate(calendar.getTime(),"yyyyMM"));
            model.setMoney(new BigDecimal(i*10));
            financeBudgetHistoryVo.getBudgetMoneyModels().add(model);
        }
        financeBudgetService.add(financeBudgetHistoryVo,"huangbq");



        //3、
        financeBudgetHistoryVo=new  FinanceBudgetHistoryVo();
        financeBudgetHistoryVo.setDepartmentId("281f4005-0363-4528-92a3-60a730532e53");
        financeBudgetHistoryVo.setDepartmentName("行政综合部");
        financeBudgetHistoryVo.setCostTypeId(5);
        financeBudgetHistoryVo.setCostTypeName("办公支出");
        financeBudgetHistoryVo.setBudgetType(new Byte("0"));
        financeBudgetHistoryVo.setBudgetMoneyModels(new ArrayList<FinanceBudgetMoneyModel>());
        for(int i=1;i<=10;i++){
            //跳过3月
            if(i==3){
                continue;
            }
            FinanceBudgetMoneyModel model=new FinanceBudgetMoneyModel();
            calendar.set(Calendar.MONTH,i-1);
            model.setMonth(DateUtils.formatDate(calendar.getTime(),"yyyyMM"));
            model.setMoney(new BigDecimal(i*10));
            financeBudgetHistoryVo.getBudgetMoneyModels().add(model);
        }
        financeBudgetService.add(financeBudgetHistoryVo,"huangbq");


    }

    @Test
    public void t200_selectTotalBudget(){
        FinanceBudgetQueryModel model=new FinanceBudgetQueryModel();
        model.setStartMonth("201901");
        model.setEndMonth("201912");
        List<FinanceTotalBudgetVo> financeTotalBudgetVoList=financeBudgetService.selectTotalBudget(model,"huangbq");
        logger.info("========>{}",financeTotalBudgetVoList.size());
    }
}