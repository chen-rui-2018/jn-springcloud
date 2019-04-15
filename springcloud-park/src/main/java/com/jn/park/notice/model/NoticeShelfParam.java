package com.jn.park.notice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/2 15:09
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="NoticeShelfParam",description = "公告上下架的bean入参")
public class NoticeShelfParam implements Serializable {
    @ApiModelProperty(value="公告id",required = true ,example = "1063bdd13de64123abaecdd96b3269dc")
    @NotBlank(message = "上架/下架公告--公告id不能为空")
    private String noticeId;
    @ApiModelProperty(value="公告状态,(0:无效-1:有效)",required = true,example = "1")
    @NotBlank(message = "上架/下架公告--操作结果不能为空 (0:下架-1:上架)")
    @Pattern(regexp = "^[0-1]$",message = "操作结果只能为0或1--(0:下架-1:上架)")
    private String noticeStatus;

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(String noticeStatus) {
        this.noticeStatus = noticeStatus;
    }
}
