package com.jn.oa.attendance.dao;

import com.jn.oa.attendance.entity.TbOaAttendance;
import com.jn.oa.attendance.model.Attendance;
import com.jn.oa.attendance.model.AttendancePage;
import com.jn.oa.attendance.vo.AttendanceVo;

import java.util.List;

/**
 * 考勤mapper
 *
 * @author： yuanyy
 * @date： Created on 2019/3/22 11:41
 * @version： v1.0
 * @modified By:
 */
public interface AttendanceMapper {

    List<AttendanceVo> selectAttendanceByCondition(AttendancePage attendancePage);
}
