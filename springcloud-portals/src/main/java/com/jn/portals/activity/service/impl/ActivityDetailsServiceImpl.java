package com.jn.portals.activity.service.impl;

import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.portals.activity.dao.ActivityDetailsMapper;
import com.jn.portals.activity.enums.ActivityExceptionEnum;
import com.jn.portals.activity.service.ActivityDetailsService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 活动详情
 * @Author: yangph
 * @Date: 2018/12/5 15:16
 * @Version v1.0
 * @modified By:
 */
@Service
public class ActivityDetailsServiceImpl implements ActivityDetailsService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityDetailsServiceImpl.class);

    @Autowired
    private ActivityDetailsMapper activityDetailsMapper;

    /**
     * 获取活动详情
     * @param id 活动id
     * @return
     */
    @ServiceLog(doAction = "获取活动详情")
    @Override
    public Result getActivityDetails(String id) {
        Result result=new Result();
        if(StringUtils.isBlank(id)){
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
            return result;
        }
        return null;
    }
}
