package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerEmployeeBasicInfo;
import com.jn.hr.employee.entity.TbManpowerEmployeeBasicInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerEmployeeBasicInfoMapper {
    long countByExample(TbManpowerEmployeeBasicInfoCriteria example);

    int deleteByExample(TbManpowerEmployeeBasicInfoCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerEmployeeBasicInfo record);

    int insertSelective(TbManpowerEmployeeBasicInfo record);

    List<TbManpowerEmployeeBasicInfo> selectByExample(TbManpowerEmployeeBasicInfoCriteria example);

    TbManpowerEmployeeBasicInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerEmployeeBasicInfo record, @Param("example") TbManpowerEmployeeBasicInfoCriteria example);

    int updateByExample(@Param("record") TbManpowerEmployeeBasicInfo record, @Param("example") TbManpowerEmployeeBasicInfoCriteria example);

    int updateByPrimaryKeySelective(TbManpowerEmployeeBasicInfo record);

    int updateByPrimaryKey(TbManpowerEmployeeBasicInfo record);
}