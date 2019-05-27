package com.jn.hr.common.util;

import com.jn.hr.archives.model.TreeModel;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartMentUtil {
    public static Map<String,String> convertDepartList(List<HashMap<String, Object>> list){
        Map<String,String> map=new HashMap<String,String>();
        if(CollectionUtils.isEmpty(list)){
            return map;
        }
        for (HashMap<String, Object> stringObjectHashMap : list) {
            map.put((String) stringObjectHashMap.get("departmentName"),(String)stringObjectHashMap.get("id"));
            if (stringObjectHashMap.get("children") != null) {
                List<HashMap<String, Object>> childrenSub = (List<HashMap<String, Object>>) stringObjectHashMap.get("children");
                setTreeChildren(map, childrenSub);

            }
        }
        return map;
    }
    private static void setTreeChildren(Map<String,String> map, List<HashMap<String,Object>> children){
        if(children==null || children.size()==0){
            return;
        }
        for (HashMap<String, Object> childMap : children) {
            map.put((String) childMap.get("departmentName"),(String)childMap.get("id"));
            if (childMap.get("children") != null) {
                List<HashMap<String, Object>> childrenSub = (List<HashMap<String, Object>>) childMap.get("children");
                setTreeChildren(map, childrenSub);
            }

        }
    }
}
