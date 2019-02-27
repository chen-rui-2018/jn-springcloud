package com.jn.enterprise.servicemarket.comment.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 提交评论入参
 * @author： jiangyl
 * @date： Created on 2019/2/27 9:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "CommentParameter",description = "提交评论入参")
public class CommentParameter {

    @ApiModelProperty(value = "需求ID")
    private String id;

    @ApiModelProperty(value = "评分")
    private String attitudeScore;

    @ApiModelProperty(value = "评价详情")
    private String evaluationDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAttitudeScore() {
        return attitudeScore;
    }

    public void setAttitudeScore(String attitudeScore) {
        this.attitudeScore = attitudeScore;
    }

    public String getEvaluationDesc() {
        return evaluationDesc;
    }

    public void setEvaluationDesc(String evaluationDesc) {
        this.evaluationDesc = evaluationDesc;
    }
}
