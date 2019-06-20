package com.jn.hardware.model.dingtalk.attendance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    private String  request_id;


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
    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    @Override
    public String toString() {
        return "LeaveStatusListResult{" +
                "success=" + success +
                ", result=" + result +
                ", request_id='" + request_id + '\'' +
                '}';
    }
}
