package com.jn.enterprise.servicemarket.advisor.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/4/15 17:17
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "EvaluationCountInfo",description = "评价信息统计")
public class EvaluationCountInfo  implements Serializable {
    @ApiModelProperty(value = "好评数")
    private int praiseNum;
    @ApiModelProperty(value = "中评数")
    private int averageNum;
    @ApiModelProperty(value = "差评数")
    private int badReviewNum;
    @ApiModelProperty(value = "评价总数")
    private int evaluationTotal;

    public int getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(int praiseNum) {
        this.praiseNum = praiseNum;
    }

    public int getAverageNum() {
        return averageNum;
    }

    public void setAverageNum(int averageNum) {
        this.averageNum = averageNum;
    }

    public int getBadReviewNum() {
        return badReviewNum;
    }

    public void setBadReviewNum(int badReviewNum) {
        this.badReviewNum = badReviewNum;
    }

    public int getEvaluationTotal() {
        return evaluationTotal;
    }

    public void setEvaluationTotal(int evaluationTotal) {
        this.evaluationTotal = evaluationTotal;
    }

    @Override
    public String toString() {
        return "EvaluationCountInfo{" +
                "praiseNum=" + praiseNum +
                ", averageNum=" + averageNum +
                ", badReviewNum=" + badReviewNum +
                ", evaluationTotal=" + evaluationTotal +
                '}';
    }
}
