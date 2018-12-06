package com.jn.portals.activity.service;

import com.jn.common.model.PaginationData;
import com.jn.portals.activity.model.Activity;

import java.util.List;

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
