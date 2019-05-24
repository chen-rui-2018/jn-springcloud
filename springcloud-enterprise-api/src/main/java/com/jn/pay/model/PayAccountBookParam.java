package com.jn.pay.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 账本明细入參实体类
 *
 * @author： wzy
 * @date： Created on 2019/5/18 11:28
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayAccountBookParam" ,description = "账本明细入參实体类")
public class PayAccountBookParam extends Page implements Serializable {
    private static final long serialVersionUID = 366952774908071264L;

    @ApiModelProperty(value="账本编号",example = "20190504123")
    private String acBookId;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAcBookId() {
        return acBookId;
    }

    public void setAcBookId(String acBookId) {
        this.acBookId = acBookId;
    }

}
