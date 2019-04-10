package com.jn.enterprise.pd.declaration.dao;

import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationNoticeAttachment;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationNoticeAttachmentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPdDeclarationNoticeAttachmentMapper {
    long countByExample(TbPdDeclarationNoticeAttachmentCriteria example);

    int deleteByExample(TbPdDeclarationNoticeAttachmentCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPdDeclarationNoticeAttachment record);

    int insertSelective(TbPdDeclarationNoticeAttachment record);

    List<TbPdDeclarationNoticeAttachment> selectByExample(TbPdDeclarationNoticeAttachmentCriteria example);

    TbPdDeclarationNoticeAttachment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPdDeclarationNoticeAttachment record, @Param("example") TbPdDeclarationNoticeAttachmentCriteria example);

    int updateByExample(@Param("record") TbPdDeclarationNoticeAttachment record, @Param("example") TbPdDeclarationNoticeAttachmentCriteria example);

    int updateByPrimaryKeySelective(TbPdDeclarationNoticeAttachment record);

    int updateByPrimaryKey(TbPdDeclarationNoticeAttachment record);
}