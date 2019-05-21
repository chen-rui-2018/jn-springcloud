package com.jn.park.video.dao;

import com.jn.park.video.entity.TbVideoInfo;
import com.jn.park.video.entity.TbVideoInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbVideoInfoMapper {
    long countByExample(TbVideoInfoCriteria example);

    int deleteByExample(TbVideoInfoCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbVideoInfo record);

    int insertSelective(TbVideoInfo record);

    List<TbVideoInfo> selectByExample(TbVideoInfoCriteria example);

    TbVideoInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbVideoInfo record, @Param("example") TbVideoInfoCriteria example);

    int updateByExample(@Param("record") TbVideoInfo record, @Param("example") TbVideoInfoCriteria example);

    int updateByPrimaryKeySelective(TbVideoInfo record);

    int updateByPrimaryKey(TbVideoInfo record);
}