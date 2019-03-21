package com.jn.oa.meeting.service;

import com.jn.common.model.PaginationData;
import com.jn.oa.meeting.entity.TbOaMeetingRoom;
import com.jn.oa.meeting.model.OaMeetingRoom;
import com.jn.oa.meeting.model.OaMeetingRoomAdd;
import com.jn.oa.meeting.model.OaMeetingRoomOrderPage;
import com.jn.oa.meeting.model.OaMeetingRoomPage;
import com.jn.oa.meeting.vo.OaMeetingRoomVo;
import com.jn.system.model.User;

import java.util.List;

/**
 * 会议室service
 * @author： yuanyy
 * @date： Created on 2019/2/13 17:01
 * @version： v1.0
 * @modified By:
 */
public interface MeetingRoomService {
    /**
     * 根据关键字分页查询会议室列表
     *
     * @param oaMeetingRoomPage
     * @return
     */
    PaginationData selectOaMeetingRoomListBySearchKey(OaMeetingRoomPage oaMeetingRoomPage);

    /**
     * 根据关键字查询会议室列表
     *
     * @param oaMeetingRoomPage
     * @return
     */
    List<OaMeetingRoomVo> selectOaMeetingRoomListBySearchKeyNoPage(OaMeetingRoomPage oaMeetingRoomPage);

    /**
     * 新增会议室
     *
     * @param tbOaMeetingRoom
     */
    void insertOaMeetingRoom(TbOaMeetingRoom tbOaMeetingRoom,String[] attachmentPaths);

    /**
     * 更新会议室信息
     *
     * @param oaMeetingRoomAdd
     * @param user         当前用户信息
     */
    void updateOaMeetingRoomById(OaMeetingRoomAdd oaMeetingRoomAdd, User user, String[] attachmentPaths);

    /**
     * 逻辑删除会议室信息
     *
     * @param ids
     * @param user 当前用户信息
     */
    void deleteOaMeetingRoomByIds(String[] ids, User user);

    /**
     * 检查会议室名称是否可用
     * @param tbOaMeetingRoomName
     * @return
     */
    String checkMeetingRoomName(String tbOaMeetingRoomName);

    /**
     * 根据会议室id查询会议室
     * @param id
     * @return
     */
    OaMeetingRoomVo selectOaMeetingRoomByIds(String id);

    /**
     * 分页查询会议室预约列表
     * @param oaMeetingRoomOrderPage
     * @return
     */
    PaginationData selectMeetingRoomAndMeetingOrder(OaMeetingRoomOrderPage oaMeetingRoomOrderPage);

    /**
     * 分页查询会议室可选列表
     * @param oaMeetingRoomPage
     * @return
     */
    PaginationData selectAvailableMeetingRoomList(OaMeetingRoomPage oaMeetingRoomPage);




}
