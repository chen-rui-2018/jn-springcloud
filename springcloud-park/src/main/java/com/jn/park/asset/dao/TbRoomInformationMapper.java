package com.jn.park.asset.dao;

import com.jn.park.asset.entity.TbRoomInformation;
import com.jn.park.asset.entity.TbRoomInformationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRoomInformationMapper {
    long countByExample(TbRoomInformationCriteria example);

    int deleteByExample(TbRoomInformationCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbRoomInformation record);

    int insertSelective(TbRoomInformation record);

    List<TbRoomInformation> selectByExample(TbRoomInformationCriteria example);

    TbRoomInformation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbRoomInformation record, @Param("example") TbRoomInformationCriteria example);

    int updateByExample(@Param("record") TbRoomInformation record, @Param("example") TbRoomInformationCriteria example);

    int updateByPrimaryKeySelective(TbRoomInformation record);

    int updateByPrimaryKey(TbRoomInformation record);
}