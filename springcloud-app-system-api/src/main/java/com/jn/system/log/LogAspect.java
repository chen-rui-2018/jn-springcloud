package com.jn.system.log;

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
@Order(0)
public class LogAspect {

    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);


    @Around(value = " @annotation(log)", argNames = "joinPoint, log")
    public Object methodAround(ProceedingJoinPoint joinPoint, ControllerLog log) throws Throwable {
        String accountName = this.getUserName();
        logger.info("begin.用户【{}】，进入【{}】的业务，对应的应用地址：【{}】", accountName, log.doAction(), joinPoint.toString());
        Object[] args = joinPoint.getArgs();
        StringBuffer argsBuffer = new StringBuffer();
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                argsBuffer.append("入参").append(i).append("：【").append(args[i]+"").append("】;");
            }
        }
        logger.info(argsBuffer.toString());
        long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            logger.warn("用户【{}】，执行【{}】的业务，错误信息【{}】", accountName, log.doAction(), e.toString());
            throw e;
        } finally {
            long end = System.currentTimeMillis();
            logger.info("end.用户【{}】，完成【{}】的业务，耗时：【{}】,结果是：【{}】", accountName, log.doAction(), (end - start) + "ms", result + "");
        }
        return result;
    }

    @Before(value = "@annotation(log)", argNames = "joinPoint, log")
    public void methodBefore(JoinPoint joinPoint, ServiceLog log) {
        logger.info("进入【{}】的方法，对应的应用地址：【{}】", log.doAction(), joinPoint.toString());
    }


    /**
     * 获取用户账号
     *
     * @return
     */
    private String getUserName() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return user == null ? "guest" : user.getAccount();
    }


}
