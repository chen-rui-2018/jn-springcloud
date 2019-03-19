package com.jn.oa.meeting.dao;

import java.util.Map;

/**
 * 会议室附件dao
 * @author： yuanyy
 * @date： Created on 2019/02/14 17:03
 * @version： v1.0
 * @modified By:
 */
public interface OaMeetingRoomPhotoMapper {


    void deleteBranchByIds(Map<String, Object> map);

    void deleteBranchByMeetingRoomId(Map<String, Object> maps);

}