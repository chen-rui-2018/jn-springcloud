package com.jn.oa.item.dao;

import com.jn.oa.item.entity.TbOaWorkPlanUser;
import com.jn.oa.item.vo.WorkPlanRemindUserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 工作计划负责人dao
 *
 * @author： shaobao
 * @date： Created on 2019/3/19 17:10
 * @version： v1.0
 * @modified By:
 **/
public interface WorkPlanUserMapper {
    /**
     * 删除工作计划负责人信息
     *
     * @param workPlanId 工作计划id
     * @param account    当前用户账号
     */
    void delete(@Param("workPlanId") String workPlanId, @Param("account") String account);

    /**
     * 查询所有未完成任务信息
     *
     * @return
     */
    List<WorkPlanRemindUserVO> getRemindWorkPlan();

    /**
     * 批量添加工作计划用户
     *
     * @param tbOaWorkPlanUserList
     */
    void insertBatch(List<TbOaWorkPlanUser> tbOaWorkPlanUserList);
}
