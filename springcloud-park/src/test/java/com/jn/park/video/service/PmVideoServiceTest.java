package com.jn.park.video.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 物业-安防录像设备测试类
 *
 * @author： shaobao
 * @date： Created on 2019/5/17 9:47
 * @version： v1.0
 * @modified By:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class PmVideoServiceTest {

    @Autowired
    private PmVideoService pmVideoService;

    @Test
    @Ignore
    public void insertVideoInfos() {
        pmVideoService.insertVideoInfos();
    }
}