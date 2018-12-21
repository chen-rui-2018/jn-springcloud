package com.jn.park.comment.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 新增评论的传值信息
 * @Author: yangph
 * @Date: 2018/12/11 11:33
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ApplyUserInfo", description = "新增评论的传值信息")
public class CommentAdd implements Serializable {
    @ApiModelProperty(value = "活动id/服务id")
    private String rootId;
    @ApiModelProperty(value = "点评ID/活动ID")
    private String pId;
    @ApiModelProperty(value = "类型")
    @Pattern(regexp="^[0-1]$",message="{comType:'类型只能是0(活动点评)和1(服务点评)'}")
    private String comType;
    @ApiModelProperty(value = "评论内容")
    @Size(max=512)
    private String comContent;

    private static final long serialVersionUID = 1L;

    public String getRootId() {
        return rootId;
    }

    public void setRootId(String rootId) {
        this.rootId = rootId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
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
