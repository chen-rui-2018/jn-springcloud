package com.jn.hr.employee.dao;

import com.jn.hr.archives.entity.TbManpowerEmployeeFile;
import com.jn.hr.archives.model.EmployeeFile;
import com.jn.hr.archives.model.EmployeeFilePage;

import java.util.List;

/**
 * @author dt
 * @create 2019-04-16 下午 7:09
 */
public interface EmployeeFileMapper {
    List<EmployeeFile> list(EmployeeFilePage employeeFilePage);
    int insertBatch(List<TbManpowerEmployeeFile> list);
}
