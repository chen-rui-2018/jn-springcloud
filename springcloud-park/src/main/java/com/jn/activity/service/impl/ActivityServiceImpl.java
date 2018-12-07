package com.jn.activity.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.activity.dao.ActivityMapper;
import com.jn.activity.model.Activity;
import com.jn.activity.service.ActivityService;
import com.jn.common.model.PaginationData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: jiangyl
 * @Date: 2018/12/5 17:00
 * @Version v1.0
 * @modified By:
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityServiceDao;
    /**
     * 日志组件
     */
    private static Logger logger= LoggerFactory.getLogger(ActivityServiceImpl.class);

    @Override
    public PaginationData selectActivityList(Activity activity){
        Page<Object> objects = PageHelper.startPage(activity.getPage(), activity.getRows());
        List<Activity> activities = activityServiceDao.selectActivityList(activity);
        PaginationData data = new PaginationData(activities, objects.getTotal());
        return data;
    }
}
