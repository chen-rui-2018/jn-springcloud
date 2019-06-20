package com.jn.hardware.model.dingtalk.attendance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jn.hardware.model.dingtalk.BaseResult;

import java.io.Serializable;

/**
 * @ClassName：钉钉：请假时长出参实体类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/18 17:20
 * @Version： v1.0
 * @Modified By:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeaveApproveDurationResult extends BaseResult implements Serializable {

    private static final long serialVersionUID = -6835197576782165028L;

    /**
     * 请假时长实体类
    * */
    private LeaveApproveDurationInfo result;

    public LeaveApproveDurationInfo getResult() {
        return result;
    }

    public void setResult(LeaveApproveDurationInfo result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "LeaveApproveDurationResult{" +
                "result=" + result +
                '}';
    }
}
