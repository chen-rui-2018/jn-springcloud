package com.jn.park.video.dao;

import com.jn.park.video.entity.TbPmVideo;
import com.jn.park.video.entity.TbPmVideoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPmVideoMapper {
    long countByExample(TbPmVideoCriteria example);

    int deleteByExample(TbPmVideoCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPmVideo record);

    int insertSelective(TbPmVideo record);

    List<TbPmVideo> selectByExampleWithBLOBs(TbPmVideoCriteria example);

    List<TbPmVideo> selectByExample(TbPmVideoCriteria example);

    TbPmVideo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPmVideo record, @Param("example") TbPmVideoCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbPmVideo record, @Param("example") TbPmVideoCriteria example);

    int updateByExample(@Param("record") TbPmVideo record, @Param("example") TbPmVideoCriteria example);

    int updateByPrimaryKeySelective(TbPmVideo record);

    int updateByPrimaryKeyWithBLOBs(TbPmVideo record);

    int updateByPrimaryKey(TbPmVideo record);
}