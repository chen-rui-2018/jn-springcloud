package com.jn.oa.goods.service;

import com.jn.oa.goods.vo.GoodsApplicationVo;
import com.jn.system.model.User;

/**
 * 物品管理控制层
 *
 * @author： shaobao
 * @date： Created on 2019/5/29 19:32
 * @version： v1.0
 * @modified By:
 **/
public interface GoodsService {

    /**
     * 更新物品数量
     *
     * @param goodsApplicationVo
     * @param user
     */
    void updateGoodsAccount(GoodsApplicationVo goodsApplicationVo, User user);
}
