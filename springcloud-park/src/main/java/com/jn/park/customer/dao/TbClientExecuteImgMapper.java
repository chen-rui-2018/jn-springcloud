package com.jn.park.customer.dao;

import com.jn.park.customer.entity.TbClientExecuteImg;
import com.jn.park.customer.entity.TbClientExecuteImgCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbClientExecuteImgMapper {
    long countByExample(TbClientExecuteImgCriteria example);

    int deleteByExample(TbClientExecuteImgCriteria example);

    int insert(TbClientExecuteImg record);

    int insertSelective(TbClientExecuteImg record);

    List<TbClientExecuteImg> selectByExample(TbClientExecuteImgCriteria example);

    int updateByExampleSelective(@Param("record") TbClientExecuteImg record, @Param("example") TbClientExecuteImgCriteria example);

    int updateByExample(@Param("record") TbClientExecuteImg record, @Param("example") TbClientExecuteImgCriteria example);
}