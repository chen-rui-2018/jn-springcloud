package com.jn.enterprise.joinpark.company.dao;

import com.jn.enterprise.joinpark.company.entity.TbServiceCompanyStaff;
import com.jn.enterprise.joinpark.company.entity.TbServiceCompanyStaffCriteria;
import java.util.List;

import com.jn.enterprise.joinpark.usermanage.model.StaffCheckCallBackParam;
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

    int updateByPrimaryKeySelective(StaffCheckCallBackParam record);

    int updateByPrimaryKey(TbServiceCompanyStaff record);
}