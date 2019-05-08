package com.jn.hardware.api;

import com.jn.common.model.Result;
import com.jn.hardware.model.electricmeter.ElectricAccessTokenParam;
import com.jn.hardware.model.electricmeter.ElectricMeterDataCollectionParam;
import com.jn.hardware.model.electricmeter.ElectricMeterInfoParam;
import com.jn.hardware.model.electricmeter.ElectricMeterSwitchParam;
import com.jn.hardware.model.parking.TemporaryCarParkingFeeRequest;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
    Result getElectricBuildingInfo();
    /**
     *查询建筑下的仪表信息
     * @param electricMeterInfoParam
     * @return
     */
    @RequestMapping(value = "/api/hardware/electric/getElectricMeterForBuilding")
    Result getElectricMeterForBuilding(@RequestBody  ElectricMeterInfoParam electricMeterInfoParam);
    /**
     *获取仪表的状态
     * @param code
     * @return
     */
    @RequestMapping(value = "/api/hardware/electric/getElectricMeterStatus")
    Result getElectricMeterStatus(@ApiParam(name = "code",value = "仪表编号",example = "10086",required = true) String code);
    /**
     *仪表的开关操作
     * @param electricMeterSwitchParam
     * @return
     */
    @RequestMapping(value = "/api/hardware/electric/electricMeterSwitch")
    Result electricMeterSwitch(ElectricMeterSwitchParam electricMeterSwitchParam);
     /**
     *仪表数据采集
     * @param electricMeterDataCollectionParam
     * @return
     */
    @RequestMapping(value = "/api/hardware/electric/electricMeterDataCollection")
    Result electricMeterDataCollection(ElectricMeterDataCollectionParam electricMeterDataCollectionParam);



}
