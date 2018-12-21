package com.jn.park.activity.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.model.ActivityApplyParment;
import com.jn.system.model.User;

import java.io.IOException;
import java.io.OutputStream;

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
     * @param activityApplyParment
     * @param needPage 是否需要分页
     * @return
     */
    PaginationData applyActivityList(ActivityApplyParment activityApplyParment, Boolean needPage);

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
     * 报名人列表信息
     * @param activityId
     * @param page
     * @param rows
     * @return
     */
    PaginationData findApplyActivityList(String activityId, Integer page,Integer rows);

    /**
     * 新增活动报名信息
     * @param id        活动id
     * @param account   用户账号
     */
    void addApplyInfo(String id, String account);
}
