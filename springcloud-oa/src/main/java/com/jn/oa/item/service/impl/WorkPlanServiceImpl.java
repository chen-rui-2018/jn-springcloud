package com.jn.oa.item.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.util.LoadBalancerUtil;
import com.jn.oa.item.dao.TbOaWorkPlanMapper;
import com.jn.oa.item.dao.WorkPlanMapper;
import com.jn.oa.item.entity.TbOaWorkPlan;
import com.jn.oa.item.model.WorkPlanPage;
import com.jn.oa.item.service.WorkPlanService;
import com.jn.oa.item.vo.WorkPlanVO;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 工作计划服务层
 *
 * @author： shaobao
 * @date： Created on 2019/2/20 oa:44
 * @version： v1.0
 * @modified By:
 **/
@Service
public class WorkPlanServiceImpl implements WorkPlanService {
    /**
     * 日志组件
     */
    private static final Logger logger = LoggerFactory.getLogger(WorkPlanServiceImpl.class);

    @Autowired
    private LoadBalancerUtil loadBalancerUtils;

    @Autowired
    private TbOaWorkPlanMapper tbOaWorkPlanMapper;
    @Autowired
    private WorkPlanMapper workPlanMapper;

    /**
     * 工作计划列表
     *
     * @param workPlanPage 分页查询条件
     * @param user         当前登录用户信息
     * @return
     */
    @Override
    @ServiceLog(doAction = "工作计划列表")
    public PaginationData list(WorkPlanPage workPlanPage, User user) {
        Page<Object> objects = PageHelper.startPage(workPlanPage.getPage(), workPlanPage.getRows());
        List<WorkPlanVO> workPlanVOList = workPlanMapper.list(workPlanPage);
        return new PaginationData(workPlanVOList, objects.getTotal());
    }

}
