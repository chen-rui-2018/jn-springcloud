package com.jn.oa.meeting.dao;

import com.jn.oa.meeting.entity.TbOaMeeting;
import com.jn.oa.meeting.model.OaMeetingNotice;
import com.jn.oa.meeting.model.OaMeetingPage;
import com.jn.oa.meeting.vo.OaMeetingParticipantVo;
import com.jn.oa.meeting.vo.OaMeetingVo;

import java.util.List;
import java.util.Map;

/**
 * 会议dao
 * @author： yuanyy
 * @date： Created on 2019/02/14 17:03
 * @version： v1.0
 * @modified By:
 */
public interface MeetingMapper {


    void deleteBranchByIds(Map<String, Object> map);

    List<OaMeetingVo> selectMeetingListByCondition(OaMeetingPage oaMeetingPage);

    OaMeetingParticipantVo  selectMeetingById(String id);

    List<TbOaMeeting> selectNotCompleteMeetingByTimeAndMeetingRoomId(TbOaMeeting tbOaMeeting);

    List<OaMeetingNotice > noticesApplicationMeeting();

    void updateMeetingRunningStatusByTime();

    void updateMeetingCompleteStatusByTime();
}