package com.jn.park.finance.service;

import com.jn.system.model.User;

import java.text.ParseException;
import java.util.Map;

/**
 * @Author: tangry
 * @Date: 2019/3/21
 * @Version 1.0
 */
public interface FinanceTimerService {


    /**
     * 更新收入情况月表数据
     * @return
     */
    String updateIncomeMonth();

    /**
     * 更新收入情况日表数据
     * @return
     */
   String updateIncomeDay();
}
