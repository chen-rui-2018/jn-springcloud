package com.jn.park.asset.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.asset.dao.AssetArticleLeaseDao;
import com.jn.park.asset.dao.TbAssetArticleLeaseMapper;
import com.jn.park.asset.dao.TbAssetArticleLeaseOrdersMapper;
import com.jn.park.asset.entity.TbAssetArticleLease;
import com.jn.park.asset.entity.TbAssetArticleLeaseCriteria;
import com.jn.park.asset.entity.TbAssetArticleLeaseOrders;
import com.jn.park.asset.enums.AssetStatusEnums;
import com.jn.park.asset.enums.LeaseStatusEnums;
import com.jn.park.asset.model.AssetArticleLeaseModel;
import com.jn.park.asset.service.AssetArticleLeaseService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
* 物品租赁impl
* @author： zhuyz
* @date： Created on 2019/4/29 15:35
* @version： v1.0
* @modified By:
*/
@Service
public class AssetArticleLeaseServiceImpl implements AssetArticleLeaseService {

    @Autowired
    private AssetArticleLeaseDao assetArticleLeaseDao;
    @Autowired
    private TbAssetArticleLeaseMapper tbAssetArticleLeaseMapper;
    @Autowired
    private TbAssetArticleLeaseOrdersMapper tbAssetArticleLeaseOrdersMapper;

    /**
     * 分页返回可租借的资产列表
     * @return
     */
    @Override
    @ServiceLog(doAction = "返回可租借的资产列表")
    public PaginationData<List<AssetArticleLeaseModel>> getArticleLeaseList(Page page) {
        //分页返回资产列表
        com.github.pagehelper.Page<Object> objects = PageHelper.startPage(page.getPage(), page.getRows());
        List<AssetArticleLeaseModel> assetArticleLeaseModelList = assetArticleLeaseDao.getArticleLeaseList();
        PaginationData<List<AssetArticleLeaseModel>> data = new PaginationData(assetArticleLeaseModelList,objects.getTotal());
        return data;
    }

    /**
     * 通过资产编号获取物品租赁详细信息
     * @param assetNumber
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据资产编号获取物品租赁详细信息")
    public AssetArticleLeaseModel getArticleLease(String assetNumber) {
        AssetArticleLeaseModel assetArticleLeaseModel = assetArticleLeaseDao.getArticleLease(assetNumber);
        return assetArticleLeaseModel;
    }


    @Override
    @ServiceLog(doAction = "企业填写租借资料")
    public void leaseWriter(String assetNumber, String leaseEnterprise, String contactName, String contactPhone, java.sql.Date startTime, java.sql.Date endTime) {
        //填写租借企业资料
        AssetArticleLeaseModel articleLease = assetArticleLeaseDao.getArticleLease(assetNumber);
        articleLease.setLeaseEnterprise(leaseEnterprise);
        articleLease.setContactName(contactName);
        articleLease.setContactPhone(contactPhone);
        articleLease.setStartTime(startTime);
        articleLease.setEndTime(endTime);
        TbAssetArticleLease tbAssetArticleLease = new TbAssetArticleLease();
        BeanUtils.copyProperties(articleLease,tbAssetArticleLease);
        tbAssetArticleLease.setApplyTime(new Date());
        TbAssetArticleLeaseCriteria example  = new TbAssetArticleLeaseCriteria();
        example.createCriteria().andAssetNumberEqualTo(tbAssetArticleLease.getAssetNumber());
        tbAssetArticleLeaseMapper.updateByExampleSelective(tbAssetArticleLease, example);
    }

    @Override
    @ServiceLog(doAction = "新增租赁订单")
    public String addLeaseOrders(String assetNumber, User user) {
        AssetArticleLeaseModel articleLease = assetArticleLeaseDao.getArticleLease(assetNumber);
        if (articleLease != null){
            TbAssetArticleLeaseOrders tbAssetArticleLeaseOrders = new TbAssetArticleLeaseOrders();
            //生成订单编号
            String ordersNumber = getOrderIdByTime();
            tbAssetArticleLeaseOrders.setId(ordersNumber);
            tbAssetArticleLeaseOrders.setAssetNumber(articleLease.getAssetNumber());
            tbAssetArticleLeaseOrders.setArticleId(articleLease.getId());
            tbAssetArticleLeaseOrders.setArticleName(articleLease.getName());
            tbAssetArticleLeaseOrders.setTypeId(articleLease.getTypeId());
            tbAssetArticleLeaseOrders.setAssetType(articleLease.getAssetType());
            tbAssetArticleLeaseOrders.setSpecification(articleLease.getSpecification());
            tbAssetArticleLeaseOrders.setArticleUrl(articleLease.getImgUrl());
            tbAssetArticleLeaseOrders.setArticleIntroduction(articleLease.getArticleIntroduction());
            tbAssetArticleLeaseOrders.setLeaseEnterprise(articleLease.getLeaseEnterprise());
            tbAssetArticleLeaseOrders.setContactName(articleLease.getContactName());
            tbAssetArticleLeaseOrders.setContactPhone(articleLease.getContactPhone());
            tbAssetArticleLeaseOrders.setLeaseCash(articleLease.getLeaseCash());
            tbAssetArticleLeaseOrders.setLeasePrice(articleLease.getLeasePrice());
            tbAssetArticleLeaseOrders.setStartTime(articleLease.getStartTime());
            tbAssetArticleLeaseOrders.setEndTime(articleLease.getEndTime());
            //订单创建者
            tbAssetArticleLeaseOrders.setContactName(user.getName());
            tbAssetArticleLeaseOrders.setRecordStatus(Byte.parseByte(AssetStatusEnums.EFFECTIVE.getCode()));
            //计算开始时间和结束时间的相差天数
            int days = (int) ((articleLease.getEndTime().getTime() - articleLease.getStartTime().getTime()) / (1000*3600*24)+1);
            //计算总共需要付款的金额
            BigDecimal day = new BigDecimal(String.valueOf(days));
            BigDecimal price = new BigDecimal(articleLease.getLeasePrice().toString());
            BigDecimal cash = new BigDecimal(articleLease.getLeaseCash().toString());
            BigDecimal paySum = day.multiply(price).add(cash);
            tbAssetArticleLeaseOrders.setPaySum(paySum);
            //订单创建时间
            tbAssetArticleLeaseOrders.setCreateTime(new Date());
            //更改订单租借状态(更改为申请中)
            tbAssetArticleLeaseOrders.setArticleStatus(Byte.parseByte(LeaseStatusEnums.APPLY.getValue()));
            int insert = tbAssetArticleLeaseOrdersMapper.insert(tbAssetArticleLeaseOrders);
            //同时更改租借的资产的状态(更改为申请中)
            Map<String,Object> map = new HashMap<>(16);
            map.put("assetNumber",assetNumber);
            map.put("status",Byte.parseByte(LeaseStatusEnums.APPLY.getValue()));
            assetArticleLeaseDao.updateStatus(map);
            if (insert > 0){
                return ordersNumber;
            }
        }
        return "-1";
    }

    /**
     * 生成订单编号
     * @return
     */
    public static String getOrderIdByTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate = sdf.format(new Date());
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            result += random.nextInt(10);
        }
        return newDate + result;
    }
}
