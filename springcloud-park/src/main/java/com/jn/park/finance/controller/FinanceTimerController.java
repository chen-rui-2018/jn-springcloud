package com.jn.park.finance.controller;

import com.jn.common.model.Result;
import com.jn.park.finance.service.FinanceTimerService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * @author： tangry
 * @date： Created on 2019/3/5
 * @version： v1.0
 * @modified By:
 * 财务协同-定时器
 */
@Component
public class FinanceTimerController {
    @Autowired
    private FinanceTimerService financeTimerService;

    /**
     * 更新收入情况月表
     * 每天凌晨2点跑一次
     * @return
     */
    @Scheduled(cron = "0 0 2 * * ?")
    public Result updateIncomeMonth() {
        String status= financeTimerService.updateIncomeMonth();
        return new Result(status);
    }


    /**
     * 更新收入情况日表
     * 每月一号凌晨1点跑一次
     * @return
     */
    @Scheduled(cron = "0 0 1 1 * ?")
    public Result updateIncomeDay()  {
        String status= financeTimerService.updateIncomeDay();
        return new Result(status);
    }


}
