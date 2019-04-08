package com.jn.enterprise.data.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 19:13
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "InputFormat", description = "指标填写格式")
public class InputFormat implements Serializable {
    @ApiModelProperty(value = "填报格式ID")
    private String formd;
    @ApiModelProperty(value = "类型（0：文本框1：多行文本框2：数字3：单选框4：多选框5：图片上传）")
    private String formType;
    @ApiModelProperty(value = "填报格式名称")
    private String formName;
    @ApiModelProperty(value = "是否必填（0:否，1：是）")
    private String haveToWrite;
    @ApiModelProperty(value = "填写框的顺序")
    private String order;
    @ApiModelProperty(value = "选项值（以逗号隔开）")
    private String choiceOption;

    public String getFormd() {
        return formd;
    }

    public void setFormd(String formd) {
        this.formd = formd;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getHaveToWrite() {
        return haveToWrite;
    }

    public void setHaveToWrite(String haveToWrite) {
        this.haveToWrite = haveToWrite;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getChoiceOption() {
        return choiceOption;
    }

    public void setChoiceOption(String choiceOption) {
        this.choiceOption = choiceOption;
    }
}
