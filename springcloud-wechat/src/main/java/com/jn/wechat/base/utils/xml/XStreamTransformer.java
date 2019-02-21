package com.jn.wechat.base.utils.xml;

import com.jn.wechat.base.model.message.WxXmlMessage;
import com.jn.wechat.base.model.message.WxXmlOutTextMessage;
import com.thoughtworks.xstream.XStream;

import java.util.*;

/**
 * 微信消息报文双向解析
 *
 * @Author： cm
 * @Date： Created on 2019/1/9 17:47
 * @Version： v1.0
 * @Modified By:
 */
public class XStreamTransformer {

    private static final Map<Class<?>, XStream> CLASS_2_XSTREAM_INSTANCE = new HashMap<>();

    static {
        registerClass(WxXmlMessage.class);
        registerClass(WxXmlOutTextMessage.class);
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
        if (clz.equals(WxXmlMessage.class)) {
            // 操蛋的微信，模板消息推送成功的消息是MsgID，其他消息推送过来是MsgId
            xstream.aliasField("MsgID", WxXmlMessage.class, "msgId");
        }
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
