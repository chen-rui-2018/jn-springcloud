package com.jn.park.notice.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/1 15:26
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="NoticeQueryParam",description = "后台公告类表查询条件")
public class NoticeQueryParam extends Page implements Serializable {
    @ApiModelProperty(value="是否首页弹出,(0:无效-1:有效,不给值则返回全部)",example = "1")
    @Pattern(regexp = "^[0-1]$",message = "公告状态-只能为 0 或 1")
    private String noticeStatus;
    @ApiModelProperty(value="是否首页弹出,(0:否-1:是,不给值则返回全部)",example = "0")
    @Pattern(regexp = "^[0-1]$",message = "首页弹出-只能为 0 或 1")
    private String homePopup;
    @ApiModelProperty(value="是否首页展示,(0:否-1:是,,不给值则返回全部)",example = "0")
    @Pattern(regexp = "^[0-1]$",message = "首页展示-只能为 0 或 1")
    private String homeShow;
    @ApiModelProperty(value="关键词,(公告标题/平台名称(app/门户))",example = "公告标题")
    private String keyWord;

    public String getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(String noticeStatus) {
        this.noticeStatus = noticeStatus;
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

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
