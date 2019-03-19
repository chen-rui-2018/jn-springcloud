package com.jn.park.finance.service.impl;

import com.jn.park.finance.dao.FinanceIncomeDao;
import com.jn.park.finance.service.FinanceIncomeService;
import com.jn.park.finance.vo.FinanceIncomeLastYearContrastVo;
import com.jn.park.finance.vo.FinanceIncomePeriodVo;
import com.jn.park.finance.vo.FinanceIncomeSummarizingProportionVo;
import com.jn.system.log.annotation.ServiceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 监控首页
 * @author： tangry
 * @date： Created on 2019/3/11
 * @version： v1.0
 * @modified By:
 */
@Service
public class FinanceIncomeServiceImpl implements FinanceIncomeService {
    @Autowired
    private FinanceIncomeDao financeIncomeDao;

    @ServiceLog(doAction = "明细,同期对比")
    @Override
    public List<FinanceIncomePeriodVo> periodContrast(String startTime, String endTime) {
        return financeIncomeDao.periodContrast(startTime,endTime);
    }

    @ServiceLog(doAction = "汇总占比")
    @Override
    public List<FinanceIncomeSummarizingProportionVo> summarizingProportion(String startTime, String endTime) {
        return financeIncomeDao.summarizingProportion(startTime,endTime);
    }

    @ServiceLog(doAction = "往年对比")
    @Override
    public List<FinanceIncomeLastYearContrastVo> lastYearContrast(String startTime, String endTime) {
        return financeIncomeDao.lastYearContrast(startTime,endTime);
    }
}
