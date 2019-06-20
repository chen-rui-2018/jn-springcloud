package com.jn.enterprise.pd.talent.dao;

import com.jn.enterprise.pd.talent.entity.TbPdPerennialDeclaration;
import com.jn.enterprise.pd.talent.entity.TbPdPerennialDeclarationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdPerennialDeclarationMapper {
    long countByExample(TbPdPerennialDeclarationCriteria example);

    int deleteByExample(TbPdPerennialDeclarationCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPdPerennialDeclaration record);

    int insertSelective(TbPdPerennialDeclaration record);

    List<TbPdPerennialDeclaration> selectByExample(TbPdPerennialDeclarationCriteria example);

    TbPdPerennialDeclaration selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPdPerennialDeclaration record, @Param("example") TbPdPerennialDeclarationCriteria example);

    int updateByExample(@Param("record") TbPdPerennialDeclaration record, @Param("example") TbPdPerennialDeclarationCriteria example);

    int updateByPrimaryKeySelective(TbPdPerennialDeclaration record);

    int updateByPrimaryKey(TbPdPerennialDeclaration record);
}