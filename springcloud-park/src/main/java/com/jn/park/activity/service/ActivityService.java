package com.jn.park.activity.service;

import com.jn.common.model.PaginationData;
import com.jn.park.activity.model.*;

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
     * @param activityParment
     * @return
     */
    PaginationData<List<Activity>> selectActivityList(ActivityParment activityParment);

    /**
     * 查询活动详情[后台管理]
     * @param activityId
     * @return
     */
    ActivityDetail getActivityDetailsForManage(String activityId);

    /**
     * 活动状态管理(修改)
     * @param activityStatus
     * @return
     */
    int updateActivityApply( ActivityStatus activityStatus);

    /**
     * 发布活动/保存草稿
     * @param activity
     * @param account 当前登录用户
     * @return
     */
    int insertOrUpdateActivity(ActivityContent activity, String account);

    /**
     * 删除草稿活动数据
     * @param activityId . 多个id用,拼接
     * @return
     */
    int deleteDraftActivity(String[] activityId,String account);

    /**
     * 删除活动(已发布列表，需管理员才能删除)
     * @param activityId . 多个id用,拼接
     * @return
     */
    int deleteActivity(String[] activityId,String account);

    /**
     * 取消活动
     * @param activityId
     * @return
     */
    int cancelActivity(String activityId,String account);

    /**
     * 前台分页获取的活动列表
     * @param activitySlimQuery
     * @param account
     * @return
     */

    PaginationData<List<ActivitySlim>> activityListSlim(ActivitySlimQuery activitySlimQuery ,String account);

	 /**
     * 手动发送活动通知接口
     * @param activityId
     * @return
     */
    int sendMsgForActivate(String activityId);

    /**
     * 活动结束回调方法
     * @param activity
     * @return
     */
    int activityEndByTimedTask(ActivityContent activity);

    /**
     * 活动消息自动推送回调接口
     * @param activity
     * @return
     */
    int activitySendMessageByTimedTask(ActivityContent activity);

    /**
     * 查看用户的报名活动列表
     * @param query
     * @param needPage
     * @return
     */
    PaginationData findActivitySuccessfulRegistration(ActivityApplyListParam query, Boolean needPage);

    /**
     * 查看机构活动资讯列表
     * @param query
     * @param activityType
     * @param needPage
     * @return
     */
    PaginationData findOrgActivityList( OrgActivityParam query,String activityType,boolean needPage);

    /**
     * 获取有效活动总数
     * @return
     */
    String getActivityNum();

    /**
     * 获取企业报报名活动信息
     * @param param
     * @return
     */
    List<CompanyActivityApplyShow> getCompanyActivityApplyInfo(CompanyActivityApplyParam param);

    /**
     * 获取累计举办活动总数
     * @return
     */
    Integer getActivityHistoryNum();

}
