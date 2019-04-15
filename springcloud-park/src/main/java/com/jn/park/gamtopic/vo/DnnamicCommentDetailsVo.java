package com.jn.park.gamtopic.vo;

import com.jn.common.model.PaginationData;
import com.jn.park.gamtopic.model.DynamicComments;
import com.jn.park.gamtopic.model.LikedUserInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/13 15:03
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DnnamicCommentDetailsVo",description = "评论详情,包含点赞人列表,回复列表,")
public class DnnamicCommentDetailsVo implements Serializable {
    @ApiModelProperty(value= "评论内容")
    private DynamicComments dynamicComments;
    @ApiModelProperty(value="评论列回复表")
    private PaginationData<List<DynamicComments>> commentList;
    @ApiModelProperty(value="点赞人信息列表,界面只取头像即可")
    private PaginationData<List<LikedUserInfo>> userList;

    public DynamicComments getDynamicComments() {
        return dynamicComments;
    }

    public void setDynamicComments(DynamicComments dynamicComments) {
        this.dynamicComments = dynamicComments;
    }

    public PaginationData<List<DynamicComments>> getCommentList() {
        return commentList;
    }

    public void setCommentList(PaginationData<List<DynamicComments>> commentList) {
        this.commentList = commentList;
    }

    public PaginationData<List<LikedUserInfo>> getUserList() {
        return userList;
    }

    public void setUserList(PaginationData<List<LikedUserInfo>> userList) {
        this.userList = userList;
    }
}
