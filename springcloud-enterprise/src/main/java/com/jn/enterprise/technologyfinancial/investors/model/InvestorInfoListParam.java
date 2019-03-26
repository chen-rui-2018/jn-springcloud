package com.jn.enterprise.technologyfinancial.investors.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/9 16:42
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "InvestorInfoListParam", description = "科技金融投资人列表查询入参")
public class InvestorInfoListParam extends Page implements Serializable {
    @ApiModelProperty(value = "主投领域id",example = "technology_financial")
    private String mainCode;
    @ApiModelProperty(value = "关键字",example = "测试")
    private String keyWords;
    @ApiModelProperty(value = "是否需要分页  1:分页   0:不分页",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

    public String getMainCode() {
        return mainCode;
    }

    public void setMainCode(String mainCode) {
        this.mainCode = mainCode;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }
}
