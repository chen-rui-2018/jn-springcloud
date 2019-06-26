package com.jn.hardware.model.dingtalk.attendance;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @ClassName：钉钉：获取请假时长入参实体类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/18 17:20
 * @Version： v1.0
 * @Modified By:
 */
public class LeaveApproveDurationParam implements Serializable {

    private static final long serialVersionUID = 3111124132442604322L;

    @NotBlank(message = "员工在企业内的UserID，企业用来唯一标识用户的字段")
    private String userid;

    @JsonProperty("from_date")
    @NotBlank(message = "请假开始时间。格式为“yyyy-MM-dd HH:mm:ss")
    private String fromDate;

    @JsonProperty("to_date")
    @NotBlank(message = "请假结束时间。格式为“yyyy-MM-dd HH:mm:ss")
    private String toDate;



    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "LeaveApproveDurationParam{" +
                "userid='" + userid + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                '}';
    }
}
