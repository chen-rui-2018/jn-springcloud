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
import com.jn.park.asset.service.RoomInformationService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
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
    @ServiceLog(doAction = "搜索房间")
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

    /**
     * 生成订单编号
     * @return
     */
    public static String getOrderIdByTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate = sdf.format(new java.util.Date());
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            result += random.nextInt(10);
        }
        return newDate + result;
    }

}
