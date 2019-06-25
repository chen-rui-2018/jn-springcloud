package com.jn.hardware.api;

import com.jn.common.model.Result;
import com.jn.hardware.model.environment.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 环境监测提供的内部服务接口
 *
 * @Author： cm
 * @Date： Created on 2019/6/23 23:41
 * @Version： v1.0
 * @Modified By:
 */
@FeignClient("springcloud-hardware")
public interface EnvironmentMonitorClient {

    /**
     * 获取设备的统计数据
     * 包含温度、湿度、pm2.5、pm10指标数据
     * @param deviceAvgDataParam
     * @return
     */
    @RequestMapping(value = "/api/hardware/environment/getEnvironmentMonitorAvgDate")
    Result<List<DeviceAvgDataResult>> getEnvironmentMonitorAvgDate(@RequestBody DeviceAvgDataParam deviceAvgDataParam);

    /**
     * 获取设备的实时数据
     * 包含设备的指标实时值、设备的实时空气质量、设备的实时污染级别、实时南京市平均空气质量
     * @param count
     * @return
     */
    @RequestMapping(value = "/api/hardware/environment/getEnvironmentMonitorRealTimeDate")
    Result<EnvironmentMonitorRealTimeDataResult> getEnvironmentMonitorRealTimeDate(@RequestParam(value = "count") int count);

    /**
     * 获取设备的实时空气质量、设备的实时污染级别、实时南京市平均空气质量
     * @return
     */
    @RequestMapping(value = "/api/hardware/environment/getDeviceAirQualityAll")
    Result<EnvironmentMonitorAirQualityAllResult> getDeviceAirQualityAll();

    /**
     * 获取所有设备未来72小时的预测值，只能预测pm2.5和pm10
     * @return
     */
    @RequestMapping(value = "/api/hardware/environment/getEnvironmentMonitorIndexForecast")
    Result<List<DeviceIndexForecastDataResult>> getEnvironmentMonitorIndexForecast();
}
