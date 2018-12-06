package com.jn.portals.activity.service;

import com.jn.common.model.Result;

/**
 * 活动报名
 * @Author: yangph
 * @Date: 2018/12/6 14:05
 * @Version v1.0
 * @modified By:
 */
public interface ActivityApplyService {
    /**
     * 快速报名
     * @param id        活动id
     * @param account   报名人账号
     * @return
     */
    Result quickApply(String id,String account);

    /**
     * 取消报名
     * @param id        活动id
     * @param account   报名人账号
     * @return
     */
    Result cancelApply(String id,String account);
}
