package com.jn.oa.schedule.service;

import com.jn.oa.model.Schedule;
import com.jn.oa.schedule.model.ScheduleEdit;
import com.jn.oa.schedule.model.ScheduleQuery;
import com.jn.system.model.User;

import java.util.List;

/**
 * 日程管理service层
 *
 * @author： shaobao
 * @date： Created on 2019/3/22 16:56
 * @version： v1.0
 * @modified By:
 **/
public interface ScheduleService {

    /**
     * 添加/修改日程管理
     *
     * @param schedule 日程管理数据
     * @param isAdd    是否添加
     * @param user     当前用户
     */
    void addOrUpdate(ScheduleEdit schedule, Boolean isAdd, User user);

    /**
     * 删除日程
     *
     * @param scheduleId 日程id
     * @param user       当前用户
     */
    void delete(String scheduleId, User user);

    /**
     * 查询日程
     *
     * @param shceduleQuery 查询条件
     * @return
     */
    List<Schedule> list(ScheduleQuery shceduleQuery);

    /**
     * 根据日程id获取日程信息详情
     *
     * @param id
     * @return
     */
    Schedule getScheduleById(String id);

    /**
     * 日程管理定时提醒功能
     *
     * @param schedule
     */
    void scheduleRemind(Schedule schedule);
}
