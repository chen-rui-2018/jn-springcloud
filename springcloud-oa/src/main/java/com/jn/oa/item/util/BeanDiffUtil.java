package com.jn.oa.item.util;


import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.common.util.enums.EnumUtil;
import com.jn.oa.item.enmus.WorkPlanPropertiesEnmus;
import com.jn.oa.item.enmus.WorkPlanStatusEnums;
import org.apache.commons.beanutils.BeanMap;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * 比较Bean对象修改前后值变化情况
 *
 * @author： shaobao
 * @date： Created on 2019/3/5 14:46
 * @version： v1.0
 * @modified By:
 **/
public class BeanDiffUtil {

    public static String diff(Object newobj, Object oldobj) {
        StringBuffer buffer = new StringBuffer();

        BeanMap newMap = new BeanMap(newobj);
        BeanMap oldMap = new BeanMap(oldobj);

        // 遍历
        Iterator<Map.Entry<Object, Object>> iter = newMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = iter.next();
            String key = (String) entry.getKey();
            Object newValue = entry.getValue();

            Object oldValue = oldMap.get(key);

            // 过滤 null 值，和 主键值,附件,项目id
            Boolean flag = newValue != null && (!Objects.equals("id", key))
                    && (!Objects.equals("attachment", key)) && (!Objects.equals("itemId", key));
            if (flag) {
                //判断不相等的情况
                if (!Objects.equals(newValue, oldValue)) {
                    WorkPlanPropertiesEnmus enmus = EnumUtil.getByCode(key, WorkPlanPropertiesEnmus.class);
                    //如果值是时间类型,格式化时间格式
                    if (newValue instanceof Date) {
                        String newStr = DateUtils.formatDate((Date) newValue, "yyyy-MM-dd HH:mm:ss");
                        String oldStr = null;
                        //如果时间旧值为空,则复初始值
                        if (oldValue == null) {
                            oldStr = "00-00-00 00:00:00";
                        } else {
                            oldStr = DateUtils.formatDate((Date) oldValue, "yyyy-MM-dd HH:mm:ss");
                        }
                        appendRecode(buffer, enmus, newStr, oldStr);

                    } else if (StringUtils.equals(WorkPlanPropertiesEnmus.WORK_PLAN_STATUS.getCode(), key)) {
                        //若是修改状态,则通过枚举获取改变状态值
                        WorkPlanStatusEnums newEnmus = EnumUtil.getByCode((String) newValue, WorkPlanStatusEnums.class);
                        WorkPlanStatusEnums oldEnmus = EnumUtil.getByCode((String) oldValue, WorkPlanStatusEnums.class);
                        appendRecode(buffer, enmus, newEnmus.getMessage(), oldEnmus.getMessage());
                    } else {
                        //若新的值不等于旧值
                        appendRecode(buffer, enmus, newValue, oldValue);
                    }
                }
            }
        }

        // 重新转为 对应的 entity , bean 对象
        return buffer.toString();
    }

    private static void appendRecode(StringBuffer buffer, WorkPlanPropertiesEnmus enmus, Object newStr, Object oldStr) {
        buffer.append("<p>修改了&nbsp;&nbsp;<i style=\"color:black;font-weight:600\">").append(enmus.getMessage())
                .append(" </i>,&nbsp;&nbsp;旧值为:&nbsp;&nbsp;\"").append(oldStr)
                .append("\",&nbsp;&nbsp;新值为: &nbsp;&nbsp;\"").append(newStr).append("\"。</p>");
    }
}
