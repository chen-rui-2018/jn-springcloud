package com.jn.activity.service;

import com.jn.activity.model.Activity;
import com.jn.common.model.PaginationData;


/**
 * 活动
 * @Author: jiangyl
 * @Date: 2018/12/5 16:59
 * @Version v1.0
 * @modified By:
 */
public interface ActivityService {

    /**
     * 查询后台管理活动列表
     * @param activity
     * @return
     */
    public PaginationData selectActivityList(Activity activity);

}
