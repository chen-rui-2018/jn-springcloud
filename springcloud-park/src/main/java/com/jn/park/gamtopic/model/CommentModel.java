package com.jn.park.gamtopic.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author： tangry
 * @date： Created on 2019/5/24
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="CommentModel",description = "关注/评论")
public class CommentModel implements Serializable {

    private static final long serialVersionUID = -2901203584291869768L;

    @ApiModelProperty(value= "关注数")
    private String careUser;

    @ApiModelProperty(value= "评论数")
    private String commentNumber;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCareUser() {
        return careUser;
    }

    public void setCareUser(String careUser) {
        this.careUser = careUser;
    }

    public String getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(String commentNumber) {
        this.commentNumber = commentNumber;
    }

    @Override
    public String toString() {
        return "CommentModel{" +
                "careUser='" + careUser + '\'' +
                ", commentNumber='" + commentNumber + '\'' +
                '}';
    }
}
