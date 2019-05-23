package com.jn.hr.employee.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author dt
 * @create 2019-04-23 下午 2:51
 */
@ApiModel(value = "HolidayRuleAdd", description = "假期规则实体")
public class HolidayRuleAdd implements Serializable {
    @ApiModelProperty(value = "规则ID")
    private String ruleId;
    @ApiModelProperty(value = "已满多少年（默认初始值为0）")
    private Integer reachedYear;
    @ApiModelProperty(value = "未满多少年（默认初始值为999）")
    private Integer notFullYear;
    @ApiModelProperty(value = "年休假")
    @NotNull(message="年休假不能为空")
    private Integer annualLeave;

    public Integer getReachedYear() {
        return reachedYear;
    }

    public void setReachedYear(Integer reachedYear) {
        this.reachedYear = reachedYear;
    }

    public Integer getNotFullYear() {
        return notFullYear;
    }

    public void setNotFullYear(Integer notFullYear) {
        this.notFullYear = notFullYear;
    }

    public Integer getAnnualLeave() {
        return annualLeave;
    }

    public void setAnnualLeave(Integer annualLeave) {
        this.annualLeave = annualLeave;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    @Override
    public String toString() {
        return "HolidayRuleAdd{" +
                "ruleId='" + ruleId + '\'' +
                ", reachedYear=" + reachedYear +
                ", notFullYear=" + notFullYear +
                ", annualLeave=" + annualLeave +
                '}';
    }
}
