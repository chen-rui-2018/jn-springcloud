package com.jn.park.electricmeter.enums;

/**
 * @author： yangh
 * @date： Created on 2019/5/17 15:50
 * @version： v1.0
 * @modified By:
 */

public class MeterConstants {
    /**
     * 无效
     */
    public final static String INVALID="0";
    /**
     * 有效
     */
    public final static String VALID="1";

    /**
     * 成功
     */
    public final static String SUCCESS="1";

    /**
     * 失败
     */
    public final static String FAIL="2";
    /**
     * 睡眠时间
     */
    public final static Long SLEEP_TIME=30000L;

    /**
     * 每页多少条
     */
    public final static Integer ROWS=40;

    /**
     * 第一页
     */
    public final static Integer FIRST_PAGE=1;

    /**
     * 循环处理次数
     */
    public final static Integer LOOP_NUM=10;

    /**
     * 每次保存的次数
     */
    public final static Integer SAVE_SIZE=40;

    /**
     * 系统用户
     */
    public final static String SYSTEM_USER="system";


    /**
     * 电表账本标识
     */
    public final static String ELEC_BOOK="1";
}
