package com.jn.oa.meeting.service;

import com.jn.common.model.PaginationData;
import com.jn.oa.meeting.entity.TbOaMeeting;
import com.jn.oa.meeting.model.OaMeeting;
import com.jn.oa.meeting.model.OaMeetingAdd;
import com.jn.oa.meeting.model.OaMeetingApprove;
import com.jn.oa.meeting.model.OaMeetingPage;
import com.jn.oa.meeting.vo.OaMeetingParticipantVo;
import com.jn.oa.meeting.vo.OaMeetingVo;
import com.jn.system.model.User;

/**
 * 会议service
 * @author： yuanyy
 * @date： Created on 2019/2/13 17:01
 * @version： v1.0
 * @modified By:
 */
public interface MeetingService {
    /**
     * 根据关键字分页查询会议列表
     *
     * @param oaMeetingPage
     * @return
     */
    PaginationData selectOaMeetingListBySearchKey(OaMeetingPage oaMeetingPage);

    /**
     * 新增会议
     *
     * @param oaMeetingAdd
     */
    void insertOaMeeting(OaMeetingAdd oaMeetingAdd);

    /**
     * 更新会议信息
     *
     * @param oaMeeting
     * @param user         当前用户信息
     */
    void updateOaMeetingById(OaMeetingAdd oaMeeting, User user);

    /**
     * 逻辑删除会议信息
     *
     * @param ids
     * @param user 当前用户信息
     */
    void deleteOaMeetingByIds(String[] ids, User user);

    /**
     * 检查会议名称是否可用
     * @param tbOaMeetingRoomName
     * @return
     */
    String checkMeetingName(String tbOaMeetingRoomName);

    /**
     * 根据会议id查询会议
     * @param id
     * @return
     */
    OaMeetingParticipantVo selectOaMeetingById(String id);

    /**
     * 审核会议
     * @param oaMeetingApprove
     * @param approveUser
     */
    void  approveOaMeeting(OaMeetingApprove oaMeetingApprove, User approveUser) ;

    /**
     * 结束会议
     * @param meetingId
     * @param approveUser
     */
    void finishOaMeeting(String meetingId,User approveUser);

    /**
     * 取消会议
     * @param meetingId
     * @param user
     */
    void cancelOaMeeting(String meetingId,User user);


}
