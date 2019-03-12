package com.jn.park.approve.dao;

import com.jn.park.approve.entity.TbApproveGuide;
import com.jn.park.approve.entity.TbApproveGuideCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbApproveGuideMapper {
    long countByExample(TbApproveGuideCriteria example);

    int deleteByExample(TbApproveGuideCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbApproveGuide record);

    int insertSelective(TbApproveGuide record);

    List<TbApproveGuide> selectByExample(TbApproveGuideCriteria example);

    TbApproveGuide selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbApproveGuide record, @Param("example") TbApproveGuideCriteria example);

    int updateByExample(@Param("record") TbApproveGuide record, @Param("example") TbApproveGuideCriteria example);

    int updateByPrimaryKeySelective(TbApproveGuide record);

    int updateByPrimaryKey(TbApproveGuide record);
}