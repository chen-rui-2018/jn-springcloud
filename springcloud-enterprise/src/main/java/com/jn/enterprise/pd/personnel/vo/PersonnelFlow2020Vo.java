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
@ApiModel("企业-上传人才申报书")
public class PersonnelFlow2020Vo extends PersonnelFlowNodeBaseAbstractVo implements Serializable {

    @Override
    public PersonnelFlowNodeEnum getFlowNodeEnum() {
        return PersonnelFlowNodeEnum.TWO_AREA_PLAN_COUNSEL_20;
    }

    //todo 补充本节点的表单内容（流程相关的除外）

}
