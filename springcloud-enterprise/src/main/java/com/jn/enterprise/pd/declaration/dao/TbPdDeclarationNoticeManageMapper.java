package com.jn.enterprise.pd.declaration.dao;

import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationNoticeManage;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationNoticeManageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdDeclarationNoticeManageMapper {
    long countByExample(TbPdDeclarationNoticeManageCriteria example);

    int deleteByExample(TbPdDeclarationNoticeManageCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPdDeclarationNoticeManage record);

    int insertSelective(TbPdDeclarationNoticeManage record);

    List<TbPdDeclarationNoticeManage> selectByExampleWithBLOBs(TbPdDeclarationNoticeManageCriteria example);

    List<TbPdDeclarationNoticeManage> selectByExample(TbPdDeclarationNoticeManageCriteria example);

    TbPdDeclarationNoticeManage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPdDeclarationNoticeManage record, @Param("example") TbPdDeclarationNoticeManageCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbPdDeclarationNoticeManage record, @Param("example") TbPdDeclarationNoticeManageCriteria example);

    int updateByExample(@Param("record") TbPdDeclarationNoticeManage record, @Param("example") TbPdDeclarationNoticeManageCriteria example);

    int updateByPrimaryKeySelective(TbPdDeclarationNoticeManage record);

    int updateByPrimaryKeyWithBLOBs(TbPdDeclarationNoticeManage record);

    int updateByPrimaryKey(TbPdDeclarationNoticeManage record);
}