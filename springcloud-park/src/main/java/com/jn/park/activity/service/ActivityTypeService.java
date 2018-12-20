package com.jn.park.activity.service;



import com.jn.common.model.PaginationData;
import com.jn.park.activity.model.ActivityType;
import com.jn.system.model.User;


/**
 * 活动类型服务类
 * @Author: chenr
 * @Date: 2018/12/05 9:39
 * @Version v1.0
 * @modified By:
 */
public interface ActivityTypeService {

    /**
     * 新增活动类型
     * @param typeName
     * @param state
     * @param templateList
     * @param user
     * @return
     */
    void  insertActivityType(String typeName, String state, String templateList, User user);

    /**
     * 查询活动类型列表
     * @param state
     * @param page
     * @param rows
     * @param isPage
     * @return
     */
    PaginationData findActivityTypeListByState(String state, Integer page,Integer rows ,boolean isPage);

    /**
     * 根据活动类型id(typeId) 获取当前活动类型内容
     * @param typeId
     * @return
     */
    ActivityType findActivityTypeById(String typeId);
    /**
     * 根据活动类型id(typeId) 获取当前活动类型内容
     * @param typeName
     * @param state
     * @param templateList
     * @param typeId
     * @param user
     * @return
     */
    void updateActivityType(String typeId,String typeName, String state, String templateList, User user);

    /**
     *根据类型Id删除活动类型
     * @param typeId
     */
    void deleteActivityTypeList(String typeId);


}