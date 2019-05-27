package com.jn.oa.overTime.service.impl;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.jn.common.model.Result;
import com.jn.hr.api.HrClient;
import com.jn.hr.model.VacationManagement;
import com.jn.oa.leave.dao.LeaveMapper;
import com.jn.oa.leave.service.LeaveService;
import com.jn.oa.model.Leave;
import com.jn.oa.overTime.service.OverTimeService;
import com.jn.oa.vo.LeaveApiVo;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 加班service
 *
 * @author： yuanyy
 * @date： Created on 2019/4/17 10:49
 * @version： v1.0
 * @modified By:
 */
@Service
public class OverTimeServiceImpl implements OverTimeService {

    private static Logger logger = LoggerFactory.getLogger(OverTimeServiceImpl.class);

    @Autowired
    private HrClient hrClient;


    /**
     * 加班结束，记录加班小时到人力资源子系统
     *
     * @param overTime
     * @return
     */
    @Override
    public Result insertOverTime(VacationManagement overTime) {
        logger.info("进入-加班结束，记录加班小时到人力资源子系统,参数：{}", JSONObject.toJSONString(overTime));
        Result result=hrClient.insertByOverTimeVacationmanage(overTime);
        logger.info("执行结束-加班结束，记录加班小时到人力资源子系统,返回参数：{}", JSONObject.toJSONString(result));
        return result;
    }
}
