package com.jn.enterprise.servicemarket.org.vo;

import com.jn.enterprise.servicemarket.org.model.OrgCount;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 我的机构 ,机构信息
 * @author： chenr
 * @date： Created on 2019/3/26 16:39
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="MyOrgInfoVo",description = "我的机构 ,机构信息")
public class MyOrgInfoVo implements Serializable {
    @ApiModelProperty(value = "机构详情")
    private OrgDetailVo orgDetailVo;
    @ApiModelProperty(value="统计信息")
    private OrgCount orgCount;

    public OrgDetailVo getOrgDetailVo() {
        return orgDetailVo;
    }

    public void setOrgDetailVo(OrgDetailVo orgDetailVo) {
        this.orgDetailVo = orgDetailVo;
    }

    public OrgCount getOrgCount() {
        return orgCount;
    }

    public void setOrgCount(OrgCount orgCount) {
        this.orgCount = orgCount;
    }
}
