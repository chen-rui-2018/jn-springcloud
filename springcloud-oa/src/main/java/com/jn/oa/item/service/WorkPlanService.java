package com.jn.oa.item.service;

import com.jn.common.model.PaginationData;
import com.jn.oa.item.entity.TbOaWorkPlan;
import com.jn.oa.item.model.WorkPlanPage;
import com.jn.system.model.User;

/**
 * 工作计划管理服务层接口
 *
 * @author： shaobao
 * @date： Created on 2019/2/20 oa:44
 * @version： v1.0
 * @modified By:
 **/
public interface WorkPlanService {

    /**
     * 工作计划列表
     *
     * @param workPlanPage 分页查询条件
     * @param user         当前登录用户信息
     * @return
     */
    PaginationData list(WorkPlanPage workPlanPage, User user);
}
