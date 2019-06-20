package com.jn.hardware.electricmeter.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.hardware.electricmeter.service.ElectricMeterService;
import com.jn.hardware.enums.ElectricMeterEnum;
import com.jn.hardware.model.electricmeter.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/24 9:21
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "仪表表数据获取")
@RestController
@RequestMapping("/hardware/electric")
public class ElectricMeterController extends BaseController {
    /**
     * 日志组件
     */
    Logger logger = LoggerFactory.getLogger(ElectricMeterController.this.getClass());

    @Autowired
    private ElectricMeterService electricMeterService;

    @ApiOperation(value = "获取电表平台access_token接口",notes = "根据平台数据(user/password)获取token")
    @RequestMapping(value = "/getElectricMeterAccessToken",method = RequestMethod.GET)
    public Result<ElectricAccessTokenShow> getElectricMeterAccessToken() {
        Result result = electricMeterService.getElectricMeterAccessToken();
        return result;
    }



    @ApiOperation(value = "获取物业下的所有建筑信息",notes = "获取物业下的所有建筑信息")
    @RequestMapping(value = "/getElectricBuildingInfo",method = RequestMethod.GET)
    public Result<List<ElectricMeterBuildingShow>> getElectricBuildingInfo() {
        return electricMeterService.getElectricBuildingInfo();

    }


    @ApiOperation(value = "查询建筑下的仪表信息",notes = "根据建筑编码(code)和分页参数.查询建筑下的仪表信息")
    @RequestMapping(value = "/getElectricMeterForBuilding",method = RequestMethod.GET)
    public Result<ElectricMeterInfoShow> getElectricMeterForBuilding(ElectricMeterInfoParam electricMeterInfoParam) {
        return electricMeterService.getElectricMeterForBuilding(electricMeterInfoParam);
    }


    @ApiOperation(value = "获取当前仪表的状态",notes = "根据仪表的编号(code),查看当前仪表的状态")
    @RequestMapping(value = "/getElectricMeterStatus",method = RequestMethod.GET)
    public Result<ElectricMeterStatusShow> getElectricMeterStatus(@ApiParam(name = "code",value = "仪表编号",example = "10086",required = true) @RequestParam("code") String code) {
        return electricMeterService.getElectricMeterStatus(code);
    }


    @ApiOperation(value = "仪表的状态操作",notes = "根据仪表的编号(code),操作码,对仪表进行开关操作")
    @RequestMapping(value = "/electricMeterSwitch",method = RequestMethod.GET)
    public Result electricMeterSwitch(ElectricMeterSwitchParam electricMeterSwitchParam) {
        return electricMeterService.electricMeterSwitch(electricMeterSwitchParam);

    }
    @ApiOperation(value = "仪表数据采集(电表或水表)",notes = "根据仪表编号,仪表类型为(水表或电表),以及仪表的数据采集开始时间,返回所采集的数据内容")
    @RequestMapping(value = "/meterDataCollection",method = RequestMethod.GET)
    public Result<ElectricOrWaterConditionShow> meterDataCollection(ElectricMeterDataCollectionParam electricMeterDataCollectionParam) {
        return electricMeterService.electricMeterDataCollection(electricMeterDataCollectionParam);
    }

    @ApiOperation(value = "仪表数据采集(空调表)",notes = "根据仪表编号,仪表类型为(空调表),以及仪表的数据采集开始时间,返回所采集的数据内容")
    @RequestMapping(value = "/electricAirMeterDataCollection",method = RequestMethod.GET)
    public Result<AirMeterConditionShow> electricAirMeterDataCollection(ElectricMeterDataCollectionParam electricMeterDataCollectionParam) {
        return electricMeterService.electricMeterDataCollection(electricMeterDataCollectionParam);
    }
    @ApiOperation(value = "仪表数据采集(电表)",notes = "根据仪表编号,仪表类型为(电表),以及仪表的数据采集开始时间,返回所采集的数据内容")
    @RequestMapping(value = "/electricMeterDataCollection",method = RequestMethod.GET)
    public Result<ElectricOrWaterConditionShow> electricMeterDataCollection(ElectricMeterDataCollectionParam electricMeterDataCollectionParam) {
        if(!ElectricMeterEnum.ELECTRIC_METER_TYPE_ELECTRIC.getCode().equals(electricMeterDataCollectionParam.getDeviceType())){
            throw new JnSpringCloudException(ElectricMeterEnum.ELECTRIC_METER_DATA_COLLECTION);
        }
        return electricMeterService.electricMeterDataCollection(electricMeterDataCollectionParam);
    }


}
