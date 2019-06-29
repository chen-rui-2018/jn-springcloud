package com.jn.hardware.environment.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jn.hardware.config.EnvironmentMonitorProperties;
import com.jn.hardware.environment.model.EnvironmentMonitorAsyncResult;
import com.jn.hardware.environment.model.EnvironmentMonitorAttr;
import com.jn.hardware.environment.service.EnvironmentMonitorAsyncTask;
import com.jn.hardware.environment.service.EnvironmentMonitorService;
import com.jn.hardware.model.environment.*;
import com.jn.hardware.util.JsonStringToObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 环境监测接口实现类
 *
 * @Author： cm
 * @Date： Created on 2019/6/22 16:25
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class EnvironmentMonitorServiceImpl implements EnvironmentMonitorService {
    /**
     * 日志组件
     */
    Logger logger = LoggerFactory.getLogger(EnvironmentMonitorServiceImpl.class);
    @Autowired
    private EnvironmentMonitorProperties environmentMonitorProperties;
    @Autowired
    private EnvironmentMonitorAsyncTask environmentMonitorAsyncTask;

    /**
     * 获取设备实时空气质量
     * @param count 返回数据条数
     * @return
     */
    @Override
    public List<DeviceRealTimeDataResult> getDeviceRealTimeData(int count) {
        logger.info("\n获取设备实时空气质量开始,方法入参：【{}】",count);
        String url = "";
        List<EnvironmentMonitorAsyncResult> futureList = new ArrayList<>();
        EnvironmentMonitorAsyncResult environmentMonitorAsyncResult;
        for(EnvironmentMonitorAttr environmentMonitorAttr : environmentMonitorProperties.getEnvironmentMonitorAttr()) {
            url = String.format(EnvironmentMonitorService.DEVICE_REAL_TIME_DATA_URL,environmentMonitorAttr.getSecKey(),count==0?1:count);
            environmentMonitorAsyncResult = new EnvironmentMonitorAsyncResult();
            environmentMonitorAsyncResult.setDeviceId(environmentMonitorAttr.getDeviceId());
            environmentMonitorAsyncResult.setAsyncResult(environmentMonitorAsyncTask.getDeviceRealTimeDataByAsync(url));
            futureList.add(environmentMonitorAsyncResult);
        }
        //结果归集
        List<EnvironmentMonitorAsyncResult> resultList = getEnvironmentMonitorAsyncResult(futureList);
        List<DeviceRealTimeDataResult> deviceRealTimeDataResults = null;
        if(null != resultList && resultList.size()>0) {
            deviceRealTimeDataResults = new ArrayList<>();
            for(EnvironmentMonitorAsyncResult asyncResult : resultList) {
                DeviceRealTimeDataResult deviceRealTimeDataResult = JsonStringToObjectUtil.jsonToObject(asyncResult.getResult(),new TypeReference<DeviceRealTimeDataResult>(){});
                if(null != deviceRealTimeDataResult) {
                    //把设备id保存进去
                    deviceRealTimeDataResult.setDeviceId(asyncResult.getDeviceId());
                }
                deviceRealTimeDataResults.add(deviceRealTimeDataResult);
            }
        }
        logger.info("\n获取设备实时空气质量结束,方法出参：【{}】",deviceRealTimeDataResults);
        return deviceRealTimeDataResults;
    }

    /**
     * 获取设备的统计数据
     * @param deviceAvgDataParam
     * @return
     */
    @Override
    public List<DeviceAvgDataResult> getDeviceAvgData(DeviceAvgDataParam deviceAvgDataParam) {
        logger.info("\n获取设备的统计数据开始,方法入参：【{}】",deviceAvgDataParam);
        String url = "";
        List<EnvironmentMonitorAsyncResult> futureList = new ArrayList<>();
        EnvironmentMonitorAsyncResult environmentMonitorAsyncResult;
        for(EnvironmentMonitorAttr environmentMonitorAttr : environmentMonitorProperties.getEnvironmentMonitorAttr()) {
            url = String.format(EnvironmentMonitorService.DEVICE_AVG_DATA_URL,environmentMonitorAttr.getSecKey(),deviceAvgDataParam.getType().getCode(),deviceAvgDataParam.getTime(),deviceAvgDataParam.getNum());
            environmentMonitorAsyncResult = new EnvironmentMonitorAsyncResult();
            environmentMonitorAsyncResult.setDeviceId(environmentMonitorAttr.getDeviceId());
            environmentMonitorAsyncResult.setAsyncResult(environmentMonitorAsyncTask.getDeviceAvgDataByAsync(url));
            futureList.add(environmentMonitorAsyncResult);
        }
        //结果归集
        List<EnvironmentMonitorAsyncResult> resultList = getEnvironmentMonitorAsyncResult(futureList);
        List<DeviceAvgDataResult> deviceAvgDataResults = null;
        if(null != resultList && resultList.size()>0) {
            deviceAvgDataResults = new ArrayList<>();
            for(EnvironmentMonitorAsyncResult asyncResult : resultList) {
                DeviceAvgDataResult deviceAvgDataResult = JsonStringToObjectUtil.jsonToObject(asyncResult.getResult(),new TypeReference<DeviceAvgDataResult>(){});
                if(null != deviceAvgDataResult) {
                    //把设备id保存进去
                    deviceAvgDataResult.setDeviceId(asyncResult.getDeviceId());
                }
                deviceAvgDataResults.add(deviceAvgDataResult);
            }
        }
        logger.info("\n获取设备的统计数据结束,方法出参：【{}】",deviceAvgDataResults);
        return deviceAvgDataResults;
    }

    /**
     * 获取设备的实时数据
     * 包含设备的指标实时值、设备的实时空气质量、实时南京市平均空气质量
     * @return
     */
    @Override
    public EnvironmentMonitorRealTimeDataResult getEnvironmentMonitorRealTimeDate(int count) {
        logger.info("\n获取设备的实时数据(包含设备的实时指标值、空气质量、南京市平均空气质量)开始,方法入参：【{}】",count);
        //获取设备的实时指标数据
        List<DeviceRealTimeDataResult> deviceRealTimeDataResults = this.getDeviceRealTimeData(count);
        //获取设备实时空气质量、实时南京市平均空气质量入参
        EnvironmentMonitorAirQualityAllResult environmentMonitorAirQualityAllResult = this.getDeviceAirQualityAll();
        //保存设备的实时指标值、设备的实时空气质量、实时南京市平均空气质量
        EnvironmentMonitorRealTimeDataResult environmentMonitorRealTimeDataResult = new EnvironmentMonitorRealTimeDataResult();
        environmentMonitorRealTimeDataResult.setDeviceRealTimeDataResults(deviceRealTimeDataResults);
        environmentMonitorRealTimeDataResult.setDeviceRealTimeAirQualityResults(environmentMonitorAirQualityAllResult.getDeviceRealTimeAirQualityResults());
        environmentMonitorRealTimeDataResult.setDeviceRealTimeCityAirQualityResults(environmentMonitorAirQualityAllResult.getDeviceRealTimeCityAirQualityResults());
        logger.info("\n获取设备的实时数据(包含设备的实时指标值、空气质量、南京市平均空气质量)结束,方法出参：【{}】",environmentMonitorRealTimeDataResult);
        return environmentMonitorRealTimeDataResult;
    }

    /**
     * 获取所有设备未来72小时候的预测值,pm2.5，pm10
     * @return
     */
    @Override
    public List<DeviceIndexForecastDataResult> getEnvironmentMonitorIndexForecast() {
        logger.info("\n获取所有设备未来72小时候的预测值,pm2.5，pm10开始");
        //获取设备的环境预测值 pm10、pm2.5
        List<EnvironmentMonitorAsyncResult> futureList = this.getEnvironmentMonitorAsyncResult(EnvironmentMonitorService.DEVICE_INDEX_FORECAST_URL);
        //获取设备的环境预测值 pm10、pm2.5 结果归集
        List<DeviceIndexForecastDataResult> deviceIndexForecastDataResults = this.getEnvironmentMonitorIndexForecastJoinResult(futureList);
        logger.info("\n获取所有设备未来72小时候的预测值,pm2.5，pm10结束,方法出参:【{}】",deviceIndexForecastDataResults);
        return deviceIndexForecastDataResults;
    }

    /**
     * 获取设备的实时空气质量、实时南京市平均空气质量
     * @return
     */
    @Override
    public EnvironmentMonitorAirQualityAllResult getDeviceAirQualityAll() {
        logger.info("\n获取设备的实时空气质量、实时南京市平均空气质量开始");
        //获取设备的实时空气质量
        List<EnvironmentMonitorAsyncResult> futureList = this.getEnvironmentMonitorAsyncResult(EnvironmentMonitorService.DEVICE_REAL_TIME_AIR_QUALITY_URL);
        //实时南京市平均空气质量
        List<EnvironmentMonitorAsyncResult> futureList2 = this.getEnvironmentMonitorAsyncResult(EnvironmentMonitorService.DEVICE_REAL_TIME_CITY_AIR_QUALITY_URL);
        //设备的实时空气质量结果归集
        List<DeviceRealTimeAirQualityResult> deviceRealTimeAirQualityResults = this.getDeviceRealTimeAirQualityJoinResult(futureList);
        //实时南京市平均空气质量结果归集
        List<DeviceRealTimeCityAirQualityResult> deviceRealTimeCityAirQualityResults = this.getDeviceRealTimeCityAirQualityJoinResult(futureList2);
        EnvironmentMonitorAirQualityAllResult environmentMonitorAirQualityAllResult = new EnvironmentMonitorAirQualityAllResult();
        environmentMonitorAirQualityAllResult.setDeviceRealTimeAirQualityResults(deviceRealTimeAirQualityResults);
        environmentMonitorAirQualityAllResult.setDeviceRealTimeCityAirQualityResults(deviceRealTimeCityAirQualityResults);
        logger.info("\n获取设备的实时空气质量、实时南京市平均空气质量结束,方法出参:【{}】",environmentMonitorAirQualityAllResult);
        return environmentMonitorAirQualityAllResult;
    }

    /**
     * 设备实时平均空气质量结果归集
     * @return
     */
    public List<DeviceRealTimeAirQualityResult> getDeviceRealTimeAirQualityJoinResult(List<EnvironmentMonitorAsyncResult> futureList) {
        List<EnvironmentMonitorAsyncResult> resultList = getEnvironmentMonitorAsyncResult(futureList);
        List<DeviceRealTimeAirQualityResult> deviceRealTimeAirQualityResults = null;
        if(null != resultList && resultList.size()>0) {
            deviceRealTimeAirQualityResults = new ArrayList<>();
            for(EnvironmentMonitorAsyncResult asyncResult : resultList) {
                DeviceRealTimeAirQualityResult deviceRealTimeAirQualityResult = JsonStringToObjectUtil.jsonToObject(asyncResult.getResult(),new TypeReference<DeviceRealTimeAirQualityResult>(){});
                if(null != deviceRealTimeAirQualityResult) {
                    //把设备id保存进去
                    deviceRealTimeAirQualityResult.setDeviceId(asyncResult.getDeviceId());
                }
                deviceRealTimeAirQualityResults.add(deviceRealTimeAirQualityResult);
            }
        }
        return deviceRealTimeAirQualityResults;
    }

    /**
     * 实时南京市平均空气质量结果归集
     * @return
     */
    public List<DeviceRealTimeCityAirQualityResult> getDeviceRealTimeCityAirQualityJoinResult(List<EnvironmentMonitorAsyncResult> futureList) {
        List<EnvironmentMonitorAsyncResult> resultList = getEnvironmentMonitorAsyncResult(futureList);
        List<DeviceRealTimeCityAirQualityResult> deviceRealTimeCityAirQualityResults = null;
        if(null != resultList && resultList.size()>0) {
            deviceRealTimeCityAirQualityResults = new ArrayList<>();
            for(EnvironmentMonitorAsyncResult asyncResult : resultList) {
                DeviceRealTimeCityAirQualityResult deviceRealTimeCityAirQualityResult = JsonStringToObjectUtil.jsonToObject(asyncResult.getResult(),new TypeReference<DeviceRealTimeCityAirQualityResult>(){});
                if(null != deviceRealTimeCityAirQualityResult) {
                    //把设备id保存进去
                    deviceRealTimeCityAirQualityResult.setDeviceId(asyncResult.getDeviceId());
                }
                deviceRealTimeCityAirQualityResults.add(deviceRealTimeCityAirQualityResult);
            }
        }
        return deviceRealTimeCityAirQualityResults;
    }

    /**
     * 获取设备的环境预测值 pm10、pm2.5 结果归集
     * @return
     */
    public List<DeviceIndexForecastDataResult> getEnvironmentMonitorIndexForecastJoinResult(List<EnvironmentMonitorAsyncResult> futureList) {
        List<EnvironmentMonitorAsyncResult> resultList = getEnvironmentMonitorAsyncResult(futureList);
        List<DeviceIndexForecastDataResult> deviceIndexForecastDataResults = null;
        if(null != resultList && resultList.size()>0) {
            deviceIndexForecastDataResults = new ArrayList<>();
            for(EnvironmentMonitorAsyncResult asyncResult : resultList) {
                DeviceIndexForecastDataResult deviceIndexForecastDataResult = JsonStringToObjectUtil.jsonToObject(asyncResult.getResult(),new TypeReference<DeviceIndexForecastDataResult>(){});
                if(null != deviceIndexForecastDataResult) {
                    //把设备id保存进去
                    deviceIndexForecastDataResult.setDeviceId(asyncResult.getDeviceId());
                }
                deviceIndexForecastDataResults.add(deviceIndexForecastDataResult);
            }
        }
        return deviceIndexForecastDataResults;
    }

    /**
     * 异步获取环境监测设备实时空气或南京市空气
     * @param url
     * @return
     */
    public List<EnvironmentMonitorAsyncResult> getEnvironmentMonitorAsyncResult(String url) {
        List<EnvironmentMonitorAsyncResult> futureList = new ArrayList<>();
        EnvironmentMonitorAsyncResult environmentMonitorAsyncResult;
        for(EnvironmentMonitorAttr environmentMonitorAttr : environmentMonitorProperties.getEnvironmentMonitorAttr()) {
            url = String.format(url,environmentMonitorAttr.getDeviceId());
            environmentMonitorAsyncResult = new EnvironmentMonitorAsyncResult();
            environmentMonitorAsyncResult.setDeviceId(environmentMonitorAttr.getDeviceId());
            environmentMonitorAsyncResult.setAsyncResult(environmentMonitorAsyncTask.getDeviceRealTimePolluteLeveByAsync(url));
            futureList.add(environmentMonitorAsyncResult);
        }
        return futureList;
    }

    /**
     * 结果归集，用迭代器遍历futureList,组装并返回结果集
     * @param futureList
     * @return
     */
    public List<EnvironmentMonitorAsyncResult> getEnvironmentMonitorAsyncResult(List<EnvironmentMonitorAsyncResult> futureList) {
        if(null == futureList || futureList.size()==0) {
            return null;
        }
        List<EnvironmentMonitorAsyncResult> list = new ArrayList<>();
        while(futureList.size()>0){
            Iterator<EnvironmentMonitorAsyncResult> iterable = futureList.iterator();
            while(iterable.hasNext()){
                EnvironmentMonitorAsyncResult environmentMonitorAsyncResult = iterable.next();
                if (environmentMonitorAsyncResult.getAsyncResult().isDone() && !environmentMonitorAsyncResult.getAsyncResult().isCancelled()){
                    try {
                        environmentMonitorAsyncResult.setResult(environmentMonitorAsyncResult.getAsyncResult().get());
                        list.add(environmentMonitorAsyncResult);
                        //任务完成移除任务
                        iterable.remove();
                    } catch (InterruptedException e) {
                        //报错移除任务,测试环境硬件接口响应时间相当不稳定基本在20左右，不影响测试，超时就移除,避免死循环
                        iterable.remove();
                        Thread.currentThread().interrupt();
                    } catch (ExecutionException e) {
                        //报错移除任务,测试环境硬件接口响应时间相当不稳定基本在20左右，不影响测试，超时就移除,避免死循环
                        iterable.remove();
                        e.printStackTrace();
                    }
                }
            }
        }
        return list;
    }


}
