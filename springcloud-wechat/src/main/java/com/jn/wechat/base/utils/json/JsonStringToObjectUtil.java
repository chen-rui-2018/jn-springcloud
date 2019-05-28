package com.jn.wechat.base.utils.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jn.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * json字符串转换成对象
 *
 * @Author： cm
 * @Date： Created on 2019/2/13 10:55
 * @Version： v1.0
 * @Modified By:
 */
public class JsonStringToObjectUtil {

    private static Logger logger = LoggerFactory.getLogger(JsonStringToObjectUtil.class);

    private  static ObjectMapper objectMapper = new ObjectMapper();

    public static <T>T jsonToObject(String src, TypeReference<T> typeReference){
        if(StringUtils.isEmpty(src) || typeReference == null){
            return null;
        }
        try {
            return (T)(typeReference.getType().equals(String.class) ? src : objectMapper.readValue(src, typeReference));
        } catch (Exception e) {
            logger.error("json字符串转换成对象失败.",e);
            return null;
        }
    }
}
