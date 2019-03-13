package com.jn.oa.meeting.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 会议室实体
 *
 * @author： yuanyy
 * @date： Created on 2019/1/13 10:18
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OaMeetingRoom", description = "会议室分页实体")
public class OaMeetingRoom implements Serializable {
    private static final long serialVersionUID = 7252981735944287744L;

    @ApiModelProperty(value = "会议室id")
    private String id;

    @ApiModelProperty(value = "会议室名称")
    private String name;

    @ApiModelProperty(value = "楼宇")
    private String building;

    @ApiModelProperty(value = "楼层")
    private String floor;

    @ApiModelProperty(value = "房间号")
    private String roomNumber;

    @ApiModelProperty(value = "会议室位置(楼宇+楼层+房间号)")
    private String position;

    @ApiModelProperty(value = "会议室说明")
    private String explains;

    @ApiModelProperty(value = "会议室状态(0:可用、1:不可用、-1:删除)")
    private Byte recordStatus;

    @ApiModelProperty(value = "会议室容量")
    private String capacity;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建者")
    private String creatorAccount;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "修改者")
    private String modifierAccount;

    @ApiModelProperty(value = "修改时间")
    private Date modifiedTime;



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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getExplains() {
        return explains;
    }

    public void setExplains(String explains) {
        this.explains = explains;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

}
