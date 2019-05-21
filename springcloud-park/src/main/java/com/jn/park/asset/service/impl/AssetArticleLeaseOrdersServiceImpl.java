package com.jn.park.asset.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.park.asset.dao.AssetArticleLeaseDao;
import com.jn.park.asset.dao.AssetArticleLeaseOrdersDao;
import com.jn.park.asset.dao.TbAssetArticleLeaseOrdersMapper;
import com.jn.park.asset.dao.TbAssetArticleLeaseOrdersPayMapper;
import com.jn.park.asset.entity.TbAssetArticleLeaseOrders;
import com.jn.park.asset.entity.TbAssetArticleLeaseOrdersPay;
import com.jn.park.asset.entity.TbRoomOrders;
import com.jn.park.asset.entity.TbRoomOrdersPay;
import com.jn.park.asset.enums.LeaseStatusEnums;
import com.jn.park.asset.enums.OrdersTypeEnums;
import com.jn.park.asset.enums.PayStatusEnums;
import com.jn.park.asset.model.AssetArticleLeaseModel;
import com.jn.park.asset.model.AssetArticleLeaseOrdersModel;
import com.jn.park.asset.model.LeaseOrdersModel;
import com.jn.park.asset.service.AssetArticleLeaseOrdersService;
import com.jn.pay.api.PayOrderClient;
import com.jn.pay.enums.ChannelIdEnum;
import com.jn.pay.enums.MchIdEnum;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.pay.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xxpay.common.util.BeanToMap;
import org.xxpay.common.util.PayDigestUtil;
import org.xxpay.common.util.XXPayUtil;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
* 物品租赁订单impl
* @author： zhuyz
* @date： Created on 2019/5/4 18:23
* @version： v1.0
* @modified By:
*/
@Service
public class AssetArticleLeaseOrdersServiceImpl implements AssetArticleLeaseOrdersService {
    private static final Logger logger = LoggerFactory.getLogger(AssetArticleLeaseOrdersServiceImpl.class);

    @Autowired
    private  TbAssetArticleLeaseOrdersMapper tbAssetArticleLeaseOrdersMapper;
    @Autowired
    private AssetArticleLeaseOrdersDao assetArticleLeaseOrdersDao;
    @Autowired
    private AssetArticleLeaseDao assetArticleLeaseDao;
    @Autowired
    private PayOrderClient payOrderClient;
    @Autowired
    private TbAssetArticleLeaseOrdersPayMapper tbAssetArticleLeaseOrdersPayMapper;


    /**
     *根据订单编号查询租借详情
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据订单编号查询租借详情")
    public AssetArticleLeaseOrdersModel getLeaseOrders(String id) {
        AssetArticleLeaseOrdersModel assetArticleLeaseOrdersModel = assetArticleLeaseOrdersDao.getLeaseOrders(id);

        return assetArticleLeaseOrdersModel;
    }

    /**
     * 返回支付订单详情
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "返回支付订单详情")
    public LeaseOrdersModel getPayOrders(String id) {

        LeaseOrdersModel leaseOrdersModel = assetArticleLeaseOrdersDao.getPayOrders(id);
        try {
          if (leaseOrdersModel != null){
              //账单类型
              leaseOrdersModel.setOrdersType(OrdersTypeEnums.ARTICLE.getMessage());
              //计算最迟缴费时间
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
              String createTime = sdf.format(leaseOrdersModel.getCreateTime());
              leaseOrdersModel.setTime(createTime);
              Calendar cal = Calendar.getInstance();
              cal.setTime(sdf.parse(createTime));
              cal.add(Calendar.HOUR_OF_DAY,1);
              String lastTime = sdf.format(cal.getTime());
              leaseOrdersModel.setLastPayTime(lastTime);
              //设置条形码
              leaseOrdersModel.setBarCode(leaseOrdersModel.getAssetNumber());
              AssetArticleLeaseModel articleLease = assetArticleLeaseDao.getArticleLease(leaseOrdersModel.getAssetNumber());
              //设置最低租借时间
              leaseOrdersModel.setLeaseTime(articleLease.getLeaseTime());
          }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return leaseOrdersModel;
    }

    /**
     * 更新租赁物品状态和订单状态为归还中
     * @param id
     */
    @Override
    @ServiceLog(doAction = "归还")
    public void giveBack(String id) {
        TbAssetArticleLeaseOrders tbAssetArticleLeaseOrders = tbAssetArticleLeaseOrdersMapper.selectByPrimaryKey(id);
        Map<String,Object> map = new HashMap<>(16);
        map.put("assetNumber",tbAssetArticleLeaseOrders.getAssetNumber());
        map.put("id",id);
        map.put("status",Byte.parseByte(LeaseStatusEnums.RETURN_ING.getValue()));
        assetArticleLeaseDao.updateStatus(map);
        assetArticleLeaseOrdersDao.updateStatus(map);
    }

    /**
     * 分页返回物品租赁历史列表
     * @param page
     * @return
     */
    @Override
    @ServiceLog(doAction = "分页返回物品租赁历史列表")
    public PaginationData<List<AssetArticleLeaseOrdersModel>> getArticleLeaseOrdersList(String account, Page page) {
        com.github.pagehelper.Page<Object> objects = PageHelper.startPage(page.getPage(), page.getRows());
        List<AssetArticleLeaseOrdersModel> assetArticleLeaseOrdersModelList = assetArticleLeaseOrdersDao.getArticleLeaseOrdersList(account);
        PaginationData<List<AssetArticleLeaseOrdersModel>> data = new PaginationData<>(assetArticleLeaseOrdersModelList,objects.getTotal());
        return data;
    }

    /**
     * 创建支付订单
     * @param orderId
     * @param channelId
     * @param userAccount
     * @return
     */
    @Override
    @ServiceLog(doAction = "创建支付订单")
    public Result<PayOrderRsp> createPayOrder(String orderId, String channelId, String userAccount) {
        logger.info("创建支付订单,orderId={}",orderId);
        TbAssetArticleLeaseOrders tbAssetArticleLeaseOrders = tbAssetArticleLeaseOrdersMapper.selectByPrimaryKey(orderId);
        if(null==tbAssetArticleLeaseOrders){
            logger.info("订单不存在,orderId={}",orderId);
            return new Result("-1","订单不存在");
        }
        if(!StringUtils.equals(tbAssetArticleLeaseOrders.getCreatorAccount(),userAccount)){
            logger.info("非本人的订单，无法支付,orderId={}",orderId);
            return new Result("-1","非本人的订单，无法支付");
        }
        if(tbAssetArticleLeaseOrders.getPaymentStatus().equals(2)){
            logger.info("订单已支付，无需重复支付,orderId={}",orderId);
            return new Result("-1","订单已支付，无需重复支付");
        }

        PayOrderReq payOrderReq=new PayOrderReq();
        payOrderReq.setMchId(MchIdEnum.MCH_BASE.getCode());
        payOrderReq.setMchOrderNo(tbAssetArticleLeaseOrders.getId());
        payOrderReq.setChannelId(channelId);
        payOrderReq.setDevice("APP");
        payOrderReq.setServiceId("springcloud-park");
        payOrderReq.setServiceUrl("/api/order/articlePayCallBack");
        //订单最晚付款时长(60分钟)
        payOrderReq.setDuration(60);
        //金额的单位是分，需要转换下
        payOrderReq.setAmount(tbAssetArticleLeaseOrders.getPaySum().multiply(new BigDecimal("100")).longValue());
        payOrderReq.setSubject("物品租赁订单"+tbAssetArticleLeaseOrders.getId());
        payOrderReq.setBody(tbAssetArticleLeaseOrders.getLeaseEnterprise());

        //签名
        String sign= PayDigestUtil.getSign(BeanToMap.toMap(payOrderReq),MchIdEnum.MCH_BASE.getReqKey());
        payOrderReq.setSign(sign);

        logger.info("调用 统一支付下单接口,请求参数{}",payOrderReq);
        Result<PayOrderRsp> payResult=payOrderClient.createPayOrder(payOrderReq);
        logger.info("调用 统一支付下单接口，返回{}",payResult);
        if(!StringUtils.equals(payResult.getCode(),"0000")){
            logger.info("统一支付下单失败，{}",payOrderReq);
            return payResult;
        }

        /*******step 4 验证响应签名 ********/
        //验证响应签名
        boolean verifyFlag = XXPayUtil.verifyPaySign(BeanToMap.toMap(payResult.getData()), MchIdEnum.MCH_BASE.getRspKey());
        if(!verifyFlag) {
            logger.info(" 支付验证响应签名失败  fail ！verifyFlag={}",verifyFlag);
            return new Result<>("-1","支付验证响应签名失败");
        }

        TbAssetArticleLeaseOrdersPay  tbAssetArticleLeaseOrdersPay = new TbAssetArticleLeaseOrdersPay();
        tbAssetArticleLeaseOrdersPay.setPayId(payResult.getData().getPayOrderId());
        tbAssetArticleLeaseOrdersPay.setOrderId(orderId);
        //未付款
        tbAssetArticleLeaseOrdersPay.setPayState(Byte.parseByte(PayStatusEnums.NONPAYMENT.getCode()));
        tbAssetArticleLeaseOrdersPay.setCreateTime(new java.util.Date());
        tbAssetArticleLeaseOrdersPay.setCreatorAccount(userAccount);
        logger.info("支付订单接口返回成功，插入业务订单支付表{}",tbAssetArticleLeaseOrdersPay);
        tbAssetArticleLeaseOrdersPayMapper.insertSelective(tbAssetArticleLeaseOrdersPay);

        return  payResult;

    }

    @ServiceLog(doAction = "物品支付回调")
    @Override
    public  Result articlePayCallBack(PayOrderNotify payOrderNotify){
        logger.info("物品支付回调,参数：{}",payOrderNotify);
        //业务订单表的支付状态
        TbAssetArticleLeaseOrdersPay tbAssetArticleLeaseOrdersPay = tbAssetArticleLeaseOrdersPayMapper.selectByPrimaryKey(payOrderNotify.getPayOrderId());
        if(tbAssetArticleLeaseOrdersPay.getPayState().equals(1)){
            logger.info("支付状态已更新过了，无需再回调");
            return new Result("-1","支付状态已更新过了，无需再回调");
        }
        if(null==tbAssetArticleLeaseOrdersPay){
            logger.info("支付订单ID["+payOrderNotify.getPayOrderId()+"]不存在");
            return new Result("-1","支付订单ID["+payOrderNotify.getPayOrderId()+"]不存在");
        }

        //查询支付订单的支付状态
        PayOrderQueryReq req=new PayOrderQueryReq();
        req.setPayOrderId(payOrderNotify.getPayOrderId());
        //签名
        String sign=PayDigestUtil.getSign(BeanToMap.toMap(req),MchIdEnum.MCH_BASE.getReqKey());
        req.setSign(sign);
        logger.info("调用支付查询接口，请求参数:{}",req);
        Result<PayOrderQueryRsp> rep=payOrderClient.payOrderQuery(req);
        logger.info("调用支付查询接口，返回参数:{}",rep);
        if(rep.getData().getStatus().equals(2)){//支付成功
            TbAssetArticleLeaseOrdersPay updateRecord = new TbAssetArticleLeaseOrdersPay();
            updateRecord.setModifiedTime(new java.util.Date());
            updateRecord.setPayId(payOrderNotify.getPayOrderId());
            updateRecord.setPayState(new Byte("1"));
            logger.info("支付表的支付状态更新为：已支付，参数：{}",updateRecord);
            int updateCount=tbAssetArticleLeaseOrdersPayMapper.updateByPrimaryKeySelective(updateRecord);
            if(updateCount!=1){
                throw new JnSpringCloudException(new Result("-1","支付表tb_room_orders_pay更新失败"));
            }

            TbAssetArticleLeaseOrders tbAssetArticleLeaseOrders = new TbAssetArticleLeaseOrders();
            tbAssetArticleLeaseOrders.setId(tbAssetArticleLeaseOrdersPay.getOrderId());
            tbAssetArticleLeaseOrders.setPaymentStatus(updateRecord.getPayState());
            tbAssetArticleLeaseOrders.setModifiedTime(updateRecord.getModifiedTime());
            logger.info("订单表的支付状态更新为：已支付，参数：{}",tbAssetArticleLeaseOrders);
            updateCount=tbAssetArticleLeaseOrdersMapper.updateByPrimaryKeySelective(tbAssetArticleLeaseOrders);
            if(updateCount!=1){
                throw new JnSpringCloudException(new Result("-1","业务表tb_asset_article_lease_orders_pay更新失败"));
            }
            logger.info("回调成功，支付状态更新为：已支付");
            return new Result("回调成功，支付状态更新为：已支付");
        }else if(rep.getData().getStatus().equals(1)){//支付中
            logger.info("支付状态为支付中，无需回调");
            return new Result("-1","支付状态为支付中，无需回调");
        }else{
            logger.info("支付状态不是支付成功，无需回调");
            return new Result("-1","支付状态不是支付成功，无需回调");
        }
    }

    /**
     * 更新租赁物品状态和订单状态为已归还
     * @param id
     */
    @Override
    @ServiceLog(doAction = "确认归还")
    public void returnArticle(String id) {
        TbAssetArticleLeaseOrders tbAssetArticleLeaseOrders = tbAssetArticleLeaseOrdersMapper.selectByPrimaryKey(id);
        Map<String,Object> map = new HashMap<>(16);
        map.put("assetNumber",tbAssetArticleLeaseOrders.getAssetNumber());
        map.put("id",id);
        map.put("status",Byte.parseByte(LeaseStatusEnums.RETURN.getValue()));
        assetArticleLeaseDao.updateStatus(map);
        assetArticleLeaseOrdersDao.updateStatus(map);
    }


    /**
     * 更新租赁物品状态和订单状态为租借中
     * @param id
     */
    @Override
    @ServiceLog(doAction = "确认交付")
    public void deliveryArticle(String id) {
        TbAssetArticleLeaseOrders tbAssetArticleLeaseOrders = tbAssetArticleLeaseOrdersMapper.selectByPrimaryKey(id);
        Map<String,Object> map = new HashMap<>(16);
        map.put("assetNumber",tbAssetArticleLeaseOrders.getAssetNumber());
        map.put("id",id);
        map.put("status",Byte.parseByte(LeaseStatusEnums.LEASE.getValue()));
        assetArticleLeaseDao.updateStatus(map);
        assetArticleLeaseOrdersDao.updateStatus(map);
    }





}
