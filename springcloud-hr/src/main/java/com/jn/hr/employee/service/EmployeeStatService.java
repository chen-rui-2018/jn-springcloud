package com.jn.hr.employee.service;

import com.jn.hr.employee.model.KeyValue;

import java.util.List;

/**
 * @author dt
 * @create 2019-04-25 上午 10:20
 */
public interface EmployeeStatService {
    //在职员工类型分布
    public List<KeyValue> statByEmployeeType(String departmentId);
    //在职员工司龄分布
    public List<KeyValue> statByEmployeeCompanyDate(String departmentId);
    //在职员工职级分布
    public List<KeyValue> statByEmployeePostName(String departmentId);
    //在职员工性别分布
    public List<KeyValue> statByEmployeeSex(String departmentId);
    //在职员工学历分布
    public List<KeyValue> statByEmployeeAcademic(String departmentId);
    //在职员工年龄分布
    public List<KeyValue> statByEmployeeAge(String departmentId);
    //部门人数统计排名
    public List<KeyValue> statByEmployeeDepartment(String departmentId);
}
