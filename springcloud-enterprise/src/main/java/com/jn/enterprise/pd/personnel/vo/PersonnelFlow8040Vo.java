package com.jn.enterprise.pd.personnel.vo;

import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 企业-市级答辩辅导中
 *
 * @author： wzy
 * @date： Created on 2019/3/19 16:30
 * @version： v1.0
 * @modified By:
 */
@ApiModel("企业-市级答辩辅导中")
public class PersonnelFlow8040Vo extends PersonnelFlowNodeBaseAbstractVo implements Serializable {

    private static final long serialVersionUID = 8829228046115493110L;

    @Override
    public PersonnelFlowNodeEnum getFlowNodeEnum() {
        return PersonnelFlowNodeEnum.EIGHT_CITY_ANSWER_COUNSEL_40;
    }

    @ApiModelProperty("唯一标识符")
    private Integer id;

    @ApiModelProperty("预约状态（1：已预约，2：未预约，3：已取消）")
    private Byte status;

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
}
