package com.jn.park.customer.service;

import com.jn.common.model.PaginationData;
import com.jn.park.customer.model.*;

/**
 * 客服中心--园区客服中心
 * @Author: yangph
 * @Date: 2019/5/14 9:42
 * @Version v1.0
 * @modified By:
 */
public interface CustomerServiceCenterManageService {
    /**
     * 我的待办事项
     * @param myTasksParam
     * @param loginAccount
     * @return
     */
    PaginationData myTasks(MyTasksParam myTasksParam,String loginAccount);

    /**
     * 我的已办事项
     * @param myTasksParam
     * @param loginAccount
     * @return
     */
    PaginationData myHandled(MyTasksParam myTasksParam,String loginAccount);

    /**
     * 获取流程表单
     * @param processInsId
     * @param loginAccount
     * @return
     */
    IBPSOnlineCustomerForm getInstForm(String processInsId, String loginAccount);

    /**
     * 处理任务
     * @param customerParam
     * @param loginAccount
     * @return
     */
    int complete(IBPSCompleteCustomerParam customerParam, String loginAccount);

    /**
     * 园区客服中心
     * @param param
     * @param loginAccount
     * @return
     */
    PaginationData myTasksOrMyHandled(MyTasksOrMyHandledParam param,String loginAccount);

    /**
     * 根据手机号获取用户信息
     * @param phone
     * @return
     */
    UserIntroInfo getUserInfo(String phone);

    /**
     * 获取服务模块信息
     * @param phone
     * @return
     */
    PaginationData getCalledHistory(String phone);

    /**
     * 保存来电录入信息
     * @param calledInfoParam
     * @param loginAccount
     * @return
     */
    int saveCalledInfo(CalledInfoParam calledInfoParam,String loginAccount);

    /**
     * 来电归属地查询
     * @param phone
     * @return
     */
    String getPhoneCalledOwen(String phone);
}
