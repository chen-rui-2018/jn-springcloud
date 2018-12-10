package com.jn.activity.service;

import com.jn.activity.entity.TbActivityApply;
import com.jn.common.model.Page;
import com.jn.common.model.Result;

import java.util.List;

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
    Result quickApply(String id, String account);

    /**
     * 取消报名
     * @param id        活动id
     * @param account   报名人账号
     * @return
     */
    Result cancelApply(String id, String account);

    /**
     * 前端参数非空校验
     * @param id      活动id
     * @param account 用户账号
     * @return
     */
    Result checkDataEmpty(String id,String account);

    /**
     * 后台管理-查询活动报名信息列表
     * @param activityId
     * @param page
     * @return
     */
    public List<TbActivityApply> applyActivityList(String activityId, Page page);

}
