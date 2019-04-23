package com.jn.park.gamtopic.vo;

import com.jn.common.model.PaginationData;
import com.jn.park.gamtopic.model.DynamicComments;
import com.jn.park.gamtopic.model.DynamicWebShow;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/11 21:03
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="DynamicWebDetailsVo", description = "前台动态详情+评论列表")
public class DynamicWebDetailsVo implements Serializable {
    @ApiModelProperty(value="动态详情")
    private DynamicWebShow dynamicWebShow;
    @ApiModelProperty(value="评论列表")
    private PaginationData<List<DynamicComments>> commentList;

    public DynamicWebShow getDynamicWebShow() {
        return dynamicWebShow;
    }

    public void setDynamicWebShow(DynamicWebShow dynamicWebShow) {
        this.dynamicWebShow = dynamicWebShow;
    }

    public PaginationData<List<DynamicComments>> getCommentList() {
        return commentList;
    }

    public void setCommentList(PaginationData<List<DynamicComments>> commentList) {
        this.commentList = commentList;
    }
}
