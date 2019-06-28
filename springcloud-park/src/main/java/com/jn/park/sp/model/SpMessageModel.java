package com.jn.park.sp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author： zhuyz
 * @date： Created on 2019/3/28 16:22
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SpMessageModel",description = "留言表")
public class SpMessageModel implements Serializable {

    private static final long serialVersionUID = 7271180997663086657L;

    @ApiModelProperty(value = "主键",example = "1")
    private String id;

    @ApiModelProperty(value = "来源的业务ID",example = "559447847364198400")
    private String fromBusiId;

    @ApiModelProperty(value = "公司名称(默认填入当前企业名称",example = "信息系统")
    private String companyName;

    @ApiModelProperty(value = "联系人姓名(默认填入企业联系人姓名)",example = "陈先生")
    private String concatName;

    @ApiModelProperty(value = "联系人电话(默认填入企业联系人电话)",example = "18620292222")
    private String concatPhone;

    @ApiModelProperty(value = "留言内容",example = "《江苏省全民义务植树条例》 第六条 县级以上绿化委员会应当组织本地区各单位积极开展义务植树的宣传教育工作，增强公民履行植树义务的意识，推动全社会义务植树和造林绿化事业的发展")
    private String message;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromBusiId() {
        return fromBusiId;
    }

    public void setFromBusiId(String fromBusiId) {
        this.fromBusiId = fromBusiId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getConcatName() {
        return concatName;
    }

    public void setConcatName(String concatName) {
        this.concatName = concatName;
    }

    public String getConcatPhone() {
        return concatPhone;
    }

    public void setConcatPhone(String concatPhone) {
        this.concatPhone = concatPhone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
