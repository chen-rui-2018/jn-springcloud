package com.jn.park.index.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 重要消息列表入参
 * @author： huxw
 * @date： Created on 2019-5-21 16:14:29
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ImportantNewsParam",description = "重要消息列表入参")
public class ImportantNewsParam extends Page implements Serializable {

    @ApiModelProperty(value = "平台类型(1:APP 2:门户)", required = true, example = "2")
    @NotNull(message = "平台类型不能为空")
    @Pattern(regexp = "^[12]$", message = "平台类型校检错误")
    private String platFormType;

    public String getPlatFormType() {
        return platFormType;
    }

    public void setPlatFormType(String platFormType) {
        this.platFormType = platFormType;
    }

    @Override
    public String toString() {
        return "ImportantNewsParam{" +
                "platFormType='" + platFormType + '\'' +
                '}';
    }
}
