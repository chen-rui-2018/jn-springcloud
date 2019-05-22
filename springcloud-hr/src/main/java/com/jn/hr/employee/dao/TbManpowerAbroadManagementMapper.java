package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerAbroadManagement;
import com.jn.hr.employee.entity.TbManpowerAbroadManagementCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerAbroadManagementMapper {
    long countByExample(TbManpowerAbroadManagementCriteria example);

    int deleteByExample(TbManpowerAbroadManagementCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerAbroadManagement record);

    int insertSelective(TbManpowerAbroadManagement record);

    List<TbManpowerAbroadManagement> selectByExample(TbManpowerAbroadManagementCriteria example);

    TbManpowerAbroadManagement selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerAbroadManagement record, @Param("example") TbManpowerAbroadManagementCriteria example);

    int updateByExample(@Param("record") TbManpowerAbroadManagement record, @Param("example") TbManpowerAbroadManagementCriteria example);

    int updateByPrimaryKeySelective(TbManpowerAbroadManagement record);

    int updateByPrimaryKey(TbManpowerAbroadManagement record);
}