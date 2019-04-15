package com.jn.park.gamtopic.model;

import com.jn.park.fileimg.model.FileImg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/10 11:20
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DynamicAddParam",description = "发布动态入参")
public class DynamicAddParam implements Serializable {
    @ApiModelProperty(value = "动态类容",required = true,example = "人生就有许多这样的奇迹，看似比登天还难的事...")
    @NotBlank(message="话题类容不能为空")
    private String topicContent;
    @ApiModelProperty(value = "动态类型 1公开2关注可看3私密",example = "1",required = true)
    @Pattern(regexp="^[1-3]$",message = "动态类型的值 只能为 1-3")
    @NotBlank(message="动态类型不能为空")
    private String topicType;
    @ApiModelProperty(value = "文件")
    private List<FileImg> imgs;
    @ApiModelProperty(value = "发布动态的地址",example = "南京市白下园区")
    private String address;
    @ApiModelProperty(value = "经度",example = "10.000")
    private String longitude;
    @ApiModelProperty(value = "纬度",example = "51.222")
    private String latitude;
    @ApiModelProperty(value = "发布身份,1:企业-0:个人 ",example = "1")
    @Pattern(regexp="^[0-1]$",message = "发布身份的值 只能为 0或1")
    @NotBlank(message="发布身份不能为空")
    private String identity;

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    public List<FileImg> getImgs() {
        return imgs;
    }

    public void setImgs(List<FileImg> imgs) {
        this.imgs = imgs;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
