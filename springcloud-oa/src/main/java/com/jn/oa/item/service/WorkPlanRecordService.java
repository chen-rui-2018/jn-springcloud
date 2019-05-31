package com.jn.oa.item.service;

import com.jn.oa.item.model.WorkPlanRecord;
import com.jn.system.model.User;

import java.util.List;

/**
 * 工作计划工作记录service接口
 *
 * @author： shaobao
 * @date： Created on 2019/3/20 14:22
 * @version： v1.0
 * @modified By:
 **/
public interface WorkPlanRecordService {

    /**
     * 批量记录工时
     *
     * @param workPlanRecordList
     * @param user
     */
    void addBatch(List<WorkPlanRecord> workPlanRecordList, User user);

    /**
     * 修改工时信息
     *
     * @param workPlanRecord
     * @param user
     */
    void update(WorkPlanRecord workPlanRecord, User user);

    /**
     * 删除工作记录
     *
     * @param workPlanRecordId
     * @param user
     */
    void delete(String workPlanRecordId, User user);

    /**
     * 查看工作记录信息
     *
     * @param workPlanId
     * @return
     */
    List<WorkPlanRecord> list(String workPlanId);
}
