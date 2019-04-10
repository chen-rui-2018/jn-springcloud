package com.jn.enterprise.pd.personnel.vo;

import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * 人才中心-政策材料审核
 *
 * @author： wzy
 * @date： Created on 2019/3/19 16:10
 * @version： v1.0
 * @modified By:
 */
@ApiModel("人才中心-政策材料审核")
public class PersonnelFlow6030Vo extends PersonnelFlowNodeBaseAbstractVo implements Serializable {

    private static final long serialVersionUID = 5805107069839796667L;

    @Override
    public PersonnelFlowNodeEnum getFlowNodeEnum() {
        return PersonnelFlowNodeEnum.SIX_POLICY_30;
    }
}
