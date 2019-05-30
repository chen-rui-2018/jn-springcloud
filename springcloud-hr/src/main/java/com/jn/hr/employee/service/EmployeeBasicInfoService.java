package com.jn.hr.employee.service;

import com.jn.common.model.PaginationData;
import com.jn.hr.archives.model.TreeModel;
import com.jn.hr.employee.model.EmployeeBasicInfo;
import com.jn.hr.employee.model.EmployeeBasicInfoAdd;
import com.jn.hr.employee.model.EmployeeBasicInfoPage;
import com.jn.system.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author dt
 * @create 2019-04-19 上午 9:24
 */
public interface EmployeeBasicInfoService {
    //新增员工花名册
    public void addEmployeeBasicInfo(EmployeeBasicInfoAdd employeeBasicInfoAdd, User user);

    //修改员工花名册
    public void updateEmployeeBasicInfo(EmployeeBasicInfoAdd employeeBasicInfoAdd, User user);
    //删除员工花名册
    public void delete(String id, User user);

    //查询员工花名册详情
    public EmployeeBasicInfo getEmployeeBasicInfoById(String id);
    //分页查询
    public PaginationData<List<EmployeeBasicInfo>> list(EmployeeBasicInfoPage employeeBasicInfoPage,boolean calcHoliday);

    //导入excel
    public String importEmployeeBasicInfo(MultipartFile file, User user);
    //导入直属领导
    public String importDirectlyLeader(MultipartFile file, User user);

    //导入教育经历
    public String importEducationExperience(MultipartFile file, User user);
    //导入工作经历
    public String importWorkExperience(MultipartFile file, User user);

    //导入社保福利
    public String importSocialSecurity(MultipartFile file, User user);
    void updateEmployStatus(String id, String employStatus, User user);
    //查询部门员工树
    public List<TreeModel> selectDepartEmployee();

    public boolean checkPhoneExist(String phone,String id);
    public boolean checkMailboxExist(String mailBox,String id);
    public boolean checkCertificateNumberExist(String certificateNumber,String id);





}
