package com.jn.oa.email.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 一键Email条件分页实体
 *
 * @author： shaobao
 * @date： Created on 2019/3/11 19:59
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "EmailPage", description = "一键Email条件分页实体")
public class EmailPage extends Page implements Serializable {

    private static final long serialVersionUID = 6667666031354207885L;
    @ApiModelProperty(value = "邮件标题", example = "邮件")
    private String title;

    @ApiModelProperty(value = "发送状态(1未发送,2发送成功,3发送失败),添加时不用传,编辑时必须传", example = "1")
    private String sendStatus;

    @ApiModelProperty(value = "创建人",example = "管理员")
    private String creator;

    public EmailPage() {
    }

    public EmailPage(String title, String sendStatus, String creator) {
        this.title = title;
        this.sendStatus = sendStatus;
        this.creator = creator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "EmailPage{" +
                "title='" + title + '\'' +
                ", sendStatus='" + sendStatus + '\'' +
                ", creator='" + creator + '\'' +
                '}';
    }
}
