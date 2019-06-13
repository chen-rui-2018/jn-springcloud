package com.jn.oa.goods.service;

import com.jn.oa.goods.entity.TbOaGoodsApplicationDetails;
import com.jn.oa.goods.vo.GoodsApplicationVo;
import com.jn.system.model.User;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 一键Email单元测试
 *
 * @author： shaobao
 * @date： Created on 2019/2/17 17:03
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoodsServiceTest {

    @Autowired
    private GoodsService goodsService;

    private static User user;

    @BeforeClass
    public static void init() {
        //初始化添加用户
        user = new User();
        user.setAccount("wangsong");
    }

    @Test
    public void updateGoodsAccount() {
        GoodsApplicationVo goodsApplicationVo = new GoodsApplicationVo();
        goodsApplicationVo.setId("575734531932291072");
        goodsApplicationVo.setCreatorAccount(user.getAccount());
        goodsApplicationVo.setTotal(10);
        goodsApplicationVo.setCreatedTime(new Date());

        List<TbOaGoodsApplicationDetails> list = new ArrayList<>();
        TbOaGoodsApplicationDetails goodsApplicationDetails1 = new TbOaGoodsApplicationDetails();
        goodsApplicationDetails1.setGoodsId("584112170917167104");
        goodsApplicationDetails1.setApplyNum(21);
        list.add(goodsApplicationDetails1);

        goodsApplicationVo.setTb_oa_goods_application_details(list);
        goodsService.updateGoodsAccount(goodsApplicationVo, user);
    }

}