package com.jn.park.notice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * @author： chenr
 * @date： Created on 2019/3/29 18:00
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "NoticeModifyParam",description = "公告修改入参")
public class NoticeModifyParam implements Serializable {
    @ApiModelProperty(value="公告id",required = true,example = "00000000000000001111111111111111")
    @NotBlank(message = "公告id不能为空")
    private String noticeId;
    @ApiModelProperty(value="公告编号",required = true,example = "GGBH123456")
    @NotBlank(message = "公告编号不能为空")
    private String noticeSerial;
    @ApiModelProperty(value="公告标题",required = true,example = "公告标题")
    @NotBlank(message = "公告标题不能为空")
    private String noticeTitle;
    @ApiModelProperty(value="生效时间",required = true,example = "2019-03-29")
    @NotBlank(message = "生效时间不能为空")
    @Pattern(regexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))$",
            message = "日期格式不正确,正确格式:yyyy-MM-dd")
    private String startTime;
    @ApiModelProperty(value="失效时间",required = true,example = "2019-04-29")
    @NotBlank(message = "失效时间不能为空")
    @Pattern(regexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))$",
            message = "日期格式不正确,正确格式:yyyy-MM-dd")
    private String endTime;
    @ApiModelProperty(value="是否首页弹出,(0:否-1:是)",required = true,example = "0")
    @NotBlank(message = "是否首页弹出不能为空")
    @Pattern(regexp = "^[0-1]$")
    private String homePopup;
    @ApiModelProperty(value="是否首页展示,(0:否-1:是)",required = true,example = "0")
    @NotBlank(message = "是否首页展示不能为空")
    @Pattern(regexp = "^[0-1]$")
    private String homeShow;
    @ApiModelProperty(value="平台类型(P001:全部-P002:App-P003:门户)",required = true,example = "P002")
    @NotBlank(message = "平台类型不能为空")
    @Pattern(regexp = "^P00[1-3]$",message = "平台类型-只能为 P001 或  P002 或  P003")
    private String platformType;
    @ApiModelProperty(value="平台类型名称(全部/App/门户)",required = true,example = "App")
    @NotBlank(message = "平台类型名称不能为空")
    private String platformName;
    @ApiModelProperty(value="公告内容",required = true,example = "公告内容...")
    @NotBlank(message = "公告内容不能为空")
    private String noticeDetails;
    @ApiModelProperty(value="排序字段,用于公告的默认,1,2,3,4",example = "1")
    @NotBlank(message = "排序字段的值不能为空")
    private String sortField;

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeSerial() {
        return noticeSerial;
    }

    public void setNoticeSerial(String noticeSerial) {
        this.noticeSerial = noticeSerial;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getHomePopup() {
        return homePopup;
    }

    public void setHomePopup(String homePopup) {
        this.homePopup = homePopup;
    }

    public String getHomeShow() {
        return homeShow;
    }

    public void setHomeShow(String homeShow) {
        this.homeShow = homeShow;
    }

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }

    public String getNoticeDetails() {
        return noticeDetails;
    }

    public void setNoticeDetails(String noticeDetails) {
        this.noticeDetails = noticeDetails;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    @Override
    public String toString() {
        return "NoticeModifyParam{" +
                "noticeId='" + noticeId + '\'' +
                ", noticeSerial='" + noticeSerial + '\'' +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", homePopup='" + homePopup + '\'' +
                ", homeShow='" + homeShow + '\'' +
                ", platformType='" + platformType + '\'' +
                ", platformName='" + platformName + '\'' +
                ", noticeDetails='" + noticeDetails + '\'' +
                ", sortField='" + sortField + '\'' +
                '}';
    }
}
