package com.jn.enterprise.servicemarket.product.dao;

import com.jn.enterprise.servicemarket.product.entity.TbServiceDetails;
import com.jn.enterprise.servicemarket.product.entity.TbServiceDetailsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbServiceDetailsMapper {
    long countByExample(TbServiceDetailsCriteria example);

    int deleteByExample(TbServiceDetailsCriteria example);

    int insert(TbServiceDetails record);

    int insertSelective(TbServiceDetails record);

    List<TbServiceDetails> selectByExampleWithBLOBs(TbServiceDetailsCriteria example);

    List<TbServiceDetails> selectByExample(TbServiceDetailsCriteria example);

    int updateByExampleSelective(@Param("record") TbServiceDetails record, @Param("example") TbServiceDetailsCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbServiceDetails record, @Param("example") TbServiceDetailsCriteria example);

    int updateByExample(@Param("record") TbServiceDetails record, @Param("example") TbServiceDetailsCriteria example);
}