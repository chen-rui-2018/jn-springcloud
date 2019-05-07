package com.jn.park.parking.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.park.enums.ParkingExceptionEnum;
import com.jn.park.parking.dao.ParkingCarInfoMapper;
import com.jn.park.parking.dao.TbParkingAreaMapper;
import com.jn.park.parking.dao.TbParkingCarInfoMapper;
import com.jn.park.parking.dao.TbParkingRecordMapper;
import com.jn.park.parking.entity.*;
import com.jn.park.parking.enums.ParkingEnums;
import com.jn.park.parking.model.ParkingCarInfoModel;
import com.jn.park.parking.model.ParkingCarInfoParam;
import com.jn.park.parking.model.ParkingRecordParam;
import com.jn.park.parking.model.ParkingRecordRampParam;
import com.jn.park.parking.service.ParkingCarInfoService;
import com.jn.park.parking.service.ParkingServerService;
import com.jn.park.parking.service.ParkingTemporaryService;
import com.jn.park.parking.vo.*;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.apache.ibatis.annotations.Param;
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
 * 车辆管理
 *
 * @author： jiangyl
 * @date： Created on 2019/04/19 17:09
 * @version： v1.0
 * @modified By:
 */
@Service
public class ParkingCarInfoServiceImpl implements ParkingCarInfoService {
    private static Logger logger = LoggerFactory.getLogger(ParkingCarInfoServiceImpl.class);

    @Autowired
    private ParkingCarInfoMapper parkingCarInfoMapper;
    @Autowired
    private TbParkingCarInfoMapper tbParkingCarInfoMapper;
    @Autowired
    private TbParkingRecordMapper tbParkingRecordMapper;
    @Autowired
    private ParkingServerService parkingServerService;
    @Autowired
    private TbParkingAreaMapper tbParkingAreaMapper;
    @Autowired
    private ParkingTemporaryService parkingTemporaryService;

    @ServiceLog(doAction = "查询车辆列表")
    @Override
    public PaginationData<List<ParkingCarInfoVo>> getCarInfoList(ParkingCarInfoParam parkingCarInfoParam) {
        Page<Object> objects = PageHelper.startPage(parkingCarInfoParam.getPage(), parkingCarInfoParam.getRows() == 0 ? 15 : parkingCarInfoParam.getRows());
        List<ParkingCarInfoVo> carInfoList = parkingCarInfoMapper.getCarInfoList(parkingCarInfoParam);
        PaginationData<List<ParkingCarInfoVo>> data = new PaginationData(carInfoList, objects.getTotal());
        return data;
    }

    @ServiceLog(doAction = "查询当前用户车辆列表")
    @Override
    public PaginationData<List<ParkingCarInfoVo>> getCarInfoListByNowUser(String account, com.jn.common.model.Page page) {
        if (StringUtils.isEmpty(account)) {
            throw new JnSpringCloudException(ParkingExceptionEnum.USER_LOGIN_INVALID);
        }
        Page<Object> objects = PageHelper.startPage(page.getPage(), page.getRows() == 0 ? 15 : page.getRows());
        ParkingCarInfoParam parkingCarInfoParam = new ParkingCarInfoParam();
        parkingCarInfoParam.setAccount(account);
        List<ParkingCarInfoVo> carInfoList = parkingCarInfoMapper.getCarInfoList(parkingCarInfoParam);
        PaginationData<List<ParkingCarInfoVo>> data = new PaginationData(carInfoList, objects.getTotal());
        return data;
    }

    @ServiceLog(doAction = "查询当前用户车辆统计数据")
    @Override
    public ParkingUserCarInfoCountVo getUserCarInfoCount(@Param(value = "userAccount") String userAccount) {
        if (StringUtils.isEmpty(userAccount)) {
            throw new JnSpringCloudException(ParkingExceptionEnum.USER_LOGIN_INVALID);
        }
        return parkingCarInfoMapper.getUserCarInfoCount(userAccount);
    }

    @ServiceLog(doAction = "新增用户车辆")
    @Override
    public String saveCarInfo(ParkingCarInfoModel userCar, User user) {
        if (StringUtils.isEmpty(userCar.getName())) {
            userCar.setName(user.getName());
        }
        if (StringUtils.isEmpty(userCar.getPhone())) {
            userCar.setPhone(user.getPhone());
        }
        TbParkingCarInfo tbParkingCarInfo = new TbParkingCarInfo();
        BeanUtils.copyProperties(userCar, tbParkingCarInfo);
        tbParkingCarInfo.setCarId(UUID.randomUUID().toString().replace("-", ""));
        tbParkingCarInfo.setCarStatus(ParkingEnums.PARKING_USER_CAR_INFO_EFFECTIVE.getCode());
        tbParkingCarInfo.setAccount(user.getAccount());
        tbParkingCarInfo.setCreatorAccount(user.getAccount());
        tbParkingCarInfo.setCreatedTime(new Date());
        tbParkingCarInfo.setRecordStatus(new Byte(ParkingEnums.EFFECTIVE.getCode()));
        int insert = tbParkingCarInfoMapper.insert(tbParkingCarInfo);
        return insert + "";
    }

    @ServiceLog(doAction = "删除本人车辆")
    @Override
    public String deleteCarInfoByUser(String account, String carId) {
        TbParkingCarInfo tbParkingCarInfo = tbParkingCarInfoMapper.selectByPrimaryKey(carId);
        if (null == tbParkingCarInfo) {
            throw new JnSpringCloudException(ParkingExceptionEnum.USER_CAR_IS_NOT_EXIT);
        }
        if (!StringUtils.equals(tbParkingCarInfo.getAccount(), account)) {
            throw new JnSpringCloudException(ParkingExceptionEnum.USER_CAR_CANT_DELETE_OTHER_CAR);
        }
        tbParkingCarInfo.setCarStatus(ParkingEnums.PARKING_USER_CAR_INFO_DELETED.getCode());
        tbParkingCarInfo.setModifiedTime(new Date());
        tbParkingCarInfo.setModifierAccount(account);
        int i = tbParkingCarInfoMapper.updateByPrimaryKeySelective(tbParkingCarInfo);
        return i + "";
    }


    @ServiceLog(doAction = "根据车牌号查询车辆信息")
    @Override
    public ParkingCarInfoVo getCarInfoByCarLicense(String carLicense) {
        ParkingCarInfoParam parkingCarInfoParam = new ParkingCarInfoParam();
        parkingCarInfoParam.setCarLicense(carLicense);
        List<ParkingCarInfoVo> carInfoList = parkingCarInfoMapper.getCarInfoList(parkingCarInfoParam);
        if (null == carInfoList || carInfoList.size() == 0) {
            return null;
        }
        return carInfoList.get(0);
    }

    @ServiceLog(doAction = "查询车辆停车记录")
    @Override
    public PaginationData<List<ParkingRecordVo>> getCarParkingRecordList(ParkingRecordParam parkingRecordParam){
        Page<Object> objects = PageHelper.startPage(parkingRecordParam.getPage(), parkingRecordParam.getRows() == 0 ? 15 : parkingRecordParam.getRows());

        TbParkingRecordCriteria recordCriteria = new TbParkingRecordCriteria();
        TbParkingRecordCriteria.Criteria criteria = recordCriteria.createCriteria().andRecordStatusEqualTo(new Byte(ParkingEnums.EFFECTIVE.getCode()));
        recordCriteria.setOrderByClause("admission_time desc");
        if(StringUtils.isNotEmpty(parkingRecordParam.getCarLicense())){
            criteria.andCarLicenseEqualTo(parkingRecordParam.getCarLicense());
        }
        try {
            if(StringUtils.isNotEmpty(parkingRecordParam.getStartTime())){
                Date startTime = DateUtils.parseDate(parkingRecordParam.getStartTime()+" 00:00:00", ParkingEnums.DATE_TIME_FORMAT.getCode());
                criteria.andAdmissionTimeGreaterThanOrEqualTo(startTime);
            }
            if(StringUtils.isNotEmpty(parkingRecordParam.getEndTime())){
                Date endTime = DateUtils.parseDate(parkingRecordParam.getEndTime()+" 23:59:59", ParkingEnums.DATE_TIME_FORMAT.getCode());
                criteria.andAdmissionTimeLessThanOrEqualTo(endTime);
            }
        }catch (ParseException e){
            throw new JnSpringCloudException(ParkingExceptionEnum.DAY_INTERVAL_ERROR);
        }

        List<TbParkingRecord> tbParkingRecords = tbParkingRecordMapper.selectByExample(recordCriteria);

        List<ParkingRecordVo> parkingRecordVos = new ArrayList<>(16);
        for (TbParkingRecord parkingRecord:
            tbParkingRecords) {
            ParkingRecordVo parkingRecordVo = new ParkingRecordVo();
            BeanUtils.copyProperties(parkingRecord,parkingRecordVo);
            parkingRecordVo.setAdmissionTime((null == parkingRecord.getAdmissionTime())?null:DateUtils.formatDate(parkingRecord.getAdmissionTime(),ParkingEnums.DATE_TIME_FORMAT.getCode()));
            parkingRecordVo.setDepartureTime((null == parkingRecord.getDepartureTime())?null:DateUtils.formatDate(parkingRecord.getDepartureTime(),ParkingEnums.DATE_TIME_FORMAT.getCode()));
            parkingRecordVo.setPaymentTime((null == parkingRecord.getPaymentTime())?null:DateUtils.formatDate(parkingRecord.getPaymentTime(),ParkingEnums.DATE_TIME_FORMAT.getCode()));
            parkingRecordVo.setPayTime((null == parkingRecord.getPayTime())?null:DateUtils.formatDate(parkingRecord.getPayTime(),ParkingEnums.DATE_TIME_FORMAT.getCode()));
            if(StringUtils.isEmpty(parkingRecord.getParkingTime())){
                if(null == parkingRecord.getDepartureTime() ){
                    parkingRecordVo.setParkingTime(getTimeDifference(parkingRecord.getAdmissionTime(),new Date()));
                }else{
                    parkingRecordVo.setParkingTime(getTimeDifference(parkingRecord.getAdmissionTime(),parkingRecord.getDepartureTime()));
                }
            }
            parkingRecordVos.add(parkingRecordVo);
        }
        //调用匝道接口查询最新数据
        ParkingRecordRampParam parkingByCarLicense = parkingServerService.getParkingByCarLicense(parkingRecordParam.getCarLicense());
        if(null != parkingByCarLicense){
            if(null == tbParkingRecords || tbParkingRecords.size()==0 || StringUtils.equals(parkingByCarLicense.getAdmissionTime()
                    ,DateUtils.formatDate(tbParkingRecords.get(0).getAdmissionTime(),ParkingEnums.DATE_TIME_FORMAT.getCode()))){
                ParkingRecordVo parkingRecordVo = new ParkingRecordVo();
                BeanUtils.copyProperties(parkingByCarLicense,parkingRecordVo);
                try{
                    if(StringUtils.isEmpty(parkingByCarLicense.getDepartureTime()) ){
                        parkingRecordVo.setParkingTime(getTimeDifference(DateUtils.parseDate(parkingByCarLicense.getAdmissionTime(),ParkingEnums.DATE_TIME_FORMAT.getCode()),new Date()));
                    }else{
                        parkingRecordVo.setParkingTime(getTimeDifference(DateUtils.parseDate(parkingByCarLicense.getAdmissionTime(),ParkingEnums.DATE_TIME_FORMAT.getCode())
                                ,DateUtils.parseDate(parkingByCarLicense.getDepartureTime(),ParkingEnums.DATE_TIME_FORMAT.getCode())));
                    }
                }catch (ParseException e){
                    throw new JnSpringCloudException(ParkingExceptionEnum.DAY_INTERVAL_ERROR);
                }
                TbParkingAreaCriteria areaCriteria = new TbParkingAreaCriteria();
                areaCriteria.createCriteria().andGateIdEqualTo(parkingByCarLicense.getGateId());
                List<TbParkingArea> tbParkingAreas = tbParkingAreaMapper.selectByExample(areaCriteria);
                if(null!=tbParkingAreas&&tbParkingAreas.size()>0){
                    parkingRecordVo.setAreaName(tbParkingAreas.get(0).getAreaName());
                }
                parkingRecordVos.add(parkingRecordVo);
            }
        }

        PaginationData<List<ParkingRecordVo>> data = new PaginationData(parkingRecordVos, objects.getTotal());
        return data;
    }

    @Override
    public String getTimeDifference(Date beginTime,Date endTime){
        long diff = endTime.getTime() - beginTime.getTime();
        long days = diff / (1000 * 60 * 60 * 24);

        long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
        long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);

        StringBuilder sb = new StringBuilder();
        if(days !=0 ){
            sb.append(days+"天");
        }
        if(hours !=0 ){
            sb.append(hours+"小时");
        }
        sb.append(minutes+"分钟");
        return sb.toString();
    }

    @ServiceLog(doAction = "查询临停缴费车辆数据详情")
    @Override
    public ParkingRecordDetailVo getCarTempParkingDetail(String carLicense){
        ParkingRecordDetailVo parkingRecordDetailVo = new ParkingRecordDetailVo();

        TbParkingRecordCriteria recordCriteria = new TbParkingRecordCriteria();
        recordCriteria.createCriteria().andCarLicenseEqualTo(carLicense).andParkingStatusEqualTo(ParkingEnums.CAR_IS_IN_PARKING.getCode());
        recordCriteria.setOrderByClause("created_time desc");
        List<TbParkingRecord> parkingRecords = tbParkingRecordMapper.selectByExample(recordCriteria);
        String areaId = "";
        String gateId = "";

        if(null!=parkingRecords&&parkingRecords.size()>0){
            areaId = parkingRecords.get(0).getAreaId();
            BeanUtils.copyProperties(parkingRecords.get(0),parkingRecordDetailVo);
            parkingRecordDetailVo.setAdmissionTime(DateUtils.formatDate(parkingRecords.get(0).getAdmissionTime(),ParkingEnums.DATE_TIME_FORMAT.getCode()));
        }else{
            //数据库无数据，调用道闸接口查询，避免数据遗落
            ParkingRecordRampParam parkingByCarLicense = parkingServerService.getParkingByCarLicense(carLicense);
            gateId = parkingByCarLicense.getGateId();
            BeanUtils.copyProperties(parkingByCarLicense,parkingRecordDetailVo);
        }
        if(StringUtils.isEmpty(areaId)&&StringUtils.isEmpty(gateId)){
            throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_RECODE_IS_NOT_EXIST);
        }

        TbParkingAreaCriteria areaCriteria = new TbParkingAreaCriteria();
        areaCriteria.createCriteria().andAreaIdEqualTo(areaId);
        TbParkingAreaCriteria areaCriteria1 = new TbParkingAreaCriteria();
        TbParkingAreaCriteria.Criteria criteria1 = areaCriteria1.createCriteria().andGateIdEqualTo(gateId);
        areaCriteria.or(criteria1);
        List<TbParkingArea> tbParkingAreas = tbParkingAreaMapper.selectByExample(areaCriteria);
        if(null!=tbParkingAreas&&tbParkingAreas.size()>0){
            parkingRecordDetailVo.setAreaName(tbParkingAreas.get(0).getAreaName());
            parkingRecordDetailVo.setAreaAddress(tbParkingAreas.get(0).getAreaAddress());
        }

        if(null!=parkingRecords&&parkingRecords.size()>0 && null!=parkingRecords.get(0).getStartBillingTime() && DateUtils.addMinutes(parkingRecords.get(0).getCreatedTime(), 15).after(new Date())){
            //说明用户已缴费，且当前未满15分钟，不返回对应的停车记录
            throw new JnSpringCloudException(ParkingExceptionEnum.PARKING_CAR_IS_PAYMENT);
        }
        Double aDouble = parkingTemporaryService.calculateParkingAmount(parkingRecords.get(0));
        parkingRecordDetailVo.setParkingAmount(aDouble);
        try{
            String timeDifference = getTimeDifference(DateUtils.parseDate(parkingRecordDetailVo.getAdmissionTime(), ParkingEnums.DATE_TIME_FORMAT.getCode()), new Date());
            parkingRecordDetailVo.setParkingTime(timeDifference);
        }catch (ParseException e){
            logger.error("停车时间计算转换异常",e);
        }
        return parkingRecordDetailVo;
    }


}
