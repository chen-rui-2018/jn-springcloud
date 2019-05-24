package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerSocialSecurity;
import com.jn.hr.employee.entity.TbManpowerSocialSecurityCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerSocialSecurityMapper {
    long countByExample(TbManpowerSocialSecurityCriteria example);

    int deleteByExample(TbManpowerSocialSecurityCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerSocialSecurity record);

    int insertSelective(TbManpowerSocialSecurity record);

    List<TbManpowerSocialSecurity> selectByExample(TbManpowerSocialSecurityCriteria example);

    TbManpowerSocialSecurity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerSocialSecurity record, @Param("example") TbManpowerSocialSecurityCriteria example);

    int updateByExample(@Param("record") TbManpowerSocialSecurity record, @Param("example") TbManpowerSocialSecurityCriteria example);

    int updateByPrimaryKeySelective(TbManpowerSocialSecurity record);

    int updateByPrimaryKey(TbManpowerSocialSecurity record);
}