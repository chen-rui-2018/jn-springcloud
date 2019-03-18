package com.jn.enterprise.pd.personnel.model;

import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
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
@ApiModel("人才意向申报")
public class PersonnelFirstStart20Model extends PersonnelFirstStart10Model implements Serializable {

    public PersonnelFirstStart20Model(String nodeNo) {
        //初始化流程 流程所在的节点
        super(nodeNo);
    }

    @Override
    public String getNextFormAction() {
        return "/person/first/20";
    }


}
