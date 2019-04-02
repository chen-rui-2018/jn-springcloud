package com.jn.park.activity.service;



import com.jn.common.model.PaginationData;
import com.jn.park.model.ActivityType;
import com.jn.park.model.ActivityTypeAdd;
import com.jn.park.model.ActivityTypeParam;
import com.jn.park.model.ActivityTypeUpdate;
import com.jn.system.model.User;

import java.util.List;


/**
 * 活动类型服务类
 * @Author: chenr
 * @Date: 2018/12/05 9:39
 * @Version v1.0
 * @modified By:
 */
public interface ActivityTypeService {

    /**
     *  新增活动类型
     * @param activityTypeAdd
     * @param user
     * @return
     */
    String  insertActivityType(ActivityTypeAdd activityTypeAdd, User user);

    /**
     *  查询活动类型列表
     * @param activityTypeParam
     * @param isPage
     * @return
     */
    PaginationData<List<ActivityType>> findActivityTypeListByState(ActivityTypeParam activityTypeParam, boolean isPage);

    /**
     * 根据活动类型id(typeId) 获取当前活动类型内容
     * @param typeId
     * @return
     */
    ActivityType findActivityTypeById(String typeId);

    /**
     * 根据活动类型id(typeId) 获取当前活动类型内容
     * @param activityTypeUpdate
     * @param user
     */
    void updateActivityType(ActivityTypeUpdate activityTypeUpdate, User user);

    /**
     *根据类型Id删除活动类型
     * @param typeId
     */
    void deleteActivityTypeList(String[] typeId);


}