package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerResumeDatabase;
import com.jn.hr.employee.entity.TbManpowerResumeDatabaseCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerResumeDatabaseMapper {
    long countByExample(TbManpowerResumeDatabaseCriteria example);

    int deleteByExample(TbManpowerResumeDatabaseCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerResumeDatabase record);

    int insertSelective(TbManpowerResumeDatabase record);

    List<TbManpowerResumeDatabase> selectByExample(TbManpowerResumeDatabaseCriteria example);

    TbManpowerResumeDatabase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerResumeDatabase record, @Param("example") TbManpowerResumeDatabaseCriteria example);

    int updateByExample(@Param("record") TbManpowerResumeDatabase record, @Param("example") TbManpowerResumeDatabaseCriteria example);

    int updateByPrimaryKeySelective(TbManpowerResumeDatabase record);

    int updateByPrimaryKey(TbManpowerResumeDatabase record);
}