package com.jn.park.approve.dao;

import com.jn.park.approve.entity.TbApproveGuideMaterials;
import com.jn.park.approve.entity.TbApproveGuideMaterialsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbApproveGuideMaterialsMapper {
    long countByExample(TbApproveGuideMaterialsCriteria example);

    int deleteByExample(TbApproveGuideMaterialsCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbApproveGuideMaterials record);

    int insertSelective(TbApproveGuideMaterials record);

    List<TbApproveGuideMaterials> selectByExample(TbApproveGuideMaterialsCriteria example);

    TbApproveGuideMaterials selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbApproveGuideMaterials record, @Param("example") TbApproveGuideMaterialsCriteria example);

    int updateByExample(@Param("record") TbApproveGuideMaterials record, @Param("example") TbApproveGuideMaterialsCriteria example);

    int updateByPrimaryKeySelective(TbApproveGuideMaterials record);

    int updateByPrimaryKey(TbApproveGuideMaterials record);
}