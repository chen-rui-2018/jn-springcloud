package com.jn.system.file.dao;

import com.jn.system.file.entity.TbSysFileGroup;
import com.jn.system.file.entity.TbSysFileGroupCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysFileGroupMapper {
    long countByExample(TbSysFileGroupCriteria example);

    int deleteByExample(TbSysFileGroupCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysFileGroup record);

    int insertSelective(TbSysFileGroup record);

    List<TbSysFileGroup> selectByExample(TbSysFileGroupCriteria example);

    TbSysFileGroup selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysFileGroup record, @Param("example") TbSysFileGroupCriteria example);

    int updateByExample(@Param("record") TbSysFileGroup record, @Param("example") TbSysFileGroupCriteria example);

    int updateByPrimaryKeySelective(TbSysFileGroup record);

    int updateByPrimaryKey(TbSysFileGroup record);
}