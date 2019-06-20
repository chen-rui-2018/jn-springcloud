package com.jn.enterprise.pd.personnel.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 人才中心-上传答辩材料及发送预约辅导
 *
 * @author： wzy
 * @date： Created on 2019/3/19 16:30
 * @version： v1.0
 * @modified By:
 */
@ApiModel("人才中心-上传答辩材料及发送预约辅导")
public class PersonnelFlow8010Vo extends PersonnelFlowNodeBaseAbstractVo implements Serializable {
    private static final long serialVersionUID = -7871216124016166745L;

    @Override
    public PersonnelFlowNodeEnum getFlowNodeEnum() {
        return PersonnelFlowNodeEnum.EIGHT_CITY_ANSWER_COUNSEL_10;
    }

    @ApiModelProperty("唯一标识符")
    private Integer id;

    @ApiModelProperty("主题")
    private String theme;

    @ApiModelProperty("园区发送预约时间始")
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    private Date parkAppointmentTimeStart;

    @ApiModelProperty("园区发送预约时间止")
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    private Date parkAppointmentTimeEnd;

    @ApiModelProperty("园区发送预约辅导地点")
    private String parkReservationAddress;

    @ApiModelProperty("预约人数限制")
    private Integer reservationLimit;

    @ApiModelProperty("截止预约时间")
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    private Date deadline;

    @ApiModelProperty("辅导类型（1：区级计划书辅导，2：区级答辩辅导，3：市级计划书辅导，4：市级答辩辅导）")
    private Byte counselType;

    @ApiModelProperty("状态（1：已使用，2：未使用）")
    private Byte status;

    /*TODO 附件未处理**/

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Date getParkAppointmentTimeStart() {
        return parkAppointmentTimeStart;
    }

    public void setParkAppointmentTimeStart(Date parkAppointmentTimeStart) {
        this.parkAppointmentTimeStart = parkAppointmentTimeStart;
    }

    public Date getParkAppointmentTimeEnd() {
        return parkAppointmentTimeEnd;
    }

    public void setParkAppointmentTimeEnd(Date parkAppointmentTimeEnd) {
        this.parkAppointmentTimeEnd = parkAppointmentTimeEnd;
    }

    public String getParkReservationAddress() {
        return parkReservationAddress;
    }

    public void setParkReservationAddress(String parkReservationAddress) {
        this.parkReservationAddress = parkReservationAddress;
    }

    public Integer getReservationLimit() {
        return reservationLimit;
    }

    public void setReservationLimit(Integer reservationLimit) {
        this.reservationLimit = reservationLimit;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Byte getCounselType() {
        return counselType;
    }

    public void setCounselType(Byte counselType) {
        this.counselType = counselType;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
