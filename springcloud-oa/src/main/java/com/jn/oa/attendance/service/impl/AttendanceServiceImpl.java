package com.jn.oa.attendance.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.hr.api.HrClient;
import com.jn.hr.model.*;
import com.jn.oa.attendance.dao.AttendanceMapper;
import com.jn.oa.attendance.dao.TbOaAttendanceMapper;
import com.jn.oa.attendance.enmus.AttendanceExceptionEnums;
import com.jn.oa.attendance.enmus.AttendanceLocationEnums;
import com.jn.oa.attendance.enmus.AttendancePlatformEnums;
import com.jn.oa.attendance.enmus.AttendanceTypeEnums;
import com.jn.oa.attendance.entity.TbOaAttendance;
import com.jn.oa.attendance.entity.TbOaAttendanceCriteria;
import com.jn.oa.attendance.model.AttendanceAdd;
import com.jn.oa.attendance.model.AttendanceLocation;
import com.jn.oa.attendance.model.AttendancePage;
import com.jn.oa.attendance.service.AttendanceService;
import com.jn.oa.attendance.vo.AttendanceResultVo;
import com.jn.oa.attendance.vo.AttendanceVo;
import com.jn.oa.common.util.LocationUtils;
import com.jn.oa.model.Attendance;
import com.jn.oa.vo.AttendanceApiVo;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysDictInvoke;
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

    @Autowired
    private HrClient hrClient;

    @Autowired
    private SystemClient systemClient;


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

        AttendanceOverTime attendanceOverTime=new AttendanceOverTime();
        attendanceOverTime.setUserId(user.getId());
        attendanceOverTime.setType(attendanceAdd.getType());
        if(AttendancePlatformEnums.PLATFORM_APP.getCode().equals(attendanceAdd.getAttendancePlatform())){
            //app打卡
            AttendanceLocation attendanceLocation= this.selectLocation(attendanceAdd.getLongitude(),attendanceAdd.getLatitude());
            if(!attendanceLocation.isStatus()){
                logger.warn("[考勤管理] 考勤失败，考勤范围不在指定范围内！,userId：{}", user.getId());
                throw  new JnSpringCloudException(AttendanceExceptionEnums.ATTENDANCE_LOCATION_ERROR);
            }

        }
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

            attendanceOverTime.setAttendanceDate(tbOaAttendance.getSignInAttendanceTime());


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

            attendanceOverTime.setAttendanceDate(tbOaAttendance.getSignOutAttendanceTime());

            TbOaAttendanceCriteria attendanceCriteria=new TbOaAttendanceCriteria();
            TbOaAttendanceCriteria.Criteria criteria=attendanceCriteria.createCriteria();
            criteria.andIdEqualTo(attendanceVo.getId());
            tbOaAttendanceMapper.updateByExampleSelective(tbOaAttendance,attendanceCriteria);
        }
        logger.info("进入-根据用户id查询用户考勤接口,参数：{}", JSONObject.toJSONString(attendanceOverTime));
        Result<AttendanceOverTimeApiVo> result= hrClient.selectByUserIdAndTime(attendanceOverTime);
        logger.info("执行结束-根据用户id查询用户考勤接口,返回参数：{}", JSONObject.toJSONString(result));
        //查询迟到早退失败
        if(result==null||!result.getCode().equals(GlobalConstants.SUCCESS_CODE)||result.getData()==null){
            logger.warn("[考勤管理] 查询人力资源接口，查询用户迟到早退状态失败！,userId：{}",user.getId());
            throw  new JnSpringCloudException(AttendanceExceptionEnums.SELECT_ATTENDANCE_STATUS_ERROR);
        }
        attendanceResultVo.setMinute(result.getData().getMinute());
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
            AttendanceVo attendanceVo=tbOaAttendanceList.get(0);
            if(attendanceVo.getSignInAttendanceTime()!=null){
                AttendanceOverTime attendanceOverTime=new AttendanceOverTime();
                attendanceOverTime.setType(AttendanceTypeEnums.SIGN_IN.getCode());
                attendanceOverTime.setAttendanceDate(attendanceVo.getSignInAttendanceTime());
                attendanceOverTime.setUserId(attendanceVo.getAttendanceUser());
                Result<AttendanceOverTimeApiVo> result=this.selectByUserIdAndTime(attendanceOverTime);
                //查询迟到早退失败
                if(result==null||!result.getCode().equals(GlobalConstants.SUCCESS_CODE)||result.getData()==null){
                    logger.warn("[考勤管理] 查询人力资源接口，查询用户迟到早退状态失败！,userId：{}",attendanceVo.getAttendanceUser());
                    throw  new JnSpringCloudException(AttendanceExceptionEnums.SELECT_ATTENDANCE_STATUS_ERROR);
                }
                attendanceVo.setSignInAttendanceMinute(result.getData().getMinute());
            }
            if(attendanceVo.getSignOutAttendanceTime()!=null){
                AttendanceOverTime attendanceOverTime=new AttendanceOverTime();
                attendanceOverTime.setType(AttendanceTypeEnums.SIGN_OUT.getCode());
                attendanceOverTime.setAttendanceDate(attendanceVo.getSignOutAttendanceTime());
                attendanceOverTime.setUserId(attendanceVo.getAttendanceUser());
                Result<AttendanceOverTimeApiVo> result=this.selectByUserIdAndTime(attendanceOverTime);
                //查询迟到早退失败
                if(result==null||!result.getCode().equals(GlobalConstants.SUCCESS_CODE)||result.getData()==null){
                    logger.warn("[考勤管理] 查询人力资源查询考勤接口，查询用户迟到早退状态失败！,userId：{}",attendanceVo.getAttendanceUser());
                    throw  new JnSpringCloudException(AttendanceExceptionEnums.SELECT_ATTENDANCE_STATUS_ERROR);
                }
                attendanceVo.setSignOutAttendanceMinute(result.getData().getMinute());
            }

            return attendanceVo;
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
    @ServiceLog(doAction = "OA-API根据条件查询考勤列表")
    public List<AttendanceApiVo> selectApiAttendanceListByCondition(Attendance attendance) {
        logger.info("[考勤管理] 条件查询考勤列表，,userId：{},departmentId：{},startTime：{},endTime：{}", attendance.getUserId(),attendance.getDepartmentId(),attendance.getStartTime(),attendance.getEndTime());
        return attendanceMapper.selectAttendanceListByCondition(attendance);
    }

    /**
     * 根据用户id查询用户考勤打卡数据
     *
     * @param attendanceManagement
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据用户id查询用户考勤打卡数据")
    public Result<List<AttendanceManagementApiVo>> selectAttendanceManagementByUserId(AttendanceManagement attendanceManagement) {
        logger.info("进入-根据用户id查询用户考勤打卡数据,参数：{}", JSONObject.toJSONString(attendanceManagement));
        Result result= hrClient.selectAttendanceManagementByUserId(attendanceManagement);
        logger.info("执行结束-根据用户id查询用户考勤打卡数据,返回参数：{}", JSONObject.toJSONString(result));
        return result;
    }

    /**
     * 根据部门id查询部门考勤打卡数据
     *
     * @param attendanceManagement
     * @return
     */
    @Override
    @ServiceLog(doAction = " 根据部门id查询部门考勤打卡数据")
    public Result<AttendanceManageApiVo> selectAttendanceManagementByDepartmentId(AttendanceManagement attendanceManagement) {
        logger.info("进入-根据部门id查询部门考勤打卡数据,参数：{}", JSONObject.toJSONString(attendanceManagement));
        Result<AttendanceManageApiVo> result= hrClient.selectAttendanceManagementByDepartmentId(attendanceManagement);
        logger.info("执行结束-根据部门id查询部门考勤打卡数据,返回参数：{}", JSONObject.toJSONString(result.getCode()));
        return result;
    }

    /**
     * 根据用户id查询用户考勤接口
     *
     * @param attendanceOverTime
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据用户id查询用户考勤接口")
    public Result<AttendanceOverTimeApiVo> selectByUserIdAndTime(AttendanceOverTime attendanceOverTime) {
        logger.info("进入-根据用户id查询用户考勤接口,参数：{}", JSONObject.toJSONString(attendanceOverTime));
        Result<AttendanceOverTimeApiVo> result= hrClient.selectByUserIdAndTime(attendanceOverTime);
        logger.info("执行结束-根据用户id查询用户考勤接口,返回参数：{}", JSONObject.toJSONString(result));
        return result;
    }

    /**
     * 根据经纬度查询距离与是否能进行打卡
     *
     * @param longitude
     * @param latitude
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据经纬度查询距离与是否能进行打卡")
    public AttendanceLocation selectLocation(String longitude, String latitude) {
        SysDictInvoke sysDictInvoke=new SysDictInvoke();
        sysDictInvoke.setModuleCode(AttendanceLocationEnums.LONGITUDE_MODULE_CODE.getCode());
        sysDictInvoke.setParentGroupCode(AttendanceLocationEnums.LONGITUDE_PARENT_GROUP_CODE.getCode());
        sysDictInvoke.setGroupCode(AttendanceLocationEnums.LONGITUDE_GROUP_CODE.getCode());

        //数据字典的经度
        sysDictInvoke.setKey(AttendanceLocationEnums.LONGITUDE_KEY.getCode());
        String longitudeDict=getDictValue(sysDictInvoke);

        //数据字典的纬度
        sysDictInvoke.setKey(AttendanceLocationEnums.LATITUDE_KEY.getCode());
        String latitudeDict=getDictValue(sysDictInvoke);

        //数据字典的距离
        sysDictInvoke.setKey(AttendanceLocationEnums.DISTANCE_KEY.getCode());
        double distance=Double.valueOf(getDictValue(sysDictInvoke));

        double pointsDistance=LocationUtils.getDistance(longitude,latitude,longitudeDict,latitudeDict);

        AttendanceLocation attendanceLocation=new AttendanceLocation();
        attendanceLocation.setDistance(String.valueOf(pointsDistance));
        logger.info("[考勤管理]两经纬度之间的距离：实际距离{}，指定距离：{}",pointsDistance,pointsDistance );
        //两经纬度的距离
        if(distance<pointsDistance){
            attendanceLocation.setStatus(false);
        }else{
            attendanceLocation.setStatus(true);
        }

        return attendanceLocation;
    }

    private String getDictValue(SysDictInvoke sysDictInvoke){
        Result<String> data=systemClient.selectDictValueByCondition(sysDictInvoke);
        if(data==null||data.getData()==null||!GlobalConstants.SUCCESS_CODE.equals(data.getCode())){
            logger.warn("[考勤管理] 根据数据字典查询考勤定位经纬度失败失败！,参数：{}，返回值：{}",JSONObject.toJSONString(sysDictInvoke),JSONObject.toJSONString(data));
            throw  new JnSpringCloudException(AttendanceExceptionEnums.ATTENDANCE_LOCATION_DIST_ERROR);
        }
        return data.getData();
    }
}
