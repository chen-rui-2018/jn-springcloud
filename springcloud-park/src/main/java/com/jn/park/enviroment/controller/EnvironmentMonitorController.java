package com.jn.park.enviroment.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.enviroment.service.EnvironmentMonitorService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 环境监测控制层
 *
 * @author： shaobao
 * @date： Created on 2019/6/29 11:05
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "综合展厅-环境监测")
@RestController
@RequestMapping("/park/environmentMonitor")
public class EnvironmentMonitorController extends BaseController {

    @Autowired
    private EnvironmentMonitorService environmentMonitorService;

    @ControllerLog(doAction = "获取环境监测数据")
    @ApiOperation(value = "获取环境监测数据", notes = "获取环境监测数据")
    @RequestMapping(value = "/getEnvironmentMonitorRealTimeDate", method = RequestMethod.POST)
    @RequiresPermissions("/park/environmentMonitor/getEnvironmentMonitorRealTimeDate")
    public Result<Integer> getEnvironmentMonitorRealTimeDate(){
        Integer i = environmentMonitorService.getEnvironmentMonitorRealTimeDate(-1);
        return new Result(i);
    }

}
