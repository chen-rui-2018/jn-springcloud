package com.jn.news.sms.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * 短信回复数据实体类
 *
 * @Author： cm
 * @Date： Created on 2019/2/22 16:44
 * @Version： v1.0
 * @Modified By:
 */
@XStreamAlias("deliver")
public class SmsAnswerResult implements Serializable {
    private static final long serialVersionUID = 5177418392313718698L;
    @XStreamAlias("mobile")
    private String mobile;
    @XStreamAlias("ac")
    private String ac;
    @XStreamAlias("content")
    private String content;
    @XStreamAlias("receivetime")
    private String receivetime;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReceivetime() {
        return receivetime;
    }

    public void setReceivetime(String receivetime) {
        this.receivetime = receivetime;
    }

    @Override
    public String toString() {
        return "SmsAnswerResult{" +
                "mobile='" + mobile + '\'' +
                ", ac='" + ac + '\'' +
                ", content='" + content + '\'' +
                ", receivetime='" + receivetime + '\'' +
                '}';
    }
}
