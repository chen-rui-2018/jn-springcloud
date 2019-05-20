package com.jn.enterprise.usercenterindex.service;

import com.jn.system.model.User;

/**
 * @Author: tangry
 * @Date: 2019/5/13
 * @Version 1.0
 */
public interface UserCenterIndexService {



    /**
     *员工申请
     * @param user
     * @return
     */
    String findEmployeeRequisition(User user);



    /**
     *顾问管理
     * @param user
     * @return
     */
    String findAdviserInvitation(User user);

    /**
     *需求管理
     * @param user
     * @return
     */
    String findRequirementManage(User user);

    /**
     *评价管理
     * @param user
     * @return
     */
    String findEvaluateManage(User user);

    /**
     *活动管理
     * @param user
     * @return
     */
    String findActivityManage(User user);

    /**
     *数据上报
     * @param user
     * @return
     */
    String findReportedData(User user);
}
