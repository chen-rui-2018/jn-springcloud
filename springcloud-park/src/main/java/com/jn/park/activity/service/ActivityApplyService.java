package com.jn.park.activity.service;

import com.jn.park.activity.entity.TbActivityApply;
import com.jn.common.model.Page;
import com.jn.system.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
     * @param page
     * @return
     */
    List<TbActivityApply> applyActivityList(String activityId, Page page);

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

}
