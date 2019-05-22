package com.jn.hr.employee.service;

import com.jn.common.model.Result;

import java.util.Map;

/**
 * @author dt
 * @create 2019-05-08 下午 3:44
 */
public interface EmployeeTaskService {
    //生成假期定时任务
    public Result<Map<String,String>> generateVacation();
}
