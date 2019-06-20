package com.jn.park.attractinvest.service;

import com.jn.park.attractinvest.vo.ProjectInfoVo;
import com.jn.system.model.User;

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

    /**
     * 企业入驻流程后置处理
     *
     * @param projectInfoVo
     * @param user          当前用户
     */
    void enterpriseEnterHandle(ProjectInfoVo projectInfoVo, User user);
}
