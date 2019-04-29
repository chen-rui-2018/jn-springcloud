package com.jn.enterprise.pd.declaration.dao;

import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationPlatformMemorandum;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationPlatformMemorandumCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdDeclarationPlatformMemorandumMapper {
    long countByExample(TbPdDeclarationPlatformMemorandumCriteria example);

    int deleteByExample(TbPdDeclarationPlatformMemorandumCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPdDeclarationPlatformMemorandum record);

    int insertSelective(TbPdDeclarationPlatformMemorandum record);

    List<TbPdDeclarationPlatformMemorandum> selectByExample(TbPdDeclarationPlatformMemorandumCriteria example);

    TbPdDeclarationPlatformMemorandum selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPdDeclarationPlatformMemorandum record, @Param("example") TbPdDeclarationPlatformMemorandumCriteria example);

    int updateByExample(@Param("record") TbPdDeclarationPlatformMemorandum record, @Param("example") TbPdDeclarationPlatformMemorandumCriteria example);

    int updateByPrimaryKeySelective(TbPdDeclarationPlatformMemorandum record);

    int updateByPrimaryKey(TbPdDeclarationPlatformMemorandum record);
}