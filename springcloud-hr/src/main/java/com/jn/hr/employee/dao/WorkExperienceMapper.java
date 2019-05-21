package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerWorkExperience;
import com.jn.hr.employee.model.WorkExperience;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dt
 * @create 2019-04-23 上午 9:11
 */
public interface WorkExperienceMapper {
    int insertBatch(List<TbManpowerWorkExperience> list);
    int deleteByJobNumber(@Param("jobNumber") String jobNumber);
    List<WorkExperience> selectByJobNumber(@Param("jobNumber") String jobNumber);
}
