package com.jn.enterprise.pd.personnel.vo;

import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 企业-领取执照
 *
 * @author： wzy
 * @date： Created on 2019/3/19 16:05
 * @version： v1.0
 * @modified By:
 */
@ApiModel("企业-领取执照")
public class PersonnelFlow5030Vo extends PersonnelFlowNodeBaseAbstractVo implements Serializable {
    private static final long serialVersionUID = 1594420564283994111L;

    @Override
    public PersonnelFlowNodeEnum getFlowNodeEnum() {
        return PersonnelFlowNodeEnum.FIVE_SETTLE_30;
    }

    @ApiModelProperty("唯一标识符")
    private Integer id;

    @ApiModelProperty("是否已领取执照(1:是，2：否)")
    private Byte settleIsLicenseCollect;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getSettleIsLicenseCollect() {
        return settleIsLicenseCollect;
    }

    public void setSettleIsLicenseCollect(Byte settleIsLicenseCollect) {
        this.settleIsLicenseCollect = settleIsLicenseCollect;
    }
}
