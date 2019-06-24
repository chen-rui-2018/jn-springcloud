package com.jn.enterprise.pd.talent.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 人才服务首页平台入參实体类
 *
 * @author： wzy
 * @date： Created on 2019/4/10 10:12
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "TalentNoticePlatformParam", description = "人才服务首页平台入參实体类")
public class TalentNoticePlatformParam extends Page implements Serializable {
    private static final long serialVersionUID = -4770449500384923742L;

    @ApiModelProperty(value = "平台标题", example = "高层次创业人才引进计划")
    private String platformTitle;

    @ApiModelProperty(value = "是否属于人才服务（1：是，2：否）",required = true, example = "1")
    @NotBlank(message = "是否属于人才服务值不能为空！")
    private String isTalentService;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPlatformTitle() {
        return platformTitle;
    }

    public void setPlatformTitle(String platformTitle) {
        this.platformTitle = platformTitle;
    }

    public String getIsTalentService() {
        return isTalentService;
    }

    public void setIsTalentService(String isTalentService) {
        this.isTalentService = isTalentService;
    }

    @Override
    public String toString() {
        return "TalentNoticePlatformParam{" +
                "platformTitle='" + platformTitle + '\'' +
                ", isTalentService='" + isTalentService + '\'' +
                '}';
    }
}
