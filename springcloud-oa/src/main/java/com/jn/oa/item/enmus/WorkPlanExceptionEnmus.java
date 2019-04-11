package com.jn.oa.item.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： shaobao
 * @date： Created on 2019/2/28 10:03
 * @version： v1.0
 * @modified By:
 **/
public enum WorkPlanExceptionEnmus implements CodeAndMsg {
    WORK_PLAM_TIME_ERROR("6012501", "开始时间需要大于结束时间"),
    WORK_PLAM_NOT_EXIST("6012502", "信息不存在"),
    CONSUME_TIME_NOT_NULL("6012503", "总消耗时间不能为空"),
    REMAIN_TIME_NOT_NULL("6012504", "总剩余时间不能为空"),
    START_TIME_NOT_NULL("6012505", "开始时间不能为空"),
    END_TIME_NOT_NULL("6012506", "结束时间不能为空"),
    REMARK_NOT_NULL("6012507", "备注信息不能为空"),
    WORKPLANRECODE_ID_NOT_NULL("6012508","工作计划工作记录不能为空"),
    DOWNLOAD_EXCEL_TEMPLATE_FAIL("6012509","工作计划导入模板下载失败,请稍后再试"),
    FILE_NOT_EMPTY("6012510","上传文件不能为空"),
    ITEM_IS_EXIST("6012511","修改状态失败,请稍后再试")
    ;
    private String code;

    private String message;

    WorkPlanExceptionEnmus(String key, String message) {
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
