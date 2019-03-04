package com.jn.news.sms.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * 短信平台短信状态和短信回复获取返回错误信息
 *
 * @Author： cm
 * @Date： Created on 2019/2/26 16:07
 * @Version： v1.0
 * @Modified By:
 */
@XStreamAlias("errorstatus")
public class SmsErrorStatusResult implements Serializable {
    private static final long serialVersionUID = 4409625769447601490L;

    /**
     * 错误代码
     */
    @XStreamAlias("result")
    private String result;
    /**
     * 错误描述
     */
    @XStreamAlias("desc")
    private String desc;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "SmsErrorStatusResult{" +
                "result='" + result + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
