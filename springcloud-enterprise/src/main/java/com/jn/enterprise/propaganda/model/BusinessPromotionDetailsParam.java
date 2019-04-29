package com.jn.enterprise.propaganda.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/4/18 15:46
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "BusinessPromotionDetailsParam", description = "企业宣传详情入参")
public class BusinessPromotionDetailsParam implements Serializable {
    @ApiModelProperty(value = "宣传id(新增时不传，修改时必传)",example="xxx123")
    private String id;
    @ApiModelProperty(value = "发布平台(1：APP  2:门户  3：其他...)",required = true,example="2")
    @NotNull(message="发布平台不能为空")
    @Pattern(regexp = "^[0-9]$",message = "issuePlatform:只能输入0-9的数字")
    private String issuePlatform;
    @ApiModelProperty(value = "宣传类型(宣传类型接口的code值)",required = true,example="xxx321")
    @NotNull(message="宣传类型不能为空")
    private String propagandaType;
    @ApiModelProperty(value = "生效日期",required = true,example = "2019-04-05")
    @Pattern(regexp = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-" +
            "(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})" +
            "(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)",
            message = "{effectiveDate:'生效日期格式错误'}")
    private String effectiveDate;
    @ApiModelProperty(value = "失效日期",required = true,example = "2019-05-05")
    @Pattern(regexp = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-" +
            "(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})" +
            "(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)",
            message = "{effectiveDate:'生效日期格式错误'}")
    private String invalidDate;
    @ApiModelProperty(value = "宣传产品/宣传标题",required = true,example = "xxx产品")
    @NotNull(message="宣传产品不能为空")
    private String propagandaTitle;
    @ApiModelProperty(value = "宣传详情",required = true,example = "xxx详情")
    @NotNull(message="宣传详情不能为空")
    private String propagandaDetails;
    @ApiModelProperty(value = "宣传区域(top:顶部  central:中部     bottom:底部)",required = true,example = "top")
    @NotNull(message="宣传区域不能为空")
    private String propagandaArea;
    @ApiModelProperty(value = "宣传区域Url",required = true,example = "xxx/top.jpg")
    @NotNull(message="宣传区域Url不能为空")
    private String propagandaAreaUrl;
    @ApiModelProperty(value = "宣传海报",required = true,example = "xxx/123.png")
    @NotNull(message="宣传海报不能为空")
    private String posterUrl;
    @ApiModelProperty(value = "宣传费用规则编码",required = true,example = "xxx123")
    @NotNull(message="宣传费用规则编码不能为空")
    private String proFeeRuleCode;
    @ApiModelProperty(value = "宣传费用",required = true,example = "50")
    @NotNull(message="宣传费用不能为空")
    @Pattern(regexp = "^([0-9]*)(\\.[0-9]{0,2})$",message = "issuePlatform:只能输入的数字和小数点")
    private String propagandaFee;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getInvalidDate() {
        return invalidDate;
    }

    public void setInvalidDate(String invalidDate) {
        this.invalidDate = invalidDate;
    }

    public String getPropagandaTitle() {
        return propagandaTitle;
    }

    public void setPropagandaTitle(String propagandaTitle) {
        this.propagandaTitle = propagandaTitle;
    }

    public String getPropagandaDetails() {
        return propagandaDetails;
    }

    public void setPropagandaDetails(String propagandaDetails) {
        this.propagandaDetails = propagandaDetails;
    }

    public String getPropagandaArea() {
        return propagandaArea;
    }

    public void setPropagandaArea(String propagandaArea) {
        this.propagandaArea = propagandaArea;
    }

    public String getPropagandaAreaUrl() {
        return propagandaAreaUrl;
    }

    public void setPropagandaAreaUrl(String propagandaAreaUrl) {
        this.propagandaAreaUrl = propagandaAreaUrl;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getProFeeRuleCode() {
        return proFeeRuleCode;
    }

    public void setProFeeRuleCode(String proFeeRuleCode) {
        this.proFeeRuleCode = proFeeRuleCode;
    }

    public String getPropagandaFee() {
        return propagandaFee;
    }

    public void setPropagandaFee(String propagandaFee) {
        this.propagandaFee = propagandaFee;
    }
}
