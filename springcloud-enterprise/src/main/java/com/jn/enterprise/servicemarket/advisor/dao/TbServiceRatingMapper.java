package com.jn.enterprise.servicemarket.advisor.dao;

import com.jn.enterprise.servicemarket.advisor.entity.TbServiceRating;
import com.jn.enterprise.servicemarket.advisor.entity.TbServiceRatingCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceRatingMapper {
    long countByExample(TbServiceRatingCriteria example);

    int deleteByExample(TbServiceRatingCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbServiceRating record);

    int insertSelective(TbServiceRating record);

    List<TbServiceRating> selectByExample(TbServiceRatingCriteria example);

    TbServiceRating selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbServiceRating record, @Param("example") TbServiceRatingCriteria example);

    int updateByExample(@Param("record") TbServiceRating record, @Param("example") TbServiceRatingCriteria example);

    int updateByPrimaryKeySelective(TbServiceRating record);

    int updateByPrimaryKey(TbServiceRating record);
}