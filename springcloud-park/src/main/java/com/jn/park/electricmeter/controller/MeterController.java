package com.jn.park.electricmeter.controller;

import com.jn.park.electricmeter.service.MeterService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ControllerLog(doAction = "手动电表数据定时接口")
    @ApiOperation(value = "消息列表",notes = "查询消息列表", httpMethod = "GET")
    @GetMapping(value = "/getDataFromHardare")
    @RequiresPermissions("/meter/getDataFromHardare")
    public void getDataFromHardare(){
        meterService.getDataFromHardare();
    }

}
