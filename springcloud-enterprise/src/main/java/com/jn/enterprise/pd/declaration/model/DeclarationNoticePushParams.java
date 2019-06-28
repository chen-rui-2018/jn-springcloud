package com.jn.enterprise.pd.declaration.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * 公告推送实体类
 *
 * @author： wzy
 * @date： Created on 2019/4/17 15:26
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DeclarationNoticePushParams", description = "公告推送实体类")
public class DeclarationNoticePushParams implements Serializable {

    private static final long serialVersionUID = -680002942429767503L;
    @ApiModelProperty("短信模板ID")
    private String smsTemplateId;

    @ApiModelProperty("微信模板ID")
    private String wxTemplateId;

    @ApiModelProperty("公告ID")
    private List<String> noticeId;

    @ApiModelProperty("企业ID")
    private List<String> entId;

    @ApiModelProperty("推送方式【1：短信，2：邮件，3：微信，4：APP】")
    private List<String> pushMode;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSmsTemplateId() {
        return smsTemplateId;
    }

    public void setSmsTemplateId(String smsTemplateId) {
        this.smsTemplateId = smsTemplateId;
    }

    public String getWxTemplateId() {
        return wxTemplateId;
    }

    public void setWxTemplateId(String wxTemplateId) {
        this.wxTemplateId = wxTemplateId;
    }

    public List<String> getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(List<String> noticeId) {
        this.noticeId = noticeId;
    }

    public List<String> getEntId() {
        return entId;
    }

    public void setEntId(List<String> entId) {
        this.entId = entId;
    }

    public List<String> getPushMode() {
        return pushMode;
    }

    public void setPushMode(List<String> pushMode) {
        this.pushMode = pushMode;
    }

    @Override
    public String toString() {
        return "DeclarationNoticePushParams{" +
                "smsTemplateId='" + smsTemplateId + '\'' +
                ", wxTemplateId='" + wxTemplateId + '\'' +
                ", noticeId=" + noticeId +
                ", entId=" + entId +
                ", pushMode=" + pushMode +
                '}';
    }
}
