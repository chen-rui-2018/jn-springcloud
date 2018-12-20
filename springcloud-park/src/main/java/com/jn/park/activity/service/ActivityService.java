package com.jn.park.activity.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.activity.model.ActivityContentBean;
import com.jn.park.activity.model.ActivityDetail;

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
     * @param actiType
     * @param state
     * @param actiName
     * @param isIndex
     * @param page
     * @param rows
     * @return
     */
    PaginationData selectActivityList(String actiType,String state,String actiName,String isIndex,Integer page,Integer rows);

    /**
     * 查询活动详情
     * @param activityId
     * @return
     */
    ActivityDetail getActivityDetailsForManage(String activityId);

    /**
     * 活动状态管理(修改)
     * @param activityId
     * @param state 1可报名 0不可报名
     * @return
     */
    int updateActivityApply(String activityId, String state);

    /**
     * 发布活动/保存草稿
     * @param activity
     * @param account 当前登录用户
     * @return
     */
    int insertOrUpdateActivity(ActivityContentBean activity, String account);

    /**
     * 删除草稿活动数据
     * @param activityId . 多个id用,拼接
     * @return
     */
    int deleteDraftActivity(String activityId);

    /**
     * 删除活动(已发布列表，需管理员才能删除)
     * @param activityId . 多个id用,拼接
     * @return
     */
    int deleteActivity(String activityId);

    /**
     * 取消活动
     * @param activityId
     * @return
     */
    int cancelActivity(String activityId);

    /**
     * 活动列表App
     * @param typeId
     * @param page
     * @param keyWord
     * @return
     */

    PaginationData activityListSlim(String typeId, Page page, String keyWord);

	 /**
     * 手动发送活动通知接口
     * @param activityId
     * @return
     */
    int sendMsgForActivate(String activityId);
}
