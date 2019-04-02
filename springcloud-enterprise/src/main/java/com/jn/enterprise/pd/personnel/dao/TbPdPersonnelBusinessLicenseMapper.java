package com.jn.enterprise.pd.personnel.dao;

import com.jn.enterprise.pd.personnel.entity.TbPdPersonnelBusinessLicense;
import com.jn.enterprise.pd.personnel.entity.TbPdPersonnelBusinessLicenseCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdPersonnelBusinessLicenseMapper {
    long countByExample(TbPdPersonnelBusinessLicenseCriteria example);

    int deleteByExample(TbPdPersonnelBusinessLicenseCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPdPersonnelBusinessLicense record);

    int insertSelective(TbPdPersonnelBusinessLicense record);

    List<TbPdPersonnelBusinessLicense> selectByExample(TbPdPersonnelBusinessLicenseCriteria example);

    TbPdPersonnelBusinessLicense selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPdPersonnelBusinessLicense record, @Param("example") TbPdPersonnelBusinessLicenseCriteria example);

    int updateByExample(@Param("record") TbPdPersonnelBusinessLicense record, @Param("example") TbPdPersonnelBusinessLicenseCriteria example);

    int updateByPrimaryKeySelective(TbPdPersonnelBusinessLicense record);

    int updateByPrimaryKey(TbPdPersonnelBusinessLicense record);
}