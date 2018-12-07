package com.jn.activity.service;


import com.github.pagehelper.PageInfo;
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
     * 新增活动类型
     * @param typeName
     * @param state
     * @param templateList
     * @param user
     * @return
     */
    void  insertActivityType(String typeName, String state, List<String> templateList, User user);

    /**
     * 查询活动类型列表
     * @param state
     * @param page
     * @param rows
     * @return
     */
    PageInfo findActivityTypeListByState(String state, String page, String rows);

}
