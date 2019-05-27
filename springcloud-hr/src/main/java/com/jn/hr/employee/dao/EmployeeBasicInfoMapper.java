package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerEmployeeBasicInfo;
import com.jn.hr.employee.model.EmployeeBasicInfo;
import com.jn.hr.employee.model.EmployeeBasicInfoPage;
import com.jn.hr.employee.model.KeyValue;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author dt
 * @create 2019-04-19 上午 9:31
 */
public interface EmployeeBasicInfoMapper {
    List<EmployeeBasicInfo> list(EmployeeBasicInfoPage employeeBasicInfoPage);
    int insertBatch(List<TbManpowerEmployeeBasicInfo> list);
    //在职员工类型分布
    public List<KeyValue> statByEmployeeType(@Param("departmentId") String departmentId);
    //在职员工司龄分布
    public List<KeyValue> statByEmployeeCompanyDate(@Param("departmentId")String departmentId);
    //在职员工职级分布
    public List<KeyValue> statByEmployeePostName(@Param("departmentId")String departmentId);
    //在职员工性别分布
    public List<KeyValue> statByEmployeeSex(@Param("departmentId")String departmentId);
    //在职员工学历分布
    public List<KeyValue> statByEmployeeAcademic(@Param("departmentId")String departmentId);
    //在职员工年龄分布
    public List<KeyValue> statByEmployeeAge(@Param("departmentId")String departmentId);
    //部门人数统计排名
    public List<KeyValue> statByEmployeeDepartment(@Param("departmentId")String departmentId);
    
    List<TbManpowerEmployeeBasicInfo> getList(TbManpowerEmployeeBasicInfo tbManpowerEmployeeBasicInfo);
    
    TbManpowerEmployeeBasicInfo selectByJobNumber(@Param("jobNumber")String jobNumber);
    
    List<TbManpowerEmployeeBasicInfo> selectByDepartment(@Param("departmentId")String departmentId);

    @MapKey("jobNumber")
    Map<String,TbManpowerEmployeeBasicInfo> map(TbManpowerEmployeeBasicInfo tbManpowerEmployeeBasicInfo);

    List<EmployeeBasicInfo> selectByEntryDate(@Param("entryDate") String entryDate);
    
    TbManpowerEmployeeBasicInfo selectByUserId(@Param("userId")String userId);

}
