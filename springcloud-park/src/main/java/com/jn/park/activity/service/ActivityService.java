package com.jn.park.activity.service;

import com.jn.common.model.PaginationData;
import com.jn.park.model.ActivityContentBean;
import com.jn.park.model.ActivityDetail;

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
     * @param status
     * @param actiName
     * @param isIndex
     * @param page
     * @param rows
     * @return
     */
    PaginationData selectActivityList(String actiType,String status,String actiName,String isIndex,Integer page,Integer rows);

    /**
     * 查询活动详情
     * @param activityId
     * @return
     */
    ActivityDetail getActivityDetailsForManage(String activityId);

    /**
     * 活动状态管理(修改)
     * @param activityId
     * @param status 1可报名 0不可报名
     * @return
     */
    int updateActivityApply(String activityId, String status);

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
     * 前台获取的活动列表
     * @param typeId
     * @param page
     * @param rows
     * @param keyWord
     * @return
     */

    PaginationData activityListSlim(String typeId, Integer page,Integer rows, String keyWord);

	 /**
     * 手动发送活动通知接口
     * @param activityId
     * @return
     */
    int sendMsgForActivate(String activityId);
}
