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

    @ApiModelProperty(value = "活动分类ID",example = "a29e14a21352473ebf26420ddffb1c60")
    private String actiType;

    @ApiModelProperty(value = "活动状态（1草稿 2报名中 3活动结束4活动取消）",example = "1")
    private String actiStatus;

    @ApiModelProperty(value = "活动名称",example = "测试活动")
    private String actiName;

    @ApiModelProperty(value = "是否首页展示（0：否，1：是）",example = "1")
    private String isIndex;

    public String getActiType() {
        return actiType;
    }

    public void setActiType(String actiType) {
        this.actiType = actiType;
    }

    public String getActiStatus() {
        return actiStatus;
    }

    public void setActiStatus(String actiStatus) {
        this.actiStatus = actiStatus;
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
