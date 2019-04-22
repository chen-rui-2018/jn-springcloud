package com.jn.enterprise.propaganda.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/4/18 11:10
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "BusinessPromotionListParam", description = "企业宣传查询列表入参")
public class BusinessPromotionListParam extends Page implements Serializable {
    @ApiModelProperty(value = "搜索内容(宣传产品名称模糊搜索))",example = "xxx产品")
    private String searchContent;
    @ApiModelProperty(value = "审批状态（0：未审批  1：审批中   2：审批通过/已发布   3：审批不通过)），默认查询未审批数据",required = true,example = "0")
    @Pattern(regexp = "^[0-9]$",message = "approvalStatus:只能输入0-9的数字")
    private String approvalStatus;
    @ApiModelProperty(value = "是否需要分页  1:分页   0:不分页",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }
}
