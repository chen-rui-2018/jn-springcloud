package com.jn.enterprise.pd.personnel.dao;

import com.jn.enterprise.pd.personnel.entity.TbPdPersonnelProjectBank;
import com.jn.enterprise.pd.personnel.entity.TbPdPersonnelProjectBankCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdPersonnelProjectBankMapper {
    long countByExample(TbPdPersonnelProjectBankCriteria example);

    int deleteByExample(TbPdPersonnelProjectBankCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPdPersonnelProjectBank record);

    int insertSelective(TbPdPersonnelProjectBank record);

    List<TbPdPersonnelProjectBank> selectByExample(TbPdPersonnelProjectBankCriteria example);

    TbPdPersonnelProjectBank selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPdPersonnelProjectBank record, @Param("example") TbPdPersonnelProjectBankCriteria example);

    int updateByExample(@Param("record") TbPdPersonnelProjectBank record, @Param("example") TbPdPersonnelProjectBankCriteria example);

    int updateByPrimaryKeySelective(TbPdPersonnelProjectBank record);

    int updateByPrimaryKey(TbPdPersonnelProjectBank record);
}