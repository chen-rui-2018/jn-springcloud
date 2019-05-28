package com.jn.miniprogram.base.utils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jn.common.util.StringUtils;

import java.io.IOException;

/**
 * json字符串转换成对象
 *
 * @Author： cm
 * @Date： Created on 2019/2/13 10:55
 * @Version： v1.0
 * @Modified By:
 */
public class JacksonJsonTransformUtil {

    private  static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * JSON字符串转对象
     * @param src
     * @param typeReference
     * @param <T>
     * @return
     */
    public static <T>T jsonToObject(String src, TypeReference<T> typeReference) throws IOException {
        if(StringUtils.isEmpty(src) || typeReference == null){
            return null;
        }
        return (T)(typeReference.getType().equals(String.class) ? src : objectMapper.readValue(src, typeReference));
    }

    /**
     * 对象转换成JSON字符串
     *
     * @param value
     * @return
     */
    public static String objectToJson(Object value) throws JsonProcessingException {
        if(null == value){
            return null;
        }
        return objectMapper.writeValueAsString(value);
    }

}
