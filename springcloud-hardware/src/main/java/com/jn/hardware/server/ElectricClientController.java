package com.jn.hardware.server;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.hardware.api.ElectricMeterClient;
import com.jn.hardware.electricmeter.service.ElectricMeterService;
import com.jn.hardware.enums.ElectricMeterEnum;
import com.jn.hardware.model.electricmeter.*;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author： chenr
 * @date： Created on 2019/4/23 17:57
 * @version： v1.0
 * @modified By:
 */
@RestController
public class ElectricClientController implements ElectricMeterClient {
    /**
     * 日志组件
     */
   Logger logger = LoggerFactory.getLogger(ElectricClientController.this.getClass());

    @Autowired
    private ElectricMeterService electricMeterService;

    @Value(value = "${electric.grant.type}")
    private String  grant_type;
    @Value(value = "${electric.username}")
    private String  username;
    @Value(value = "${electric.password}")
    private String  password;
    @Value(value = "${electric.scopes}")
    private String  scopes;


    /**
     * 定时刷新电表平台token
     *
     * @return
     */
    @Override
    public Result<ElectricAccessTokenShow> getElectricMeterAccessToken() {
         return electricMeterService.getElectricMeterAccessToken();

    }

    /**
     * 获取物业下的所有建筑信息
     * @return
     */
    @Override
    public Result<List<ElectricMeterBuildingShow>> getElectricBuildingInfo() {
        return electricMeterService.getElectricBuildingInfo();

    }

    /**
     * 查询建筑下的仪表信息
     * @param electricMeterInfoParam
     * @return
     */
    @Override
    public Result<ElectricMeterInfoShow> getElectricMeterForBuilding(@RequestBody ElectricMeterInfoParam electricMeterInfoParam) {
        return electricMeterService.getElectricMeterForBuilding(electricMeterInfoParam);
    }

    /**
     * 获取当前仪表的状态
     * @param code
     * @return
     */
    @Override
    public Result<ElectricMeterStatusShow> getElectricMeterStatus(@RequestBody String code) {
        return electricMeterService.getElectricMeterStatus(code);
    }

    /**
     * 仪表的状态操作
     * @param electricMeterSwitchParam
     * @return
     */
    @Override
    public Result electricMeterSwitch(@RequestBody ElectricMeterSwitchParam electricMeterSwitchParam) {
        return electricMeterService.electricMeterSwitch(electricMeterSwitchParam);

    }

    /**
     * 仪表数据采集
     * @param electricMeterDataCollectionParam
     * @return
     */
    @Override
    public Result meterDataCollection(@RequestBody ElectricMeterDataCollectionParam electricMeterDataCollectionParam) {
        return electricMeterService.electricMeterDataCollection(electricMeterDataCollectionParam);
    }
    /**
     * 电表数据采集 仪表类型必须为1(电表)
     * @param electricMeterDataCollectionParam
     * @return
     */
    @Override
    public Result<ElectricOrWaterConditionShow> electricMeterDataCollection(@RequestBody ElectricMeterDataCollectionParam electricMeterDataCollectionParam) {
       if(!ElectricMeterEnum.ELECTRIC_METER_TYPE_ELECTRIC.getCode().equals(electricMeterDataCollectionParam.getDeviceType())){
           throw new JnSpringCloudException(ElectricMeterEnum.ELECTRIC_METER_DATA_COLLECTION);
       }
        return electricMeterService.electricMeterDataCollection(electricMeterDataCollectionParam);
    }
    /**
     *水表数据采集 仪表类型必须为2(水表)
     * @param electricMeterDataCollectionParam
     * @return
     */
    @Override
    public Result<ElectricOrWaterConditionShow> waterMeterDataCollection(@RequestBody ElectricMeterDataCollectionParam electricMeterDataCollectionParam) {
        if(!ElectricMeterEnum.ELECTRIC_METER_TYPE_WATER.getCode().equals(electricMeterDataCollectionParam.getDeviceType())){
            throw new JnSpringCloudException(ElectricMeterEnum.WATER_METER_DATA_COLLECTION);
        }
        return electricMeterService.electricMeterDataCollection(electricMeterDataCollectionParam);
    }
    /**
     *水表数据采集 仪表类型必须为3(空调表)
     * @param electricMeterDataCollectionParam
     * @return
     */
    @Override
    public Result<AirMeterConditionShow> airMeterDataCollection(@RequestBody ElectricMeterDataCollectionParam electricMeterDataCollectionParam) {
        if(!ElectricMeterEnum.ELECTRIC_METER_TYPE_AIR.getCode().equals(electricMeterDataCollectionParam.getDeviceType())){
            throw new JnSpringCloudException(ElectricMeterEnum.AIR_METER_DATA_COLLECTION);
        }
        return electricMeterService.electricMeterDataCollection(electricMeterDataCollectionParam);
    }

}
