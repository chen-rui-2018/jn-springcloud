package com.jn.oa.attendance.service;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.hr.model.*;
import com.jn.oa.attendance.entity.TbOaAttendance;
import com.jn.oa.attendance.model.AttendanceAdd;
import com.jn.oa.attendance.model.AttendanceLocation;
import com.jn.oa.attendance.model.AttendancePage;
import com.jn.oa.attendance.vo.AttendanceResultVo;
import com.jn.oa.attendance.vo.AttendanceVo;
import com.jn.oa.model.Attendance;
import com.jn.oa.vo.AttendanceApiVo;
import com.jn.system.model.User;

import java.util.List;

/**
 * @author： yuanyy
 * @date： Created on 2019/3/21 15:32
 * @version： v1.0
 * @modified By:
 **/
public interface AttendanceService {
    /**
     * 考勤签到
     *
     * @param attendance
     * @param user      当前用户
     */
    AttendanceResultVo attendance(AttendanceAdd  attendance, User user);



    /**
     * 查询考勤详情
     *
     * @param attendanceId 考勤id
     * @return
     */
    TbOaAttendance getAttendanceById(String attendanceId);

    /**
     * 根据用户id查询考勤详情
     *
     * @param userId 用户id
     * @return
     */
    List<AttendanceVo> getAttendanceByUserId(String userId);

    /**
     * 根据当前时间查询考勤详情
     * @param userId
     * @return
     */
    AttendanceVo selectByUserIdAndCurrentDate(String userId);


    /**
     * 根据条件查询考勤列表
     *
     * @param attendance
     * @return
     */
    PaginationData selectAttendanceListByCondition(AttendancePage attendance);


    /**
     * OA-API根据条件查询考勤列表
     *
     * @param attendance
     * @return
     */
    List<AttendanceApiVo> selectApiAttendanceListByCondition(Attendance attendance);


    /**
     * 根据用户id查询用户考勤打卡数据
     * @param attendanceManagement
     * @return
     */
    Result<List<AttendanceManagementApiVo>> selectAttendanceManagementByUserId(AttendanceManagement attendanceManagement);


    /**
     * 根据部门id查询部门考勤打卡数据
     * @param attendanceManagement
     * @return
     */
    Result<AttendanceManageApiVo> selectAttendanceManagementByDepartmentId(AttendanceManagement attendanceManagement);

    /**
     * 根据用户id查询用户考勤接口
     *
     * @param attendanceOverTime
     * @return
     */
    Result<AttendanceOverTimeApiVo> selectByUserIdAndTime(AttendanceOverTime attendanceOverTime);

    /**
     * 根据经纬度查询距离与是否能进行打卡
     * @param longitude
     * @param latitude
     * @return
     */
    AttendanceLocation selectLocation(String longitude,String latitude);
}
