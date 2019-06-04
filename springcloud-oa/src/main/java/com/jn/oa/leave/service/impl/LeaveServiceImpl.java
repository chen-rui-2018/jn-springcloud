package com.jn.oa.leave.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jn.common.model.Result;
import com.jn.hr.api.HrClient;
import com.jn.hr.model.VacationManagement;
import com.jn.oa.leave.dao.LeaveMapper;
import com.jn.oa.model.Leave ;
import com.jn.oa.leave.service.LeaveService;
import com.jn.oa.vo.LeaveApiVo ;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 请假service
 *
 * @author： yuanyy
 * @date： Created on 2019/4/17 10:49
 * @version： v1.0
 * @modified By:
 */
@Service
public class LeaveServiceImpl implements LeaveService {

    private static Logger logger = LoggerFactory.getLogger(LeaveServiceImpl.class);

    @Autowired
    private LeaveMapper leaveMapper;

    @Autowired
    private HrClient hrClient;

    /**
     * 根据条件查询请假列表
     *
     * @param leave
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据条件查询请假列表")
    public List<LeaveApiVo> searchLeaveListByCondition(Leave leave) {
        logger.info("[请假管理] 条件查询请假列表，,userId：{},departmentId：{},startTime：{},endTime：{}", leave.getUserId(),leave.getDepartmentId(),leave.getStartTime(),leave.getEndTime());
        return leaveMapper.selectLeaveByCondition(leave);
    }

    /**
     * 请假结束，记录请假小时到人力资源子系统
     *
     * @param leave
     * @return
     */
    @Override
    public Result insertByLeave(VacationManagement leave) {
        logger.info("进入-请假结束，记录请假小时到人力资源子系统,参数：{}", JSONObject.toJSONString(leave));
        Result result=hrClient.insertByLeaveVacationmanage(leave);
        logger.info("执行结束-请假结束，记录请假小时到人力资源子系统,返回参数：{}", JSONObject.toJSONString(result));
        return  result;
    }
}
