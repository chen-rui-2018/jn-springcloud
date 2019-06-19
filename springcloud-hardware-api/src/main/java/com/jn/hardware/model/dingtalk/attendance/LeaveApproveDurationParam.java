package com.jn.hardware.model.dingtalk.attendance;

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

    @NotBlank(message = "请假开始时间。格式为“yyyy-MM-dd HH:mm:ss")
    private String from_date;

    @NotBlank(message = "请假结束时间。格式为“yyyy-MM-dd HH:mm:ss")
    private String to_date;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFrom_date() {
        return from_date;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public String getTo_date() {
        return to_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }

    @Override
    public String toString() {
        return "LeaveApproveduRationParam{" +
                "userid='" + userid + '\'' +
                ", from_date='" + from_date + '\'' +
                ", to_date='" + to_date + '\'' +
                '}';
    }
}
