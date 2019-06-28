package com.jn.park.wifi.service.impl;

import com.jn.park.wifi.service.WifiTowerHeatService;
import com.netflix.discovery.converters.Auto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/*
 *
 *<pre>
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：${DATE}
 *</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WifiTowerHeatServiceImplTest {

    @Autowired
    private WifiTowerHeatService wifiTowerHeatService;
    @Test
    public void collectionHeatInf() {

        wifiTowerHeatService.collectionHeatInfo();
    }
}