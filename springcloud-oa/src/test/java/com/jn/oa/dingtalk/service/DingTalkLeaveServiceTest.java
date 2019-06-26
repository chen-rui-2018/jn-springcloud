package com.jn.oa.dingtalk.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.oa.dingTalk.service.DingTalkAttendanceService;
import com.jn.oa.dingTalk.service.DingTalkLeaveService;
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
 * 钉钉用户service单元测试
 *
 * @author： yuanyy
 * @date： Created on 2019/2/17 17:03
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DingTalkLeaveServiceTest {

    @Autowired
    public DingTalkLeaveService dingTalkLeaveService;

    private static Date workDateFrom;
    private static Date workDateTo;


    @BeforeClass
    public static void init() {
        LocalDateTime now = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = now.atZone(zoneId);
        workDateFrom = Date.from(zdt.toInstant());


        now.plusDays(7);
        workDateTo = Date.from(now.atZone(zoneId).toInstant());


    }

    /**
     * 批量插入数据
     */
    @Test
    public void batchInsertDingTalkAttendance() {
        try {
            dingTalkLeaveService.batchInsertDingTalkLeave(workDateFrom,workDateTo);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }







}
