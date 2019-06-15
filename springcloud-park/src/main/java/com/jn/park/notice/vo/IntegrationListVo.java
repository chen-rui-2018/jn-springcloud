package com.jn.park.notice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: tangry
 * @Date: 2019/6/15
 * @Version 1.0
 */
@ApiModel(value = "IntegrationListVo",description = "PC端整合接口包装VO")
public class IntegrationListVo implements Serializable {

    private static final long serialVersionUID = -5813278981425670766L;

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("内容")
    private String intro;

    @ApiModelProperty("简介")
    private String noticeBiref;

    @ApiModelProperty("是否置顶")
    private String isStick;

    @ApiModelProperty("创建时间")
    private String createdTime;

    @ApiModelProperty("最新更新时间")
    private String modifiedTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getNoticeBiref() {
        return noticeBiref;
    }

    public void setNoticeBiref(String noticeBiref) {
        this.noticeBiref = noticeBiref;
    }

    public String getIsStick() {
        return isStick;
    }

    public void setIsStick(String isStick) {
        this.isStick = isStick;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "IntegrationListVo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", intro='" + intro + '\'' +
                ", noticeBiref='" + noticeBiref + '\'' +
                ", isStick='" + isStick + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                '}';
    }
}
