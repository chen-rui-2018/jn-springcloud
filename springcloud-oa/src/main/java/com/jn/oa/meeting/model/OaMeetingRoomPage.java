package com.jn.oa.meeting.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

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

    @ApiModelProperty(value = "楼宇")
    private String building;

    @ApiModelProperty(value = "楼层")
    private String floor;

    @ApiModelProperty(value = "房间号")
    private String roomNumber;

    @ApiModelProperty(value = "会议开始时间")
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    private Date startTime;

    @ApiModelProperty(value = "会议结束时间")
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    private Date endTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

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

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}


