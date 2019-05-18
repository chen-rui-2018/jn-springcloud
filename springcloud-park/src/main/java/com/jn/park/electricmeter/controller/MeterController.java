package com.jn.park.electricmeter.controller;

import com.jn.common.model.Result;
import com.jn.park.electricmeter.service.MeterService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author： yangh
 * @date： Created on 2019/5/15 11:24
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "物业管理-电表相关接口")
@RestController
@RequestMapping("/meter")
public class MeterController  {

    @Autowired
    private MeterService meterService;
    private static Logger logger = LoggerFactory.getLogger(MeterTimerController.class);

    @ControllerLog(doAction = "手动处理指定的电表读数定时入库失败的数据")
    @ApiOperation(value = "手动定时入库",notes = "手动定时入库", httpMethod = "GET")
    @GetMapping(value = "/dealSomeOneFailByHandle")
    @RequiresPermissions("/meter/dealSomeOneFailByHandle")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dealDate",value = "日期",type = "Date" ,example = "2019-12-12",required = true),
            @ApiImplicitParam(name = "dealHour",value = "小时",type = "Integer" ,example = "12",required = true)
    })
    public void dealSomeOneFailByHandle(Date dealDate,String dealHour){
        meterService.getDataFromHardare();
    }

    @ControllerLog(doAction = "手动处理所有电表读数定时入库失败的数据")
    @ApiOperation(value = "批量定时入库",notes = "批量定时入库", httpMethod = "GET")
    @GetMapping(value = "/dealAllFailByHandle")
    @RequiresPermissions("/meter/dealAllFailByHandle")
    public void dealAllFailByHandle(){
        meterService.getDataFromHardare();
    }

}
