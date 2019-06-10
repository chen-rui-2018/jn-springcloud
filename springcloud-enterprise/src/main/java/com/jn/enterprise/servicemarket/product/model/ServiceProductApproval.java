package com.jn.enterprise.servicemarket.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 服务产品审批,上下架
 * @author： chenr
 * @date： Created on 2019/2/18 10:47
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceProductApproval", description = "服务产品审批,上下架")
public class ServiceProductApproval implements Serializable {
    @ApiModelProperty(value = "服务产品ID",required = true)
    @NotBlank(message = "产品Id 不能为空")
    private String productId;
    @ApiModelProperty(value = "状态(审批结果 1:审批通过,2:审批不通过)",required = true,example = "1")
    @NotBlank(message = "审批结果不能为空")
    private String status;
    @ApiModelProperty(value = "审批意见",example = "符合要求,审批通过")
    private String approvalComments;
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApprovalComments() {
        return approvalComments;
    }

    public void setApprovalComments(String approvalComments) {
        this.approvalComments = approvalComments;
    }
}
