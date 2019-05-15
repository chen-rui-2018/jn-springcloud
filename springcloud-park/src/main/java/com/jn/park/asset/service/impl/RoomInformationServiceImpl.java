package com.jn.park.asset.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.park.asset.dao.*;
import com.jn.park.asset.entity.*;
import com.jn.park.asset.enums.AssetStatusEnums;
import com.jn.park.asset.enums.PayStatusEnums;
import com.jn.park.asset.enums.RoomLeaseStatusEnums;
import com.jn.park.asset.enums.RoomReletStatusEnums;
import com.jn.park.asset.model.RoomInformationModel;
import com.jn.park.asset.service.RoomInformationService;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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


    /**
     * 分页返回房间租借列表
     * @param page
     * @return
     */
    @Override
    @ServiceLog(doAction = "分页返回房间租借列表")
    public PaginationData<List<RoomInformationModel>> getRoomLeaseList(Page page) {
        com.github.pagehelper.Page<Object> objects = PageHelper.startPage(page.getPage(), page.getRows());
        List<RoomInformationModel> roomLeaseList = roomInformationDao.getRoomLeaseList();
        PaginationData<List<RoomInformationModel>> data = new PaginationData<>(roomLeaseList,objects.getTotal());
        return data;
    }

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



    //todo
    @Override
    @ServiceLog(doAction ="新增房间订单")
    public Result addRoomOrders(String roomId,  String contactName, String contactPhone, Date leaseStartTime, Date leaseEndTime,String userAccount) {

        TbRoomInformation tbRoomInformation= tbRoomInformationMapper.selectByPrimaryKey(roomId);

        //
        this.validShortestLease(leaseStartTime,leaseEndTime,tbRoomInformation);

        //
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
            //todo

            item.setPaySum(this.calPrice(e));
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
        orders.setCreateTime(new java.util.Date());
        orders.setContactName(userAccount);
        //todo .....
        logger.info("插入订单主表数据，{}",orders);
        tbRoomOrdersMapper.insert(orders);

        //同时更新房间信息租借状态(更改为租借申请中)
        Map<String,Object> map = new HashMap<>(16);
        map.put("roomId",roomId);
        map.put("roomStatus",Byte.parseByte(RoomLeaseStatusEnums.APPLY.getValue()));
        roomInformationDao.updateStatus(map);//todo 单表不要自己写

        return new Result(orderId);
    }

    //校验最短租期
    private void validShortestLease(Date leaseStartTime, Date leaseEndTime,TbRoomInformation tbRoomInformation){
        //todo
        throw new JnSpringCloudException(new Result("",""));
    }
    //校验用户是否属于某个企业
    private void checkIsCompanyUser(String account){

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

    /**
     * 计算时间差
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(java.util.Date date1, java.util.Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        //同一年
        if (year1 != year2) {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                //闰年
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    timeDistance += 366;

                } else {
                    //不是闰年
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2 - day1);
        } else {
            //不同年
            System.out.println("判断day2 - day1 : " + (day2 - day1));
            return day2 - day1;
        }
    }
}
