package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerEntryManagement;
import com.jn.hr.employee.entity.TbManpowerEntryManagementCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerEntryManagementMapper {
    long countByExample(TbManpowerEntryManagementCriteria example);

    int deleteByExample(TbManpowerEntryManagementCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerEntryManagement record);

    int insertSelective(TbManpowerEntryManagement record);

    List<TbManpowerEntryManagement> selectByExample(TbManpowerEntryManagementCriteria example);

    TbManpowerEntryManagement selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerEntryManagement record, @Param("example") TbManpowerEntryManagementCriteria example);

    int updateByExample(@Param("record") TbManpowerEntryManagement record, @Param("example") TbManpowerEntryManagementCriteria example);

    int updateByPrimaryKeySelective(TbManpowerEntryManagement record);

    int updateByPrimaryKey(TbManpowerEntryManagement record);
}