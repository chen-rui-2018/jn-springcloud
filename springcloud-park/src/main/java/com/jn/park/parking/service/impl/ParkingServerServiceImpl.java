package com.jn.park.parking.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.hardware.api.ParkingClient;
import com.jn.hardware.enums.ParkingCompanyEnum;
import com.jn.hardware.model.parking.MonthlyRentalCardRenewalFeeRequset;
import com.jn.hardware.model.parking.ParkingMonthlyRentCardRequest;
import com.jn.hardware.model.parking.ParkingMonthlyRentCardUnite;
import com.jn.hardware.model.parking.PaymentCarParkingFeeRequest;
import com.jn.hardware.model.parking.door.DoorCarInParkingShow;
import com.jn.hardware.model.parking.door.DoorCarOutParkingShow;
import com.jn.hardware.model.parking.door.DoorMonthlyRentalCardRenewalFeeParam;
import com.jn.hardware.model.parking.door.DoorPaymentCarParkingFeeRequest;
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
import org.springframework.beans.BeanUtils;
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
        //TODO 调用匝道接口获取富士最新入场数据

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
    public List<ParkingRecordRampParam> selectParkingRecordByRamp(List<ParkingRecordRampParam> parkingRecordRampParam){
        return parkingRecordMapper.selectParkingRecordByRamp(parkingRecordRampParam);
    }



    @ServiceLog(doAction = "停车位租赁支付成功回调接口")
    @Override
    public Boolean parkingSpaceBillCallBack(String billNum){
        Result<PayBillVO> payBillDetailByIdOrNum = payBillClient.getPayBillDetailByIdOrNum(billNum);
        if(null == payBillDetailByIdOrNum || payBillDetailByIdOrNum.getData() == null){
            throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_PAYMENT_NOT_EXIT);
        }

        TbParkingSpaceRentalCriteria spaceRentalCriteria = new TbParkingSpaceRentalCriteria();
        spaceRentalCriteria.createCriteria().andOrderBillNumEqualTo(billNum);
        List<TbParkingSpaceRental> tbParkingSpaceRentals = tbParkingSpaceRentalMapper.selectByExample(spaceRentalCriteria);
        if(null == tbParkingSpaceRentals || tbParkingSpaceRentals.size() == 0 ){
            throw new JnSpringCloudException(ParkingExceptionEnum.REND_ID_IS_NOT_EXIT);
        }
        TbParkingSpaceRental tbParkingSpaceRental = tbParkingSpaceRentals.get(0);

        TbParkingSpaceRentalCriteria rentalCriteria = new TbParkingSpaceRentalCriteria();
        rentalCriteria.createCriteria().andCarLicenseEqualTo(tbParkingSpaceRental.getCarLicense()).andApprovalStatusEqualTo(ParkingEnums.PARKING_USER_APPLY_PAYED.getCode()).andRecordStatusEqualTo(new Byte(ParkingEnums.EFFECTIVE.getCode()));
        List<TbParkingSpaceRental> tbParkingSpaceRentals1 = tbParkingSpaceRentalMapper.selectByExample(rentalCriteria);
        if(null!= tbParkingSpaceRentals1 && tbParkingSpaceRentals1.size() >0){
            //第一次租赁 车位租赁硬件测接口
            saveParkingMonthlyRentCard(tbParkingSpaceRental,payBillDetailByIdOrNum.getData());
        }else{
            //车位续租接口
            saveMonthlyRentalCardRenewalFee(tbParkingSpaceRental,payBillDetailByIdOrNum.getData());
        }

        //改变租赁数据状态
        tbParkingSpaceRental.setApprovalStatus(ParkingEnums.PARKING_USER_APPLY_PAYED.getCode());
        tbParkingSpaceRental.setModifiedTime(new Date());

        int i = tbParkingSpaceRentalMapper.updateByPrimaryKeySelective(tbParkingSpaceRental);
        logger.info("车位支付回调，处理数据完成，响应条数：{}",i);
        return i==1?true:false;
    }

    /**
     * 车位租赁硬件对接接口
     * @param tbParkingSpaceRental
     * @param payBillVO
     */
    public void saveParkingMonthlyRentCard( TbParkingSpaceRental tbParkingSpaceRental,PayBillVO payBillVO){
        // 调用匝道通知车辆已开通月租卡
        ParkingMonthlyRentCardUnite rentCardUnite = new ParkingMonthlyRentCardUnite();
        String areaId = tbParkingSpaceRental.getAreaId();
        TbParkingArea tbParkingArea = tbParkingAreaMapper.selectByPrimaryKey(areaId);
        if(StringUtils.equals(tbParkingArea.getGateFactory(),ParkingEnums.PARKING_AREA_GATE_DAOER.getCode())){
            rentCardUnite.setParkingCompanyId(ParkingCompanyEnum.DOOR_COMPANY.getCode());
        }else if(StringUtils.equals(tbParkingArea.getGateFactory(),ParkingEnums.PARKING_AREA_GATE_FUSHI.getCode())){
            rentCardUnite.setParkingCompanyId(ParkingCompanyEnum.FUSHI_COMPANY.getCode());
        }
        //匝道系统中的停车场ID为园区系统的gate_id
        rentCardUnite.setAreaId(tbParkingArea.getGateId());
        rentCardUnite.setCarLicense(tbParkingSpaceRental.getCarLicense());
        rentCardUnite.setCardTypeId(ParkingEnums.PARKING_AREA_MONTHS_11.getCode());
        rentCardUnite.setStartTime(DateUtils.formatDate(tbParkingSpaceRental.getStartTime(),ParkingEnums.DATE_TIME_FORMAT_DATE.getCode()));
        rentCardUnite.setEndTime(DateUtils.formatDate(tbParkingSpaceRental.getEndTime(),ParkingEnums.DATE_TIME_FORMAT_DATE.getCode()));
        rentCardUnite.setActualMoney(tbParkingSpaceRental.getActualMoney().toString());
        String payType = payBillVO.getPayType();
        rentCardUnite.setPayType(payType);
        rentCardUnite.setOrderBillNum(tbParkingSpaceRental.getOrderBillNum());
        rentCardUnite.setPayDate(DateUtils.formatDate((null==payBillVO.getPayTime()? (new Date()):payBillVO.getPayTime()),ParkingEnums.DATE_TIME_FORMAT.getCode()));
        rentCardUnite.setAccount(tbParkingSpaceRental.getName()==null?tbParkingSpaceRental.getCreatorAccount():tbParkingSpaceRental.getName());
        rentCardUnite.setPhone(tbParkingSpaceRental.getPhone()==null? "":tbParkingSpaceRental.getPhone());
        rentCardUnite.setOperaterName("门户系统");
        Result result = parkingClient.saveParkingMonthlyRentCard(rentCardUnite);
        logger.info("月租卡开户信息推送,硬件测响应结果：{}，{}",result.getCode(),result.getResult());
    }

    /**
     * 车位续租硬件对接接口
     * @param tbParkingSpaceRental
     * @param payBillVO
     */
    public void saveMonthlyRentalCardRenewalFee( TbParkingSpaceRental tbParkingSpaceRental,PayBillVO payBillVO){
        MonthlyRentalCardRenewalFeeRequset renewalFeeRequset = new MonthlyRentalCardRenewalFeeRequset();
        String areaId = tbParkingSpaceRental.getAreaId();
        TbParkingArea tbParkingArea = tbParkingAreaMapper.selectByPrimaryKey(areaId);
        if(StringUtils.equals(tbParkingArea.getGateFactory(),ParkingEnums.PARKING_AREA_GATE_DAOER.getCode())){
            renewalFeeRequset.setParkingCompanyId(ParkingCompanyEnum.DOOR_COMPANY.getCode());
        }else if(StringUtils.equals(tbParkingArea.getGateFactory(),ParkingEnums.PARKING_AREA_GATE_FUSHI.getCode())){
            renewalFeeRequset.setParkingCompanyId(ParkingCompanyEnum.FUSHI_COMPANY.getCode());
        }

        DoorMonthlyRentalCardRenewalFeeParam rentalCardRenewalFeeParam = new DoorMonthlyRentalCardRenewalFeeParam();

        rentalCardRenewalFeeParam.setParkid(tbParkingArea.getGateId());
        rentalCardRenewalFeeParam.setCarNo(tbParkingSpaceRental.getCarLicense());
        rentalCardRenewalFeeParam.setCardTypeId(ParkingEnums.PARKING_AREA_MONTHS_11.getCode());
        rentalCardRenewalFeeParam.setStartDate(DateUtils.formatDate(tbParkingSpaceRental.getStartTime(),ParkingEnums.DATE_TIME_FORMAT_DATE.getCode()));
        rentalCardRenewalFeeParam.setEndDate(DateUtils.formatDate(tbParkingSpaceRental.getEndTime(),ParkingEnums.DATE_TIME_FORMAT_DATE.getCode()));
        rentalCardRenewalFeeParam.setAmount(tbParkingSpaceRental.getActualMoney().toString());
        String payType = payBillVO.getPayType();
        rentalCardRenewalFeeParam.setPayType(payType);
        rentalCardRenewalFeeParam.setPaymentNumber(tbParkingSpaceRental.getOrderBillNum());
        rentalCardRenewalFeeParam.setPayDate(DateUtils.formatDate((null==payBillVO.getPayTime()? (new Date()):payBillVO.getPayTime()),ParkingEnums.DATE_TIME_FORMAT.getCode()));

        Result result = parkingClient.saveMonthlyRentalCardRenewalFee(renewalFeeRequset);
        logger.info("月租卡续租信息推送,硬件测响应结果：{}，{}",result.getCode(),result.getResult());
    }


    @ServiceLog(doAction = "临时车支付成功回调接口")
    @Override
    public Boolean parkingCarBillCallBack(String billNum){
        Result<PayBillVO> payBillDetailByIdOrNum = payBillClient.getPayBillDetailByIdOrNum(billNum);
        if(null == payBillDetailByIdOrNum || null == payBillDetailByIdOrNum.getData()){
            throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_PAYMENT_NOT_EXIT);
        }
        TbParkingRecordCriteria recordCriteria = new TbParkingRecordCriteria();
        recordCriteria.createCriteria().andOrderBillNumEqualTo(payBillDetailByIdOrNum.getData().getBillNum()).andRecordStatusEqualTo(new Byte(ParkingEnums.EFFECTIVE.getCode()));
        List<TbParkingRecord> parkingRecords = tbParkingRecordMapper.selectByExample(recordCriteria);
        if(null == parkingRecords || parkingRecords.size() == 0){
            throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_RECODE_IS_NOT_EXIST);
        }

        PaymentCarParkingFeeRequest paymentCarParking = new PaymentCarParkingFeeRequest();
        TbParkingRecord tbParkingRecord = parkingRecords.get(0);
        String areaId = tbParkingRecord.getAreaId();
        TbParkingArea parkingArea = tbParkingAreaMapper.selectByPrimaryKey(areaId);
        if(StringUtils.equals(parkingArea.getGateFactory(),ParkingEnums.PARKING_AREA_GATE_DAOER.getCode())){
            paymentCarParking.setParkingCompanyId(ParkingCompanyEnum.DOOR_COMPANY.getCode());
        }else if(StringUtils.equals(parkingArea.getGateFactory(),ParkingEnums.PARKING_AREA_GATE_FUSHI.getCode())){
            paymentCarParking.setParkingCompanyId(ParkingCompanyEnum.FUSHI_COMPANY.getCode());
        }
        DoorPaymentCarParkingFeeRequest parkingFeeRequest = new DoorPaymentCarParkingFeeRequest();
        parkingFeeRequest.setParkid(parkingArea.getGateId());
        parkingFeeRequest.setCardNo(tbParkingRecord.getCarLicense());
        parkingFeeRequest.setEntryTime(DateUtils.formatDate(tbParkingRecord.getAdmissionTime(),ParkingEnums.DATE_TIME_FORMAT.getCode()));
        parkingFeeRequest.setPayTime(DateUtils.formatDate(new Date(),ParkingEnums.DATE_TIME_FORMAT.getCode()));
        parkingFeeRequest.setChargeDuration((((new Date()).getTime() - tbParkingRecord.getAdmissionTime().getTime())/1000/60)+"");
        parkingFeeRequest.setAmount(null==tbParkingRecord.getDueMoney()?"0":tbParkingRecord.getDueMoney().toString());
        parkingFeeRequest.setPurchaseAmount(null==tbParkingRecord.getActualMoney()?"0":tbParkingRecord.getActualMoney().toString());
        parkingFeeRequest.setCouponAmount(null==tbParkingRecord.getDeductionMoney()?"0":tbParkingRecord.getDeductionMoney().toString());
        parkingFeeRequest.setPaymentType(payBillDetailByIdOrNum.getData().getPayType());
        parkingFeeRequest.setPaymentTnx(tbParkingRecord.getOrderBillNum());
        parkingFeeRequest.setOperator(null==tbParkingRecord.getCreatorAccount()?"admin":tbParkingRecord.getCreatorAccount());
        paymentCarParking.setDoorPaymentCarParkingFeeRequest(parkingFeeRequest);

        Result result = parkingClient.savePaymentCarParkingFee(paymentCarParking);
        logger.info("调用匝道系统业务处理完成，返回响应标识：{}，响应结果：{}",result.getCode(),result.getResult());
        if(StringUtils.equals(result.getCode(),ParkingEnums.PARKING_RESPONSE_SUCCESS.getCode())){
            logger.info("道闸系统处理成功，开始创建新的停车记录数据。");
            //创建新的停车记录。缴费开始计算时间为缴费时间+免费时间
            String billCreateTime = payBillDetailByIdOrNum.getData().getBillCreateTime();
            TbParkingArea tbParkingArea = tbParkingAreaMapper.selectByPrimaryKey(tbParkingRecord.getAreaId());
            TbParkingRecord parkingRecordNew = new TbParkingRecord();
            BeanUtils.copyProperties(tbParkingRecord,parkingRecordNew);
            try{
                parkingRecordNew.setStartBillingTime(DateUtils.addMinutes(DateUtils.parseDate(billCreateTime,"yyyy-MM-dd HH:mm:ss"),tbParkingArea.getTempFreeTime()));
            }catch (ParseException e){
                logger.error("账单创建时停车场免费时间对应数据转换失败，改用当前时间。",e);
                parkingRecordNew.setStartBillingTime(DateUtils.addMinutes(new Date(),tbParkingArea.getTempFreeTime()));
            }
            parkingRecordNew.setCreatedTime(new Date());
            parkingRecordNew.setParkingId(UUID.randomUUID().toString().replaceAll("-",""));
            int insert = tbParkingRecordMapper.insert(parkingRecordNew);
            logger.info("临停支付成功，创建新的停车记录。缴费开始计算时间为缴费时间+免费分钟，响应条数：{}",insert);
            //修改停车记录数据
            tbParkingRecord.setPayTime(new Date());
            tbParkingRecord.setPayStatus(ParkingEnums.PARKING_CARE_APPLY_PAYED.getCode());
            tbParkingRecord.setActualMoney(payBillDetailByIdOrNum.getData().getPayAmount());
            int i = tbParkingRecordMapper.updateByPrimaryKey(tbParkingRecord);
            logger.info("修改停车记录数据支付状态，响应条数：{}",i);
        }else{
            logger.error("临停缴费支付回调，对接道闸业务系统响应失败，账单号：{}",billNum);
            throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_GATE_ERROR);
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
            param.setParkingId(UUID.randomUUID().toString().replaceAll("-",""));
            param.setMessageId(door.getId());
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
        logger.info("处理道尔推送车辆入场数据成功，ids：{}",s);
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
        for (Object obj:carList ) {
            ParkingRecordRampParam param = new ParkingRecordRampParam();
            DoorCarOutParkingShow door = (DoorCarOutParkingShow)obj;
            param.setParkingStatus(ParkingEnums.CAR_IS_IN_PARKING.getCode());
            param.setAdmissionTime(door.getEntranceTime());
            param.setDepartureTime(door.getExportTime());
            param.setCarLicense(door.getCarNo());
            parkingRecordRampParam.add(param);
            sb.append(door.getId()+",");
        }
        int i = parkingRecordMapper.updateParkingRecordByRamp(parkingRecordRampParam);
        logger.info("处理道尔推送车辆出场数据成功，响应条数：-- {}",i);
        String s = carList.size()==i?sb.toString():"";
        return s==""?"":s.substring(0,s.length()-1);
    }

}