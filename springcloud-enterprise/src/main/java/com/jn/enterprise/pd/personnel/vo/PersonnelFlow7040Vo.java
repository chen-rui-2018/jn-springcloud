package com.jn.enterprise.pd.personnel.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业-进行预约辅导
 *
 * @author： wzy
 * @date： Created on 2019/3/19 16:18
 * @version： v1.0
 * @modified By:
 */
@ApiModel("企业-进行预约辅导")
public class PersonnelFlow7040Vo extends PersonnelFlowNodeBaseAbstractVo implements Serializable {

    private static final long serialVersionUID = -8308945333188525140L;

    @Override
    public PersonnelFlowNodeEnum getFlowNodeEnum() {
        return PersonnelFlowNodeEnum.SEVEN_CITY_PLAN_COUNSEL_40;
    }

    @ApiModelProperty("唯一标识符")
    private Integer id;

    @ApiModelProperty("预约状态（1：已预约，2：未预约，3：已取消）")
    private Byte status;

    @ApiModelProperty("企业预约时间始")
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    private Date appointmentTimeStart;

    @ApiModelProperty("企业预约时间止")
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    private Date appointmentTimeEnd;

    @ApiModelProperty("企业预约辅导地点")
    private String reservationAddress;

    @ApiModelProperty("项目ID")
    private Integer projectId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getAppointmentTimeStart() {
        return appointmentTimeStart;
    }

    public void setAppointmentTimeStart(Date appointmentTimeStart) {
        this.appointmentTimeStart = appointmentTimeStart;
    }

    public Date getAppointmentTimeEnd() {
        return appointmentTimeEnd;
    }

    public void setAppointmentTimeEnd(Date appointmentTimeEnd) {
        this.appointmentTimeEnd = appointmentTimeEnd;
    }

    public String getReservationAddress() {
        return reservationAddress;
    }

    public void setReservationAddress(String reservationAddress) {
        this.reservationAddress = reservationAddress;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
