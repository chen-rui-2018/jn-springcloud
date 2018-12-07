package com.jn.miniprogram.area.dao;

import com.jn.miniprogram.area.entity.TbMiniProgramArea;
import com.jn.miniprogram.area.entity.TbMiniProgramAreaCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbMiniProgramAreaMapper {
    long countByExample(TbMiniProgramAreaCriteria example);

    int deleteByExample(TbMiniProgramAreaCriteria example);

    int deleteByPrimaryKey(String areaId);

    int insert(TbMiniProgramArea record);

    int insertSelective(TbMiniProgramArea record);

    List<TbMiniProgramArea> selectByExample(TbMiniProgramAreaCriteria example);

    TbMiniProgramArea selectByPrimaryKey(String areaId);

    int updateByExampleSelective(@Param("record") TbMiniProgramArea record, @Param("example") TbMiniProgramAreaCriteria example);

    int updateByExample(@Param("record") TbMiniProgramArea record, @Param("example") TbMiniProgramAreaCriteria example);

    int updateByPrimaryKeySelective(TbMiniProgramArea record);

    int updateByPrimaryKey(TbMiniProgramArea record);
}