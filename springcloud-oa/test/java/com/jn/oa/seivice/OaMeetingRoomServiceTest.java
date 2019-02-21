package com.jn.oa.seivice;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.oa.common.enums.OaStatusEnums;
import com.jn.oa.meeting.entity.TbOaMeetingRoom;
import com.jn.oa.meeting.model.OaMeetingRoom;
import com.jn.oa.meeting.model.OaMeetingRoomPage;
import com.jn.oa.meeting.service.MeetingRoomService;
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
 * 会议室管理service单元测试
 *
 * @author： yuanyy
 * @date： Created on 2019/2/17 17:03
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OaMeetingRoomServiceTest {

    @Autowired
    public MeetingRoomService meetingRoomService;

    private  static String meetingRoomId;

    private  static String meetingRoomName;

    private static User user;

    private static TbOaMeetingRoom tbOaMeetingRoom;

    @BeforeClass
    public static void init() {
        //初始化添加用户
        user = new User();
        user.setAccount("10000");

        //初始化部门部门id及部门名称
        meetingRoomId = UUID.randomUUID().toString();
        meetingRoomName = "测试会议室名称" + RandomStringUtils.randomNumeric(4);

        //初始化部门对象
        tbOaMeetingRoom = new TbOaMeetingRoom();
        tbOaMeetingRoom.setCapacity("10");
        tbOaMeetingRoom.setExplains("测试数据");
        tbOaMeetingRoom.setBuilding("102栋");
        tbOaMeetingRoom.setFloor("2层");
        tbOaMeetingRoom.setRoomNumber("101");
        tbOaMeetingRoom.setId(meetingRoomId);
        tbOaMeetingRoom.setName(meetingRoomName);
        tbOaMeetingRoom.setCreatorAccount(user.getAccount());
        tbOaMeetingRoom.setCreatedTime(new Date());
        tbOaMeetingRoom.setRecordStatus(OaStatusEnums.EFFECTIVE.getCode());
    }

    @Test
    public void add() {
        try {
            meetingRoomService.insertOaMeetingRoom(tbOaMeetingRoom);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void selectByPrimaryKeyTest() {
        OaMeetingRoom data = meetingRoomService.selectOaMeetingRoomByIds(meetingRoomId);
        Assert.assertThat(data, Matchers.anything());
    }
    @Test
    public void selectListTest() {
        OaMeetingRoomPage oaMeetingRoomPage=new OaMeetingRoomPage();
        oaMeetingRoomPage.setPage(1);
        oaMeetingRoomPage.setRows(10);
        PaginationData data = meetingRoomService.selectOaMeetingRoomListBySearchKey(oaMeetingRoomPage);
        Assert.assertThat(data, Matchers.anything());
    }

    @Test
    public void updateTest() {
        OaMeetingRoom oaMeetingRoom = new OaMeetingRoom();
        oaMeetingRoom.setId(meetingRoomId);
        Byte recordStatus = Byte.parseByte(OaStatusEnums.EFFECTIVE.getCode());
        oaMeetingRoom.setRecordStatus(recordStatus);
        oaMeetingRoom.setName(meetingRoomName);
        try {
            meetingRoomService.updateOaMeetingRoomById(oaMeetingRoom,user);
        } catch (JnSpringCloudException e) {
            Assert.assertThat(e, Matchers.anything());
        }
    }

    @Test
    public void zDeleteTest() {
        String[] ids={meetingRoomId};
        meetingRoomService.deleteOaMeetingRoomByIds(ids,user);
    }
}
