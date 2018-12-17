package com.jn.park.parkCode.controller;

import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.comment.model.CommentAdd;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.enums.CommentExceptionEnum;
import com.jn.park.enums.ParkCodeExcptionEnum;
import com.jn.park.parkCode.entity.TbParkCode;
import com.jn.park.parkCode.service.ParkCodeService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
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
public class ParkCodeController {

    @Autowired
    private ParkCodeService parkCodeService;

    @ControllerLog(doAction = "查询园区字典")
    @ApiOperation(value = "查询园区字典", httpMethod = "POST", response = Result.class,
            notes = "codeType：查询的字典类型（例如查询园区列表,codeType=parkName）")
    @RequestMapping(value = "/getParkCodeByType")
    public Result getParkCodeByType(String codeType){
        Assert.notNull(codeType, ParkCodeExcptionEnum.CODE_TYPE_NOT_NULL.getMessage());
        List<TbParkCode> parkCodeByType = parkCodeService.getParkCodeByType(codeType);
        return new Result(parkCodeByType);
    }

}
