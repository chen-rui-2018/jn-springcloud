package com.jn.system.dao;

import com.jn.system.entity.SysGroup;
import com.jn.system.entity.SysGroupCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysGroupMapper {
    long countByExample(SysGroupCriteria example);

    int deleteByExample(SysGroupCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(SysGroup record);

    int insertSelective(SysGroup record);

    List<SysGroup> selectByExample(SysGroupCriteria example);

    SysGroup selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysGroup record, @Param("example") SysGroupCriteria example);

    int updateByExample(@Param("record") SysGroup record, @Param("example") SysGroupCriteria example);

    int updateByPrimaryKeySelective(SysGroup record);

    int updateByPrimaryKey(SysGroup record);
}