package com.jn.park.activity.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.activity.model.ActivityApplyDetail;
import com.jn.park.activity.model.ActivityApplyListEasyParam;
import com.jn.park.activity.model.ActivityApplyParam;
import com.jn.park.activity.model.ActivityPagingParam;
import com.jn.user.model.UserExtensionInfo;

import java.io.IOException;
import java.io.OutputStream;
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
     * @param activityId 活动id
     * @param account    报名人账号
     * @return
     */
    void quickApply(String activityId, String account);

    /**
     * 取消报名
     * @param activityId 活动id
     * @param account    报名人账号
     * @return
     */
    void cancelApply(String activityId, String account);


    /**
     * 后台管理-查询活动报名信息列表
     * @param activityApplyParam
     * @param needPage 是否需要分页
     * @return
     */
    PaginationData<List<ActivityApplyDetail>> applyActivityList(ActivityApplyParam activityApplyParam, Boolean needPage);

    /**
     * 根据报名状态查询活动报名列表
     * @param param
     * @return
     */
    PaginationData<List<ActivityApplyDetail>> applyActivityListByApplyStatus(ActivityApplyListEasyParam param);


    /**
     * 生成二维码
     * @param outputStream
     * @param data :需要生成二维码的数据
     * @throws  IOException
     */
    void getQrCode (OutputStream outputStream, String data) throws IOException;

    /**
     * 前台用户签到接口
     * @param account
     * @param activityId
     * @return
     */
    int signInActivity(String account,String activityId);

    /**
     * 后台签到管理签到接口
     * @param applyId
     * @return
     */
    int signInActivityBackend(String applyId,String account);

    /**
     * 后台管理报名审核接口
     * @param applyId
     * @return
     */
    int signInActivityCheck(String applyId,String account);

    /**
     * 报名人列表信息
     * @param activityPagingParam
     * @param isPage  true：分页  false:不分页
     * @return
     */
    PaginationData findApplyActivityList(ActivityPagingParam activityPagingParam, Boolean isPage);

    /**
     * 报名人账号信息
     * @param activityIdList
     * @return
     */
    List<ActivityApplyDetail> findApplyAccountList(List<String> activityIdList);

    /**
     *
     * 新增活动报名信息
     * @param activityId 活动id
     * @param account    用户账号
     * @param status     报名状态 0:取消报名   1：报名成功   2：待审核
     */
    void addApplyInfo(String activityId, String account,String status);

    /**
     * 报名人资料
     * @param account
     * @return
     */
    UserExtensionInfo activityApplyInfo(String account);
}
