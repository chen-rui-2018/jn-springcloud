package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerMobilizationManagement;
import com.jn.hr.employee.entity.TbManpowerMobilizationManagementCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerMobilizationManagementMapper {
    long countByExample(TbManpowerMobilizationManagementCriteria example);

    int deleteByExample(TbManpowerMobilizationManagementCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerMobilizationManagement record);

    int insertSelective(TbManpowerMobilizationManagement record);

    List<TbManpowerMobilizationManagement> selectByExample(TbManpowerMobilizationManagementCriteria example);

    TbManpowerMobilizationManagement selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerMobilizationManagement record, @Param("example") TbManpowerMobilizationManagementCriteria example);

    int updateByExample(@Param("record") TbManpowerMobilizationManagement record, @Param("example") TbManpowerMobilizationManagementCriteria example);

    int updateByPrimaryKeySelective(TbManpowerMobilizationManagement record);

    int updateByPrimaryKey(TbManpowerMobilizationManagement record);
}