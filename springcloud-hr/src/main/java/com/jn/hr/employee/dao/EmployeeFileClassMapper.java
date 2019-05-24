package com.jn.hr.employee.dao;

import com.jn.hr.archives.model.EmployeeFileClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dt
 * @create 2019-04-18 上午 10:07
 */
public interface EmployeeFileClassMapper {
    public List<EmployeeFileClass> selectByNodeName(@Param("nodeName") String nodeName);
}
