package com.jn.enterprise.pd.declaration.dao;

import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationPlatformSubordinate;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationPlatformSubordinateCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdDeclarationPlatformSubordinateMapper {
    long countByExample(TbPdDeclarationPlatformSubordinateCriteria example);

    int deleteByExample(TbPdDeclarationPlatformSubordinateCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPdDeclarationPlatformSubordinate record);

    int insertSelective(TbPdDeclarationPlatformSubordinate record);

    List<TbPdDeclarationPlatformSubordinate> selectByExample(TbPdDeclarationPlatformSubordinateCriteria example);

    TbPdDeclarationPlatformSubordinate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPdDeclarationPlatformSubordinate record, @Param("example") TbPdDeclarationPlatformSubordinateCriteria example);

    int updateByExample(@Param("record") TbPdDeclarationPlatformSubordinate record, @Param("example") TbPdDeclarationPlatformSubordinateCriteria example);

    int updateByPrimaryKeySelective(TbPdDeclarationPlatformSubordinate record);

    int updateByPrimaryKey(TbPdDeclarationPlatformSubordinate record);
}