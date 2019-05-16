package com.jn.hardware.security.service.impl;

import com.jn.common.model.Result;
import com.jn.hardware.api.SecurityVideoClient;
import com.jn.hardware.model.security.SecurityMonitoringPointParam;
import com.jn.hardware.model.security.SecurityMonitoringPointShow;
import com.jn.hardware.model.security.SecurityPlayBackUrlParam;
import com.jn.hardware.model.security.SecurityPlayBackUrlShow;
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
        securityPlayBackUrlParam.setCameraIndexCode("3226a7b1a4f74c55a8d57f3187a355e0");
        securityPlayBackUrlParam.setBeginTime("2019-05-15T00:00:00.000+08:00");
        securityPlayBackUrlParam.setEndTime("2019-05-15T10:00:00.000+08:00");
//        securityPlayBackUrlParam.setRecordLocation("0");
//        securityPlayBackUrlParam.setProtocol("RTSP");
//        securityPlayBackUrlParam.setTransmode("0");
//        securityPlayBackUrlParam.setUuid("4750e3a4a5bbad3cda5bbad3cd4af9ed5101");
//        securityPlayBackUrlParam.setExpand("streamform=rtp");
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
}