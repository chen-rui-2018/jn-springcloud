package com.jn.oa.meeting.dao;

import com.jn.oa.meeting.model.OaMeetingAttendancePage;
import com.jn.oa.meeting.vo.OaMeetingAttendanceVo;
import com.jn.oa.meeting.vo.OaMeetingParticipantsAttendanceVo;

import java.util.List;
import java.util.Map;

/**
 * 会议参会人员dao
 * @author： yuanyy
 * @date： Created on 2019/02/14 17:03
 * @version： v1.0
 * @modified By:
 */
public interface MeetingParticipantMapper {


    void deleteBranchByIds(Map<String, Object> map);

    void deleteBranchByMeetingIds(Map<String, Object> maps);

    List<OaMeetingParticipantsAttendanceVo> selectMeetingAttendanceListByCondition(OaMeetingAttendancePage oaMeetingAttendancePage);

    OaMeetingAttendanceVo selectList(String id);



}