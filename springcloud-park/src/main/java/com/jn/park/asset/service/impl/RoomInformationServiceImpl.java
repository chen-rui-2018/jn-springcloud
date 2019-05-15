package com.jn.park.asset.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.asset.dao.RoomInformationDao;
import com.jn.park.asset.dao.TbRoomInformationMapper;
import com.jn.park.asset.dao.TbRoomOrdersMapper;
import com.jn.park.asset.entity.TbRoomInformation;
import com.jn.park.asset.entity.TbRoomInformationCriteria;
import com.jn.park.asset.entity.TbRoomOrders;
import com.jn.park.asset.enums.*;
import com.jn.park.asset.model.RoomInformationModel;
import com.jn.park.asset.model.RoomOrdersModle;
import com.jn.park.asset.service.RoomInformationService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
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

    @Autowired
    private RoomInformationDao roomInformationDao;
    @Autowired
    private TbRoomInformationMapper tbRoomInformationMapper;
    @Autowired
    private TbRoomOrdersMapper tbRoomOrdersMapper;


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
        RoomInformationModel roomInformationModel = roomInformationDao.getRoomInformation(id);
        return roomInformationModel;
    }

    /**
     * 租借资料填写
     * @param id
     * @param leaseEnterprise
     * @param contactName
     * @param contactPhone
     * @param leaseStartTime
     * @param leaseEndTime
     */
    @Override
    @ServiceLog(doAction = "租借资料填写")
    public void leaseWriter(String id, String leaseEnterprise, String contactName, String contactPhone, Date leaseStartTime, Date leaseEndTime) {
        RoomInformationModel roomInformation = roomInformationDao.getRoomInformation(id);
        roomInformation.setLeaseEnterprise(leaseEnterprise);
        roomInformation.setContactName(contactName);
        roomInformation.setContactPhone(contactPhone);
        roomInformation.setLeaseStartTime(leaseStartTime);
        roomInformation.setLeaseEndTime(leaseEndTime);
        TbRoomInformation tbRoomInformation = new TbRoomInformation();
        BeanUtils.copyProperties(roomInformation,tbRoomInformation);
        TbRoomInformationCriteria tbRoomInformationCriteria = new TbRoomInformationCriteria();
        TbRoomInformationCriteria.Criteria criteria = tbRoomInformationCriteria.createCriteria();
        criteria.andIdEqualTo(id);
        tbRoomInformationMapper.updateByExample(tbRoomInformation, tbRoomInformationCriteria);
    }

    //todo
    /*@Override
    @ServiceLog(doAction ="新增房间订单")
    public String addRoomOrders(String id, User user) {
        RoomInformationModel room = roomInformationDao.getRoomInformation(id);
        if (room != null){
            TbRoomOrders tbRoomOrders = new TbRoomOrders();
            //生成订单编号
            tbRoomOrders.setId(getOrderIdByTime());
            tbRoomOrders.setLeaseEnterprise(room.getLeaseEnterprise());
            tbRoomOrders.setRoomId(id);
            tbRoomOrders.setRoomName(room.getName());
            tbRoomOrders.setFloor(room.getFloor());
            tbRoomOrders.setTowerId(room.getTowerId());
            tbRoomOrders.setTowerName(room.getTowerName());
            tbRoomOrders.setRoomUrl(room.getImgUrl());
            tbRoomOrders.setLeaseStartTime(room.getLeaseStartTime());
            tbRoomOrders.setLeaseEndTime(room.getLeaseEndTime());
            tbRoomOrders.setContactName(room.getContactName());
            tbRoomOrders.setContactPhone(room.getContactPhone());
            tbRoomOrders.setRoomArea(room.getRoomArea());
            tbRoomOrders.setLeasePrice(room.getLeasePrice());
            tbRoomOrders.setLeaseSum(room.getLeaseSum());
            tbRoomOrders.setPressPay("押"+room.getPress()+"付"+room.getPay());
            tbRoomOrders.setShortestLease(room.getShortestLease());
            tbRoomOrders.setIntroduce(room.getIntroduce());
            //订单创建者
            tbRoomOrders.setCreatorAccount(user.getAccount());
            //计算付款金额
            //押
            BigDecimal press = new BigDecimal(room.getPress());
            //付
            BigDecimal pay = new BigDecimal(room.getPay());
            //租金
            BigDecimal leaseSum = room.getLeaseSum();
            //付款总金额
            BigDecimal paySum = leaseSum.multiply(press).add(leaseSum.multiply(pay));
            tbRoomOrders.setPaySum(paySum);
            //未付款
            tbRoomOrders.setPayState(Byte.parseByte(PayStatusEnums.NONPAYMENT.getCode()));
            //是否是续租订单(否)
            tbRoomOrders.setIsRelet(Byte.parseByte(RoomReletStatusEnums.NO.getCode()));
            //有效
            tbRoomOrders.setRecordStatus(Byte.parseByte(AssetStatusEnums.EFFECTIVE.getCode()));
            //房间房间租借状态(更改为租借申请中)
            tbRoomOrders.setRoomStatus(Byte.parseByte(RoomLeaseStatusEnums.APPLY.getValue()));
            tbRoomOrders.setCreateTime(new java.util.Date());
            tbRoomOrders.setContactName(user.getAccount());
            int insert = tbRoomOrdersMapper.insert(tbRoomOrders);
            //同时更新房间信息租借状态(更改为租借申请中)
            Map<String,Object> map = new HashMap<>(16);
            map.put("roomId",id);
            map.put("roomStatus",Byte.parseByte(RoomLeaseStatusEnums.APPLY.getValue()));
            roomInformationDao.updateStatus(map);
            if (insert > 0){
                return tbRoomOrders.getId();
            }
        }
        return "-1";
    }*/

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
