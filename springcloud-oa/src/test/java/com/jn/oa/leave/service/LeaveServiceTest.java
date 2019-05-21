package com.jn.oa.leave.service;

import com.jn.common.exception.JnSpringCloudException;

import com.jn.oa.model.Leave ;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * 请假管理service单元测试
 *
 * @author： yuanyy
 * @date： Created on 2019/2/17 17:03
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LeaveServiceTest {

    @Autowired
    public LeaveService leaveService;
    private static Leave leave;



    @BeforeClass
    public static void init() {
        //初始化添加用户
        leave = new Leave();
        leave.setUserId("10000");


        //初始化部门部门id及部门名称
        leave.setDepartmentId("116");


        //结束时间
        leave.setEndTime(new Date());

    }

    /**
     * 签到
     */
    @Test
    public void searchLeaveListByCondition() {
        try {
            leaveService.searchLeaveListByCondition(leave);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }







}
