package com.jn.enterprise.data.controller;

import com.jn.common.controller.BaseController;
import com.jn.enterprise.data.service.DataTaskTimerService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author： yangh
 * @date： Created on 2019/5/11 10:36
 * @version： v1.0
 * @modified By:
 */
@Api(tags="数据上报手动任务创建")
@RestController
@RequestMapping(value = "/data")
public class ManualOperationTimerController extends BaseController {
    @Autowired
    private DataTaskTimerService dataTaskTimerService;

    private static Logger logger = LoggerFactory.getLogger(ManualOperationTimerController.class);

    @ControllerLog(doAction = "手动任务创建")
    @ApiOperation(value = "手动任务创建",notes = "手动任务创建")
    @GetMapping(value = "/task/createTask")
    public void createTask(){
        dataTaskTimerService.createTask();
    }


    @ControllerLog(doAction = "手动更新任务状态")
    @ApiOperation(value = "手动更新任务状态",notes = "手动更新任务状态")
    @GetMapping(value = "/task/updateTask")
    public void updateTask(){
        dataTaskTimerService.updateTask();
    }


    @ControllerLog(doAction = "手动任务预警")
    @ApiOperation(value = "手动任务预警",notes = "手动任务预警")
    @GetMapping(value = "/task/taskWarning")
    public void taskWarning(){
        dataTaskTimerService.taskWarning();
    }

}
