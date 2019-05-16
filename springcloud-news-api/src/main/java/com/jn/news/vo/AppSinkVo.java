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
    private String title;
    @ApiModelProperty(value = "推送的目标id列表",required = true)
    @NotBlank(message = "消息发送目标id不能为空")
    private List<String> ids;
    @ApiModelProperty(value = "平台类型 ANDROID/IOS/null  如果为null(不给值) 则发送给所有平台")
    private String platfromType;

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

    public String getPlatfromType() {
        return platfromType;
    }

    public void setPlatfromType(String platfromType) {
        this.platfromType = platfromType;
    }

    @Override
    public String toString() {
        return "AppSinkVo{" +
                "content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", ids=" + ids +
                ", platfromType=" + platfromType +
                '}';
    }
}
