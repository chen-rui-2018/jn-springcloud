package com.jn.enterprise.servicemarket.industryarea.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 业务领域查询入参
 * @author： jiangyl
 * @date： Created on 2019/2/27 11:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "IndustryDictParameter",description = "机构数据字典查询入参")
public class IndustryDictParameter extends Page {

    @ApiModelProperty(value = "数据名称",example = "生物医药")
    private String preValue;

    @ApiModelProperty(value = "领域名称",example = "1",notes = "0业务领域1行业领域2发展阶段3企业性质 ")
    private String preType;

    @ApiModelProperty(value = "数据id",example = "shengwuyiyao")
    private String id;

    public String getPreValue() {
        return preValue;
    }

    public void setPreValue(String preValue) {
        this.preValue = preValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPreType() {
        return preType;
    }

    public void setPreType(String preType) {
        this.preType = preType;
    }
}
