package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerHonorWall;
import com.jn.hr.employee.entity.TbManpowerHonorWallCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerHonorWallMapper {
    long countByExample(TbManpowerHonorWallCriteria example);

    int deleteByExample(TbManpowerHonorWallCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerHonorWall record);

    int insertSelective(TbManpowerHonorWall record);

    List<TbManpowerHonorWall> selectByExample(TbManpowerHonorWallCriteria example);

    TbManpowerHonorWall selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerHonorWall record, @Param("example") TbManpowerHonorWallCriteria example);

    int updateByExample(@Param("record") TbManpowerHonorWall record, @Param("example") TbManpowerHonorWallCriteria example);

    int updateByPrimaryKeySelective(TbManpowerHonorWall record);

    int updateByPrimaryKey(TbManpowerHonorWall record);
}