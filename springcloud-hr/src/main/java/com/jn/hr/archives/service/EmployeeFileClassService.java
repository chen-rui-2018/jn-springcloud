package com.jn.hr.archives.service;

import com.jn.hr.archives.model.EmployeeFileClass;
import com.jn.hr.archives.model.EmployeeFileClassAdd;
import com.jn.hr.archives.model.TreeModel;
import com.jn.system.model.User;

import java.util.List;

/**
 * @author dt
 * @create 2019-04-17 上午 10:03
 */
public interface EmployeeFileClassService {
    //新增员工档案分类
    public EmployeeFileClass addEmployeeFileClass(EmployeeFileClassAdd employeeFileClassAdd, User user);

    //修改员工档案分类
    public void updateEmployeeFileClass(EmployeeFileClassAdd employeeFileClassAdd, User user);
    //删除员工档案分类
    public void delete(String id, User user);

    //根据parentId查询员工档案分类
    public List<TreeModel> getEmployeeFileClassByParentId(String parentId);
    public List<TreeModel> getAllEmployeeFileClass();
}
