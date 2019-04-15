package com.jn.enterprise.pd.personnel.vo;

import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 人才中心-发布政策通知
 *
 * @author： wzy
 * @date： Created on 2019/3/19 16:09
 * @version： v1.0
 * @modified By:
 */
@ApiModel("人才中心-发布政策通知")
public class PersonnelFlow6010Vo extends PersonnelFlowNodeBaseAbstractVo implements Serializable {
    private static final long serialVersionUID = 107257429622272009L;

    @Override
    public PersonnelFlowNodeEnum getFlowNodeEnum() {
        return PersonnelFlowNodeEnum.SIX_POLICY_10;
    }
    @ApiModelProperty("唯一标识符")
    private Integer id;

    @ApiModelProperty("政策通知（获取扶持政策环节使用）")
    private String policyNotice;

    @ApiModelProperty("是否已发送（1：已发送，2：未发送）-获取扶持政策环节使用")
    private Byte policyIsSendOut;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPolicyNotice() {
        return policyNotice;
    }

    public void setPolicyNotice(String policyNotice) {
        this.policyNotice = policyNotice;
    }

    public Byte getPolicyIsSendOut() {
        return policyIsSendOut;
    }

    public void setPolicyIsSendOut(Byte policyIsSendOut) {
        this.policyIsSendOut = policyIsSendOut;
    }
}
