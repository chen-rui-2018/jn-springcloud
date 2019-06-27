package com.jn.hardware.sdnwareAp.service;

import com.jn.common.model.Result;
import com.jn.hardware.api.SdnwareApClient;
import com.jn.hardware.model.dingtalk.attendance.*;
import com.jn.hardware.model.sdnware.heat.HeatResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SdnwareApServiceTest {

    /**
     * 日志组件
     */
    Logger logger = LoggerFactory.getLogger(SdnwareApServiceTest.class);
    @Autowired
    private SdnwareApClient sdnwareApClient;


    @Before
    public void setUp() throws Exception {

    }


    /**
     * 获取区域人数统计（热力）
    * */
    @Test
    public void getMapHeat() {
        Result<HeatResult> result= sdnwareApClient.getMapHeat();


        logger.info("获取区域人数统计（热力） result：{}",result);
    }



}