package com.jn.oa.meeting.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 会议室分页实体
 *
 * @author： yuanyy
 * @date： Created on 2019/1/13 10:18
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OaMeetingRoomPage", description = "会议室分页实体")
public class OaMeetingRoomPage extends Page implements Serializable {
    private static final long serialVersionUID = 7252981735944287743L;

    @ApiModelProperty(value = "会议室id")
    private String id;

    @ApiModelProperty(value = "会议室名称")
    private String name;

    @ApiModelProperty(value = "会议室状态(1:可用、2:不可用、0:删除)")
    private String recordStatus;

    @ApiModelProperty(value = "会议id")
    private String meetingId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }
}


