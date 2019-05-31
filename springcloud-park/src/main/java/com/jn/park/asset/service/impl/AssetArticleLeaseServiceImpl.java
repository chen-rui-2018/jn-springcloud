package com.jn.park.asset.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.park.asset.dao.AssetArticleLeaseDao;
import com.jn.park.asset.dao.TbAssetArticleLeaseMapper;
import com.jn.park.asset.dao.TbAssetArticleLeaseOrdersMapper;
import com.jn.park.asset.entity.TbAssetArticleLease;
import com.jn.park.asset.entity.TbAssetArticleLeaseCriteria;
import com.jn.park.asset.entity.TbAssetArticleLeaseOrders;
import com.jn.park.asset.enums.AssetExceptionEnum;
import com.jn.park.asset.enums.AssetStatusEnums;
import com.jn.park.asset.enums.LeaseStatusEnums;
import com.jn.park.asset.enums.PayStatusEnums;
import com.jn.park.asset.model.AssetArticleLeaseModel;
import com.jn.park.asset.service.AssetArticleLeaseService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.apache.poi.ss.formula.functions.T;
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
     * 通过资产编号获取物品租赁详细信息
     * @param assetNumber
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据资产编号获取物品租赁详细信息")
    public AssetArticleLeaseModel getArticleLease(String assetNumber) {
        AssetArticleLeaseModel assetArticleLeaseModel = assetArticleLeaseDao.getArticleLease(assetNumber);
        assetArticleLeaseModel.setBarCode(assetArticleLeaseModel.getAssetNumber());
        return assetArticleLeaseModel;
    }


    @Override
    @ServiceLog(doAction = "企业填写租借资料")
    public String leaseWriter(String assetNumber, String leaseEnterprise, String contactName, String contactPhone, java.sql.Date startTime, String time,User user) {
        //填写租借企业资料
        AssetArticleLeaseModel articleLease = assetArticleLeaseDao.getArticleLease(assetNumber);
        articleLease.setLeaseEnterprise(leaseEnterprise);
        articleLease.setContactName(contactName);
        articleLease.setContactPhone(contactPhone);
        articleLease.setStartTime(startTime);
        //计算结束时间
        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);
        cal.add(Calendar.DAY_OF_MONTH,+Integer.parseInt(time));
        Date calTime = cal.getTime();
        java.sql.Date endTime=new java.sql.Date(calTime.getTime());
        articleLease.setEndTime(endTime);
        //判断租借时间是否大于最短租期
        int days = (int) ((articleLease.getEndTime().getTime() - articleLease.getStartTime().getTime()) / (1000*3600*24)+1);
        //最短租借时间
        int leaseTime = Integer.parseInt(articleLease.getLeaseTime());
        if (leaseTime > days){
            throw new JnSpringCloudException(AssetExceptionEnum.TIME_NOT_AFTER_LEASE_TIME);
        }
        TbAssetArticleLease tbAssetArticleLease = new TbAssetArticleLease();
        BeanUtils.copyProperties(articleLease,tbAssetArticleLease);
        tbAssetArticleLease.setApplyTime(new Date());
        TbAssetArticleLeaseCriteria example  = new TbAssetArticleLeaseCriteria();
        example.createCriteria().andAssetNumberEqualTo(tbAssetArticleLease.getAssetNumber());
        //更新租借企业资料
        tbAssetArticleLeaseMapper.updateByExampleSelective(tbAssetArticleLease, example);
        //新增租赁订单
        return addLeaseOrders(assetNumber,user);
    }

    /**
     * 分页返回可租借的资产列表(可搜索)
     * @param page
     * @param name
     * @return
     */
    @Override
    @ServiceLog(doAction = "通过物品名称搜索物品")
    public PaginationData<List<AssetArticleLeaseModel>> getArticleLeaseList(Page page, String name) {
        com.github.pagehelper.Page<Object> objects = PageHelper.startPage(page.getPage(), page.getRows());
        List<AssetArticleLeaseModel> assetArticleLeaseModelList = assetArticleLeaseDao.getArticleLeaseList(name);
        for (AssetArticleLeaseModel assetArticleLeaseModel : assetArticleLeaseModelList) {
            assetArticleLeaseModel.setBarCode(assetArticleLeaseModel.getAssetNumber());
        }
        PaginationData<List<AssetArticleLeaseModel>> data = new PaginationData(assetArticleLeaseModelList,objects.getTotal());
        return data;
    }

    /**
     * 新增租赁订单
     * @param assetNumber
     * @param user
     * @return
     */
    private String addLeaseOrders(String assetNumber, User user) {
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
            //未付款
            tbAssetArticleLeaseOrders.setPaymentStatus(Byte.parseByte(PayStatusEnums.NONPAYMENT.getCode()));
            //订单创建者
            tbAssetArticleLeaseOrders.setCreatorAccount(user.getAccount());
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
            int insert = tbAssetArticleLeaseOrdersMapper.insert(tbAssetArticleLeaseOrders);
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
