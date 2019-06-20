package com.jn.park.electricmeter.service.impl;

import com.jn.park.electricmeter.service.ElectricRulesInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * <pre>
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/6/4
 * </pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElectricRulesInfoServiceImplTest {

    @Autowired
    private ElectricRulesInfoService electricRulesInfoService;

    @Test
    public void monitor() {
        electricRulesInfoService.monitor();
    }
}