package com.jn.park.utils;

import java.util.*;

/**
 * bean对象转map
 * Created by wuzx on 2017/7/26
 */
public class ObjToMapUtil {
	public static List<Map<String, Object>> listToMap(List<?> list) {
		List<Map<String, Object>> listNew=new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map=(Map<String, Object>) objToMap(list.get(i));
			Map<String, Object> map1 = new HashMap<String, Object>();
			for (String stringStringEntry : map.keySet()) {
				String val = map.get(stringStringEntry)+"";
				if(val==null || "null".equals(val)){
					val = "";
				}
				//字符预处理，防止异常字符导致excel打不开
				val=val.replaceAll("\n|\t", "").replaceAll("\\?", "");
				val=val.trim();
				map1.put(stringStringEntry,val)	;
			}
			listNew.add(map1);
		}
		return listNew;
	}

	/**
	 * 对象转map
	 * @param obj
	 * @return
	 */
	public static Map<?, ?> objToMap(Object obj) {
		if (obj == null){
			return null;
		}
		return new org.apache.commons.beanutils.BeanMap(obj);
	}

	/**
	 * map转对象
	 * @param map
	 * @param beanClass
	 * @return
	 * @throws Exception
	 */
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
		if (map == null){
			return null;
		}
		Object obj = beanClass.newInstance();
		org.apache.commons.beanutils.BeanUtils.populate(obj, map);
		return obj;
	}
}
