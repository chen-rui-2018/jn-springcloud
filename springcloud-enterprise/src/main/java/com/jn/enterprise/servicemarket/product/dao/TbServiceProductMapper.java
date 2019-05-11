package com.jn.enterprise.servicemarket.product.dao;

import com.jn.enterprise.servicemarket.product.entity.TbServiceProduct;
import com.jn.enterprise.servicemarket.product.entity.TbServiceProductCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceProductMapper {
    long countByExample(TbServiceProductCriteria example);

    int deleteByExample(TbServiceProductCriteria example);

    int deleteByPrimaryKey(String productId);

    int insert(TbServiceProduct record);

    int insertSelective(TbServiceProduct record);

    List<TbServiceProduct> selectByExampleWithBLOBs(TbServiceProductCriteria example);

    List<TbServiceProduct> selectByExample(TbServiceProductCriteria example);

    TbServiceProduct selectByPrimaryKey(String productId);

    int updateByExampleSelective(@Param("record") TbServiceProduct record, @Param("example") TbServiceProductCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbServiceProduct record, @Param("example") TbServiceProductCriteria example);

    int updateByExample(@Param("record") TbServiceProduct record, @Param("example") TbServiceProductCriteria example);

    int updateByPrimaryKeySelective(TbServiceProduct record);

    int updateByPrimaryKeyWithBLOBs(TbServiceProduct record);

    int updateByPrimaryKey(TbServiceProduct record);
}