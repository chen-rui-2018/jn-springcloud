package com.jn.park.finance.service.impl;

import com.jn.common.util.DateUtils;
import com.jn.park.finance.dao.FinanceTimerDao;
import com.jn.park.finance.model.FinanceIncomeGetDaysModel;
import com.jn.park.finance.model.FinanceIncomeUpdateMonthModel;
import com.jn.park.finance.service.FinanceTimerService;
import com.jn.system.log.annotation.ServiceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Author: tangry
 * @Date: 2019/3/21
 * @Version 1.0
 */
@Service
@Transactional
public class FinanceTimerServiceImpl implements FinanceTimerService {
    @Autowired
    private FinanceTimerDao financeTimerDao;

    @ServiceLog(doAction = "更新收入情况日表")
    @Override
    public String updateIncomeDay() {
        // TODO: 2019/3/24 获取接口数据
        List<FinanceIncomeGetDaysModel> financeIncomeGetDaysModelList=new ArrayList<>();
        //保存到日表
        Map<String,Object> map=new HashMap<>();
        map.put("list",financeIncomeGetDaysModelList);
        financeTimerDao.getDaysData(map);
        return "同步成功";
    }

    @ServiceLog(doAction = "更新收入情况月表")
    @Override
    public String updateIncomeMonth() {
        //获取字典表中“收入情况定时器”的最大可更新月份，返回最大账期
        //传入字典值,查询最大账期
        String maxValue= financeTimerDao.getDictionaryStatus("收入情况定时器");
        //获取到当前的月份
        Date day=new Date();
        String month= DateUtils.formatDate(day,"yyyyMM");
        //将最大账期的年份减去一年,得到去年同期账期
        String yyyy=maxValue.substring(0,4);
        String mm=maxValue.substring(4);
        //年份-1，得到去年年份
        String last= String.valueOf(Integer.parseInt(yyyy) - 1);
        //拼接去年同期的账期
        String lastYear=last+mm;
        //再通过刚刚查询出来的最大的账期最为条件,汇总月份数据,还有去年同期的收入汇总
        List<FinanceIncomeUpdateMonthModel> financeIncomeGetDaysModelList=financeTimerDao.selectSummarizing(maxValue,lastYear);
        //将加过保存到月表中
        Map<String,Object> map=new HashMap<>();
        map.put("list",financeIncomeGetDaysModelList);
        financeTimerDao.saveSummarizing(map);
        //再将这次试用的最大账期逻辑删除
        financeTimerDao.updateDictionary(maxValue,"收入情况定时器");
        //再新增一条最大的账期
        financeTimerDao.insertDictionary(month,"收入情况定时器");
        return null;
    }





}
