package com.jn.common.util.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <从Spring IOC容器中获取Bean对象> <功能详细描述>
 *
 * @author： fengxh
 * @date： Created on 2019/6/16 15:01
 * @version： v1.0
 * @modified By:
 */
@Component("beanHeader")
public class BeanHeader implements ApplicationContextAware {


    // 上下文对象
    private static ApplicationContext APPLICATIONCONTEXT;

    /**
     * 实现ApplicationContextAware接口的回调方法，注入上下文对象
     * @param APPLICATIONCONTEXT
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext APPLICATIONCONTEXT)
            throws BeansException
    {
        BeanHeader.APPLICATIONCONTEXT = APPLICATIONCONTEXT;
    }

    /**
     * 获取上下文对象
     * @return APPLICATIONCONTEXT
     */
    public static ApplicationContext getApplicationContext()
    {
        return APPLICATIONCONTEXT;
    }

    /**
     * 判断上下文对象是否为空
     *
     * @return
     */
    public static boolean checkAPPLICATIONCONTEXT()
    {
        boolean flag = getApplicationContext() != null;
        return flag;
    }

    /**
     * 根据name获取bean
     * @param name
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name)
    {
        if (checkAPPLICATIONCONTEXT())
        {
            return (T)getApplicationContext().getBean(name);
        }
        else
        {
            return null;
        }
    }

    /**
     * 根据class 获取bean
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz)
    {
        if (checkAPPLICATIONCONTEXT())
        {
            return getApplicationContext().getBean(clazz);
        }
        else
        {
            return null;
        }
    }

    /**
     * 根据name,以及Clazz返回指定的Bean
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> clazz)
    {
        if (checkAPPLICATIONCONTEXT())
        {
            return getApplicationContext().getBean(name, clazz);
        }
        else
        {
            return null;
        }
    }
}