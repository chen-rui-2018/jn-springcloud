package com.jn.pay.vo;

import com.jn.pay.model.PayAccountBook;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 我的账本组合实体类
 *
 * @author： wzy
 * @date： Created on 2019/5/21 11:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayAccountBookVo" ,description = "我的账本组合实体类")
public class PayAccountBookVo extends PayAccountBook implements Serializable {

    @ApiModelProperty(value="账本描述信息")
    private String acBookDesc;

    @ApiModelProperty(value="账本适用范围")
    private String acBookScope;

    public String getAcBookDesc() {
        return acBookDesc;
    }

    public void setAcBookDesc(String acBookDesc) {
        this.acBookDesc = acBookDesc;
    }

    public String getAcBookScope() {
        return acBookScope;
    }

    public void setAcBookScope(String acBookScope) {
        this.acBookScope = acBookScope;
    }
}
