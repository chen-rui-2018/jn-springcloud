package com.jn.park.parking.service.impl;

import com.jn.common.util.DateUtils;
import com.jn.park.parking.dao.ParkingRecordMapper;
import com.jn.park.parking.enums.ParkingEnums;
import com.jn.park.parking.model.ParkingRecordRampDetailParam;
import com.jn.park.parking.service.ParkingServerService;
import com.jn.park.parking.model.ParkingRecordRampParam;
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
            parkingRecordRampDetailParam.setParkingId(UUID.randomUUID().toString().replaceAll("-",""));
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
        //TODO 调用匝道通知车辆已开通月租卡
        //TODO 改变租赁数据状态
        return true;
    }

    @ServiceLog(doAction = "临时车支付成功回调接口")
    public Boolean parkingCarBillCallBack(String billNum){
        //TODO 调用匝道通知临时车已缴费

        //TODO 创建新的停车记录。缴费开始计算时间为缴费时间+15分钟
        return true;
    }

}
