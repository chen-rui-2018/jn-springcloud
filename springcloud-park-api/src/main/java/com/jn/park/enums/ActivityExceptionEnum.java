package com.jn.park.enums;

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
    NETWORK_ANOMALY("4020901", "网络异常，请稍后重试。"),
    ACTIVITY_ID_CANNOT_EMPTY("4020201","活动id不能为空"),
    ACTIVITY_NOT_EXIST("4020202","活动未发布在或已被删除"),
    ACTIVITY_CANNOT_EMPTY("4020203","活动报名截止时间不能为空"),
    ACTIVITY_CUTOFF("4020204","报名已截止，不能报名或取消报名"),
    ACTIVITY_TYPE_NAME_EMPTY("4020205","活动类型名称不能为空"),
    ACTIVITY_TYPE_STATUS_EMPTY("4020206","活动类型状态不能为空"),
    ACTIVITY_TYPE_NAME_REPEAT("4020207","活动类型名称不能重复"),
    ACTIVITY_TYPE_ID_EMPTY("4020208","活动类型ID不能为空"),
    ACTIVITY_TYPE_ALREADY_ASSOCIATED("4020209","活动类型已关联活动"),
    ACTIVITY_LIKE_ACCOUNT_REPEAT("4020210","当前活动存在多个相同点赞用户，无法点赞"),
    ACTIVITY_RESULT_ERROR("4020211","活动信息查询异常"),
    ACTIVITY_STATE_ERROR("4020212","活动状态异常"),
    ACTIVITY_TITLE_NOT_NULL("4020213","活动标题不能为空"),
    ACTIVITY_TYPE_NOT_NULL("4020214","活动类型不能为空"),
    ACTIVITY_APPLY_TYPE_STATE_NOT_NULL("4020215","活动可报名状态不能为空"),
    ACTIVITY_STATE_TIME_NOT_NULL("4020216","活动开始时间不能为空"),
    ACTIVITY_END_TIME_NOT_NULL("4020217","活动结束时间不能为空"),
    ACTIVITY_APPLY_END_TIME_NOT_NULL("4020218","活动报名结束时间不能为空"),
    ACTIVITY_MES_SEND_TIME_NOT_NULL("4020219","活动消息推送时间不能为空"),
    ACTIVITY_ADDRESS_NOT_NULL("4020220","活动地址不能为空"),
    ACTIVITY_COST_NOT_NULL("4020221","活动费用不能为空"),
    ACTIVITY_ORGANIZER_NOT_NULL("4020222","活动主办方不能为空"),
    ACTIVITY_NUMBER_NOT_NULL("4020223","活动主人数不能为空"),
    ACTIVITY_PARK_ID_NOT_NULL("4020224","活动园区不能为空"),
    ACTIVITY_APPLY_CHECK_NOT_NULL("4020224","报名状态是否需审核不能为空"),
    ACTIVITY_POSTER_URL_NOT_NULL("4020225","活动海报不能为空"),
    ACTIVITY_DETAIL_NOT_NULL("4020226","活动详情不能为空"),
    ACTIVITY_STATE_NOT_DRAFT("4020227","活动不为草稿，不能修改"),
    ACTIVITY_TIME_PARSE_ERROR("4020228","活动时间转换错误，请核实时间为：yyyy-MM-dd HH:mm:ss"),
    ACTIVITY_TIME_ERROR("4020229","活动结束时间不能小于开始时间"),
    ACTIVITY_APPLY_TIME_ERROR("4020230","活动报名时间不能大于活动开始时间"),
    ACTIVITY_DRAFT_DELETE_ERROR("4020231","只能删除活动草稿数据"),
    ACTIVITY_DELETE_ERROR("4020232","数据删除异常"),
    ACTIVITY_IS_NOT_EXIST_ERROR("4020233","未查询出对应活动数据，请核实"),
    ACTIVITY_CANCEL_ERROR("4020234","数据取消异常"),
    ACTIVITY_UPDATE_ERROR("4020235","活动信息修改异常"),
    INCOMPLETE_INFORMATION("4020236","用户信息不完善，请完善用户信息"),
    ACTIVITY_TIME_PARSE_ERROR2("4020237","筛选的时间范围,时间格式转换错误，请核实时间为：yyyy-MM-dd"),
    ACTIVITY_APPLY_CODE_DOWN_IO_EXCEPTION("4020502","签到二维码下载IO异常"),
    ACTIVITY_APPLY_CODE_DOWN_WRITER_EXCEPTION("4020503","签到二维码下载读取异常"),
    ACTIVITY_USER_LOGIN_EXCEPTION("4020501","请先进行登录操作"),
    ACTIVITY_APPLY_INFO_IS_NULL("4020502","该活动报名信息为空，不允许签到"),
    ACTIVITY_APPLYED_CODE_EXCEPTION("4020503","报名无效，不允许签到"),
    ACTIVITY_CANCEL_EXPEPTION("4020504","当前状态不能取消活动"),
    ACTIVITY_APPLYED_SIGN_CODE_EXCEPTION("4020505","已签到成功，无需再次签到"),
    ACTIVITY_SEND_MSG_TIME_EXCEPTION("4020506","当前时间不处于活动开始前24小时，不能推送消息"),
    ACTIVITY_STATE_SEND_MSG_EXCEPTION("4020507","活动状态不为报名中，不能推送消息"),
    ACTIVITY_USER_NOT_APPLY("4020508","您未报名该活动，不能进行签到"),
    ACTIVITY_APPLY_ID_NOT_NULL("4020509","活动报名标识不能为空"),
    ACTIVITY_APPLY_IS_NULL("4020510","数据不存在，请核实"),
    ACTIVITY_APPLYED_NOT_CHECKED("4020511","非未审核报名状态，无需审核"),
    EXPORT_FAILED("4020902","导出失败"),
    EXPORT_PARAMETER_NUM("4020239","excel导出字段别名[exportColName]个数和excel导出字段标题[exportTitle]个数不匹配"),
    EXPORT_PARAMETER_MORE_HEAD("4020237","是否多行表头[isMoreHead]值只能是“0”、“1”"),
    EXPORT_PARAMETER_INDEX_OR_TEMP("4020238","多行表头从哪一行开始写数据[rowIndex]的值至少是3，多行表头导出模板[temp]不能为空"),
    EXPORT_CANNOT_EMPTY("4020510","没有数据，不能导出"),
    LIKE_STATE_NOT_ALLOW("4020511","点状状态只能是点赞(1)和取消点赞(0)"),
    APPLY_IS_NOT_EXIST("4020512","点赞评论或服务不存在"),
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
