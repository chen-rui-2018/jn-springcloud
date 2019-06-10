package com.jn.enterprise.pd.personnel.dao;

import com.jn.enterprise.pd.personnel.entity.TbPdPersonnelTalentLabel;
import com.jn.enterprise.pd.personnel.entity.TbPdPersonnelTalentLabelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdPersonnelTalentLabelMapper {
    long countByExample(TbPdPersonnelTalentLabelCriteria example);

    int deleteByExample(TbPdPersonnelTalentLabelCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPdPersonnelTalentLabel record);

    int insertSelective(TbPdPersonnelTalentLabel record);

    List<TbPdPersonnelTalentLabel> selectByExample(TbPdPersonnelTalentLabelCriteria example);

    TbPdPersonnelTalentLabel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPdPersonnelTalentLabel record, @Param("example") TbPdPersonnelTalentLabelCriteria example);

    int updateByExample(@Param("record") TbPdPersonnelTalentLabel record, @Param("example") TbPdPersonnelTalentLabelCriteria example);

    int updateByPrimaryKeySelective(TbPdPersonnelTalentLabel record);

    int updateByPrimaryKey(TbPdPersonnelTalentLabel record);
}