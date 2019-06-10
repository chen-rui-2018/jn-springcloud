package com.jn.hr.employee.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.hr.common.enums.HrExceptionEnums;
import com.jn.hr.employee.dao.EmployeeBasicInfoMapper;
import com.jn.hr.employee.model.KeyValue;
import com.jn.hr.employee.service.EmployeeStatService;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author dt
 * @create 2019-04-25 上午 10:20
 */
@Service
public class EmployeeStatServiceImpl implements EmployeeStatService {
    @Autowired
    private EmployeeBasicInfoMapper employeeBasicInfoMapper;
    @Autowired
    private SystemClient systemClient;
    @Override
    @ServiceLog(doAction = "在职员工类型分布")
    public List<KeyValue> statByEmployeeType(String departmentId) {
        List<String> departs=getChildDeparts(departmentId);
        return employeeBasicInfoMapper.statByEmployeeType(departs);
    }

    @Override
    @ServiceLog(doAction = "在职员工司龄分布")
    public List<KeyValue> statByEmployeeCompanyDate(String departmentId) {
        List<String> departs=getChildDeparts(departmentId);
        return employeeBasicInfoMapper.statByEmployeeCompanyDate(departs);
    }

    @Override
    @ServiceLog(doAction = "在职员工职级分布")
    public List<KeyValue> statByEmployeePostName(String departmentId) {
        List<String> departs=getChildDeparts(departmentId);
        return employeeBasicInfoMapper.statByEmployeePostName(departs);
    }

    @Override
    @ServiceLog(doAction = "在职员工性别分布")
    public List<KeyValue> statByEmployeeSex(String departmentId) {
        List<String> departs=getChildDeparts(departmentId);
        return employeeBasicInfoMapper.statByEmployeeSex(departs);
    }

    @Override
    @ServiceLog(doAction = "在职员工学历分布")
    public List<KeyValue> statByEmployeeAcademic(String departmentId) {
        List<String> departs=getChildDeparts(departmentId);
        return employeeBasicInfoMapper.statByEmployeeAcademic(departs);
    }

    @Override
    @ServiceLog(doAction = "在职员工年龄分布")
    public List<KeyValue> statByEmployeeAge(String departmentId) {
        List<String> departs=getChildDeparts(departmentId);
        return employeeBasicInfoMapper.statByEmployeeAge(departs);
    }

    @Override
    @ServiceLog(doAction = "部门人数统计排名")
    public List<KeyValue> statByEmployeeDepartment(String departmentId) {
        List<String> departs=getChildDeparts(departmentId);
        return employeeBasicInfoMapper.statByEmployeeDepartment(departs);
    }
    private List<String> getChildDeparts(String departmentId){
        List<String> rootList=new ArrayList<String>();
        if(StringUtils.isEmpty(departmentId)){
            return rootList;
        }
        Result result = systemClient.selectDeptByParentId(departmentId, true);
        if (result == null || !"0000".equals(result.getCode()) || result.getData() == null) {
            throw new JnSpringCloudException(HrExceptionEnums.DEPARTMENT_QUERY_ERRPR);
        }
        HashMap<String, Object> childMap = (HashMap<String, Object>) result.getData();
        rootList.add((String) childMap.get("id"));
        if (childMap.get("children") != null) {
            List<HashMap<String, Object>> childrenSub = (List<HashMap<String, Object>>) childMap.get("children");
            getChildrenDepartment(rootList, childrenSub);
        }

        return rootList;
    }
    private void getChildrenDepartment(List<String> rootList, List<HashMap<String, Object>> children) {
        for (HashMap<String, Object> childMap : children) {
            rootList.add((String) childMap.get("id"));
            if (childMap.get("children") != null) {
                List<HashMap<String, Object>> childrenSub = (List<HashMap<String, Object>>) childMap.get("children");
                getChildrenDepartment(rootList, childrenSub);
            }
        }
    }
}
