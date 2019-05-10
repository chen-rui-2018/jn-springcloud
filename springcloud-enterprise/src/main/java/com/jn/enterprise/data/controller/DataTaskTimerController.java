package com.jn.enterprise.data.controller;

import com.jn.common.controller.BaseController;
import com.jn.enterprise.data.service.DataTaskTimerService;
import com.jn.enterprise.data.service.impl.DataModelServiceImpl;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： yangh
 * @date： Created on 2019/4/18 10:51
 * @version： v1.0
 * @modified By:
 */
@Component
@Api(tags="数据上报任务创建定时器")
@RestController
@RequestMapping(value = "/data")
public class DataTaskTimerController extends BaseController {
    @Autowired
    private DataTaskTimerService dataTaskTimerService;
    private static Logger logger = LoggerFactory.getLogger(DataTaskTimerController.class);

    //@Scheduled(cron = "0 0 1 0 * ?")
    @ControllerLog(doAction = "任务创建")
    @ApiOperation(value = "任务创建",notes = "任务创建")
    @GetMapping(value = "/task/createTask")
    public void createTask(){

        dataTaskTimerService.createTask();
    }

    //@Scheduled(cron = "0 0 1 0 * ?")
    @ControllerLog(doAction = "更新任务状态")
    @ApiOperation(value = "更新任务状态",notes = "更新任务状态")
    @GetMapping(value = "/task/updateTask")
    public void updateTask(){

        dataTaskTimerService.updateTask();
    }

    //@Scheduled(cron = "0 0 1 0 * ?")
    @ControllerLog(doAction = "任务预警")
    @ApiOperation(value = "任务预警",notes = "任务预警")
    @GetMapping(value = "/task/taskWarning")
    public void taskWarning(){

        dataTaskTimerService.taskWarning();
    }
}
