package com.jn.oa.seivice;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.oa.common.enums.OaStatusEnums;
import com.jn.oa.meeting.enums.OaMeetingApproveStatusEnums;
import com.jn.oa.meeting.model.OaMeeting;
import com.jn.oa.meeting.model.OaMeetingAdd;
import com.jn.oa.meeting.model.OaMeetingApprove;
import com.jn.oa.meeting.service.MeetingService;
import com.jn.system.model.User;
import org.apache.commons.lang.RandomStringUtils;
import org.hamcrest.Matchers;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

/**
 * 会议管理service单元测试
 *
 * @author： yuanyy
 * @date： Created on 2019/2/17 17:03
 * @version： v1.0
 * @modified By:
 */
@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OaMeetingServiceTest {

    @Autowired
    public MeetingService meetingService;

    private  static String meetingId;

    private  static String meetingName;

    private static User user;

    private static OaMeetingAdd oaMeetingAdd;

    private static OaMeetingApprove oaMeetingApprove;

    @BeforeClass
    public static void init() {
        //初始化添加用户
        user = new User();
        user.setAccount("10000");

        //初始化部门部门id及部门名称
        meetingId = UUID.randomUUID().toString();
        meetingName = "测试会议室名称" + RandomStringUtils.randomNumeric(4);

        //初始化部门对象
        oaMeetingAdd = new OaMeetingAdd();
        oaMeetingAdd.setId(meetingId);
        oaMeetingAdd.setApplicant(user.getAccount());
        oaMeetingAdd.setTitle("测试会议标题");
        oaMeetingAdd.setOaMeetingContent("测试会议内容");
        oaMeetingAdd.setApplicationTime(new Date());
        //审批中
        oaMeetingAdd.setApprovalStatus(OaMeetingApproveStatusEnums .APPROVAL.getCode());
        oaMeetingAdd.setCreatorAccount(user.getAccount());
        oaMeetingAdd.setCreatedTime(new Date());
        Byte cancelledStatus = Byte.parseByte(OaStatusEnums.EFFECTIVE.getCode());
        oaMeetingAdd.setRecordStatus(cancelledStatus);
    }

    @Test
    public void add() {
        try {
            meetingService.insertOaMeeting(oaMeetingAdd);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void selectByPrimaryKeyTest() {
        OaMeeting data = meetingService.selectOaMeetingByIds(meetingId);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void updateTest() {
        OaMeeting oaMeeting = new OaMeeting();
        oaMeeting.setId(meetingId);
        Byte recordStatus = Byte.parseByte(OaStatusEnums.EFFECTIVE.getCode());
        oaMeeting.setRecordStatus(recordStatus);
        oaMeeting.setTitle(meetingName);
        try {
            meetingService.updateOaMeetingById(oaMeeting,user);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void zDeleteTest() {
        String[] ids={meetingId};
        meetingService.deleteOaMeetingByIds(ids,user);
    }

    @Test
    public void approveTest() {
        oaMeetingApprove =new OaMeetingApprove();
        oaMeetingApprove.setId(meetingId);
        oaMeetingApprove.setApprovalOpinion("测试审批意见");
        oaMeetingApprove.setModifiedTime(new Date());
        oaMeetingApprove.setApprovalUser(user.getAccount());
        oaMeetingApprove.setApprovalStatus(OaMeetingApproveStatusEnums.APPROVAL_PASS.getCode());

        meetingService.approveOaMeeting(oaMeetingApprove,user);
    }

    @Test
    public void finishTest() {
        meetingService.finishOaMeeting(meetingId,user);
    }
}
