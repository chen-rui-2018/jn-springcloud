package com.jn.oa.schedule.dao;

import com.jn.oa.schedule.model.Schedule;
import com.jn.oa.schedule.model.ScheduleQuery;

import java.util.List;

/**
 * 日程管理dao层
 *
 * @author： shaobao
 * @date： Created on 2019/3/23 10:45
 * @version： v1.0
 * @modified By:
 **/
public interface ScheduleMapper {

    /**
     * 查询日程
     *
     * @param scheduleQuery 查询条件
     * @return
     */
    List<Schedule> list(ScheduleQuery scheduleQuery);
}
