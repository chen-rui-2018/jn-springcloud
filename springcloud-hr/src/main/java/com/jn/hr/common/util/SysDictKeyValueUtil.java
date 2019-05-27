package com.jn.hr.common.util;

import com.jn.system.model.SysPost;
import com.jn.system.vo.SysDictKeyValue;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

public class SysDictKeyValueUtil {
    public static String getKeyByLabel(List<SysDictKeyValue> dictList, String label){
        if(CollectionUtils.isEmpty(dictList)){
            return "";
        }
        for (SysDictKeyValue sysDictKeyValue : dictList) {
            if(sysDictKeyValue.getLable().equals(label)){
                return sysDictKeyValue.getKey();
            }
        }

        return "";
    }

    public static String getPostIdByName(List<SysPost> dictList, String postName){
        if(CollectionUtils.isEmpty(dictList)){
            return "";
        }
        for (SysPost sysPost : dictList) {
            if(sysPost.getPostName().equals(postName)){
                return sysPost.getId();
            }
        }

        return "";
    }
}
