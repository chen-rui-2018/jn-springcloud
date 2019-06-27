package com.jn.park.attractinvest.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.park.attractinvest.entity.TbProjectEnterDetails;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 招商管理-项目管理实体Vo
 *
 * @author： shaobao
 * @date： Created on 2019/6/10 9:55
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "ProjectInfoVo", description = "招商管理-项目管理实体Vo")
public class ProjectInfoVo implements Serializable {
    private static final long serialVersionUID = -5594012591498766057L;

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "公司id")
    private String companyId;

    @ApiModelProperty(value = "租赁信息")
    private String rentInfo;

    @ApiModelProperty(value = "预计入驻时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date expectEnterTime;

    @ApiModelProperty(value = "确认时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sureTime;

    @ApiModelProperty(value = "审批意见")
    private String approvalOpioion;

    @ApiModelProperty(value = "法人")
    private String legalPersoner;

    @ApiModelProperty(value = "法人联系方式")
    private String legalPhone;

    @ApiModelProperty(value = "企业管理员账号")
    private String comAdmin;

    @ApiModelProperty(value = "联系人")
    private String linker;

    @ApiModelProperty(value = "联系电话")
    private String linkerPhone;

    @ApiModelProperty(value = "企业性质")
    private String enterpriseProperty;

    @ApiModelProperty(value = "产业领域名字")
    private String industryTypeName;

    @ApiModelProperty(value = "产业领域")
    private String industryType;

    @ApiModelProperty(value = "租房开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date rentStartTime;

    @ApiModelProperty(value = "租赁期限")
    private Integer rentMonthNum;

    @ApiModelProperty(value = "租房截止时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date comEntTime;

    @ApiModelProperty(value = "备注")
    private String remerk;

    @ApiModelProperty(value = "主体楼宇id")
    private String mainTowerId;

    @ApiModelProperty(value = "企业入驻租赁信息详情")
    private List<TbProjectEnterDetails> tb_project_enter_details;

    public ProjectInfoVo() {
    }

    public ProjectInfoVo(String id, String companyName, String companyId, String rentInfo, Date expectEnterTime,
                         Date sureTime, String approvalOpioion, String legalPersoner, String legalPhone,
                         String comAdmin, String linker, String linkerPhone, String enterpriseProperty,
                         String industryTypeName, String industryType, Date rentStartTime, Integer rentMonthNum,
                         Date comEntTime, String remerk, String mainTowerId,
                         List<TbProjectEnterDetails> tb_project_enter_details) {
        this.id = id;
        this.companyName = companyName;
        this.companyId = companyId;
        this.rentInfo = rentInfo;
        this.expectEnterTime = expectEnterTime;
        this.sureTime = sureTime;
        this.approvalOpioion = approvalOpioion;
        this.legalPersoner = legalPersoner;
        this.legalPhone = legalPhone;
        this.comAdmin = comAdmin;
        this.linker = linker;
        this.linkerPhone = linkerPhone;
        this.enterpriseProperty = enterpriseProperty;
        this.industryTypeName = industryTypeName;
        this.industryType = industryType;
        this.rentStartTime = rentStartTime;
        this.rentMonthNum = rentMonthNum;
        this.comEntTime = comEntTime;
        this.remerk = remerk;
        this.mainTowerId = mainTowerId;
        this.tb_project_enter_details = tb_project_enter_details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getRentInfo() {
        return rentInfo;
    }

    public void setRentInfo(String rentInfo) {
        this.rentInfo = rentInfo;
    }

    public Date getExpectEnterTime() {
        return expectEnterTime;
    }

    public void setExpectEnterTime(Date expectEnterTime) {
        this.expectEnterTime = expectEnterTime;
    }

    public Date getSureTime() {
        return sureTime;
    }

    public void setSureTime(Date sureTime) {
        this.sureTime = sureTime;
    }

    public String getApprovalOpioion() {
        return approvalOpioion;
    }

    public void setApprovalOpioion(String approvalOpioion) {
        this.approvalOpioion = approvalOpioion;
    }

    public String getLegalPersoner() {
        return legalPersoner;
    }

    public void setLegalPersoner(String legalPersoner) {
        this.legalPersoner = legalPersoner;
    }

    public String getLegalPhone() {
        return legalPhone;
    }

    public void setLegalPhone(String legalPhone) {
        this.legalPhone = legalPhone;
    }

    public String getComAdmin() {
        return comAdmin;
    }

    public void setComAdmin(String comAdmin) {
        this.comAdmin = comAdmin;
    }

    public String getLinker() {
        return linker;
    }

    public void setLinker(String linker) {
        this.linker = linker;
    }

    public String getLinkerPhone() {
        return linkerPhone;
    }

    public void setLinkerPhone(String linkerPhone) {
        this.linkerPhone = linkerPhone;
    }

    public String getEnterpriseProperty() {
        return enterpriseProperty;
    }

    public void setEnterpriseProperty(String enterpriseProperty) {
        this.enterpriseProperty = enterpriseProperty;
    }

    public String getIndustryTypeName() {
        return industryTypeName;
    }

    public void setIndustryTypeName(String industryTypeName) {
        this.industryTypeName = industryTypeName;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public Date getRentStartTime() {
        return rentStartTime;
    }

    public void setRentStartTime(Date rentStartTime) {
        this.rentStartTime = rentStartTime;
    }

    public Integer getRentMonthNum() {
        return rentMonthNum;
    }

    public void setRentMonthNum(Integer rentMonthNum) {
        this.rentMonthNum = rentMonthNum;
    }

    public Date getComEntTime() {
        return comEntTime;
    }

    public void setComEntTime(Date comEntTime) {
        this.comEntTime = comEntTime;
    }

    public String getRemerk() {
        return remerk;
    }

    public void setRemerk(String remerk) {
        this.remerk = remerk;
    }

    public String getMainTowerId() {
        return mainTowerId;
    }

    public void setMainTowerId(String mainTowerId) {
        this.mainTowerId = mainTowerId;
    }

    public List<TbProjectEnterDetails> getTb_project_enter_details() {
        return tb_project_enter_details;
    }

    public void setTb_project_enter_details(List<TbProjectEnterDetails> tb_project_enter_details) {
        this.tb_project_enter_details = tb_project_enter_details;
    }

    @Override
    public String toString() {
        return "ProjectInfoVo{" +
                "id='" + id + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyId='" + companyId + '\'' +
                ", rentInfo='" + rentInfo + '\'' +
                ", expectEnterTime=" + expectEnterTime +
                ", sureTime=" + sureTime +
                ", approvalOpioion='" + approvalOpioion + '\'' +
                ", legalPersoner='" + legalPersoner + '\'' +
                ", legalPhone='" + legalPhone + '\'' +
                ", comAdmin='" + comAdmin + '\'' +
                ", linker='" + linker + '\'' +
                ", linkerPhone='" + linkerPhone + '\'' +
                ", enterpriseProperty='" + enterpriseProperty + '\'' +
                ", industryTypeName='" + industryTypeName + '\'' +
                ", industryType='" + industryType + '\'' +
                ", rentStartTime=" + rentStartTime +
                ", rentMonthNum=" + rentMonthNum +
                ", comEntTime=" + comEntTime +
                ", remerk='" + remerk + '\'' +
                ", mainTowerId='" + mainTowerId + '\'' +
                ", tb_project_enter_details=" + tb_project_enter_details +
                '}';
    }
}
