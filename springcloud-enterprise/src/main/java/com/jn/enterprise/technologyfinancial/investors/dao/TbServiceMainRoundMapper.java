package com.jn.enterprise.technologyfinancial.investors.dao;

import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceMainRound;
import com.jn.enterprise.technologyfinancial.investors.entity.TbServiceMainRoundCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceMainRoundMapper {
    long countByExample(TbServiceMainRoundCriteria example);

    int deleteByExample(TbServiceMainRoundCriteria example);

    int deleteByPrimaryKey(String mainRoundCode);

    int insert(TbServiceMainRound record);

    int insertSelective(TbServiceMainRound record);

    List<TbServiceMainRound> selectByExample(TbServiceMainRoundCriteria example);

    TbServiceMainRound selectByPrimaryKey(String mainRoundCode);

    int updateByExampleSelective(@Param("record") TbServiceMainRound record, @Param("example") TbServiceMainRoundCriteria example);

    int updateByExample(@Param("record") TbServiceMainRound record, @Param("example") TbServiceMainRoundCriteria example);

    int updateByPrimaryKeySelective(TbServiceMainRound record);

    int updateByPrimaryKey(TbServiceMainRound record);
}