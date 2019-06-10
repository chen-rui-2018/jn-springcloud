package com.jn.enterprise.propaganda.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/4/30 9:38
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "BusinessHomePageParam", description = "门户各首页宣传信息入参")
public class BusinessHomePageParam extends Page implements Serializable {
    @ApiModelProperty(value = "宣传类型（用户中心--企业宣传--获取宣传类型接口）",example = "business_promotion")
    private String propagandaType;
    @ApiModelProperty(value = "是否需要分页  1:分页   0:不分页",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;
    @ApiModelProperty(value = "宣传区域[不传查询全部](top:顶部 central:中部 bottom:底部)", example = "top")
    @Pattern(regexp = "^(top)|(central)|(bottom)$", message = "宣传区域传参错误")
    private String propagandaArea;
    @ApiModelProperty(value = "发布平台(1:App 2:门户)", required = true, example = "2")
    @Pattern(regexp = "^[12]$", message = "宣传区域传参错误")
    private String issuePlatform;

    public String getPropagandaArea() {
        return propagandaArea;
    }

    public void setPropagandaArea(String propagandaArea) {
        this.propagandaArea = propagandaArea;
    }

    public String getIssuePlatform() {
        return issuePlatform;
    }

    public void setIssuePlatform(String issuePlatform) {
        this.issuePlatform = issuePlatform;
    }

    public String getPropagandaType() {
        return propagandaType;
    }

    public void setPropagandaType(String propagandaType) {
        this.propagandaType = propagandaType;
    }

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }
}
