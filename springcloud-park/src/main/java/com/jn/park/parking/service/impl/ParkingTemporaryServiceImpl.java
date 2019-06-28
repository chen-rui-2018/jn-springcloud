package com.jn.park.parking.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.StringUtils;
import com.jn.hardware.api.ParkingClient;
import com.jn.hardware.model.parking.TemporaryCarParkingFeeRequest;
import com.jn.hardware.model.parking.door.DoorTemporaryCarParkingFeeRequest;
import com.jn.hardware.model.parking.door.DoorTemporaryCarParkingFeeResponse;
import com.jn.park.enums.ParkingExceptionEnum;
import com.jn.park.parking.dao.TbParkingAreaMapper;
import com.jn.park.parking.dao.TbParkingCarInfoMapper;
import com.jn.park.parking.dao.TbParkingRecordMapper;
import com.jn.park.parking.dao.TbParkingSpaceRentalMapper;
import com.jn.park.parking.entity.*;
import com.jn.park.parking.enums.ParkingEnums;
import com.jn.park.parking.model.ParkingCarJoinParam;
import com.jn.park.parking.model.ParkingCarLeaveParam;
import com.jn.park.parking.service.ParkingTemporaryService;
import com.jn.park.parking.vo.ParkingCarLeaveVo;
import com.jn.park.parking.vo.ParkingCarPayVo;
import com.jn.paybill.api.PayBillClient;
import com.jn.paybill.model.PaymentBillModel;
import com.jn.paybill.model.PaymentBillParam;
import com.jn.system.log.annotation.ServiceLog;
import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/24 11:07
 * @version： v1.0
 * @modified By:
 */
@Service
public class ParkingTemporaryServiceImpl implements ParkingTemporaryService {
    private static Logger logger = LoggerFactory.getLogger(ParkingTemporaryServiceImpl.class);
    @Autowired
    private TbParkingRecordMapper tbParkingRecordMapper;
    @Autowired
    private TbParkingAreaMapper tbParkingAreaMapper;
    @Autowired
    private TbParkingCarInfoMapper tbParkingCarInfoMapper;
    @Autowired
    private TbParkingSpaceRentalMapper tbParkingSpaceRentalMapper;
    @Autowired
    private PayBillClient payBillClient;
    @Autowired
    private ParkingClient parkingClient;

    @ServiceLog(doAction = "车辆入场请求接口")
    @Override
    public String carJoinParking(ParkingCarJoinParam parkingCarJoinParam) {
        TbParkingRecord parkingRecord = new TbParkingRecord();
        parkingRecord.setParkingId(UUID.randomUUID().toString().replaceAll("-", ""));

        TbParkingAreaCriteria areaCriteria = new TbParkingAreaCriteria();
        areaCriteria.createCriteria().andAreaIdEqualTo(parkingCarJoinParam.getAreaId()).andRecordStatusEqualTo(new Byte(ParkingEnums.EFFECTIVE.getCode())).andAreaStatusEqualTo(ParkingEnums.PARKING_AREA_EFFECTIVE.getCode());
        List<TbParkingArea> tbParkingAreas = tbParkingAreaMapper.selectByExample(areaCriteria);
        if (null == tbParkingAreas || tbParkingAreas.size() != 1) {
            throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_AREA_IS_NOT_EXIST);
        }
        TbParkingCarInfoCriteria carInfoCriteria = new TbParkingCarInfoCriteria();
        carInfoCriteria.createCriteria().andCarLicenseEqualTo(parkingCarJoinParam.getCarLicense()).andRecordStatusEqualTo(new Byte(ParkingEnums.EFFECTIVE.getCode())).andCarStatusEqualTo(ParkingEnums.PARKING_USER_CAR_INFO_EFFECTIVE.getCode());
        List<TbParkingCarInfo> tbParkingCarInfos = tbParkingCarInfoMapper.selectByExample(carInfoCriteria);
        if (null != tbParkingCarInfos && tbParkingCarInfos.size() == 1) {
            parkingRecord.setAccount(tbParkingCarInfos.get(0).getAccount());
            parkingRecord.setName(tbParkingCarInfos.get(0).getName());
            parkingRecord.setPhone(tbParkingCarInfos.get(0).getPhone());
        }
        parkingRecord.setAdmissionTime(new Date());
        parkingRecord.setCreatedTime(new Date());
        parkingRecord.setAreaName(tbParkingAreas.get(0).getAreaName());
        parkingRecord.setCarLicense(parkingCarJoinParam.getCarLicense());
        parkingRecord.setRecordStatus(new Byte(ParkingEnums.EFFECTIVE.getCode()));
        int insert = tbParkingRecordMapper.insert(parkingRecord);
        return insert+"";
    }

    @ServiceLog(doAction = "车辆离场接口")
    @Override
    public ParkingCarLeaveVo carLeaveParking(ParkingCarLeaveParam parkingCarLeaveParam){

        String carLicense = parkingCarLeaveParam.getCarLicense();
        TbParkingRecordCriteria recordCriteria = new TbParkingRecordCriteria();
        recordCriteria.createCriteria().andRecordStatusEqualTo(new Byte(ParkingEnums.EFFECTIVE.getCode())).andCarLicenseEqualTo(carLicense).andParkingStatusEqualTo("1");
        recordCriteria.setOrderByClause("created_time desc");

        ParkingCarLeaveVo parkingCarLeaveVo = new ParkingCarLeaveVo();
        BeanUtils.copyProperties(parkingCarLeaveParam,parkingCarLeaveVo);

        List<TbParkingRecord> tbParkingRecords = tbParkingRecordMapper.selectByExample(recordCriteria);
        if(tbParkingRecords==null){
            throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_CAR_NOT_EXIT_EFFECTIVE_DATA);
        }
        TbParkingRecord parkingRecord = tbParkingRecords.get(0);
        Double amount = calculateParkingAmount(parkingRecord);

        Boolean aBoolean = checkCarIsMonthlyCard(carLicense,parkingCarLeaveParam.getAreaId());

        parkingCarLeaveVo.setWaitPayAmount(Double.toHexString(amount));
        parkingCarLeaveVo.setIsDischar(amount==0?ParkingEnums.PARKING_DISCHAR_PASS.getCode():ParkingEnums.PARKING_DISCHAR_UNPASS.getCode());
        parkingCarLeaveVo.setIsRental(aBoolean?ParkingEnums.PARKING_IS_RENTAL.getCode():ParkingEnums.PARKING_IS_UNRENTAL.getCode());
        return parkingCarLeaveVo;
    }

    @ServiceLog(doAction = "计算停车费金额")
    @Override
    public Double calculateParkingAmount(TbParkingRecord parkingRecord){
//        Date nowDate = new Date();
//        long times= (nowDate.getTime() - parkingRecord.getAdmissionTime().getTime())/(1000* 60);
//        TbParkingArea tbParkingArea = tbParkingAreaMapper.selectByPrimaryKey(parkingRecord.getAreaId());
//        if(times > (tbParkingArea.getTempFreeTime()==null?0:tbParkingArea.getTempFreeTime()) ||
//                (parkingRecord.getStartBillingTime()!=null && parkingRecord.getStartBillingTime().getTime()>(tbParkingArea.getTempFreeTime()==null?0:tbParkingArea.getTempFreeTime()))){
//            if(parkingRecord.getStartBillingTime()!=null){
//                times = parkingRecord.getStartBillingTime().getTime() - (tbParkingArea.getTempFreeTime()==null?0:tbParkingArea.getTempFreeTime()) ;
//            }
//            int unit = new Integer(tbParkingArea.getTempPriceUnit());
//            //获取计费时长
//            long c = times%unit == 0 ? (times/unit) : (times/unit)+1;
//            double amount = new BigDecimal(c).multiply(new BigDecimal(Double.toString(tbParkingArea.getTempPrice()))).doubleValue();
//            return new Double((null!=tbParkingArea.getTempPriceTotal()&&tbParkingArea.getTempPriceTotal()<amount)?tbParkingArea.getTempPriceTotal():amount);
//        }else{
//            return new Double(0);
//        }
        TbParkingArea parkingArea = tbParkingAreaMapper.selectByPrimaryKey(parkingRecord.getAreaId());
        TemporaryCarParkingFeeRequest temporaryCarParkingFeeRequest = new TemporaryCarParkingFeeRequest();
        DoorTemporaryCarParkingFeeRequest  request = new DoorTemporaryCarParkingFeeRequest();
        request.setCarNo(parkingRecord.getCarLicense());
        request.setParkid(parkingArea.getGateId());
        temporaryCarParkingFeeRequest.setParkingCompanyId("1");
        temporaryCarParkingFeeRequest.setDoorTemporaryCarParkingFeeRequest(request);
        Result<DoorTemporaryCarParkingFeeResponse> result =   parkingClient.getTemporaryCarParkingFee(temporaryCarParkingFeeRequest);
        if(result.getCode().equals(GlobalConstants.SUCCESS_CODE)){
            DoorTemporaryCarParkingFeeResponse response = result.getData();
            return Double.valueOf(response.getDiscountAmount());
        }else{
            logger.info("\n临时停车费用获取异常{}原因"+result.getResult());
            throw  new JnSpringCloudException(ParkingExceptionEnum.PARKING_GET_PAYMENT,result.getResult());
        }
    }

    @ServiceLog(doAction = "校验是否是月租车")
    @Override
    public Boolean checkCarIsMonthlyCard(String carLicense,String areaId){
        TbParkingSpaceRentalCriteria rentalCriteria = new TbParkingSpaceRentalCriteria();
        rentalCriteria.createCriteria().andRecordStatusEqualTo(new Byte(ParkingEnums.EFFECTIVE.getCode())).andCarLicenseEqualTo(carLicense).andAreaIdEqualTo(areaId).
                andApprovalStatusEqualTo(ParkingEnums.PARKING_USER_APPLY_PAYED.getCode()).andStartTimeLessThanOrEqualTo(new Date()).andEndTimeGreaterThanOrEqualTo(new Date());
        List<TbParkingSpaceRental> tbParkingSpaceRentals = tbParkingSpaceRentalMapper.selectByExample(rentalCriteria);
        if(null!=tbParkingSpaceRentals && tbParkingSpaceRentals.size()>0){
            return true;
        }else{
            return false;
        }

    }

    @ServiceLog(doAction = "临停缴费账单创建")
    @Override
    public ParkingCarPayVo createCarParkingBill(String parkingId){
        TbParkingRecord parkingRecord = tbParkingRecordMapper.selectByPrimaryKey(parkingId);
        if(null == parkingRecord){
            throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_RECODE_IS_NOT_EXIST);
        }
        ParkingCarPayVo parkingCarPayVo = new ParkingCarPayVo();
        parkingCarPayVo.setParkingId(parkingId);
        //校验是否是月租卡
        Boolean aBoolean = checkCarIsMonthlyCard(parkingRecord.getCarLicense(),parkingRecord.getAreaId());
        //计算金额
        Double aDouble = calculateParkingAmount(parkingRecord);
        if(aBoolean || aDouble == 0){
            parkingCarPayVo.setDueMoney(new Double(0));
            parkingCarPayVo.setCreateStatus(aBoolean==true? ParkingEnums.PARKING_PAYMENT_IS_NOT.getCode():ParkingEnums.PARKING_PAYMENT_IS_NOT_PAY.getCode());
            //不用缴费的数据不同步至匝道系统
        }else{
            //判断是否已创建账单，已创建则取消原账单。
            if(StringUtils.isNotEmpty(parkingRecord.getOrderBillNum())){
                Result<Boolean> booleanResult = payBillClient.cancelPayBillByBillId(parkingRecord.getOrderBillNum());
                logger.info("删除临时停车原有缴费记录数据，响应结果：{}",booleanResult.getData());
            }
            PaymentBillModel paymentBillModel = new PaymentBillModel();
            paymentBillModel.setBillNum("PK-"+ DateUtils.getDate(ParkingEnums.DATE_TIME_FORMAT_DATE_NUM.getCode())+ RandomUtils.nextInt(999));
            paymentBillModel.setBillName(parkingRecord.getCarLicense()+"-"+DateUtils.formatDate(parkingRecord.getAdmissionTime(),ParkingEnums.DATE_TIME_FORMAT_DATE_NUM.getCode())+"停车费");
            paymentBillModel.setBillType(ParkingEnums.PARKING_TEMPORARY_BILL_TYPE.getCode());
            paymentBillModel.setBillObjId(parkingRecord.getAccount());
            paymentBillModel.setBillObjName(parkingRecord.getName());
            paymentBillModel.setBillAmount(aDouble);
            paymentBillModel.setPayEndTime(DateUtils.formatDate(DateUtils.addDays(new Date(),1),ParkingEnums.DATE_TIME_FORMAT.getCode()));
            paymentBillModel.setBillCreateAccount(parkingRecord.getAccount());
            paymentBillModel.setBillRemark(ParkingEnums.PARKING_TEMPORARY_BILL_TYPE_NAME.getCode());
            Result<String> bill = payBillClient.createBill(paymentBillModel);
            parkingCarPayVo.setBillId(bill.getData());
            parkingCarPayVo.setBillNum(paymentBillModel.getBillNum());
            parkingCarPayVo.setDueMoney(aDouble);
            parkingCarPayVo.setCreateStatus(ParkingEnums.PARKING_PAYMENT_IS_INITIATE.getCode());

            //支付发起成功，将支付账单id写入停车记录，方便下次发起支付删除原有缴费记录。
            parkingRecord.setModifiedTime(new Date());
            parkingRecord.setOrderBillNum(paymentBillModel.getBillNum());
            int i = tbParkingRecordMapper.updateByPrimaryKeySelective(parkingRecord);
            logger.info("处理临时停车账单号逻辑完成，响应条数：{}",i);
        }
        return parkingCarPayVo;
    }

}
