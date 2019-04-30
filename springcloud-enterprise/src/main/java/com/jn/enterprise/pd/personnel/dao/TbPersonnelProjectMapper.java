package com.jn.enterprise.pd.personnel.dao;

import com.jn.enterprise.pd.personnel.entity.TbPersonnelProject;
import com.jn.enterprise.pd.personnel.entity.TbPersonnelProjectCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPersonnelProjectMapper {
    long countByExample(TbPersonnelProjectCriteria example);

    int deleteByExample(TbPersonnelProjectCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPersonnelProject record);

    int insertSelective(TbPersonnelProject record);

    List<TbPersonnelProject> selectByExample(TbPersonnelProjectCriteria example);

    TbPersonnelProject selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPersonnelProject record, @Param("example") TbPersonnelProjectCriteria example);

    int updateByExample(@Param("record") TbPersonnelProject record, @Param("example") TbPersonnelProjectCriteria example);

    int updateByPrimaryKeySelective(TbPersonnelProject record);

    int updateByPrimaryKey(TbPersonnelProject record);
}