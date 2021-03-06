package com.jn.park.enviroment.service;

/**
 * 环境监测service
 *
 * @author： shaobao
 * @date： Created on 2019/6/27 20:33
 * @version： v1.0
 * @modified By:
 **/
public interface EnvironmentMonitorService {

    /**
     * 获取设备的实时数据
     * 包含设备的指标实时值、设备的实时空气质量、设备的实时污染级别、实时南京市平均空气质量
     *
     * @param hour
     * @return 1:获取数据成功 2:当前时间数据已存在 0:获取数据失败
     */
    Integer getEnvironmentMonitorRealTimeDate(Integer hour);

}
