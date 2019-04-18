package com.jn.hardware.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.hardware.api.ParkingClient;
import com.jn.hardware.model.parking.TemporaryCarParkingFeeRequest;
import com.jn.hardware.parking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO：未添加类描述
 *
 * @Author： cm
 * @Date： Created on 2019/4/17 16:06
 * @Version： v1.0
 * @Modified By:
 */
@RestController
public class ParkingController extends BaseController implements ParkingClient {

    @Autowired
    private ParkingService parkingService;

    @Override
    public Result getTemporaryCarParkingFee(@RequestBody TemporaryCarParkingFeeRequest temporaryCarParkingFeeRequest) {
        parkingService.getTemporaryCarParkingFee(temporaryCarParkingFeeRequest);
        return null;
    }
}
