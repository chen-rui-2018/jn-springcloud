package com.jn.park.parkcode.controller;


import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.enums.ParkCodeExceptionEnum;
import com.jn.park.parkcode.service.ParkCodeService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import com.jn.park.parkcode.entity.TbParkCode;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 园区字典
 *
 * @author： jiangyl
 * @date： Created on 2018/12/17 10:26
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "园区字典表")
@RestController
@RequestMapping(value = "/parkCode")
public class ParkCodeController  {

    @Autowired
    private ParkCodeService parkCodeService;

    @ControllerLog(doAction = "查询园区字典")
    @ApiOperation(value = "查询园区字典", httpMethod = "POST", response = Result.class,
            notes = "codeType：查询的字典类型（例如查询园区列表,codeType=parkName）")
    @RequestMapping(value = "/getParkCodeByType")
    public Result getParkCodeByType(String codeType){
        Assert.notNull(codeType, ParkCodeExceptionEnum.CODE_TYPE_NOT_NULL.getMessage());
        List<TbParkCode> parkCodeByType = parkCodeService.getParkCodeByType(codeType);
        return new Result(parkCodeByType);
    }

}
