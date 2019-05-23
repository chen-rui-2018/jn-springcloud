package com.jn.park.sp.dao;

import com.jn.park.sp.entity.TbSpAd;
import com.jn.park.sp.entity.TbSpAdCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSpAdMapper {
    long countByExample(TbSpAdCriteria example);

    int deleteByExample(TbSpAdCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSpAd record);

    int insertSelective(TbSpAd record);

    List<TbSpAd> selectByExample(TbSpAdCriteria example);

    TbSpAd selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSpAd record, @Param("example") TbSpAdCriteria example);

    int updateByExample(@Param("record") TbSpAd record, @Param("example") TbSpAdCriteria example);

    int updateByPrimaryKeySelective(TbSpAd record);

    int updateByPrimaryKey(TbSpAd record);
}