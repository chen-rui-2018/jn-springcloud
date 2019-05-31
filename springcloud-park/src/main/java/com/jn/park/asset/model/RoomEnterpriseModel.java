package com.jn.park.asset.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
* 租借企业相关房间信息
* @author： zhuyz
* @date： Created on 2019/5/25 14:28
* @version： v1.0
* @modified By:
*/
public class RoomEnterpriseModel implements Serializable {
    private static final long serialVersionUID = 7696152012522343540L;

    @ApiModelProperty(value = "租借企业id")
    private String enterpriseId;

    @ApiModelProperty(value = "租借企业名称")
    private String leaseEnterprise;

    @ApiModelProperty(value = "企业租借房间信息")
    private List<RoomPayOrdersItemModel> children;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getLeaseEnterprise() {
        return leaseEnterprise;
    }

    public void setLeaseEnterprise(String leaseEnterprise) {
        this.leaseEnterprise = leaseEnterprise;
    }

    public List<RoomPayOrdersItemModel> getChildren() {
        return children;
    }

    public void setChildren(List<RoomPayOrdersItemModel> children) {
        this.children = children;
    }
}