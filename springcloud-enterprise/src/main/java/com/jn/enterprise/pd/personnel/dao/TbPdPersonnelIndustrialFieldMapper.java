package com.jn.enterprise.pd.personnel.dao;

import com.jn.enterprise.pd.personnel.entity.TbPdPersonnelIndustrialField;
import com.jn.enterprise.pd.personnel.entity.TbPdPersonnelIndustrialFieldCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdPersonnelIndustrialFieldMapper {
    long countByExample(TbPdPersonnelIndustrialFieldCriteria example);

    int deleteByExample(TbPdPersonnelIndustrialFieldCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPdPersonnelIndustrialField record);

    int insertSelective(TbPdPersonnelIndustrialField record);

    List<TbPdPersonnelIndustrialField> selectByExample(TbPdPersonnelIndustrialFieldCriteria example);

    TbPdPersonnelIndustrialField selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPdPersonnelIndustrialField record, @Param("example") TbPdPersonnelIndustrialFieldCriteria example);

    int updateByExample(@Param("record") TbPdPersonnelIndustrialField record, @Param("example") TbPdPersonnelIndustrialFieldCriteria example);

    int updateByPrimaryKeySelective(TbPdPersonnelIndustrialField record);

    int updateByPrimaryKey(TbPdPersonnelIndustrialField record);
}