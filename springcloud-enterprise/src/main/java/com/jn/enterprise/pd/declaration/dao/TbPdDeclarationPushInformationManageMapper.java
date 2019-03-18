package com.jn.enterprise.pd.declaration.dao;

import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationPushInformationManage;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationPushInformationManageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdDeclarationPushInformationManageMapper {
    long countByExample(TbPdDeclarationPushInformationManageCriteria example);

    int deleteByExample(TbPdDeclarationPushInformationManageCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPdDeclarationPushInformationManage record);

    int insertSelective(TbPdDeclarationPushInformationManage record);

    List<TbPdDeclarationPushInformationManage> selectByExample(TbPdDeclarationPushInformationManageCriteria example);

    TbPdDeclarationPushInformationManage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPdDeclarationPushInformationManage record, @Param("example") TbPdDeclarationPushInformationManageCriteria example);

    int updateByExample(@Param("record") TbPdDeclarationPushInformationManage record, @Param("example") TbPdDeclarationPushInformationManageCriteria example);

    int updateByPrimaryKeySelective(TbPdDeclarationPushInformationManage record);

    int updateByPrimaryKey(TbPdDeclarationPushInformationManage record);
}