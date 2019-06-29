package com.jn.server;

import com.jn.park.api.EnvironmentMonitorClient;
import com.jn.park.enviroment.service.EnvironmentMonitorService;
import com.jn.system.log.annotation.ControllerLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 环境监测server
 *
 * @author： shaobao
 * @date： Created on 2019/6/28 14:21
 * @version： v1.0
 * @modified By:
 **/
@RestController
public class EnvironmentMonitorServerController implements EnvironmentMonitorClient {

    @Autowired
    private EnvironmentMonitorService environmentMonitorService;

    @Override
    @ControllerLog(doAction = "定时获取环境监测数据")
    public void getEnvironmentMonitorRealTimeDate(@RequestBody String hour) {
        environmentMonitorService.getEnvironmentMonitorRealTimeDate(Integer.parseInt(hour));
    }
}
