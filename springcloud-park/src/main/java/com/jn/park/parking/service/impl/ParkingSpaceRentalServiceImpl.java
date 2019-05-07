package com.jn.park.parking.service.impl;

import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.park.parking.dao.TbParkingPreferentialMapper;
import com.jn.park.parking.dao.TbParkingSpaceRentalMapper;
import com.jn.park.parking.entity.TbParkingPreferential;
import com.jn.park.parking.entity.TbParkingSpaceRental;
import com.jn.park.parking.enums.ParkingEnums;
import com.jn.park.parking.service.ParkingSpaceRentalService;
import com.jn.park.parking.vo.ParkingSpaceRentalVo;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 车位租赁
 * @author： jiangyl
 * @date： Created on 2019/4/18 17:41
 * @version： v1.0
 * @modified By:
 */
@Service
public class ParkingSpaceRentalServiceImpl implements ParkingSpaceRentalService {
    private static Logger logger = LoggerFactory.getLogger(ParkingSpaceRentalServiceImpl.class);
    @Autowired
    private TbParkingSpaceRentalMapper tbParkingSpaceRentalMapper;
    @Autowired
    private TbParkingPreferentialMapper tbParkingPreferentialMapper;


    @ServiceLog(doAction = "根据租赁ID查询租赁信息")
    @Override
    public ParkingSpaceRentalVo getParkingSpaceDetailById(String rentId){
        TbParkingSpaceRental tbParkingSpaceRental = tbParkingSpaceRentalMapper.selectByPrimaryKey(rentId);
        if(null == tbParkingSpaceRental){
            logger.info("根据租赁ID查询租赁信息:未查询到相关车位租赁数据，rentId：{}",rentId);
        }
        ParkingSpaceRentalVo parkingSpaceRentalVo = new ParkingSpaceRentalVo();
        if(StringUtils.isNotEmpty(tbParkingSpaceRental.getPolicyId())){
            TbParkingPreferential tbParkingPreferential = tbParkingPreferentialMapper.selectByPrimaryKey(tbParkingSpaceRental.getPolicyId());
            BeanUtils.copyProperties(tbParkingPreferential,parkingSpaceRentalVo);
        }
        BeanUtils.copyProperties(tbParkingSpaceRental,parkingSpaceRentalVo);
        parkingSpaceRentalVo.setStartTime(null==tbParkingSpaceRental.getStartTime()?"": DateUtils.formatDate(tbParkingSpaceRental.getStartTime(), ParkingEnums.DATE_TIME_FORMAT_DATE.getCode()));
        parkingSpaceRentalVo.setEndTime(null==tbParkingSpaceRental.getEndTime()?"": DateUtils.formatDate(tbParkingSpaceRental.getEndTime(), ParkingEnums.DATE_TIME_FORMAT_DATE.getCode()));
        return parkingSpaceRentalVo;
    }

}
