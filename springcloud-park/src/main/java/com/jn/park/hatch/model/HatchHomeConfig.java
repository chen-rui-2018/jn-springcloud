package com.jn.park.hatch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

/**
 * 众创空间后台配置表实体类
 *
 * @author： wzy
 * @date： Created on 2019/4/10 10:12
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "HatchHomeConfig", description = "众创空间后台配置表实体类")
public class HatchHomeConfig implements Serializable {

    @ApiModelProperty(value = "唯一id")
    private String id;

    @ApiModelProperty(value = "孵化器ID")
    private String incubatorId;

    @ApiModelProperty(value = "孵化器名称")
    private String incubatorName;

    @ApiModelProperty(value = "孵化器简称")
    private String incubatorAbb;

    @ApiModelProperty(value = "优势介绍")
    private String advantageIntroduct;

    @ApiModelProperty(value = "空间特色")
    private String spatialCharacter;

    @ApiModelProperty(value = "入驻标准")
    private String entryCriteria;

    @ApiModelProperty(value = "联系电话")
    private String phone;

    @ApiModelProperty(value = "状态（1：草稿2：已发布3：已下架）")
    private String status;

    @ApiModelProperty(value = "是否删除（0标记删除，1正常）")
    private String recordStatus;

    @ApiModelProperty(value = "创建者账号")
    private String creatorAccount;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @ApiModelProperty(value = "最新更新者账号")
    private String modifierAccount;

    @ApiModelProperty(value = "最新更新时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIncubatorId() {
        return incubatorId;
    }

    public void setIncubatorId(String incubatorId) {
        this.incubatorId = incubatorId;
    }

    public String getIncubatorName() {
        return incubatorName;
    }

    public void setIncubatorName(String incubatorName) {
        this.incubatorName = incubatorName;
    }

    public String getIncubatorAbb() {
        return incubatorAbb;
    }

    public void setIncubatorAbb(String incubatorAbb) {
        this.incubatorAbb = incubatorAbb;
    }

    public String getAdvantageIntroduct() {
        return advantageIntroduct;
    }

    public void setAdvantageIntroduct(String advantageIntroduct) {
        this.advantageIntroduct = advantageIntroduct;
    }

    public String getSpatialCharacter() {
        return spatialCharacter;
    }

    public void setSpatialCharacter(String spatialCharacter) {
        this.spatialCharacter = spatialCharacter;
    }

    public String getEntryCriteria() {
        return entryCriteria;
    }

    public void setEntryCriteria(String entryCriteria) {
        this.entryCriteria = entryCriteria;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}