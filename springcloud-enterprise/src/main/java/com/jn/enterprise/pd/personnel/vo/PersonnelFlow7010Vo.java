package com.jn.enterprise.pd.personnel.vo;

import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 人才中心-上传人才申报书模板
 *
 * @author： wzy
 * @date： Created on 2019/3/19 16:17
 * @version： v1.0
 * @modified By:
 */
@ApiModel("人才中心-上传人才申报书模板")
public class PersonnelFlow7010Vo extends PersonnelFlowNodeBaseAbstractVo implements Serializable {
    private static final long serialVersionUID = -1749652387846931151L;

    @Override
    public PersonnelFlowNodeEnum getFlowNodeEnum() {
        return PersonnelFlowNodeEnum.SEVEN_CITY_PLAN_COUNSEL_10;
    }

    @ApiModelProperty("唯一标识符")
    private Integer id;

    @ApiModelProperty("文件路径")
    private String fileUrl;

    @ApiModelProperty("文件名称")
    private String fileName;

    @ApiModelProperty("文件类型('营业执照','其他资质荣誉','项目介绍书','人才申报书模板','人才申报书','区级答辩辅导材料','注册落户')")
    private String fileType;

    @ApiModelProperty("项目ID")
    private Integer projectId;

    @ApiModelProperty("业务表ID")
    private String businessTableId;

    @ApiModelProperty("业务表名称")
    private String businessTableName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getBusinessTableId() {
        return businessTableId;
    }

    public void setBusinessTableId(String businessTableId) {
        this.businessTableId = businessTableId;
    }

    public String getBusinessTableName() {
        return businessTableName;
    }

    public void setBusinessTableName(String businessTableName) {
        this.businessTableName = businessTableName;
    }
}
