package com.jn.park.asset.service.impl;

import com.jn.common.model.Result;
import com.jn.park.asset.service.RoomInformationService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomInformationServiceImplTest {
    @Autowired
    private RoomInformationService roomInformationService;

    private static String billids ;

    @BeforeClass
    public static void init(){
        billids = "GD2019051600011,GD2019052300013";
    }

    @Test
    public void createBill(){

    }
    @Test
    public void createRoomOrderBillByOrder(){
        Result roomOrderBillByOrder = roomInformationService.createRoomOrderBillByOrder("2019061314373402306");
        assertThat(roomOrderBillByOrder,notNullValue());
    }

}
