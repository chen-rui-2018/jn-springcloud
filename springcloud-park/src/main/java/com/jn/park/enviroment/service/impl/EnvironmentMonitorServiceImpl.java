package com.jn.park.enviroment.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.StringUtils;
import com.jn.hardware.api.EnvironmentMonitorClient;
import com.jn.hardware.model.environment.*;
import com.jn.park.attractinvest.service.impl.BusinessAdServiceImpl;
import com.jn.park.enviroment.dao.TbEnviDeviceRecordAirQualityMapper;
import com.jn.park.enviroment.dao.TbEnviDeviceRecordAvgMapper;
import com.jn.park.enviroment.dao.TbEnviDeviceRecordMapper;
import com.jn.park.enviroment.enmus.DeviceResponseStatusEnmus;
import com.jn.park.enviroment.enmus.EnviStatusEnums;
import com.jn.park.enviroment.enmus.ParkOrCityEnums;
import com.jn.park.enviroment.entity.TbEnviDeviceRecord;
import com.jn.park.enviroment.entity.TbEnviDeviceRecordAirQuality;
import com.jn.park.enviroment.entity.TbEnviDeviceRecordAvg;
import com.jn.park.enviroment.entity.TbEnviDeviceRecordAvgCriteria;
import com.jn.park.enviroment.service.EnvironmentMonitorService;
import com.jn.send.api.DelaySendMessageClient;
import com.jn.send.model.Delay;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

/**
 * 环境监测service实现
 *
 * @author： shaobao
 * @date： Created on 2019/6/27 20:34
 * @version： v1.0
 * @modified By:
 **/
@Service
public class EnvironmentMonitorServiceImpl implements EnvironmentMonitorService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(BusinessAdServiceImpl.class);

    @Autowired
    private EnvironmentMonitorClient environmentMonitorClient;
    @Autowired
    private TbEnviDeviceRecordMapper tbEnviDeviceRecordMapper;
    @Autowired
    private TbEnviDeviceRecordAvgMapper tbEnviDeviceRecordAvgMapper;
    @Autowired
    private TbEnviDeviceRecordAirQualityMapper tbEnviDeviceRecordAirQualityMapper;
    @Autowired
    private DelaySendMessageClient delaySendMessageClient;


    /**
     * 获取环境监测时时数据
     *
     * @param hour 小时
     */
    @Override
    @ServiceLog(doAction = "获取环境监测时时数据")
    @Transactional(rollbackFor = Exception.class)
    public void getEnvironmentMonitorRealTimeDate(Integer hour) {
        //当前时间小时
        Calendar calendar = Calendar.getInstance();
        int currHour = calendar.get(Calendar.HOUR_OF_DAY);

        //判断传入的hour数值,-1直接跳过,不是-1且hour与当前小时不能,则终止方法,防止方法获取不到监测数据,无限发定时消息
        if (hour != -1 && currHour != hour) {
            return;
        }

        //1.查询当前小时时候存在环境指标数值
        TbEnviDeviceRecordAvgCriteria tbEnviDeviceRecordAvgCriteria = new TbEnviDeviceRecordAvgCriteria();
        TbEnviDeviceRecordAvgCriteria.Criteria criteria = tbEnviDeviceRecordAvgCriteria.createCriteria();
        criteria.andDealDateEqualTo(new Date());
        criteria.andHourEqualTo(currHour);
        criteria.andRecordStatusEqualTo(new Byte(EnviStatusEnums.EFFECTIVE.getCode()));
        List<TbEnviDeviceRecordAvg> tbEnviDeviceRecordAvgs =
                tbEnviDeviceRecordAvgMapper.selectByExample(tbEnviDeviceRecordAvgCriteria);

        //如果当前时间指标值已存在,则不再获取数值
        if (tbEnviDeviceRecordAvgs != null && tbEnviDeviceRecordAvgs.size() > 0) {
            return;
        }

        //2.调用硬件接口,获取环境设置监测数据
        Result<EnvironmentMonitorRealTimeDataResult> result = null;
        try {
            result = environmentMonitorClient.getEnvironmentMonitorRealTimeDate(1);
        } catch (Exception e) {
            //10分钟后重新获取环境监测数据
            delayGetEnviRecord(currHour);
            return;
        }
        if (StringUtils.equals(GlobalConstants.SUCCESS_CODE, result.getCode())) {

            String environmentResult = JSONObject.toJSONString(result);
            String currTime = DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
            logger.info("[环境监测] 获取环境监测设备监测各项指标数据,监测数据:{},当前时间:{}", environmentResult, currTime);

            //3.分析监测数据
            EnvironmentMonitorRealTimeDataResult environmentMonitorData = result.getData();
            if (environmentMonitorData == null) {
                //10分钟后重新获取环境监测数据
                delayGetEnviRecord(currHour);
            } else {
                //温度数值集合
                List<String> temperList = new ArrayList<String>(16);
                //湿度数值集合
                List<String> humList = new ArrayList<String>(16);
                //pm2.5数值集合
                List<String> pm25List = new ArrayList<String>(16);
                //pm10数值集合
                List<String> pm10List = new ArrayList<String>(16);
                //园区空气指数数值集合
                List<String> parkAirQualityList = new ArrayList<String>(16);
                //市区空气指数数值集合
                List<String> cityAirQualityList = new ArrayList<String>(16);

                //4.分析环境监测温度,湿度,pm2.5,pm10数据
                analyzeDeviceRecord(environmentMonitorData, tbEnviDeviceRecordMapper, temperList, humList, pm25List, pm10List);

                //5.分析保存园区空气质量数据
                analyzeParkAirQuality(environmentMonitorData, tbEnviDeviceRecordAirQualityMapper, parkAirQualityList);

                //6.分析保存市区空气质量数据
                analyzeCityAirQuality(environmentMonitorData, tbEnviDeviceRecordAirQualityMapper, cityAirQualityList);

                //7.分析保存各项指标平均值
                insetDeviceAvgRecord(temperList, humList, pm25List, pm10List, parkAirQualityList, cityAirQualityList);

            }

        } else {
            //10分钟后重新获取环境监测数据
            delayGetEnviRecord(currHour);
        }
    }

    /**
     * 定时10分钟重新获取环境监测数据
     *
     * @param currHour
     */
    private void delayGetEnviRecord(int currHour) {
        logger.warn("[环境监测] 获取环境监测数据失败!延时10分钟后重新获取");
        // 4.创建企业的账本信息-延迟调度
        Delay delay = new Delay();
        delay.setServiceId("springcloud-park");
        delay.setServiceUrl("/api/park/getEnvironmentMonitorRealTimeDate");
        //设置延时10分钟
        delay.setTtl("600000");
        delay.setDataString(currHour + "");
        logger.info("开始回调");
        Result<Boolean> delayResult = delaySendMessageClient.delaySend(delay);
        logger.info("结束回调,返回结果，【{}】", delayResult.toString());
    }

    /**
     * 保存各项指标平均值数据
     *
     * @param temperList
     * @param humList
     * @param pm25List
     * @param pm10List
     * @param parkAirQualityList
     * @param cityAirQualityList
     */
    private void insetDeviceAvgRecord(List<String> temperList, List<String> humList, List<String> pm25List, List<String> pm10List, List<String> parkAirQualityList, List<String> cityAirQualityList) {
        TbEnviDeviceRecordAvg tbEnviDeviceRecordAvg = new TbEnviDeviceRecordAvg();
        tbEnviDeviceRecordAvg.setId(UUID.randomUUID().toString());
        //设置当前日期
        tbEnviDeviceRecordAvg.setDealDate(new Date());
        //设置小时
        Calendar calendar = Calendar.getInstance();
        tbEnviDeviceRecordAvg.setHour(calendar.get(Calendar.HOUR_OF_DAY));

        //计算当前时间温度平均值
        BigDecimal temperAvg = new BigDecimal(0);
        for (String temper : temperList) {
            BigDecimal temp = new BigDecimal(temper);
            temperAvg = temperAvg.add(temp);
        }
        BigDecimal temperSize = new BigDecimal(temperList.size());
        temperAvg = temperAvg.divide(temperSize, 1, BigDecimal.ROUND_HALF_UP);
        tbEnviDeviceRecordAvg.setTemper(temperAvg.toString());

        //计算当前湿度平均值
        BigDecimal humAvg = new BigDecimal(0);
        for (String hum : humList) {
            BigDecimal humVal = new BigDecimal(hum);
            humAvg = humAvg.add(humVal);
        }
        BigDecimal humSize = new BigDecimal(humList.size());
        humAvg = humAvg.divide(humSize, 1, BigDecimal.ROUND_HALF_UP);
        tbEnviDeviceRecordAvg.setHum(humAvg.toString());

        //计算当前时间pm2.5平均值
        BigDecimal pm25Avg = new BigDecimal(0);
        for (String pm25 : pm25List) {
            BigDecimal pm25Val = new BigDecimal(pm25);
            pm25Avg = pm25Avg.add(pm25Val);
        }
        BigDecimal pm25Size = new BigDecimal(pm25List.size());
        pm25Avg = pm25Avg.divide(pm25Size, 2, BigDecimal.ROUND_HALF_UP);
        tbEnviDeviceRecordAvg.setPm25(pm25Avg.toString());

        //计算当前时间pm10的平均值
        BigDecimal pm10Avg = new BigDecimal(0);
        for (String pm10 : pm10List) {
            BigDecimal pm10Val = new BigDecimal(pm10);
            pm10Avg = pm10Avg.add(pm10Val);
        }
        BigDecimal pm10Size = new BigDecimal(pm10List.size());
        pm10Avg = pm10Avg.divide(pm10Size, 2, BigDecimal.ROUND_HALF_UP);
        tbEnviDeviceRecordAvg.setPm10(pm10Avg.toString());

        //计算当前时间园区空气质量平均值及级别
        BigDecimal parkAirQualityAvg = new BigDecimal(0);
        for (String parkAirQuality : parkAirQualityList) {
            BigDecimal parkAirQualityVal = new BigDecimal(parkAirQuality);
            parkAirQualityAvg = parkAirQualityAvg.add(parkAirQualityVal);
        }
        BigDecimal parkAirQualitySize = new BigDecimal(parkAirQualityList.size());
        parkAirQualityAvg = parkAirQualityAvg.divide(parkAirQualitySize, 2, BigDecimal.ROUND_HALF_UP);
        tbEnviDeviceRecordAvg.setParkAirQuality(parkAirQualityAvg.toString());

        //设置园区空气质量等级
        String parkAirQualityLevel = getAirQualityLevel(parkAirQualityAvg);
        tbEnviDeviceRecordAvg.setParkAirQualityLevel(parkAirQualityLevel);

        //计算当前时间市区空气质量平均值及级别
        BigDecimal cityAirQualityAvg = new BigDecimal(0);
        for (String cityAirQuality : cityAirQualityList) {
            BigDecimal cityAirQualityVal = new BigDecimal(cityAirQuality);
            cityAirQualityAvg = cityAirQualityAvg.add(cityAirQualityVal);
        }
        BigDecimal cityAirQualitySize = new BigDecimal(cityAirQualityList.size());
        cityAirQualityAvg = cityAirQualityAvg.divide(cityAirQualitySize, 2, BigDecimal.ROUND_HALF_UP);
        tbEnviDeviceRecordAvg.setCityAirQuality(cityAirQualityAvg.toString());

        //设置市区空气质量等级
        String cityAirQualityLevel = getAirQualityLevel(cityAirQualityAvg);
        tbEnviDeviceRecordAvg.setCityAirQualityLevel(cityAirQualityLevel);
        //设置状态
        tbEnviDeviceRecordAvg.setRecordStatus(new Byte(EnviStatusEnums.EFFECTIVE.getCode()));
        //设置创建时间
        tbEnviDeviceRecordAvg.setCreatedTime(new Date());
        //将数据保存只数据库
        tbEnviDeviceRecordAvgMapper.insertSelective(tbEnviDeviceRecordAvg);
        logger.info("[环境监测] 将各项监测数据保存数据库成功");
    }

    /**
     * 根据空气质量指数,判断空气质量等级
     *
     * @param parkAirQualityAvg
     * @return
     */
    private String getAirQualityLevel(BigDecimal parkAirQualityAvg) {
        String parkAirQualityLevel = null;
        if (new BigDecimal(0).compareTo(parkAirQualityAvg) < 1
                && new BigDecimal(50).compareTo(parkAirQualityAvg) > -1) {
            parkAirQualityLevel = "优";
        } else if (new BigDecimal(51).compareTo(parkAirQualityAvg) < 1
                && new BigDecimal(100).compareTo(parkAirQualityAvg) > -1) {
            parkAirQualityLevel = "良";
        } else if (new BigDecimal(101).compareTo(parkAirQualityAvg) < 1
                && new BigDecimal(150).compareTo(parkAirQualityAvg) > -1) {
            parkAirQualityLevel = "轻度污染";
        } else if (new BigDecimal(151).compareTo(parkAirQualityAvg) < 1
                && new BigDecimal(200).compareTo(parkAirQualityAvg) > -1) {
            parkAirQualityLevel = "中度污染";
        } else if (new BigDecimal(201).compareTo(parkAirQualityAvg) < 1
                && new BigDecimal(300).compareTo(parkAirQualityAvg) > -1) {
            parkAirQualityLevel = "重度污染";
        } else if (new BigDecimal(301).compareTo(parkAirQualityAvg) < 1) {
            parkAirQualityLevel = "严重污染";
        }
        return parkAirQualityLevel;
    }

    /**
     * 分析市区空气质量
     *
     * @param environmentMonitorData
     * @param tbEnviDeviceRecordAirQualityMapper
     * @param cityAirQualityList
     */
    private void analyzeCityAirQuality(EnvironmentMonitorRealTimeDataResult environmentMonitorData,
                                       TbEnviDeviceRecordAirQualityMapper tbEnviDeviceRecordAirQualityMapper,
                                       List<String> cityAirQualityList) {
        List<DeviceRealTimeCityAirQualityResult> deviceRealTimeCityAirQualityResults =
                environmentMonitorData.getDeviceRealTimeCityAirQualityResults();
        for (DeviceRealTimeCityAirQualityResult deviceRealTimeCityAirQualityResult : deviceRealTimeCityAirQualityResults) {

            //判断响应是否成功
            String issuccess = deviceRealTimeCityAirQualityResult.getIssuccess();
            if (StringUtils.equals(DeviceResponseStatusEnmus.SUCCESS.getCode(), issuccess)) {
                //响应成功,将数据保存只数据库
                TbEnviDeviceRecordAirQuality tbEnviDeviceRecordAirQuality = new TbEnviDeviceRecordAirQuality();
                tbEnviDeviceRecordAirQuality.setId(UUID.randomUUID().toString());
                // 状态标识，false:失败 true:成功
                tbEnviDeviceRecordAirQuality.setIssuccess(issuccess);
                //状态描述
                tbEnviDeviceRecordAirQuality.setMessage(deviceRealTimeCityAirQualityResult.getMessage());
                //设备实时空气质量数值
                String data = deviceRealTimeCityAirQualityResult.getData();
                tbEnviDeviceRecordAirQuality.setAirQuality(data);
                if (StringUtils.isNotBlank(data)) {
                    cityAirQualityList.add(data);
                }
                // 设备id
                tbEnviDeviceRecordAirQuality.setDeviceId(deviceRealTimeCityAirQualityResult.getDeviceId());
                //设置创建时间
                tbEnviDeviceRecordAirQuality.setCreatedTime(new Date());
                //设置状态
                tbEnviDeviceRecordAirQuality.setRecordStatus(new Byte(EnviStatusEnums.EFFECTIVE.getCode()));
                //设置是园区数据
                tbEnviDeviceRecordAirQuality.setParkOrCity(ParkOrCityEnums.CITY.getCode());
                //将数据保存只数据库
                tbEnviDeviceRecordAirQualityMapper.insertSelective(tbEnviDeviceRecordAirQuality);
                logger.info("[环境监测] 将市区空气质量数据保存数据库成功");
            } else {
                //响应失败,则跳过当前数据
                continue;
            }
        }
    }

    /**
     * 分析园区空气质量指数
     *
     * @param environmentMonitorData
     * @param tbEnviDeviceRecordAirQualityMapper
     * @param parkAirQualityList
     */
    private void analyzeParkAirQuality(EnvironmentMonitorRealTimeDataResult environmentMonitorData,
                                       TbEnviDeviceRecordAirQualityMapper tbEnviDeviceRecordAirQualityMapper,
                                       List<String> parkAirQualityList) {
        List<DeviceRealTimeAirQualityResult> deviceRealTimeAirQualityResults =
                environmentMonitorData.getDeviceRealTimeAirQualityResults();
        for (DeviceRealTimeAirQualityResult deviceRealTimeAirQualityResult : deviceRealTimeAirQualityResults) {

            //判断响应是否成功
            String issuccess = deviceRealTimeAirQualityResult.getIssuccess();
            if (StringUtils.equals(DeviceResponseStatusEnmus.SUCCESS.getCode(), issuccess)) {
                //响应成功,将数据保存只数据库
                TbEnviDeviceRecordAirQuality tbEnviDeviceRecordAirQuality = new TbEnviDeviceRecordAirQuality();
                tbEnviDeviceRecordAirQuality.setId(UUID.randomUUID().toString());
                // 状态标识，false:失败 true:成功
                tbEnviDeviceRecordAirQuality.setIssuccess(issuccess);
                //状态描述
                tbEnviDeviceRecordAirQuality.setMessage(deviceRealTimeAirQualityResult.getMessage());
                //设备实时空气质量数值
                String data = deviceRealTimeAirQualityResult.getData();
                tbEnviDeviceRecordAirQuality.setAirQuality(data);
                if (StringUtils.isNotBlank(data)) {
                    parkAirQualityList.add(data);
                }
                //设备实时污染级别数值
                tbEnviDeviceRecordAirQuality.setLeveldata(deviceRealTimeAirQualityResult.getLevelData());
                // 设备id
                tbEnviDeviceRecordAirQuality.setDeviceId(deviceRealTimeAirQualityResult.getDeviceId());
                //设置创建时间
                tbEnviDeviceRecordAirQuality.setCreatedTime(new Date());
                //设置状态
                tbEnviDeviceRecordAirQuality.setRecordStatus(new Byte(EnviStatusEnums.EFFECTIVE.getCode()));
                //设置是园区数据
                tbEnviDeviceRecordAirQuality.setParkOrCity(ParkOrCityEnums.PARK.getCode());

                //将数据保存只数据库
                tbEnviDeviceRecordAirQualityMapper.insertSelective(tbEnviDeviceRecordAirQuality);
                logger.info("[环境监测] 将园区空气质量数据保存数据库成功");
            } else {
                //响应失败,则跳过当前数据
                continue;
            }
        }
    }

    /**
     * 分析环境监测各项指标数据
     *
     * @param environmentMonitorData
     * @param tbEnviDeviceRecordMapper
     * @param temperList
     * @param humList
     * @param pm25List
     * @param pm10List
     */
    private void analyzeDeviceRecord(EnvironmentMonitorRealTimeDataResult environmentMonitorData,
                                     TbEnviDeviceRecordMapper tbEnviDeviceRecordMapper, List<String> temperList,
                                     List<String> humList, List<String> pm25List, List<String> pm10List) {
        List<DeviceRealTimeDataResult> deviceRealTimeDataResults =
                environmentMonitorData.getDeviceRealTimeDataResults();
        for (DeviceRealTimeDataResult deviceRealTimeDataResult : deviceRealTimeDataResults) {
            //判断当前设备是否响应成功
            String success = deviceRealTimeDataResult.getSuccess();
            if (StringUtils.equals(DeviceResponseStatusEnmus.SUCCESS.getCode(), success)) {
                //如果响应成功,记录数据
                List<DeviceData> data = deviceRealTimeDataResult.getData();
                for (DeviceData datum : data) {

                    //封装环境监测温度,湿度,pm2.5,pm10数据
                    TbEnviDeviceRecord tbEnviDeviceRecord = new TbEnviDeviceRecord();
                    //设置id
                    tbEnviDeviceRecord.setId(UUID.randomUUID().toString());
                    //设置当前时间
                    tbEnviDeviceRecord.setDealDate(new Date());
                    try {
                        if (datum.getTime() != null){
                            Date resTime = DateUtils.parseDate(datum.getTime(), "yyyy-MM-dd HH:mm:ss");
                            //设置设备记录时间
                            tbEnviDeviceRecord.setDeviceRecordTime(resTime);
                            //设置当前小时数
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(resTime);
                            tbEnviDeviceRecord.setHour(calendar.get(Calendar.HOUR_OF_DAY));
                        }
                    } catch (ParseException e) {
                        logger.error("[环境监测] 设备监测时间解析异常,e:{}", e.getMessage());
                    }
                    //设置设备id
                    tbEnviDeviceRecord.setDeviceId(datum.getDevId());
                    //设置湿度
                    String hum = datum.getHum();
                    tbEnviDeviceRecord.setHum(hum);
                    if (StringUtils.isNotBlank(hum)) {
                        humList.add(hum);
                    }
                    //设置纬度
                    tbEnviDeviceRecord.setLat(datum.getLat());
                    //设置亮度
                    tbEnviDeviceRecord.setLight(datum.getLight());
                    //设置经度
                    tbEnviDeviceRecord.setLog(datum.getLog());
                    //设置PM10
                    String pm10 = datum.getPm10();
                    tbEnviDeviceRecord.setPm10(pm10);
                    if (StringUtils.isNotBlank(pm10)) {
                        pm10List.add(pm10);
                    }
                    //设置PM2.5
                    String pm25 = datum.getPm25();
                    tbEnviDeviceRecord.setPm25(pm25);
                    if (StringUtils.isNotBlank(pm25)) {
                        pm25List.add(pm25);
                    }
                    //设置温度
                    String temper = datum.getTemper();
                    tbEnviDeviceRecord.setTemper(temper);
                    if (StringUtils.isNotBlank(temper)) {
                        temperList.add(temper);
                    }
                    //设置远程IP
                    tbEnviDeviceRecord.setRemoteIp(datum.getRemoteIp());
                    //设置创建时间
                    tbEnviDeviceRecord.setCreatedTime(new Date());
                    //设置状态
                    tbEnviDeviceRecord.setRecordStatus(new Byte(EnviStatusEnums.EFFECTIVE.getCode()));

                    //将各项环境数据指标添加到集合
                    tbEnviDeviceRecordMapper.insertSelective(tbEnviDeviceRecord);
                    logger.info("[环境监测] 将监测各项指标数据保存数据库成功");
                }
            } else {
                //响应失败,则跳过当前数据
                continue;
            }
        }
    }

}
