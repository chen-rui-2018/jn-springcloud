package com.jn.park.hatch.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 更新企业（团队）税收，营收，投资额实体类
 *
 * @author： wzy
 * @date： Created on 2019/5/30 14:55
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "HatchUpdateRevenueParamModel", description = "更新企业（团队）税收，营收，投资额实体类")
public class HatchUpdateRevenueParamModel implements Serializable {
    private static final long serialVersionUID = -591371736946187147L;

    @ApiModelProperty(value = "企业（团队）ID",example = "219842749242")
    @NotNull(message = "企业（团队）ID不能为空")
    private String entAndTeamId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getEntAndTeamId() {
        return entAndTeamId;
    }

    public void setEntAndTeamId(String entAndTeamId) {
        this.entAndTeamId = entAndTeamId;
    }
}
