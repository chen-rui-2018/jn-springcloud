package com.jn.park.parking.service.impl;

import com.jn.SpringCloudParkApplication;
import com.jn.park.parking.model.ParkingRecordRampParam;
import com.jn.park.parking.service.ParkingServerService;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringCloudParkApplication.class})
@FixMethodOrder(MethodSorters.JVM)
public class ParkingServerServiceImplTest {
    private static Logger logger = LoggerFactory.getLogger(ParkingServerServiceImplTest.class);

    @Autowired
    private ParkingServerService parkingServerService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getParkingCarInfoList() {
    }

    @Test
    public void getParkingByCarLicense() {
    }

    @Test
    public void insterParkingRecordByRamp() {
        List<ParkingRecordRampParam> parkingRecordRampParam = new ArrayList<>(16);

        ParkingRecordRampParam param = new ParkingRecordRampParam();
        param.setGateId("258415618964243");
        param.setCarLicense("湘A00001");
        param.setAdmissionTime("2019-04-25 10:10:10");
        param.setDepartureTime("2019-04-25 15:10:10");
        ParkingRecordRampParam param1 = new ParkingRecordRampParam();
        param1.setGateId("258415618442413");
        param1.setCarLicense("湘A00002");
        param1.setAdmissionTime("2019-04-25 10:10:10");

        parkingRecordRampParam.add(param);
        parkingRecordRampParam.add(param1);

        int i = parkingServerService.insertParkingRecordByRamp(parkingRecordRampParam);
        logger.info("批量插入入参数据响应条数{}",i);
    }
    @Test
    public void updateParkingRecordByParam() {
        List<ParkingRecordRampParam> parkingRecordRampParam = new ArrayList<>(16);

        ParkingRecordRampParam param = new ParkingRecordRampParam();
        param.setGateId("258415618442413");
        param.setCarLicense("湘A00001");
        param.setAdmissionTime("2019-04-25 10:10:10");
        param.setDepartureTime("2019-04-25 18:10:10");
        param.setParkingStatus("0");
        ParkingRecordRampParam param1 = new ParkingRecordRampParam();
        param1.setGateId("258415618442413");
        param1.setCarLicense("湘A00001");
        param1.setAdmissionTime("2019-04-25 10:55:10");
        param1.setDepartureTime("2019-04-25 15:55:12");
        param1.setParkingStatus("1");
        parkingRecordRampParam.add(param);
        parkingRecordRampParam.add(param1);


        int i = parkingServerService.updateParkingRecordByParam(parkingRecordRampParam);
        logger.info("批量插入入参数据响应条数{}",i);
    }
}