package com.jn.park.hatch.dao;

import com.jn.park.hatch.entity.TbHatchHomeConfig;
import com.jn.park.hatch.entity.TbHatchHomeConfigCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbHatchHomeConfigMapper {
    long countByExample(TbHatchHomeConfigCriteria example);

    int deleteByExample(TbHatchHomeConfigCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbHatchHomeConfig record);

    int insertSelective(TbHatchHomeConfig record);

    List<TbHatchHomeConfig> selectByExample(TbHatchHomeConfigCriteria example);

    TbHatchHomeConfig selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbHatchHomeConfig record, @Param("example") TbHatchHomeConfigCriteria example);

    int updateByExample(@Param("record") TbHatchHomeConfig record, @Param("example") TbHatchHomeConfigCriteria example);

    int updateByPrimaryKeySelective(TbHatchHomeConfig record);

    int updateByPrimaryKey(TbHatchHomeConfig record);
}