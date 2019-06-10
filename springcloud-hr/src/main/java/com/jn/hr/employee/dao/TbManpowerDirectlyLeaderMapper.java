package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerDirectlyLeader;
import com.jn.hr.employee.entity.TbManpowerDirectlyLeaderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerDirectlyLeaderMapper {
    long countByExample(TbManpowerDirectlyLeaderCriteria example);

    int deleteByExample(TbManpowerDirectlyLeaderCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerDirectlyLeader record);

    int insertSelective(TbManpowerDirectlyLeader record);

    List<TbManpowerDirectlyLeader> selectByExample(TbManpowerDirectlyLeaderCriteria example);

    TbManpowerDirectlyLeader selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerDirectlyLeader record, @Param("example") TbManpowerDirectlyLeaderCriteria example);

    int updateByExample(@Param("record") TbManpowerDirectlyLeader record, @Param("example") TbManpowerDirectlyLeaderCriteria example);

    int updateByPrimaryKeySelective(TbManpowerDirectlyLeader record);

    int updateByPrimaryKey(TbManpowerDirectlyLeader record);
}