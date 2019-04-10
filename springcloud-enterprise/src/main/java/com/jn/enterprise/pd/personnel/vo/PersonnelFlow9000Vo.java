package com.jn.enterprise.pd.personnel.vo;

import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * 完成申报
 *
 * @author： wzy
 * @date： Created on 2019/3/19 16:38
 * @version： v1.0
 * @modified By:
 */
@ApiModel("完成申报")
public class PersonnelFlow9000Vo extends PersonnelFlowNodeBaseAbstractVo implements Serializable {
    private static final long serialVersionUID = -8019836695718057111L;

    @Override
    public PersonnelFlowNodeEnum getFlowNodeEnum() {
        return PersonnelFlowNodeEnum.END;
    }
}
