package com.jn.hr.archives.dao;

import com.jn.hr.archives.entity.TbManpowerEmployeeFileClass;
import com.jn.hr.archives.entity.TbManpowerEmployeeFileClassCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerEmployeeFileClassMapper {
    long countByExample(TbManpowerEmployeeFileClassCriteria example);

    int deleteByExample(TbManpowerEmployeeFileClassCriteria example);

    int deleteByPrimaryKey(String classId);

    int insert(TbManpowerEmployeeFileClass record);

    int insertSelective(TbManpowerEmployeeFileClass record);

    List<TbManpowerEmployeeFileClass> selectByExample(TbManpowerEmployeeFileClassCriteria example);

    TbManpowerEmployeeFileClass selectByPrimaryKey(String classId);

    int updateByExampleSelective(@Param("record") TbManpowerEmployeeFileClass record, @Param("example") TbManpowerEmployeeFileClassCriteria example);

    int updateByExample(@Param("record") TbManpowerEmployeeFileClass record, @Param("example") TbManpowerEmployeeFileClassCriteria example);

    int updateByPrimaryKeySelective(TbManpowerEmployeeFileClass record);

    int updateByPrimaryKey(TbManpowerEmployeeFileClass record);
}