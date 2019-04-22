package com.jn.enterprise.propaganda.dao;

import com.jn.enterprise.propaganda.entity.TbPropaganda;
import com.jn.enterprise.propaganda.entity.TbPropagandaCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPropagandaMapper {
    long countByExample(TbPropagandaCriteria example);

    int deleteByExample(TbPropagandaCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPropaganda record);

    int insertSelective(TbPropaganda record);

    List<TbPropaganda> selectByExampleWithBLOBs(TbPropagandaCriteria example);

    List<TbPropaganda> selectByExample(TbPropagandaCriteria example);

    TbPropaganda selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPropaganda record, @Param("example") TbPropagandaCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbPropaganda record, @Param("example") TbPropagandaCriteria example);

    int updateByExample(@Param("record") TbPropaganda record, @Param("example") TbPropagandaCriteria example);

    int updateByPrimaryKeySelective(TbPropaganda record);

    int updateByPrimaryKeyWithBLOBs(TbPropaganda record);

    int updateByPrimaryKey(TbPropaganda record);
}