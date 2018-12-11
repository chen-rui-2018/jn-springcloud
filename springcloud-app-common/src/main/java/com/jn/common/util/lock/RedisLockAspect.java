package com.jn.common.util.lock;

import com.jn.common.enums.CommonLockExceptionEnum;
import com.jn.common.util.lock.service.Lock;
import org.apache.ibatis.javassist.ClassClassPath;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.javassist.bytecode.CodeAttribute;
import org.apache.ibatis.javassist.bytecode.LocalVariableAttribute;
import org.apache.ibatis.javassist.bytecode.MethodInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 锁切面
 *
 * @author： fengxh
 * @date： Created on 2018/12/22 16:50
 * @version： v1.0
 * @modified By:
 */
@Component
@Aspect
@Order(2)
public class RedisLockAspect {

    private static Logger logger = LoggerFactory.getLogger(RedisLockAspect.class);


    @Autowired
    private Lock redisLock;


    @Around(value = " @annotation(lock)", argNames = "joinPoint, lock")
    public Object redisLockMethodAround(ProceedingJoinPoint joinPoint, LockAnnotation lock) throws Throwable {
        //获取参数MAP
        Object[] args = joinPoint.getArgs();
        String classType = joinPoint.getTarget().getClass().getName();    
        Class<?> clazz = Class.forName(classType);    
        String clazzName = clazz.getName();    
        String methodName = joinPoint.getSignature().getName();
        Map<String,Object> nameAndArgs;
        try{
            nameAndArgs = this.getFieldsName(this.getClass(), clazzName, methodName,args);
        }catch (Exception e){
            logger.warn("类解析异常",e);
            throw new JnSpringCloudLockException(CommonLockExceptionEnum.LOCK_INTO_ERROR);
        }
        //获取注解数据
        if (!nameAndArgs.containsKey(lock.lockPrefix()) || !(nameAndArgs.get(lock.lockPrefix()) instanceof String)) {
            throw new JnSpringCloudLockException(CommonLockExceptionEnum.LOCK_INTO_ERROR);
        }
        if (nameAndArgs.containsKey(lock.account()) && !(nameAndArgs.get(lock.account()) instanceof String)) {
            throw new JnSpringCloudLockException(CommonLockExceptionEnum.LOCK_INTO_ERROR);
        }
        String lockKey = nameAndArgs.get(lock.lockPrefix()).toString() ;
        String account = nameAndArgs.get(lock.account())==null?lock.account():nameAndArgs.get(lock.account()).toString();
        int timeOut = lock.timeOut();
        int tryCount = lock.tryCount();
        long tryTime = lock.tryTime();
        // 获取锁的超时时间，超过这个时间则放弃获取锁
        long end = System.currentTimeMillis() + (tryTime*tryCount);
        Boolean var = Boolean.FALSE;
        int var2 = 1;
        while (System.currentTimeMillis() <= end) {
            logger.info("用户【{}】,第【{}】次获取锁",account,var2++);
            var = redisLock.getLock(account,lockKey,timeOut);
            if (var) {
               break;
            }
            try {
                Thread.sleep(tryTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        if (!var) {
            throw new JnSpringCloudLockException(CommonLockExceptionEnum.LOCK_FAIL);
        }
        logger.info("用户【{}】,获取锁成功，key值为:【{}】",account,lockKey);
        Object result ;
        try {
            result = joinPoint.proceed();
        }catch (Exception e){
            throw e;
        }finally {
            boolean release = redisLock.releaseLock(account,lockKey);
            logger.info("用户【{}】,释放锁，key值为:【{}】,结果是:【{}】",account,lockKey,release);
        }
        return result;
    }

    /**
     * @Description 获取字段名和字段值
     * @return Map<String,Object>
     */
    private Map<String,Object> getFieldsName(Class cls, String clazzName, String methodName, Object[] args) throws Exception {
        Map<String,Object > map=new HashMap<>();
        ClassPool pool = ClassPool.getDefault();
        ClassClassPath classPath = new ClassClassPath(cls);
        pool.insertClassPath(classPath);
        CtClass cc = pool.get(clazzName);
        CtMethod cm = cc.getDeclaredMethod(methodName);
        MethodInfo methodInfo = cm.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        if (attr == null) {
            throw new JnSpringCloudLockException(CommonLockExceptionEnum.LOCK_INTO_ERROR);
        }
        String[] parameterNames = new String[args.length];
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
        TreeMap<Integer, String> sortMap = new TreeMap<>();
        for(int i = 0; i < attr.tableLength(); i++) {
            sortMap.put(attr.index(i), attr.variableName(i));
        }
        parameterNames = Arrays.copyOfRange(sortMap.values().toArray(new String[0]), pos, parameterNames.length + pos);
        for(int i = 0; i< parameterNames.length;i++){
            map.put(parameterNames[i],args[i]);
        }
        return map;
    }    




}
