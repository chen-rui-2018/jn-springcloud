package com.jn.hr.employee.service;

import com.jn.hr.employee.model.EmployeeDepartment;
import com.jn.hr.employee.model.EmployeeDepartmentAdd;
import com.jn.system.model.User;

import java.util.List;

/**
 * @author dt
 * @create 2019-04-18 下午 5:35
 */
public interface EmployeeDepartmentService {
    //新增组织架构分类
    public EmployeeDepartment addEmployeeDepartment(EmployeeDepartmentAdd EmployeeDepartmentAdd, User user);

    //修改组织架构分类
    public void updateEmployeeDepartment(EmployeeDepartmentAdd EmployeeDepartmentAdd, User user);
    //删除组织架构分类
    public void delete(String id, User user);

    //根据parentId查询组织架构分类
    public List<EmployeeDepartment> getEmployeeDepartments();
}
