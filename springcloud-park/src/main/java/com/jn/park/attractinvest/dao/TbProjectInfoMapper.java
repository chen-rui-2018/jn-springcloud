package com.jn.park.attractinvest.dao;

import com.jn.park.attractinvest.entity.TbProjectInfo;
import com.jn.park.attractinvest.entity.TbProjectInfoCriteria;
import com.jn.park.attractinvest.entity.TbProjectInfoWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbProjectInfoMapper {
    long countByExample(TbProjectInfoCriteria example);

    int deleteByExample(TbProjectInfoCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbProjectInfoWithBLOBs record);

    int insertSelective(TbProjectInfoWithBLOBs record);

    List<TbProjectInfoWithBLOBs> selectByExampleWithBLOBs(TbProjectInfoCriteria example);

    List<TbProjectInfo> selectByExample(TbProjectInfoCriteria example);

    TbProjectInfoWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbProjectInfoWithBLOBs record, @Param("example") TbProjectInfoCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbProjectInfoWithBLOBs record, @Param("example") TbProjectInfoCriteria example);

    int updateByExample(@Param("record") TbProjectInfo record, @Param("example") TbProjectInfoCriteria example);

    int updateByPrimaryKeySelective(TbProjectInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TbProjectInfoWithBLOBs record);

    int updateByPrimaryKey(TbProjectInfo record);
}