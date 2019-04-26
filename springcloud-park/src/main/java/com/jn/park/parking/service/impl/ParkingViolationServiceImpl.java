package com.jn.park.parking.service.impl;

import com.jn.park.fileimg.service.FileImgService;
import com.jn.park.parking.dao.TbParkingViolationMapper;
import com.jn.park.parking.entity.TbParkingCarInfo;
import com.jn.park.parking.entity.TbParkingViolation;
import com.jn.park.parking.enums.ParkingEnums;
import com.jn.park.parking.model.ParkingViolationModel;
import com.jn.park.parking.service.ParkingCarInfoService;
import com.jn.park.parking.service.ParkingViolationService;
import com.jn.park.parking.vo.ParkingCarInfoVo;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/23 17:42
 * @version： v1.0
 * @modified By:
 */
@Service
public class ParkingViolationServiceImpl implements ParkingViolationService {
    private static Logger logger = LoggerFactory.getLogger(ParkingViolationServiceImpl.class);

    @Autowired
    private FileImgService fileImgService;
    @Autowired
    private ParkingCarInfoService parkingCarInfoService;
    @Autowired
    private TbParkingViolationMapper tbParkingViolationMapper;


    @ServiceLog(doAction = "保存车辆违停信息")
    @Override
    public String saveParkingViolation(ParkingViolationModel parkingViolationModel, String account){
        TbParkingViolation tbParkingViolation = new TbParkingViolation();
        tbParkingViolation.setReportId(UUID.randomUUID().toString().replaceAll("-",""));

        ParkingCarInfoVo carInfoByCarLicense = parkingCarInfoService.getCarInfoByCarLicense(parkingViolationModel.getCarLicense());
        if(null != carInfoByCarLicense){
            tbParkingViolation.setUserAccount(carInfoByCarLicense.getAccount());
            tbParkingViolation.setUserName(carInfoByCarLicense.getName());
            tbParkingViolation.setUserPhone(carInfoByCarLicense.getPhone());
            tbParkingViolation.setParkingInfo(carInfoByCarLicense.getParkingInfo());
        }
        tbParkingViolation.setParkingAddress(parkingViolationModel.getParkingAddress());
        tbParkingViolation.setCarPhone(parkingViolationModel.getCarPhone());
        int i = fileImgService.saveFileImgList(parkingViolationModel.getFileImgs(), account, tbParkingViolation.getReportId());
        logger.info("保存用户违停数据响应条数{}",i);
        //TODO 调用消息发送接口

        BeanUtils.copyProperties(parkingViolationModel,tbParkingViolation);

        tbParkingViolation.setCreatorAccount(account);
        tbParkingViolation.setCreatedTime(new Date());
        tbParkingViolation.setRecordStatus(new Byte(ParkingEnums.EFFECTIVE.getCode()));
        int insert = tbParkingViolationMapper.insert(tbParkingViolation);
        return insert+"";
    }

}
