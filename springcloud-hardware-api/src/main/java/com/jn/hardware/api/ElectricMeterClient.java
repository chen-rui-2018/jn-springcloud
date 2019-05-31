package com.jn.hardware.api;

import com.jn.common.model.Result;
import com.jn.hardware.model.electricmeter.*;
import com.jn.hardware.model.parking.TemporaryCarParkingFeeRequest;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/23 17:53
 * @version： v1.0
 * @modified By:
 */
@FeignClient("springcloud-hardware")
public interface ElectricMeterClient {
    /**
     * 获取电表平台token
     * @param electricAccessTokenParam 实体类参数
     * @return
     */
    @RequestMapping(value = "/api/hardware/electric/getElectricMeterAccessToken")
    Result getElectricMeterAccessToken(@RequestBody ElectricAccessTokenParam electricAccessTokenParam);
    /**
     * 定时刷新获取电表平台token
     *
     * @return
     */
    @RequestMapping(value = "/api/hardware/electric/getElectricAccessToken")
    Result getElectricMeterAccessToken();

    /**
     *查询物业下的所有建筑
     * @return
     */
    @RequestMapping(value = "/api/hardware/electric/getElectricBuildingInfo")
    Result<List<ElectricMeterBuildingShow>> getElectricBuildingInfo();
    /**
     *查询建筑下的仪表信息
     * @param electricMeterInfoParam
     * @return
     */
    @RequestMapping(value = "/api/hardware/electric/getElectricMeterForBuilding")
    public Result<ElectricMeterInfoShow> getElectricMeterForBuilding(@RequestBody  ElectricMeterInfoParam electricMeterInfoParam);
    /**
     *获取仪表的状态
     * @param code
     * @return
     */
    @RequestMapping(value = "/api/hardware/electric/getElectricMeterStatus")
    Result<ElectricMeterStatusShow> getElectricMeterStatus(@ApiParam(name = "code",value = "仪表编号",example = "10086",required = true) String code);
    /**
     *仪表的开关操作
     * @param electricMeterSwitchParam
     * @return
     */
    @RequestMapping(value = "/api/hardware/electric/electricMeterSwitch")
    Result electricMeterSwitch(@RequestBody ElectricMeterSwitchParam electricMeterSwitchParam);
     /**
     *仪表数据采集
     * @param electricMeterDataCollectionParam
     * @return
     */
    @RequestMapping(value = "/api/hardware/electric/MeterDataCollection")
    Result meterDataCollection(@RequestBody ElectricMeterDataCollectionParam electricMeterDataCollectionParam);
    /**
     *电表数据采集 仪表类型必须为1(电表)
     * @param electricMeterDataCollectionParam
     * @return
     */
    @RequestMapping(value = "/api/hardware/electric/electricMeterDataCollection")
    Result<ElectricOrWaterConditionShow> electricMeterDataCollection(@RequestBody ElectricMeterDataCollectionParam electricMeterDataCollectionParam);
     /**
         *水表数据采集 仪表类型必须为2(水表)
         * @param electricMeterDataCollectionParam
         * @return
         */
    @RequestMapping(value = "/api/hardware/electric/waterMeterDataCollection")
    Result<ElectricOrWaterConditionShow> waterMeterDataCollection(@RequestBody ElectricMeterDataCollectionParam electricMeterDataCollectionParam);
    /**
         *空调表数据采集 仪表类型必须为3(空调表)
         * @param electricMeterDataCollectionParam
         * @return
         */
    @RequestMapping(value = "/api/hardware/electric/airMeterDataCollection")
    Result<AirMeterConditionShow> airMeterDataCollection( @RequestBody ElectricMeterDataCollectionParam electricMeterDataCollectionParam);



}
