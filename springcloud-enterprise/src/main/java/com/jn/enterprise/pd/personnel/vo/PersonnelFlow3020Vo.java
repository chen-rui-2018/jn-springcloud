package com.jn.enterprise.pd.personnel.vo;

import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * 人才中心-完善申报资料审核
 *
 * @author： wzy
 * @date： Created on 2019/3/19 15:01
 * @version： v1.0
 * @modified By:
 */
@ApiModel("人才中心-完善申报资料审核")
public class PersonnelFlow3020Vo extends PersonnelFlowNodeBaseAbstractVo implements Serializable {

    private static final long serialVersionUID = -2393949669324048263L;

    @Override
    public PersonnelFlowNodeEnum getFlowNodeEnum() {
        return PersonnelFlowNodeEnum.THREE_ADD_INFO_20;
    }

}