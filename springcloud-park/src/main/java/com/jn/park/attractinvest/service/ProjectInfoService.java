package com.jn.park.attractinvest.service;

/**
 * 项目管理service
 *
 * @author： shaobao
 * @date： Created on 2019/4/29 9:41
 * @version： v1.0
 * @modified By:
 **/
public interface ProjectInfoService {

    /**
     * 定时更新项目管理拟制合同状态
     */
    void updateProjectInfoStatus();

    /**
     * 项目管理，拟制合同状态不正常提醒功能
     */
    void projectRemind();
}
