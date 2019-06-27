package com.jn.oa.dingTalk.service.impl;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.hardware.api.DingTalkClient;
import com.jn.hardware.model.dingtalk.attendance.*;
import com.jn.oa.attendance.dao.TbOaAttendanceMapper;
import com.jn.oa.attendance.entity.TbOaAttendance;
import com.jn.oa.common.enums.OaDingTalkEnums;
import com.jn.oa.dingTalk.dao.DingTalkUserMapper;
import com.jn.oa.dingTalk.dao.TbOaDingTalkUserMapper;
import com.jn.oa.dingTalk.entity.TbOaDingTalkUser;
import com.jn.oa.dingTalk.service.DingTalkAttendanceService;
import com.jn.oa.dingTalk.service.DingTalkLeaveService;
import com.jn.oa.leave.dao.TbOaLeaveMapper;
import com.jn.oa.leave.entity.TbOaLeave;
import com.jn.oa.leave.entity.TbOaLeaveCriteria;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.system.vo.SysDepartmentPostVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * 钉钉用户请假service
 *
 * @author： yuanyy
 * @date： Created on 2019/4/17 10:49
 * @version： v1.0
 * @modified By:
 */
@Service
public class DingTalkLeaveServiceImpl implements DingTalkLeaveService  {

    private static Logger logger = LoggerFactory.getLogger(DingTalkLeaveServiceImpl.class);

   @Autowired
   private TbOaDingTalkUserMapper tbOaDingTalkUserMapper;

   @Autowired
   private DingTalkUserMapper dingTalkUserMapper;

    @Autowired
    private DingTalkClient dingTalkClient;

    @Autowired
    private TbOaLeaveMapper tbOaLeaveMapper;


    @Autowired
    private SystemClient systemClient;


    /**
     * 批量更新钉钉请假
     *
     * @return
     */
    @Override
    @ServiceLog(doAction ="批量更新钉钉请假" )
    @Transactional(rollbackFor = Exception.class)
    public void batchInsertDingTalkLeave(Date workDateFrom,Date workDateTo) {

        int page=Integer.valueOf(OaDingTalkEnums.PAGE.getCode());
        int rows=Integer.valueOf(OaDingTalkEnums.ROWS.getCode());
        Page<Object> objects = PageHelper.startPage(page, rows);
        PaginationData<List<String>> paginationData=new PaginationData(dingTalkUserMapper.selectAllDingTalkUserId(null) , objects.getTotal());
        logger.info("[钉钉用户考勤]分页查询所有用户userId,返回值，paginationData：{}", JSON.toJSON(paginationData));
        if(paginationData!=null&&paginationData.getRows()!=null&&paginationData.getRows().size()>0) {
            recursionPagingSearchDingTalkUserId(objects, paginationData, workDateFrom, workDateTo);
        }

    }

    /**
     * 递归分页查询用户id
     * @param objects
     * @param paginationData
     * @param workDateFrom
     * @param workDateTo
     */
    private void recursionPagingSearchDingTalkUserId(Page<Object> objects, PaginationData<List<String>> paginationData,Date workDateFrom,Date workDateTo){

        //在分页查询时返回，先新增当前页的数据
        LeaveStatusListParam leaveStatusListParam=new LeaveStatusListParam();
        List<String> userIds=paginationData.getRows();
        leaveStatusListParam.setUseridList(StringUtils.join(userIds,","));
        leaveStatusListParam.setStartTime(workDateFrom.getTime());
        leaveStatusListParam.setEndTime(workDateTo.getTime());
        leaveStatusListParam.setOffset(Long.valueOf(OaDingTalkEnums.OFFSET.getCode()));
        leaveStatusListParam.setSize(Long.valueOf(OaDingTalkEnums.SIZE.getCode()));
        logger.info("[钉钉用户考勤]批量更新钉钉请假,入参leaveStatusListParam：{}", JSON.toJSON(leaveStatusListParam));
        Result<LeaveStatusListResult> leaveStatusListResult= dingTalkClient.getLeaveStatusList(leaveStatusListParam);
        logger.info("[钉钉用户考勤]批量更新钉钉请假,返回值leaveStatusListResult：{}", JSON.toJSON(leaveStatusListResult));
        if(leaveStatusListResult!=null&&leaveStatusListResult.getData()!=null&&leaveStatusListResult.getData().getResult()!=null&&leaveStatusListResult.getData().getResult().getLeaveStatus()!=null&&leaveStatusListResult.getData().getResult().getLeaveStatus().size()>0) {
            recursionPagingSearchAttendance(leaveStatusListParam, leaveStatusListResult);
        }
        //判断是否有下一页数据
        if(objects.getPageNum()<(paginationData.getTotal()/objects.getPageSize()+1)){
            //递归查询下一页信息
            objects = PageHelper.startPage(objects.getPageNum()+1, objects.getPageSize());
            PaginationData<List<String>> data=new PaginationData(dingTalkUserMapper.selectAllDingTalkUserId(null) , objects.getTotal());
            recursionPagingSearchDingTalkUserId(objects,data, workDateFrom, workDateTo);
        }



    }


    /**
     * 递归分页查询
     * @param leaveStatusListParam
     * @param leaveStatusListResult
     */
    private void recursionPagingSearchAttendance(LeaveStatusListParam leaveStatusListParam, Result<LeaveStatusListResult> leaveStatusListResult){

        //在分页查询时返回，先新增当前页的数据
        List<LeaveStatusInfo> leaveStatusInfos=leaveStatusListResult.getData().getResult().getLeaveStatus();
        for (LeaveStatusInfo leaveStatusInfo:leaveStatusInfos){

            TbOaLeave tbOaLeave=new TbOaLeave();


            //计算请假小时，默认返回的请假时长是乘以100
            long total=0;
            if(OaDingTalkEnums.PERCENT_HOUR.getCode().equals(leaveStatusInfo.getDurationUnit())){
                total=Long.valueOf(leaveStatusInfo.getDurationPercent())/100/24;
            }else{
                total=Long.valueOf(leaveStatusInfo.getDurationPercent())/100;
            }
            tbOaLeave.setTotalHour(String.valueOf(total));

            //将时间戳转换成date
            ZonedDateTime startTimeZdt=LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.valueOf(leaveStatusInfo.getStartTime())), ZoneId.systemDefault()).atZone(ZoneId.systemDefault());
            tbOaLeave.setStartTime(Date.from(startTimeZdt.toInstant()));
            ZonedDateTime endTimeZdt=LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.valueOf(leaveStatusInfo.getEndTime())), ZoneId.systemDefault()).atZone(ZoneId.systemDefault());
            tbOaLeave.setEndTime(Date.from(endTimeZdt.toInstant()));


            TbOaDingTalkUser tbOaDingTalkUser=tbOaDingTalkUserMapper.selectByPrimaryKey(leaveStatusInfo.getUserid());
            tbOaLeave.setApplicant(tbOaDingTalkUser.getUserId());
            tbOaLeave.setApplicantName(tbOaDingTalkUser.getName());

            TbOaLeaveCriteria example=new TbOaLeaveCriteria();
            TbOaLeaveCriteria.Criteria criteria=example.createCriteria();
            criteria.andApplicantEqualTo(tbOaDingTalkUser.getUserId()).andStartTimeEqualTo(tbOaLeave.getStartTime()).andEndTimeEqualTo(tbOaLeave.getEndTime());

            List<TbOaLeave> tbOaLeaveList=tbOaLeaveMapper.selectByExample(example);
            if(tbOaLeaveList!=null&&tbOaLeaveList.size()>0){
                logger.info("[钉钉用户考勤]批量更新钉钉请假,该请假数据已存在，leaveStatusInfo：{}", JSON.toJSON(leaveStatusInfo));
                continue;
            }


            tbOaLeave.setId(UUID.randomUUID().toString());


            //根据用户的手机号查询该用户默认部门信息
            User user=new User();
            user.setPhone(tbOaDingTalkUser.getMobile());
            Result<User> userResult=systemClient.getUser(user);
            if(userResult==null&&userResult.getData()!=null){
                List<SysDepartmentPostVO> sysDepartmentPosts=userResult.getData().getSysDepartmentPostVO();
                for(SysDepartmentPostVO sysDepartmentPostVO:sysDepartmentPosts){
                    //默认部门
                    if(OaDingTalkEnums.DEFAULT.getCode().equals(sysDepartmentPostVO.getIsDefault()) ){
                        tbOaLeave.setOrganization(sysDepartmentPostVO.getDepartmentId());
                        tbOaLeave.setOrganizationName(sysDepartmentPostVO.getDepartmentName());
                    }
                }
            }
            //新增钉钉考勤数据
            tbOaLeaveMapper.insert(tbOaLeave);
        }
        //判断是否有下一页数据
        if(leaveStatusListResult.getData().getResult().getHasMore()){
            leaveStatusListParam.setOffset(leaveStatusListParam.getOffset()+leaveStatusListParam.getSize());
            Result<LeaveStatusListResult> resultList= dingTalkClient.getLeaveStatusList(leaveStatusListParam);
            //递归分页查询钉钉考勤数据
            recursionPagingSearchAttendance(leaveStatusListParam,resultList);
        }

    }
}
