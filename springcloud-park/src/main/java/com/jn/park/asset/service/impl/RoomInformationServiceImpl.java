package com.jn.park.asset.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.company.api.CompanyClient;
import com.jn.company.model.ServiceCompany;
import com.jn.park.asset.dao.*;
import com.jn.park.asset.entity.*;
import com.jn.park.asset.enums.*;
import com.jn.park.asset.model.RoomBaseModel;
import com.jn.park.asset.model.RoomInformationModel;
import com.jn.park.asset.model.RoomPayOrdersItemModel;
import com.jn.park.asset.model.RoomPayOrdersModel;
import com.jn.park.asset.service.RoomInformationService;
import com.jn.park.asset.vo.AppPayDataVo;
import com.jn.pay.api.PayOrderClient;
import com.jn.pay.enums.MchIdEnum;
import com.jn.pay.model.*;
import com.jn.pay.model.alipay.AlipayMobilePayRsp;
import com.jn.pay.utils.BeanToMap;
import com.jn.system.log.annotation.ServiceLog;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.xxpay.common.util.PayDigestUtil;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
* 房间信息impl
* @author： zhuyz
* @date： Created on 2019/5/7 19:31
* @version： v1.0
* @modified By:
*/
@Service
public class RoomInformationServiceImpl implements RoomInformationService {
    private static Logger logger = LoggerFactory.getLogger(RoomInformationServiceImpl.class);
    @Autowired
    private RoomInformationDao roomInformationDao;
    @Autowired
    private TbRoomInformationMapper tbRoomInformationMapper;
    @Autowired
    private TbRoomOrdersMapper tbRoomOrdersMapper;
    @Autowired
    private TbRoomGroupMapper tbRoomGroupMapper;
    @Autowired
    private TbRoomOrdersItemMapper tbRoomOrdersItemMapper;
    @Autowired
    private CompanyClient companyClient;
	@Autowired
    private TbRoomOrdersPayMapper tbRoomOrdersPayMapper;
    @Autowired
    private PayOrderClient payOrderClient;

    /**
     * 返回房间信息
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "返回房间信息")
    public RoomInformationModel getRoomInformation(String id) {
        TbRoomInformation tbRoomInformation= tbRoomInformationMapper.selectByPrimaryKey(id);
        RoomInformationModel roomInformationModel=new RoomInformationModel();
        BeanUtils.copyProperties(tbRoomInformation,roomInformationModel);

        //设置同属分组房间
        roomInformationModel.setGroupRoomList(new ArrayList<>());
        List<TbRoomInformation> tbRoomInformationList=this.getRoomGroupId(tbRoomInformation.getGroupId());
        if(null==tbRoomInformationList){
            return roomInformationModel;
        }
        for(TbRoomInformation e:tbRoomInformationList){
            RoomInformationModel target=new RoomInformationModel();
            BeanUtils.copyProperties(e,target);
            roomInformationModel.getGroupRoomList().add(target);
        }
        return roomInformationModel;
    }


    @Override
    @ServiceLog(doAction ="新增房间订单")
    public Result addRoomOrders(String roomId,  String contactName, String contactPhone, Date leaseStartTime, Date leaseEndTime,String userAccount) {

        TbRoomInformation tbRoomInformation= tbRoomInformationMapper.selectByPrimaryKey(roomId);
        //通过用户account查询企业
        Result<ServiceCompany> companyDetailByAccountOrCompanyId = companyClient.getCompanyDetailByAccountOrCompanyId(userAccount);
        ServiceCompany data = companyDetailByAccountOrCompanyId.getData();

        //判断租借时间是否大于最短租期
        this.validShortestLease(leaseStartTime,leaseEndTime,tbRoomInformation);

        //判断租借用户是否是企业用户
        this.checkIsCompanyUser(userAccount);

        //拿到要出租的所有房间
        List<TbRoomInformation> tbRoomInformationList=this.getRoomGroupId(tbRoomInformation.getGroupId());
        if(tbRoomInformationList==null){
            tbRoomInformationList.add(tbRoomInformation);
        }

        //生成订单号
        String orderId=UUID.randomUUID().toString();
        //订单总金额
        BigDecimal orderPaySum=new BigDecimal("0");

        //生成订单明细
        for(TbRoomInformation e:tbRoomInformationList){
            TbRoomOrdersItem item=new TbRoomOrdersItem();
            item.setId(UUID.randomUUID().toString());
            item.setOrderId(orderId);
            item.setRoomId(e.getId());
            item.setRoomName(e.getName());
            item.setFloor(e.getFloor());
            item.setTowerId(e.getTowerId());
            item.setTowerName(e.getTowerName());
            item.setRoomUrl(e.getImgUrl());
            item.setRoomArea(e.getRoomArea());
            item.setLeasePrice(e.getLeasePrice());
            item.setLeaseSum(e.getLeaseSum());
            item.setPressPay(e.getPressPay());
            item.setShortestLease(e.getShortestLease());
            item.setIntroduce(e.getIntroduce());
            item.setPaySum(this.calPrice(e));
            item.setCreatorAccount(userAccount);
            item.setCreateTime(new java.util.Date());
            //加到订单总金额里面
            orderPaySum.add(item.getPaySum());
            logger.info("插入订单明细数据，{}",item);
            tbRoomOrdersItemMapper.insertSelective(item);
        }

        //生成总订单
        TbRoomOrders orders=new TbRoomOrders();
        orders.setId(orderId);
        orders.setPaySum(orderPaySum);

        //未付款
        orders.setPayState(Byte.parseByte(PayStatusEnums.NONPAYMENT.getCode()));
        //是否是续租订单(否)
        orders.setIsRelet(Byte.parseByte(RoomReletStatusEnums.NO.getCode()));
        //有效
        orders.setRecordStatus(Byte.parseByte(AssetStatusEnums.EFFECTIVE.getCode()));
        orders.setEnterpriseId(data.getId());
        orders.setLeaseEnterprise(data.getComName());
        orders.setLeaseStartTime(leaseStartTime);
        orders.setLeaseEndTime(leaseEndTime);
        orders.setContactName(contactName);
        orders.setContactPhone(contactPhone);
        orders.setCreateTime(new java.util.Date());
        orders.setContactName(userAccount);
        logger.info("插入订单主表数据，{}",orders);
        tbRoomOrdersMapper.insert(orders);

        //同时更新房间信息租借状态(更改为租借申请中)
        TbRoomInformation tbRoom = tbRoomInformationMapper.selectByPrimaryKey(roomId);
        tbRoom.setState(Byte.parseByte(RoomLeaseStatusEnums.APPLY.getValue()));
        logger.info("更新房间租借状态,{}",tbRoom);
        tbRoomInformationMapper.updateByPrimaryKey(tbRoom);

        return new Result(orderId);
    }

    @Override
    @ServiceLog(doAction ="获取房间基本信息")
    public RoomBaseModel getRoomBaseInfo(String roomId) {
        TbRoomInformation tbRoomInformation= tbRoomInformationMapper.selectByPrimaryKey(roomId);
        //拿到要出租的所有房间
        List<TbRoomInformation> tbRoomInformationList=this.getRoomGroupId(tbRoomInformation.getGroupId());
        if (tbRoomInformation == null){
            RoomBaseModel BaseModel = new RoomBaseModel();
            BeanUtils.copyProperties(tbRoomInformation,BaseModel);
            return BaseModel;
        }
        List<RoomBaseModel> roomBaseModelList = new ArrayList<>();
        RoomBaseModel roomBaseModel = new RoomBaseModel();
        for (TbRoomInformation roomInformation : tbRoomInformationList) {
            RoomBaseModel roomBase = new RoomBaseModel();
            BeanUtils.copyProperties(roomInformation,roomBase);
            roomBaseModelList.add(roomBase);
        }
        roomBaseModel.setGroupRoomList(roomBaseModelList);
        return roomBaseModel;
    }

    /**
     * 分页返回房间租借列表(可搜索)
     * @param page
     * @param name
     * @return
     */
    @Override
    @ServiceLog(doAction = "分页返回房间租借列表(可搜索)")
    public PaginationData<List<RoomInformationModel>> getRoomLeaseList(Page page, String name) {
        com.github.pagehelper.Page<Object> objects = PageHelper.startPage(page.getPage(), page.getRows());
        List<RoomInformationModel> roomInformationModelList = roomInformationDao.getRoomLeaseList(name);
        PaginationData data = new PaginationData(roomInformationModelList, objects.getTotal());
        return data;
    }

    //校验最短租期
    private void validShortestLease(Date leaseStartTime, Date leaseEndTime,TbRoomInformation tbRoomInformation){
        //判断租借时间是否大于最短租期
        int days = (int) ((leaseEndTime.getTime() - leaseStartTime.getTime()) / (1000*3600*24)+1);
        //最短租借时间
        int leaseTime = Integer.parseInt(tbRoomInformation.getShortestLease());
        if (leaseTime > days) {
            throw new JnSpringCloudException(AssetExceptionEnum.TIME_NOT_AFTER_LEASE_TIME);
        }
    }
    //校验用户是否属于某个企业
    private void checkIsCompanyUser(String account){
        Result<ServiceCompany> companyDetailByAccountOrCompanyId = companyClient.getCompanyDetailByAccountOrCompanyId(account);
        ServiceCompany data = companyDetailByAccountOrCompanyId.getData();
        if (null == data){
            //throw new JnSpringCloudException(new Result("4020502","当前用户不属于企业用户"));
        }
    }

    /**
     * 计算单个房间的总价
     * @param room
     * @return
     */
    private BigDecimal calPrice(TbRoomInformation room){

        //计算付款金额
        //押
        BigDecimal press = new BigDecimal(room.getPress());
        //付
        BigDecimal pay = new BigDecimal(room.getPay());
        //租金
        BigDecimal leaseSum = room.getLeaseSum();
        //付款总金额
        BigDecimal paySum = leaseSum.multiply(press).add(leaseSum.multiply(pay));
        return paySum;
    }

    /**
     * 拿到同属的所有房间
     * @param groupId
     * @return
     */
    private List<TbRoomInformation>getRoomGroupId(String groupId){
        if(StringUtils.isBlank(groupId)){
            return null;
        }
        TbRoomGroup tbRoomGroup=tbRoomGroupMapper.selectByPrimaryKey(groupId);
        if(null!=tbRoomGroup){
            TbRoomInformationCriteria roomInformationCriteria=new TbRoomInformationCriteria();
            List<String>roomIdList=new ArrayList<>();
            String[] roomIdArr=tbRoomGroup.getRoomIds().split(",");
            for(String e:roomIdArr){
                roomIdList.add(e);
            }
            roomInformationCriteria.createCriteria().andIdIn(roomIdList);
            List<TbRoomInformation>  tbRoomInformationList=tbRoomInformationMapper.selectByExample(roomInformationCriteria);
            return tbRoomInformationList;
        }
        return null;
    }

     @ServiceLog(doAction = "创建支付订单")
    public Result<AppPayDataVo> createPayOrder(String orderId, String channelId , String userAccount){
        logger.info("创建支付订单,orderId={}",orderId);
        TbRoomOrders tbRoomOrders=tbRoomOrdersMapper.selectByPrimaryKey(orderId);

        if(null==tbRoomOrders){
            logger.info("订单不存在,orderId={}",orderId);
            return new Result("-1","订单不存在");
        }
        if(!StringUtils.equals(tbRoomOrders.getCreatorAccount(),userAccount)){
            logger.info("非本人的订单，无法支付,orderId={}",orderId);
            return new Result("-1","非本人的订单，无法支付");
        }
        if(tbRoomOrders.getPayState().equals(2)){
            logger.info("订单已支付，无需重复支付,orderId={}",orderId);
            return new Result("-1","订单已支付，无需重复支付");
        }

        PayOrderReq payOrderReq=new PayOrderReq();
        payOrderReq.setMchId(MchIdEnum.MCH_BASE.getCode());
        payOrderReq.setMchOrderNo(tbRoomOrders.getId());
        payOrderReq.setChannelId(channelId);
        payOrderReq.setDevice("APP");
        payOrderReq.setServiceId("springcloud-park");
        payOrderReq.setServiceUrl("/api/order/payCallBack");
        //金额的单位是 分，需要转换下
         payOrderReq.setAmount(tbRoomOrders.getPaySum().multiply(new BigDecimal("100")).longValue());
         payOrderReq.setSubject("房间租赁订单"+tbRoomOrders.getId());
         payOrderReq.setBody(tbRoomOrders.getLeaseEnterprise());

         payOrderReq.setSign(com.jn.pay.utils.PayDigestUtil.getSign(BeanToMap.toMap(payOrderReq),MchIdEnum.MCH_BASE.getReqKey()));

        logger.info("调用 统一支付下单接口,请求参数{}",payOrderReq);
        Result payResult=payOrderClient.createPayOrder(payOrderReq);
        logger.info("调用 统一支付下单接口，返回{}",payResult);
        if(!StringUtils.equals(payResult.getCode(),"0000")){
            logger.info("统一支付下单失败，{}",payOrderReq);
            return payResult;
        }

        if(payResult.getData() instanceof AlipayMobilePayRsp){
            AlipayMobilePayRsp alipayMobilePayRsp=(AlipayMobilePayRsp)payResult.getData();
        }

        PayBaseRsp payBaseRsp=(PayBaseRsp)payResult.getData();
        TbRoomOrdersPay tbRoomOrdersPay=new TbRoomOrdersPay();
        tbRoomOrdersPay.setPayId(payBaseRsp.getPayOrderId());
        tbRoomOrdersPay.setOrderId(orderId);
        tbRoomOrdersPay.setPayState(new Byte("1"));//支付中
        tbRoomOrdersPay.setCreateTime(new java.util.Date());
        tbRoomOrdersPay.setCreatorAccount(userAccount);
        logger.info("插入订单支付表{}",tbRoomOrdersPay);
        tbRoomOrdersPayMapper.insertSelective(tbRoomOrdersPay);


        return  payResult;

    }

    @ServiceLog(doAction = "房间支付回调")
    @Override
    public  Result payCallBack(PayOrderNotify payOrderNotify){
        logger.info("房间支付回调,参数：{}",payOrderNotify);
        //业务订单表的支付状态
        TbRoomOrdersPay tbRoomOrdersPay=tbRoomOrdersPayMapper.selectByPrimaryKey(payOrderNotify.getPayOrderId());
        if(null==tbRoomOrdersPay){
            logger.info("支付订单ID["+payOrderNotify.getPayOrderId()+"]不存在");
            return new Result("-1","支付订单ID["+payOrderNotify.getPayOrderId()+"]不存在");
        }
        if(tbRoomOrdersPay.getPayState().equals(2)){
            logger.info("支付状态已更新过了，无需再回调");
            return new Result("-1","支付状态已更新过了，无需再回调");
        }

        //查询支付订单的支付状态
        PayOrderQueryReq req=new PayOrderQueryReq();
        req.setPayOrderId(payOrderNotify.getPayOrderId());
        logger.info("调用支付查询接口，请求参数:{}",req);
        Result<PayOrderQueryRsp> rep=payOrderClient.payOrderQuery(req);
        logger.info("调用支付查询接口，返回参数:{}",rep);
        if(rep.getData().getStatus().equals(2)){//支付成功
            TbRoomOrdersPay updateRecord=new TbRoomOrdersPay();
            updateRecord.setPayId(payOrderNotify.getPayOrderId());
            updateRecord.setPayState(new Byte("2"));
            updateRecord.setModifiedTime(new java.util.Date());
            logger.info("支付表的支付状态更新为：已支付，参数：{}",updateRecord);
            int updateCount=tbRoomOrdersPayMapper.updateByPrimaryKeySelective(updateRecord);
            if(updateCount!=1){
                throw new JnSpringCloudException(new Result("-1","支付表tb_room_orders_pay更新失败"));
            }

            TbRoomOrders tbRoomOrdersUpdate=new TbRoomOrders();
            tbRoomOrdersUpdate.setId(tbRoomOrdersPay.getOrderId());
            tbRoomOrdersUpdate.setPayState(updateRecord.getPayState());
            tbRoomOrdersUpdate.setModifiedTime(updateRecord.getModifiedTime());
            logger.info("订单表的支付状态更新为：已支付，参数：{}",tbRoomOrdersUpdate);
            updateCount=tbRoomOrdersMapper.updateByPrimaryKeySelective(tbRoomOrdersUpdate);
            if(updateCount!=1){
                throw new JnSpringCloudException(new Result("-1","业务表tb_room_orders更新失败"));
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
     * 返回支付订单
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "返回支付订单")
    public RoomPayOrdersModel getPayOrders(String id) {
        //查询订单表
        TbRoomOrders tbRoomOrders = tbRoomOrdersMapper.selectByPrimaryKey(id);
        RoomPayOrdersModel roomPayOrdersModel = new RoomPayOrdersModel();
        BeanUtils.copyProperties(tbRoomOrders,roomPayOrdersModel);
        //通过订单id查询订单字表
        TbRoomOrdersItemCriteria tbRoomOrdersItemCriteria= new TbRoomOrdersItemCriteria();
        tbRoomOrdersItemCriteria.createCriteria().andOrderIdEqualTo(id);
        List<TbRoomOrdersItem> tbRoomOrdersItemList = tbRoomOrdersItemMapper.selectByExample(tbRoomOrdersItemCriteria);
        //创建子订单List集合
        List<RoomPayOrdersItemModel> roomPayOrdersItemModelList = new ArrayList<>();

        if (tbRoomOrdersItemList != null){
            for (TbRoomOrdersItem tbRoomOrdersItem : tbRoomOrdersItemList) {
                RoomPayOrdersItemModel roomPay = new RoomPayOrdersItemModel();
                BeanUtils.copyProperties(tbRoomOrdersItem,roomPay);
                roomPayOrdersItemModelList.add(roomPay);
            }
            roomPayOrdersModel.setRoomPayOrdersItemModels(roomPayOrdersItemModelList);
        }
        try {
            if (roomPayOrdersModel != null){
                //账单类型
                roomPayOrdersModel.setOrdersType(OrdersTypeEnums.ROOM.getMessage());
                //计算最迟缴费时间
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String createTime = sdf.format(roomPayOrdersModel.getCreateTime());
                roomPayOrdersModel.setTime(createTime);
                Calendar cal = Calendar.getInstance();
                cal.setTime(sdf.parse(createTime));
                cal.add(Calendar.HOUR_OF_DAY,1);
                String lastTime = sdf.format(cal.getTime());
                roomPayOrdersModel.setLastPayTime(lastTime);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return roomPayOrdersModel;
    }

    /**
     * 分页返回房间租借历史列表
     * @param account
     * @param page
     * @return
     */
    @Override
    @ServiceLog(doAction = "分页返回房间租借历史列表")
    public PaginationData<List<RoomPayOrdersModel>> getRoomOrdersList(String account,Page page) {
        List<RoomPayOrdersModel>result=new ArrayList<>();

        TbRoomOrdersCriteria tbRoomOrdersCriteria =new TbRoomOrdersCriteria();
        tbRoomOrdersCriteria.createCriteria().andCreatorAccountEqualTo(account).andRecordStatusEqualTo(new Byte("1"));
        tbRoomOrdersCriteria.setOrderByClause("create_time DESC");
        //开始分页
        com.github.pagehelper.Page<Object> objects = PageHelper.startPage(page.getPage(), page.getRows());
        List<TbRoomOrders>tbRoomOrdersList=tbRoomOrdersMapper.selectByExample(tbRoomOrdersCriteria);
        for(TbRoomOrders e:tbRoomOrdersList){
            RoomPayOrdersModel roomPayOrdersModel=new RoomPayOrdersModel();
            BeanUtils.copyProperties(e,roomPayOrdersModel);
            //创建订单集合
            List<RoomPayOrdersItemModel> roomPayOrdersItemModelList = new ArrayList<>();
            //设置查询条件
            TbRoomOrdersItemCriteria tbRoomOrdersItemCriteria = new TbRoomOrdersItemCriteria();
            //设置用户
            tbRoomOrdersItemCriteria.createCriteria().andOrderIdEqualTo(e.getId());
            //按照创建时间倒序排序
            tbRoomOrdersItemCriteria.setOrderByClause("create_time DESC");
            List<TbRoomOrdersItem> tbRoomOrdersItems = tbRoomOrdersItemMapper.selectByExample(tbRoomOrdersItemCriteria);
            for (TbRoomOrdersItem tbRoomOrdersItem : tbRoomOrdersItems) {
                RoomPayOrdersItemModel roomPayOrdersItemModel = new RoomPayOrdersItemModel();
                BeanUtils.copyProperties(tbRoomOrdersItem,roomPayOrdersItemModel);
                roomPayOrdersItemModelList.add(roomPayOrdersItemModel);
            }
            roomPayOrdersModel.setRoomPayOrdersItemModels(roomPayOrdersItemModelList);
            result.add(roomPayOrdersModel);
        }

        return new PaginationData(result,objects.getTotal());
    }

    /**
     * 获取房间租借详情信息
     * @param orderId
     * @return
     */
    @Override
    @ServiceLog(doAction ="获取房间租借详情信息")
    public RoomPayOrdersModel getRoomOrders(String orderId,String userAccount) {
        RoomPayOrdersModel result=new RoomPayOrdersModel();
        TbRoomOrders tbRoomOrders=tbRoomOrdersMapper.selectByPrimaryKey(orderId);
        if(tbRoomOrders==null||!StringUtils.equals(tbRoomOrders.getCreatorAccount(),userAccount)){
            throw new JnSpringCloudException(new Result("-1","订单不存在"));
        }
        BeanUtils.copyProperties(tbRoomOrders,result);

        TbRoomOrdersItemCriteria criteria=new TbRoomOrdersItemCriteria();
        criteria.createCriteria().andOrderIdEqualTo(orderId);
        List<TbRoomOrdersItem> tbRoomOrdersItemList = tbRoomOrdersItemMapper.selectByExample(criteria);
        result.setRoomPayOrdersItemModels(new ArrayList<>());
        for(TbRoomOrdersItem e:tbRoomOrdersItemList){
            RoomPayOrdersItemModel roomPayOrdersItemModel = new RoomPayOrdersItemModel();
            BeanUtils.copyProperties(e,roomPayOrdersItemModel);
            result.getRoomPayOrdersItemModels().add(roomPayOrdersItemModel);
        }
        return result;
    }

    /**
     * 房间退租申请
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "房间退租申请")
    public RoomPayOrdersItemModel quitApply(String id) {
        //更新订单房间状态
        TbRoomOrdersItem tbRoomOrdersItem = tbRoomOrdersItemMapper.selectByPrimaryKey(id);
        tbRoomOrdersItem.setRecordStatus(Byte.parseByte(RoomLeaseStatusEnums.QUIT.getValue()));
        TbRoomOrdersItemCriteria tbRoomOrdersItemCriteria = new TbRoomOrdersItemCriteria();
        tbRoomOrdersItemCriteria.createCriteria().andIdEqualTo(id);
        logger.info("更新订单房间状态,{}",tbRoomOrdersItem);
        tbRoomOrdersItemMapper.updateByExampleSelective(tbRoomOrdersItem,tbRoomOrdersItemCriteria);
        //更新房间信息房间状态
        TbRoomInformation tbRoomInformation = tbRoomInformationMapper.selectByPrimaryKey(tbRoomOrdersItem.getRoomId());
        tbRoomInformation.setState(Byte.parseByte(RoomLeaseStatusEnums.QUIT.getValue()));
        TbRoomInformationCriteria tbRoomInformationCriteria = new TbRoomInformationCriteria();
        tbRoomInformationCriteria.createCriteria().andIdEqualTo(tbRoomOrdersItem.getRoomId());
        logger.info("更新房间信息房间状态,{}",tbRoomInformation);
        tbRoomInformationMapper.updateByExampleSelective(tbRoomInformation,tbRoomInformationCriteria);
        //返回更新后的房间订单信息
        RoomPayOrdersItemModel roomPayOrdersItemModel = new RoomPayOrdersItemModel();
        BeanUtils.copyProperties(tbRoomOrdersItem,roomPayOrdersItemModel);
        return roomPayOrdersItemModel;
    }
}
