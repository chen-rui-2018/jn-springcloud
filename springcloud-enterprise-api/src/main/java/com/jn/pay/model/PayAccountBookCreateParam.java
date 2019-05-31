package com.jn.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 创建账本实体类
 *
 * @author： wzy
 * @date： Created on 2019/5/31 18:06
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayAccountBookCreateParam" ,description = "创建账本实体类")
public class PayAccountBookCreateParam implements Serializable {
    private static final long serialVersionUID = -1521738958721359584L;

    @ApiModelProperty(value="企业ID",example = "20190504124")
    private String enterId;

    @ApiModelProperty(value="企业管理员账号",example = "wangsong")
    private String comAdmin;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getEnterId() {
        return enterId;
    }

    public void setEnterId(String enterId) {
        this.enterId = enterId;
    }

    public String getComAdmin() {
        return comAdmin;
    }

    public void setComAdmin(String comAdmin) {
        this.comAdmin = comAdmin;
    }
}
