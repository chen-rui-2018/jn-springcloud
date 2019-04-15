package com.jn.park.gamtopic.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/13 14:32
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value ="DynamicCommentsParam" ,description = "动态评论列表入参/评论的回复列表入参")
public class DynamicCommentsParam extends Page implements Serializable {
    @ApiModelProperty(value = "动态id/评论id",required = true ,example = "ebf75324ccbe4614afbad37ca920aa08")
    @NotBlank(message = "入参id不能为空")
    private String  paramId;

    public String getParamId() {
        return paramId;
    }

    public void setParamId(String paramId) {
        this.paramId = paramId;
    }
}
