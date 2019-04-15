package com.jn.oa.email.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.oa.email.model.EmailReceiver;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 一键Email实体
 *
 * @author： shaobao
 * @date： Created on 2019/3/11 20:26
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "EmailVO", description = "一键Email实体")
public class EmailVO implements Serializable {
    private static final long serialVersionUID = 4315984199557297656L;

    @ApiModelProperty(value = "一键EmailID", example = "\"100\"")
    private String id;

    @ApiModelProperty(value = "工单编号", required = true, example = "OAEMAIL20190309123")
    private String workOrderNum;

    @ApiModelProperty(value = "邮件标题", required = true, example = "测试邮件")
    private String title;

    @ApiModelProperty(value = "邮件内容", required = true, example = "这是邮件测试,测试邮件")
    private String emailContent;

    @ApiModelProperty(value = "发送状态(1未发送,2发送成功,3发送失败),添加时不用传,编辑时必须传", example = "1")
    private String sendStatus;

    @ApiModelProperty(value = "是否定时发送(1是,0否)", example = "\"0\"")
    private String isDelay;

    @ApiModelProperty(value = "定时发送时间", example = "2019-12-12 12:13:13")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date delaySendTime;

    @ApiModelProperty(value = "邮件接收人账号", example = "[\"wangsong\"]")
    private String userAccounts;

    @ApiModelProperty(value = "邮件接收人名称", example = "王松,刘雄")
    private String userNames;

    @ApiModelProperty(value = "创建时间", example = "2019-12-12 12:13:13")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;

    @ApiModelProperty(value = "创建人", example = "管理员")
    private String creator;

    @ApiModelProperty(value = "附件", example = "[{\"title\":\"附件\",\"url\":\"https:www.baidu.com\"}]")
    private String attachment;

    @ApiModelProperty(value = "创建时间", example = "2019-12-12 12:13:13")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sendTime;

    @ApiModelProperty(value = "创建人部门名称")
    private String departName;

    @ApiModelProperty(value = "邮件接收人信息集合")
    private List<EmailReceiver> receiverList;

    public EmailVO() {
    }

    public EmailVO(String id, String workOrderNum, String title, String emailContent, String sendStatus,
                   String isDelay, Date delaySendTime, String userAccounts, String userNames,
                   Date createdTime, String creator, String attachment, Date sendTime, String departName,
                   List<EmailReceiver> receiverList) {
        this.id = id;
        this.workOrderNum = workOrderNum;
        this.title = title;
        this.emailContent = emailContent;
        this.sendStatus = sendStatus;
        this.isDelay = isDelay;
        this.delaySendTime = delaySendTime;
        this.userAccounts = userAccounts;
        this.userNames = userNames;
        this.createdTime = createdTime;
        this.creator = creator;
        this.attachment = attachment;
        this.sendTime = sendTime;
        this.departName = departName;
        this.receiverList = receiverList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkOrderNum() {
        return workOrderNum;
    }

    public void setWorkOrderNum(String workOrderNum) {
        this.workOrderNum = workOrderNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }

    public String getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getIsDelay() {
        return isDelay;
    }

    public void setIsDelay(String isDelay) {
        this.isDelay = isDelay;
    }

    public Date getDelaySendTime() {
        return delaySendTime;
    }

    public void setDelaySendTime(Date delaySendTime) {
        this.delaySendTime = delaySendTime;
    }

    public String getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(String userAccounts) {
        this.userAccounts = userAccounts;
    }

    public String getUserNames() {
        return userNames;
    }

    public void setUserNames(String userNames) {
        this.userNames = userNames;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public List<EmailReceiver> getReceiverList() {
        return receiverList;
    }

    public void setReceiverList(List<EmailReceiver> receiverList) {
        this.receiverList = receiverList;
    }


    @Override
    public String toString() {
        return "EmailVO{" +
                "id='" + id + '\'' +
                ", workOrderNum='" + workOrderNum + '\'' +
                ", title='" + title + '\'' +
                ", emailContent='" + emailContent + '\'' +
                ", sendStatus='" + sendStatus + '\'' +
                ", isDelay='" + isDelay + '\'' +
                ", delaySendTime=" + delaySendTime +
                ", userAccounts='" + userAccounts + '\'' +
                ", userNames='" + userNames + '\'' +
                ", createdTime=" + createdTime +
                ", creator='" + creator + '\'' +
                ", attachment='" + attachment + '\'' +
                ", sendTime=" + sendTime +
                ", departName='" + departName + '\'' +
                ", receiverList=" + receiverList +
                '}';
    }
}
