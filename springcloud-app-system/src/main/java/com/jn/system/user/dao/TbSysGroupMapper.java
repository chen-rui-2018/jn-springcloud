package com.jn.system.user.dao;

import com.jn.system.user.entity.TbSysGroup;
import com.jn.system.user.entity.TbSysGroupCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysGroupMapper {
    long countByExample(TbSysGroupCriteria example);

    int deleteByExample(TbSysGroupCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysGroup record);

    int insertSelective(TbSysGroup record);

    List<TbSysGroup> selectByExample(TbSysGroupCriteria example);

    TbSysGroup selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysGroup record, @Param("example") TbSysGroupCriteria example);

    int updateByExample(@Param("record") TbSysGroup record, @Param("example") TbSysGroupCriteria example);

    int updateByPrimaryKeySelective(TbSysGroup record);

    int updateByPrimaryKey(TbSysGroup record);
}