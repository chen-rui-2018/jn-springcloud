package com.jn.user.usertag.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/6 16:50
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "TagCode",description = "用户标签字典")
public class TagCode implements Serializable {
    @ApiModelProperty(value = "标签ID")
    private String tagId;
    @ApiModelProperty(value = "标签值")
    private String tagVaule;
    @ApiModelProperty(value = "标签类型 0兴趣1职业")
    private String tagType;

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getTagVaule() {
        return tagVaule;
    }

    public void setTagVaule(String tagVaule) {
        this.tagVaule = tagVaule;
    }

    public String getTagType() {
        return tagType;
    }

    public void setTagType(String tagType) {
        this.tagType = tagType;
    }
}
