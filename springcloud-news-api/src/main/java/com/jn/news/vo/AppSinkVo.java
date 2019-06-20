package com.jn.news.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/5/11 17:30
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value ="AppSinkVo",description = "极光app消息推送入参")
public class AppSinkVo implements Serializable {

    private static final long serialVersionUID = -577642681757881257L;
    @ApiModelProperty(value = "推送的消息内容",required = true,example = "today ....")
    @NotBlank(message = "消息内容不能为空")
    private String content;
    @ApiModelProperty(value = "推送的消息标题")
    @NotBlank(message = "消息标题不能为空")
    private String title;
    @ApiModelProperty(value = "推送的目标列表",required = true)
    private List<String> ids;
    @ApiModelProperty(value = "推送方式（DEVICE：设备 TAG：标签）", required = true)
    @NotBlank(message = "推送方式不能为空")
    private String pushType;
    @ApiModelProperty(value = "平台类型 ANDROID/IOS/null  如果为null(不给值) 则发送给所有平台")
    private String platFromType;
    @ApiModelProperty(value = "推送通知类型（ALL：全部 NOTICE：通知 MESSAGE：透传消息）", required = true)
    private String noticeType;
    @ApiModelProperty(value = "透传消息内容（用户APP处理业务）", required = true)
    private String message;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
    }

    public String getPlatFromType() {
        return platFromType;
    }

    public void setPlatFromType(String platFromType) {
        this.platFromType = platFromType;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AppSinkVo{" +
                "content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", ids=" + ids +
                ", pushType='" + pushType + '\'' +
                ", platFromType='" + platFromType + '\'' +
                ", noticeType='" + noticeType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
