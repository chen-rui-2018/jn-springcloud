package com.jn.hardware.environment.service;

import com.jn.common.util.RestTemplateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * 环境监测异步请求第三方接口
 *
 * @Author： cm
 * @Date： Created on 2019/6/23 11:31
 * @Version： v1.0
 * @Modified By:
 */
@Component
public class EnvironmentMonitorAsyncTask {
    /**
     * 日志组件
     */
    Logger logger = LoggerFactory.getLogger(EnvironmentMonitorAsyncTask.class);
    /**
     * 异步获取设备实时数据
     * @param url
     * @return
     */
    @Async
    public Future<String> getDeviceRealTimeDataByAsync(String url) {
        String result = RestTemplateUtil.get(url);
        logger.info("\n获取设备实时数据接口入参：【{}】,接口出参：【{}】",url,result);
        return new AsyncResult<String>(result);
    }

    /**
     * 异步获取设备的统计数据
     * @param url
     * @return
     */
    @Async
    public Future<String> getDeviceAvgDataByAsync(String url) {
        String result = RestTemplateUtil.get(url);
        logger.info("\n获取设备的统计数据接口入参：【{}】,接口出参：【{}】",url,result);
        return new AsyncResult<String>(result);
    }

    /**
     * 异步获取环境监测设备实时空气或南京市空气或设备实时污染级别
     * @param url
     * @return
     */
    @Async
    public Future<String> getDeviceRealTimePolluteLeveByAsync(String url) {
        String result = RestTemplateUtil.get(url);
        logger.info("\n获取环境监测设备实时空气或南京市空气或未来pm10和pm2.5预测值的接口入参：【{}】,接口出参：【{}】",url,result);
        return new AsyncResult<String>(result);
    }

}
