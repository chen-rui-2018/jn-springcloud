package com.jn.enterprise.pd.personnel.vo;

import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 人才中心-市级答辩辅导完成
 *
 * @author： wzy
 * @date： Created on 2019/3/19 16:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel("人才中心-市级答辩辅导完成")
public class PersonnelFlow8050Vo extends PersonnelFlowNodeBaseAbstractVo implements Serializable {

    private static final long serialVersionUID = -5401372578688748890L;

    @Override
    public PersonnelFlowNodeEnum getFlowNodeEnum() {
        return PersonnelFlowNodeEnum.EIGHT_CITY_ANSWER_COUNSEL_50;
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
