package com.jn.enterprise.joinpark.usermanage.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 公司企业
 * @author： jiangyl
 * @date： Created on 2019/3/5 19:53
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "Conpany",description = "公司企业")
public class Conpany implements Serializable {

    @ApiModelProperty(value = "企业ID")
    private String id;

    @ApiModelProperty(value = "企业ID")
    private String comName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }
}
