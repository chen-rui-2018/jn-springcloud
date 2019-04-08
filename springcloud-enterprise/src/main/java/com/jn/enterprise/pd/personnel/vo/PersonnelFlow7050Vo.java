package com.jn.enterprise.pd.personnel.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 人才中心-通知实际辅导
 *
 * @author： wzy
 * @date： Created on 2019/3/19 16:18
 * @version： v1.0
 * @modified By:
 */
@ApiModel("人才中心-通知实际辅导")
public class PersonnelFlow7050Vo extends PersonnelFlowNodeBaseAbstractVo implements Serializable {

    private static final long serialVersionUID = -6977787569737619148L;

    @Override
    public PersonnelFlowNodeEnum getFlowNodeEnum() {
        return PersonnelFlowNodeEnum.SEVEN_CITY_PLAN_COUNSEL_50;
    }

    @ApiModelProperty("唯一标识符")
    private Integer id;

    @ApiModelProperty("通知方式（1：短信，2：邮件，3：微信推送）")
    private Byte notificationMode;

    @ApiModelProperty("实际辅导时间始")
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    private Date notifyCounselTimeStart;

    @ApiModelProperty("实际辅导时间止")
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    private Date notifyCounselTimeEnd;

    @ApiModelProperty("实际辅导地址")
    private String notifyCounselAddress;

    @ApiModelProperty("项目ID")
    private Integer projectId;

    @ApiModelProperty("主题ID")
    private Integer themeId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getNotificationMode() {
        return notificationMode;
    }

    public void setNotificationMode(Byte notificationMode) {
        this.notificationMode = notificationMode;
    }

    public Date getNotifyCounselTimeStart() {
        return notifyCounselTimeStart;
    }

    public void setNotifyCounselTimeStart(Date notifyCounselTimeStart) {
        this.notifyCounselTimeStart = notifyCounselTimeStart;
    }

    public Date getNotifyCounselTimeEnd() {
        return notifyCounselTimeEnd;
    }

    public void setNotifyCounselTimeEnd(Date notifyCounselTimeEnd) {
        this.notifyCounselTimeEnd = notifyCounselTimeEnd;
    }

    public String getNotifyCounselAddress() {
        return notifyCounselAddress;
    }

    public void setNotifyCounselAddress(String notifyCounselAddress) {
        this.notifyCounselAddress = notifyCounselAddress;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }
}
