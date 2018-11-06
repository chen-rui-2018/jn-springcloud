package com.jn.system.dao;

import com.jn.system.entity.TbSysPermissionDb;
import com.jn.system.entity.TbSysPermissionDbCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysPermissionDbMapper {
    long countByExample(TbSysPermissionDbCriteria example);

    int deleteByExample(TbSysPermissionDbCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysPermissionDb record);

    int insertSelective(TbSysPermissionDb record);

    List<TbSysPermissionDb> selectByExample(TbSysPermissionDbCriteria example);

    TbSysPermissionDb selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysPermissionDb record, @Param("example") TbSysPermissionDbCriteria example);

    int updateByExample(@Param("record") TbSysPermissionDb record, @Param("example") TbSysPermissionDbCriteria example);

    int updateByPrimaryKeySelective(TbSysPermissionDb record);

    int updateByPrimaryKey(TbSysPermissionDb record);
}