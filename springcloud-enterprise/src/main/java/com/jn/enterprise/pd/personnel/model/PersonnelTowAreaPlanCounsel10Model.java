package com.jn.enterprise.pd.personnel.model;

import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import com.jn.enterprise.pd.personnel.vo.PersonnelFlowNodeBaseAbstractVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *
 * @author： huangbq
 * @date： Created on 2019/3/15 1:15
 * @version： v1.0
 * @modified By:
 */
@ApiModel("区级计划书辅导")
public class PersonnelTowAreaPlanCounsel10Model extends PersonnelFlowNodeBaseAbstractVo implements Serializable {

    public PersonnelTowAreaPlanCounsel10Model(String nodeNo) {
        //初始化流程 流程所在的节点
        super(PersonnelFlowNodeEnum.TWO_AREA_PLAN_COUNSEL_10.getNodeNo());
    }

    @Override
    public String getNextFormAction() {
        return "/person/first/20";
    }

    //todo
}
