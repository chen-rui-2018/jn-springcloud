package com.jn.hardware.electricmeter.runner;

import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.hardware.electricmeter.service.ElectricMeterService;
import com.jn.hardware.model.electricmeter.ElectricAccessTokenParam;
import com.jn.hardware.model.electricmeter.ElectricAccessTokenShow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 服务启动时,执行仪表平台token获取接口,规避首次访问时出现无效令牌问题
 * @author： chenr
 * @date： Created on 2019/5/10 11:53
 * @version： v1.0
 * @modified By:
 */
@Component
@Order(value = 1)
public class ElectricMiterRunner   implements ApplicationRunner {
    /**
     * 日志组件
     */
    Logger logger = LoggerFactory.getLogger(ElectricMiterRunner.class);
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
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("仪表平台获取access_token开始");
        ElectricAccessTokenParam electricAccessTokenParam = new ElectricAccessTokenParam();
        electricAccessTokenParam.setGrant_type(grant_type);
        electricAccessTokenParam.setUsername(username);
        electricAccessTokenParam.setPassword(password);
        electricAccessTokenParam.setScopes(scopes);
        Result<ElectricAccessTokenShow> result = electricMeterService.getElectricMeterAccessToken(electricAccessTokenParam);
        if(result != null ){
            if(result.getCode().equals(GlobalConstants.SUCCESS_CODE)){
                logger.info("仪表平台获取access_token成功{}access_token:"+result.getData().getAccess_token());
            }else{
                logger.info("仪表平台获取access_token失败{}失败原因:"+result.getResult());
            }
            logger.info("仪表平台获取access_token结束");
        }

    }
}
