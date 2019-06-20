package com.jn.enterprise.company.dao;

import com.jn.enterprise.company.entity.TbServiceCompanyStaff;
import com.jn.enterprise.company.entity.TbServiceCompanyStaffCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceCompanyStaffMapper {
    long countByExample(TbServiceCompanyStaffCriteria example);

    int deleteByExample(TbServiceCompanyStaffCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceCompanyStaff record);

    int insertSelective(TbServiceCompanyStaff record);

    List<TbServiceCompanyStaff> selectByExample(TbServiceCompanyStaffCriteria example);

    TbServiceCompanyStaff selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceCompanyStaff record, @Param("example") TbServiceCompanyStaffCriteria example);

    int updateByExample(@Param("record") TbServiceCompanyStaff record, @Param("example") TbServiceCompanyStaffCriteria example);

    int updateByPrimaryKeySelective(TbServiceCompanyStaff record);

    int updateByPrimaryKey(TbServiceCompanyStaff record);
}