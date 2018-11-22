package com.jn.system.log.annotation;

import java.lang.annotation.*;

/**
 * service层的日志打印注解
 *
 * @author： fengxh
 * @date： Created on 2018/11/22 15:24
 * @version： v1.0
 * @modified By:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ServiceLog {

    /**
     * 具体的动作描述.eg.判断余额是否足够
     */
    String doAction() ;



}
