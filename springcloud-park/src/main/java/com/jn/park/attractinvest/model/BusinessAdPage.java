package com.jn.park.attractinvest.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 招商信息分页实体
 *
 * @author： shaobao
 * @date： Created on 2019/4/24 16:38
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "BusinessAdPage", description = "招商信息分页实体")
public class BusinessAdPage extends Page implements Serializable {
    private static final long serialVersionUID = -95324539665999831L;

    @ApiModelProperty(value = "园区id", example = "570327211966464000")
    private String parkId;

    @ApiModelProperty(value = "关键字", notes = "对招商信息标题及副标题进行模糊搜索",example = "招商")
    private String keyWords;

    public BusinessAdPage() {
    }

    public BusinessAdPage(String parkId, String keyWords) {
        this.parkId = parkId;
        this.keyWords = keyWords;
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    @Override
    public String toString() {
        return "BusinessAdPage{" +
                "parkId='" + parkId + '\'' +
                ", keyWords='" + keyWords + '\'' +
                '}';
    }
}
