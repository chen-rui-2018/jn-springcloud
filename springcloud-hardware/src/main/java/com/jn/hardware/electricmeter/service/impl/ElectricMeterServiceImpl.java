package com.jn.hardware.electricmeter.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.RestTemplateUtil;
import com.jn.common.util.StringUtils;
import com.jn.hardware.electricmeter.service.ElectricRedisConfigStorage;
import com.jn.hardware.electricmeter.service.ElectricMeterService;
import com.jn.hardware.enums.ElectricMeterEnum;
import com.jn.hardware.model.electricmeter.*;
import com.jn.hardware.util.JsonStringToObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2019/4/23 16:58
 * @version： v1.0
 * @modified By:
 */
@Service
public class ElectricMeterServiceImpl implements ElectricMeterService {

    /**
     * 日志组件
     */
    Logger logger = LoggerFactory.getLogger(ElectricMeterServiceImpl.this.getClass());

     @Autowired
     ElectricRedisConfigStorage redisConfigStorage;
    /**
     * 获取电表access_token
     * @param electricAccessTokenParam
     * @return
     */
    @Override
    public Result<ElectricAccessTokenShow> getElectricMeterAccessToken(ElectricAccessTokenParam electricAccessTokenParam) {
        Result result= new Result();
        ElectricResult<ElectricAccessTokenShow> electricResult = new ElectricResult();
        String url = ElectricMeterService.POST_ELECTRIC_ACCESS_TOKEN_URL;
        String jsonData = JsonStringToObjectUtil.objectToJson(electricAccessTokenParam);
        Map<String,String> dynamicHeaders = new HashMap<>(16);
        dynamicHeaders.put("Authorization","Basic ZXN0YXRlOkNSb142JEV0ZXdSMzNORjI=");
        dynamicHeaders.put("Content-Type", "application/json;charset=UTF-8");
        MultiValueMap<String,String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("grant_type",electricAccessTokenParam.getGrant_type());
        multiValueMap.add("username",electricAccessTokenParam.getUsername());
        multiValueMap.add("password",electricAccessTokenParam.getPassword());
        multiValueMap.add("scopes",electricAccessTokenParam.getScopes());
        //获取token前 将从redis中可获取token的状态设置为false
        redisConfigStorage.setAccessTokenController(ElectricMeterEnum.ELECTRIC_GET_TOKEN_FALSE.getCode(),7200);
        String resultString =  RestTemplateUtil.post(url,multiValueMap,dynamicHeaders);
        ElectricAccessTokenShow  accessTokenShow = JsonStringToObjectUtil.jsonToObject(resultString, new TypeReference<ElectricAccessTokenShow>(){});
        if(accessTokenShow ==null){
            electricResult =  JsonStringToObjectUtil.jsonToObject(resultString, new TypeReference<ElectricResult<ElectricAccessTokenShow>>(){});
        }
        electricResult.setData(accessTokenShow);
        //获取token成功
        if(electricResult.getCode().equals(GlobalConstants.SUCCESS_CODE)){
            redisConfigStorage.setAccessToken(electricResult.getData().getAccess_token(),Integer.valueOf(electricResult.getData().getExpires_in()));
            //设置完成token后  将从redis中可获取token的状态设置为true
            redisConfigStorage.setAccessTokenController(ElectricMeterEnum.ELECTRIC_GET_TOKEN_TRUE.getCode(),7200);
            result.setData(electricResult.getData());
            logger.info("获取电表平台access_token成功,access_token="+electricResult.getData().getAccess_token());
        }else{
            result.setCode(electricResult.getCode());
            result.setResult(electricResult.getMsg());
            logger.info("获取电表平台access_token失败,失败原因"+electricResult.getMsg());
        }
        return result;
    }

    /**
     * 获取物业下的所有建筑信息
     * @return
     */
    @Override
    public Result<List<ElectricMeterBuildingShow>> getElectricBuildingInfo() {
        Result result= new Result();
        String url = ElectricMeterService.GET_BUILDING_INFO_URL;
        String accessToken = getAccessToken();
        url = String.format(url,accessToken);
        String buildingString = RestTemplateUtil.get(url);
        ElectricResult<List<ElectricMeterBuildingShow>> electricResult = JsonStringToObjectUtil.jsonToObject(buildingString, new TypeReference<ElectricResult<List<ElectricMeterBuildingShow>>>(){});
        if(electricResult.getCode().equals(GlobalConstants.SUCCESS_CODE)){
            result.setData(electricResult.getData());
            logger.info("获取电表平台建筑信息成功,buildingInfo:"+buildingString);
        }else{
            result.setCode(electricResult.getCode());
            result.setResult(electricResult.getMsg());
            logger.info("获取电表平台建筑信息失败,失败原因"+electricResult.getMsg());
        }
        return result;
    }

    /**
     * 获取建筑下仪表信息
     * @param electricMeterInfoParam
     * @return
     */
    @Override
    public Result<ElectricMeterInfoShow> getElectricMeterForBuilding(ElectricMeterInfoParam electricMeterInfoParam) {
        Result result= new Result();
        ElectricResult<ElectricMeterInfoShow> electricResult = new ElectricResult();

        String accessToken = getAccessToken();
        String url = ElectricMeterService.GET_ELECTRIC_METER_INFO_URL;
        url = String.format(url,accessToken,electricMeterInfoParam.getCode(),electricMeterInfoParam.getPage(),electricMeterInfoParam.getRows());
        String electricString = RestTemplateUtil.get(url);
        ElectricMeterInfoShow electricShow = JsonStringToObjectUtil.jsonToObject(electricString, new TypeReference<ElectricMeterInfoShow>() {});
        if(electricShow == null ){
            electricResult = JsonStringToObjectUtil.jsonToObject(electricString, new TypeReference<ElectricResult<ElectricMeterInfoShow>>() {});
        }
        electricResult.setData(electricShow);
        if(electricResult.getCode().equals(GlobalConstants.SUCCESS_CODE)){
            result.setData(electricResult.getData());
            logger.info("获取建筑下的仪表信息成功,electricMeter:"+electricString);
        }else{
            result.setCode(electricResult.getCode());
            result.setResult(electricResult.getMsg());
            logger.info("获取建筑下的仪表信息息失败,失败原因"+electricResult.getMsg());
        }

        return result;
    }

    /**
     * ,仪表开关状态  0-关闭；1-开启;''-没有这个仪表
     * @param code
     * @return
     */
    @Override
    public Result<ElectricMeterStatusShow> getElectricMeterStatus(String code) {
        Result result= new Result();
        ElectricResult<ElectricMeterStatusShow> electricResult = new ElectricResult<>();
        String accessToken = getAccessToken();
        String url = ElectricMeterService.GET_ELECTRIC_METER_STATUS_URL;
        url = String.format(url,accessToken,code);
        String statusString = RestTemplateUtil.get(url);
        ElectricMeterStatusShow show  = JsonStringToObjectUtil.jsonToObject(statusString, new TypeReference<ElectricMeterStatusShow>() {});
        if(show == null){
            electricResult = JsonStringToObjectUtil.jsonToObject(statusString, new TypeReference<ElectricResult<ElectricMeterStatusShow>>() {});
        }
        electricResult.setData(show);
        if(electricResult.getCode().equals(GlobalConstants.SUCCESS_CODE)){
            result.setData(electricResult.getData());
            logger.info("仪表开关状态信息获取成功,statusString:"+statusString);
        }else{
            result.setCode(electricResult.getCode());
            result.setResult(electricResult.getMsg());
            logger.info("获取建筑下的仪表信息息失败,失败原因"+electricResult.getMsg());
        }
        return result;
    }

    /**
     * 仪表开关操作
     * @param electricMeterSwitchParam
     * @return
     */
    @Override
    public Result electricMeterSwitch(ElectricMeterSwitchParam electricMeterSwitchParam) {
        Result result= new Result();
        String url = ElectricMeterService.GET_ELECTRIC_METER_SWITCH_URL;
        String accessToken =getAccessToken();
        url = String.format(url,accessToken,electricMeterSwitchParam.getCode(),electricMeterSwitchParam.getFlag());
        String  switchSting = RestTemplateUtil.get(url);
        //如果返回不为空,则出现了开关操作错误;
        if(StringUtils.isNotBlank(switchSting)){
           ElectricResult electricResult = JsonStringToObjectUtil.jsonToObject(switchSting, new TypeReference<ElectricResult>() {});
           result.setCode(electricResult.getCode());
           result.setResult(electricResult.getMsg());
        }
        return result;
    }

    /**
     * 仪表数据采集
     * @param electricMeterDataCollectionParam
     * @return
     */
    @Override
    public Result electricMeterDataCollection(ElectricMeterDataCollectionParam electricMeterDataCollectionParam) {

        Result result= new Result();
        String url = ElectricMeterService.GET_ELECTRIC_DATA_COLLECTION_URL;
        String accessToken = getAccessToken();
        url = String.format(url,electricMeterDataCollectionParam.getCode(),electricMeterDataCollectionParam.getDeviceType()
                ,electricMeterDataCollectionParam.getStartTime(),accessToken);
        String dataString = RestTemplateUtil.get(url);
        //查询的表类型为空调表
        if (ElectricMeterEnum.ELECTRIC_METER_TYPE_AIR.getCode().equals(electricMeterDataCollectionParam.getDeviceType())) {
               ElectricResult<List<ElectricMeterAirConditionShow>> electricResult = JsonStringToObjectUtil.jsonToObject(dataString, new TypeReference<ElectricResult<List<ElectricMeterAirConditionShow>>>() {});
            if(electricResult.getCode().equals(GlobalConstants.SUCCESS_CODE)) {
                result.setData(electricResult.getData());
                logger.info("空调表数据信息采集成功,statusString:"+dataString);
            }else{
                result.setCode(electricResult.getCode());
                result.setResult(electricResult.getMsg());
                logger.info("空调表数据信息采集失败,失败原因"+electricResult.getMsg());
            }
        } else {
            //电表 或 水表数据采集 使用相同的返回实体
            String meterName = "";
            //电表数据采集
            if(ElectricMeterEnum.ELECTRIC_METER_TYPE_ELECTRIC.getCode().equals(electricMeterDataCollectionParam.getDeviceType())){
                meterName = ElectricMeterEnum.ELECTRIC_METER_TYPE_ELECTRIC.getMessage();
            }
            //水表数据采集
            if(ElectricMeterEnum.ELECTRIC_METER_TYPE_WATER.getCode().equals(electricMeterDataCollectionParam.getDeviceType())){
                meterName = ElectricMeterEnum.ELECTRIC_METER_TYPE_WATER.getMessage();
            }
            ElectricResult<List<ElectricMeterWaterOrElectricShow>> electricResult = JsonStringToObjectUtil.jsonToObject(dataString, new TypeReference<ElectricResult<List<ElectricMeterWaterOrElectricShow>>>() {});
            if(electricResult.getCode().equals(GlobalConstants.SUCCESS_CODE)) {
                result.setData(electricResult.getData());
                logger.info(meterName+"数据信息采集成功,statusString:"+dataString);
            }else{
                result.setCode(electricResult.getCode());
                result.setResult(electricResult.getMsg());
                logger.info(meterName+"数据信息采集失败,失败原因"+electricResult.getMsg());
            }
        }
        return result;
    }

    /**
     * 从redis中 获取仪表平台的token
     * @return
     */
    private String getAccessToken(){
        try {
            //获取token前先判断是否可以进行获取
            String flag = redisConfigStorage.getAccessTokenController();
            //获取token超过指定次数则提示token获取异常
            int number = 0;
            while (!ElectricMeterEnum.ELECTRIC_GET_TOKEN_TRUE.getCode().equals(flag)) {
                if (number == Integer.valueOf(ElectricMeterEnum.ELECTRIC_GET_TOKEN_TIMES.getCode())) {
                    logger.info("仪表平台access_token获取失败! 网络异常");
                    throw new JnSpringCloudException(ElectricMeterEnum.ELECTRIC_GET_TOKEN_DEFEAT);
                }
                Thread.sleep(Long.valueOf(ElectricMeterEnum.ELECTRIC_GET_TOKEN_TIME.getCode()));
                number++;
                flag = redisConfigStorage.getAccessTokenController();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        String accessToken = redisConfigStorage.getAccessToken();
        return accessToken;

    }
}
