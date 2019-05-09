package com.jn.park.asset.service.impl;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.asset.model.RoomOrdersModle;
import com.jn.park.asset.model.RoomPayOrdersModel;
import com.jn.park.asset.service.RoomOrdersService;
import com.jn.system.log.annotation.ServiceLog;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 房间租借订单impl
* @author： zhuyz
* @date： Created on 2019/5/7 19:32
* @version： v1.0
* @modified By:
*/
@Service
public class RoomOrdersServiceImpl implements RoomOrdersService {
    @Override
    @ServiceLog(doAction = "返回支付订单")
    public RoomPayOrdersModel getPayOrders(String id) {
        return null;
    }

    @Override
    @ServiceLog(doAction = "分页返回房间租借历史列表")
    public PaginationData<List<RoomOrdersModle>> getRoomOrdersList(Page page) {
        return null;
    }

    @Override
    @ServiceLog(doAction ="获取房间租借详情信息")
    public RoomOrdersModle getRoomOrders(String id) {
        return null;
    }

    @Override
    @ServiceLog(doAction = "房间退租申请")
    public RoomOrdersModle quitApply(String id) {
        return null;
    }
}
