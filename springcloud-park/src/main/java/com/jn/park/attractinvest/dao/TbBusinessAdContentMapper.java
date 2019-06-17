package com.jn.park.attractinvest.dao;

import com.jn.park.attractinvest.entity.TbBusinessAdContent;
import com.jn.park.attractinvest.entity.TbBusinessAdContentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbBusinessAdContentMapper {
    long countByExample(TbBusinessAdContentCriteria example);

    int deleteByExample(TbBusinessAdContentCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbBusinessAdContent record);

    int insertSelective(TbBusinessAdContent record);

    List<TbBusinessAdContent> selectByExampleWithBLOBs(TbBusinessAdContentCriteria example);

    List<TbBusinessAdContent> selectByExample(TbBusinessAdContentCriteria example);

    TbBusinessAdContent selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbBusinessAdContent record, @Param("example") TbBusinessAdContentCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbBusinessAdContent record, @Param("example") TbBusinessAdContentCriteria example);

    int updateByExample(@Param("record") TbBusinessAdContent record, @Param("example") TbBusinessAdContentCriteria example);

    int updateByPrimaryKeySelective(TbBusinessAdContent record);

    int updateByPrimaryKeyWithBLOBs(TbBusinessAdContent record);

    int updateByPrimaryKey(TbBusinessAdContent record);
}