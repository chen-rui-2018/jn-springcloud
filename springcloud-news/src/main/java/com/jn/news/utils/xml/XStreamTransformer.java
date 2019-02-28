package com.jn.news.utils.xml;

import com.jn.news.sms.model.SmsAnswerResult;
import com.jn.news.sms.model.SmsBaseResult;
import com.jn.news.sms.model.SmsErrorStatusResult;
import com.jn.news.sms.vo.SmsAnswersResult;
import com.jn.news.sms.vo.SmsReportsResult;
import com.thoughtworks.xstream.XStream;

import java.util.*;

/**
 * 报文双向解析
 *
 * @Author： cm
 * @Date： Created on 2019/1/9 17:47
 * @Version： v1.0
 * @Modified By:
 */
public class XStreamTransformer {

    private static final Map<Class<?>, XStream> CLASS_2_XSTREAM_INSTANCE = new HashMap<>();

    static {
        registerClass(SmsBaseResult.class);
        registerClass(SmsReportsResult.class);
        registerClass(SmsErrorStatusResult.class);
        registerClass(SmsAnswerResult.class);
        registerClass(SmsAnswersResult.class);
    }

    /**
     * 会自动注册该类及其子类.
     *
     * @param clz 要注册的类
     */
    private static void registerClass(Class<?> clz) {
        XStream xstream = XStreamInitializer.getInstance();

        xstream.processAnnotations(clz);
        xstream.processAnnotations(getInnerClasses(clz));
        register(clz, xstream);
    }

    private static Class<?>[] getInnerClasses(Class<?> clz) {
        Class<?>[] innerClasses = clz.getClasses();
        if (innerClasses == null) {
            return null;
        }
        List<Class<?>> result = new ArrayList<>();
        result.addAll(Arrays.asList(innerClasses));
        for (Class<?> inner : innerClasses) {
            Class<?>[] innerClz = getInnerClasses(inner);
            if (innerClz == null) {
                continue;
            }
            result.addAll(Arrays.asList(innerClz));
        }
        return result.toArray(new Class<?>[0]);
    }

    /**
     * 注册扩展消息的解析器.
     *
     * @param clz     类型
     * @param xStream xml解析器
     */
    public static void register(Class<?> clz, XStream xStream) {
        CLASS_2_XSTREAM_INSTANCE.put(clz, xStream);
    }

    /**
     * xml -> pojo.
     */
    @SuppressWarnings("unchecked")
    public static <T> T fromXml(Class<T> clazz, String xml) {
        T object = (T) CLASS_2_XSTREAM_INSTANCE.get(clazz).fromXML(xml);
        return object;
    }

    /**
     * pojo -> xml.
     */
    public static <T> String toXml(Class<T> clazz, T object) {
        return CLASS_2_XSTREAM_INSTANCE.get(clazz).toXML(object);
    }
}
