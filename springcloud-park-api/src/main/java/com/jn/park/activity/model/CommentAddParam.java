package com.jn.park.activity.model;

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
@ApiModel(value = "CommentAddParam", description = "评论的传值信息")
public class CommentAddParam implements Serializable {
    @ApiModelProperty(value = "根id(活动id/服务id/话题id/企业ID)",example="xxx1234")
    private String rootId;
    @ApiModelProperty(value = "点评父id(可以是根id,可以是被评论的评论id)",example = "xxx5678")
    private String pId;
    @ApiModelProperty(value = "点评人账号[前端无需理会]")
    private String account;
    @ApiModelProperty(value = "类型(0-9的数值,0：活动点评，1：服务点评，2：话题点评 ，3企业点评)",example="0")
    @Pattern(regexp="^[0-9]$",message="{comType:'类型只能是0：活动点评，1：服务点评，2：话题点评 ，3企业点评 ...'}")
    private String comType;
    @ApiModelProperty(value = "评论内容",example = "xxx评论")
    @Size(max=512,message="评论内容不能超过520个字")
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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
