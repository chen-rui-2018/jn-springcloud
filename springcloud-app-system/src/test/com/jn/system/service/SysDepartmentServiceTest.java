package com.jn.system.service;

import com.jn.common.model.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SysDepartmentServiceTest {

    private Logger logger = LoggerFactory.getLogger(SysDepartmentServiceTest.class);

    @Autowired
    public SysDepartmentService sysDepartmentService;

    @Test
    public void findSysDepartmentAll() {
        Result result = sysDepartmentService.findSysDepartmentAll();
        logger.info("result",result);
    }
}
