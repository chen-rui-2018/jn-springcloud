package com.jn.park.asset.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.StringUtils;
import com.jn.company.api.CompanyClient;
import com.jn.company.model.ServiceCompany;
import com.jn.park.asset.dao.*;
import com.jn.park.asset.entity.*;
import com.jn.park.asset.enums.*;
import com.jn.park.asset.model.*;
import com.jn.park.asset.service.RoomInformationService;
import com.jn.park.electricmeter.enums.MeterConstants;
import com.jn.park.property.model.PayCallBackNotify;
import com.jn.pay.api.PayClient;
import com.jn.pay.api.PayOrderClient;
import com.jn.pay.enums.MchIdEnum;
import com.jn.pay.model.*;
import com.jn.pay.vo.PayBillCreateParamVo;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import org.apache.poi.ss.formula.functions.T;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
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
    @Autowired
    private TbRoomOrdersBillMapper tbRoomOrdersBillMapper;
    @Autowired
    private UserExtensionClient userExtensionClient;
    @Autowired
    private PayClient payClient;

    /**
     * 返回房间信息
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "返回房间信息")
    public RoomInformationModel getRoomInformation(String id,String account) {
        //获取当前用户的信息
        UserExtensionInfo data = getUserExtension(account);
        TbRoomInformation tbRoomInformation= tbRoomInformationMapper.selectByPrimaryKey(id);
        RoomInformationModel roomInformationModel=new RoomInformationModel();
        BeanUtils.copyProperties(tbRoomInformation,roomInformationModel);
        //设置租借企业人资料
        roomInformationModel.setLeaseEnterprise(data.getCompanyName());
        roomInformationModel.setContactName(data.getName());
        roomInformationModel.setContactPhone(data.getPhone());
        //设置图片集合
        List<String> imgUrlList = getImgUrlList(roomInformationModel.getImgUrl());
        //添加户型图
        imgUrlList.add(roomInformationModel.getRoomPlan());
        //添加流程平面图
        imgUrlList.add(roomInformationModel.getFloorPlan());
        roomInformationModel.setImage(imgUrlList);
        //设置同属分组房间
        roomInformationModel.setGroupRoomList(new ArrayList<>());
        List<TbRoomInformation> tbRoomInformationList=this.getRoomGroupId(tbRoomInformation.getGroupId());
        if(null==tbRoomInformationList){
            return roomInformationModel;
        }
        List<RoomInformationModel> roomInformationModelList = new ArrayList<>();
        for(TbRoomInformation e:tbRoomInformationList){
            RoomInformationModel target=new RoomInformationModel();
            BeanUtils.copyProperties(e,target);
            //设置图片集合
            List<String> imgList = getImgUrlList(target.getImgUrl());
            //添加户型图
            imgList.add(roomInformationModel.getRoomPlan());
            //添加流程平面图
            imgList.add(roomInformationModel.getFloorPlan());
            target.setImage(imgUrlList);
            //设置租借企业人资料
            target.setLeaseEnterprise(data.getCompanyName());
            target.setContactName(data.getName());
            target.setContactPhone(data.getPhone());
            roomInformationModelList.add(target);
        }
        roomInformationModel.setGroupRoomList(roomInformationModelList);
        return roomInformationModel;
    }


    @Override
    @ServiceLog(doAction ="新增房间订单")
    public Result addRoomOrders(String roomId,  String contactName, String contactPhone, Date leaseStartTime, String month,String userAccount) {

        TbRoomInformation tbRoomInformation= tbRoomInformationMapper.selectByPrimaryKey(roomId);
        //通过用户account查询企业
        Result<ServiceCompany> companyDetailByAccountOrCompanyId = companyClient.getCompanyDetailByAccountOrCompanyId(userAccount);
        ServiceCompany data = companyDetailByAccountOrCompanyId.getData();

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
        orders.setEnterpriseId(data.getId());
        orders.setLeaseEnterprise(data.getComName());
        orders.setLeaseStartTime(leaseStartTime);
        orders.setLeaseEndTime(leaseEndTime);
        orders.setContactName(contactName);
        orders.setContactPhone(contactPhone);
        orders.setCreateTime(new java.util.Date());
        orders.setCreatorAccount(userAccount);
        logger.info("插入订单主表数据，{}",orders);
        tbRoomOrdersMapper.insert(orders);

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
            throw new JnSpringCloudException(new Result("4020502","当前用户不属于企业用户"));
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

     @Override
     @ServiceLog(doAction = "创建支付订单")
    public Result<PayOrderRsp> createPayOrder(String orderId, String channelId , BigDecimal paySum, String userAccount){
        logger.info("创建支付订单,orderId={}",orderId);
        TbRoomOrders tbRoomOrders=tbRoomOrdersMapper.selectByPrimaryKey(orderId);
         if(null==tbRoomOrders){
             logger.info("订单不存在,orderId={}",orderId);
             return new Result("-1","订单不存在");
         }
         BigDecimal ordersPaySum = tbRoomOrders.getPaySum();
         int count = paySum.compareTo(ordersPaySum);
         if (!StringUtils.equals(String.valueOf(count),String.valueOf(0))){
            logger.info("支付金额与订单支付金额不一致,无法支付,传入金额:paySum={},订单金额:orderPaySum={}",paySum,ordersPaySum);
            return new Result("-1","支付金额不一致,支付失败");
        }
        if(!StringUtils.equals(tbRoomOrders.getCreatorAccount(),userAccount)){
            logger.info("非本人的订单，无法支付,orderId={}",orderId);
            return new Result("-1","非本人的订单，无法支付");
        }
        if(StringUtils.equals(tbRoomOrders.getPayState().toString(),PayStatusEnums.PAYMENT.getCode())){
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
         //订单最晚付款时长(30分钟)
         payOrderReq.setDuration(30);

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
            //(新)通过子订单找到对应房间,更新房间状态
            TbRoomOrdersItemCriteria tbRoomOrdersItemCriteria = new TbRoomOrdersItemCriteria();
            tbRoomOrdersItemCriteria.createCriteria().andOrderIdEqualTo(tbRoomOrdersUpdate.getId());
            List<TbRoomOrdersItem> tbRoomOrdersItemList = tbRoomOrdersItemMapper.selectByExample(tbRoomOrdersItemCriteria);
            if (tbRoomOrdersItemList != null && tbRoomOrdersItemList.size() > 0){
                for (TbRoomOrdersItem roomOrdersItem : tbRoomOrdersItemList) {
                    //更新子订单房间状态(租借申请中)
                    roomOrdersItem.setRoomStatus(Byte.parseByte(RoomLeaseStatusEnums.APPLY.getValue()));
                    logger.info("更新子订单房间租借状态: 租借申请中,{}",roomOrdersItem);
                     updateCount = tbRoomOrdersItemMapper.updateByPrimaryKeySelective(roomOrdersItem);
                    if(updateCount!=1){
                        throw new JnSpringCloudException(new Result("-1","房间信息表tb_room_orders_item更新失败"));
                    }
                    //更新房间信息房间状态
                    TbRoomInformation roomInformation = tbRoomInformationMapper.selectByPrimaryKey(roomOrdersItem.getRoomId());
                    roomInformation.setRecordStatus(Byte.parseByte(RoomLeaseStatusEnums.APPLY.getValue()));
                    logger.info("更新房间租借状态: 租借申请中,{}",roomInformation);
                    updateCount = tbRoomInformationMapper.updateByPrimaryKeySelective(roomInformation);
                    if(updateCount!=1){
                        throw new JnSpringCloudException(new Result("-1","房间信息表tb_room_information更新失败"));
                    }
                }
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
                cal.add(Calendar.MINUTE, 30);
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
                        roomPayOrdersModel.setName(roomPayOrdersModel.getRoomName());
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
     * @param orderItemId
     * @return
     */
    @Override
    @ServiceLog(doAction = "房间退租申请")
    public RoomPayOrdersItemModel quitApply(String orderItemId) {
        //更新订单房间状态
        TbRoomOrdersItem tbRoomOrdersItem = tbRoomOrdersItemMapper.selectByPrimaryKey(orderItemId);
        tbRoomOrdersItem.setRecordStatus(Byte.parseByte(RoomLeaseStatusEnums.QUIT.getValue()));
        TbRoomOrdersItemCriteria tbRoomOrdersItemCriteria = new TbRoomOrdersItemCriteria();
        tbRoomOrdersItemCriteria.createCriteria().andIdEqualTo(orderItemId);
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

        //设置图片
        List<String> urlList = getImgUrlList(result.getImgUrl());
        //设置流程图
        urlList.add(result.getFloorPlan());
        //设置房间平面图
        urlList.add(result.getRoomPlan());
        result.setImage(urlList);
        //通过订单id获取所有的子订单
        TbRoomOrdersItemCriteria criteria=new TbRoomOrdersItemCriteria();
        criteria.createCriteria().andOrderIdEqualTo(result.getOrderId());
        List<TbRoomOrdersItem> tbRoomOrdersItemList = tbRoomOrdersItemMapper.selectByExample(criteria);
        result.setRoomOrdersModelsList(new ArrayList<>());
        List<RoomOrdersModel> ordersModelList  = new ArrayList<>();
        for (TbRoomOrdersItem tbRoomOrdersItem : tbRoomOrdersItemList) {
            RoomOrdersModel orders = roomInformationDao.getNewRoomOrders(tbRoomOrdersItem.getId());
            //设置图片
            List<String> imgUrlList = getImgUrlList(orders.getImgUrl());
            //设置流程图
            imgUrlList.add(orders.getFloorPlan());
            //设置房间平面图
            imgUrlList.add(orders.getRoomPlan());
            //设置图片集合
            orders.setImage(imgUrlList);
            ordersModelList.add(orders);
            result.setRoomOrdersModelsList(ordersModelList);
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
      /*  //更新总订单支付状态(更新为已取消)
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
                tbRoomOrdersPayMapper.updateByPrimaryKeySelective(tbRoomOrdersPay);
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
                tbRoomInformationMapper.updateByPrimaryKeySelective(tbRoomInformation);
                logger.info("更新房间租借状态,{}",tbRoomInformation);
            }
        }*/
    }

    /**
     * 定时任务,是否支付,未支付取消订单
     */
    @Override
    @ServiceLog(doAction = "定时任务,是否支付,未支付取消订单")
    public void updateRoomPayStatus() {
        /*TbRoomOrdersCriteria tbRoomOrdersCriteria = new TbRoomOrdersCriteria();
        //计算当前时间之前的半小时
        java.util.Date date = new java.util.Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE,-30);
        java.util.Date time = cal.getTime();
        //支付订单创建时间大于等于当前时间减去半小时,支付状态为(0未付款),并且有效的订单
        tbRoomOrdersCriteria.createCriteria().andCreateTimeGreaterThanOrEqualTo(time).andPayStateEqualTo(Byte.parseByte(PayStatusEnums.NONPAYMENT.getCode())).andRecordStatusEqualTo(Byte.parseByte(AssetStatusEnums.EFFECTIVE.getCode()));
        List<TbRoomOrders> tbRoomOrdersList = tbRoomOrdersMapper.selectByExample(tbRoomOrdersCriteria);
        if (tbRoomOrdersList != null && tbRoomOrdersList.size() > 0){
            for (TbRoomOrders tbRoomOrders : tbRoomOrdersList) {
                //更改订单支付状态(更改为订单已取消)
                tbRoomOrders.setPayState(Byte.parseByte(PayStatusEnums.CANCEL.getCode()));
                logger.info("订单表的支付状态更新为:订单已取消,参数:{}",tbRoomOrders);
                int updateCount = tbRoomOrdersMapper.updateByPrimaryKeySelective(tbRoomOrders);
                if (updateCount != 1){
                    throw new JnSpringCloudException(new Result("-1","更新订单表tb_room_orders失败"));
                }
                //更改房间订单支付中心关系表支付状态(更改为订单已取消)
                TbRoomOrdersPayCriteria tbRoomOrdersPayCriteria = new TbRoomOrdersPayCriteria();
                tbRoomOrdersPayCriteria.createCriteria().andOrderIdEqualTo(tbRoomOrders.getId());
                List<TbRoomOrdersPay> tbRoomOrdersPayList = tbRoomOrdersPayMapper.selectByExample(tbRoomOrdersPayCriteria);
                if (tbRoomOrdersPayList != null && tbRoomOrdersPayList.size() > 0){
                    for (TbRoomOrdersPay tbRoomOrdersPay : tbRoomOrdersPayList) {
                        tbRoomOrdersPay.setPayState(Byte.parseByte(PayStatusEnums.CANCEL.getCode()));
                        logger.info("支付中心关系表的支付状态更新为:订单已取消,参数:{}",tbRoomOrdersPay);
                        int payUpdateCount = tbRoomOrdersPayMapper.updateByPrimaryKeySelective(tbRoomOrdersPay);
                        if (payUpdateCount != 1){
                            throw new JnSpringCloudException(new Result("-1","更新订单表tb_room_orders失败"));
                        }
                    }
                }
                //通过子订单查询相对应的房间,更新房间租借状态
                TbRoomOrdersItemCriteria tbRoomOrdersItemCriteria = new TbRoomOrdersItemCriteria();
                tbRoomOrdersItemCriteria.createCriteria().andOrderIdEqualTo(tbRoomOrders.getId());
                List<TbRoomOrdersItem> tbRoomOrdersItemList = tbRoomOrdersItemMapper.selectByExample(tbRoomOrdersItemCriteria);
                if(tbRoomOrdersItemList != null && tbRoomOrdersItemList.size() > 0){
                    for (TbRoomOrdersItem tbRoomOrdersItem : tbRoomOrdersItemList) {
                        TbRoomInformation tbRoomInformation = tbRoomInformationMapper.selectByPrimaryKey(tbRoomOrdersItem.getRoomId());
                        tbRoomInformation.setState(Byte.parseByte(RoomLeaseStatusEnums.UNUSED.getValue()));
                        logger.info(",更新房间租借状态:空闲,参数:{}",tbRoomInformation);
                        int roomUpdateCount = tbRoomInformationMapper.updateByPrimaryKeySelective(tbRoomInformation);
                        if (roomUpdateCount != 1){
                            throw new JnSpringCloudException(new Result("-1","更新房间信息表tb_room_information失败"));
                        }
                    }
                }

            }
        }*/
    }

    /**
     * 生成房间缴费单
     */
    @Override
    @ServiceLog(doAction = "生成房间缴费单")
    public void createOrderBill() {
        TbRoomOrdersCriteria tbRoomOrdersCriteria = new TbRoomOrdersCriteria();
        java.util.Date date = new java.util.Date();

        //已支付的订单,并且在租借有效期内的订单
        tbRoomOrdersCriteria.createCriteria().andPayStateEqualTo(Byte.parseByte(PayStatusEnums.PAYMENT.getCode())).andLeaseEndTimeGreaterThanOrEqualTo(date).andLeaseStartTimeLessThanOrEqualTo(date);
        //获取订单集合
        List<TbRoomOrders> tbRoomOrdersList = tbRoomOrdersMapper.selectByExample(tbRoomOrdersCriteria);
        if (tbRoomOrdersList != null){
            for (TbRoomOrders tbR : tbRoomOrdersList) {
                TbRoomOrdersBill tbRoomOrdersBill = new TbRoomOrdersBill();
                tbRoomOrdersBill.setId(UUID.randomUUID().toString());
                //订单id
                tbRoomOrdersBill.setOrderId(tbR.getId());
                //缴费企业
                tbRoomOrdersBill.setLeaseEnterprise(tbR.getLeaseEnterprise());
                //企业联系人
                tbRoomOrdersBill.setContactName(tbR.getContactName());
                tbRoomOrdersBill.setContactPhone(tbR.getContactPhone());
                //账单生成时间
                tbRoomOrdersBill.setBillCreateTime(date);
                //账单初始金额
                tbRoomOrdersBill.setBillInitSum(tbR.getPaySum());
                //缴费单生成状态(默认未生成)
                tbRoomOrdersBill.setBillStatus(Byte.parseByte("0"));
                //缴费单金额
                BigDecimal billSum = new BigDecimal(0);
                //开始时间
                tbRoomOrdersBill.setStartTime(tbR.getLeaseStartTime());
                //结束时间
                tbRoomOrdersBill.setEndTime(tbR.getLeaseEndTime());

                //计算相差月份
                Calendar leaseStartTime = Calendar.getInstance();
                leaseStartTime.setTime(tbR.getLeaseStartTime());
                Calendar leaseEndTime = Calendar.getInstance();
                leaseEndTime.setTime(tbR.getLeaseEndTime());
               int year = (leaseEndTime.get(Calendar.YEAR)) - (leaseStartTime.get(Calendar.YEAR)) * 12 ;
               int month = (leaseEndTime.get(Calendar.YEAR)) - (leaseStartTime.get(Calendar.YEAR)) + year;


                //缴费状态(默认未缴费)
                tbRoomOrdersBill.setPaySum(Byte.parseByte("0"));

                //账单周期(待定)
                // TODO

                TbRoomOrdersItemCriteria tbRoomOrdersItemCriteria = new TbRoomOrdersItemCriteria();
                //通过总订单id获取子订单,房间状态为租借中,并且租赁申请成功的
                tbRoomOrdersItemCriteria.createCriteria().andOrderIdEqualTo(tbR.getId()).andLeaseApplyStatusEqualTo(Byte.parseByte(RoomApplyStatusEnums.SUCCEED.getCode())).andRoomStatusEqualTo(Byte.parseByte(RoomLeaseStatusEnums.DELIVERY.getValue()));
                //获取子订单集合
                List<TbRoomOrdersItem> tbRoomOrdersItemList = tbRoomOrdersItemMapper.selectByExample(tbRoomOrdersItemCriteria);
                //账单详情实体类集合
                List<PayBillDetails> payBillDetailsList = new ArrayList<>();
                if (tbRoomOrdersItemList != null){
                    String rooms = "";
                    for (TbRoomOrdersItem roomOrdersItem : tbRoomOrdersItemList) {
                        String roomName = roomOrdersItem.getRoomName();
                        rooms += roomName + ",";
                        //房间
                        tbRoomOrdersBill.setRooms(rooms.substring(0,rooms.length()-1));
                        //获取房间
                        TbRoomInformation tbRoomInformation = tbRoomInformationMapper.selectByPrimaryKey(roomOrdersItem.getRoomId());
                        Integer pay = tbRoomInformation.getPay();
                        billSum.add(roomOrdersItem.getLeaseSum().multiply(new BigDecimal(pay)));
                    }
                    //缴费单金额
                    tbRoomOrdersBill.setBillSum(billSum);
                }
                logger.info("创建房间缴费单:参数{}",tbRoomOrdersBill);
                int insert = tbRoomOrdersBillMapper.insert(tbRoomOrdersBill);
                if (insert != 1){
                    throw new JnSpringCloudException(new Result("-1","房间缴费单创建失败,插入tb_room_orders_bill表失败"));
                }

            }

        }
    }


    /**
     *创建缴费单
     * @param jsonParam
     * @return
     */
    @Override
    @ServiceLog(doAction = "调用生成缴费单接口")
    public Result createBill(String jsonParam){
        String[] split = jsonParam.split(",");
        for (String ordersBillId : split) {
            TbRoomOrdersBill tbRoomOrdersBill = tbRoomOrdersBillMapper.selectByPrimaryKey(ordersBillId);
            if (tbRoomOrdersBill == null){
                throw new JnSpringCloudException(new Result("-1","缴费单不存在"));
            }
            TbRoomOrders tbR = tbRoomOrdersMapper.selectByPrimaryKey(tbRoomOrdersBill.getOrderId());
            if(tbR == null){
                throw new JnSpringCloudException(new Result("-1","订单不存在"));
            }
            TbRoomOrdersItemCriteria roomOrdersItemCriteria = new TbRoomOrdersItemCriteria();
            //通过总订单id获取子订单,房间状态为租借中,并且租赁申请成功的
            TbRoomOrdersItemCriteria.Criteria criteria = roomOrdersItemCriteria.createCriteria();
            criteria.andOrderIdEqualTo(tbR.getId()).andLeaseApplyStatusEqualTo(Byte.parseByte(RoomApplyStatusEnums.SUCCEED.getCode())).andRoomStatusEqualTo(Byte.parseByte(RoomLeaseStatusEnums.DELIVERY.getValue()));
            List<TbRoomOrdersItem> tbRoomOrdersItemList = tbRoomOrdersItemMapper.selectByExample(roomOrdersItemCriteria);
            //账单详情实体类集合
            List<PayBillDetails> payBillDetailsList = new ArrayList<>();
            int i = 0;
            if (tbRoomOrdersItemList != null){
                for (TbRoomOrdersItem roomOrdersItem : tbRoomOrdersItemList) {
                    //获取房间 押金月数
                    TbRoomInformation tbRoomInformation = tbRoomInformationMapper.selectByPrimaryKey(roomOrdersItem.getRoomId());
                    Integer pay = tbRoomInformation.getPay();
                    //设置账单详情实体类
                    PayBillDetails payBillDetails = new PayBillDetails();
                    payBillDetails.setCostName(roomOrdersItem.getRoomName());
                    payBillDetails.setCostValue(roomOrdersItem.getLeaseSum().multiply(new BigDecimal(pay)).toString());
                    payBillDetails.setSort(i++);
                    payBillDetailsList.add(payBillDetails);
                }
            }
            logger.info("开始调用接口创建缴费账单");
            PayBillCreateParamVo payBillCreateParamVo = new PayBillCreateParamVo();
            payBillCreateParamVo.setBillId(tbRoomOrdersBill.getId());
            //账单名称
            payBillCreateParamVo.setBillName(tbR.getLeaseEnterprise()+"房租账单");
            //账单来源
            payBillCreateParamVo.setBillSource("房间缴费");
            //账单费用
            payBillCreateParamVo.setBillExpense(tbRoomOrdersBill.getBillSum());
            //对象类型【1：企业，2：个人】
            payBillCreateParamVo.setObjType("1");
            //对象Id（传企业ID或用户ID）
            payBillCreateParamVo.setObjId("wangsong");
            //对象名称（传企业名称或用户名称）
            payBillCreateParamVo.setObjName(tbR.getLeaseEnterprise());
            //账本类型ID【1：电费，2：物业费】
            payBillCreateParamVo.setAcBookType("ROOM_LEASE");
            //回调ID
            payBillCreateParamVo.setCallbackId("springcloud-park");
            //回调URL
            payBillCreateParamVo.setCallbackUrl("/api/order/updateBill");
            //创建时间
            payBillCreateParamVo.setCreatedTime(new java.util.Date());
            //创建人
            payBillCreateParamVo.setCreatorAccount(tbR.getCreatorAccount());

            //设置账单最迟支付时间为创建长单后，一周内
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+7);
            java.util.Date latePaymentDate=calendar.getTime();

            //最迟缴费时间
            payBillCreateParamVo.setLatePayment(latePaymentDate);
            //缴费详情【存list对象集合】
            payBillCreateParamVo.setPayBillDetails(payBillDetailsList);
            Result billCreateResult = payClient.billCreate(payBillCreateParamVo);
            logger.info("结束调用接口创建账单");
            if(StringUtils.equals(billCreateResult.getCode(),GlobalConstants.SUCCESS_CODE)){
                tbRoomOrdersBill.setBillStatus(Byte.parseByte("1"));
                logger.info("更新账单生成状态为:已生成,参数{}",tbRoomOrdersBill);
                int updateCount = tbRoomOrdersBillMapper.updateByPrimaryKeySelective(tbRoomOrdersBill);
                if (updateCount != 1){
                    throw new JnSpringCloudException(new Result("-1","更新tb_room_orders_bill状态失败"));
                }
            }else {
                throw new JnSpringCloudException(new Result("-1","创建缴费单失败"));
            }
        }
        logger.info("生成缴费单成功");
        return new Result("0000","生成缴费单成功");
    }

    @Override
    @ServiceLog(doAction = "缴费单回调")
    public Result updateBill(PayCallBackNotify payCallBackNotify) {
        logger.info("开始缴费单回调");
        String billId=payCallBackNotify.getBillId();
        PayBill payBill =payClient.getBillBasicInfo(billId);
        //账单支付成功
        if (payBill.getPaymentState().equals(PayStatusEnums.PAYMENT.getCode())){
            TbRoomOrdersBill tbRoomOrdersBill = tbRoomOrdersBillMapper.selectByPrimaryKey(payBill.getBillId());
            tbRoomOrdersBill.setPaySum(Byte.parseByte(PayStatusEnums.PAYMENT.getCode()));
            tbRoomOrdersBill.setPayTime(payBill.getCreatedTime());
            logger.info("更新缴费单支付状态,参数{}",tbRoomOrdersBill);
            int updateCount = tbRoomOrdersBillMapper.updateByPrimaryKeySelective(tbRoomOrdersBill);
            if (updateCount != 1){
                throw new JnSpringCloudException(new Result("-1","更新缴费单tb_room_orders_bill失败"));
            }
            logger.info("回调成功，支付状态更新为：已支付");
            return new Result("回调成功，支付状态更新为：已支付");
        }
        return new Result();
    }

    /**
     * 查询房间租借企业信息
     * @param enterpriseIds
     * @return
     */
    @Override
    @ServiceLog(doAction = "查询房间租借企业信息")
    public List<RoomEnterpriseModel> selectRoomEnterprise(List<String> enterpriseIds) {
        List<RoomEnterpriseModel> roomEnterpriseModelList = new ArrayList<>();
        if (enterpriseIds != null){
            for (String enterpriseId : enterpriseIds) {
                //创建查询条件
                TbRoomOrdersCriteria tbRoomOrdersCriteria = new TbRoomOrdersCriteria();
                //租借结束时间大于当前时间,并且企业已付款的订单信息
                tbRoomOrdersCriteria.createCriteria().andLeaseEndTimeGreaterThanOrEqualTo(new java.util.Date()).andEnterpriseIdEqualTo(enterpriseId).andPayStateEqualTo(Byte.parseByte(PayStatusEnums.PAYMENT.getCode()));
                List<TbRoomOrders> tbRoomOrdersList = tbRoomOrdersMapper.selectByExample(tbRoomOrdersCriteria);
                if (tbRoomOrdersList != null){
                    for (TbRoomOrders tbRoomOrders : tbRoomOrdersList) {
                        RoomEnterpriseModel roomEnter = new RoomEnterpriseModel();
                        //租借企业id
                        roomEnter.setEnterpriseId(tbRoomOrders.getEnterpriseId());
                        //租借企业名称
                        roomEnter.setEnterpriseId(tbRoomOrders.getLeaseEnterprise());
                        //查询子订单房间租借信息
                        TbRoomOrdersItemCriteria tbRoomOrdersItemCriteria = new TbRoomOrdersItemCriteria();
                        //通过订单id查询子订单,并且房间状态为租借中,
                        tbRoomOrdersItemCriteria.createCriteria().andOrderIdEqualTo(tbRoomOrders.getId()).andRoomStatusEqualTo(Byte.parseByte(RoomLeaseStatusEnums.DELIVERY.getValue())).andLeaseApplyStatusEqualTo(Byte.parseByte(RoomApplyStatusEnums.SUCCEED.getCode()));
                        List<TbRoomOrdersItem> tbRoomOrdersItemList = tbRoomOrdersItemMapper.selectByExample(tbRoomOrdersItemCriteria);
                        if (tbRoomOrdersItemList != null){
                            List<RoomPayOrdersItemModel> children = new ArrayList<>();
                            for (TbRoomOrdersItem roomOrdersItem : tbRoomOrdersItemList) {
                                //创建子集合model
                                RoomPayOrdersItemModel roomPayOrdersItemModel = new RoomPayOrdersItemModel();
                                BeanUtils.copyProperties(roomOrdersItem,roomPayOrdersItemModel);
                                children.add(roomPayOrdersItemModel);
                            }
                            roomEnter.setChildren(children);
                        }
                        roomEnterpriseModelList.add(roomEnter);
                    }
                }
            }
        }
        return roomEnterpriseModelList;
    }


    /**
     * 获取图片集合
     * @param imgUrl
     * @return
     */
    public List<String> getImgUrlList(String imgUrl){
        List<String> imageList = new ArrayList<>();
        if (StringUtils.isNotEmpty(imgUrl)){
            String[] url= imgUrl.split(",");
            for (String img : url) {
                imageList.add(img);
            }
        }
        return imageList;
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
