package com.jn.common.util.enums;


import com.jn.common.enums.CodeEnum;

/**
 * 状态码枚举类
 *
 * @author： yuanyy
 * @date：Created on 2018/11/01 17:29
 * @version： v1.0
 * @modified By:
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByKey(String key, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (key.equals(each.getKey())) {
                return each;
            }
        }
        return null;
    }
}
