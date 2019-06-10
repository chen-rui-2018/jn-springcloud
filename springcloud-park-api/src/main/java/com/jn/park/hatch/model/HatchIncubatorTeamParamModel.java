package com.jn.park.hatch.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * @author wzy93
 */
@ApiModel(value = "HatchIncubatorTeamParamModel", description = "入孵团队入參实体类")
public class HatchIncubatorTeamParamModel implements Serializable {

    private static final long serialVersionUID = -7611722139369429534L;
    @ApiModelProperty(value = "唯一id【团队ID】",example = "219842749242")
    @NotNull(message = "唯一id【团队ID】不能为空")
    private String id;

    @ApiModelProperty(value = "类型【1：企业，2：团队】",example = "2")
    @NotNull(message = "类型不能为空")
    private String type;

    @ApiModelProperty(value = "团队名称",example = "XX敏捷团队")
    private String name;

    @ApiModelProperty(value = "项目名称",example = "大数据项目")
    private String proName;

    @ApiModelProperty(value = "项目简介",example = "大数据项目。。。")
    private String proSynopsis;

    @ApiModelProperty(value = "是否获得过投融资（1：是2：否）",example = "2")
    private String isFinanc;

    @ApiModelProperty(value = "投融资金额",example = "11.00")
    private BigDecimal financNum;

    @ApiModelProperty(value = "联系人",example = "老王")
    private String contacts;

    @ApiModelProperty(value = "联系电话",example = "13254321234")
    private String phone;

    @ApiModelProperty(value = "电子邮箱",example = "123@qq.com")
    private String email;

    @ApiModelProperty(value = "项目介绍",example = "大数据项目。。。")
    private String proIntroduc;

    @ApiModelProperty(value = "数据来源（1：来源企业库2：来源孵化申请）",example = "1")
    private String dataSources;

    @ApiModelProperty(value = "申请时间", example = "2019-04-20 10:10:00")
    private Date applicationTime;

    @ApiModelProperty(value = "团队管理员账号",example = "wangsong")
    @NotNull(message = "团队管理员账号不能为空")
    private String comAdmin;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProSynopsis() {
        return proSynopsis;
    }

    public void setProSynopsis(String proSynopsis) {
        this.proSynopsis = proSynopsis;
    }

    public String getIsFinanc() {
        return isFinanc;
    }

    public void setIsFinanc(String isFinanc) {
        this.isFinanc = isFinanc;
    }

    public BigDecimal getFinancNum() {
        return financNum;
    }

    public void setFinancNum(BigDecimal financNum) {
        this.financNum = financNum;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProIntroduc() {
        return proIntroduc;
    }

    public void setProIntroduc(String proIntroduc) {
        this.proIntroduc = proIntroduc;
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
}