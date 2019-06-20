package com.jn.oa.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 附件下载实体
 *
 * @author： shaobao
 * @date： Created on 2019/3/14 22:03
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "DownAttachment", description = "附件下载实体")
public class DownAttachment implements Serializable {

    private static final long serialVersionUID = 2340333746986485120L;

    @ApiModelProperty(value = "附件名称",example = "a.txt")
    @NotNull(message = "文件名称不能为空")
    private String title;

    @ApiModelProperty(value = "路径",
            example = "http://192.168.10.20:2020/group2/M00/00/23/wKgKFFyKUjuABMFzAAAABY3cYbI792.txt")
    @NotNull(message = "文件路径不能为空")
    private String url;

    public DownAttachment() {
    }

    public DownAttachment(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "DownAttachment{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
