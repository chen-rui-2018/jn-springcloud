package com.jn.park.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
/**
 * 根据活动id,编辑当前活动类型
 *
 * @Author: chenr
 * @Date: 2018/12/24 09:35
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ActivityTypeUpdate", description = "编辑活动信息")
public class ActivityTypeUpdate extends ActivityTypeAdd implements Serializable {
    @ApiModelProperty(value = "活动类型Id",required = true)
    @NotBlank(message = "活动类型Id不能为空")
    private  String typeId;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}
