package com.jn.oa.item.vo;

import com.jn.oa.item.entity.TbOaWorkPlan;
import com.jn.oa.item.model.WorkPlanRemain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 用于工作计划提醒实体
 *
 * @author： shaobao
 * @date： Created on 2019/3/20 17:45
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "WorkPlanRemindUserVO", description = "用于工作计划提醒实体")
public class WorkPlanRemindUserVO implements Serializable {

    private static final long serialVersionUID = -5790530775267952940L;
    @ApiModelProperty(value = "用户id")
    private String userId;
    @ApiModelProperty(value = "用户邮箱")
    private String email;
    @ApiModelProperty(value = "工作计划集合")
    private List<WorkPlanRemain> workPlanRemainList;

    public WorkPlanRemindUserVO() {
    }

    public WorkPlanRemindUserVO(String userId, String email, List<WorkPlanRemain> workPlanRemainList) {
        this.userId = userId;
        this.email = email;
        this.workPlanRemainList = workPlanRemainList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<WorkPlanRemain> getWorkPlanRemainList() {
        return workPlanRemainList;
    }

    public void setWorkPlanRemainList(List<WorkPlanRemain> workPlanRemainList) {
        this.workPlanRemainList = workPlanRemainList;
    }

    @Override
    public String toString() {
        return "WorkPlanRemindUserVO{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", workPlanRemainList=" + workPlanRemainList +
                '}';
    }
}
