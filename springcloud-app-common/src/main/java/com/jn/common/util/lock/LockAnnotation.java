package com.jn.common.util.lock;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * 锁注解
 *
 * @author： fengxh
 * @date： Created on 2018/11/22 15:24
 * @version： v1.0
 * @modified By:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface LockAnnotation {
    /**
     * 锁（唯一键）参数名字
     * @return
     */
    String lockPrefix() ;
    /**
     * 操作人账号参数名字
     * @return
     */
    String account() default "guest";
    /**
     * 锁定时长,秒为单位
     * @return
     */
    int timeOut() default 60;
    /**
     * 尝试获取次数
     * 如果设置建议不要超过3次
     * @return
     */
    int tryCount() default 0;
    /**
     * 尝试获取间隔（毫秒作为单位）
     * @return
     */
    long tryTime() default 500;
}
