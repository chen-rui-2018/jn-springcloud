package com.jn.server;/**
 * @author： huangbq
 * @date： Created on 2019/5/15 21:11
 * @version： v1.0
 * @modified By:
 */

import com.jn.common.model.Result;
import com.jn.park.api.RoomOrderClient;
import com.jn.park.asset.service.RoomInformationService;
import com.jn.park.property.model.PayCallBackNotify;
import com.jn.pay.model.CreatePayReqModel;
import com.jn.pay.model.PayOrderNotify;
import com.jn.pay.model.PayOrderRsp;
import com.jn.system.log.annotation.ControllerLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Date;

/**
 *房间租赁controller
 *<pre> 
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/5/15
 *</pre>
 */
@RestController
public class RoomOrderClientController implements RoomOrderClient {
    @Resource
    private RoomInformationService roomInformationService;

    @ControllerLog(doAction = "房间支付回调")
    @Override
    public Result payCallBack(@RequestBody PayOrderNotify payOrderNotify) {
        return roomInformationService.payCallBack(payOrderNotify);
    }

    @Override
    @ControllerLog(doAction = "创建订单")
    public Result<PayOrderRsp> createPay(@RequestBody CreatePayReqModel createPayReqModel) {
        return roomInformationService.createPayOrder(createPayReqModel.getOrderId(),createPayReqModel.getChannelId(),createPayReqModel.getPaySum(),createPayReqModel.getUserAccount());
    }

    @Override
    @ControllerLog(doAction = "是否支付,未支付取消订单")
    public Result updateRoomPayStatus() {
        roomInformationService.updateRoomPayStatus();
        return new Result();
    }

    @Override
    @ControllerLog(doAction = "定时生成缴费单")
    public Result createOrderBill() {
        roomInformationService.createOrderBill();
        return null;
    }

    @Override
    @ControllerLog(doAction ="缴费单回调")
    public Result updateBill(@RequestBody PayCallBackNotify payCallBackNotify) {
        return roomInformationService.updateBill(payCallBackNotify);
    }

    @ControllerLog(doAction = "新增房间订单")
    @Override
    public Result addRoomOrders(@RequestParam("roomIds")String roomIds, @RequestParam("contactName") String contactName, @RequestParam("contactPhone") String contactPhone, @RequestParam("leaseStartTime") Date leaseStartTime, @RequestParam("month") String month, @RequestParam("userAccount") String userAccount) {
        return roomInformationService.addRoomOrders(roomIds,contactName,contactPhone,leaseStartTime,month,userAccount);
    }

    @ControllerLog(doAction = "根据订单生成缴费单")
    @Override
    public Result createRoomOrderBillByOrder(@RequestParam("orderId") String orderId) {
        return roomInformationService.createRoomOrderBillByOrder(orderId);
    }

}
