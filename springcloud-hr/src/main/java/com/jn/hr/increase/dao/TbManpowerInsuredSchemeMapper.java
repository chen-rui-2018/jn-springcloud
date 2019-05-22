package com.jn.hr.increase.dao;

import com.jn.hr.increase.entity.TbManpowerInsuredScheme;
import com.jn.hr.increase.entity.TbManpowerInsuredSchemeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerInsuredSchemeMapper {
    long countByExample(TbManpowerInsuredSchemeCriteria example);

    int deleteByExample(TbManpowerInsuredSchemeCriteria example);

    int deleteByPrimaryKey(String schemeId);

    int insert(TbManpowerInsuredScheme record);

    int insertSelective(TbManpowerInsuredScheme record);

    List<TbManpowerInsuredScheme> selectByExample(TbManpowerInsuredSchemeCriteria example);

    TbManpowerInsuredScheme selectByPrimaryKey(String schemeId);

    int updateByExampleSelective(@Param("record") TbManpowerInsuredScheme record, @Param("example") TbManpowerInsuredSchemeCriteria example);

    int updateByExample(@Param("record") TbManpowerInsuredScheme record, @Param("example") TbManpowerInsuredSchemeCriteria example);

    int updateByPrimaryKeySelective(TbManpowerInsuredScheme record);

    int updateByPrimaryKey(TbManpowerInsuredScheme record);
}