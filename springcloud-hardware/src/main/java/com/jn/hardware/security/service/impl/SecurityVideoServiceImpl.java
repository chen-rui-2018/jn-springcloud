package com.jn.hardware.security.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.hardware.model.security.*;
import com.jn.hardware.security.enums.SecurityEnum;
import com.jn.hardware.security.service.SecurityVideoService;
import com.jn.hardware.util.JsonStringToObjectUtil;
import org.checkerframework.checker.nullness.NullnessUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2019/5/8 15:46
 * @version： v1.0
 * @modified By:
 */
@Service
public class SecurityVideoServiceImpl implements SecurityVideoService {
    /**
     * 日志组件
     */
    Logger logger = LoggerFactory.getLogger(SecurityVideoServiceImpl.this.getClass());

    static {
        // 代理API网关nginx服务器ip端口
        ArtemisConfig.host = SecurityEnum.ARTEMIS_CONFIG_HOST.getCode();
        // 秘钥appkey
        ArtemisConfig.appKey =SecurityEnum.ARTEMIS_CONFIG_APP_KEY.getCode();
        // 秘钥appSecret
        ArtemisConfig.appSecret =SecurityEnum.ARTEMIS_CONFIG_APP_SECRET.getCode();
    }
    /**
     * 查询监控点列表
     * @param securityMonitoringPointParam
     * @return
     */
    @Override
    public Result<SecurityMonitoringPointShow> findSecurityMonitoringPointList(SecurityMonitoringPointParam securityMonitoringPointParam) {
        Result result = new Result();
        String getCamsApi = SecurityEnum.ARTEMIS_PATH .getCode()+SecurityEnum.MONITORING_POINT.getCode() ;
        logger.info("\n查询监控点列表入参:【{}】,接口地址:【{}】",securityMonitoringPointParam,getCamsApi);
        Map<String,String> path = new HashMap<String,String>(16){
            {
                put(SecurityEnum.HTTP_PROTOCOL_TYPE.getCode(),getCamsApi);
            }
        };
        String body = JsonStringToObjectUtil.objectToJson(securityMonitoringPointParam);
        logger.info("\n查询监控点列表,接口参数为：【{}】",body);
        // post请求application/json类型参数
        String resultString = ArtemisHttpUtil.doPostStringArtemis(path,body,null,null,SecurityEnum.APPLICATION_JSON.getCode(),null);
        logger.info("\n查询监控点列表,接口出参：【{}】",resultString);
       if(StringUtils.isNotBlank(resultString)){
           SecurityResult<SecurityMonitoringPointShow> securityResult = JsonStringToObjectUtil.jsonToObject(resultString, new TypeReference<SecurityResult<SecurityMonitoringPointShow>>() {});
           if(securityResult != null) {
               if(SecurityEnum.SECURITY_RESULT_NORMAL.getCode().equals(securityResult.getCode())){
                   result.setData(securityResult.getData());
                   logger.info("\n监控点列表获取成功：{}记录总数为",securityResult.getData().getTotal());
               }else{
                   result.setCode(securityResult.getCode());
                   result.setResult(securityResult.getMsg());
                   logger.info("\n监控点列表获取失败：{}失败编号,失败原因{}",securityResult.getCode(),securityResult.getMsg());
               }
           }
        }
        return result;
    }
    /**
     * 查询监控回放路径url列表
     * @param securityPlayBackUrlParam 实体类参数
     * @return
     */
    @Override
    public Result<SecurityPlayBackUrlShow> findSecurityPlayBackUrlList(SecurityPlayBackUrlParam securityPlayBackUrlParam) {
        Result result = new Result();
        String getCamsApi = SecurityEnum.ARTEMIS_PATH .getCode() + SecurityEnum.PLAY_BACK_URL.getCode();
        logger.info("\n查询监控回放路径url入参:【{}】,接口地址:【{}】",securityPlayBackUrlParam,getCamsApi);
        Map<String,String> path = new HashMap<String,String>(16){
            {
                put(SecurityEnum.HTTP_PROTOCOL_TYPE.getCode(),getCamsApi);
            }
        };
        String body = JsonStringToObjectUtil.objectToJson(securityPlayBackUrlParam);
        logger.info("\n查询监控回放url,硬件接口参数：【{}】",body);
        // post请求application/json类型参数
        String resultString =ArtemisHttpUtil.doPostStringArtemis(path,body,null,null,SecurityEnum.APPLICATION_JSON.getCode(),null);
        logger.info("\n监控回放url查询,硬件接口出参：【{}】",resultString);
        if(StringUtils.isNotBlank(resultString)){
            SecurityResult<SecurityPlayBackUrlShow> securityResult = JsonStringToObjectUtil.jsonToObject(resultString, new TypeReference<SecurityResult<SecurityPlayBackUrlShow>>() {});
            if(securityResult!=null){
                if(SecurityEnum.SECURITY_RESULT_NORMAL.getCode().equals(securityResult.getCode())){
                    result.setData(securityResult.getData());
                    logger.info("\n监控点回放url获取成功：{}返回状态为:【{}】",securityResult.getMsg());
                }else{
                    result.setCode(securityResult.getCode());
                    result.setResult(securityResult.getMsg());
                    logger.info("\n监控点回放url获取失败：{}失败编号,失败原因{}",securityResult.getCode(),securityResult.getMsg());
                }
            }
        }
        return result;
    }
    /**
     * 获取海康威视的 接口凭证 token,返回 用于认证的url
     * @param securityTokenParam 实体类参数
     * @return
     */
    @Override
    public Result<String> getSecurityTokenURL(SecurityTokenParam securityTokenParam) {
        Result result = new Result();
        String getCamsApi = SecurityEnum.ARTEMIS_PATH .getCode() + SecurityEnum.GET_TOKEN_URL.getCode();
        logger.info("\n获取海康威视的接口凭证token入参:【{}】,接口地址:【{}】",securityTokenParam,getCamsApi);
        Map<String,String> query = new HashMap<>(16);
        query.put(SecurityEnum.GET_TOKEN_USER_CODE.getCode(),securityTokenParam.getUserCode());
        query.put(SecurityEnum.GET_TOKEN_SERVICE.getCode(),securityTokenParam.getService());
        query.put(SecurityEnum.GET_TOKEN_LANGUAGE.getCode(),securityTokenParam.getLanguage());
        Map<String,String> path = new HashMap<String,String>(16){
            {
                put(SecurityEnum.HTTP_PROTOCOL_TYPE.getCode(),getCamsApi);
            }
        };
        logger.info("\n获取海康威视的接口凭证token,调用接口入参：【{}】",securityTokenParam.toString());
        String resultString =ArtemisHttpUtil.doGetArtemis(path,query,null, null,null);
        logger.info("\n监控认证url获取成功,海康返回的值:【{}】",resultString);
        if(StringUtils.isNotBlank(resultString)){
            SecurityResult<SecurityTokenShow> securityResult = JsonStringToObjectUtil.jsonToObject(resultString, new TypeReference< SecurityResult<SecurityTokenShow>>() {});
            if(securityResult!=null){
                if(SecurityEnum.SECURITY_RESULT_NORMAL.getCode().equals(securityResult.getCode())){
                    String ttoken  =  securityResult.getData().getToken();
                    String url =SecurityEnum.HTTP_PROTOCOL_TYPE.getCode()+SecurityEnum.ARTEMIS_CONFIG_HOST.getCode()+String.format(SecurityEnum.SECURITY_TOOKEN_URL.getCode(),ttoken,securityTokenParam.getService());
                    result.setData(url);
                    logger.info("\n获取token后组装的url:【{}】,返回状态为：【{}】",url,securityResult.getMsg());
                }else{
                    result.setCode(securityResult.getCode());
                    result.setResult(securityResult.getMsg());
                    logger.info("\n监控认证url获取失败：{}失败编号，失败原因{}",securityResult.getCode(),securityResult.getMsg());
                }
            }
        }
        return result;
    }

}
