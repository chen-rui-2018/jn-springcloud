package com.jn.hr.increase.dao;

import com.jn.hr.increase.entity.TbManpowerSalaryInfo;
import com.jn.hr.increase.entity.TbManpowerSalaryInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerSalaryInfoMapper {
    long countByExample(TbManpowerSalaryInfoCriteria example);

    int deleteByExample(TbManpowerSalaryInfoCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerSalaryInfo record);

    int insertSelective(TbManpowerSalaryInfo record);

    List<TbManpowerSalaryInfo> selectByExample(TbManpowerSalaryInfoCriteria example);

    TbManpowerSalaryInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerSalaryInfo record, @Param("example") TbManpowerSalaryInfoCriteria example);

    int updateByExample(@Param("record") TbManpowerSalaryInfo record, @Param("example") TbManpowerSalaryInfoCriteria example);

    int updateByPrimaryKeySelective(TbManpowerSalaryInfo record);

    int updateByPrimaryKey(TbManpowerSalaryInfo record);
}