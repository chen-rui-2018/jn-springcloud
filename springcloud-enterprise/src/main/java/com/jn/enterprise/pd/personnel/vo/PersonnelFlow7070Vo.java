package com.jn.enterprise.pd.personnel.vo;

import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 人才中心-市级计划书辅导完成
 *
 * @author： wzy
 * @date： Created on 2019/3/19 16:18
 * @version： v1.0
 * @modified By:
 */
@ApiModel("人才中心-市级计划书辅导完成")
public class PersonnelFlow7070Vo extends PersonnelFlowNodeBaseAbstractVo implements Serializable {

    private static final long serialVersionUID = -2919623996753222126L;

    @Override
    public PersonnelFlowNodeEnum getFlowNodeEnum() {
        return PersonnelFlowNodeEnum.SEVEN_CITY_PLAN_COUNSEL_70;
    }

    @ApiModelProperty("唯一标识符")
    private Integer id;

    @ApiModelProperty("辅导名称")
    private String coachName;

    @ApiModelProperty("辅导专家")
    private String counselSpecialist;

    @ApiModelProperty("辅导打分")
    private BigDecimal counselScore;

    @ApiModelProperty("项目ID")
    private Integer projectId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getCounselSpecialist() {
        return counselSpecialist;
    }

    public void setCounselSpecialist(String counselSpecialist) {
        this.counselSpecialist = counselSpecialist;
    }

    public BigDecimal getCounselScore() {
        return counselScore;
    }

    public void setCounselScore(BigDecimal counselScore) {
        this.counselScore = counselScore;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
