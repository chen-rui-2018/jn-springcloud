package com.jn.pay.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 更新催缴次数入參
 *
 * @author： wzy
 * @date： Created on 2019/5/20 14:41
 * @version： v1.0
 * @modified By:
 */
public class PayCheckReminderParam implements Serializable {
    private static final long serialVersionUID = -3130495883561640246L;

    @ApiModelProperty(value="账单编号",example = "201905041234")
    @NotBlank(message = "{billId :'账单编号不能为空'}")
    private String billId;

    @ApiModelProperty(value="催缴次数",example = "2")
    @NotNull(message = "{reminderNumber :'催缴次数不能为空'}")
    private int reminderNumber;

    @ApiModelProperty(value="最新催缴时间",example = "2019-12-12 12:12:12")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date modifiedReminderTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public int getReminderNumber() {
        return reminderNumber;
    }

    public void setReminderNumber(int reminderNumber) {
        this.reminderNumber = reminderNumber;
    }

    public Date getModifiedReminderTime() {
        return modifiedReminderTime;
    }

    public void setModifiedReminderTime(Date modifiedReminderTime) {
        this.modifiedReminderTime = modifiedReminderTime;
    }
}
