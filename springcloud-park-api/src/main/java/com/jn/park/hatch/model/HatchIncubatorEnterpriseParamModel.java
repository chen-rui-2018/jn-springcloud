package com.jn.park.hatch.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * @author wzy93
 */
@ApiModel(value = "HatchIncubatorEnterpriseParamModel", description = "入孵企业入參实体类")
public class HatchIncubatorEnterpriseParamModel implements Serializable {

    @ApiModelProperty(value = "唯一id【企业ID】",example = "219842749242")
    @NotNull(message = "唯一id【企业ID】不能为空")
    private String id;

    @ApiModelProperty(value = "类型【1：企业，2：团队】",example = "1")
    @NotNull(message = "类型不能为空")
    private String type;

    @ApiModelProperty(value = "企业logo地址",example = "传url地址")
    private String logoUrl;

    @ApiModelProperty(value = "统一社会信用代码",example = "123454")
    private String creditCode;

    @ApiModelProperty(value = "企业名称",example = "XXX科技公司")
    @NotNull(message = "企业名称不能为空")
    private String enterpriseName;

    @ApiModelProperty(value = "成立时间",  example = "2019-04-20 10:10:00")
    @NotNull(message = "成立时间不能为空")
    private Date establishTime;

    @ApiModelProperty(value = "企业人数",example = "员工总数 100 人，其中博士 20 人，硕士 30 个，本科 40 个，科技活动人员_5人，留学回国人员5人，其他人员0人")
    private String enterPersonHtml;

    @ApiModelProperty(value = "占地面积(平方米)",example = "12.3")
    private Double areaCover;

    @ApiModelProperty(value = "注册资本",example = "1000.00")
    @NotNull(message = "注册资本不能为空")
    private Double regCapital;

    @ApiModelProperty(value = "企业法人",example = "老王")
    @NotNull(message = "企业法人不能为空")
    private String legalPerson;

    @ApiModelProperty(value = "企业团队介绍",example = "本团队组成。。。")
    @NotNull(message = "企业团队介绍不能为空")
    private String teamHtml;

    @ApiModelProperty(value = "生产/研发产品介绍",example = "研发禅产品。。。")
    @NotNull(message = "生产/研发产品介绍不能为空")
    private String productHtml;

    @ApiModelProperty(value = "三证合一或营业执照扫描件",example = "传url地址")
    @NotNull(message = "三证合一或营业执照扫描件不能为空")
    private String licenseUrl;

    @ApiModelProperty(value = "联系人",example = "老王")
    @NotNull(message = "联系人不能为空")
    private String contacts;

    @ApiModelProperty(value = "联系电话",example = "13212344321")
    @NotNull(message = "联系电话不能为空")
    private String phone;

    @ApiModelProperty(value = "企业性质ID",example = "1")
    private String enterpriseNatureId;

    @ApiModelProperty(value = "企业类型ID",example = "1")
    private String enterpriseTypeId;

    @ApiModelProperty(value = "技术来源ID",example = "1")
    private String enterpriseTechId;

    @ApiModelProperty(value = "实际办公地址",example = "白下高新区")
    private String officeLocation;

    @ApiModelProperty(value = "数据来源(1.来源企业库2.来源孵化申请）",example = "1")
    @NotNull(message = "数据来源不能为空")
    private String dataSources;

    @ApiModelProperty(value = "申请时间", example = "2019-04-20 10:10:00")
    @NotNull(message = "申请时间不能为空")
    private Date applicationTime;

    @ApiModelProperty(value = "是否是人才企业（1：是2：否）",example = "2")
    @NotNull(message = "是否是人才企业不能为空")
    private String isTalent;

    @ApiModelProperty(value = "是否是高新企业（1：是2：否）",example = "2")
    @NotNull(message = "是否是高新企业不能为空")
    private String isTech;

    @ApiModelProperty(value = "免租金额",example = "1.00")
    private BigDecimal rentfreeAmount;

    @ApiModelProperty(value = "企业管理员账号",example = "wangsong")
    @NotNull(message = "企业管理员账号不能为空")
    private String comAdmin;

    private static final long serialVersionUID = 1L;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComAdmin() {
        return comAdmin;
    }

    public void setComAdmin(String comAdmin) {
        this.comAdmin = comAdmin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public Date getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(Date establishTime) {
        this.establishTime = establishTime;
    }

    public String getEnterPersonHtml() {
        return enterPersonHtml;
    }

    public void setEnterPersonHtml(String enterPersonHtml) {
        this.enterPersonHtml = enterPersonHtml;
    }

    public Double getAreaCover() {
        return areaCover;
    }

    public void setAreaCover(Double areaCover) {
        this.areaCover = areaCover;
    }

    public Double getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(Double regCapital) {
        this.regCapital = regCapital;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getTeamHtml() {
        return teamHtml;
    }

    public void setTeamHtml(String teamHtml) {
        this.teamHtml = teamHtml;
    }

    public String getProductHtml() {
        return productHtml;
    }

    public void setProductHtml(String productHtml) {
        this.productHtml = productHtml;
    }

    public String getLicenseUrl() {
        return licenseUrl;
    }

    public void setLicenseUrl(String licenseUrl) {
        this.licenseUrl = licenseUrl;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEnterpriseNatureId() {
        return enterpriseNatureId;
    }

    public void setEnterpriseNatureId(String enterpriseNatureId) {
        this.enterpriseNatureId = enterpriseNatureId;
    }

    public String getEnterpriseTypeId() {
        return enterpriseTypeId;
    }

    public void setEnterpriseTypeId(String enterpriseTypeId) {
        this.enterpriseTypeId = enterpriseTypeId;
    }

    public String getEnterpriseTechId() {
        return enterpriseTechId;
    }

    public void setEnterpriseTechId(String enterpriseTechId) {
        this.enterpriseTechId = enterpriseTechId;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public String getDataSources() {
        return dataSources;
    }

    public void setDataSources(String dataSources) {
        this.dataSources = dataSources;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getIsTalent() {
        return isTalent;
    }

    public void setIsTalent(String isTalent) {
        this.isTalent = isTalent;
    }

    public String getIsTech() {
        return isTech;
    }

    public void setIsTech(String isTech) {
        this.isTech = isTech;
    }

    public BigDecimal getRentfreeAmount() {
        return rentfreeAmount;
    }

    public void setRentfreeAmount(BigDecimal rentfreeAmount) {
        this.rentfreeAmount = rentfreeAmount;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}