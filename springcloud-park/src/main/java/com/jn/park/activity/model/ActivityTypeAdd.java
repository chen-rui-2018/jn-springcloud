package com.jn.park.activity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 增加活动类型信息
 *
 * @Author: chenr
 * @Date: 2018/12/21 17:52
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ActivityTypeAdd", description = "增加活动类型信息")
public class ActivityTypeAdd implements Serializable {

    @ApiModelProperty(value = "类型名称",required = true,example = "***活动类型")
    @NotBlank(message = "活动类型名称不能为空")
    @Size(min = 1, max = 20, message = "活动类型名称不正确")
    private String typeName;
    @ApiModelProperty(value = "状态(0：无效，1：有效)",required = true,example = "1")
    @NotBlank(message = "活动类型状态不能为空")
    @Pattern(regexp = "^['0'|'1']$", message = "{status:'状态值错误'}")
    private String typeStatus;
    @ApiModelProperty(value = "模板列表,多个时使用逗号[图片路径]','分隔",example = "http://192.168.10.20:2020/group2/M00/00/1F/wKgKFFwbR2iAIJ7HAACAPkYqwSw461.jpg")
    private String templateList;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeStatus() {
        return typeStatus;
    }
    public void setTypeStatus(String typeStatus) {
        this.typeStatus = typeStatus;
    }

    public String getTemplateList() {
        return templateList;
    }

    public void setTemplateList(String templateList) {
        this.templateList = templateList;
    }
}
