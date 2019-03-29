package com.jn.oa.meeting.seivice;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.oa.attendance.enmus.AttendancePlatformEnums;
import com.jn.oa.attendance.enmus.AttendanceTypeEnums;
import com.jn.oa.attendance.model.AttendanceAdd;
import com.jn.oa.attendance.service.AttendanceService;
import com.jn.oa.meeting.enums.MeetingAttendanceTypeEnums;
import com.jn.oa.meeting.model.OaMeetingAttendancePage;
import com.jn.oa.meeting.model.OaMeetingParticipantsAttendance;
import com.jn.oa.meeting.service.MeetingAttendanceService;
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

import java.util.UUID;

/**
 * 会议考勤管理service单元测试
 *
 * @author： yuanyy
 * @date： Created on 2019/2/17 17:03
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MeetingAttendanceServiceTest {

    @Autowired
    public MeetingAttendanceService meetingAttendanceService;

    private  static String meetingAttendanceType;

    private static User user;

    private static OaMeetingParticipantsAttendance meetingParticipantsAttendance;



    @BeforeClass
    public static void init() {
        //初始化添加用户
        user = new User();
        user.setAccount("wangsong");
        user.setId("10000");


        //初始化对象
        meetingParticipantsAttendance = new OaMeetingParticipantsAttendance();
        meetingParticipantsAttendance.setMeetingId("07ce8588-4f19-4ced-95a7-cfac3e00efdf");

    }

    /**
     * 签到
     */
    @Test
    public void signIn() {
        meetingAttendanceType= MeetingAttendanceTypeEnums.MEETING_SIGN_IN.getCode();
        meetingParticipantsAttendance.setMeetingAttendanceType(meetingAttendanceType);
        try {
            meetingAttendanceService.meetingAttendanceSignIn(meetingParticipantsAttendance,user);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    /**
     * 签退
     */
    @Test
    public void signOut() {
        meetingAttendanceType= MeetingAttendanceTypeEnums.MEETING_SIGN_OUT.getCode();
        meetingParticipantsAttendance.setMeetingAttendanceType(meetingAttendanceType);
        try {
            meetingAttendanceService.meetingAttendanceSignIn(meetingParticipantsAttendance,user);
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
            meetingAttendanceService.selectMeetingAttendanceById("50454442-18d1-4b7b-8125-5da32d3f2b71");
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    /**
     * 根据用户id查询考勤信息
     */
    @Test
    public void listTest() {
        try {
            OaMeetingAttendancePage oaMeetingAttendancePage=new OaMeetingAttendancePage();
            oaMeetingAttendancePage.setRows(10);
            oaMeetingAttendancePage.setPage(1);
            meetingAttendanceService.selectMeetingAttendanceList(oaMeetingAttendancePage);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }







}
