package com.jn.oa.attendance.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.oa.attendance.dao.AttendanceMapper;
import com.jn.oa.attendance.dao.TbOaAttendanceMapper;
import com.jn.oa.attendance.enmus.AttendanceExceptionEnums;
import com.jn.oa.attendance.enmus.AttendanceTypeEnums;
import com.jn.oa.attendance.entity.TbOaAttendance;
import com.jn.oa.attendance.entity.TbOaAttendanceCriteria;
import com.jn.oa.attendance.model.AttendanceAdd;
import com.jn.oa.attendance.model.AttendancePage;
import com.jn.oa.attendance.service.AttendanceService;
import com.jn.oa.attendance.vo.AttendanceResultVo;
import com.jn.oa.attendance.vo.AttendanceVo;
import com.jn.oa.model.Attendance;
import com.jn.oa.vo.AttendanceApiVo;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    private static Logger logger = LoggerFactory.getLogger(AttendanceServiceImpl.class);

    @Autowired
    private TbOaAttendanceMapper tbOaAttendanceMapper;

    @Autowired
    private AttendanceMapper attendanceMapper;


    /**
     * 考勤签到/签退
     *
     * @param attendanceAdd
     * @param user       当前用户
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @ServiceLog(doAction = "考勤签到/签退")
    public AttendanceResultVo attendance(AttendanceAdd  attendanceAdd, User user) {
        TbOaAttendance tbOaAttendance=new TbOaAttendance();
        BeanUtils.copyProperties(attendanceAdd, tbOaAttendance);

        //查询改用户当天签到列表
        AttendanceVo attendanceVo= selectByUserIdAndCurrentDate(attendanceAdd.getAttendanceUser());

        //考勤返回
        AttendanceResultVo attendanceResultVo=new AttendanceResultVo();
        attendanceResultVo.setType(attendanceAdd.getType());

        //签到
        if(AttendanceTypeEnums.SIGN_IN.getCode().equals(attendanceAdd.getType())){
            if(attendanceVo!=null){
                logger.warn("[考勤管理] 考勤签到失败，用户不能进行多次签到！,userId：{}", user.getId());
                throw  new JnSpringCloudException(AttendanceExceptionEnums.ATTENDANCE_SIGN_IN);
            }
            tbOaAttendance.setAttendanceUser(user.getId());
            tbOaAttendance.setCreatedTime(new Date());
            tbOaAttendance.setCreatorAccount(user.getAccount());
            //签到
            tbOaAttendance.setId(UUID.randomUUID().toString());
            tbOaAttendance.setSignInAttendanceTime(new Date());
            tbOaAttendance.setSignInAttendanceIp(attendanceAdd.getAttendanceIp());
            tbOaAttendance.setSignInAttendancePlatform(attendanceAdd.getAttendancePlatform());
            tbOaAttendance.setSignInLatitude(attendanceAdd.getLatitude());
            tbOaAttendance.setSignInLongitude(attendanceAdd.getLongitude());

            attendanceResultVo.setAttendanceTime(tbOaAttendance.getSignInAttendanceTime());

            tbOaAttendanceMapper.insert(tbOaAttendance);
        }
        //签退
        else if(AttendanceTypeEnums.SIGN_OUT.getCode().equals(attendanceAdd.getType())){
            //无签到数据
            if(attendanceVo==null){
                logger.warn("[考勤管理] 考勤签退失败，用户未进行签到，不能进行签退！,userId：{}",user.getId());
                throw  new JnSpringCloudException(AttendanceExceptionEnums.ATTENDANCE_SIGN_OUT);
            }
            tbOaAttendance.setSignOutAttendanceTime(new Date());
            tbOaAttendance.setSignOutAttendanceIp(attendanceAdd.getAttendanceIp());
            tbOaAttendance.setSignOutAttendancePlatform(attendanceAdd.getAttendancePlatform());
            tbOaAttendance.setSignOutLatitude(attendanceAdd.getLatitude());
            tbOaAttendance.setSignOutLongitude(attendanceAdd.getLongitude());
            //签退
            attendanceResultVo.setAttendanceTime(tbOaAttendance.getSignOutAttendanceTime());

            TbOaAttendanceCriteria attendanceCriteria=new TbOaAttendanceCriteria();
            TbOaAttendanceCriteria.Criteria criteria=attendanceCriteria.createCriteria();
            criteria.andIdEqualTo(attendanceVo.getId());
            tbOaAttendanceMapper.updateByExampleSelective(tbOaAttendance,attendanceCriteria);
        }


        return attendanceResultVo;
    }


    /**
     * 查询考勤详情
     *
     * @param attendanceId 考勤id
     * @return
     */
    @Override
    @ServiceLog(doAction = "查询考勤详情")
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
    @ServiceLog(doAction = "根据用户id查询考勤详情")
    public List<AttendanceVo> getAttendanceByUserId(String userId) {

        AttendancePage attendance=new AttendancePage();
        attendance.setAttendanceUser(userId);
        return  attendanceMapper.selectAttendanceByCondition(attendance);
    }

    /**
     * 根据当前时间查询考勤详情
     *
     * @param userId
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据当前时间查询考勤详情")
    public AttendanceVo selectByUserIdAndCurrentDate(String userId) {
        //查询改用户当天签到列表
        AttendancePage attendance=new AttendancePage();
        attendance.setAttendanceUser(userId);
        attendance.setAttendanceTime(new Date());
        List<AttendanceVo> tbOaAttendanceList= attendanceMapper.selectAttendanceByCondition(attendance);
        if(tbOaAttendanceList!=null && tbOaAttendanceList.size()>0){
            return tbOaAttendanceList.get(0);
        }
        return null;
    }

    /**
     * 根据条件查询考勤列表
     *
     * @param attendancePage
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据条件查询考勤列表")
    public PaginationData selectAttendanceListByCondition(AttendancePage  attendancePage) {

        Page<Object> objects = PageHelper.startPage(attendancePage.getPage(), attendancePage.getRows());
        return new PaginationData(attendanceMapper.selectAttendanceByCondition(attendancePage)
                , objects.getTotal());

    }

    /**
     * OA-API根据条件查询考勤列表
     *
     * @param attendance
     * @return
     */
    @Override
    public List<AttendanceApiVo> selectApiAttendanceListByCondition(Attendance attendance) {
        logger.info("[考勤管理] 条件查询考勤列表，,userId：{},departmentId：{},startTime：{},endTime：{}", attendance.getUserId(),attendance.getDepartmentId(),attendance.getStartTime(),attendance.getEndTime());
        return attendanceMapper.selectAttendanceListByCondition(attendance);
    }
}
