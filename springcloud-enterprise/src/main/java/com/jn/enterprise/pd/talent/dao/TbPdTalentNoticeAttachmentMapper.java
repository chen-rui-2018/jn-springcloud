package com.jn.enterprise.pd.talent.dao;

import com.jn.enterprise.pd.talent.entity.TbPdTalentNoticeAttachment;
import com.jn.enterprise.pd.talent.entity.TbPdTalentNoticeAttachmentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdTalentNoticeAttachmentMapper {
    long countByExample(TbPdTalentNoticeAttachmentCriteria example);

    int deleteByExample(TbPdTalentNoticeAttachmentCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPdTalentNoticeAttachment record);

    int insertSelective(TbPdTalentNoticeAttachment record);

    List<TbPdTalentNoticeAttachment> selectByExample(TbPdTalentNoticeAttachmentCriteria example);

    TbPdTalentNoticeAttachment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPdTalentNoticeAttachment record, @Param("example") TbPdTalentNoticeAttachmentCriteria example);

    int updateByExample(@Param("record") TbPdTalentNoticeAttachment record, @Param("example") TbPdTalentNoticeAttachmentCriteria example);

    int updateByPrimaryKeySelective(TbPdTalentNoticeAttachment record);

    int updateByPrimaryKey(TbPdTalentNoticeAttachment record);
}