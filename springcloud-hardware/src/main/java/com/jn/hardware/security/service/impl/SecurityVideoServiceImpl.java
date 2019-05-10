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
        logger.info("\n监控点信息："+getCamsApi);
        Map<String,String> path = new HashMap<String,String>(16){
            {
                put(SecurityEnum.HTTP_PROTOCOL_TYPE.getCode(),getCamsApi);
            }
        };
        String body = JsonStringToObjectUtil.objectToJson(securityMonitoringPointParam);
        logger.info("\n监控点列表获取入参："+body);
        // post请求application/json类型参数
        String resultString = ArtemisHttpUtil.doPostStringArtemis(path,body,null,null,SecurityEnum.APPLICATION_JSON.getCode(),null);
        logger.info("\n监控点列表获取出参："+resultString);
       if(StringUtils.isNotBlank(resultString)){
           SecurityResult<SecurityMonitoringPointShow> securityResult = JsonStringToObjectUtil.jsonToObject(resultString, new TypeReference<SecurityResult<SecurityMonitoringPointShow>>() {});
           if(securityResult != null) {
               if(SecurityEnum.SECURITY_RESULT_NORMAL.getCode().equals(securityResult.getCode())){
                   result.setData(securityResult.getData());
                   logger.info("\n监控点列表获取成功：{}记录总数为"+securityResult.getData().getTotal());
               }else{
                   result.setCode(securityResult.getCode());
                   result.setResult(securityResult.getMsg());
                   logger.info("\n监控点列表获取失败：{}失败编号"+securityResult.getCode()+"失败原因{}"+securityResult.getMsg());
               }
           }
        }
        return result;
    }
    /**
     * 查询监控点列表
     * @param securityPlayBackUrlParam 实体类参数
     * @return
     */
    @Override
    public Result<SecurityPlayBackUrlShow> findSecurityPlayBackUrlList(SecurityPlayBackUrlParam securityPlayBackUrlParam) {
        Result result = new Result();
        String getCamsApi = SecurityEnum.ARTEMIS_PATH .getCode() + SecurityEnum.PLAY_BACK_URL.getCode();
        logger.info("\n录像回放："+getCamsApi);
        Map<String,String> path = new HashMap<String,String>(16){
            {
                put(SecurityEnum.HTTP_PROTOCOL_TYPE.getCode(),getCamsApi);
            }
        };
        String body = JsonStringToObjectUtil.objectToJson(securityPlayBackUrlParam);
        logger.info("\n监控回放url查询入参："+body);
        // post请求application/json类型参数
        String resultString =ArtemisHttpUtil.doPostStringArtemis(path,body,null,null,SecurityEnum.APPLICATION_JSON.getCode(),null);
        logger.info("\n监控回放url查询出参："+resultString);
        if(StringUtils.isNotBlank(resultString)){
            SecurityResult<SecurityPlayBackUrlShow> securityResult = JsonStringToObjectUtil.jsonToObject(resultString, new TypeReference<SecurityResult<SecurityPlayBackUrlShow>>() {});
            if(securityResult!=null){
                if(SecurityEnum.SECURITY_RESULT_NORMAL.getCode().equals(securityResult.getCode())){
                    result.setData(securityResult.getData());
                    logger.info("\n监控点回放url获取成功：{}返回状态为:"+securityResult.getMsg());
                }else{
                    result.setCode(securityResult.getCode());
                    result.setResult(securityResult.getMsg());
                    logger.info("\n监控点回放url获取失败：{}失败编号"+securityResult.getCode()+"失败原因{}"+securityResult.getMsg());
                }
            }
        }
        return result;
    }
    private Result  transformResult(SecurityResult securityResult){
        Result result = new Result();

        return result;
    }

}
