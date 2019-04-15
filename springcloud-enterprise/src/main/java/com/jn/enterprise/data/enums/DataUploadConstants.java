package com.jn.enterprise.data.enums;

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
     * 逾期上报
     */
    public final static String FILLED_BUT_OVERDUE="2";

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
    public final static Integer LAST_MONTH=0;
    /**
     * 上年同期值
     */
    public final static Integer THIS_MONTH_LAST_YEAR=1;
    /**
     * 上月上年同期值
     */
    public final static Integer LAST_MONTH_LAST_YEAR=2;
    /**
     *增幅
     */
    public final static Integer AMPLIFICATION=3;
    /**
     * tab列类型值的分割符号
     */
    public final static String TAB_COLUMN_SEPARTOR=",";

}
