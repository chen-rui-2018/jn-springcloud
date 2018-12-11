package com.jn.common.util.lock.service;

/**
 * 锁
 *
 * @author： fengxh
 * @date： Created on 2018/12/10 16:40
 * @version： v1.0
 * @modified By:
 */
public interface Lock {
    /**
     * 获取锁
     * @param account 账号
     * @param lockKey 业务key
     * @param expireTime    过期时间（秒）
     * @return
     */
    Boolean getLock(String account,String lockKey,Integer expireTime);

    /**
     * 释放锁
     * @param account   账号
     * @param lockKey   业务key
     * @return
     */
    Boolean releaseLock(String account,String lockKey);
}
