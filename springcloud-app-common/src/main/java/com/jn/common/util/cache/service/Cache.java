package com.jn.common.util.cache.service;

import java.util.Collection;
import java.util.Set;

/**
 * 缓存接口
 *
 * @author： fengxh
 * @date： Created on 2018/11/29 19:28
 * @version： v1.0
 * @modified By:
 */
public interface Cache <V> {
    /**
     * 获取缓存对象
     * @param key  key
     * @return
     */
    V get(String key) ;
    /**
     * 缓存数据
     * @param key
     * @param object
     * @return
     */
    V put(String key, V object) ;
    /**
     * 删除数据
     * @param key
     * @return
     */
    V remove(String key) ;
    /**
     * 清理
     */
    void clear() ;
    /**
     * 缓存size
     * @return
     */
    int size();
    /**
     * 获取缓存的全部key
     * @return
     */
    Set<String> keys();
    /**
     * 获取缓存的值
     * @return
     */
    Collection<V> values();
}
