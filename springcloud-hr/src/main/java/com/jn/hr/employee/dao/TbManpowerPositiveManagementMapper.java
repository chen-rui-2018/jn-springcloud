package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerPositiveManagement;
import com.jn.hr.employee.entity.TbManpowerPositiveManagementCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerPositiveManagementMapper {
    long countByExample(TbManpowerPositiveManagementCriteria example);

    int deleteByExample(TbManpowerPositiveManagementCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerPositiveManagement record);

    int insertSelective(TbManpowerPositiveManagement record);

    List<TbManpowerPositiveManagement> selectByExample(TbManpowerPositiveManagementCriteria example);

    TbManpowerPositiveManagement selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerPositiveManagement record, @Param("example") TbManpowerPositiveManagementCriteria example);

    int updateByExample(@Param("record") TbManpowerPositiveManagement record, @Param("example") TbManpowerPositiveManagementCriteria example);

    int updateByPrimaryKeySelective(TbManpowerPositiveManagement record);

    int updateByPrimaryKey(TbManpowerPositiveManagement record);
}