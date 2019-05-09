package com.jn.enterprise.pay.dao;

import com.jn.enterprise.pay.entity.TbPayAccountBookTypeSub;
import com.jn.enterprise.pay.entity.TbPayAccountBookTypeSubCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPayAccountBookTypeSubMapper {
    long countByExample(TbPayAccountBookTypeSubCriteria example);

    int deleteByExample(TbPayAccountBookTypeSubCriteria example);

    int deleteByPrimaryKey(String sonId);

    int insert(TbPayAccountBookTypeSub record);

    int insertSelective(TbPayAccountBookTypeSub record);

    List<TbPayAccountBookTypeSub> selectByExample(TbPayAccountBookTypeSubCriteria example);

    TbPayAccountBookTypeSub selectByPrimaryKey(String sonId);

    int updateByExampleSelective(@Param("record") TbPayAccountBookTypeSub record, @Param("example") TbPayAccountBookTypeSubCriteria example);

    int updateByExample(@Param("record") TbPayAccountBookTypeSub record, @Param("example") TbPayAccountBookTypeSubCriteria example);

    int updateByPrimaryKeySelective(TbPayAccountBookTypeSub record);

    int updateByPrimaryKey(TbPayAccountBookTypeSub record);
}