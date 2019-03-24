package com.jn.oa.email.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * 一键Email的添加实体
 *
 * @author： shaobao
 * @date： Created on 2019/3/9 11:35
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "EmailAdd", description = "一键Email的添加实体")
public class EmailAdd implements Serializable {

    private static final long serialVersionUID = -2952130120757495863L;

    @ApiModelProperty(value = "一键EmailID,添加时不用传,编辑时必须传",example = "\"100\"")
    private String id;

    @ApiModelProperty(value = "工单编号", required = true, example = "OAEMAIL20190309123")
    private String workOrderNum;

    @ApiModelProperty(value = "邮件标题", required = true, example = "测试邮件")
    @NotNull(message = "邮件标题不能为空")
    private String title;

    @ApiModelProperty(value = "邮件内容", required = true, example = "这是邮件测试,测试邮件")
    @NotNull(message = "邮件内容不能为空")
    private String emailContent;

    @ApiModelProperty(value = "发送状态(1未发送,2发送成功,3发送失败),添加时不用传,编辑时必须传", example = "1")
    private String sendStatus;

    @ApiModelProperty(value = "是否定时发送(1是,0否)", example = "\"0\"")
    private String isDelay;

    @ApiModelProperty(value = "定时发送时间", example = "2019-12-12 12:13:13")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date delaySendTime;

    @ApiModelProperty(value = "附件", example = "\"[{\"title\":\"附件\",\"url\":\"https:www.baidu.com\"}]\"")
    private String attachment;

    @ApiModelProperty(value = "邮件接收人账号", example = "[\"wangsong\"]")
    @NotNull(message = "邮件接收人不能为空")
    private String[] userAccounts;

    public EmailAdd() {
    }

    public EmailAdd(String id, String workOrderNum, String title, String emailContent, String sendStatus,
                    String isDelay, Date delaySendTime, String attachment, String[] userAccounts) {
        this.id = id;
        this.workOrderNum = workOrderNum;
        this.title = title;
        this.emailContent = emailContent;
        this.sendStatus = sendStatus;
        this.isDelay = isDelay;
        this.delaySendTime = delaySendTime;
        this.attachment = attachment;
        this.userAccounts = userAccounts;
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

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String[] getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(String[] userAccounts) {
        this.userAccounts = userAccounts;
    }

    @Override
    public String toString() {
        return "EmailAdd{" +
                "id='" + id + '\'' +
                ", workOrderNum='" + workOrderNum + '\'' +
                ", title='" + title + '\'' +
                ", emailContent='" + emailContent + '\'' +
                ", sendStatus='" + sendStatus + '\'' +
                ", isDelay='" + isDelay + '\'' +
                ", delaySendTime=" + delaySendTime +
                ", attachment='" + attachment + '\'' +
                ", userAccounts=" + Arrays.toString(userAccounts) +
                '}';
    }
}
