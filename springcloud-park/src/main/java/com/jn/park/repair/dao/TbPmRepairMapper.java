package com.jn.park.repair.dao;

import com.jn.park.repair.entity.TbPmRepair;
import com.jn.park.repair.entity.TbPmRepairCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPmRepairMapper {
    long countByExample(TbPmRepairCriteria example);

    int deleteByExample(TbPmRepairCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPmRepair record);

    int insertSelective(TbPmRepair record);

    List<TbPmRepair> selectByExample(TbPmRepairCriteria example);

    TbPmRepair selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPmRepair record, @Param("example") TbPmRepairCriteria example);

    int updateByExample(@Param("record") TbPmRepair record, @Param("example") TbPmRepairCriteria example);

    int updateByPrimaryKeySelective(TbPmRepair record);

    int updateByPrimaryKey(TbPmRepair record);
}