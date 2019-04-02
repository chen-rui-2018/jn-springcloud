package com.jn.park.sp.dao;

import com.jn.park.sp.entity.TbSpMessage;
import com.jn.park.sp.entity.TbSpMessageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSpMessageMapper {
    long countByExample(TbSpMessageCriteria example);

    int deleteByExample(TbSpMessageCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSpMessage record);

    int insertSelective(TbSpMessage record);

    List<TbSpMessage> selectByExampleWithBLOBs(TbSpMessageCriteria example);

    List<TbSpMessage> selectByExample(TbSpMessageCriteria example);

    TbSpMessage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSpMessage record, @Param("example") TbSpMessageCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbSpMessage record, @Param("example") TbSpMessageCriteria example);

    int updateByExample(@Param("record") TbSpMessage record, @Param("example") TbSpMessageCriteria example);

    int updateByPrimaryKeySelective(TbSpMessage record);

    int updateByPrimaryKeyWithBLOBs(TbSpMessage record);

    int updateByPrimaryKey(TbSpMessage record);
}