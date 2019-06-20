package com.jn.hardware.model.dingtalk.attendance;

import java.io.Serializable;

/**
 * @ClassName：钉钉：打卡结果
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/18 11:43
 * @Version： v1.0
 * @Modified By:
 */
public class ClockInInfo implements Serializable {

    private static final long serialVersionUID = 7414202026836062755L;

    /**
     * 唯一标识ID
    * */
    private String id;

    /**
     * 考勤组ID
     * */
    private String groupId;

    /**
     * 排班ID
     * */
    private String planId;

    /**
     * 打卡记录ID
     * */
    private String recordId;

    /**
     * 工作日
     * */
    private String workDate;
    /**
     * 用户ID
     * */
    private String userId;

    /**
     * 考勤类型
     * OnDuty：上班
     * OffDuty：下班
     * */
    private String checkType;

    /**
     * 时间结果
     * Normal：正常;
     * Early：早退;
     * Late：迟到;
     * SeriousLate：严重迟到；
     * Absenteeism：旷工迟到；
     * NotSigned：未打卡
     * */
    private String timeResult;

    /**
     * 位置结果
     * Normal：范围内；
     * Outside：范围外；
     * NotSigned：未打卡
     * */
    private String locationResult;

    /**
     * 关联的审批id，当该字段非空时，表示打卡记录与请假、加班等审批有关
     * */
    private String approveId;

    /**
     * 关联的审批实例id，当该字段非空时，表示打卡记录与请假、加班等审批有关。可以与获取单个审批数据配合使用
     * */
    private String procInstId;

    /**
     * 计算迟到和早退，基准时间
     * */
    private String baseCheckTime;

    /**
     * 实际打卡时间,  用户打卡时间的毫秒数
     * */
    private String userCheckTime;

    /**
     * 数据来源
     * ATM：考勤机;
     * BEACON：IBeacon;
     * DING_ATM：钉钉考勤机;
     * USER：用户打卡;
     * BOSS：老板改签;
     * APPROVE：审批系统;
     * SYSTEM：考勤系统;
     * AUTO_CHECK：自动打卡
     * */
    private String sourceType;

    /**
     * 企业id
     * */
    private String corpId;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getTimeResult() {
        return timeResult;
    }

    public void setTimeResult(String timeResult) {
        this.timeResult = timeResult;
    }

    public String getLocationResult() {
        return locationResult;
    }

    public void setLocationResult(String locationResult) {
        this.locationResult = locationResult;
    }

    public String getApproveId() {
        return approveId;
    }

    public void setApproveId(String approveId) {
        this.approveId = approveId;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public String getBaseCheckTime() {
        return baseCheckTime;
    }

    public void setBaseCheckTime(String baseCheckTime) {
        this.baseCheckTime = baseCheckTime;
    }

    public String getUserCheckTime() {
        return userCheckTime;
    }

    public void setUserCheckTime(String userCheckTime) {
        this.userCheckTime = userCheckTime;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    @Override
    public String toString() {
        return "ClockInInfo{" +
                "id='" + id + '\'' +
                ", groupId='" + groupId + '\'' +
                ", planId='" + planId + '\'' +
                ", recordId='" + recordId + '\'' +
                ", workDate='" + workDate + '\'' +
                ", userId='" + userId + '\'' +
                ", checkType='" + checkType + '\'' +
                ", timeResult='" + timeResult + '\'' +
                ", locationResult='" + locationResult + '\'' +
                ", approveId='" + approveId + '\'' +
                ", procInstId='" + procInstId + '\'' +
                ", baseCheckTime='" + baseCheckTime + '\'' +
                ", userCheckTime='" + userCheckTime + '\'' +
                ", sourceType='" + sourceType + '\'' +
                ", corpId='" + corpId + '\'' +
                '}';
    }
}
