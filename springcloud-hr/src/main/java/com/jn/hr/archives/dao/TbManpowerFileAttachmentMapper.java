package com.jn.hr.archives.dao;

import com.jn.hr.archives.entity.TbManpowerFileAttachment;
import com.jn.hr.archives.entity.TbManpowerFileAttachmentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerFileAttachmentMapper {
    long countByExample(TbManpowerFileAttachmentCriteria example);

    int deleteByExample(TbManpowerFileAttachmentCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerFileAttachment record);

    int insertSelective(TbManpowerFileAttachment record);

    List<TbManpowerFileAttachment> selectByExample(TbManpowerFileAttachmentCriteria example);

    TbManpowerFileAttachment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerFileAttachment record, @Param("example") TbManpowerFileAttachmentCriteria example);

    int updateByExample(@Param("record") TbManpowerFileAttachment record, @Param("example") TbManpowerFileAttachmentCriteria example);

    int updateByPrimaryKeySelective(TbManpowerFileAttachment record);

    int updateByPrimaryKey(TbManpowerFileAttachment record);
}