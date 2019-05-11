package com.jn.oa.multiDeptOffice.service;

import com.jn.system.model.User;

import java.util.List;

/**
 * 多部门协同service层
 *
 * @author： shaobao
 * @date： Created on 2019/4/13 22:52
 * @version： v1.0
 * @modified By:
 **/
public interface MultiDeptOfficeService {

    /**
     * 更新多部门协同状态信息
     */
    void updateMultiDeptOfficeStatus();

    /**
     * 定时提醒用户功能
     */
    void remind();
}
