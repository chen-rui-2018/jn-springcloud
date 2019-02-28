package com.jn.oa.meeting.dao;


import com.jn.oa.meeting.model.OaMeetingRoomOrderPage;
import com.jn.oa.meeting.model.OaMeetingRoomPage;
import com.jn.oa.meeting.vo.OaMeetingRoomOrderVo;
import com.jn.oa.meeting.vo.OaMeetingRoomVo;

import java.util.List;
import java.util.Map;

/**
 * 会议室dao
 * @author： yuanyy
 * @date： Created on 2019/02/14 17:03
 * @version： v1.0
 * @modified By:
 */
public interface OaMeetingRoomMapper {


    void deleteBranchByIds(Map<String,Object> map);

    List<OaMeetingRoomVo> selectListByCondition(OaMeetingRoomPage oaMeetingRoomPage);

    OaMeetingRoomVo selectMeetingRoomById(String id);

    List<OaMeetingRoomOrderVo> selectMeetingRoomAndMeetingOrder(OaMeetingRoomOrderPage oaMeetingRoomOrderPage );

    List<OaMeetingRoomOrderVo> selectAvailableMeetingRoomList(OaMeetingRoomPage oaMeetingRoomPage );


}