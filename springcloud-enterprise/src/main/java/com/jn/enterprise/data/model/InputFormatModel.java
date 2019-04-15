package com.jn.enterprise.data.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 19:13
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "InputFormatModel", description = "指标填写格式")
public class InputFormatModel implements Serializable {

    @ApiModelProperty(value = "指标ID",example = "0001")
    private String targetId;
    @ApiModelProperty(value = "填报格式ID",example = "0001")
    private String formId;
    @ApiModelProperty(value = "类型（0：文本框1：多行文本框2：数字3：单选框4：多选框5：图片上传）",example = "3")
    private String formType;
    @ApiModelProperty(value = "填报格式名称",example = "性别")
    private String formName;
    @ApiModelProperty(value = "是否必填（0:否，1：是）",example = "1")
    private String require;
    @ApiModelProperty(value = "填写框的顺序",example = "23")
    private String order;
    @ApiModelProperty(value = "选项值（以逗号隔开）",example = "男,女,未知")
    private String choiceOption;

    @ApiModelProperty(value = "选项值;保存用户输入的值",example = "男")
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
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

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }
}
