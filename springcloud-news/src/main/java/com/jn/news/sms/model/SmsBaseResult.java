package com.jn.news.sms.model;

import java.io.Serializable;

/**
 * 接口短信下发接口返回的数据
 *
 * @Author： cm
 * @Date： Created on 2019/2/22 16:26
 * @Version： v1.0
 * @Modified By:
 */
public class SmsBaseResult implements Serializable {

    private static final long serialVersionUID = 5417211153593580996L;

    /**
     * 返回结果
     * 0：成功
     * 1：帐号信息错误，请核对
     * 2：IP地址错误
     * 3：参数请不带空数据，比如内容，号码等
     */
    private String result;
    /**
     * 返回实际描述
     */
    private String desc;
    /**
     * 只有成功提交才有返回值，批量提交请根据号码和消息ID去匹配报告
     */
    private String taskid;

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

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    @Override
    public String toString() {
        return "SmsSubmitResult{" +
                "result='" + result + '\'' +
                ", desc='" + desc + '\'' +
                ", taskid='" + taskid + '\'' +
                '}';
    }
}
