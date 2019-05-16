package com.jn.park.asset.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.asset.dao.RoomInformationDao;
import com.jn.park.asset.dao.RoomOrdersDao;
import com.jn.park.asset.enums.OrdersTypeEnums;
import com.jn.park.asset.enums.RoomLeaseStatusEnums;
import com.jn.park.asset.model.RoomOrdersModle;
import com.jn.park.asset.model.RoomPayOrdersModel;
import com.jn.park.asset.service.RoomOrdersService;
import com.jn.system.log.annotation.ServiceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 房间租借订单impl
* @author： zhuyz
* @date： Created on 2019/5/7 19:32
* @version： v1.0
* @modified By:
*/
@Service
public class RoomOrdersServiceImpl implements RoomOrdersService {

    @Autowired
    private RoomOrdersDao roomOrdersDao;
    @Autowired
    private RoomInformationDao roomInformationDao;

    /**
     * 返回支付订单
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "返回支付订单")
    public RoomPayOrdersModel getPayOrders(String id) {
       RoomPayOrdersModel roomPayOrdersModel = roomOrdersDao.getPayOrders(id);
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
    public PaginationData<List<RoomOrdersModle>> getRoomOrdersList(String account,Page page) {
        com.github.pagehelper.Page<Object> objects = PageHelper.startPage(page.getPage(), page.getRows());
        List<RoomOrdersModle> roomOrdersModleList = roomOrdersDao.getRoomOrdersList(account);
        PaginationData<List<RoomOrdersModle>> data = new PaginationData<>(roomOrdersModleList,objects.getTotal());
        return data;
    }

    /**
     * 获取房间租借详情信息
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction ="获取房间租借详情信息")
    public RoomOrdersModle getRoomOrders(String id) {
        RoomOrdersModle roomOrdersModle = roomOrdersDao.getRoomOrders(id);
        return roomOrdersModle;
    }

    /**
     * 房间退租申请
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "房间退租申请")
    public RoomOrdersModle quitApply(String id) {
        //状态未更新前
        RoomOrdersModle beforeRoomOrders = roomOrdersDao.getRoomOrders(id);
        Map<String,Object> map = new HashMap<>(16);
        map.put("roomId",beforeRoomOrders.getRoomId());
        map.put("roomStatus",Byte.parseByte(RoomLeaseStatusEnums.QUIT.getValue()));
        map.put("orderId",id);
        //更新房间订单状态
        roomOrdersDao.updateRoomStatus(map);
        //更新房间状态
        roomInformationDao.updateStatus(map);
        //状态更新后
        RoomOrdersModle afterRoomOrders = roomOrdersDao.getRoomOrders(id);
        return afterRoomOrders;
    }
}
