package com.jn.hardware.parking.service.impl;

import com.jn.common.model.Result;
import com.jn.hardware.enums.ParkingCompanyEnum;
import com.jn.hardware.model.parking.*;
import com.jn.hardware.model.parking.door.*;
import com.jn.hardware.parking.service.ParkingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingServiceImplTest {
    Logger logger = LoggerFactory.getLogger(ParkingServiceImplTest.class);

    @Autowired
    private ParkingService parkingService;

    /**
     * 查询临时停车缴费信息
     */
    @Test
    public void getTemporaryCarParkingFee() {
        TemporaryCarParkingFeeRequest temporaryCarParkingFeeRequest = new TemporaryCarParkingFeeRequest();
        temporaryCarParkingFeeRequest.setParkingCompanyId(ParkingCompanyEnum.DOOR_COMPANY.getCode());
        DoorTemporaryCarParkingFeeRequest doorTemporaryCarParkingFeeRequest = new DoorTemporaryCarParkingFeeRequest();
        doorTemporaryCarParkingFeeRequest.setParkid("100010_0004");
        doorTemporaryCarParkingFeeRequest.setCarNo("粤B7PU23");
        temporaryCarParkingFeeRequest.setDoorTemporaryCarParkingFeeRequest(doorTemporaryCarParkingFeeRequest);
        logger.info("\n查询临时停车缴费信息,入参：{}",temporaryCarParkingFeeRequest);
        Result result = parkingService.getTemporaryCarParkingFee(temporaryCarParkingFeeRequest);
        logger.info("\n查询结果说明：{}",result.getResult());
    }
    /**
     * 保存临时停车缴费信息
     */
    @Test
    public void savePaymentCarParkingFee() {
        Date  date = new Date();
        long time = date.getTime();
        PaymentCarParkingFeeRequest  paymentCarParkingFeeRequest = new PaymentCarParkingFeeRequest();
        paymentCarParkingFeeRequest.setParkingCompanyId(ParkingCompanyEnum.DOOR_COMPANY.getCode());
        DoorPaymentCarParkingFeeRequest doorPaymentCarParkingFeeRequest= new DoorPaymentCarParkingFeeRequest();
        doorPaymentCarParkingFeeRequest.setParkid("100010_0004");
        doorPaymentCarParkingFeeRequest.setCarNo("粤B7PU23");
        doorPaymentCarParkingFeeRequest.setCardNo("");
        doorPaymentCarParkingFeeRequest.setCardId("");
        doorPaymentCarParkingFeeRequest.setEntryTime("2019-04-18 08:45:36");
        doorPaymentCarParkingFeeRequest.setPayTime("2019-04-18 18:45:36");
        doorPaymentCarParkingFeeRequest.setChargeDuration("600");
        doorPaymentCarParkingFeeRequest.setAmount("100");
        doorPaymentCarParkingFeeRequest.setPurchaseAmount("70");
        doorPaymentCarParkingFeeRequest.setCouponAmount("30");
        doorPaymentCarParkingFeeRequest.setPaymentType("2");
        doorPaymentCarParkingFeeRequest.setPaymentTnx(Long.toString(time));
        doorPaymentCarParkingFeeRequest.setOperator("wangsong");
        doorPaymentCarParkingFeeRequest.setChannelId("123");
        logger.info("\n保存缴费,入参：{}",doorPaymentCarParkingFeeRequest);
        paymentCarParkingFeeRequest.setDoorPaymentCarParkingFeeRequest(doorPaymentCarParkingFeeRequest);
        Result result = parkingService.savePaymentCarParkingFee(paymentCarParkingFeeRequest);
        logger.info("\n保存缴费,结果说明：{}",result.getResult());
    }
    /**
     * 保存月租卡开户信息
     */
    @Test
    public void saveParkingMonthlyRentCard() {
        Date  date = new Date();
        long time = date.getTime();
        ParkingMonthlyRentCardRequest rentCardRequest = new ParkingMonthlyRentCardRequest();
        DoorParkingMonthlyRentCardParam param = new DoorParkingMonthlyRentCardParam();
        rentCardRequest.setParkingCompanyId(ParkingCompanyEnum.DOOR_COMPANY.getCode());
        param.setParkid("100010_0004");
        param.setCarNo("粤Z76760");
        param.setCardTypeId("11");
        param.setStartDate("2019-04-18");
        param.setEndDate("2020-04-18");
        param.setAmount("1000.00");
        param.setPayType("1");
        param.setPaymentNumber(Long.toString(time));
        param.setPayDate("2019-04-16 12:12:12");
        param.setContactName("王淞");
        param.setContactPhone("18899996666");
        param.setOperaterName("王多鱼");
        rentCardRequest.setDoorParkingMonthlyRentCardParam(param);
        Result result = parkingService.saveParkingMonthlyRentCard(rentCardRequest);
        logger.info("\n保存月租卡开户信息,结果说明：{}",result.getResult());
    }

    @Test
    public void findParkingMonthlyRentCard() {
        ParkingMonthlyCardInfoRequest cardInfoRequest = new ParkingMonthlyCardInfoRequest();
        cardInfoRequest.setParkingCompanyId(ParkingCompanyEnum.DOOR_COMPANY.getCode());
        DoorParkingMonthlyCardParam doorParkingMonthlyCardParam = new DoorParkingMonthlyCardParam();
        doorParkingMonthlyCardParam.setParkid("100010_0004");
        doorParkingMonthlyCardParam.setCarNo("粤Z76760");
        doorParkingMonthlyCardParam.setUserDate("2018-04-16");
        doorParkingMonthlyCardParam.setPageNo("1");
        doorParkingMonthlyCardParam.setPageSize("10");
        cardInfoRequest.setDoorParkingMonthlyCardParam(doorParkingMonthlyCardParam);
        Result result = parkingService.findParkingMonthlyRentCard(cardInfoRequest);
        logger.info("\n查询月租卡信息,结果说明：{}",result.getResult());

    }

    @Test
    public void saveMonthlyRentalCardRenewalFee() {
        Date  date = new Date();
        long time = date.getTime();
        MonthlyRentalCardRenewalFeeRequset feeRequest = new MonthlyRentalCardRenewalFeeRequset();
        feeRequest.setParkingCompanyId(ParkingCompanyEnum.DOOR_COMPANY.getCode());
        DoorMonthlyRentalCardRenewalFeeParam feeParam = new DoorMonthlyRentalCardRenewalFeeParam();
        feeParam.setParkid("100010_0004");
        feeParam.setCarNo("粤Z76760");
        feeParam.setCardTypeId("11");
        feeParam.setEndDate("2020-04-18");
        feeParam.setAmount("1000.00");
        feeParam.setPayType("1");
        feeParam.setPaymentNumber(Long.toString(time));
        feeParam.setPayDate("2019-04-16 12:12:12");
        feeRequest.setDoorMonthlyRentalCardRenewalFeeParam(feeParam);
        Result result =  parkingService.saveMonthlyRentalCardRenewalFee(feeRequest);
        logger.info("\n查询月租卡信息,结果说明：{}",result.getResult());
    }


    @Test
    public void findMonthlyRentCardRateInfo() {
        MonthyRentalCardRateRequest rateRequest =  new MonthyRentalCardRateRequest();
        rateRequest.setParkingCompanyId(ParkingCompanyEnum.DOOR_COMPANY.getCode());
        DoorMonthlyRentCardRateParam rateParam = new DoorMonthlyRentCardRateParam();
        rateParam.setParkid("100010_0004");
        rateParam.setCarNo("粤Z76760");
        rateParam.setCardId("123465");
        rateParam.setCardNo("123465");

        rateRequest.setDoorMonthlyRentCardRateParam(rateParam);
        Result result =   parkingService.findMonthlyRentCardRateInfo(rateRequest);
        logger.info("\n查询月租卡信息,结果说明：{}",result.getResult());

    }

    @Test
    public void cancelMonthlyRentAccount() {
        CancelMonthlyRentAccountRequest cancelRequest = new CancelMonthlyRentAccountRequest();
        cancelRequest.setParkingCompanyId(ParkingCompanyEnum.DOOR_COMPANY.getCode());
        DoorCancelMonthlyRentAccountParam cancelParam = new DoorCancelMonthlyRentAccountParam();
        cancelParam.setParkid("100010_0004");
        cancelParam.setCarNo("粤Z76760");
        cancelRequest.setDoorCancelMonthlyRentAccountParam(cancelParam);
        Result result =  parkingService.cancelMonthlyRentAccount(cancelRequest);
        logger.info("\n查询月租卡信息,结果说明：{}",result.getResult());

    }

    @Test
    public void findParkingSpaceAmount() {
        ParkingSpaceAmountRequest amountRequest = new ParkingSpaceAmountRequest();
        amountRequest.setParkingCompanyId(ParkingCompanyEnum.DOOR_COMPANY.getCode());
        amountRequest.setParkid("100010_0004");
        Result result =   parkingService.findParkingSpaceAmount(amountRequest);
        logger.info("\n车场停车位信息,结果说明：{}",result.getResult());

    }

    @Test
    public void saveDoorCarInParkingInfo() {
        DoorCarInParkingParam doorCarInParkingParam= new DoorCarInParkingParam();
        List<DoorCarInParkingShow> carinlist = new ArrayList<>(10);
        List<DoorPaymentInfo> paymentInfoList = new ArrayList<>(10);
        DoorCarInParkingShow doorCarInParkingShow = new DoorCarInParkingShow();
        //支付信息
        DoorPaymentInfo  doorPaymentInfo = new DoorPaymentInfo();
        doorPaymentInfo.setAccountCharge("3.0000");
        doorPaymentInfo.setPayCharge("1.2300");
        doorPaymentInfo.setPaymentType("1");
        doorPaymentInfo.setPayDate("2017-06-14 09:45:45");
        doorPaymentInfo.setDisAmount("1.7700");
        doorPaymentInfo.setPaymentTnx("139071630220170614094545275");
        paymentInfoList.add(doorPaymentInfo);
        //入场信息
        doorCarInParkingShow.setPaymentInfo(paymentInfoList);
        doorCarInParkingShow.setId("197");
        doorCarInParkingShow.setEntrance("入口");
        doorCarInParkingShow.setCardId("BDF2413131313131");
        doorCarInParkingShow.setCardNo("津A11111");
        doorCarInParkingShow.setCarNo("津A11111");
        doorCarInParkingShow.setOwnerName("临时用户");
        doorCarInParkingShow.setCardTypeId("31");
        doorCarInParkingShow.setCardTypeName("临时卡A");
        doorCarInParkingShow.setEntranceTime("2017-06-14 08:38:29");
        doorCarInParkingShow.setEntranceUserName("系统管理员");
        doorCarInParkingShow.setEntranceWayId("0");
        doorCarInParkingShow.setEntranceWayName("正常入场");
        doorCarInParkingShow.setSmall("0");
        doorCarInParkingShow.setEntryPic("");
        carinlist.add(doorCarInParkingShow);
        //入场入参
        doorCarInParkingParam.setCarinlist(carinlist);
        doorCarInParkingParam.setSignature("SJDKLSJKLDJSKLSHJKSHDJKHJKHJK");
        doorCarInParkingParam.setT("1520416876");
        String url= "";
        String parkId = "";
        DoorResult result = parkingService.saveDoorCarInParkingInfo(doorCarInParkingParam,url,parkId);
        logger.info("\n车场车辆入场信息,结果说明：{}",result.getBody());

    }

    @Test
    public void saveDoorCarOutParkingInfo() {


        DoorCarOutParkingParam  doorCarOutParkingParam = new DoorCarOutParkingParam();
        List<DoorCarOutParkingShow> showList = new ArrayList<>(10);
        DoorCarOutParkingShow doorCarOutParkingShow  = new DoorCarOutParkingShow();
        List<DoorPaymentInfo> paymentInfoList = new ArrayList<>(10);
        DoorCarInParkingShow doorCarInParkingShow = new DoorCarInParkingShow();
        //支付信息
        DoorPaymentInfo  doorPaymentInfo = new DoorPaymentInfo();
        doorPaymentInfo.setAccountCharge("3.0000");
        doorPaymentInfo.setPayCharge("1.2300");
        doorPaymentInfo.setPaymentType("1");
        doorPaymentInfo.setPayDate("2017-06-14 09:45:45");
        doorPaymentInfo.setDisAmount("1.7700");
        doorPaymentInfo.setPaymentTnx("139071630220170614094545275");
        paymentInfoList.add(doorPaymentInfo);
        //入场信息
        doorCarOutParkingShow.setId("126");
        doorCarOutParkingShow.setParkTime("0");
        doorCarOutParkingShow.setCardId("0000000000000000");
        doorCarOutParkingShow.setCardNo("0000000000");
        doorCarOutParkingShow.setCarNo("津A11111");
        doorCarOutParkingShow.setOwnerName("临时用户");
        doorCarOutParkingShow.setCardTypeId("1");
        doorCarOutParkingShow.setCardTypeName("手动开闸");
        doorCarOutParkingShow.setEntranceTime("2017-12-20 09:55:10");
        doorCarOutParkingShow.setEntranceUserName("");
        doorCarOutParkingShow.setCentralTime("2017-12-20 09:55:10");
        doorCarOutParkingShow.setExportTime("2017-12-20 09:55:10");
        doorCarOutParkingShow.setExportUserName("第三方手动开闸");
        doorCarOutParkingShow.setPayType("0");
        doorCarOutParkingShow.setPayCharge("0.0000");
        doorCarOutParkingShow.setBalanceMoney("0.0000");
        doorCarOutParkingShow.setDiscountNo("0");
        doorCarOutParkingShow.setDiscountTime("0.0000");
        doorCarOutParkingShow.setDisAmount("0.0000");
        doorCarOutParkingShow.setAccountCharge("0.0000");
        doorCarOutParkingShow.setIsOut("1");
        doorCarOutParkingShow.setUnusualMemo("手动开闸");
        doorCarOutParkingShow.setFreeAmount("0.0000");
        doorCarOutParkingShow.setEntrance("");
        doorCarOutParkingShow.setExport("");
        doorCarOutParkingShow.setExportPic("");
        doorCarOutParkingShow.setEntrancePic("");
        showList.add(doorCarOutParkingShow);
       //出场入参
        doorCarOutParkingParam.setCaroutlist(showList);
        doorCarOutParkingParam.setT("1520416876");
        doorCarOutParkingParam.setSignature("SJDKLSJKLDJSKLSHJKSHDJKHJKHJK");
        String url = "";
        String parkId = "";
        DoorResult doorResult =  parkingService.saveDoorCarOutParkingInfo(doorCarOutParkingParam,url,parkId);
        logger.info("\n车场车辆出场信息,结果说明：{}",doorResult.getBody());
    }

}