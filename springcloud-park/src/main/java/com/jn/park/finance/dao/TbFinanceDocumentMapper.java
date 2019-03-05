package com.jn.park.finance.dao;

import com.jn.park.finance.entity.TbFinanceDocument;
import com.jn.park.finance.entity.TbFinanceDocumentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFinanceDocumentMapper {
    long countByExample(TbFinanceDocumentExample example);

    int deleteByExample(TbFinanceDocumentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFinanceDocument record);

    int insertSelective(TbFinanceDocument record);

    List<TbFinanceDocument> selectByExample(TbFinanceDocumentExample example);

    TbFinanceDocument selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFinanceDocument record, @Param("example") TbFinanceDocumentExample example);

    int updateByExample(@Param("record") TbFinanceDocument record, @Param("example") TbFinanceDocumentExample example);

    int updateByPrimaryKeySelective(TbFinanceDocument record);

    int updateByPrimaryKey(TbFinanceDocument record);
}