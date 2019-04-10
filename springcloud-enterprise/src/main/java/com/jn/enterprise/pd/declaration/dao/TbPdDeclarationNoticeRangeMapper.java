package com.jn.enterprise.pd.declaration.dao;

import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationNoticeRange;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationNoticeRangeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdDeclarationNoticeRangeMapper {
    long countByExample(TbPdDeclarationNoticeRangeCriteria example);

    int deleteByExample(TbPdDeclarationNoticeRangeCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPdDeclarationNoticeRange record);

    int insertSelective(TbPdDeclarationNoticeRange record);

    List<TbPdDeclarationNoticeRange> selectByExample(TbPdDeclarationNoticeRangeCriteria example);

    TbPdDeclarationNoticeRange selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPdDeclarationNoticeRange record, @Param("example") TbPdDeclarationNoticeRangeCriteria example);

    int updateByExample(@Param("record") TbPdDeclarationNoticeRange record, @Param("example") TbPdDeclarationNoticeRangeCriteria example);

    int updateByPrimaryKeySelective(TbPdDeclarationNoticeRange record);

    int updateByPrimaryKey(TbPdDeclarationNoticeRange record);
}