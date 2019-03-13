package com.jn.oa.meeting.dao;

import java.util.Map;

/**
 * 会议参会人员dao
 * @author： yuanyy
 * @date： Created on 2019/02/14 17:03
 * @version： v1.0
 * @modified By:
 */
public interface OaMeetingParticipantMapper {


    void deleteBranchByIds(Map<String, Object> map);

    void deleteBranchByMeetingIds(Map<String, Object> maps);



}