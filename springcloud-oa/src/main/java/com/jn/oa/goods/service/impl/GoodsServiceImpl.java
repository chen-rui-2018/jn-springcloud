package com.jn.oa.goods.service.impl;

import com.jn.common.channel.MessageSource;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.news.vo.EmailVo;
import com.jn.oa.goods.dao.GoodsApplicationDetailsMapper;
import com.jn.oa.goods.dao.TbOaGoodsMapper;
import com.jn.oa.goods.domain.GoodsProperties;
import com.jn.oa.goods.enmus.GoodsTemplateEnums;
import com.jn.oa.goods.entity.TbOaGoods;
import com.jn.oa.goods.entity.TbOaGoodsApplicationDetails;
import com.jn.oa.goods.service.GoodsService;
import com.jn.oa.goods.vo.GoodsApplicationVo;
import com.jn.oa.notice.service.impl.NoticeServiceImpl;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysRole;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private GoodsProperties goodsProperties;

    @Autowired
    private SystemClient systemClient;

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

        //物品集合,用于添加物品数量为0的物品
        List<TbOaGoods> goodsList = new ArrayList<TbOaGoods>(16);
        for (TbOaGoodsApplicationDetails tb_oa_goods_application_detail : tb_oa_goods_application_details) {
            //获取当前申请数量
            Integer applyNum = tb_oa_goods_application_detail.getApplyNum();

            //获取当前物品信息
            String goodsId = tb_oa_goods_application_detail.getGoodsId();
            TbOaGoods tbOaGoods = tbOaGoodsMapper.selectByPrimaryKey(goodsId);
            if (tbOaGoods != null) {
                Integer goodsNum = tbOaGoods.getGoodsNum();
                goodsNum = goodsNum - applyNum;
                if (goodsNum <= 0) {
                    goodsNum = 0;
                    goodsList.add(tbOaGoods);
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

        //判断是否存在物品数量为0,当为0时,为指定用户发送邮件通知
        sendRemindEmail(user, goodsList);
    }

    /**
     * 当物品数量为0时,为指定用户发送邮件提醒
     *
     * @param user      当前用户
     * @param goodsList 物品集合
     */
    private void sendRemindEmail(User user, List<TbOaGoods> goodsList) {
        if (goodsList != null && goodsList.size() > 0) {
            //发送邮件
            String goodsManagerRolesId = goodsProperties.getGoodsManagerRolesId();
            if (StringUtils.isNotBlank(goodsManagerRolesId)) {
                //角色id不为空时,获取指定用户
                SysRole role = new SysRole();
                role.setId(goodsManagerRolesId);
                Result<List<User>> userResult = systemClient.getUserByRole(role);
                //如果获取到用户
                if (userResult != null && userResult.getData() != null && userResult.getData().size() > 0) {
                    //遍历,获取用户的邮箱
                    StringBuffer buffer = new StringBuffer();
                    List<User> userList = userResult.getData();
                    for (User user1 : userList) {
                        String email = user1.getEmail();
                        if (StringUtils.isNotBlank(email)) {
                            buffer.append(email).append(",");
                        }
                    }

                    //获取到用户,则发送邮件
                    if (buffer.length() > 0) {
                        String email = buffer.substring(0, buffer.length() - 1);
                        EmailVo emailVo = new EmailVo();
                        emailVo.setEmail(email);
                        emailVo.setEmailSubject("[白下智慧园区]物品管理数量提醒");
                        emailVo.setTemplatesName(GoodsTemplateEnums.GOODS_REMIND_TEMPLATE.getCode());

                        //封装数据
                        Map map = new HashMap();
                        map.put("currentTime", DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));

                        map.put("taskCount", goodsList.size());
                        map.put("goodsList", goodsList);
                        emailVo.setTemplatesDataMap(map);
                        emailVo.setTemplateFlag(true);

                        boolean sendStatus = messageSource.outputEmail().send(MessageBuilder.withPayload(emailVo).build());
                        if (sendStatus) {
                            logger.info("[工作计划] 任务提醒发送成功,用户邮箱:{}", email);
                        } else {
                            logger.error("[工作计划] 任务提醒发送失败,用户邮箱:{}", email);
                        }
                    }
                }
            }
        }
    }
}
