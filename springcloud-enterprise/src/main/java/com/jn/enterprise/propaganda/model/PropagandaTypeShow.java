package com.jn.enterprise.propaganda.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/4/19 9:14
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "PropagandaTypeShow", description = "宣传类型出参")
public class PropagandaTypeShow implements Serializable {
    @ApiModelProperty(value = "发布类型编码")
    private String propagandaTypeCode;
    @ApiModelProperty(value = "发布类型名称")
    private String propagandaTypeName;

    public String getPropagandaTypeCode() {
        return propagandaTypeCode;
    }

    public void setPropagandaTypeCode(String propagandaTypeCode) {
        this.propagandaTypeCode = propagandaTypeCode;
    }

    public String getPropagandaTypeName() {
        return propagandaTypeName;
    }

    public void setPropagandaTypeName(String propagandaTypeName) {
        this.propagandaTypeName = propagandaTypeName;
    }

    @Override
    public String toString() {
        return "PropagandaTypeShow{" +
                "propagandaTypeCode='" + propagandaTypeCode + '\'' +
                ", propagandaTypeName='" + propagandaTypeName + '\'' +
                '}';
    }
}
