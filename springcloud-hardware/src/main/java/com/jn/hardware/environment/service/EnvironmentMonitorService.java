package com.jn.hardware.environment.service;

import com.jn.hardware.model.environment.*;

import java.util.List;

/**
 * 环境监测接口
 *
 * @Author： cm
 * @Date： Created on 2019/6/22 16:14
 * @Version： v1.0
 * @Modified By:
 */
public interface EnvironmentMonitorService {

    /**
     * 获取设备实时数据url
     */
    String DEVICE_REAL_TIME_DATA_URL = "http://service.wanwuyun.com:8920/devicedata/%s?count=%s";

    /**
     * 获取设备的统计数据url
     */
    String DEVICE_AVG_DATA_URL = "http://service.wanwuyun.com:8920/deviceavg/%s?type=%s&time=%s&num=%s";

    /**
     * 获取实时设备空气质量url
     */
    String DEVICE_REAL_TIME_AIR_QUALITY_URL = "http://service.envicloud.cn:8083/data/pollutiondevice?deviceid=%s";

    /**
     * 获取实时南京市平均空气质量url
     */
    String DEVICE_REAL_TIME_CITY_AIR_QUALITY_URL = "http://service.envicloud.cn:8083/data/pollutioncity?deviceid=%s";

    /**
     * 获取实时设备污染级别URL
     */
    String DEVICE_REAL_TIME_POLLUTE_LEVEL_URL = "http://service.envicloud.cn:8083/data/pollutionlevel?deviceid=%s";
    /**
     * 设备环境预测值，pm10、pm2.5
     */
    String DEVICE_INDEX_FORECAST_URL = "http://service.envicloud.cn:8083/data/forecast?deviceid=%s";

    /**
     * 获取设备实时数据
     * @param count 返回数据条数
     * @return
     */
    List<DeviceRealTimeDataResult> getDeviceRealTimeData(int count);

    /**
     * 获取设备的统计数据 设备的指标平均值
     * @param deviceAvgDataParam
     * @return
     */
    List<DeviceAvgDataResult> getDeviceAvgData(DeviceAvgDataParam deviceAvgDataParam);

    /**
     * 获取设备的实时数据
     * 包含设备的指标实时值、设备的实时空气质量、设备的实时污染级别、实时南京市平均空气质量
     * @param count 返回数据条数
     * @return
     */
    EnvironmentMonitorRealTimeDataResult getEnvironmentMonitorRealTimeDate(int count);

    /**
     * 获取设备的实时空气质量、设备的实时污染级别、实时南京市平均空气质量
     * @return
     */
    EnvironmentMonitorAirQualityAllResult getDeviceAirQualityAll();

    /**
     * 获取所有设备未来72小时候的预测值,pm2.5，pm10
     * @return
     */
    List<DeviceIndexForecastDataResult> getEnvironmentMonitorIndexForecast();

}
