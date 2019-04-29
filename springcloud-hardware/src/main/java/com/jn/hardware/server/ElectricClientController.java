package com.jn.hardware.server;

import com.jn.common.model.Result;
import com.jn.hardware.api.ElectricMeterClient;
import com.jn.hardware.electricmeter.service.ElectricMeterService;
import com.jn.hardware.model.electricmeter.*;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;


/**
 * @author： chenr
 * @date： Created on 2019/4/23 17:57
 * @version： v1.0
 * @modified By:
 */
public class ElectricClientController implements ElectricMeterClient {
    /**
     * 日志组件
     */
   Logger logger = LoggerFactory.getLogger(ElectricClientController.this.getClass());

    @Autowired
    private ElectricMeterService electricMeterService;
    @Value(value = "${electric.client.secret}")
    private String  client_secret;
    @Value(value = "${electric.client.id}")
    private String  client_id;
    @Value(value = "${electric.grant.type}")
    private String  grant_type;
    @Value(value = "${electric.username}")
    private String  username;
    @Value(value = "${electric.password}")
    private String  password;
    @Value(value = "${electric.scopes}")
    private String  scopes;

    /**
     * 获取电表平台access_token接口
     * @param electricAccessTokenParam 实体类参数
     * @return
     */
    @Override
    public Result<ElectricAccessTokenShow> getElectricMeterAccessToken(ElectricAccessTokenParam electricAccessTokenParam) {
       Result result = electricMeterService.getElectricMeterAccessToken(electricAccessTokenParam);
       return result;
    }
    /**
     * 定时刷新电表平台token
     *
     * @return
     */
    @Override
    public Result<ElectricAccessTokenShow> getElectricMeterAccessToken() {
        ElectricAccessTokenParam electricAccessTokenParam = new ElectricAccessTokenParam();
        electricAccessTokenParam.setGrant_type(grant_type);
        electricAccessTokenParam.setUsername(username);
        electricAccessTokenParam.setPassword(password);
        electricAccessTokenParam.setScopes(scopes);
        return electricMeterService.getElectricMeterAccessToken(electricAccessTokenParam);

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
    public Result<ElectricMeterInfoShow> getElectricMeterForBuilding(ElectricMeterInfoParam electricMeterInfoParam) {
        return electricMeterService.getElectricMeterForBuilding(electricMeterInfoParam);
    }

    /**
     * 获取当前仪表的状态
     * @param code
     * @return
     */
    @Override
    public Result<ElectricMeterStatusShow> getElectricMeterStatus(@ApiParam(name = "code",value = "仪表编号",example = "10086",required = true) String code) {
        return electricMeterService.getElectricMeterStatus(code);
    }

    /**
     * 仪表的状态操作
     * @param electricMeterSwitchParam
     * @return
     */
    @Override
    public Result electricMeterSwitch(ElectricMeterSwitchParam electricMeterSwitchParam) {
        return electricMeterService.electricMeterSwitch(electricMeterSwitchParam);

    }

    /**
     * 仪表数据采集
     * @param electricMeterDataCollectionParam
     * @return
     */
    @Override
    public Result electricMeterDataCollection(ElectricMeterDataCollectionParam electricMeterDataCollectionParam) {
        return electricMeterService.electricMeterDataCollection(electricMeterDataCollectionParam);
    }
}
