package com.jn.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 查询账本余额实体类
 *
 * @author： wzy
 * @date： Created on 2019/5/28 11:12
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayAccountBookMoney" ,description = "查询账本余额实体类")
public class PayAccountBookMoney implements Serializable {

    @ApiModelProperty(value="账本ID",example = "1234")
    @NotNull(message = "账本ID不能为空")
    private String acBookId;

    public String getAcBookId() {
        return acBookId;
    }

    public void setAcBookId(String acBookId) {
        this.acBookId = acBookId;
    }
}
