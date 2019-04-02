package com.jn.enterprise.pd.support.dao;

import com.jn.enterprise.pd.support.entity.TbPdSupportFundExamine;
import com.jn.enterprise.pd.support.entity.TbPdSupportFundExamineCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdSupportFundExamineMapper {
    long countByExample(TbPdSupportFundExamineCriteria example);

    int deleteByExample(TbPdSupportFundExamineCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPdSupportFundExamine record);

    int insertSelective(TbPdSupportFundExamine record);

    List<TbPdSupportFundExamine> selectByExample(TbPdSupportFundExamineCriteria example);

    TbPdSupportFundExamine selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPdSupportFundExamine record, @Param("example") TbPdSupportFundExamineCriteria example);

    int updateByExample(@Param("record") TbPdSupportFundExamine record, @Param("example") TbPdSupportFundExamineCriteria example);

    int updateByPrimaryKeySelective(TbPdSupportFundExamine record);

    int updateByPrimaryKey(TbPdSupportFundExamine record);
}