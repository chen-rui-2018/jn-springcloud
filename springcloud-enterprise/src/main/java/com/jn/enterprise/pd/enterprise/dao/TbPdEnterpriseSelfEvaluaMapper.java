package com.jn.enterprise.pd.enterprise.dao;

import com.jn.enterprise.pd.enterprise.entity.TbPdEnterpriseSelfEvalua;
import com.jn.enterprise.pd.enterprise.entity.TbPdEnterpriseSelfEvaluaCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdEnterpriseSelfEvaluaMapper {
    long countByExample(TbPdEnterpriseSelfEvaluaCriteria example);

    int deleteByExample(TbPdEnterpriseSelfEvaluaCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPdEnterpriseSelfEvalua record);

    int insertSelective(TbPdEnterpriseSelfEvalua record);

    List<TbPdEnterpriseSelfEvalua> selectByExample(TbPdEnterpriseSelfEvaluaCriteria example);

    TbPdEnterpriseSelfEvalua selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPdEnterpriseSelfEvalua record, @Param("example") TbPdEnterpriseSelfEvaluaCriteria example);

    int updateByExample(@Param("record") TbPdEnterpriseSelfEvalua record, @Param("example") TbPdEnterpriseSelfEvaluaCriteria example);

    int updateByPrimaryKeySelective(TbPdEnterpriseSelfEvalua record);

    int updateByPrimaryKey(TbPdEnterpriseSelfEvalua record);
}