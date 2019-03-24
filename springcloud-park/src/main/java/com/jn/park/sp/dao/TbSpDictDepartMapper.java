package com.jn.park.sp.dao;

import com.jn.park.sp.entity.TbSpDictDepart;
import com.jn.park.sp.entity.TbSpDictDepartCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSpDictDepartMapper {
    long countByExample(TbSpDictDepartCriteria example);

    int deleteByExample(TbSpDictDepartCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSpDictDepart record);

    int insertSelective(TbSpDictDepart record);

    List<TbSpDictDepart> selectByExample(TbSpDictDepartCriteria example);

    TbSpDictDepart selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSpDictDepart record, @Param("example") TbSpDictDepartCriteria example);

    int updateByExample(@Param("record") TbSpDictDepart record, @Param("example") TbSpDictDepartCriteria example);

    int updateByPrimaryKeySelective(TbSpDictDepart record);

    int updateByPrimaryKey(TbSpDictDepart record);
}