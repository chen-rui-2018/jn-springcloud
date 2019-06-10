package com.jn.park.customer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/5/23 16:41
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "CalledOwenResult",description = "来电归属地返回结果")
public class CalledOwenResult implements Serializable {
    @ApiModelProperty(value = "响应结果")
    private Object response;
    @ApiModelProperty(value = "响应头")
    private Object responseHeader;

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public Object getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(Object responseHeader) {
        this.responseHeader = responseHeader;
    }

    @Override
    public String toString() {
        return "CalledOwenResult{" +
                "response=" + response +
                ", responseHeader=" + responseHeader +
                '}';
    }
}
