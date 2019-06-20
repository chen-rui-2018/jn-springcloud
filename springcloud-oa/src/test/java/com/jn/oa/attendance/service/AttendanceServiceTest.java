package com.jn.oa.attendance.service;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.oa.attendance.enmus.AttendancePlatformEnums;
import com.jn.oa.attendance.enmus.AttendanceTypeEnums;
import com.jn.oa.attendance.model.AttendanceAdd;
import com.jn.oa.model.Attendance;
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

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * 考勤管理service单元测试
 *
 * @author： yuanyy
 * @date： Created on 2019/2/17 17:03
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AttendanceServiceTest {

    @Autowired
    public AttendanceService attendanceService;

    private  static String attendanceId;

    private  static String attendanceType;

    private static User user;

    private static AttendanceAdd attendanceAdd;

    private static Attendance attendance;



    @BeforeClass
    public static void init() {
        //初始化添加用户
        user = new User();
        user.setAccount("wangsong");
        user.setId("10000");


        //初始化部门部门id及部门名称
        attendanceId = UUID.randomUUID().toString();

        //初始化部门对象
        attendanceAdd = new AttendanceAdd();
        attendanceAdd.setId(attendanceId);
        attendanceAdd.setAttendancePlatform(AttendancePlatformEnums .PLATFORM_PC.getCode());

        //初始化添加用户
        attendance = new Attendance();
        // leave.setUserId("10000");


        //初始化部门部门id及部门名称
        //attendance.setDepartmentId("116");


        //结束时间
        attendance.setEndTime(new Date());

    }

    /**
     * 签到
     */
    @Test
    public void signIn() {
        attendanceType= AttendanceTypeEnums.SIGN_IN.getCode();
        attendanceAdd.setType(attendanceType);
        try {
            attendanceService.attendance(attendanceAdd,user);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    /**
     * 签退
     */
    @Test
    public void signOut() {
        attendanceType= AttendanceTypeEnums.SIGN_OUT.getCode();
        attendanceAdd.setType(attendanceType);
        try {
            attendanceService.attendance(attendanceAdd,user);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    /**
     * 根据用户id查询考勤信息
     */
    @Test
    public void getAttendanceByUserId() {
        try {
            attendanceService.getAttendanceByUserId(user.getId());
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    /**
     * oa-api根据条件查询考勤信息
     */
    @Test
    public void selectApiAttendanceListByCondition() {
        try {
            attendanceService.selectApiAttendanceListByCondition(attendance);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }





}
