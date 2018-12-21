package com.jn.park.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 活动点评信息
 *
 * @Author: jiangyl
 * @Date: 2018/12/5 11:17
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "Comment", description = "活动点评信息")
public class Comment extends Page implements Serializable {
    @ApiModelProperty(value = "点评ID")
    private String id;
    @ApiModelProperty(value = "根节点id，活动id/服务id")
    private String rootId;
    @ApiModelProperty(value = "点评父ID(点评ID/活动ID)")
    private String pId;
    @ApiModelProperty(value = "点评人")
    private String comAccount;
    @ApiModelProperty(value = "被点评人")
    private  String parentAccount;
    @ApiModelProperty(value = "点评时间")
    private String comTime;
    @ApiModelProperty(value = "点评点赞数")
    private Integer likeNum;
    @ApiModelProperty(value = "点评状态")
    private String status;
    @ApiModelProperty(value = "点评类型(0：活动点评，1：服务点评)")
    private String comType;
    @ApiModelProperty(value = "点评内容")
    private String comContent;
    @ApiModelProperty(value = "点评人头像)")
    private String avatar;
    @ApiModelProperty(value = "点评子节点)")
    private List<Comment> childList;
    @ApiModelProperty(value = "当前评论的子节点个数")
    private int childNum;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getComAccount() {
        return comAccount;
    }

    public void setComAccount(String comAccount) {
        this.comAccount = comAccount;
    }

    public String getParentAccount() {
        return parentAccount;
    }

    public void setParentAccount(String parentAccount) {
        this.parentAccount = parentAccount;
    }

    public String getComTime() {
        return comTime;
    }

    public void setComTime(String comTime) {
        this.comTime = comTime;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Comment> getChildList() {
        return childList;
    }

    public void setChildList(List<Comment> childList) {
        this.childList = childList;
    }

    public int getChildNum() {
        return childNum;
    }

    public void setChildNum(int childNum) {
        this.childNum = childNum;
    }
}