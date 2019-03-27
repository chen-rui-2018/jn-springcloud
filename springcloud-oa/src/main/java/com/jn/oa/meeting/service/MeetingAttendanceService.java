package com.jn.oa.meeting.service;


import com.jn.common.model.PaginationData;
import com.jn.oa.meeting.model.OaMeetingAttendancePage;
import com.jn.oa.meeting.model.OaMeetingParticipantsAttendance;
import com.jn.oa.meeting.vo.OaMeetingAttendanceVo;
import com.jn.oa.meeting.vo.OaMeetingParticipantsAttendanceVo;
import com.jn.system.model.User;

/**
 * 会议考勤service
 * @author： yuanyy
 * @date： Created on 2019/2/13 17:01
 * @version： v1.0
 * @modified By:
 */


public interface MeetingAttendanceService {

    /**
     * 会议考勤签到、签退接口
     * @param oaMeetingParticipantsAttendance
     * @param user
     */
    void meetingAttendanceSignIn(OaMeetingParticipantsAttendance oaMeetingParticipantsAttendance, User user);


    /**
     * 根据id查询考勤详情
     * @param id
     * @return
     */
    OaMeetingAttendanceVo selectMeetingAttendanceById(String id);

    /**
     * 列表查询考勤
     * @param oaMeetingAttendancePage
     * @return
     */
    PaginationData selectMeetingAttendanceList(OaMeetingAttendancePage oaMeetingAttendancePage);




}
