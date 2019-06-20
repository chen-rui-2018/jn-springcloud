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
            leaveStatusListParam.setUserid_list("1760054150647048" +
                    ",176005420021472913" +
                    ",061838443733317635" +
                    ",06084024281089553" +
                    ",181642044421752203" );
            leaveStatusListParam.setStart_time(formatter.parse("2019-03-01 00:00:00").getTime());
            leaveStatusListParam.setEnd_time(new Date().getTime());
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
        leaveApproveDurationParam.setUserid("176005420021472913");
        leaveApproveDurationParam.setFrom_date("2019-06-01 00:00:00");
        leaveApproveDurationParam.setTo_date(formatter.format(new Date()));

        Result<LeaveApproveDurationResult> result =  dingTalkClient.getLeaveApproveDuration(leaveApproveDurationParam);
        logger.info("输出结果 result：{}",result);
    }


}