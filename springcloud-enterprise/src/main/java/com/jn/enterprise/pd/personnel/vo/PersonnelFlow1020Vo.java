package com.jn.enterprise.pd.personnel.vo;

import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 *
 * @author： huangbq
 * @date： Created on 2019/3/15 1:15
 * @version： v1.0
 * @modified By:
 */
@ApiModel("人才中心-人才意向申报审核")
public class PersonnelFlow1020Vo extends PersonnelFlowNodeBaseAbstractVo implements Serializable {

    @Override
    public PersonnelFlowNodeEnum getFlowNodeEnum() {
        return PersonnelFlowNodeEnum.FIRST_START_20;
    }

    //todo 补充本节点的表单内容（流程相关的除外）

}
