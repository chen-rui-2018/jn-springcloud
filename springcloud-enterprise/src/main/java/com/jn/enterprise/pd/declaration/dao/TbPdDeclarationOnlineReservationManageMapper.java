package com.jn.enterprise.pd.declaration.dao;

import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationOnlineReservationManage;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationOnlineReservationManageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdDeclarationOnlineReservationManageMapper {
    long countByExample(TbPdDeclarationOnlineReservationManageCriteria example);

    int deleteByExample(TbPdDeclarationOnlineReservationManageCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPdDeclarationOnlineReservationManage record);

    int insertSelective(TbPdDeclarationOnlineReservationManage record);

    List<TbPdDeclarationOnlineReservationManage> selectByExample(TbPdDeclarationOnlineReservationManageCriteria example);

    TbPdDeclarationOnlineReservationManage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPdDeclarationOnlineReservationManage record, @Param("example") TbPdDeclarationOnlineReservationManageCriteria example);

    int updateByExample(@Param("record") TbPdDeclarationOnlineReservationManage record, @Param("example") TbPdDeclarationOnlineReservationManageCriteria example);

    int updateByPrimaryKeySelective(TbPdDeclarationOnlineReservationManage record);

    int updateByPrimaryKey(TbPdDeclarationOnlineReservationManage record);
}