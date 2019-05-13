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
    @ApiModelProperty(value = "宣传类型",example = "business_promotion")
    private String propagandaType;
    @ApiModelProperty(value = "数据状态（0：失效  1：有效  不传查询全部）",example = "1")
    @Pattern(regexp = "^[01]$", message = "{^[01]$:'默认值只允许为0,1'}")
    private String status;
    @ApiModelProperty(value = "搜索内容(宣传产品名称模糊搜索))",example = "xxx产品")
    private String searchContent;
    @ApiModelProperty(value = "审批状态（0：未审批  1：审批中   2：审批通过   3：审批不通过，4：未付款  5：待发布  6：已发布)），不传查询全部",example = "0")
    @Pattern(regexp = "^[0-9]$",message = "approvalStatus:只能输入0-9的数字")
    private String approvalStatus;
    @ApiModelProperty(value = "是否需要分页  1:分页   0:不分页",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

    public String getPropagandaType() {
        return propagandaType;
    }

    public void setPropagandaType(String propagandaType) {
        this.propagandaType = propagandaType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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
