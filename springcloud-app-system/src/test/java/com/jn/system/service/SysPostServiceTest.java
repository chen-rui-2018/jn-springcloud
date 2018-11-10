package com.jn.system.service;

import com.jn.common.model.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SysPostServiceTest {

    private Logger logger = LoggerFactory.getLogger(SysPostServiceTest.class);

    @Autowired
    public SysPostService sysPostService;

    @Test
    public void findSysPostAll() {
        Result result = sysPostService.findSysPostAll();
        logger.info("测试结果:"+result.getData().toString());
    }

}
