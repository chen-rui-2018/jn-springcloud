package com.jn.hr.employee.service.impl;

import com.jn.hr.employee.dao.EmployeeBasicInfoMapper;
import com.jn.hr.employee.model.KeyValue;
import com.jn.hr.employee.service.EmployeeStatService;
import com.jn.system.log.annotation.ServiceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dt
 * @create 2019-04-25 上午 10:20
 */
@Service
public class EmployeeStatServiceImpl implements EmployeeStatService {
    @Autowired
    private EmployeeBasicInfoMapper employeeBasicInfoMapper;
    @Override
    @ServiceLog(doAction = "在职员工类型分布")
    public List<KeyValue> statByEmployeeType(String departmentId) {
        return employeeBasicInfoMapper.statByEmployeeType(departmentId);
    }

    @Override
    @ServiceLog(doAction = "在职员工司龄分布")
    public List<KeyValue> statByEmployeeCompanyDate(String departmentId) {
        return employeeBasicInfoMapper.statByEmployeeCompanyDate(departmentId);
    }

    @Override
    @ServiceLog(doAction = "在职员工职级分布")
    public List<KeyValue> statByEmployeePostName(String departmentId) {
        return employeeBasicInfoMapper.statByEmployeePostName(departmentId);
    }

    @Override
    @ServiceLog(doAction = "在职员工性别分布")
    public List<KeyValue> statByEmployeeSex(String departmentId) {
        return employeeBasicInfoMapper.statByEmployeeSex(departmentId);
    }

    @Override
    @ServiceLog(doAction = "在职员工学历分布")
    public List<KeyValue> statByEmployeeAcademic(String departmentId) {
        return employeeBasicInfoMapper.statByEmployeeAcademic(departmentId);
    }

    @Override
    @ServiceLog(doAction = "在职员工年龄分布")
    public List<KeyValue> statByEmployeeAge(String departmentId) {
        return employeeBasicInfoMapper.statByEmployeeAge(departmentId);
    }

    @Override
    @ServiceLog(doAction = "部门人数统计排名")
    public List<KeyValue> statByEmployeeDepartment(String departmentId) {
        return employeeBasicInfoMapper.statByEmployeeDepartment(departmentId);
    }
}
