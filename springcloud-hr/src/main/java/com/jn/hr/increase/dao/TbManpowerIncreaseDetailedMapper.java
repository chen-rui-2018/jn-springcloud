package com.jn.hr.increase.dao;

import com.jn.hr.increase.entity.TbManpowerIncreaseDetailed;
import com.jn.hr.increase.entity.TbManpowerIncreaseDetailedCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerIncreaseDetailedMapper {
    long countByExample(TbManpowerIncreaseDetailedCriteria example);

    int deleteByExample(TbManpowerIncreaseDetailedCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerIncreaseDetailed record);

    int insertSelective(TbManpowerIncreaseDetailed record);

    List<TbManpowerIncreaseDetailed> selectByExample(TbManpowerIncreaseDetailedCriteria example);

    TbManpowerIncreaseDetailed selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerIncreaseDetailed record, @Param("example") TbManpowerIncreaseDetailedCriteria example);

    int updateByExample(@Param("record") TbManpowerIncreaseDetailed record, @Param("example") TbManpowerIncreaseDetailedCriteria example);

    int updateByPrimaryKeySelective(TbManpowerIncreaseDetailed record);

    int updateByPrimaryKey(TbManpowerIncreaseDetailed record);
}