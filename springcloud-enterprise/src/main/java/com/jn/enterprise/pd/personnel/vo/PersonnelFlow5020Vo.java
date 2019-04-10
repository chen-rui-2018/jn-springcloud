package com.jn.enterprise.pd.personnel.vo;

import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * 企业-提交材料
 *
 * @author： wzy
 * @date： Created on 2019/3/19 16:05
 * @version： v1.0
 * @modified By:
 */
@ApiModel("企业-提交材料")
public class PersonnelFlow5020Vo extends PersonnelFlowNodeBaseAbstractVo implements Serializable {

    private static final long serialVersionUID = 570593250611023126L;

    @Override
    public PersonnelFlowNodeEnum getFlowNodeEnum() {
        return PersonnelFlowNodeEnum.FIVE_SETTLE_20;
    }


}
