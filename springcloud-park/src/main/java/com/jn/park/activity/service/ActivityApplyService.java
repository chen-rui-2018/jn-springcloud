package com.jn.park.activity.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
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
     * @param id        活动id
     * @param account   报名人账号
     * @return
     */
    void quickApply(String id, String account);

    /**
     * 取消报名
     * @param id        活动id
     * @param account   报名人账号
     * @return
     */
    void cancelApply(String id, String account);


    /**
     * 后台管理-查询活动报名信息列表
     * @param activityId
     * @param page  不分页传null
     * @return
     */
    PaginationData applyActivityList(String activityId, Page page);

    /**
     * 生成二维码
     * @param outputStream
     * @param data :需要生成二维码的数据
     */
    void getQrCode (OutputStream outputStream, String data) throws IOException;

    /**
     * 前台用户签到接口
     * @param user
     * @param activityId
     * @return
     */
    int signInActivity(User user,String activityId);

    /**
     * 报名人列表信息
     * @param activityId
     * @param page
     * @return
     */
    PaginationData findApplyActivityList(String activityId, Page page);
}
