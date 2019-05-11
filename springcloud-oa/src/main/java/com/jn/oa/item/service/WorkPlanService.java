package com.jn.oa.item.service;

import com.jn.common.model.PaginationData;
import com.jn.oa.item.entity.TbOaItem;
import com.jn.oa.item.model.*;
import com.jn.oa.item.vo.WorkPlanVO;
import com.jn.system.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
     * @return
     */
    PaginationData<List<WorkPlanVO>> list(WorkPlanPage workPlanPage);

    /**
     * 添加工作计划
     *
     * @param workPlanAdd 工作计划添加实体
     * @param user        当前用户
     */
    void add(WorkPlanAdd workPlanAdd, User user);

    /**
     * 查询工作计划详情
     *
     * @param workPlanId 工作计划id
     */
    WorkPlanVO getWorkPlanById(String workPlanId);

    /**
     * 编辑工作计划
     *
     * @param workPlanEdit
     * @param user
     */
    void update(WorkPlanEdit workPlanEdit, User user);

    /**
     * 修改工作计划状态
     *
     * @param workPlanUpdateStatus 状态信息
     * @param user                 当前用户
     */
    void updateWorkPlanStatus(WorkPlanUpdateStatus workPlanUpdateStatus, User user);

    /**
     * 添加备注信息
     *
     * @param workPlanAddRemark
     * @param user
     */
    void addRemark(WorkPlanAddRemark workPlanAddRemark, User user);

    /**
     * (逻辑)删除工作计划
     *
     * @param workPlanId
     * @param user
     */
    void delete(String workPlanId, User user);

    /**
     * 添加工作计划历史记录
     *
     * @param user           当前用户
     * @param workPlanId     工作计划id
     * @param operate        操作类型
     * @param remark         备注信息
     * @param operateDetails 操作细节
     */
    void inserWorkPlanHistory(User user, String workPlanId, String operate, String remark, String operateDetails);

    /**
     * 工作计划提醒功能
     *
     * @return
     */
    Boolean workPlanRemindEveryDay();

    /**
     * 自动更新工作计划状态
     */
    void updateWorkPlanIsExpire();

    /**
     * 报表导入工作计划
     *
     * @param file 报表文件
     * @param user 当前用户
     */
    String importExcelWorkPlanInfo(MultipartFile file, User user);

    /**
     * 获取所有项目信息
     *
     * @return
     */
    List<TbOaItem> getItemAll();
}
