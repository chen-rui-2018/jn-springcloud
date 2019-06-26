package com.jn.oa.dingTalk.service.impl;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.hardware.api.DingTalkClient;
import com.jn.hardware.model.dingtalk.attendance.ClockInInfo;
import com.jn.hardware.model.dingtalk.attendance.ClockInListParam;
import com.jn.hardware.model.dingtalk.attendance.ClockInListResult;
import com.jn.oa.attendance.dao.TbOaAttendanceMapper;
import com.jn.oa.attendance.entity.TbOaAttendance;
import com.jn.oa.common.enums.OaDingTalkEnums;
import com.jn.oa.dingTalk.dao.DingTalkUserMapper;
import com.jn.oa.dingTalk.dao.TbOaDingTalkUserMapper;
import com.jn.oa.dingTalk.entity.TbOaDingTalkUser;
import com.jn.oa.dingTalk.service.DingTalkAttendanceService;
import com.jn.system.api.SystemClient;
import com.jn.system.model.User;
import com.jn.system.vo.SysDepartmentPostVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;


/**
 * 钉钉用户考勤service
 *
 * @author： yuanyy
 * @date： Created on 2019/4/17 10:49
 * @version： v1.0
 * @modified By:
 */
@Service
public class DingTalkAttendanceServiceImpl implements DingTalkAttendanceService {

    private static Logger logger = LoggerFactory.getLogger(DingTalkAttendanceServiceImpl.class);

   @Autowired
   private TbOaDingTalkUserMapper tbOaDingTalkUserMapper;

   @Autowired
   private DingTalkUserMapper dingTalkUserMapper;

    @Autowired
    private DingTalkClient dingTalkClient;

    @Autowired
    private TbOaAttendanceMapper tbOaAttendanceMapper;


    @Autowired
    private SystemClient systemClient;


    /**
     * 批量更新钉钉考勤
     *
     * @return
     */
    @Override
    public void batchInsertDingTalkAttendance(String workDateFrom,String workDateTo) {

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
    private void recursionPagingSearchDingTalkUserId(Page<Object> objects, PaginationData<List<String>> paginationData,String workDateFrom,String workDateTo){

        //在分页查询时返回，先新增当前页的数据
        ClockInListParam clockInListParam=new ClockInListParam();
        List<String> userIds=paginationData.getRows();
        clockInListParam.setUserIdList(userIds);
        clockInListParam.setWorkDateFrom(workDateFrom);
        clockInListParam.setWorkDateTo(workDateTo);
        clockInListParam.setOffset(Long.valueOf(OaDingTalkEnums.OFFSET.getCode()));
        clockInListParam.setLimit(Long.valueOf(OaDingTalkEnums.SIZE.getCode()));
        logger.info("[钉钉用户考勤]批量更新钉钉考勤,入参clockInListParam：{}", JSON.toJSON(clockInListParam));
        Result<ClockInListResult> clockInListResult= dingTalkClient.getClockInResultList(clockInListParam);
        logger.info("[钉钉用户考勤]批量更新钉钉考勤,返回值：clockInListResult：{}", JSON.toJSON(clockInListResult));
        if(clockInListResult!=null&&clockInListResult.getData()!=null&&clockInListResult.getData().getRecordresult()!=null&&clockInListResult.getData().getRecordresult().size()>0) {
            recursionPagingSearchAttendance(clockInListParam, clockInListResult);
        }
        //判断是否有下一页数据
        if(objects.getPageNum()<(paginationData.getTotal()/objects.getPageSize()+1)){
            //递归查询下一页信息
            objects = PageHelper.startPage(objects.getPageNum()+1, objects.getPageSize());
            logger.info("[钉钉用户考勤]批量更新钉钉考勤,递归查询下一页查询用户id信息：objects：{}", JSON.toJSON(objects));
            PaginationData<List<String>> data=new PaginationData(dingTalkUserMapper.selectAllDingTalkUserId(null) , objects.getTotal());
            recursionPagingSearchDingTalkUserId(objects,data, workDateFrom, workDateTo);
        }



    }


    /**
     * 递归分页查询考勤数据
     * @param clockInListParam
     * @param clockInListResult
     */
    private void recursionPagingSearchAttendance(ClockInListParam clockInListParam, Result<ClockInListResult> clockInListResult){

        //在分页查询时返回，先新增当前页的数据
        List<ClockInInfo> clockInInfos=clockInListResult.getData().getRecordresult();
        for (ClockInInfo clockInInfo:clockInInfos){
            TbOaAttendance tbOaAttendance=tbOaAttendanceMapper.selectByPrimaryKey(clockInInfo.getId());
            if(tbOaAttendance!=null){
                logger.info("[钉钉用户考勤]批量更新钉钉考勤,该考勤已存在，clockInInfo：{}", JSON.toJSON(clockInInfo));
                continue;
            }
            TbOaAttendance attendance=new TbOaAttendance();
            BeanUtils.copyProperties(clockInInfo,attendance);


            //将时间戳转换成date
            ZonedDateTime baseCheckTimeZdt=LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.valueOf(clockInInfo.getBaseCheckTime())), ZoneId.systemDefault()).atZone(ZoneId.systemDefault());
            attendance.setBaseCheckTime(Date.from(baseCheckTimeZdt.toInstant()));

            ZonedDateTime checkTimeZdt=LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.valueOf(clockInInfo.getUserCheckTime())), ZoneId.systemDefault()).atZone(ZoneId.systemDefault());
            attendance.setUserCheckTime(Date.from(checkTimeZdt.toInstant()));

            ZonedDateTime workDateZdt=LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.valueOf(clockInInfo.getWorkDate())), ZoneId.systemDefault()).atZone(ZoneId.systemDefault());
            attendance.setWorkDate(Date.from(workDateZdt.toInstant()));

            TbOaDingTalkUser tbOaDingTalkUser=tbOaDingTalkUserMapper.selectByPrimaryKey(clockInInfo.getUserId());
            attendance.setUserName(tbOaDingTalkUser.getName());

            //根据用户的手机号查询该用户默认部门信息
            User user=new User();
            user.setPhone(tbOaDingTalkUser.getMobile());
            Result<User> userResult=systemClient.getUser(user);
            if(userResult==null&&userResult.getData()!=null){
                List<SysDepartmentPostVO> sysDepartmentPosts=userResult.getData().getSysDepartmentPostVO();
                for(SysDepartmentPostVO sysDepartmentPostVO:sysDepartmentPosts){
                    //默认部门
                    if(OaDingTalkEnums.DEFAULT.getCode().equals(sysDepartmentPostVO.getIsDefault()) ){
                        attendance.setDepartmentId(sysDepartmentPostVO.getDepartmentId());
                        attendance.setDepartmentName(sysDepartmentPostVO.getDepartmentName());
                    }
                }
            }
            //新增钉钉考勤数据
            tbOaAttendanceMapper.insert(attendance);
        }
        //判断是否有下一页数据
        if(clockInListResult.getData().getHasMore()){
            clockInListParam.setOffset(clockInListParam.getOffset()+clockInListParam.getLimit());
            logger.info("[钉钉用户考勤]批量更新钉钉考勤,递归查询下一页考勤数据信息：objects：{}", JSON.toJSON(clockInListParam));
            Result<ClockInListResult> resultList= dingTalkClient.getClockInResultList(clockInListParam);
            //递归分页查询钉钉考勤数据
            recursionPagingSearchAttendance(clockInListParam,resultList);
        }

    }
}
