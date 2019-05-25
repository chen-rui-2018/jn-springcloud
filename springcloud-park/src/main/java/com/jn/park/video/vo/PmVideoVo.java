package com.jn.park.video.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.park.video.entity.TbPmVideoItem;
import com.jn.park.video.model.PmVideoItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 安防录像申请Vo实体
 *
 * @author： shaobao
 * @date： Created on 2019/5/18 16:00
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "PmVideoVo", description = "安防录像申请Vo实体")
public class PmVideoVo implements Serializable {
    private static final long serialVersionUID = -7447442778372432277L;

    @ApiModelProperty(value = "id", example = "578977761985560576")
    private String id;
    @ApiModelProperty(value = "企业id", example = "578977761985560576")
    private String enterpriseId;
    @ApiModelProperty(value = "企业名称", example = "578977761985560576")
    private String enterpriseName;
    @ApiModelProperty(value = "联系人", example = "王松")
    private String contactMan;
    @ApiModelProperty(value = "联系电话x", example = "13345677654")
    private String contactPhone;
    @ApiModelProperty(value = "联系地址", example = "江苏南京")
    private String address;
    @ApiModelProperty(value = "流程编号", example = "0212012010")
    private String flowNo;
    @ApiModelProperty(value = "工单名称", example = "工单测试")
    private String flowTitle;
    @ApiModelProperty(value = "工单状态", example = "0")
    private Byte flowStatus;
    @ApiModelProperty("节点名称")
    private String flowNodeName;
    @ApiModelProperty("办理材料清单")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date flowStartTime;
    @ApiModelProperty("流程完成时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date flowCompleteTime;
    @ApiModelProperty("是否删除")
    private Byte recordStatus;
    @ApiModelProperty("创建人账号")
    private String creatorAccount;
    @ApiModelProperty("创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("更新人账号")
    private String modifierAccount;
    @ApiModelProperty("备注")
    private String remarks;
    @ApiModelProperty("安防录像申请单明细")
    private List<PmVideoItem> tb_pm_video_item;

    public PmVideoVo() {
    }

    public PmVideoVo(String id, String enterpriseId, String enterpriseName, String contactMan, String contactPhone,
                     String address, String flowNo, String flowTitle, Byte flowStatus, String flowNodeName,
                     Date flowStartTime, Date flowCompleteTime, Byte recordStatus, String creatorAccount,
                     Date createTime, String modifierAccount, String remarks, List<PmVideoItem> tb_pm_video_item) {
        this.id = id;
        this.enterpriseId = enterpriseId;
        this.enterpriseName = enterpriseName;
        this.contactMan = contactMan;
        this.contactPhone = contactPhone;
        this.address = address;
        this.flowNo = flowNo;
        this.flowTitle = flowTitle;
        this.flowStatus = flowStatus;
        this.flowNodeName = flowNodeName;
        this.flowStartTime = flowStartTime;
        this.flowCompleteTime = flowCompleteTime;
        this.recordStatus = recordStatus;
        this.creatorAccount = creatorAccount;
        this.createTime = createTime;
        this.modifierAccount = modifierAccount;
        this.remarks = remarks;
        this.tb_pm_video_item = tb_pm_video_item;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getContactMan() {
        return contactMan;
    }

    public void setContactMan(String contactMan) {
        this.contactMan = contactMan;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo;
    }

    public String getFlowTitle() {
        return flowTitle;
    }

    public void setFlowTitle(String flowTitle) {
        this.flowTitle = flowTitle;
    }

    public Byte getFlowStatus() {
        return flowStatus;
    }

    public void setFlowStatus(Byte flowStatus) {
        this.flowStatus = flowStatus;
    }

    public String getFlowNodeName() {
        return flowNodeName;
    }

    public void setFlowNodeName(String flowNodeName) {
        this.flowNodeName = flowNodeName;
    }

    public Date getFlowStartTime() {
        return flowStartTime;
    }

    public void setFlowStartTime(Date flowStartTime) {
        this.flowStartTime = flowStartTime;
    }

    public Date getFlowCompleteTime() {
        return flowCompleteTime;
    }

    public void setFlowCompleteTime(Date flowCompleteTime) {
        this.flowCompleteTime = flowCompleteTime;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<PmVideoItem> getTb_pm_video_item() {
        return tb_pm_video_item;
    }

    public void setTb_pm_video_item(List<PmVideoItem> tb_pm_video_item) {
        this.tb_pm_video_item = tb_pm_video_item;
    }

    @Override
    public String toString() {
        return "PmVideoVo{" +
                "id='" + id + '\'' +
                ", enterpriseId='" + enterpriseId + '\'' +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", contactMan='" + contactMan + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", address='" + address + '\'' +
                ", flowNo='" + flowNo + '\'' +
                ", flowTitle='" + flowTitle + '\'' +
                ", flowStatus=" + flowStatus +
                ", flowNodeName='" + flowNodeName + '\'' +
                ", flowStartTime=" + flowStartTime +
                ", flowCompleteTime=" + flowCompleteTime +
                ", recordStatus=" + recordStatus +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createTime=" + createTime +
                ", modifierAccount='" + modifierAccount + '\'' +
                ", remarks='" + remarks + '\'' +
                ", tb_pm_video_item=" + tb_pm_video_item +
                '}';
    }
}
