package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerWorkExperience;
import com.jn.hr.employee.entity.TbManpowerWorkExperienceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerWorkExperienceMapper {
    long countByExample(TbManpowerWorkExperienceCriteria example);

    int deleteByExample(TbManpowerWorkExperienceCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerWorkExperience record);

    int insertSelective(TbManpowerWorkExperience record);

    List<TbManpowerWorkExperience> selectByExample(TbManpowerWorkExperienceCriteria example);

    TbManpowerWorkExperience selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerWorkExperience record, @Param("example") TbManpowerWorkExperienceCriteria example);

    int updateByExample(@Param("record") TbManpowerWorkExperience record, @Param("example") TbManpowerWorkExperienceCriteria example);

    int updateByPrimaryKeySelective(TbManpowerWorkExperience record);

    int updateByPrimaryKey(TbManpowerWorkExperience record);
}