package com.jn.oa.goods.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 物品管理dao
 *
 * @author： shaobao
 * @date： Created on 2019/5/29 19:30
 * @version： v1.0
 * @modified By:
 **/
public interface GoodsApplicationDetailsMapper {

    /**
     * 根据物品id,更新未完成流程中改物品数量
     *
     * @param goodsId  物品id
     * @param goodsNum 物品数量
     */
    void updateGoodsNum(@Param("goodsId") String goodsId, @Param("goodsNum") Integer goodsNum);
}