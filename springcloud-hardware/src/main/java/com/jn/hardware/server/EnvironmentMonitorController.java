package com.jn.hardware.server;

import com.jn.common.model.Result;
import com.jn.hardware.api.EnvironmentMonitorClient;
import com.jn.hardware.environment.service.EnvironmentMonitorService;
import com.jn.hardware.model.environment.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 环境监测：内部接口实现类
 *
 * @Author： cm
 * @Date： Created on 2019/6/23 23:50
 * @Version： v1.0
 * @Modified By:
 */
@RestController
public class EnvironmentMonitorController implements EnvironmentMonitorClient {

    @Autowired
    private EnvironmentMonitorService environmentMonitorService;

    @Override
    public Result<List<DeviceAvgDataResult>> getEnvironmentMonitorAvgDate(@RequestBody DeviceAvgDataParam deviceAvgDataParam) {
        return new Result(environmentMonitorService.getDeviceAvgData(deviceAvgDataParam));
    }

    @Override
    public Result<EnvironmentMonitorRealTimeDataResult> getEnvironmentMonitorRealTimeDate(@RequestParam(value = "count") int count) {
        return new Result(environmentMonitorService.getEnvironmentMonitorRealTimeDate(count));
    }

    @Override
    public Result<EnvironmentMonitorAirQualityAllResult> getDeviceAirQualityAll() {
        return new Result(environmentMonitorService.getDeviceAirQualityAll());
    }

    @Override
    public Result<List<DeviceIndexForecastDataResult>> getEnvironmentMonitorIndexForecast() {
        return new Result(environmentMonitorService.getEnvironmentMonitorIndexForecast());
    }
}
