package com.jn.enterprise.data.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author： yangh
 * @date： Created on 2019/4/9 15:10
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "GroupModel",description = "企业群组")
public class GroupModel {
    @ApiModelProperty("群组ID")
    private String groupId;

    @ApiModelProperty("群主名称")
    private String groupName;
}
