package com.jn.news.sms.model;

import com.jn.common.util.xml.XmlUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.dom4j.DocumentException;

import java.io.Serializable;
import java.util.Map;

/**
 * 短信发送状态数据实体类
 *
 * @Author： cm
 * @Date： Created on 2019/2/22 16:44
 * @Version： v1.0
 * @Modified By:
 */
@XStreamAlias("report")
public class SmsReportResult implements Serializable {
    private static final long serialVersionUID = 3890671058889787778L;
    @XStreamAlias("mobile")
    private String mobile;
    @XStreamAlias("taskid")
    private String taskid;
    @XStreamAlias("status")
    private String status;
    @XStreamAlias("errcode")
    private String errcode;
    @XStreamAlias("receivetime")
    private String receivetime;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getReceivetime() {
        return receivetime;
    }

    public void setReceivetime(String receivetime) {
        this.receivetime = receivetime;
    }

    @Override
    public String toString() {
        return "SmsReportResult{" +
                "mobile='" + mobile + '\'' +
                ", taskid='" + taskid + '\'' +
                ", status='" + status + '\'' +
                ", errcode='" + errcode + '\'' +
                ", receivetime='" + receivetime + '\'' +
                '}';
    }

}
