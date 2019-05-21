package com.jn.enterprise.company.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 企业员工列表入参
 * @author： huxw
 * @date： Created on 2019-4-9 14:18:49
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "StaffListParam",description = "企业员工列表入参")
public class StaffListParam extends Page implements Serializable {

    @ApiModelProperty(value = "是否需要分页 1:分页 0:不分页", required = true, example = "1")
    @Pattern(regexp = "^[01]$", message = "{isDefault:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

    @ApiModelProperty(value = "姓名/手机[模糊搜索]", example = "张三")
    private String searchFiled;

    @ApiModelProperty(value = "状态（0待审批 -1审核不通过 5已邀请 7已拒绝）[默认全部]")
    @Pattern(regexp = "^-1|[057]|\\s*$", message = "状态传值错误")
    private String status;

    @ApiModelProperty(value = "企业ID", hidden = true)
    private String comId;

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getSearchFiled() {
        return searchFiled;
    }

    public void setSearchFiled(String searchFiled) {
        this.searchFiled = searchFiled;
    }

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StaffListParam{" +
                "needPage='" + needPage + '\'' +
                ", searchFiled='" + searchFiled + '\'' +
                ", status='" + status + '\'' +
                ", comId='" + comId + '\'' +
                '}';
    }
}
