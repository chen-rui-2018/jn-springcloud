package com.jn.enterprise.pd.declaration.dao;

import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationPlatformManage;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationPlatformManageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdDeclarationPlatformManageMapper {
    long countByExample(TbPdDeclarationPlatformManageCriteria example);

    int deleteByExample(TbPdDeclarationPlatformManageCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPdDeclarationPlatformManage record);

    int insertSelective(TbPdDeclarationPlatformManage record);

    List<TbPdDeclarationPlatformManage> selectByExample(TbPdDeclarationPlatformManageCriteria example);

    TbPdDeclarationPlatformManage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPdDeclarationPlatformManage record, @Param("example") TbPdDeclarationPlatformManageCriteria example);

    int updateByExample(@Param("record") TbPdDeclarationPlatformManage record, @Param("example") TbPdDeclarationPlatformManageCriteria example);

    int updateByPrimaryKeySelective(TbPdDeclarationPlatformManage record);

    int updateByPrimaryKey(TbPdDeclarationPlatformManage record);
}