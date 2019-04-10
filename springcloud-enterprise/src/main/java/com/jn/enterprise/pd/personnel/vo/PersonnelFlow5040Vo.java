package com.jn.enterprise.pd.personnel.vo;

import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 企业-刻章等事项
 *
 * @author： wzy
 * @date： Created on 2019/3/19 16:05
 * @version： v1.0
 * @modified By:
 */
@ApiModel("企业-刻章等事项")
public class PersonnelFlow5040Vo extends PersonnelFlowNodeBaseAbstractVo implements Serializable {

    private static final long serialVersionUID = -4539954793783032024L;

    @Override
    public PersonnelFlowNodeEnum getFlowNodeEnum() {
        return PersonnelFlowNodeEnum.FIVE_SETTLE_40;
    }

    @ApiModelProperty("唯一标识符")
    private Integer id;

    @ApiModelProperty("是否已完成盖章（1：是，2：否）")
    private Byte settleIsCompletionSeal;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getSettleIsCompletionSeal() {
        return settleIsCompletionSeal;
    }

    public void setSettleIsCompletionSeal(Byte settleIsCompletionSeal) {
        this.settleIsCompletionSeal = settleIsCompletionSeal;
    }
}
