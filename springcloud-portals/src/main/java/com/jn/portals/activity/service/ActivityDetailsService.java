package com.jn.portals.activity.service;

import com.jn.common.model.Result;

/**
 * 活动详情
 * @Author: yangph
 * @Date: 2018/12/5 15:16
 * @Version v1.0
 * @modified By:
 */
public interface ActivityDetailsService {
    /**
     * 获取活动详情
     * @param id 活动id
     * @return
     */
    Result getActivityDetails(String id);
}
