package com.jn.system.permission.dao;

import com.jn.system.permission.entity.TbSysPermissionFiles;
import com.jn.system.permission.entity.TbSysPermissionFilesCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysPermissionFilesMapper {
    long countByExample(TbSysPermissionFilesCriteria example);

    int deleteByExample(TbSysPermissionFilesCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysPermissionFiles record);

    int insertSelective(TbSysPermissionFiles record);

    List<TbSysPermissionFiles> selectByExample(TbSysPermissionFilesCriteria example);

    TbSysPermissionFiles selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysPermissionFiles record, @Param("example") TbSysPermissionFilesCriteria example);

    int updateByExample(@Param("record") TbSysPermissionFiles record, @Param("example") TbSysPermissionFilesCriteria example);

    int updateByPrimaryKeySelective(TbSysPermissionFiles record);

    int updateByPrimaryKey(TbSysPermissionFiles record);
}