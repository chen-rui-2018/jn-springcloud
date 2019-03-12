package com.jn.park.approve.dao;

import com.jn.park.approve.entity.TbApproveGuideMessage;
import com.jn.park.approve.entity.TbApproveGuideMessageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbApproveGuideMessageMapper {
    long countByExample(TbApproveGuideMessageCriteria example);

    int deleteByExample(TbApproveGuideMessageCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbApproveGuideMessage record);

    int insertSelective(TbApproveGuideMessage record);

    List<TbApproveGuideMessage> selectByExample(TbApproveGuideMessageCriteria example);

    TbApproveGuideMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbApproveGuideMessage record, @Param("example") TbApproveGuideMessageCriteria example);

    int updateByExample(@Param("record") TbApproveGuideMessage record, @Param("example") TbApproveGuideMessageCriteria example);

    int updateByPrimaryKeySelective(TbApproveGuideMessage record);

    int updateByPrimaryKey(TbApproveGuideMessage record);
}