package com.jn.park.comment.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2018/12/11 11:33
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ApplyUserInfo", description = "新增评论")
public class CommentAdd implements Serializable {
    @ApiModelProperty(value = "点评ID/活动ID")
    private String id;
    @ApiModelProperty(value = "类型")
    @Pattern(regexp="^[0-1]$",message="{comType:'类型只能是0(活动点评)和1(服务点评)'}")
    private String comType;
    @ApiModelProperty(value = "评论内容")
    private String comContent;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent;
    }
}
