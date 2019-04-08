package com.jn.enterprise.pd.personnel.enums;

import io.swagger.annotations.ApiModelProperty;

/**
 * 审批节点-枚举类
 * 定义每个申报步骤，节点编码(共4位，前2位代表大的阶段节点，后2位代表当前阶段的明细节点)
 * 只有2位的，代表是大的阶段节点（不会保存在数据库中）
 * @author： huangbq
 * @date： Created on 2019/3/15 1:39
 * @version： v1.0
 * @modified By:
 */
public enum PersonnelFlowNodeEnum {

    FIRST_START("10","人才意向申报"),
    FIRST_START_10("1010","企业-人才意向申报"),
    FIRST_START_20("1020","人才中心-人才意向申报审核"),

    TWO_AREA_PLAN_COUNSEL("20","区级计划书辅导"),
    TWO_AREA_PLAN_COUNSEL_10("2010","人才中心-上传人才申报书模板"),
    TWO_AREA_PLAN_COUNSEL_20("2020","企业-上传人才申报书"),
    TWO_AREA_PLAN_COUNSEL_30("2030","人才中心-发送预约辅导"),
    TWO_AREA_PLAN_COUNSEL_40("2040","企业-进行预约辅导"),
    TWO_AREA_PLAN_COUNSEL_50("2050","人才中心-通知实际辅导"),
    TWO_AREA_PLAN_COUNSEL_60("2060","企业-区级计划书辅导中"),
    TWO_AREA_PLAN_COUNSEL_70("2070","人才中心-区级计划书辅导完成"),

    THREE_ADD_INFO("30","完善申报资料"),
    THREE_ADD_INFO_10("3010","企业-完善申报资料"),
    THREE_ADD_INFO_20("3020","人才中心-完善申报资料审核"),

    FOUR_AREA_ANSWER_COUNSEL("40","区级答辩辅导"),
    FOUR_AREA_ANSWER_COUNSEL_10("4010","人才中心-上传答辩材料及发送预约辅导"),
    FOUR_AREA_ANSWER_COUNSEL_20("4020","企业-进行预约辅导"),
    FOUR_AREA_ANSWER_COUNSEL_30("4030","人才中心-通知实际辅导"),
    FOUR_AREA_ANSWER_COUNSEL_40("4040","企业-区级答辩辅导中"),
    FOUR_AREA_ANSWER_COUNSEL_50("4050","人才中心-区级答辩辅导完成"),

    FIVE_SETTLE("50","注册落户"),
    FIVE_SETTLE_10("5010","企业-核准名称"),
    FIVE_SETTLE_20("5020","企业-提交材料"),
    FIVE_SETTLE_30("5030","企业-领取执照"),
    FIVE_SETTLE_40("5040","企业-刻章等事项"),

    SIX_POLICY("60","获取扶持政策"),
    SIX_POLICY_10("6010","人才中心-发布政策通知"),
    SIX_POLICY_20("6020","企业-上传政策材料"),
    SIX_POLICY_30("6030","人才中心-政策材料审核"),

    SEVEN_CITY_PLAN_COUNSEL("70","市级计划书辅导"),
    SEVEN_CITY_PLAN_COUNSEL_10("7010","人才中心-上传人才申报书模板"),
    SEVEN_CITY_PLAN_COUNSEL_20("7020","企业-上传人才申报书"),
    SEVEN_CITY_PLAN_COUNSEL_30("7030","人才中心-发送预约辅导"),
    SEVEN_CITY_PLAN_COUNSEL_40("7040","企业-进行预约辅导"),
    SEVEN_CITY_PLAN_COUNSEL_50("7050","人才中心-通知实际辅导"),
    SEVEN_CITY_PLAN_COUNSEL_60("7060","企业-市级计划书辅导中"),
    SEVEN_CITY_PLAN_COUNSEL_70("7070","人才中心-市级计划书辅导完成"),

    EIGHT_CITY_ANSWER_COUNSEL("80","市级答辩辅导"),
    EIGHT_CITY_ANSWER_COUNSEL_10("8010","人才中心-上传答辩材料及发送预约辅导"),
    EIGHT_CITY_ANSWER_COUNSEL_20("8020","企业-进行预约辅导"),
    EIGHT_CITY_ANSWER_COUNSEL_30("8030","人才中心-通知实际辅导"),
    EIGHT_CITY_ANSWER_COUNSEL_40("8040","企业-市级答辩辅导中"),
    EIGHT_CITY_ANSWER_COUNSEL_50("8050","人才中心-市级答辩辅导完成"),
    END("9000","完成申报");

    @ApiModelProperty("节点编码(共4位，前2位代表大的阶段节点，后2位代表当前阶段的明细节点)")
    private String nodeNo;

    @ApiModelProperty("节点编码")
    private String nodeName;

    public String getNodeNo() {
        return nodeNo;
    }

    public void setNodeNo(String nodeNo) {
        this.nodeNo = nodeNo;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    PersonnelFlowNodeEnum(String nodeNo, String nodeName) {
        this.nodeNo = nodeNo;
        this.nodeName = nodeName;
    }}



