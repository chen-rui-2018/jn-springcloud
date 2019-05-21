package com.jn.park.repair.service.impl;

import com.jn.SpringCloudParkApplication;
import com.jn.common.util.Assert;
import com.jn.park.parking.service.impl.ParkingServerServiceImplTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author： huangbq
 * @date： Created on 2019/5/18 19:09
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudParkApplication.class})
public class RepairServiceImplTest {
    private static Logger logger = LoggerFactory.getLogger(RepairServiceImplTest.class);
    @Autowired
    private RepairServiceImpl repairService;

    @Test
    public void completeTask(){
        repairService.completeTask("579349269673148416");
        Assert.isTrue(true);
    }
}