package com.jn.park.sp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： huangbq
 * @date： Created on 2019/3/24 22:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "办理材料",description = "业务对应的办理材料")
public class SpPowerBusiMaterialsModel implements Serializable {

    private static final long serialVersionUID = -332644525070242013L;
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("业务ID")
    private String busiId;

    @ApiModelProperty("材料名称")
    private String name;

    @ApiModelProperty("材料样本")
    private String sample;

    @ApiModelProperty("来源渠道")
    private String fromChannel;

    @ApiModelProperty("纸质材料数量（份）")
    private Integer paperQuantity;

    @ApiModelProperty("是否需要电子材料")
    private Integer isNeedElectronic;

    @ApiModelProperty("材料必要性（0非必要，1必要）")
    private Integer isRequired;

    @ApiModelProperty("填报须知")
    private String notice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusiId() {
        return busiId;
    }

    public void setBusiId(String busiId) {
        this.busiId = busiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public String getFromChannel() {
        return fromChannel;
    }

    public void setFromChannel(String fromChannel) {
        this.fromChannel = fromChannel;
    }

    public Integer getPaperQuantity() {
        return paperQuantity;
    }

    public void setPaperQuantity(Integer paperQuantity) {
        this.paperQuantity = paperQuantity;
    }

    public Integer getIsNeedElectronic() {
        return isNeedElectronic;
    }

    public void setIsNeedElectronic(Integer isNeedElectronic) {
        this.isNeedElectronic = isNeedElectronic;
    }

    public Integer getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Integer isRequired) {
        this.isRequired = isRequired;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
