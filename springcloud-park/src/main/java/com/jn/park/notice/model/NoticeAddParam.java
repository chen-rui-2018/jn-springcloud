package com.jn.park.notice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * @author： chenr
 * @date： Created on 2019/3/29 17:07
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "NoticeAddParam",description = "发布(新增)公告入参")
public class NoticeAddParam implements Serializable {
    @ApiModelProperty(value="公告编号",required = true,example = "GGBH123456")
    @NotBlank(message = "公告编号不能为空")
    private String noticeSerial;
    @ApiModelProperty(value="公告标题",required = true,example = "公告标题")
    @NotBlank(message = "公告标题不能为空")
    private String noticeTitle;
    @ApiModelProperty(value="生效时间",required = true,example = "2019-03-29")
    @NotBlank(message = "生效时间不能为空")
    @Pattern(regexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))$",
            message = "日期格式不正确,正确格式:yyyy-MM-dd HH:mm:ss")
    private String startTime;
    @ApiModelProperty(value="失效时间",required = true,example = "2019-04-29")
    @NotBlank(message = "失效时间不能为空")
    @Pattern(regexp = "^^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))$",
            message = "日期格式不正确,正确格式:yyyy-MM-dd HH:mm:ss")
    private String  endTime;
    @ApiModelProperty(value="是否首页弹出,(0:否-1:是)",required = true,example = "0")
    @NotBlank(message = "是否首页弹出不能为空")
    @Pattern(regexp = "^[0-1]$",message = "首页弹出-只能为 0 或 1")
    private String homePopup;
    @ApiModelProperty(value="是否首页展示,(0:否-1:是)",required = true,example = "0")
    @NotBlank(message = "是否首页展示不能为空")
    @Pattern(regexp = "^[0-1]$",message = "首页展示-只能为 0 或 1")
    private String homeShow;
    @ApiModelProperty(value="平台类型(0:全部-1:app-2:门户)",required = true,example = "0")
    @NotBlank(message = "平台类型不能为空")
    @Pattern(regexp = "^[0-2]$",message = "平台类型-只能为 0 或 1 或 2")
    private String platformType;
    @ApiModelProperty(value="公告内容",required = true,example = "公告内容...")
    @NotBlank(message = "公告内容不能为空")
    private String noticeContent;
    @ApiModelProperty(value="排序字段,用于公告的默认,1,2,3,4",example = "1")
    @NotBlank(message = "排序字段的值不能为空")
    private String sortField;

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
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
}
