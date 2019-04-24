package com.jn.hardware.parking.service;

import com.jn.common.model.Result;
import com.jn.hardware.model.parking.*;
import com.jn.hardware.model.parking.door.DoorCarInParkingParam;
import com.jn.hardware.model.parking.door.DoorCarOutParkingParam;
import com.jn.hardware.model.parking.door.DoorResult;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * TODO：未添加类描述
 *
 * @Author： cm
 * @Date： Created on 2019/4/17 17:12
 * @Version： v1.0
 * @Modified By:
 */
public interface ParkingService {
    /**
     * 道尔的临停预缴费信息(场内缴费)
     * todo 后面需写在配置文件中，分了正式和测试地址
     */
    String GET_DOOR_TEMPORARYCAR_PARKINGFEE_URL = "https://api-dev.drzk.cn/v2/car/temporarycar/parkingfee/parkid/%s?parkid=%s&carNo=%s";

    /**
     * 保存道尔的临停预缴费信息(场内缴费)
     * todo 后面需写在配置文件中，分了正式和测试地址
     */
    String POST_DOOR_SAVE_PAYMENT_CARPARKINGFEE_URL = "https://api-dev.drzk.cn/v2/car/temporarycar/payment/parkid/%s";
    /**
     * 保存道尔的月租卡开户信息
     * todo 后面需写在配置文件中，分了正式和测试地址
     */
    String POST_DOOR_SAVE_MONTHLY_RENT_CARD_URL = "https://api-dev.drzk.cn/v2/car/monthlycar/newcard/parkid/%s";
    /**
     * 保存道尔的月租卡开户信息
     * todo 后面需写在配置文件中，分了正式和测试地址
     */
    String GET_DOOR_FIND_MONTHLY_RENT_CARD_URL = "https://api-dev.drzk.cn/v2/car/monthlycar/carddetail/parkid/%s?parkid=%s&carNo=%s&userDate=%s&pageNo=%s&pageSize=%s";
     /**
     * 保存道尔的月租卡续费信息
     * todo 后面需写在配置文件中，分了正式和测试地址
     */
    String POST_DOOR_MONTHLY_RENTAL_CARD_RENEWALFEE_URL = "https://api-dev.drzk.cn/v2/car/monthlycar/payment/parkid/%s";
    /**
     * 保存道尔的月租卡续费信息
     * todo 后面需写在配置文件中，分了正式和测试地址
     */
    String GET_DOOR_MONTHLYRENTCARD_RATEINFO_URL = "https://api-dev.drzk.cn/v2/car/monthlycar/monthlycarfee/parkid/%s?parkid=%s&carNo=%s";
     /**
     * 道尔 注销月租卡
     * todo 后面需写在配置文件中，分了正式和测试地址
     */
    String POST_DOOR_CANCEL_MONTHLYRENT_ACCOUNT_URL = "https://api-dev.drzk.cn/v2/car/monthlycar/logoff/parkid/%s";
    /**
     * 道尔 车场车位查询
     * todo 后面需写在配置文件中，分了正式和测试地址
     */
    String POST_DOOR_PARKINGSPACE_AMOUNT_URL = "https://api-dev.drzk.cn/v2/park/carportnum/parkid/%s?parkid=%s";



    /**
     * 获取临停预缴费信息(场内缴费)
     * @param temporaryCarParkingFeeRequest
     * @return
     */
    Result getTemporaryCarParkingFee(TemporaryCarParkingFeeRequest temporaryCarParkingFeeRequest);

    /**
     * 保存用户停车缴费信息
     * @param paymentCarParkingFeeRequest
     * @return
     */
    Result savePaymentCarParkingFee(PaymentCarParkingFeeRequest paymentCarParkingFeeRequest);

    /**
     * 月租卡开户信息保存
     * @param parkingMonthlyRentCardRequest
     * @return
     */
    Result saveParkingMonthlyRentCard(ParkingMonthlyRentCardRequest parkingMonthlyRentCardRequest);

    /**
     * 月租卡信息查询
     * @param parkingMonthlyCardInfoRequest
     * @return
     */
    Result findParkingMonthlyRentCard(ParkingMonthlyCardInfoRequest parkingMonthlyCardInfoRequest);

    /**
     * 月租卡续费信息保存
     * @param monthlyRentalCardRenewalFeeRequset
     * @return
     */
    Result saveMonthlyRentalCardRenewalFee(MonthlyRentalCardRenewalFeeRequset monthlyRentalCardRenewalFeeRequset);

    /**
     * 月租信息获取(含费率)
     * @param monthyRentalCardRateRequest
     * @return
     */
    Result findMonthlyRentCardRateInfo(MonthyRentalCardRateRequest monthyRentalCardRateRequest);

    /**
     * 月租卡销户操作
     * @param cancelMonthlyRentAccountRequest
     * @return
     */
    Result cancelMonthlyRentAccount(CancelMonthlyRentAccountRequest cancelMonthlyRentAccountRequest);

    /**
     * 停车场车位查询
     * @param parkingSpaceAmountRequest
     * @return
     */
    Result findParkingSpaceAmount(ParkingSpaceAmountRequest parkingSpaceAmountRequest);

    /**
     * 车辆入场记录信息
     * @param doorCarInParkingShow
     * @param url
     * @return
     */
    DoorResult saveDoorCarInParkingInfo(DoorCarInParkingParam doorCarInParkingShow, String url);

    /**
     * 车辆出场记录信息
     * @param doorCarOutParkingShow
     * @param url
     * @return
     */
    DoorResult  saveDoorCarOutParkingInfo(@RequestBody DoorCarOutParkingParam doorCarOutParkingShow, String url);

}
