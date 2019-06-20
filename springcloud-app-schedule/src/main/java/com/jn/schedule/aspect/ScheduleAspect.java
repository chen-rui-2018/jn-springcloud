package com.jn.schedule.aspect;

import com.jn.common.util.StringUtils;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 *
 * @author： fengxh
 * @date： Created on 2018/11/22 16:50
 * @version： v1.0
 * @modified By:
 */
@Component
@Aspect
public class ScheduleAspect {

    private static Logger logger = LoggerFactory.getLogger(ScheduleAspect.class);


    @Around(value = " @annotation(scheduled)", argNames = "joinPoint, scheduled")
    public Object methodAround(ProceedingJoinPoint joinPoint, Scheduled scheduled) throws Throwable {
        //cron没有放行
        if(StringUtils.isBlank(scheduled.cron())) {
            return joinPoint.proceed();
        }
        logger.info("begin.进入【{}】的业务，定时器启动标准是：【{}】", joinPoint.toString(), scheduled.cron());
        long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            logger.warn("执行【{}】的业务，错误信息【{}】", joinPoint.toString(), e.toString());
            throw e;
        } finally {
            long end = System.currentTimeMillis();
            logger.info("end.完成【{}】的业务，耗时：【{}】,结果是：【{}】", joinPoint.toString(), (end - start) + "ms", result + "");
        }
        return result;
    }




}
