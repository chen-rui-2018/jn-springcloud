package com.jn.park.index.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 园区成果列表入参
 * @author： huxw
 * @date： Created on 2019-5-21 16:14:29
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "AchievementParam",description = "园区成果列表入参")
public class AchievementParam extends Page implements Serializable {

    @ApiModelProperty(value = "类型（科技：technology 学术：science）[不传查询全部]")
    @Pattern(regexp = "^(technology)|(science)$", message = "平台类型校检错误")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AchievementParam{" +
                "type='" + type + '\'' +
                '}';
    }
}
