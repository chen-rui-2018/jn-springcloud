package com.jn.park.activity.dao;


import com.jn.park.activity.model.Activity;

import java.util.List;

/**
 * @Author: jiangyl
 * @Date: 2018/12/5 21:09
 * @Version v1.0
 * @modified By:
 */
public interface ActivityMapper {

    public List<Activity> selectActivityList(Activity activity);

}
