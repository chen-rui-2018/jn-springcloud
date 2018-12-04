package com.jn.common.util;

import com.jn.common.enums.CommonAssertExceptionEnum;
import com.jn.common.exception.JnSpringCloudException;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 断言
 *
 * @author： fengxh
 * @date： Created on 2018/11/23 16:37
 * @version： v1.0
 * @modified By:
 */
public abstract class Assert {

    private Assert() {
    }

    /**
     * 状态断言
     * @param expression
     * @param message
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new JnSpringCloudException(CommonAssertExceptionEnum.ASSERT_STATE, message);
        }
    }
    /**
     * 状态断言
     * @param expression
     */
    public static void isTrue(boolean expression) {
        isTrue(expression, CommonAssertExceptionEnum.ASSERT_STATE.getMessage());
    }
    /**
     * 为空断言
     * @param object
     * @param message
     */
    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new JnSpringCloudException(CommonAssertExceptionEnum.ASSERT_NULL, message);
        }
    }
    /**
     * 为空断言
     * @param object
     */
    public static void isNull(Object object) {
        isNull(object, CommonAssertExceptionEnum.ASSERT_NULL.getMessage());
    }
    /**
     * 不为空断言
     * @param object
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new JnSpringCloudException(CommonAssertExceptionEnum.ASSERT_NOT_NULL, message);
        }
    }
    /**
     * 不为空断言
     * @param object
     */
    public static void notNull(Object object) {
        notNull(object, CommonAssertExceptionEnum.ASSERT_NOT_NULL.getMessage());
    }

    /**
     * 有长度断言
     * @param text
     * @param message
     */
    public static void hasLength(String text, String message) {
        if (!org.springframework.util.StringUtils.hasLength(text)) {
            throw new JnSpringCloudException(CommonAssertExceptionEnum.ASSERT_HAS_LENGTH, message);
        }
    }
    /**
     * 有长度断言
     * @param text
     */
    public static void hasLength(String text) {
        hasLength(text, CommonAssertExceptionEnum.ASSERT_HAS_LENGTH.getMessage());
    }

    /**
     * 有内容断言
     * @param text
     * @param message
     */
    public static void hasText(String text, String message) {
        if (!org.springframework.util.StringUtils.hasText(text)) {
            throw new JnSpringCloudException(CommonAssertExceptionEnum.ASSERT_HAS_TEXT, message);
        }
    }
    /**
     * 有内容断言
     * @param text
     */
    public static void hasText(String text) {
        hasText(text, CommonAssertExceptionEnum.ASSERT_HAS_TEXT.getMessage());
    }

    /**
     * 不能相同字符串
     * @param textToSearch  校验的字符串
     * @param substring     对比的字符串
     * @param message       错误信息
     */
    public static void doesNotContain(String textToSearch, String substring, String message) {
        if (org.springframework.util.StringUtils.hasLength(textToSearch) && org.springframework.util.StringUtils.hasLength(substring) && textToSearch.contains(substring)) {
            throw new JnSpringCloudException(CommonAssertExceptionEnum.ASSERT_NOT_CONTAINS_DATA, message);
        }
    }
    /**
     * 不能相同字符串
     * @param textToSearch  校验的字符串
     * @param substring     对比的字符串
     */
    public static void doesNotContain(String textToSearch, String substring) {
        doesNotContain(textToSearch, substring, CommonAssertExceptionEnum.ASSERT_NOT_CONTAINS_DATA.getMessage()+substring);
    }

    /**
     * 数组不能为空
     * @param array 数组
     * @param message   信息
     */
    public static void notEmpty(Object[] array, String message) {
        if (ObjectUtils.isEmpty(array)) {
            throw new JnSpringCloudException(CommonAssertExceptionEnum.ASSERT_ARRAY_NOT_EMPTY, message);
        }
    }
    /**
     * 数组不能为空
     * @param array 数组
     */

    public static void notEmpty(Object[] array) {
        notEmpty(array, CommonAssertExceptionEnum.ASSERT_ARRAY_NOT_EMPTY.getMessage());
    }
    /**
     * 数组里面不能有null值
     * @param array 数组
     * @param message 信息
     */
    public static void noNullElements(Object[] array, String message) {
        if (array != null) {
            Object[] var2 = array;
            int var3 = array.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                Object element = var2[var4];
                if (element == null) {
                    throw new JnSpringCloudException(CommonAssertExceptionEnum.ASSERT_ARRAY_NOT_ANY_EMPTY, message);
                }
            }
        }

    }
    /**
     * 数组里面不能有null值
     * @param array
     */

    public static void noNullElements(Object[] array) {
        noNullElements(array, CommonAssertExceptionEnum.ASSERT_ARRAY_NOT_ANY_EMPTY.getMessage());
    }

    /**
     * 集合不为空
     * @param collection
     * @param message
     */
    public static void notEmpty(Collection<?> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new JnSpringCloudException(CommonAssertExceptionEnum.ASSERT_COLLECTION_NOT_EMPTY, message);
        }
    }
    /**
     * 集合不为空
     * @param collection
     */

    public static void notEmpty(Collection<?> collection) {
        notEmpty(collection, CommonAssertExceptionEnum.ASSERT_COLLECTION_NOT_EMPTY.getMessage());
    }
    /**
     *  MAP不为空
     * @param map
     * @param message
     */
    public static void notEmpty(Map<?, ?> map, String message) {
        if (CollectionUtils.isEmpty(map)) {
            throw new JnSpringCloudException(CommonAssertExceptionEnum.ASSERT_MAP_NOT_EMPTY, message);
        }
    }
    /**
     *  MAP不为空
     * @param map
     */
    public static void notEmpty(Map<?, ?> map) {
        notEmpty(map, CommonAssertExceptionEnum.ASSERT_MAP_NOT_EMPTY.getMessage());
    }
    /**
     * instanceOf
     * @param type  源CLASS
     * @param obj   目标
     * @param message
     */
    public static void isInstanceOf(Class<?> type, Object obj, String message) {
        notNull(type);
        if (!type.isInstance(obj)) {
            throw new JnSpringCloudException(CommonAssertExceptionEnum.ASSERT_INSTANCE, message);
        }
    }
    /**
     * instanceOf
     * @param type  源CLASS
     * @param obj   目标
     */
    public static void isInstanceOf(Class<?> type, Object obj) {
        isInstanceOf(type, obj, CommonAssertExceptionEnum.ASSERT_INSTANCE.getMessage()+obj.getClass().getName());
    }

}
