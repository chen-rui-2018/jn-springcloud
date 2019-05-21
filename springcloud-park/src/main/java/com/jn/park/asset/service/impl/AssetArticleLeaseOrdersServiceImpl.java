package com.jn.park.asset.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.asset.dao.AssetArticleLeaseDao;
import com.jn.park.asset.dao.AssetArticleLeaseOrdersDao;
import com.jn.park.asset.dao.TbAssetArticleLeaseOrdersMapper;
import com.jn.park.asset.entity.TbAssetArticleLeaseOrders;
import com.jn.park.asset.enums.LeaseStatusEnums;
import com.jn.park.asset.enums.OrdersTypeEnums;
import com.jn.park.asset.model.AssetArticleLeaseModel;
import com.jn.park.asset.model.AssetArticleLeaseOrdersModel;
import com.jn.park.asset.model.LeaseOrdersModel;
import com.jn.park.asset.service.AssetArticleLeaseOrdersService;
import com.jn.pay.enums.ChannelIdEnum;
import com.jn.pay.enums.MchIdEnum;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.pay.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 发起支付
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "发起支付")
    @Transactional(rollbackFor = RuntimeException.class)
    public Result startPayment(String id) {
        AssetArticleLeaseOrdersModel leaseOrders = assetArticleLeaseOrdersDao.getLeaseOrders(id);
        /**调用支付接口发起支付*/
        logger.info("开始调用统一缴费发起支付接口操作");
        PayOrderReq payOrderReq = new PayOrderReq();
        //商户id
        payOrderReq.setMchId(MchIdEnum.MCH_BASE.getCode());
        //商户订单号
        payOrderReq.setMchOrderNo(leaseOrders.getId());
        //渠道ID(APP支付)
        payOrderReq.setChannelId(ChannelIdEnum.WX_APP.getCode());
        //支付金额
        return null;
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
