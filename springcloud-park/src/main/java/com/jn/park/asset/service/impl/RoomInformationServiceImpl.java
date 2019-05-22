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
import com.jn.park.asset.model.*;
import com.jn.park.asset.service.RoomInformationService;
import com.jn.pay.api.PayOrderClient;
import com.jn.pay.enums.MchIdEnum;
import com.jn.pay.model.*;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xxpay.common.util.BeanToMap;
import org.xxpay.common.util.PayDigestUtil;
import org.xxpay.common.util.XXPayUtil;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

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
    public Result addRoomOrders(String roomId,  String contactName, String contactPhone, Date leaseStartTime, String month,String userAccount) {

        TbRoomInformation tbRoomInformation= tbRoomInformationMapper.selectByPrimaryKey(roomId);
        //通过用户account查询企业
        //Result<ServiceCompany> companyDetailByAccountOrCompanyId = companyClient.getCompanyDetailByAccountOrCompanyId(userAccount);
        //ServiceCompany data = companyDetailByAccountOrCompanyId.getData();

        //计算结束时间
        Calendar cal = Calendar.getInstance();
        cal.setTime(leaseStartTime);
        cal.add(Calendar.MONTH,+Integer.parseInt(month));
        java.util.Date calTime = cal.getTime();
        java.sql.Date leaseEndTime=new java.sql.Date(calTime.getTime());

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
        BigDecimal orderPaySum=new BigDecimal(0);

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
            orderPaySum = orderPaySum.add(item.getPaySum());
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
        //orders.setEnterpriseId(data.getId());
        //orders.setLeaseEnterprise(data.getComName());
        orders.setLeaseStartTime(leaseStartTime);
        orders.setLeaseEndTime(leaseEndTime);
        orders.setContactName(contactName);
        orders.setContactPhone(contactPhone);
        orders.setCreateTime(new java.util.Date());
        orders.setCreatorAccount(userAccount);
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
    public Result<PayOrderRsp> createPayOrder(String orderId, String channelId , String userAccount){
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
         //订单最晚付款时长(60分钟)
         payOrderReq.setDuration(60);

         //签名
         String sign=PayDigestUtil.getSign(BeanToMap.toMap(payOrderReq),MchIdEnum.MCH_BASE.getReqKey());
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

        TbRoomOrdersPay tbRoomOrdersPay=new TbRoomOrdersPay();
        tbRoomOrdersPay.setPayId(payResult.getData().getPayOrderId());
        tbRoomOrdersPay.setOrderId(orderId);
        tbRoomOrdersPay.setPayState(new Byte("0"));//未付款
        tbRoomOrdersPay.setCreateTime(new java.util.Date());
        tbRoomOrdersPay.setCreatorAccount(userAccount);
        logger.info("支付订单接口返回成功，插入业务订单支付表{}",tbRoomOrdersPay);
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
        if(tbRoomOrdersPay.getPayState().equals(1)){
            logger.info("支付状态已更新过了，无需再回调");
            return new Result("-1","支付状态已更新过了，无需再回调");
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
            TbRoomOrdersPay updateRecord=new TbRoomOrdersPay();
            updateRecord.setPayId(payOrderNotify.getPayOrderId());
            updateRecord.setPayState(new Byte("1"));
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
     * @param orderId
     * @return
     */
    @Override
    @ServiceLog(doAction = "返回支付订单")
    public RoomPayOrdersModel getPayOrders(String orderId) {
        TbRoomOrders tbRoomOrders = tbRoomOrdersMapper.selectByPrimaryKey(orderId);
        RoomPayOrdersModel result = new RoomPayOrdersModel();
        result.setRoomPayOrdersModelList(new ArrayList<>());
        try {
            if (tbRoomOrders != null) {
                //计算最迟缴费时间
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //创建时间
                String createTime = sdf.format(tbRoomOrders.getCreateTime());
                Calendar cal = Calendar.getInstance();
                cal.setTime(sdf.parse(createTime));
                cal.add(Calendar.HOUR_OF_DAY, 1);
                //最后缴费时间
                String lastTime = sdf.format(cal.getTime());
                //转换开始租借时间和结束租借时间
                java.sql.Date leaseStartTime = new java.sql.Date(tbRoomOrders.getLeaseStartTime().getTime());
                java.sql.Date leaseEndTime = new java.sql.Date(tbRoomOrders.getLeaseEndTime().getTime());
                //获取订单集合
                TbRoomOrdersItemCriteria tbRoomOrdersItemCriteria = new TbRoomOrdersItemCriteria();
                tbRoomOrdersItemCriteria.createCriteria().andOrderIdEqualTo(orderId);
                List<TbRoomOrdersItem> tbRoomOrdersItems = tbRoomOrdersItemMapper.selectByExample(tbRoomOrdersItemCriteria);
                if (tbRoomOrders != null) {
                    for (TbRoomOrdersItem tbRoomOrdersItem : tbRoomOrdersItems) {
                        RoomPayOrdersModel roomPayOrdersModel = new RoomPayOrdersModel();
                        roomPayOrdersModel.setId(tbRoomOrders.getId());
                        roomPayOrdersModel.setItemId(tbRoomOrdersItem.getId());
                        roomPayOrdersModel.setTime(createTime);
                        //账单类型
                        roomPayOrdersModel.setOrdersType(OrdersTypeEnums.ROOM.getMessage());
                        //最迟缴费时间
                        roomPayOrdersModel.setLastPayTime(lastTime);
                        //开始租借时间和结束租借时间
                        roomPayOrdersModel.setLeaseStartTime(leaseStartTime);
                        roomPayOrdersModel.setLeaseEndTime(leaseEndTime);
                        roomPayOrdersModel.setPaySum(tbRoomOrders.getPaySum());
                        BeanUtils.copyProperties(tbRoomOrdersItem, roomPayOrdersModel);
                        result.getRoomPayOrdersModelList().add(roomPayOrdersModel);
                    }
                }
                TbRoomOrdersItem model = tbRoomOrdersItems.get(0);
                BeanUtils.copyProperties(model, result);
                result.setId(tbRoomOrders.getId());
                result.setPaySum(tbRoomOrders.getPaySum());
                result.setLastPayTime(lastTime);
                result.setLeaseStartTime(leaseStartTime);
                result.setLeaseEndTime(leaseEndTime);
                result.setTime(createTime);
                result.setItemId(model.getId());
                result.setOrdersType(OrdersTypeEnums.ROOM.getMessage());
            }
            return result;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
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
       /* List<RoomPayOrdersModel>result=new ArrayList<>();

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

        return new PaginationData(result,objects.getTotal());*/
       return null;
    }

    /**
     * 获取房间租借详情信息
     * @param orderId
     * @return
     */
    @Override
    @ServiceLog(doAction ="获取房间租借详情信息")
    public RoomPayOrdersModel getRoomOrders(String orderId,String userAccount) {
       /* RoomPayOrdersModel result=new RoomPayOrdersModel();
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
        return result;*/
       return null;
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

    /**
     * 房间租借历史订单(新)
     * @param account
     * @param page
     * @return
     */
    @Override
    @ServiceLog(doAction = "房间租借历史订单(新)")
    public PaginationData<List<RoomLeaseRecordModel>> getNewRoomOrdersList(String account, Page page) {
        com.github.pagehelper.Page<Object> objects = PageHelper.startPage(page.getPage(), page.getRows());
        //获取创建时间倒叙排序的子订单列表
        List<RoomLeaseRecordModel> roomLeaseRecordModelList = roomInformationDao.getNewRoomOrdersList(account);
        PaginationData<List<RoomLeaseRecordModel>> data = new PaginationData(roomLeaseRecordModelList,objects.getTotal());
        return data;
    }

    /**
     * 房间租借租借详情(新)
     * @param itemId 子订单id
     * @param account
     * @return
     */
    @Override
    @ServiceLog(doAction = "房间租借详情(新)")
    public RoomOrdersModel getNewRoomOrders(String itemId, String account) {
        RoomOrdersModel result = roomInformationDao.getNewRoomOrders(itemId);
        String creatorAccount = result.getCreatorAccount();
        if(result==null||!StringUtils.contains(creatorAccount,account)){
            throw new JnSpringCloudException(new Result("-1","订单不存在"));
        }
        //通过订单id获取所有的子订单
        TbRoomOrdersItemCriteria criteria=new TbRoomOrdersItemCriteria();
        criteria.createCriteria().andOrderIdEqualTo(result.getOrderId());
        List<TbRoomOrdersItem> tbRoomOrdersItemList = tbRoomOrdersItemMapper.selectByExample(criteria);
        result.setRoomOrdersModelsList(new ArrayList<>());
        for (TbRoomOrdersItem tbRoomOrdersItem : tbRoomOrdersItemList) {
            RoomOrdersModel orders = roomInformationDao.getNewRoomOrders(tbRoomOrdersItem.getId());
            result.getRoomOrdersModelsList().add(orders);
        }
        return result;
    }

    /**
     * 取消订单
     * @param orderId
     */
    @Override
    @ServiceLog(doAction = "取消订单")
    public void cancelOrder(String orderId) {
        //更新总订单支付状态(更新为已取消)
        TbRoomOrders tbRoomOrders = tbRoomOrdersMapper.selectByPrimaryKey(orderId);
        if (tbRoomOrders == null){
            throw new JnSpringCloudException(new Result("-1","订单不存在"));
        }
        tbRoomOrders.setPayState(Byte.parseByte(PayStatusEnums.CANCEL.getCode()));
        TbRoomOrdersCriteria tbRoomOrdersCriteria = new TbRoomOrdersCriteria();
        tbRoomOrdersCriteria.createCriteria().andIdEqualTo(orderId);
        tbRoomOrdersMapper.updateByExampleSelective(tbRoomOrders,tbRoomOrdersCriteria);
        logger.info("更新总订单支付状态,{}",tbRoomOrders);
        //更新房间订单(支付中心关系表)存在则更新为已取消
        TbRoomOrdersPayCriteria tbRoomOrdersPayCriteria = new TbRoomOrdersPayCriteria();
        TbRoomOrdersPayCriteria.Criteria criteria = tbRoomOrdersPayCriteria.createCriteria();
        criteria.andOrderIdEqualTo(tbRoomOrders.getId());
        List<TbRoomOrdersPay> tbRoomOrdersPays = tbRoomOrdersPayMapper.selectByExample(tbRoomOrdersPayCriteria);
        if (tbRoomOrdersPays != null){
            for (TbRoomOrdersPay tbRoomOrdersPay : tbRoomOrdersPays) {
                tbRoomOrdersPay.setPayState(Byte.parseByte(PayStatusEnums.CANCEL.getCode()));
                tbRoomOrdersPayMapper.updateByExampleSelective(tbRoomOrdersPay,tbRoomOrdersPayCriteria);
                logger.info("更新房间订单(支付中心关系表),{}",tbRoomOrdersPay);
            }
        }
        //更新房间租借状态(更新为空闲)
        TbRoomOrdersItemCriteria tbRoomOrdersItemCriteria = new TbRoomOrdersItemCriteria();
        tbRoomOrdersItemCriteria.createCriteria().andOrderIdEqualTo(orderId);
        List<TbRoomOrdersItem> tbRoomOrdersItems = tbRoomOrdersItemMapper.selectByExample(tbRoomOrdersItemCriteria);
        if (tbRoomOrdersItems != null){
            for (TbRoomOrdersItem tbRoomOrdersItem : tbRoomOrdersItems) {
                TbRoomInformation tbRoomInformation = tbRoomInformationMapper.selectByPrimaryKey(tbRoomOrdersItem.getRoomId());
                tbRoomInformation.setRecordStatus(Byte.parseByte(RoomLeaseStatusEnums.UNUSED.getValue()));
                TbRoomInformationCriteria tbRoomInformationCriteria = new TbRoomInformationCriteria();
                tbRoomInformationCriteria.createCriteria().andIdEqualTo(tbRoomOrdersItem.getRoomId());
                tbRoomInformationMapper.updateByExampleSelective(tbRoomInformation,tbRoomInformationCriteria);
                logger.info("更新房间租借状态,{}",tbRoomInformation);
            }
        }
    }

}
