package com.jn.park.asset.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.park.asset.dao.AssetArticleLeaseDao;
import com.jn.park.asset.dao.TbAssetArticleLeaseMapper;
import com.jn.park.asset.dao.TbAssetArticleLeaseOrdersMapper;
import com.jn.park.asset.dao.TbAssetInformationMapper;
import com.jn.park.asset.entity.*;
import com.jn.park.asset.enums.AssetExceptionEnum;
import com.jn.park.asset.enums.AssetStatusEnums;
import com.jn.park.asset.enums.LeaseStatusEnums;
import com.jn.park.asset.enums.PayStatusEnums;
import com.jn.park.asset.model.AssetArticleLeaseModel;
import com.jn.park.asset.service.AssetArticleLeaseService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
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
    @Autowired
    private UserExtensionClient userExtensionClient;
    @Autowired
    private TbAssetInformationMapper tbAssetInformationMapper;



    /**
     * 通过资产编号获取物品租赁详细信息
     * @param assetNumber
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据资产编号获取物品租赁详细信息")
    public AssetArticleLeaseModel getArticleLease(String assetNumber,String account) {
        AssetArticleLeaseModel assetArticleLeaseModel = assetArticleLeaseDao.getArticleLease(assetNumber);
        //设置租借资料
        UserExtensionInfo userExtension = getUserExtension(account);
        assetArticleLeaseModel.setLeaseEnterprise(userExtension.getCompanyName());
        assetArticleLeaseModel.setContactName(userExtension.getName());
        assetArticleLeaseModel.setContactPhone(userExtension.getPhone());
        //设置条形码
        String barCode = "";
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            barCode += random.nextInt(10);
        }
        assetArticleLeaseModel.setBarCode(barCode);
        return assetArticleLeaseModel;
    }


    @Override
    @ServiceLog(doAction = "企业填写租借资料")
    public String leaseWriter(String assetNumber, String leaseEnterprise, String contactName, String contactPhone, java.sql.Date startTime, String time,User user) {
        TbAssetInformationCriteria tbAssetInformationCriteria = new TbAssetInformationCriteria();
        tbAssetInformationCriteria.createCriteria().andAssetNumberEqualTo(assetNumber);
        List<TbAssetInformation> tbAssetInformations = tbAssetInformationMapper.selectByExample(tbAssetInformationCriteria);
        if (tbAssetInformations.isEmpty()){
            throw new JnSpringCloudException(new Result("-1","资产信息不存在"));
        }
        //资产信息
        TbAssetInformation tbAssetInformation = tbAssetInformations.get(0);
        //获取租借企业id
        UserExtensionInfo userExtension = getUserExtension(user.getAccount());
        tbAssetInformation.setLeaseEnterpriseId(userExtension.getCompanyCode());
        tbAssetInformation.setLeaseEnterpriseName(userExtension.getCompanyName());
        tbAssetInformation.setLeaseContactName(contactName);
        tbAssetInformation.setLeaseContactPhone(contactPhone);
        tbAssetInformation.setLeaseStartTime(startTime);
        //租借申请时间
        tbAssetInformation.setLeaseApplyTime(new Date());
        //计算结束时间
        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);
        cal.add(Calendar.DAY_OF_MONTH,+Integer.parseInt(time));
        Date calTime = cal.getTime();
        java.sql.Date endTime=new java.sql.Date(calTime.getTime());
        tbAssetInformation.setLeaseEndTime(endTime);
        //判断租借时间是否大于最短租期
        int days = (int) ((tbAssetInformation.getLeaseEndTime().getTime() - tbAssetInformation.getLeaseStartTime().getTime()) / (1000*3600*24)+1);
        //最短租借时间
        int leaseTime = Integer.parseInt(tbAssetInformation.getLeaseTime());
        if (leaseTime > days){
            throw new JnSpringCloudException(AssetExceptionEnum.TIME_NOT_AFTER_LEASE_TIME);
        }
        //更新租借企业资料
        tbAssetInformationMapper.updateByPrimaryKeySelective(tbAssetInformation);
        //新增租赁订单
        return addLeaseOrders(tbAssetInformation.getId(),user);
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
     * @param id
     * @param user
     * @return
     */
    private String addLeaseOrders(String id, User user) {
        TbAssetInformation tbAssetInformation = tbAssetInformationMapper.selectByPrimaryKey(id);
        if (tbAssetInformation != null){
            TbAssetArticleLeaseOrders tbAssetArticleLeaseOrders = new TbAssetArticleLeaseOrders();
            //生成订单编号
            String ordersNumber = getOrderIdByTime();
            tbAssetArticleLeaseOrders.setId(ordersNumber);
            tbAssetArticleLeaseOrders.setAssetNumber(tbAssetInformation.getAssetNumber());
            tbAssetArticleLeaseOrders.setArticleId(tbAssetInformation.getId());
            tbAssetArticleLeaseOrders.setArticleName(tbAssetInformation.getAssetName());
            tbAssetArticleLeaseOrders.setTypeId(tbAssetInformation.getTypeId());
            tbAssetArticleLeaseOrders.setAssetType(tbAssetInformation.getAssetType());
            tbAssetArticleLeaseOrders.setSpecification(tbAssetInformation.getSpecification());
            tbAssetArticleLeaseOrders.setArticleUrl(tbAssetInformation.getImgUrl());
            tbAssetArticleLeaseOrders.setArticleIntroduction(tbAssetInformation.getAssetExplain());
            tbAssetArticleLeaseOrders.setLeaseEnterprise(tbAssetInformation.getLeaseEnterpriseName());
            tbAssetArticleLeaseOrders.setContactName(tbAssetInformation.getLeaseContactName());
            tbAssetArticleLeaseOrders.setContactPhone(tbAssetInformation.getLeaseContactPhone());
            tbAssetArticleLeaseOrders.setLeaseCash(tbAssetInformation.getLeaseCash());
            tbAssetArticleLeaseOrders.setLeasePrice(tbAssetInformation.getLeasePrice());
            tbAssetArticleLeaseOrders.setStartTime(tbAssetInformation.getLeaseStartTime());
            tbAssetArticleLeaseOrders.setEndTime(tbAssetInformation.getLeaseEndTime());
            //未付款
            tbAssetArticleLeaseOrders.setPaymentStatus(Byte.parseByte(PayStatusEnums.NONPAYMENT.getCode()));
            //订单创建者
            tbAssetArticleLeaseOrders.setCreatorAccount(user.getAccount());
            tbAssetArticleLeaseOrders.setRecordStatus(Byte.parseByte(AssetStatusEnums.EFFECTIVE.getCode()));
            //计算开始时间和结束时间的相差天数
            int days = (int) ((tbAssetInformation.getLeaseEndTime().getTime() - tbAssetInformation.getLeaseStartTime().getTime()) / (1000*3600*24)+1);
            //计算总共需要付款的金额
            BigDecimal day = new BigDecimal(String.valueOf(days));
            BigDecimal price = new BigDecimal(tbAssetInformation.getLeasePrice().toString());
            BigDecimal cash = new BigDecimal(tbAssetInformation.getLeaseCash().toString());
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


    /**
     * 获取用户企业信息
     * @param account
     * @return
     */
    public UserExtensionInfo getUserExtension(String account){
        //获取当前用户的信息
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(account);
        UserExtensionInfo data = userExtension.getData();
        if (data == null){
            throw new JnSpringCloudException(new Result("-1","获取用户企业信息失败"));
        }
        return data;
    }
}
