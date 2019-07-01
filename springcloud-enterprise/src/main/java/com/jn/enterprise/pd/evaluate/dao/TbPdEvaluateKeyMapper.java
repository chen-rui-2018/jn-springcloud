package com.jn.enterprise.pd.evaluate.dao;

import com.jn.enterprise.pd.evaluate.entity.TbPdEvaluateKey;
import com.jn.enterprise.pd.evaluate.entity.TbPdEvaluateKeyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdEvaluateKeyMapper {
    long countByExample(TbPdEvaluateKeyCriteria example);

    int deleteByExample(TbPdEvaluateKeyCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPdEvaluateKey record);

    int insertSelective(TbPdEvaluateKey record);

    List<TbPdEvaluateKey> selectByExample(TbPdEvaluateKeyCriteria example);

    TbPdEvaluateKey selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPdEvaluateKey record, @Param("example") TbPdEvaluateKeyCriteria example);

    int updateByExample(@Param("record") TbPdEvaluateKey record, @Param("example") TbPdEvaluateKeyCriteria example);

    int updateByPrimaryKeySelective(TbPdEvaluateKey record);

    int updateByPrimaryKey(TbPdEvaluateKey record);
}