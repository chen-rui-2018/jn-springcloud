package com.jn.hardware.parking.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jn.common.model.Result;
import com.jn.common.util.RestTemplateUtil;
import com.jn.common.util.StringUtils;
import com.jn.hardware.enums.ParkingExceptionEnum;
import com.jn.hardware.model.parking.door.DoorResult;
import com.jn.hardware.model.parking.door.DoorTemporaryCarParkingFeeRequest;
import com.jn.hardware.parking.service.ParkingService;
import com.jn.hardware.util.JsonStringToObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * TODO：未添加类描述
 *
 * @Author： cm
 * @Date： Created on 2019/4/17 17:22
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class ParkingServiceImpl implements ParkingService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 临停预缴费信息(场内缴费)查询
     * @param doorTemporaryCarParkingFeeRequest
     * @return
     */
    @Override
    public Result getTemporaryCarParkingFee(DoorTemporaryCarParkingFeeRequest doorTemporaryCarParkingFeeRequest) {
        Result result=new Result();
        String url = "";
        if(null!=doorTemporaryCarParkingFeeRequest && StringUtils.isNotBlank(doorTemporaryCarParkingFeeRequest.getParkid())) {
            //调用道尔硬件接口
            url = String.format(ParkingService.GET_DOOR_TEMPORARYCAR_PARKINGFEE_URL,doorTemporaryCarParkingFeeRequest.getParkid());
            String responseString = RestTemplateUtil.get(url);
            DoorResult<DoorTemporaryCarParkingFeeRequest> doorResult = JsonStringToObjectUtil.jsonToObject(responseString,new TypeReference<DoorResult<DoorTemporaryCarParkingFeeRequest>>(){});
            if(DoorResult.SUCCESS_CODE.equals(doorResult.getHead().getStatus())) {
                result.setData(doorResult.getBody());
            }else {
                result.setCode(ParkingExceptionEnum.DOOR_COMPANY_EXCEPTION.getCode());
                result.setResult(doorResult.getHead().getMessage());
            }
            logger.info("\n道尔的临停预缴费信息(场内缴费)查询结果{}",doorResult);
        }else {
            result.setCode(ParkingExceptionEnum.MISSING_PARK_ID.getCode());
            result.setResult(ParkingExceptionEnum.MISSING_PARK_ID.getMessage());
            logger.info("\n道尔的临停预缴费信息(场内缴费)查询失败，原因：{}",ParkingExceptionEnum.MISSING_PARK_ID.getMessage());
        }
        return result;
    }

}
