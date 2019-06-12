package com.jn.park.customer.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/5/19 16:11
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "MyTasksOrMyHandledParam",description = "客服中心--园区客服中心入参")
public class MyTasksOrMyHandledParam extends Page implements Serializable {
    @ApiModelProperty(value = "流程实例id",example = "579315482578911232")
    private String procInstId;
    @ApiModelProperty(value = "流程类型(待处理：task ，已处理：handled)",required = true,example = "task")
    private String procType;
    @ApiModelProperty(value = "是否需要分页  1:分页   0:不分页",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public String getProcType() {
        return procType;
    }

    public void setProcType(String procType) {
        this.procType = procType;
    }

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }

    @Override
    public String toString() {
        return "MyTasksOrMyHandledParam{" +
                "procInstId='" + procInstId + '\'' +
                ", procType='" + procType + '\'' +
                ", needPage='" + needPage + '\'' +
                '}';
    }
}
