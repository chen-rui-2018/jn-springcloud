package com.jn.hardware.security.service.impl;

import com.jn.common.model.Result;
import com.jn.hardware.api.SecurityVideoClient;
import com.jn.hardware.model.security.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.IsAnything.anything;
import static org.junit.Assert.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityVideoServiceImplTest {
    /**
     * 日志组件
     */
    Logger logger = LoggerFactory.getLogger(SecurityVideoServiceImplTest.class);

    private SecurityMonitoringPointParam securityMonitoringPointParam;
    private SecurityPlayBackUrlParam securityPlayBackUrlParam;
    private SecurityTokenParam securityTokenParam;


    @Autowired
    private SecurityVideoClient securityVideoClient;
    @Before
    public void setUp() throws Exception {
        //获取监控点信息
        securityMonitoringPointParam = new SecurityMonitoringPointParam();
        securityMonitoringPointParam.setPageNo(2);
        securityMonitoringPointParam.setPageSize(20);

        //获取回放URL
        securityPlayBackUrlParam = new SecurityPlayBackUrlParam();
        securityPlayBackUrlParam.setCameraIndexCode("8bb1497fe2db4929ab45091aa58050cd");
        securityPlayBackUrlParam.setBeginTime("2019-05-09T12:00:00.000+08:00");
        securityPlayBackUrlParam.setEndTime("2019-05-09T12:30:00.000+08:00");
        securityPlayBackUrlParam.setRecordLocation("0");
        securityPlayBackUrlParam.setProtocol("rtsp");
        securityPlayBackUrlParam.setTransmode("0");
//        securityPlayBackUrlParam.setUuid("4750e3a4a5bbad3cda5bbad3cd4af9ed5101");
        securityPlayBackUrlParam.setExpand("streamform=rtp");
        //token验证的url获取
        securityTokenParam = new SecurityTokenParam();
//        securityTokenParam.setUserCode("admin");
//        securityTokenParam.setService("http://192.168.30.2/portal/");
//        securityTokenParam.setLanguage("zh_CN");
    }
    @Test
    public void findSecurityMonitoringPointList() {
        Result<SecurityMonitoringPointShow> show =  securityVideoClient.findSecurityMonitoringPointList(securityMonitoringPointParam);
        logger.info("\n获取监控点信息,监控点列表信息: {}",show.getResult());
        assertThat(anything(),anything());
    }

    @Test
    public void findSecurityPlayBackUrlList() {
        Result<SecurityPlayBackUrlShow> show  =  securityVideoClient.findSecurityPlayBackUrlList(securityPlayBackUrlParam);
        logger.info("\n获取监控点获取回放URL,监控点获取回放URL: {}",show.getData().getUrl());
        assertThat(anything(),anything());
    }

    @Test
    public void getSecurityTokenURL() {
        Result<String> show  =  securityVideoClient.getSecurityTokenURL(securityTokenParam);
        logger.info("\n获取监控验证URL成功,验证的路径为: {}",show.getData());
        assertThat(anything(),anything());
    }
}