package com.jn.park.customer.dao;

import com.jn.park.customer.entity.TbClientServiceCenter;
import com.jn.park.customer.entity.TbClientServiceCenterCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbClientServiceCenterMapper {
    long countByExample(TbClientServiceCenterCriteria example);

    int deleteByExample(TbClientServiceCenterCriteria example);

    int insert(TbClientServiceCenter record);

    int insertSelective(TbClientServiceCenter record);

    List<TbClientServiceCenter> selectByExample(TbClientServiceCenterCriteria example);

    int updateByExampleSelective(@Param("record") TbClientServiceCenter record, @Param("example") TbClientServiceCenterCriteria example);

    int updateByExample(@Param("record") TbClientServiceCenter record, @Param("example") TbClientServiceCenterCriteria example);
}