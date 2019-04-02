package com.jn.oa.item.dao;

import com.jn.oa.item.model.WorkPlanRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 工作计划工作记录dao
 *
 * @author： shaobao
 * @date： Created on 2019/3/19 17:10
 * @version： v1.0
 * @modified By:
 **/
public interface WorkPlanRecordMapper {
    /**
     * 删除工作计划工作记录信息
     *
     * @param workPlanId
     * @param account
     */
    void delete(@Param("workPlanId") String workPlanId, @Param("account") String account);

    /**
     * 批量记录工时
     *
     * @param workPlanRecordList
     */
    void addBatch(List<WorkPlanRecord> workPlanRecordList);
}
