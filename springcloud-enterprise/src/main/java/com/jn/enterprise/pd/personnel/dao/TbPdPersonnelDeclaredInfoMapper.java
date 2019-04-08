package com.jn.enterprise.pd.personnel.dao;

import com.jn.enterprise.pd.personnel.entity.TbPdPersonnelDeclaredInfo;
import com.jn.enterprise.pd.personnel.entity.TbPdPersonnelDeclaredInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdPersonnelDeclaredInfoMapper {
    long countByExample(TbPdPersonnelDeclaredInfoCriteria example);

    int deleteByExample(TbPdPersonnelDeclaredInfoCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPdPersonnelDeclaredInfo record);

    int insertSelective(TbPdPersonnelDeclaredInfo record);

    List<TbPdPersonnelDeclaredInfo> selectByExample(TbPdPersonnelDeclaredInfoCriteria example);

    TbPdPersonnelDeclaredInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPdPersonnelDeclaredInfo record, @Param("example") TbPdPersonnelDeclaredInfoCriteria example);

    int updateByExample(@Param("record") TbPdPersonnelDeclaredInfo record, @Param("example") TbPdPersonnelDeclaredInfoCriteria example);

    int updateByPrimaryKeySelective(TbPdPersonnelDeclaredInfo record);

    int updateByPrimaryKey(TbPdPersonnelDeclaredInfo record);
}