package com.jn.park.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 活动查询入参Bean
 * @author： jiangyl
 * @date： Created on 2018/12/21 17:26
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ActivityParment",description = "活动查询入参")
public class ActivityParment extends Page {

    @ApiModelProperty("活动分类ID")
    private String actiType;

    @ApiModelProperty("活动状态")
    private String status;

    @ApiModelProperty("活动名称")
    private String actiName;

    @ApiModelProperty("是否首页展示")
    private String isIndex;

    public String getActiType() {
        return actiType;
    }

    public void setActiType(String actiType) {
        this.actiType = actiType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActiName() {
        return actiName;
    }

    public void setActiName(String actiName) {
        this.actiName = actiName;
    }

    public String getIsIndex() {
        return isIndex;
    }

    public void setIsIndex(String isIndex) {
        this.isIndex = isIndex;
    }
}
