package com.jn.hr.train.dao;

import com.jn.hr.train.entity.TbManpowerTrainManagement;
import com.jn.hr.train.entity.TbManpowerTrainManagementCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerTrainManagementMapper {
    long countByExample(TbManpowerTrainManagementCriteria example);

    int deleteByExample(TbManpowerTrainManagementCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerTrainManagement record);

    int insertSelective(TbManpowerTrainManagement record);

    List<TbManpowerTrainManagement> selectByExampleWithBLOBs(TbManpowerTrainManagementCriteria example);

    List<TbManpowerTrainManagement> selectByExample(TbManpowerTrainManagementCriteria example);

    TbManpowerTrainManagement selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerTrainManagement record, @Param("example") TbManpowerTrainManagementCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbManpowerTrainManagement record, @Param("example") TbManpowerTrainManagementCriteria example);

    int updateByExample(@Param("record") TbManpowerTrainManagement record, @Param("example") TbManpowerTrainManagementCriteria example);

    int updateByPrimaryKeySelective(TbManpowerTrainManagement record);

    int updateByPrimaryKeyWithBLOBs(TbManpowerTrainManagement record);

    int updateByPrimaryKey(TbManpowerTrainManagement record);
}