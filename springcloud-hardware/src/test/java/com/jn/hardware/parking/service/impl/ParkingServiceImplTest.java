package com.jn.hardware.parking.service.impl;

import com.jn.common.model.Result;
import com.jn.hardware.enums.ParkingCompanyEnum;
import com.jn.hardware.model.parking.TemporaryCarParkingFeeRequest;
import com.jn.hardware.model.parking.door.DoorTemporaryCarParkingFeeRequest;
import com.jn.hardware.parking.service.ParkingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingServiceImplTest {
    Logger logger = LoggerFactory.getLogger(ParkingServiceImplTest.class);

    @Autowired
    private ParkingService parkingService;

    @Test
    public void getTemporaryCarParkingFee() {
        TemporaryCarParkingFeeRequest temporaryCarParkingFeeRequest = new TemporaryCarParkingFeeRequest();
        temporaryCarParkingFeeRequest.setParkingCompanyId(ParkingCompanyEnum.DOOR_COMPANY.getCode());
        DoorTemporaryCarParkingFeeRequest doorTemporaryCarParkingFeeRequest = new DoorTemporaryCarParkingFeeRequest();
        doorTemporaryCarParkingFeeRequest.setParkid("1");
        doorTemporaryCarParkingFeeRequest.setCarNo("粤A12345");
        temporaryCarParkingFeeRequest.setDoorTemporaryCarParkingFeeRequest(doorTemporaryCarParkingFeeRequest);
        Result result = parkingService.getTemporaryCarParkingFee(temporaryCarParkingFeeRequest);
        logger.info("\n查询结果说明：{}",result.getResult());
    }
}