package com.jn.system.log.annotation;

import com.jn.system.log.enums.LogEnum;

import java.lang.annotation.*;

/**
 * controller层的日志打印注解
 *
 * @author： fengxh
 * @date： Created on 2018/11/22 15:24
 * @version： v1.0
 * @modified By:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ControllerLog {

    /**
     * 具体的业务描述.eg.缴费申请
     */
    String doAction() ;



}
