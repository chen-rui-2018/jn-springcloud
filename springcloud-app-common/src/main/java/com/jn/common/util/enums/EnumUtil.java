package com.jn.common.util.enums;


import com.jn.common.api.CodeAndMsg;

/**
 * 状态码枚举类
 *
 * @author： yuanyy
 * @date：Created on 2018/11/01 17:29
 * @version： v1.0
 * @modified By:
 */
public class EnumUtil {

    public static <T extends CodeAndMsg> T getByCode(String key, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (key.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
