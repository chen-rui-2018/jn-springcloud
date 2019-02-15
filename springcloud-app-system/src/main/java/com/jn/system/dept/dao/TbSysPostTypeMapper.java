package com.jn.system.dept.dao;

import com.jn.system.dept.entity.TbSysPostType;
import com.jn.system.dept.entity.TbSysPostTypeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysPostTypeMapper {
    long countByExample(TbSysPostTypeCriteria example);

    int deleteByExample(TbSysPostTypeCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysPostType record);

    int insertSelective(TbSysPostType record);

    List<TbSysPostType> selectByExample(TbSysPostTypeCriteria example);

    TbSysPostType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysPostType record, @Param("example") TbSysPostTypeCriteria example);

    int updateByExample(@Param("record") TbSysPostType record, @Param("example") TbSysPostTypeCriteria example);

    int updateByPrimaryKeySelective(TbSysPostType record);

    int updateByPrimaryKey(TbSysPostType record);
}