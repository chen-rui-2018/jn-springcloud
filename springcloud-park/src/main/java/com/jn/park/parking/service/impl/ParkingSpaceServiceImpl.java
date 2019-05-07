package com.jn.park.parking.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.park.enums.ParkingExceptionEnum;
import com.jn.park.parking.dao.*;
import com.jn.park.parking.entity.*;
import com.jn.park.parking.enums.ParkingEnums;
import com.jn.park.parking.model.*;
import com.jn.park.parking.service.ParkingAreaService;
import com.jn.park.parking.service.ParkingCarInfoService;
import com.jn.park.parking.service.ParkingSpaceRentalService;
import com.jn.park.parking.service.ParkingSpaceService;
import com.jn.park.parking.vo.*;
import com.jn.paybill.api.PayBillClient;
import com.jn.paybill.model.PayBillVO;
import com.jn.paybill.model.PaymentBillModel;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.apache.commons.lang.math.RandomUtils;
import org.jolokia.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.jar.JarException;

/**
 * 停车位
 *
 * @author： jiangyl
 * @date： Created on 2019/4/18 17:41
 * @version： v1.0
 * @modified By:
 */
@Service
public class ParkingSpaceServiceImpl implements ParkingSpaceService {
    private static Logger logger = LoggerFactory.getLogger(ParkingSpaceServiceImpl.class);
    @Autowired
    private TbParkingSpaceMapper tbParkingSpaceMapper;
    @Autowired
    private TbParkingPreferentialMapper tbParkingPreferentialMapper;
    @Autowired
    private ParkingSpaceRentalService parkingSpaceRentalService;
    @Autowired
    private ParkingSpaceMapper parkingSpaceMapper;
    @Autowired
    private ParkingAreaService parkingAreaService;
    @Autowired
    private TbParkingSpaceRentalMapper tbParkingSpaceRentalMapper;
    @Autowired
    private TbParkingCarInfoMapper tbParkingCarInfoMapper;
    @Autowired
    private ParkingCarInfoService parkingCarInfoService;
    @Autowired
    private PayBillClient payBillClient;
    @Autowired
    private TbParkingPreferentialAreaMapper tbParkingPreferentialAreaMapper;

    @ServiceLog(doAction = "查询停车位列表")
    @Override
    public PaginationData<List<ParkingSpaceVo>> getParkingSpaceList(ParkingSpaceParam parkingSpaceParam) {
        Page<Object> objects = PageHelper.startPage(parkingSpaceParam.getPage(), parkingSpaceParam.getRows() == 0 ? 15 : parkingSpaceParam.getRows());
        List<ParkingSpaceVo> parkingSpaceList = parkingSpaceMapper.getParkingSpaceList(parkingSpaceParam);
        PaginationData<List<ParkingSpaceVo>> data = new PaginationData(parkingSpaceList, objects.getTotal());
        return data;
    }

    @ServiceLog(doAction = "查询停车位详情[已租车位关联出租户信息]")
    @Override
    public ParkingSpaceDetailVo getParkingSpaceDetailById(String spaceId) {
        ParkingSpaceParam parkingSpaceParam = new ParkingSpaceParam();
        parkingSpaceParam.setSpaceId(spaceId);
        List<ParkingSpaceVo> parkingSpaceList = parkingSpaceMapper.getParkingSpaceList(parkingSpaceParam);
        if (null == parkingSpaceList || parkingSpaceList.size() == 0) {
            logger.info("查询停车位详情[已租车位关联出租户信息]:未查询到相关车位数据，spaceId：{}", spaceId);
            throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_AREA_IS_NOT_EXIST);
        }
        ParkingSpaceDetailVo spaceVo = new ParkingSpaceDetailVo();
        BeanUtils.copyProperties(parkingSpaceList.get(0), spaceVo);
        if (StringUtils.isNotEmpty(parkingSpaceList.get(0).getRentId())) {
            ParkingSpaceRentalVo parkingSpaceDetail = parkingSpaceRentalService.getParkingSpaceDetailById(parkingSpaceList.get(0).getRentId());
            BeanUtils.copyProperties(parkingSpaceDetail, spaceVo);
        }
        return spaceVo;
    }

    @ServiceLog(doAction = "新增/修改车位")
    @Override
    public String saveOrUpdateParkingSpace(ParkingSpaceModel parkingSpaceModel, String userAccount) {
        TbParkingSpace parkingSpace = new TbParkingSpace();
        BeanUtils.copyProperties(parkingSpaceModel, parkingSpace);
        int i = 0;
        if (StringUtils.isNotEmpty(parkingSpaceModel.getSpaceId())) {
            parkingSpace.setModifiedTime(new Date());
            parkingSpace.setModifierAccount(userAccount);
            i = tbParkingSpaceMapper.updateByPrimaryKeySelective(parkingSpace);
        } else {
            parkingSpace.setSpaceId(UUID.randomUUID().toString().replace("-", ""));
            parkingSpace.setSpaceStatus(ParkingEnums.PARKING_SPACE_NOT_RENTED.getCode());
            parkingSpace.setRecordStatus(new Byte(ParkingEnums.EFFECTIVE.getCode()));
            parkingSpace.setCreatedTime(new Date());
            parkingSpace.setCreatorAccount(userAccount);
            i = tbParkingSpaceMapper.insert(parkingSpace);
        }
        return i + "";
    }

    @ServiceLog(doAction = "删除车位")
    @Override
    public String deleteParkingSpace(String spaceId, String userAccount) {
        TbParkingSpace tbParkingSpace = new TbParkingSpace();
        tbParkingSpace.setSpaceId(spaceId);
        tbParkingSpace.setSpaceStatus(ParkingEnums.PARKING_SPACE_DELETED.getCode());
        tbParkingSpace.setModifierAccount(userAccount);
        tbParkingSpace.setModifiedTime(new Date());
        int i = tbParkingSpaceMapper.updateByPrimaryKeySelective(tbParkingSpace);
        return i + "";
    }

    @ServiceLog(doAction = "查询当前用户车位租赁记录")
    @Override
    public PaginationData<List<ParkingUserSpaceRentalVo>> getParKingSpaceRentalListByUser(String account, com.jn.common.model.Page page) {
        Page<Object> objects = PageHelper.startPage(page.getPage(), page.getRows() == 0 ? 15 : page.getRows());
        List<ParkingUserSpaceRentalVo> parKingSpaceRentalListByUser = parkingSpaceMapper.getParKingSpaceRentalListByUser(account);
        PaginationData<List<ParkingUserSpaceRentalVo>> data = new PaginationData(parKingSpaceRentalListByUser, objects.getTotal());
        return data;
    }

    @ServiceLog(doAction = "查询当前用户车位统计数据")
    @Override
    public ParkingSpaceUserCountVo getParkingSpaceUserCount(String userAccount) {
        if (StringUtils.isEmpty(userAccount)) {
            throw new JnSpringCloudException(ParkingExceptionEnum.USER_LOGIN_INVALID);
        }
        return parkingSpaceMapper.getParkingSpaceUserCount(userAccount);
    }

    @ServiceLog(doAction = "车位申请")
    @Override
    public String applyParkingSpace(ParkingSpaceApplyModel parkingSpaceApplyModel, User user) {
        ParkingSpaceAmountModel parkingSpaceAmountModel = new ParkingSpaceAmountModel();
        BeanUtils.copyProperties(parkingSpaceApplyModel, parkingSpaceAmountModel);

        ParkingSpaceAmountVo parkingSpaceAmountVo = this.applyParkingSpaceAmount(parkingSpaceAmountModel, user.getAccount());
        TbParkingSpaceRental tbParkingSpaceRental = new TbParkingSpaceRental();
        BeanUtils.copyProperties(parkingSpaceApplyModel,tbParkingSpaceRental);
        BeanUtils.copyProperties(parkingSpaceAmountVo,tbParkingSpaceRental);
        String rentId = UUID.randomUUID().toString().replaceAll("-", "");
        tbParkingSpaceRental.setRentId(rentId);
        tbParkingSpaceRental.setAccount(user.getAccount());
        try {
            tbParkingSpaceRental.setStartTime(DateUtils.parseDate(parkingSpaceApplyModel.getStartTime(), ParkingEnums.DATE_TIME_FORMAT_DATE.getCode()));
            tbParkingSpaceRental.setEndTime(DateUtils.parseDate(parkingSpaceApplyModel.getEndTime(), ParkingEnums.DATE_TIME_FORMAT_DATE.getCode()));
        } catch (ParseException e) {
            logger.info("时间转换异常：", e);
            throw new JnSpringCloudException(ParkingExceptionEnum.DAY_INTERVAL_ERROR);
        }
        if (StringUtils.isEmpty(parkingSpaceApplyModel.getName())) {
            tbParkingSpaceRental.setName(user.getName());
        }
        if (StringUtils.isEmpty(parkingSpaceApplyModel.getPhone())) {
            tbParkingSpaceRental.setPhone(user.getPhone());
        }
        tbParkingSpaceRental.setApprovalStatus(ParkingEnums.PARKING_USER_APPLY_WAIT_CHECK.getCode());
        tbParkingSpaceRental.setCreatedTime(new Date());
        tbParkingSpaceRental.setCreatorAccount(user.getAccount());
        tbParkingSpaceRental.setRecordStatus(new Byte(ParkingEnums.EFFECTIVE.getCode()));

        //处理用户绑定车辆数据
        TbParkingCarInfoCriteria carInfoCriteria = new TbParkingCarInfoCriteria();
        carInfoCriteria.createCriteria().andCarLicenseEqualTo(parkingSpaceApplyModel.getCarLicense()).andCarStatusEqualTo(ParkingEnums.PARKING_USER_CAR_INFO_EFFECTIVE.getCode()).andRecordStatusEqualTo(new Byte(ParkingEnums.EFFECTIVE.getCode()));
        List<TbParkingCarInfo> tbParkingCarInfos = tbParkingCarInfoMapper.selectByExample(carInfoCriteria);
        if(null == tbParkingCarInfos || tbParkingCarInfos.size() == 0 ){
            ParkingCarInfoModel parkingCarInfoModel = new ParkingCarInfoModel();
            parkingCarInfoModel.setCarLicense(parkingSpaceApplyModel.getCarLicense());
            parkingCarInfoModel.setName(tbParkingSpaceRental.getName());
            parkingCarInfoModel.setPhone(tbParkingSpaceRental.getPhone());
            String s = parkingCarInfoService.saveCarInfo(parkingCarInfoModel, user);
            logger.info("用户车位申请绑定车辆响应结果：{}",s);
        }

        //TODO 调用审核流



        int insert = tbParkingSpaceRentalMapper.insert(tbParkingSpaceRental);
        return insert + "";
    }

    @ServiceLog(doAction = "租车位费用计算接口")
    @Override
    public ParkingSpaceAmountVo applyParkingSpaceAmount(ParkingSpaceAmountModel parkingSpaceAmountModel, String account) {
        ParkingAreaDetailVo parkingAreaDetailById = parkingAreaService.getParkingAreaDetailById(parkingSpaceAmountModel.getAreaId());
        if (null == parkingAreaDetailById) {
            throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_AREA_IS_NOT_EXIST);
        }
        ParkingSpaceAmountVo parkingSpaceAmountVo = new ParkingSpaceAmountVo();
        BeanUtils.copyProperties(parkingSpaceAmountModel, parkingSpaceAmountVo);
        parkingSpaceAmountVo.setRentPrice(Double.toString(parkingAreaDetailById.getRentPrice()));
        int dayInterval = 0;
        try {
            dayInterval = getDayInterval(DateUtils.parseDate(parkingSpaceAmountModel.getStartTime(), ParkingEnums.DATE_TIME_FORMAT_DATE.getCode()), DateUtils.parseDate(parkingSpaceAmountModel.getEndTime(), ParkingEnums.DATE_TIME_FORMAT_DATE.getCode()));
        } catch (ParseException e) {
            logger.info("时间转换异常：", e);
            throw new JnSpringCloudException(ParkingExceptionEnum.DAY_INTERVAL_ERROR);
        }
        //计算应缴金额
        double dueMoney = new BigDecimal(dayInterval).multiply(new BigDecimal(Double.toString(parkingAreaDetailById.getRentPrice()))).divide(new BigDecimal(365),2,BigDecimal.ROUND_HALF_UP).doubleValue();
        parkingSpaceAmountVo.setDueMoney(dueMoney);

        if (StringUtils.isNotEmpty(parkingSpaceAmountModel.getPolicyId())) {
            //校验当前停车场是否具有某个优惠数据
            TbParkingPreferentialAreaCriteria areaCriteria = new TbParkingPreferentialAreaCriteria();
            areaCriteria.createCriteria().andAreaIdEqualTo(parkingSpaceAmountModel.getAreaId()).andPolicyIdEqualTo(parkingSpaceAmountModel.getPolicyId()).andRecordStatusEqualTo(new Byte(ParkingEnums.EFFECTIVE.getCode()));
            List<TbParkingPreferentialArea> tbParkingPreferentialAreas = tbParkingPreferentialAreaMapper.selectByExample(areaCriteria);
            if (null == tbParkingPreferentialAreas || tbParkingPreferentialAreas.size()==0) {
                throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_PREFERENTIAL_IS_NOT_EXIST);
            }

            TbParkingPreferential tbParkingPreferential = tbParkingPreferentialMapper.selectByPrimaryKey(parkingSpaceAmountModel.getPolicyId());
            //获取用户已租天数
            TbParkingSpaceRentalCriteria parkingSpaceRentalCriteria = new TbParkingSpaceRentalCriteria();
            parkingSpaceRentalCriteria.createCriteria().andApprovalStatusEqualTo(ParkingEnums.PARKING_SPACE_RENTAL_IS_PAYED.getCode()).andAccountEqualTo(account).andRecordStatusEqualTo(new Byte(ParkingEnums.EFFECTIVE.getCode()));
            List<TbParkingSpaceRental> tbParkingSpaceRentals = tbParkingSpaceRentalMapper.selectByExample(parkingSpaceRentalCriteria);
            int applyDay = 0;
            for (TbParkingSpaceRental parkingSpaceRental : tbParkingSpaceRentals) {
                applyDay += getDayInterval(parkingSpaceRental.getStartTime(), parkingSpaceRental.getEndTime());
            }

            if (null == tbParkingPreferential.getDayConditions() || (applyDay+dayInterval) > tbParkingPreferential.getDayConditions()) {
                logger.info("满足优惠条件，开始计算优惠金额，优惠政策{}，用户已租天数{}，本次租赁天数{}。", tbParkingPreferential.getPolicyCode(),applyDay, dayInterval);
                if (null != tbParkingPreferential.getOfferPrice() && 0 != tbParkingPreferential.getOfferPrice()) {
                    //减免固定金额
                    parkingSpaceAmountVo.setDeductionMoney(tbParkingPreferential.getOfferPrice());
                    parkingSpaceAmountVo.setActualMoney(new BigDecimal(Double.toString(dueMoney)).subtract(new BigDecimal(Double.toString(tbParkingPreferential.getOfferPrice()))).doubleValue());
                } else {
                    //按比例减免
                    BigDecimal divide = new BigDecimal(dueMoney).multiply(new BigDecimal(Double.toString(tbParkingPreferential.getOfferRatio()))).divide(new BigDecimal("100"),2,BigDecimal.ROUND_HALF_UP);
                    parkingSpaceAmountVo.setDeductionMoney(divide.doubleValue());
                    parkingSpaceAmountVo.setActualMoney(new BigDecimal(Double.toString(dueMoney)).subtract(divide).doubleValue());
                }
            } else {
                logger.info("不满足优惠条件，按原价计算，优惠政策{}，用户已租天数{}，本次租赁天数{}。", tbParkingPreferential.getPolicyCode(),applyDay, dayInterval);
                parkingSpaceAmountVo.setDeductionMoney(new Double(0));
                parkingSpaceAmountVo.setActualMoney(dueMoney);
            }
        } else {
            parkingSpaceAmountVo.setDeductionMoney(new Double(0));
            parkingSpaceAmountVo.setActualMoney(dueMoney);
        }
        return parkingSpaceAmountVo;
    }

    /**
     * 计算两时间间隔天数 [开始时间不能少于结束时间]
     *
     * @param startTime 开始时间 yyyy-MM-dd
     * @param endTime   结束时间 yyyy-MM-dd
     * @return
     */
    @ServiceLog(doAction = "计算两时间间隔天数")
    @Override
    public int getDayInterval(Date startTime, Date endTime) {
        int days = 0;
        Calendar can1 = Calendar.getInstance();
        can1.setTime(startTime);
        Calendar can2 = Calendar.getInstance();
        can2.setTime(endTime);
        int year1 = can1.get(Calendar.YEAR);
        int year2 = can2.get(Calendar.YEAR);
        //天数
        Calendar can = null;
        if (can1.before(can2)) {
            days -= can1.get(Calendar.DAY_OF_YEAR);
            days += can2.get(Calendar.DAY_OF_YEAR);
            can = can1;
        } else {
            throw new JnSpringCloudException(ParkingExceptionEnum.START_TIME_NOT_AFTER_END_TIME);
        }
        for (int i = 0; i < Math.abs(year2 - year1); i++) {
            //获取小的时间当前年的总天数
            days += can.getActualMaximum(Calendar.DAY_OF_YEAR);
            //再计算下一年。
            can.add(Calendar.YEAR, 1);
        }
        logger.info("时间查计算结果{}", days);
        return days;
    }



    @ServiceLog(doAction = "创建停车月卡缴费账单")
    @Override
    public String createParkingSpaceBill(String rentId,User user){
        TbParkingSpaceRental tbParkingSpaceRental = tbParkingSpaceRentalMapper.selectByPrimaryKey(rentId);
        if(null == tbParkingSpaceRental){
            throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_REND_IS_NOT_EXIST);
        }
        if(StringUtils.isNotEmpty(tbParkingSpaceRental.getOrderBillNum())){
            Result<PayBillVO> payBillDetailByIdOrNum = payBillClient.getPayBillDetailByIdOrNum(tbParkingSpaceRental.getOrderBillNum());
            PayBillVO data = payBillDetailByIdOrNum.getData();
            if(null != data && StringUtils.isNotEmpty(data.getBillId())){
                return data.getBillId();
            }
        }
        PaymentBillModel paymentBillModel = new PaymentBillModel();
        paymentBillModel.setBillNum("PK-"+ DateUtils.getDate(ParkingEnums.DATE_TIME_FORMAT_DATE_NUM.getCode())+ RandomUtils.nextInt(999));
        paymentBillModel.setBillName(tbParkingSpaceRental.getCarLicense()+"["+DateUtils.formatDate(tbParkingSpaceRental.getStartTime(),ParkingEnums.DATE_TIME_FORMAT_DATE.getCode())+"至"+DateUtils.formatDate(tbParkingSpaceRental.getEndTime(),ParkingEnums.DATE_TIME_FORMAT_DATE.getCode())+"月租卡");
        paymentBillModel.setBillType(ParkingEnums.PARKING_MONTH_BILL_TYPE.getCode());
        paymentBillModel.setBillObjId(user.getAccount());
        paymentBillModel.setBillObjName(user.getName());
        paymentBillModel.setBillAmount(tbParkingSpaceRental.getActualMoney());
        paymentBillModel.setPayEndTime(DateUtils.formatDate(DateUtils.addDays(new Date(),1),ParkingEnums.DATE_TIME_FORMAT.getCode()));
        paymentBillModel.setBillCreateAccount(user.getAccount());
        paymentBillModel.setBillRemark(ParkingEnums.PARKING_MONTH_BILL_TYPE_NAME.getCode());
        Result<String> bill = payBillClient.createBill(paymentBillModel);
        return bill.getData();
    }



}
