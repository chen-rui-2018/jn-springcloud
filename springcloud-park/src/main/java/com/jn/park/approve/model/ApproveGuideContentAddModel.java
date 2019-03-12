package com.jn.park.approve.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author： huangbq
 * @date： Created on 2019/3/12 16:58
 * @version： v1.0
 * @modified By:
 */
@ApiModel("指南内容发布")
public class ApproveGuideContentAddModel extends ApproveGuideTypeAddModel{

    @ApiModelProperty(value = "详细信息",example = "【法律】 《中华人民共和国律师法》 第十八条 设立律师事务所，应当向设区的市级或者直辖市的区人民政府司法行政部门提出申请，受理申请的部门应当自受理之日起二十日内予以审查，并将审查意见和全部申请材料报送省、自治区、直辖市人民政府司法行政部门。省、自治区、直辖市人民政府司法行政部门应当自收到报送材料之日起十日内予以审核，作出是否准予设立的决定。准予设立的，向申请人颁发律...")
    private String detail;

    @ApiModelProperty(value = "字数",example = "233")
    private String wordCount;

    @ApiModelProperty("事项描述")
    private String description;

    @ApiModelProperty(value = "18个工作日")
    private Integer dealDays;

    @ApiModelProperty(value = "受理地址",example = "南京市鼓楼区北京西路28号/各市县司法部门公布的办公地址")
    private String dealAddress;

    @ApiModelProperty(value = "受理时间",example = "春秋冬季（10月～7月14日）：上午8:30～11:30；下午13:30～17:00。夏季（7月15日～9月30日）:上午8:30～11:30；下午15:00～18:00")
    private String dealTime;

    @ApiModelProperty("是否支持在线留言受理方式(0不支持，1支持)")
    private Byte isDealModelOfMessage;

    @ApiModelProperty("是否支持QQ群受理方式(0不支持，1支持)")
    private Byte isDealModelOfQqGroup;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getWordCount() {
        return wordCount;
    }

    public void setWordCount(String wordCount) {
        this.wordCount = wordCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDealDays() {
        return dealDays;
    }

    public void setDealDays(Integer dealDays) {
        this.dealDays = dealDays;
    }

    public String getDealAddress() {
        return dealAddress;
    }

    public void setDealAddress(String dealAddress) {
        this.dealAddress = dealAddress;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
    }

    public Byte getIsDealModelOfMessage() {
        return isDealModelOfMessage;
    }

    public void setIsDealModelOfMessage(Byte isDealModelOfMessage) {
        this.isDealModelOfMessage = isDealModelOfMessage;
    }

    public Byte getIsDealModelOfQqGroup() {
        return isDealModelOfQqGroup;
    }

    public void setIsDealModelOfQqGroup(Byte isDealModelOfQqGroup) {
        this.isDealModelOfQqGroup = isDealModelOfQqGroup;
    }
}
