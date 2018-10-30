package com.jn.system.config;

import com.jn.system.model.User;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;
import java.util.concurrent.TimeUnit;
/**
 * redis缓存
 *
 * @author： fengxh
 * @date： Created on 2018/9/20 15:31
 * @version： v1.0
 * @modified By:
 */
class RedisCache<K, V> implements Cache<K, V> {
	

	private RedisTemplate<String, Object> redisTemplate;	

	private String keyPrefix ;
	
	private int expire;

	public RedisCache(RedisTemplate<String, Object> redisTemplate, String prefix,int expire){
		 this.redisTemplate = redisTemplate;
		 this.keyPrefix = prefix;
		 this.expire = expire;
	}
 	
	@Override
	public V get(K key) throws CacheException {
		try {
			if (key == null) {
	            return null;
	        }else{
				Object k=getKey(key);
				V value = (V)redisTemplate.opsForValue().get(keyPrefix+k);
	        	return value;
	        }
		} catch (Throwable t) {
			throw new CacheException(t);
		}

	}

	@Override
	public V put(K key, V value) throws CacheException {
		 try {
			 	Object k=getKey(key);
			 	redisTemplate.opsForValue().set(keyPrefix+k, value,expire, TimeUnit.MILLISECONDS);
	            return value;
	        } catch (Throwable t) {
	            throw new CacheException(t);
	        }
	}

	@Override
	public V remove(K key) throws CacheException {

		try {
			Object k=getKey(key);
            V previous = get(key);
            redisTemplate.delete(keyPrefix+k);
            return previous;
        } catch (Throwable t) {
            throw new CacheException(t);
        }
	}

	@Override
	public void clear() throws CacheException {

		try {
			redisTemplate.delete(redisTemplate.keys(keyPrefix+"*"));
		} catch (Throwable t) {
            throw new CacheException(t);
        }
	}

	@Override
	public int size() {
		try {
            return redisTemplate.keys(keyPrefix+"*").size();
        } catch (Throwable t) {
            throw new CacheException(t);
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<K> keys() {
		try {
            Set<String> keys = redisTemplate.keys(keyPrefix+"*");
            if (CollectionUtils.isEmpty(keys)) {
            	return Collections.emptySet();
            }else{
            	Set<K> newKeys = new HashSet<>();
            	for(String key:keys){
            		newKeys.add((K)key);
            	}
            	return newKeys;
            }
        } catch (Throwable t) {
            throw new CacheException(t);
        }
	}

	@Override
	public Collection<V> values() {
		try {
			 Set<String> keys = redisTemplate.keys(keyPrefix+"*");
            if (!CollectionUtils.isEmpty(keys)) {
                List<V> values = new ArrayList<V>(keys.size());
                for (String key : keys) {
                    @SuppressWarnings("unchecked")
					V value = get((K)key);
                    if (value != null) {
                        values.add(value);
                    }
                }
                return Collections.unmodifiableList(values);
            } else {
                return Collections.emptyList();
            }
        } catch (Throwable t) {
            throw new CacheException(t);
        }
	}

	/**
	 * 使用用户对象获取用户ID作为缓存的key
	 * @param key
	 * @return
	 */
	private Object getKey(K key) {
		if(key instanceof PrincipalCollection) {
			PrincipalCollection pc=(PrincipalCollection) key;
			User user =(User)pc.getPrimaryPrincipal();
			return user.getId();
		}
		return key;
	}
	public int getExpire() {
		return expire;
	}

	public void setExpire(int expire) {
		this.expire = expire;
	}

}
