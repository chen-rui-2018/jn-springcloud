package com.jn.enterprise.pd.personnel.vo;

import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 企业-核准名称
 *
 * @author： wzy
 * @date： Created on 2019/3/19 16:05
 * @version： v1.0
 * @modified By:
 */
@ApiModel("企业-核准名称")
public class PersonnelFlow5010Vo extends PersonnelFlowNodeBaseAbstractVo implements Serializable {
    private static final long serialVersionUID = 1609660487974486700L;

    @Override
    public PersonnelFlowNodeEnum getFlowNodeEnum() {
        return PersonnelFlowNodeEnum.FIVE_SETTLE_10;
    }

    @ApiModelProperty("唯一标识符")
    private Integer id;

    @ApiModelProperty("是否完成核名（1：是，2：否）")
    private Byte settleIsCompleteNuclearName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getSettleIsCompleteNuclearName() {
        return settleIsCompleteNuclearName;
    }

    public void setSettleIsCompleteNuclearName(Byte settleIsCompleteNuclearName) {
        this.settleIsCompleteNuclearName = settleIsCompleteNuclearName;
    }
}
