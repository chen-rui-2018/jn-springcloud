package com.jn.enterprise.company.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 邀请列表（APP）
 * @author： huxw
 * @date： Created on 2019-4-9 14:18:49
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "StaffInviteParam",description = "邀请列表（APP）")
public class StaffInviteParam implements Serializable {

    @ApiModelProperty(value = "姓名[模糊搜索]/手机", required = true, example = "张三")
    @NotNull(message = "查询字段不能为空")
    private String searchFiled;

    public String getSearchFiled() {
        return searchFiled;
    }

    public void setSearchFiled(String searchFiled) {
        this.searchFiled = searchFiled;
    }

}
