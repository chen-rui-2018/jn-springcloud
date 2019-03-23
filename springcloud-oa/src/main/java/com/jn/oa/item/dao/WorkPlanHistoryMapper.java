package com.jn.oa.item.dao;

import com.jn.oa.item.entity.TbOaWorkPlanHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 工作计划历史记录dao
 *
 * @author： shaobao
 * @date： Created on 2019/3/19 17:09
 * @version： v1.0
 * @modified By:
 **/
public interface WorkPlanHistoryMapper {
    /**
     * 删除工作计划历史记录信息
     *
     * @param workPlanId
     * @param account
     */
    void delete(@Param("workPlanId") String workPlanId, @Param("account") String account);

    /**
     * 批量保存工作计划历史记录信息
     *
     * @param tbOaWorkPlanHistoryList
     */
    void insertBatch(List<TbOaWorkPlanHistory> tbOaWorkPlanHistoryList);
}
