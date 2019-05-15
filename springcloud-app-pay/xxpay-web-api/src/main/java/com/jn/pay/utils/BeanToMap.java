package com.jn.pay.utils;

import org.springframework.cglib.beans.BeanMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName：对象转Map
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/4/28 18:08
 * @Version： v1.0
 * @Modified By:
 */
public class BeanToMap {

    public static <T> Map<String, Object> toMap(T bean) {
        Map<String, Object> map = new HashMap<>();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key + "", beanMap.get(key));
            }
        }
        return map;
    }
}
