package com.jn.oa.item.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 工作计划字段枚举
 *
 * @author： shaobao
 * @date： Created on 2019/3/5 15:47
 * @version： v1.0
 * @modified By:
 **/
public enum WorkPlanPropertiesEnmus implements CodeAndMsg {
    ITEMNAME("itemName", "项目名称"),
    WORK_PLAN_NAME("workPlanName", "工作计划名称"),
    CONTENT("content", "工作计划内容"),
    DEMANDDESCRIBE("demandDescribe", "工作计划需求"),
    PLAN_START_TIME("planStartTime", "计划开始时间"),
    PLAN_End_TIME("planEndTime", "计划截止时间"),
    START_TIME("startTime", "实际开始时间"),
    END_TIME("endTime", "实际截止时间"),
    PLAN_TIME("planTime", "计划工时"),
    TOTAL_CONSUME_TIME("totalConsumeTime", "总消耗时间"),
    TOTAL_REMAIN_TIME("totalRemainTime", "总剩余时间"),
    WORK_PLAN_STATUS("workPlanStatus", "任务状态"),
    RESPONSIBLE_USER_NAME("responsibleUserName", "负责人"),
    RECORDDATE("recordDate","日期"),
    CONSUMETIME("consumeTime","消耗总工时"),
    REMAINTIME("remainTime","剩余总工时"),
    REMARK("remark","备注")
    ;

    private String code;

    private String message;

    WorkPlanPropertiesEnmus(String key, String message) {
        this.code = key;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }


    @Override
    public String getMessage() {
        return message;
    }
}
