package com.jn.park.finance.service.impl;

import com.jn.park.finance.dao.FinanceWorkbenchDao;
import com.jn.park.finance.service.FinanceWorkbenchService;
import com.jn.park.finance.vo.FinanceWorkbenchMonitoringVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 智能工作台
 * @author： tangry
 * @date： Created on 2019/3/18
 * @version： v1.0
 * @modified By:
 */
@Service
public class FinanceWorkbenchServiceImpl implements FinanceWorkbenchService {
    @Autowired
    private FinanceWorkbenchDao financeWorkbenchDao;

    @Override
    public List<FinanceWorkbenchMonitoringVo> financeMonitoring() {
        //获取到当前年份
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String year = sdf.format(date);
        //凭接出这一年的开始和结束时间，以为页面没有时间选择，所以获取当前年份
        String StarTime =year+"01";
        String endTime =year+"12";
        return financeWorkbenchDao.financeMonitoring(StarTime,endTime);
    }
}
