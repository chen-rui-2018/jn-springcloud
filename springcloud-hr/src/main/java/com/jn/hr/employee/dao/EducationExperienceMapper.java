package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerEducationExperience;
import com.jn.hr.employee.model.EducationExperience;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dt
 * @create 2019-04-23 上午 9:12
 */
public interface EducationExperienceMapper {
    int insertBatch(List<TbManpowerEducationExperience> list);
    int deleteByJobNumber(@Param("jobNumber") String jobNumber);
    List<EducationExperience> selectByJobNumber(@Param("jobNumber") String jobNumber);
}
