package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerEntryRegistra;
import com.jn.hr.employee.entity.TbManpowerEntryRegistraCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerEntryRegistraMapper {
    long countByExample(TbManpowerEntryRegistraCriteria example);

    int deleteByExample(TbManpowerEntryRegistraCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerEntryRegistra record);

    int insertSelective(TbManpowerEntryRegistra record);

    List<TbManpowerEntryRegistra> selectByExample(TbManpowerEntryRegistraCriteria example);

    TbManpowerEntryRegistra selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerEntryRegistra record, @Param("example") TbManpowerEntryRegistraCriteria example);

    int updateByExample(@Param("record") TbManpowerEntryRegistra record, @Param("example") TbManpowerEntryRegistraCriteria example);

    int updateByPrimaryKeySelective(TbManpowerEntryRegistra record);

    int updateByPrimaryKey(TbManpowerEntryRegistra record);
}