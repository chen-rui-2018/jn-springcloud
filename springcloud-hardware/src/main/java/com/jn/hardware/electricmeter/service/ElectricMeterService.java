package com.jn.hardware.electricmeter.service;

import com.jn.common.model.Result;
import com.jn.hardware.model.electricmeter.*;

import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/23 16:57
 * @version： v1.0
 * @modified By:
 */
public interface ElectricMeterService {
    /**
     * 电表access_token获取路径
     * todo 后面需写在配置文件中
     */
    String POST_ELECTRIC_ACCESS_TOKEN_URL = "http://api.leiyoukeji.com/oauth/token";
    /**
     * 物业下的所有建筑信息 获取路径
     * todo 后面需写在配置文件中
     */
    String GET_BUILDING_INFO_URL = "http://api.leiyoukeji.com/api/queryBuilding?access_token=%s";
    /**
     * 建筑下仪表信息 获取路径
     * todo 后面需写在配置文件中
     */
    String GET_ELECTRIC_METER_INFO_URL = "http://api.leiyoukeji.com/api/queryDevice?access_token=%s&code=%s&pageNum=%s&pageSize=%s";
    /**
     * 仪表状态 获取路径
     * todo 后面需写在配置文件中
     */
    String GET_ELECTRIC_METER_STATUS_URL = "http://api.leiyoukeji.com/api/queryDeviceStatus?access_token=%s&code=%s";
    /**
     * 仪表开关操作 操作路径
     * todo 后面需写在配置文件中
     */
    String GET_ELECTRIC_METER_SWITCH_URL = "http://api.leiyoukeji.com/api/indicateDevice?access_token=%s&code=%s&flag=%s";
    /**
     * 数据采集,有code查询
     * todo 后面需写在配置文件中
     */
    String GET_ELECTRIC_DATA_COLLECTION_URL = "http://api.leiyoukeji.com/api/queryDeviceDate?code=%s&deviceType=%s&startTime=%s&access_token=%s&pageNum=%s&pageSize=%s";
/**
     * 数据采集,无code查询
     * todo 后面需写在配置文件中
     */
    String GET_ELECTRIC_DATA_COLLECTION_NOCODE_URL = "http://api.leiyoukeji.com/api/queryDeviceDate?deviceType=%s&startTime=%s&access_token=%s&pageNum=%s&pageSize=%s";

    /**
     * 获取电表平台access_token接口
     * @param electricAccessTokenParam
     * @return
     */
    Result<ElectricAccessTokenShow> getElectricMeterAccessToken(ElectricAccessTokenParam electricAccessTokenParam);

    /**
     * 获取物业下的所有建筑信息
     * @return
     */
    Result<List<ElectricMeterBuildingShow>> getElectricBuildingInfo();

    /**
     * 获取建筑下的仪表信息
     * @param electricMeterInfoParam
     * @return
     */
    Result<ElectricMeterInfoShow> getElectricMeterForBuilding(ElectricMeterInfoParam electricMeterInfoParam);

    /**
     * 获取仪表开关状态  ,仪表开关状态  0-关闭；1-开启;''-没有这个仪表
     * @param code
     * @return
     */
    Result<ElectricMeterStatusShow> getElectricMeterStatus(String code);

    /**
     * 仪表的开关操作
     * @param electricMeterSwitchParam
     * @return
     */
    Result electricMeterSwitch(ElectricMeterSwitchParam electricMeterSwitchParam);

    /**
     * 仪表的数据采集操作
     * @param electricMeterDataCollectionParam
     * @return
     */
    Result electricMeterDataCollection(ElectricMeterDataCollectionParam electricMeterDataCollectionParam);
}
