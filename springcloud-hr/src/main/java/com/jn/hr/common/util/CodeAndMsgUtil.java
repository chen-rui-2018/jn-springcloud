package com.jn.hr.common.util;

import com.jn.common.api.CodeAndMsg;

/**
 * @author dt
 * @create 2019-04-19 下午 3:22
 */
public class CodeAndMsgUtil {


    public static <T extends CodeAndMsg> String getMsgByCode(Class<T> enumClass,String code){
        CodeAndMsg[] array = (CodeAndMsg[])enumClass.getEnumConstants();

        for(int i = 0; i < array.length; i++) {
            CodeAndMsg each = array[i];
            if (each!=null &&code!=null && each.getCode().equals(code)) {
                return each.getMessage();
            }
        }
        return "";
    }

    public static <T extends CodeAndMsg> String getCodeByMsg(Class<T> enumClass,String msg){
        CodeAndMsg[] array = (CodeAndMsg[])enumClass.getEnumConstants();

        for(int i = 0; i < array.length; i++) {
            CodeAndMsg each = array[i];
            if (msg.equals(each.getMessage())) {
                return each.getCode();
            }
        }
        return "未知";
    }
}
