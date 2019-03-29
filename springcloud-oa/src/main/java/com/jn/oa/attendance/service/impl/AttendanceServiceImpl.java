package com.jn.oa.attendance.service.impl;

import com.jn.oa.attendance.dao.AttendanceMapper;
import com.jn.oa.attendance.dao.TbOaAttendanceMapper;
import com.jn.oa.attendance.enmus.AttendanceTypeEnums;
import com.jn.oa.attendance.entity.TbOaAttendance;
import com.jn.oa.attendance.entity.TbOaAttendanceCriteria;
import com.jn.oa.attendance.model.Attendance;
import com.jn.oa.attendance.model.AttendanceAdd;
import com.jn.oa.attendance.service.AttendanceService;
import com.jn.oa.attendance.vo.AttendanceResultVo;
import com.jn.system.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 考勤签到serviceImpl
 *
 * @author： yuanyy
 * @date： Created on 2019/3/22 10:26
 * @version： v1.0
 * @modified By:
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private TbOaAttendanceMapper tbOaAttendanceMapper;

    @Autowired
    private AttendanceMapper attendanceMapper;


    /**
     * 考勤签到
     *
     * @param attendanceAdd
     * @param user       当前用户
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AttendanceResultVo attendance(AttendanceAdd  attendanceAdd, User user) {
        TbOaAttendance tbOaAttendance=new TbOaAttendance();
        BeanUtils.copyProperties(attendanceAdd, tbOaAttendance);

        tbOaAttendance.setAttendanceTime(new Date());
        tbOaAttendance.setAttendanceUser(user.getId());
        tbOaAttendance.setCreatedTime(new Date());
        tbOaAttendance.setCreatorAccount(user.getAccount());


        //查询改用户当天签到列表
        Attendance attendance=new Attendance();
        BeanUtils.copyProperties(tbOaAttendance, attendance);
        List<TbOaAttendance> tbOaAttendanceList= attendanceMapper.selectAttendanceByCondition(attendance);

        //有签到数据则更新，否则就新增
        if(tbOaAttendanceList!=null&&tbOaAttendanceList.size()>0){
            tbOaAttendanceMapper.updateByPrimaryKeySelective(tbOaAttendance);
        }else{
            tbOaAttendanceMapper.insert(tbOaAttendance);
        }

        //签到返回
        AttendanceResultVo attendanceResultVo=new AttendanceResultVo();
        attendanceResultVo.setType(tbOaAttendance.getType());
        attendanceResultVo.setAttendanceTime(tbOaAttendance.getAttendanceTime());
        return attendanceResultVo;
    }


    /**
     * 查询考勤详情
     *
     * @param attendanceId 考勤id
     * @return
     */
    @Override
    public TbOaAttendance getAttendanceById(String attendanceId) {
        return tbOaAttendanceMapper.selectByPrimaryKey(attendanceId);
    }

    /**
     * 根据用户id查询考勤详情
     *
     * @param userId 用户id
     * @return
     */
    @Override
    public List<TbOaAttendance> getAttendanceByUserId(String userId) {

        Attendance attendance=new Attendance();
        attendance.setAttendanceUser(userId);
        return  attendanceMapper.selectAttendanceByCondition(attendance);
    }

    /**
     * 根据条件查询考勤列表
     *
     * @param attendance
     * @return
     */
    @Override
    public List<TbOaAttendance> selectAttendanceListByCondition(Attendance  attendance) {
        return attendanceMapper.selectAttendanceByCondition(attendance);
    }
}
