package com.jn.oa.goods.service.impl;

import com.jn.oa.goods.dao.GoodsApplicationDetailsMapper;
import com.jn.oa.goods.dao.TbOaGoodsMapper;
import com.jn.oa.goods.entity.TbOaGoods;
import com.jn.oa.goods.entity.TbOaGoodsApplicationDetails;
import com.jn.oa.goods.service.GoodsService;
import com.jn.oa.goods.vo.GoodsApplicationVo;
import com.jn.oa.notice.service.impl.NoticeServiceImpl;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 物品管理服务层实现
 *
 * @author： shaobao
 * @date： Created on 2019/5/29 19:33
 * @version： v1.0
 * @modified By:
 **/
@Service
public class GoodsServiceImpl implements GoodsService {

    /**
     * 日志组件
     */
    private static final Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);

    @Autowired
    private TbOaGoodsMapper tbOaGoodsMapper;

    @Autowired
    private GoodsApplicationDetailsMapper goodsApplicationDetailsMapper;

    /**
     * 更新物品数量
     *
     * @param goodsApplicationVo
     * @param user
     */
    @Override
    @ServiceLog(doAction = "更新物品数量")
    @Transactional(rollbackFor = Exception.class)
    public void updateGoodsAccount(GoodsApplicationVo goodsApplicationVo, User user) {
        String account = user.getAccount();
        //获取申请物品明细
        List<TbOaGoodsApplicationDetails> tb_oa_goods_application_details = goodsApplicationVo.getTb_oa_goods_application_details();
        for (TbOaGoodsApplicationDetails tb_oa_goods_application_detail : tb_oa_goods_application_details) {
            //获取当前申请数量
            Integer applyNum = tb_oa_goods_application_detail.getApplyNum();

            //获取当前物品信息
            String goodsId = tb_oa_goods_application_detail.getGoodsId();
            TbOaGoods tbOaGoods = tbOaGoodsMapper.selectByPrimaryKey(goodsId);
            if (tbOaGoods != null) {
                Integer goodsNum = tbOaGoods.getGoodsNum();
                goodsNum = goodsNum - applyNum;
                if (goodsNum < 0) {
                    goodsNum = 0;
                }

                tbOaGoods.setGoodsNum(goodsNum);
                tbOaGoods.setModifierAccount(account);
                tbOaGoods.setModifiedTime(new Date());
                tbOaGoodsMapper.updateByPrimaryKeySelective(tbOaGoods);

                //根据物品id,更新未完成流程中改物品数量
                goodsApplicationDetailsMapper.updateGoodsNum(goodsId, goodsNum);
                logger.info("[物品管理] 更新物品数量成功,物品id:{}", goodsId);
            }
        }
    }
}
