package com.jn.im.dao;

import com.jn.im.entity.TbImMessage;
import com.jn.im.entity.TbImMessageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbImMessageMapper {
    long countByExample(TbImMessageCriteria example);

    int deleteByExample(TbImMessageCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbImMessage record);

    int insertSelective(TbImMessage record);

    List<TbImMessage> selectByExample(TbImMessageCriteria example);

    TbImMessage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbImMessage record, @Param("example") TbImMessageCriteria example);

    int updateByExample(@Param("record") TbImMessage record, @Param("example") TbImMessageCriteria example);

    int updateByPrimaryKeySelective(TbImMessage record);

    int updateByPrimaryKey(TbImMessage record);
}