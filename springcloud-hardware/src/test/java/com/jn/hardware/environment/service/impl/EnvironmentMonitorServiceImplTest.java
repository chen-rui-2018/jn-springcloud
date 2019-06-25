package com.jn.hardware.environment.service.impl;

import com.jn.hardware.electricmeter.service.impl.ElectricMeterServiceImplTest;
import com.jn.hardware.enums.environment.DeviceAvgTypeEnum;
import com.jn.hardware.environment.service.EnvironmentMonitorService;
import com.jn.hardware.model.environment.DeviceAvgDataParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnvironmentMonitorServiceImplTest {

    /**
     * 日志组件
     */
    Logger logger = LoggerFactory.getLogger(ElectricMeterServiceImplTest.class);

    @Autowired
    private EnvironmentMonitorService environmentMonitorService;

    /**
     * 获取设备实时数据
     */
    @Test
    public void getDeviceRealTimeData() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        logger.info("\n获取设备实时数据开始============="+df.format(new Date()));
        logger.info("\n获取设备实时数据结果===="+environmentMonitorService.getDeviceRealTimeData(1));
        logger.info("\n获取设备实时数据结束============="+df.format(new Date()));
    }

    /**
     * 获取设备的统计数据 设备的指标平均值
     */
    @Test
    public void getDeviceAvgData() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("\n获取设备的统计数据 设备的指标平均值开始============="+df.format(new Date()));
        DeviceAvgDataParam deviceAvgDataParam = new DeviceAvgDataParam();
        deviceAvgDataParam.setTime("20190624000000");
        deviceAvgDataParam.setType(DeviceAvgTypeEnum.DEVICE_AVG_HOUR_TYPE);
        logger.info("\n获取设备的统计数据 设备的指标平均值结果===="+environmentMonitorService.getDeviceAvgData(deviceAvgDataParam));
        logger.info("\n获取设备的统计数据 设备的指标平均值结束============="+df.format(new Date()));
    }

    /**
     * 获取设备的实时数据
     * 包含设备的指标实时值、设备的实时空气质量、设备的实时污染级别、实时南京市平均空气质量
     */
    @Test
    public void getEnvironmentMonitorRealTimeDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        logger.info("\n获取设备的实时数据,包含设备的实时指标值、空气质量、污染级别、南京市平均空气质量开始============="+df.format(new Date()));
        logger.info("\n获取设备的实时数据,包含设备的实时指标值、空气质量、污染级别、南京市平均空气质量结果===="+environmentMonitorService.getEnvironmentMonitorRealTimeDate(1));
        logger.info("\n获取设备的实时数据,包含设备的实时指标值、空气质量、污染级别、南京市平均空气质量结束============="+df.format(new Date()));
    }

    /**
     * 获取所有设备未来72小时候的预测值,pm2.5，pm10
     */
    @Test
    public void getEnvironmentMonitorIndexForecast() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        logger.info("\n获取所有设备未来72小时候的预测值,pm2.5，pm10开始============="+df.format(new Date()));
        logger.info("\n获取所有设备未来72小时候的预测值,pm2.5，pm10结果===="+environmentMonitorService.getEnvironmentMonitorIndexForecast());
        logger.info("\n获取所有设备未来72小时候的预测值,pm2.5，pm10结束============="+df.format(new Date()));
    }

    /**
     * 获取设备的实时空气质量、设备的实时污染级别、实时南京市平均空气质量
     */
    @Test
    public void getDeviceAirQualityAll() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        logger.info("\n获取设备的实时空气质量、设备的实时污染级别、实时南京市平均空气质量开始============="+df.format(new Date()));
        logger.info("\n获取设备的实时空气质量、设备的实时污染级别、实时南京市平均空气质量结果===="+environmentMonitorService.getDeviceAirQualityAll());
        logger.info("\n获取设备的实时空气质量、设备的实时污染级别、实时南京市平均空气质量结束============="+df.format(new Date()));
    }
}