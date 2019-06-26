package com.jn.hardware.model.dingtalk.attendance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jn.hardware.model.dingtalk.BaseResult;

import java.io.Serializable;

/**
 * @ClassName：钉钉：获取请假状态出参实体类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/18 15:52
 * @Version： v1.0
 * @Modified By:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeaveStatusListResult extends BaseResult implements Serializable {

    private static final long serialVersionUID = -3018574489921508640L;

    /**
     * 调用是否成功
    * */
    private Boolean  success;
    /**
     * 请假状态列表
    * */
    private LeaveStatusList result;
    /**
     * 请求ID
    * */
    @JsonProperty("request_id")
    private String  requestId;


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public LeaveStatusList getResult() {
        return result;
    }

    public void setResult(LeaveStatusList result) {
        this.result = result;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @Override
    public String toString() {
        return "LeaveStatusListResult{" +
                "success=" + success +
                ", result=" + result +
                ", requestId='" + requestId + '\'' +
                '}';
    }
}
