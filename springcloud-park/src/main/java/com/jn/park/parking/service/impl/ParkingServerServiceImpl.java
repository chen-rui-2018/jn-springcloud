package com.jn.park.parking.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.hardware.api.ParkingClient;
import com.jn.hardware.model.parking.ParkingMonthlyRentCardRequest;
import com.jn.hardware.model.parking.ParkingMonthlyRentCardUnite;
import com.jn.hardware.model.parking.PaymentCarParkingFeeRequest;
import com.jn.hardware.model.parking.door.DoorCarInParkingShow;
import com.jn.hardware.model.parking.door.DoorCarOutParkingShow;
import com.jn.park.enums.ParkingExceptionEnum;
import com.jn.park.parking.dao.ParkingRecordMapper;
import com.jn.park.parking.dao.TbParkingAreaMapper;
import com.jn.park.parking.dao.TbParkingRecordMapper;
import com.jn.park.parking.dao.TbParkingSpaceRentalMapper;
import com.jn.park.parking.entity.*;
import com.jn.park.parking.enums.ParkingEnums;
import com.jn.park.parking.model.ParkingRecordRampDetailParam;
import com.jn.park.parking.service.ParkingServerService;
import com.jn.park.parking.model.ParkingRecordRampParam;
import com.jn.pay.api.PayClient;
import com.jn.pay.model.PayBillDetails;
import com.jn.paybill.api.PayBillClient;
import com.jn.paybill.model.PayBillVO;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/25 15:44
 * @version： v1.0
 * @modified By:
 */
@Service
public class ParkingServerServiceImpl implements ParkingServerService {
    private static Logger logger = LoggerFactory.getLogger(ParkingServerServiceImpl.class);

    @Autowired
    private ParkingRecordMapper parkingRecordMapper;
    @Autowired
    private TbParkingRecordMapper tbParkingRecordMapper;
    @Autowired
    private TbParkingSpaceRentalMapper tbParkingSpaceRentalMapper;
    @Autowired
    private ParkingClient parkingClient;
    @Autowired
    private PayBillClient payBillClient;
    @Autowired
    private TbParkingAreaMapper tbParkingAreaMapper;

    @ServiceLog(doAction = "定时同步匝道系统车辆入场数据")
    @Override
    public Boolean getInParkingCarInfoList(){
        //TODO 调用匝道接口获取最新入场数据

        List<ParkingRecordRampParam> parkingRecordRampParam = new ArrayList<>(16);
        //TODO 查询系统数据，做去重处理


        return true;
    }

    @ServiceLog(doAction = "定时同步匝道系统车辆出场数据")
    @Override
    public Boolean getOutParkingCarInfoList(){

        return true;
    }

    @ServiceLog(doAction = "调用匝道查询停车信息【不计算金额，只同步数据】")
    @Override
    public ParkingRecordRampParam getParkingByCarLicense(String carLicense){
        ParkingRecordRampParam parkingRecordRampParam = new ParkingRecordRampParam();
        //TODO 调用匝道查询停车信息【不计算金额，只同步数据】

        List<ParkingRecordRampParam> parkingRecordRampParams = new ArrayList<>(16);
        parkingRecordRampParams.add(parkingRecordRampParam);
        return parkingRecordRampParam;
    }

    @ServiceLog(doAction = "将匝道同步过来的数据批量入库【需是去重后的数据】")
    @Override
    public int insertParkingRecordByRamp(List<ParkingRecordRampParam> parkingRecordRampParam){
        List<ParkingRecordRampDetailParam> parkingRecords = new ArrayList<>(16);
        for (ParkingRecordRampParam param:
             parkingRecordRampParam) {
            ParkingRecordRampDetailParam parkingRecordRampDetailParam = new ParkingRecordRampDetailParam();
            parkingRecordRampDetailParam.setGateId(param.getGateId());
            parkingRecordRampDetailParam.setParkingId(StringUtils.isEmpty(param.getParkingId())?UUID.randomUUID().toString().replaceAll("-",""):param.getParkingId());
            parkingRecordRampDetailParam.setCarLicense(param.getCarLicense());
            parkingRecordRampDetailParam.setCreatedTime(new Date());
            try{
                parkingRecordRampDetailParam.setDepartureTime(param.getDepartureTime()==null?null:DateUtils.parseDate(param.getDepartureTime(), ParkingEnums.DATE_TIME_FORMAT.getCode()));
                parkingRecordRampDetailParam.setAdmissionTime(param.getAdmissionTime()==null?null: DateUtils.parseDate(param.getAdmissionTime(), ParkingEnums.DATE_TIME_FORMAT.getCode()));

            }catch (ParseException e){
                logger.error("将匝道同步过来的数据批量入库，时间转换错误",e);
            }
            parkingRecords.add(parkingRecordRampDetailParam);
        }
        int i = parkingRecordMapper.insertParkingRecordByRamp(parkingRecords);
        return i;
    }

    @ServiceLog(doAction = "批量修改停车数据[处理车辆出场时间和状态]")
    @Override
    public int updateParkingRecordByParam(List<ParkingRecordRampParam> parkingRecordRampParam){
        return parkingRecordMapper.updateParkingRecordByRamp(parkingRecordRampParam);
    }



    @ServiceLog(doAction = "停车位租赁支付成功回调接口")
    public Boolean parkingSpaceBillCallBack(String billNum){
        TbParkingSpaceRentalCriteria spaceRentalCriteria = new TbParkingSpaceRentalCriteria();
        spaceRentalCriteria.createCriteria().andOrderBillNumEqualTo(billNum);
        List<TbParkingSpaceRental> tbParkingSpaceRentals = tbParkingSpaceRentalMapper.selectByExample(spaceRentalCriteria);
        if(null == tbParkingSpaceRentals || tbParkingSpaceRentals.size() == 0 ){
            throw new JnSpringCloudException(ParkingExceptionEnum.REND_ID_IS_NOT_EXIT);
        }
        TbParkingSpaceRental tbParkingSpaceRental = tbParkingSpaceRentals.get(0);
        //TODO 调用匝道通知车辆已开通月租卡
        ParkingMonthlyRentCardUnite parkingMonthlyRentCardRequest = new ParkingMonthlyRentCardUnite();
        parkingClient.saveParkingMonthlyRentCard(parkingMonthlyRentCardRequest);

        //改变租赁数据状态
        tbParkingSpaceRental.setApprovalStatus(ParkingEnums.PARKING_USER_APPLY_PAYED.getCode());
        tbParkingSpaceRental.setModifiedTime(new Date());

        int i = tbParkingSpaceRentalMapper.updateByPrimaryKeySelective(tbParkingSpaceRental);
        logger.info("车位支付回调，处理数据完成，响应条数：{}",i);
        return i==1?true:false;
    }

    @ServiceLog(doAction = "临时车支付成功回调接口")
    public Boolean parkingCarBillCallBack(String billId){
        Result<PayBillVO> payBillDetailByIdOrNum = payBillClient.getPayBillDetailByIdOrNum(billId);
        if(null == payBillDetailByIdOrNum || null == payBillDetailByIdOrNum.getData()){
            throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_PAYMENT_NOT_EXIT);
        }
        //TODO 调用匝道通知临时车已缴费
        PaymentCarParkingFeeRequest paymentCarParking = new PaymentCarParkingFeeRequest();
        Result result = parkingClient.savePaymentCarParkingFee(paymentCarParking);
        String code = result.getCode();
        if(StringUtils.equals(code,ParkingEnums.PARKING_RESPONSE_SUCCESS.getCode())){
            logger.info("道闸系统处理成功，开始创建新的停车记录数据。");

        }else{
            logger.error("临停缴费支付回调，对接道闸业务系统响应失败，账单号：{}",billId);
            throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_GATE_ERROR);
        }

        TbParkingRecordCriteria recordCriteria = new TbParkingRecordCriteria();
        recordCriteria.createCriteria().andOrderBillNumEqualTo(payBillDetailByIdOrNum.getData().getBillNum()).andRecordStatusEqualTo(new Byte(ParkingEnums.EFFECTIVE.getCode()));
        List<TbParkingRecord> parkingRecords = tbParkingRecordMapper.selectByExample(recordCriteria);

        if(parkingRecords.size()>0){
            //创建新的停车记录。缴费开始计算时间为缴费时间+免费时间
            TbParkingRecord tbParkingRecord = parkingRecords.get(0);
            String billCreateTime = payBillDetailByIdOrNum.getData().getBillCreateTime();
            TbParkingArea tbParkingArea = tbParkingAreaMapper.selectByPrimaryKey(tbParkingRecord.getAreaId());
            try{
                tbParkingRecord.setStartBillingTime(DateUtils.addMinutes(DateUtils.parseDate(billCreateTime,"yyyy-MM-dd HH:mm:ss"),tbParkingArea.getTempFreeTime()));
            }catch (ParseException e){
                logger.error("账单创建是加能赚换失败，改用当前时间。",e);
                tbParkingRecord.setStartBillingTime(DateUtils.addMinutes(new Date(),tbParkingArea.getTempFreeTime()));
            }
            tbParkingRecord.setCreatedTime(new Date());

            int insert = tbParkingRecordMapper.insert(tbParkingRecord);
            logger.info("临停支付成功，创建新的停车记录。缴费开始计算时间为缴费时间+免费分钟，响应条数：{}",insert);
        }
        return true;
    }

    @ServiceLog(doAction = "道尔 车辆入场推送接口")
    @Override
    public String carJoinParking(List carList,String parkId){
        logger.info("道尔 车辆入场推送接口 parkId:"+parkId);
        StringBuffer sb = new StringBuffer();
        if(null == carList || carList.size() == 0){
            throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_INFO_IS_NOT_NULL);
        }
        logger.info("开始处理道尔推送车辆入场数据，数据总条数：{}",carList.size());
        List<ParkingRecordRampParam> parkingRecordRampParam = new ArrayList<>(16);
        for (Object obj:carList
             ) {
            ParkingRecordRampParam param = new ParkingRecordRampParam();
            DoorCarInParkingShow door = (DoorCarInParkingShow)obj;
            param.setParkingId(door.getId());
            param.setParkingStatus(ParkingEnums.CAR_IS_IN_PARKING.getCode());
            param.setAdmissionTime(door.getEntranceTime());
            param.setCarLicense(door.getCarNo());
            param.setGateId(parkId);
            parkingRecordRampParam.add(param);
            sb.append(door.getId()+",");
        }
        int i = insertParkingRecordByRamp(parkingRecordRampParam);
        logger.info("处理道尔推送车辆入场数据成功，响应条数：{}",i);
        String s = sb.toString();
        return s.substring(0,s.length()-1);
    }

    @ServiceLog(doAction = "道尔 车辆出场推送接口")
    @Override
    public String carOutParking(List carList){
        StringBuffer sb = new StringBuffer();
        if(null == carList || carList.size() == 0){
            throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_INFO_IS_NOT_NULL);
        }
        logger.info("开始处理道尔推送车辆出场数据，数据总条数：-- {}",carList.size());
        List<ParkingRecordRampParam> parkingRecordRampParam = new ArrayList<>(16);
        for (Object obj:carList
             ) {
            ParkingRecordRampParam param = new ParkingRecordRampParam();
            DoorCarOutParkingShow door = (DoorCarOutParkingShow)obj;
            param.setParkingStatus(ParkingEnums.CAR_IS_IN_PARKING.getCode());
            param.setAdmissionTime(door.getEntranceTime());
            param.setDepartureTime(door.getExportTime());
            param.setCarLicense(door.getCarNo());
            parkingRecordRampParam.add(param);
            sb.append(door.getId()+",");
        }
        int i = updateParkingRecordByParam(parkingRecordRampParam);
        logger.info("处理道尔推送车辆出场数据成功，响应条数：-- {}",i);
        String s = sb.toString();
        return s.substring(0,s.length()-1);
    }

}
