package com.jn.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 查询账户下账本实体类
 *
 * @author： wzy
 * @date： Created on 2019/5/28 11:12
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayAccountBookEntIdOrUserIdParam" ,description = "查询账户下账本实体类")
public class PayAccountBookEntIdOrUserIdParam implements Serializable {

    @ApiModelProperty(value="对象类型【1：企业，2：个人】",example = "1")
    @NotNull(message = "对象类型不能为空")
    private String objType;

    @ApiModelProperty(value="对象ID【可传企业ID，企业管理员账号，用户名】",example = "wangsong")
    @NotNull(message = "对象ID不能为空")
    private String objId;

    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    @Override
    public String toString() {
        return "PayAccountBookEntIdOrUserIdParam{" +
                "objType='" + objType + '\'' +
                ", objId='" + objId + '\'' +
                '}';
    }
}
