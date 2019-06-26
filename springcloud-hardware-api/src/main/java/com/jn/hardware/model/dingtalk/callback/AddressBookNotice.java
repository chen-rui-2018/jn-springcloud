package com.jn.hardware.model.dingtalk.callback;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jn.hardware.enums.dingtalk.AddressBookEventTypeEnum;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName：通讯录回调信息
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/20 11:00
 * @Version： v1.0
 * @Modified By:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressBookNotice implements Serializable {

    private static final long serialVersionUID = 744264893993646577L;
    /**
     *事件类型
    * */
    private AddressBookEventTypeEnum eventType;

    /**
     *时间戳
     * */
    @JsonProperty("TimeStamp")
    private String timeStamp;

    /**
     *用户发生变更的userid列表
     * */
    @JsonProperty("UserId")
    private List<String> userId;

    /**
     *部门发生变更的deptId列表
     * */
    @JsonProperty("DeptId")
    private List<String> deptId;

    /**
      * 发生通讯录变更的企业ID
     * */
    @JsonProperty("CorpId")
    private String corpId;

    public AddressBookEventTypeEnum getEventType() {
        return eventType;
    }

    public void setEventType(AddressBookEventTypeEnum eventType) {
        this.eventType = eventType;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<String> getUserId() {
        return userId;
    }

    public void setUserId(List<String> userId) {
        this.userId = userId;
    }

    public List<String> getDeptId() {
        return deptId;
    }

    public void setDeptId(List<String> deptId) {
        this.deptId = deptId;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    @Override
    public String toString() {
        return "AddressBookNotice{" +
                "eventType=" + eventType +
                ", timeStamp='" + timeStamp + '\'' +
                ", userId=" + userId +
                ", deptId=" + deptId +
                ", corpId='" + corpId + '\'' +
                '}';
    }
}
