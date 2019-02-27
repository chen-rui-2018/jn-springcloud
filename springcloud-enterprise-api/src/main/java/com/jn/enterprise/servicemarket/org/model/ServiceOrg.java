package com.jn.enterprise.servicemarket.org.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 服务机构
 * @author： jiangyl
 * @date： Created on 2019/2/13 15:08
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceOrg", description = "服务机构")
public class ServiceOrg implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "机构ID")
    private String id;

    @ApiModelProperty(value = "机构名称")
    private String orgName;

    @ApiModelProperty(value = "机构注册时间")
    private String orgRegisterTime;

    @ApiModelProperty(value = "是否认证")
    private String isApprove;

    @ApiModelProperty(value = "机构类型")
    private String orgType;

    @ApiModelProperty(value = "机构咨询电话")
    private String orgPhone;

    @ApiModelProperty(value = "机构地址")
    private String orgAddress;

    @ApiModelProperty(value = "机构LOGO")
    private String orgLogo;

    @ApiModelProperty(value = "服务态度评分")
    private String attitudeScore;
    @ApiModelProperty(value = "服务专业评分")
    private String professionScore;
    @ApiModelProperty(value = "服务响应评分")
    private String responseScore;
    @ApiModelProperty(value = "服务价格评分")
    private String priceScore;
    @ApiModelProperty(value = "综合得分")
    private Integer integratedSort;
    @ApiModelProperty(value = "评价等级（好评）")
    private String evaluationLevel;
    @ApiModelProperty(value = "浏览量（人气）")
    private Integer pageviews;
    @ApiModelProperty(value = "累计交易次数（服务量）")
    private Integer transactionNum;
    @ApiModelProperty(value = "评价次数")
    private Integer evaluationNum;
}
