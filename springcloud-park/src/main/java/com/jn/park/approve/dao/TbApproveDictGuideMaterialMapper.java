package com.jn.park.approve.dao;

import com.jn.park.approve.entity.TbApproveDictGuideMaterial;
import com.jn.park.approve.entity.TbApproveDictGuideMaterialCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbApproveDictGuideMaterialMapper {
    long countByExample(TbApproveDictGuideMaterialCriteria example);

    int deleteByExample(TbApproveDictGuideMaterialCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbApproveDictGuideMaterial record);

    int insertSelective(TbApproveDictGuideMaterial record);

    List<TbApproveDictGuideMaterial> selectByExample(TbApproveDictGuideMaterialCriteria example);

    TbApproveDictGuideMaterial selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbApproveDictGuideMaterial record, @Param("example") TbApproveDictGuideMaterialCriteria example);

    int updateByExample(@Param("record") TbApproveDictGuideMaterial record, @Param("example") TbApproveDictGuideMaterialCriteria example);

    int updateByPrimaryKeySelective(TbApproveDictGuideMaterial record);

    int updateByPrimaryKey(TbApproveDictGuideMaterial record);
}