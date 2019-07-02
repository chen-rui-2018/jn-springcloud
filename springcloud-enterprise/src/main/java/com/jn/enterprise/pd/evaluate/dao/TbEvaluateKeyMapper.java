package com.jn.enterprise.pd.evaluate.dao;

import com.jn.enterprise.pd.evaluate.entity.TbEvaluateKey;
import com.jn.enterprise.pd.evaluate.entity.TbEvaluateKeyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbEvaluateKeyMapper {
    long countByExample(TbEvaluateKeyCriteria example);

    int deleteByExample(TbEvaluateKeyCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbEvaluateKey record);

    int insertSelective(TbEvaluateKey record);

    List<TbEvaluateKey> selectByExample(TbEvaluateKeyCriteria example);

    TbEvaluateKey selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbEvaluateKey record, @Param("example") TbEvaluateKeyCriteria example);

    int updateByExample(@Param("record") TbEvaluateKey record, @Param("example") TbEvaluateKeyCriteria example);

    int updateByPrimaryKeySelective(TbEvaluateKey record);

    int updateByPrimaryKey(TbEvaluateKey record);
}