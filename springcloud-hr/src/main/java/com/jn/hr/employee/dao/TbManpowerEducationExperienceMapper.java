package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerEducationExperience;
import com.jn.hr.employee.entity.TbManpowerEducationExperienceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerEducationExperienceMapper {
    long countByExample(TbManpowerEducationExperienceCriteria example);

    int deleteByExample(TbManpowerEducationExperienceCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerEducationExperience record);

    int insertSelective(TbManpowerEducationExperience record);

    List<TbManpowerEducationExperience> selectByExample(TbManpowerEducationExperienceCriteria example);

    TbManpowerEducationExperience selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerEducationExperience record, @Param("example") TbManpowerEducationExperienceCriteria example);

    int updateByExample(@Param("record") TbManpowerEducationExperience record, @Param("example") TbManpowerEducationExperienceCriteria example);

    int updateByPrimaryKeySelective(TbManpowerEducationExperience record);

    int updateByPrimaryKey(TbManpowerEducationExperience record);
}