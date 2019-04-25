package com.jn.enterprise.data.enums;

import com.jn.common.exception.JnSpringCloudException;

/**
 * @author： yangh
 * @date： Created on 2019/4/11 17:14
 * @version： v1.0
 * @modified By:
 */
public class DataUploadConstants {
    /**
     * 无效
     */
    public final static String INVALID="0";
    /**
     * 有效
     */
    public final static String VALID="1";
    /**
     * 企业类型
     */
    public final static String COMPANY_TYPE="0";
    /**
     * 园区类型
     */
    public final static String GARDEN_TYPE="1";

    //填报状态
    /**
     * 已上报
     */
    public final static String FILLED="0";
    /**
     * 未上报
     */
    public final static String NOT_FILL="1";

    /**
     *
     */
    public final static String IS_DRAFT="2";
    /**
     * 逾期上报

    public final static String FILLED_BUT_OVERDUE="2";
     */
    //填报周期
    /**
     * 月
     */
    public final static String MODEL_CYCLE_MONTH="0";
    /**
     * 年
     */
    public final static String MODEL_CYCLE_YEAR="1";

    /**
     * 1月
     */
    public final static Integer ONE_MONTH=1;
    /**
     * 上月填报值
     */
    public final static String LAST_MONTH="0";
    /**
     * 上年同期值
     */
    public final static String THIS_MONTH_LAST_YEAR="1";
    /**
     * 上月上年同期值
     */
    public final static String LAST_MONTH_LAST_YEAR="2";
    /**
     *增幅
     */
    public final static String AMPLIFICATION="3";
    /**
     * tab列类型值的分割符号
     */
    public final static String TAB_COLUMN_SEPARTOR=",";

    /**
     * 任务是否逾期-是
     */
    public final static String TASK_IS_OVERDUE="1";
    /**
     * 任务是否逾期-否
     */
    public final static String TASK_IS_NOT_OVERDUE="0";

    /**
     * 广告展示客户端-PC
     */
    public final static String AD_DISPLAY_CLIENT_PC="PC";
    /**
     * 广告展示客户端-APP
     */
    public final static String AD_DISPLAY_CLIENT_APP="APP";

    /**
     * 0：文本框
     */
    public final static String FORM_TYPE_TEXT="0";
    /**
     *1：多行文本框
     */
    public final static String FORM_TYPE_TEXTAREA="1";
    /**
     *2：数字
     */
    public final static String FORM_TYPE_TEXTNUMBER="2";
    /**
     *3：单选框
     */
    public final static String FORM_TYPE_RADIO="3";
    /**
     *4：多选框
     */
    public final static String FORM_TYPE_CHECK="4";
    /**
     * 5：图片上传
     */
    public final static String FORM_TYPE_IMAGE="5";

    /**
     *下月
     */
    public final static String DEAD_TYPE_NEXT_MONTH="下月";
    /**
     *当月
     */
    public final static String DEAD_TYPE_THIS_MONTH="当月";

    /**
     *APP预警方式
     */
    public final static String WARNING_BY_APP="2";
    /**
     *邮件预警方式
     */
    public final static String WARNING_BY_EMAIL="1";
    /**
     * 短信预警方式
     */
    public final static String WARNING_BY_SMSTEXT="0";

    /**
     *
     */
    public final static String  REQUIRED="1";
}
