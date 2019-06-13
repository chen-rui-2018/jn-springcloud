package com.jn.oa.meeting.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.oa.common.enums.OaStatusEnums;
import com.jn.oa.meeting.dao.MeetingParticipantMapper;
import com.jn.oa.meeting.dao.TbOaMeetingParticipantsMapper;
import com.jn.oa.meeting.dao.TbOaMeetingRoomMapper;
import com.jn.oa.meeting.entity.TbOaMeetingParticipants;
import com.jn.oa.meeting.entity.TbOaMeetingParticipantsCriteria;
import com.jn.oa.meeting.entity.TbOaMeetingRoom;
import com.jn.oa.meeting.enums.MeetingAttendanceTypeEnums;
import com.jn.oa.meeting.enums.MeetingExceptionEnums;
import com.jn.oa.meeting.model.OaMeetingAttendancePage;
import com.jn.oa.meeting.model.OaMeetingParticipantsAttendance;
import com.jn.oa.meeting.service.MeetingAttendanceService;
import com.jn.oa.meeting.vo.OaMeetingAttendanceVo;

import com.jn.oa.meeting.vo.OaMeetingParticipantsAttendanceVo;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * 会议考勤service
 * @author： yuanyy
 * @date： Created on 2019/1/29 17:01
 * @version： v1.0
 * @modified By:
 */
@Service
public class MeetingAttendanceServiceImpl implements MeetingAttendanceService {
    private static Logger logger = LoggerFactory.getLogger(MeetingAttendanceServiceImpl.class);

    @Autowired
    private TbOaMeetingParticipantsMapper tbOaMeetingParticipantsMapper;

    @Autowired
    private MeetingParticipantMapper meetingParticipantMapper;

    @Autowired
    private TbOaMeetingRoomMapper tbOaMeetingRoomMapper;

    /**
     * 会议考勤签到、签退接口
     *
     * @param oaMeetingParticipantsAttendance
     * @param user
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @ServiceLog(doAction = "会议考勤签到、签退接口")
    public void meetingAttendanceSignIn(OaMeetingParticipantsAttendance oaMeetingParticipantsAttendance, User user) {

        TbOaMeetingParticipantsCriteria participantsCriteria=new TbOaMeetingParticipantsCriteria();
        TbOaMeetingParticipantsCriteria.Criteria criteria=participantsCriteria.createCriteria();
        criteria.andMeetingIdEqualTo(oaMeetingParticipantsAttendance.getMeetingId());
        criteria.andMeetingUserIdEqualTo(user.getId());
        List<TbOaMeetingParticipants> tbOaMeetingParticipantsList= tbOaMeetingParticipantsMapper.selectByExample(participantsCriteria);

        TbOaMeetingParticipants tbOaMeetingParticipants=new TbOaMeetingParticipants();

        //设置有效状态
        tbOaMeetingParticipants.setRecordStatus(OaStatusEnums.EFFECTIVE.getCode());
        tbOaMeetingParticipants.setMeetingUserId(user.getId());
        tbOaMeetingParticipants.setMeetingId(oaMeetingParticipantsAttendance.getMeetingId());

        //签到
        if(MeetingAttendanceTypeEnums.MEETING_SIGN_IN.getCode().equals(oaMeetingParticipantsAttendance.getMeetingAttendanceType())){

            if(tbOaMeetingParticipantsList!=null&&tbOaMeetingParticipantsList.size()!=0){
                logger.warn("[会议考勤] 会议考勤签到失败，用户不能进行多次签到！,meetingId: {},userId：{}", oaMeetingParticipantsAttendance.getMeetingId(),user.getId());
                throw  new JnSpringCloudException(MeetingExceptionEnums.MEETING_ATTENDANCE_SIGN_IN);
            }
            tbOaMeetingParticipants.setId(UUID.randomUUID().toString());
            tbOaMeetingParticipants.setCreatorAccount(user.getAccount());
            tbOaMeetingParticipants.setCreatedTime(new Date());
            //签到时间
            tbOaMeetingParticipants.setSignInTime(new Date());
            tbOaMeetingParticipantsMapper.insert(tbOaMeetingParticipants);
            return;
        }
        //签退
        else if(MeetingAttendanceTypeEnums.MEETING_SIGN_OUT.getCode().equals(oaMeetingParticipantsAttendance.getMeetingAttendanceType())){
            //无签到数据
            if(tbOaMeetingParticipantsList==null||tbOaMeetingParticipantsList.size()==0){
                logger.warn("[会议考勤] 会议考勤签退失败，用户未进行签到，不能进行签退！,meetingId: {},userId：{}", oaMeetingParticipantsAttendance.getMeetingId(),user.getId());
                throw  new JnSpringCloudException(MeetingExceptionEnums.MEETING_ATTENDANCE_SIGN_OUT);
            }
            tbOaMeetingParticipants.setModifiedTime(new Date());
            tbOaMeetingParticipants.setModifierAccount(user.getAccount());
            //签退时间
            tbOaMeetingParticipants.setSignBackTime(new Date());

            tbOaMeetingParticipantsMapper.updateByExampleSelective(tbOaMeetingParticipants,participantsCriteria);

            return;
        }

        logger.warn("[会议考勤] 会议考勤签到/签退异常，该考勤类型不存在！,meetingId: {},userId：{}，type：{}", oaMeetingParticipantsAttendance.getMeetingId(),user.getId(),oaMeetingParticipantsAttendance.getMeetingAttendanceType());
        throw  new JnSpringCloudException(MeetingExceptionEnums.MEETING_ATTENDANCE_ERROR);
    }

    /**
     * 会议考勤根据id查询考勤会议详情
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "会议考勤根据id查询考勤会议详情")
    public OaMeetingAttendanceVo selectMeetingAttendanceById(String id) {
        OaMeetingAttendanceVo oaMeetingAttendanceVo= meetingParticipantMapper.selectList(id);
        logger.info("[会议考勤] 会议考勤根据id查询考勤会议详情！,oaMeetingAttendanceVo: {}", id);
        return oaMeetingAttendanceVo;
    }

    /**
     * 列表查询考勤
     *
     * @param oaMeetingAttendancePage
     * @return
     */
    @Override
    @ServiceLog(doAction = "会议考勤列表查询")
    public PaginationData<List<OaMeetingParticipantsAttendanceVo>> selectMeetingAttendanceList(OaMeetingAttendancePage oaMeetingAttendancePage) {
        Page<Object> objects = PageHelper.startPage(oaMeetingAttendancePage.getPage(), oaMeetingAttendancePage.getRows());
        List<OaMeetingParticipantsAttendanceVo> oaMeetingParticipantsAttendanceVoList= meetingParticipantMapper.selectMeetingAttendanceListByCondition(oaMeetingAttendancePage);
        for(int i=0;i<oaMeetingParticipantsAttendanceVoList.size();i++){
            TbOaMeetingRoom tbOaMeetingRoom=tbOaMeetingRoomMapper.selectByPrimaryKey(oaMeetingParticipantsAttendanceVoList.get(i).getMeetingRoomId());
            oaMeetingParticipantsAttendanceVoList.get(i).setMeetingRoomName(tbOaMeetingRoom.getName());
        }
        return new PaginationData(oaMeetingParticipantsAttendanceVoList
                , objects.getTotal());

    }
}


