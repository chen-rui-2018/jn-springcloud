package com.jn.oa.item.dao;

import com.jn.oa.item.entity.TbOaWorkPlan;
import com.jn.oa.item.model.WorkPlanPage;
import com.jn.oa.item.vo.WorkPlanVO;
import org.apache.ibatis.annotations.Param;

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
     *
     * @param workPlanPage
     * @return
     */
    List<WorkPlanVO> list(WorkPlanPage workPlanPage);


    /***
     * 根据项工作id获取工作计划详细信息及历史记录集合
     * @param workPlanid
     */
    WorkPlanVO getResponsibleAndHistoryById(String workPlanid);

    /**
     * 获取工作计划负责人账号
     *
     * @param workPlanId
     * @return
     */
    List<String> getResponsibleById(String workPlanId);

    /**
     * @param workPlanId
     * @return
     */
    String getResponsibleName(String workPlanId);

    /**
     * 更新工作计划延期状态
     *
     * @param tbOaWorkPlans
     */
    void updateWorkPlanIsExpire(List<TbOaWorkPlan> tbOaWorkPlans);

    /**
     * 获取用户账号
     *
     * @param userName 用户名称
     * @param email    用户邮箱
     * @return
     */
    List<String> getUser(@Param("userName") String userName, @Param("email") String email);

    /**
     * 批量导入工作计划
     *
     * @param tbOaWorkPlanList
     */
    void insertBatch(List<TbOaWorkPlan> tbOaWorkPlanList);
}
