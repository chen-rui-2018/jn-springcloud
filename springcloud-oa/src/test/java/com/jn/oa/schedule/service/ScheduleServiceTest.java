package com.jn.oa.schedule.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.oa.common.enums.OaExceptionEnums;
import com.jn.oa.schedule.enums.ScheduleExceptionEnums;
import com.jn.oa.schedule.enums.ScheduleRemindEnums;
import com.jn.oa.schedule.model.ScheduleEdit;
import com.jn.oa.schedule.model.ScheduleQuery;
import com.jn.system.model.User;
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

import java.util.Date;
import java.util.UUID;

/**
 * 日程管理单元测试
 *
 * @author： shaobao
 * @date： Created on 2019/2/17 17:03
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScheduleServiceTest {

    @Autowired
    private ScheduleService scheduleService;

    private static User user;

    private static ScheduleEdit schedule;

    private static String scheduleId;

    @BeforeClass
    public static void init() {
        //初始化添加用户
        user = new User();
        user.setAccount("wangsong");

        scheduleId = UUID.randomUUID().toString();

        schedule = new ScheduleEdit();
        schedule.setId(scheduleId);
        schedule.setTitle("日程测试");
        schedule.setContent("日程内容测试");
        schedule.setRemark("日程备注测试");
        schedule.setStartTime(new Date(System.currentTimeMillis() + 60000L));
        schedule.setEndTime(new Date());
        schedule.setIsRemind(ScheduleRemindEnums.NO.getCode());
    }

    /**
     * 测试日程管理添加编辑功能,及定时正常设置功能
     * <p>
     * 1.测试添加,不定时
     * 2.测试编辑时开始时间大于结束时间
     * 3.测试定时添加,没有选择定时方式
     * 4.测试编辑,定时,正常添加
     */
    @Test
    public void t001_addOrUpdate() {
        //1.测试编辑时开始时间大于结束时间
        try {
            scheduleService.addOrUpdate(schedule, true, user);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e.getCode(), Matchers.equalTo(ScheduleExceptionEnums.SCHEDULE_TIME_ERROR.getCode()));
        }

        //2.测试添加,不定时
        schedule.setEndTime(new Date(System.currentTimeMillis() + 120000L));
        scheduleService.addOrUpdate(schedule, true, user);

        //3.测试编辑数据不存在
        try {
            schedule.setId("dsfkljkldjalfsdnfasdf3333");
            scheduleService.addOrUpdate(schedule, false, user);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e.getCode(), Matchers.equalTo(OaExceptionEnums.UPDATEDATA_NOT_EXIST.getCode()));
        }

        //4.测试定时添加,没有选择定时方式
        try {
            schedule.setId(scheduleId);
            schedule.setIsRemind(ScheduleRemindEnums.YES.getCode());
            schedule.setRemindTime(new Date());
            scheduleService.addOrUpdate(schedule, false, user);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e.getCode(), Matchers.equalTo(ScheduleExceptionEnums.REMIND_METHOD_NOT_EMPTY.getCode()));
        }

        //5.测试编辑,定时,正常添加
        schedule.setAppRemind(ScheduleRemindEnums.YES.getCode());
        schedule.setPcRemind(ScheduleRemindEnums.YES.getCode());
        schedule.setWechatRemind(ScheduleRemindEnums.YES.getCode());
        schedule.setMessageRemind(ScheduleRemindEnums.YES.getCode());
        schedule.setRemindTime(new Date());
        schedule.setStartTime(new Date(System.currentTimeMillis() + 60000L));
        schedule.setEndTime(new Date(System.currentTimeMillis() + 120000L));
        scheduleService.addOrUpdate(schedule, false, user);
    }

    @Test
    public void list(){
        ScheduleQuery query = new ScheduleQuery();
        query.setUserAccount(user.getAccount());
        query.setDate(new Date());
        query.setTitle("日程");
        query.setEndTime(new Date(System.currentTimeMillis() + 20000L));
        query.setStartTime(new Date(System.currentTimeMillis() - 20000L));
        scheduleService.list(query);
    }

    @Test
    public void t004_delete() {
        scheduleService.delete(scheduleId,user);
    }
}