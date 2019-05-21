package com.jn.hr.employee.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author dt
 * @create 2019-04-15 上午 10:47
 */
@ApiModel(value = "ResumeDatabasePage", description = "简历库分页实体类")
public class ResumeDatabasePage extends Page implements Serializable {
    @ApiModelProperty(value = "学历ID", example = "1")
    private String educationId;

    @ApiModelProperty(value = "是否完成背景调查（1：是 2：否）")
    private Byte isBackgroundInvest;

    @ApiModelProperty(value = "应聘结果（1：通过，2：淘汰，3：等待结果）")
    private Byte applicationResult;
    @ApiModelProperty(value = "姓名")
    private String name;

    public String getEducationId() {
        return educationId;
    }

    public void setEducationId(String educationId) {
        this.educationId = educationId;
    }

    public Byte getIsBackgroundInvest() {
        return isBackgroundInvest;
    }

    public void setIsBackgroundInvest(Byte isBackgroundInvest) {
        this.isBackgroundInvest = isBackgroundInvest;
    }

    public Byte getApplicationResult() {
        return applicationResult;
    }

    public void setApplicationResult(Byte applicationResult) {
        this.applicationResult = applicationResult;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
