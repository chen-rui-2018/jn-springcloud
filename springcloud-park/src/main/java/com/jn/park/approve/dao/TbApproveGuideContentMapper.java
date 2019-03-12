package com.jn.park.approve.dao;

import com.jn.park.approve.entity.TbApproveGuideContent;
import com.jn.park.approve.entity.TbApproveGuideContentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbApproveGuideContentMapper {
    long countByExample(TbApproveGuideContentCriteria example);

    int deleteByExample(TbApproveGuideContentCriteria example);

    int deleteByPrimaryKey(Integer guideId);

    int insert(TbApproveGuideContent record);

    int insertSelective(TbApproveGuideContent record);

    List<TbApproveGuideContent> selectByExampleWithBLOBs(TbApproveGuideContentCriteria example);

    List<TbApproveGuideContent> selectByExample(TbApproveGuideContentCriteria example);

    TbApproveGuideContent selectByPrimaryKey(Integer guideId);

    int updateByExampleSelective(@Param("record") TbApproveGuideContent record, @Param("example") TbApproveGuideContentCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbApproveGuideContent record, @Param("example") TbApproveGuideContentCriteria example);

    int updateByExample(@Param("record") TbApproveGuideContent record, @Param("example") TbApproveGuideContentCriteria example);

    int updateByPrimaryKeySelective(TbApproveGuideContent record);

    int updateByPrimaryKeyWithBLOBs(TbApproveGuideContent record);

    int updateByPrimaryKey(TbApproveGuideContent record);
}