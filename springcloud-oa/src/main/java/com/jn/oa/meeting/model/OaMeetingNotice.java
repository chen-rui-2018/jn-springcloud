package com.jn.oa.meeting.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 会议通知
 *
 * @author： yuanyy
 * @date： Created on 2019/1/13 10:18
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OaMeetingNotice", description = "会议通知")
public class OaMeetingNotice implements Serializable {
    private static final long serialVersionUID = 7252981735944287744L;

    @ApiModelProperty(value = "会议申请id")
    private String id;

    @ApiModelProperty(value = "会议主题")
    private String title;


    @ApiModelProperty(value = "会议申请人号码")
    private String applicantPhone;

    @ApiModelProperty(value = "会议申请人微信账号")
    private String applicantWechatAccount;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getApplicantPhone() {
        return applicantPhone;
    }

    public void setApplicantPhone(String applicantPhone) {
        this.applicantPhone = applicantPhone;
    }

    public String getApplicantWechatAccount() {
        return applicantWechatAccount;
    }

    public void setApplicantWechatAccount(String applicantWechatAccount) {
        this.applicantWechatAccount = applicantWechatAccount;
    }
}
