package com.jn.enterprise.data.controller;

import com.jn.common.controller.BaseController;
import com.jn.enterprise.api.EnterpriseClient;
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
@Api(tags = "数据上报-企业/园区定时任务创建")
@RestController
public class DataTaskTimerController extends BaseController  implements EnterpriseClient {
    @Autowired
    private DataTaskTimerService dataTaskTimerService;
    private static Logger logger = LoggerFactory.getLogger(DataTaskTimerController.class);

    @ControllerLog(doAction = "任务创建")
    @Override
    public void createTask(){

        dataTaskTimerService.createTask();
    }

    @ControllerLog(doAction = "更新任务状态")
    @Override
    public void updateTask(){

        dataTaskTimerService.updateTask();
    }

    @ControllerLog(doAction = "任务预警")
    @Override
    public void taskWarning(){
        dataTaskTimerService.taskWarning();
    }
}
