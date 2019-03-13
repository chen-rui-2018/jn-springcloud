package com.jn.oa.item.dao;

import com.jn.oa.item.model.WorkPlanPage;
import com.jn.oa.item.vo.WorkPlanVO;

import java.util.List;

/**
 * 工作计划持久层
 *
 * @author： shaobao
 * @date： Created on 2019/2/20 17:19
 * @version： v1.0
 * @modified By:
 **/
public interface WorkPlanMapper {
    /**
     * 工作计划列表功能
     * @param workPlanPage
     * @return
     */
    List<WorkPlanVO> list(WorkPlanPage workPlanPage);
}
