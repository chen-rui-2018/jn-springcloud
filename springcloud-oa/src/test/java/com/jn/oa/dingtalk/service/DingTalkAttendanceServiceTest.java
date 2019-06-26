package com.jn.oa.dingtalk.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.oa.common.enums.OaDingTalkEnums;
import com.jn.oa.dingTalk.service.DingTalkAttendanceService;
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
import java.time.format.DateTimeFormatter;

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
public class DingTalkAttendanceServiceTest {

    @Autowired
    public DingTalkAttendanceService dingTalkAttendanceService;

    private static String workDateFrom;
    private static String workDateTo;


    @BeforeClass
    public static void init() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern(OaDingTalkEnums.DATE_FORMATTER.getCode());
        workDateFrom = now.format(format);

        now.plusDays(7);
        workDateTo = now.format(format);

    }

    /**
     * 批量插入数据
     */
    @Test
    public void batchInsertDingTalkAttendance() {
        try {
            dingTalkAttendanceService.batchInsertDingTalkAttendance(workDateFrom,workDateTo);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }







}
