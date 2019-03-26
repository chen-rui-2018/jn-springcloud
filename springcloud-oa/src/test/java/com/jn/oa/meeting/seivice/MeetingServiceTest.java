package com.jn.oa.meeting.seivice;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.oa.common.enums.OaStatusEnums;
import com.jn.oa.meeting.enums.MeetingApproveStatusEnums;
import com.jn.oa.meeting.model.*;
import com.jn.oa.meeting.service.MeetingService;
import com.jn.oa.meeting.vo.OaMeetingParticipantVo;
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
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MeetingServiceTest {

    @Autowired
    public MeetingService meetingService;

    private  static String meetingId;

    private  static String meetingName;

    private static User user;

    private static OaMeetingAdd oaMeetingAdd;

    private static OaMeetingApprove oaMeetingApprove;

   /* @Autowired
    private MessageSource messageSource;*/


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
        oaMeetingAdd.setMeetingRoomId("86580b0b-b1a2-4803-974a-877f0f41e6b1");
        oaMeetingAdd.setTitle("测试会议标题");
        oaMeetingAdd.setOaMeetingContent("测试会议内容");
        String[] participantsId={"01cc6db5-9cbb-4399-ac96-3fba0f9e64fa","0571e04f-b28c-4efd-a681-780bed72aede"};
        oaMeetingAdd.setParticipantsId(participantsId);
        oaMeetingAdd.setApplicationTime(new Date());
        //审批中
        oaMeetingAdd.setApprovalStatus(MeetingApproveStatusEnums.APPROVAL.getCode());
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
    public void selectListTest() {
        OaMeetingPage oaMeetingPage=new OaMeetingPage();
        oaMeetingPage.setPage(1);
        oaMeetingPage.setRows(10);
        //oaMeetingRoomPage.setName("3");
        PaginationData data = meetingService.selectOaMeetingListBySearchKey(oaMeetingPage,user);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void selectByPrimaryKeyTest() {
        OaMeetingParticipantVo data = meetingService.selectOaMeetingById(meetingId);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void updateTest() {
        OaMeetingAdd oaMeeting = new OaMeetingAdd();
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
    public void approveTest() throws Exception{
        oaMeetingApprove =new OaMeetingApprove();
        oaMeetingApprove.setId("07793b4d-fae6-4dd9-adf3-dc19bc32cddd");
        oaMeetingApprove.setApprovalOpinion("测试审批意见");
        oaMeetingApprove.setModifiedTime(new Date());
        oaMeetingApprove.setApprovalUser(user.getAccount());
        oaMeetingApprove.setApprovalStatus(MeetingApproveStatusEnums.APPROVAL_PASS.getCode());

        meetingService.approveOaMeeting(oaMeetingApprove,user);
    }

    @Test
    public void finishTest() {
        meetingService.finishOaMeeting(meetingId,user);
    }

 /*   @Test
    public void sendMessage() {
        SmsTemplateVo smsTemplateVo = new SmsTemplateVo();
        smsTemplateVo.setTemplateId("1001");
        String[] m = {"18312736252"};
        smsTemplateVo.setMobiles(m);
        String[] t = {"12345666"};
        smsTemplateVo.setContents(t);
        messageSource.outputSms().send(MessageBuilder.withPayload(smsTemplateVo).build());
    }*/

}
