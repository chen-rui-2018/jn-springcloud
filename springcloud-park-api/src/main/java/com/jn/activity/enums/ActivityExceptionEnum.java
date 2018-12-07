package com.jn.activity.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 登录异常枚举
 *
 * @Author: yangph
 * @Date: 2018/11/28 19:02
 * @Version v1.0
 * @modified By:
 */
public enum ActivityExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("11110301", "网络异常，请稍后重试。"),
    ACTIVITY_ID_CANNOT_EMPTY("11110201","活动id不能为空"),
    ACTIVITY_NOT_EXIST("11110202","活动未发布在或已被删除"),
    ACTIVITY_CANNOT_EMPTY("11110203","活动报名截止时间不能为空"),
    ACTIVITY_CUTOFF("11110501","报名已截止，不能报名或取消报名"),
    ACTIVITY_TYPE_NAME_EMPTY("11110201","活动类型名称不能为空"),
    ACTIVITY_TYPE_STATUS_EMPTY("11110201","活动类型状态不能为空"),
    ACTIVITY_TYPE_NAME_REPEAT("1111201","活动类型名称不能重复"),
    ACTIVITY_LIKE_ACCOUNT_REPEAT("11110502","当前活动存在多个相同点赞用户，无法点赞"),
    ACTIVITY_RESUT_ERROR("11110211","活动信息查询异常"),
    ACTIVITY_STATE_ERROR("11110241","活动状态异常"),
    ACTIVITY_TITLE_NOT_NULL("11110300","活动标题不能为空"),
    ACTIVITY_TYPE_NOT_NULL("11110300","活动类型不能为空"),
    ACTIVITY_STATE_TIME_NOT_NULL("11110300","活动开始时间不能为空"),
    ACTIVITY_END_TIME_NOT_NULL("11110300","活动结束时间不能为空"),
    ACTIVITY_APPLY_END_TIME_NOT_NULL("11110300","活动报名结束时间不能为空"),
    ACTIVITY_MES_SEND_TIME_NOT_NULL("11110300","活动消息推送时间不能为空"),
    ACTIVITY_ADDRESS_NOT_NULL("11110300","活动地址不能为空"),
    ACTIVITY_COST_NOT_NULL("11110300","活动费用不能为空"),
    ACTIVITY_ORGANIZER_NOT_NULL("11110300","活动主办方不能为空"),
    ACTIVITY_NUMBER_NOT_NULL("11110300","活动主人数不能为空"),
    ACTIVITY_POSTER_URL_NOT_NULL("11110300","活动海报不能为空"),
    ACTIVITY_DETAIL_NOT_NULL("11110300","活动详情不能为空"),
    ACTIVITY_STATE_NOT_DRAFT("11110300","活动不为草稿，不能修改"),
    ACTIVITY_TIME_PARSE_ERROR("11110300","活动时间转换错误，请核实时间为：yyyy-MM-dd HH:mm:ss"),
    ACTIVITY_TIME_ERROR("11110300","活动结束时间不能小于开始时间"),
    ACTIVITY_APPLY_TIME_ERROR("11110300","活动报名时间不能小于活动开始时间"),
    ACTIVITY_DRAFT_DELETE_ERROR("11110300","只能删除活动草稿数据"),
    ACTIVITY_DELETE_ERROR("11110300","数据删除异常"),
    ACTIVITY_UPDATE_ERROR("11110221","活动信息修改异常")
    ;

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    ActivityExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
