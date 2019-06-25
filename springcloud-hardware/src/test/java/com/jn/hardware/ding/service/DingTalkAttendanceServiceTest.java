package com.jn.hardware.ding.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jn.common.model.Result;
import com.jn.common.util.RestTemplateUtil;
import com.jn.hardware.api.DingTalkClient;
import com.jn.hardware.model.dingtalk.attendance.*;
import com.jn.hardware.util.JsonStringToObjectUtil;
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
public class DingTalkAttendanceServiceTest {

    /**
     * 日志组件
     */
    Logger logger = LoggerFactory.getLogger(DingTalkAttendanceServiceTest.class);
    @Autowired
    private DingTalkClient dingTalkClient;
    @Autowired
    private DingTalkInRedisConfigStorage dingTalkInRedisConfigStorage;

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Before
    public void setUp() throws Exception {


    }

    /**
     *  获取打卡结果
    * */
    @Test
    public void getClockInResultList() {
        ClockInListParam clockInInfoParam = new ClockInListParam();
        clockInInfoParam.setWorkDateFrom("2019-06-13 00:00:00");
        clockInInfoParam.setWorkDateTo(formatter.format(new Date()));
        clockInInfoParam.setOffset(0L);
        clockInInfoParam.setLimit(50L);

        List userIdList = new ArrayList<>();
        userIdList.add("1760054150647048");
        userIdList.add("176005420021472913");
        userIdList.add("061838443733317635");
        clockInInfoParam.setUserIdList(userIdList);

        Result<ClockInListResult> result = dingTalkClient.getClockInResultList(clockInInfoParam);
        logger.info("输出结果 result：{}",result);

    }

    /**
     *  获取请假状态
     * */
    @Test
    public void getLeaveStatusList() {

        try {
            LeaveStatusListParam leaveStatusListParam = new LeaveStatusListParam();
            leaveStatusListParam.setUseridList("1760054150647048" +
                    ",176005420021472913" +
                    ",061838443733317635" +
                    ",06084024281089553" +
                    ",181642044421752203" +
                    ",044553590430629984"
            );
            leaveStatusListParam.setStartTime(formatter.parse("2019-03-01 00:00:00").getTime());
            leaveStatusListParam.setEndTime(new Date().getTime());
            leaveStatusListParam.setOffset(0L);
            leaveStatusListParam.setSize(20L);
            Result<LeaveStatusListResult> result =  dingTalkClient.getLeaveStatusList(leaveStatusListParam);

            logger.info("输出结果 result：{}",result);


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取请假时长
    * */
    @Test
    public void getLeaveApproveDuration() {
        LeaveApproveDurationParam leaveApproveDurationParam = new LeaveApproveDurationParam();
        leaveApproveDurationParam.setUserid("044553590430629984");
        leaveApproveDurationParam.setFromDate("2019-06-01 00:00:00");
        leaveApproveDurationParam.setToDate(formatter.format(new Date()));

        Result<LeaveApproveDurationResult> result =  dingTalkClient.getLeaveApproveDuration(leaveApproveDurationParam);
        logger.info("输出结果 result：{}",result);
    }


    /**
     * 获取TOKEN
     * */
    @Test
    public void getToken() {
        String token = dingTalkInRedisConfigStorage.getAccessToken();
        logger.info("================== token ==========：{}",token);
    }
}