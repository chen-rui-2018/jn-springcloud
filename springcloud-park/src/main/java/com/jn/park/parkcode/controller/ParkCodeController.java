package com.jn.park.parkcode.controller;


import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.enums.ParkCodeExceptionEnum;
import com.jn.park.model.ParkCode;
import com.jn.park.parkcode.service.ParkCodeService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import com.jn.park.parkcode.entity.TbParkCode;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation(value = "查询园区字典",
            notes = "codeType：查询的字典类型（例如查询园区列表,codeType=parkName）")
    @RequestMapping(value = "/getParkCodeByType",method = RequestMethod.POST)
    public Result<List<ParkCode>> getParkCodeByType(@ApiParam(name="codeType",value = "字典类型",required = true,example = "parkName")@RequestParam(value = "codeType") String codeType){
        Assert.notNull(codeType, ParkCodeExceptionEnum.CODE_TYPE_NOT_NULL.getMessage());
        List<ParkCode> parkCodeByType = parkCodeService.getParkCodeByType(codeType);
        return new Result(parkCodeByType);
    }

}
