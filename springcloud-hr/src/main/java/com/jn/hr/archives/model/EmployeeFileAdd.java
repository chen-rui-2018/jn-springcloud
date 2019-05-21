package com.jn.hr.archives.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author dt
 * @create 2019-04-16 下午 6:59
 */
@ApiModel(value = "EmployeeFile", description = "员工档案添加实体")
public class EmployeeFileAdd implements Serializable {
    @ApiModelProperty(value = "唯一标识符")
    private String fileId;
    @ApiModelProperty(value = "分类ID",required = true)
    @NotNull(message = "分类ID不能为空")
    private String classId;
    @ApiModelProperty(value = "分类名称",required = true)
    @NotNull(message = "分类名称不能为空")
    private String nodeName;
    @ApiModelProperty(value = "文号",required = true)
    @NotNull(message = "文号不能为空")
    private String symbol;
    @ApiModelProperty(value = "题名",required = true)
    @NotNull(message = "题名不能为空")
    private String titleName;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "责任人",required = true)
    @NotNull(message = "责任人不能为空")
    private String personLiable;
    @ApiModelProperty(value = "附件管理")
    private String accessoryManagement;
    @ApiModelProperty(value = "是否删除（0标记删除，1正常）")
    private Byte recordStatus;
    @ApiModelProperty(value = "登记部门",required = true)
    @NotNull(message = "登记部门不能为空")
    private String regDepartment;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPersonLiable() {
        return personLiable;
    }

    public void setPersonLiable(String personLiable) {
        this.personLiable = personLiable;
    }

    public String getAccessoryManagement() {
        return accessoryManagement;
    }

    public void setAccessoryManagement(String accessoryManagement) {
        this.accessoryManagement = accessoryManagement;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }


    public String getRegDepartment() {
        return regDepartment;
    }

    public void setRegDepartment(String regDepartment) {
        this.regDepartment = regDepartment;
    }

    @Override
    public String toString() {
        return "EmployeeFileAdd{" +
                "fileId='" + fileId + '\'' +
                ", classId='" + classId + '\'' +
                ", nodeName='" + nodeName + '\'' +
                ", symbol='" + symbol + '\'' +
                ", titleName='" + titleName + '\'' +
                ", remark='" + remark + '\'' +
                ", personLiable='" + personLiable + '\'' +
                ", accessoryManagement='" + accessoryManagement + '\'' +
                ", recordStatus=" + recordStatus +
                ", regDepartment='" + regDepartment + '\'' +
                '}';
    }

    /*public static void main(String[] args) throws Exception{
        EmployeeFileAdd employeeFileAdd=new EmployeeFileAdd();
        employeeFileAdd.setClassId("d72e2a09-dd97-40aa-ab3a-097699395e07");
        employeeFileAdd.setNodeName("教育");
        employeeFileAdd.setSymbol("一号");
        employeeFileAdd.setTitleName("标题1");
        employeeFileAdd.setRemark("备注1");
        employeeFileAdd.setPersonLiable("责任人1");
        employeeFileAdd.setAccessoryManagement("");
        employeeFileAdd.setRegDepartment("开发部");
        System.out.println(JSON.toJSONString(employeeFileAdd));
        String a="%E7%86%8A%E7%8C%AB1";
        String b= URLDecoder.decode(a,"utf-8");
        System.out.println(b);

    }*/
}
