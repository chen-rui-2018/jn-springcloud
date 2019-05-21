package com.jn.hr.employee.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author dt
 * @create 2019-04-19 上午 9:28
 */
@ApiModel(value = "EmployeeBasicInfoPage", description = "员工基本信息分页实体类")
public class EmployeeBasicInfoPage extends Page implements Serializable {
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "职位ID")
    private String jobId;
    @ApiModelProperty(value = "职务ID")
    private String postId;
    @ApiModelProperty(value = "员工类型（1：正式，2：实习生）")
    private String employeeType;
    @ApiModelProperty(value = "部门ID")
    private String departmentId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "EmployeeBasicInfoPage{" +
                "name='" + name + '\'' +
                ", jobId='" + jobId + '\'' +
                ", postId='" + postId + '\'' +
                ", employeeType='" + employeeType + '\'' +
                ", departmentId='" + departmentId + '\'' +
                "} " + super.toString();
    }
}
