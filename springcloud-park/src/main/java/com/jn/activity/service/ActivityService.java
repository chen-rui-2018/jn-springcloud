package com.jn.activity.service;

import com.jn.activity.model.Activity;
import com.jn.common.model.Page;
import com.jn.common.model.Result;

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

    public Result selectActivityList(Activity activity);

    /**
     * 查询活动详情
     * @param activityId
     * @return
     */
    public Result getActivityDetailsForManage(String activityId);

    /**
     * 活动状态管理(修改)
     * @param activityId
     * @param state 1可报名 0不可报名
     * @return
     */
    public Result updateActivityApply(String activityId, String state);

    /**
     * 发布活动/保存草稿
     * @param activity
     * @return
     */
    public Result insterOrUpdateActivity(Activity activity);

    /**
     * 删除草稿活动数据
     * @param activityId . 多个id用,拼接
     * @return
     */
    public Result deleteDraftActivity(String activityId);

    /**
     * 删除活动(已发布列表，需管理员才能删除)
     * @param activityId . 多个id用,拼接
     * @return
     */
    public Result deleteActivity(String activityId);

    /**
     * 取消活动
     * @param activityId
     * @return
     */
    public Result cancelActivity(String activityId);

    /**
     * 查询活动报名信息列表
     * @param activityId
     * @param page
     * @return
     */
    public Result applyActivityList(String activityId, Page page);
}
