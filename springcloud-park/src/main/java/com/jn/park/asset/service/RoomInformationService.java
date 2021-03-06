package com.jn.park.asset.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.asset.model.*;
import com.jn.park.property.model.PayCallBackNotify;
import com.jn.pay.model.PayOrderNotify;
import com.jn.pay.model.PayOrderRsp;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
* 房间信息Service
* @author： zhuyz
* @date： Created on 2019/5/7 16:03
* @version： v1.0
* @modified By:
*/
public interface RoomInformationService {

    /**
     * 获取房间信息
     * @param id
     * @return
     */
    RoomInformationModel getRoomInformation(String id,String account);

    /**
     *
     * @param roomIds
     * @param contactName
     * @param contactPhone
     * @param leaseStartTime
     * @param month
     * @param userAccount
     * @return
     */
    Result addRoomOrders(String roomIds, String contactName, String contactPhone, Date leaseStartTime,  String month, String userAccount);

    /**
     * 根据订单生成缴费单
     * @param orderId 房间订单ID
     * @return
     */
    Result createRoomOrderBillByOrder(String orderId);

    /**
     * 获取房间基本信息
     * @param roomId
     * @return
     */
    RoomBaseModel getRoomBaseInfo(String roomId);

    /**
     * 分页返回房间租赁列表(可搜索)
     * @param page
     * @param name
     * @return
     */
    PaginationData<List<RoomInformationModel>> getRoomLeaseList(Page page, String name);

     /**
     * 创建支付订单
     * @param orderId
     * @param channelId
     * @return
     */
    public Result<PayOrderRsp> createPayOrder(String orderId, String channelId ,BigDecimal paySum, String userAccount);
    /**
     * 支付回调
     * @param payOrderNotify
     * @return
     */
    Result payCallBack(PayOrderNotify payOrderNotify);

    /**
     * 返回支付订单
     * @param id
     * @return
     */
    RoomPayOrdersModel getPayOrders(String orderId);

    /**
     * 房间退租申请
     * @param id
     * @return
     */
    RoomPayOrdersItemModel quitApply(String orderItemId);

    /**
     * 房间租借历史订单(新)
     * @param account
     * @param page
     * @return
     */
    PaginationData<List<RoomLeaseRecordModel>> getNewRoomOrdersList(String account, Page page);

    /**
     * 房间租借详情(新)
     * @param itemId 子订单id
     * @param account
     * @return
     */
    RoomOrdersModel getNewRoomOrders(String itemId, String account);

    /**
     * 定时任务,生成缴费单
     */
    void createOrderBill();

    /**
     * 查询企业租借房间信息
     * @param enterpriseId
     * @return
     */
    List<RoomEnterpriseModel> selectRoomEnterprise(List<String> enterpriseId);

    /**
     * 缴费单回调
     * @param payCallBackNotify
     * @return
     */
    Result updateBill(PayCallBackNotify payCallBackNotify);

    /**
     * 调用生成缴费单接口
     * @param billId
     * @param billSum
     * @return
     */
    Result createBill(String billId,String billSum);

    /**
     * 撤销缴费单
     * @param billIds
     * @return
     */
    Result withdrawBill(String billIds);
}
