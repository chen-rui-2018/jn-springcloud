package com.jn.enterprise.joinpark.org.controller;

import com.codingapi.tx.annotation.TxTransaction;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.company.model.IBPSResult;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.joinpark.org.service.OrgJoinService;
import com.jn.enterprise.servicemarket.advisor.model.OrgNameIsExistParam;
import com.jn.enterprise.servicemarket.org.model.OrgDetailParameter;
import com.jn.enterprise.servicemarket.org.model.OrgDetailUpdateParameter;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/4 11:08
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "加入园区-机构认证")
@RestController
@RequestMapping("/orgJoinPark")
public class OrgJoinController {

    private static Logger logger = LoggerFactory.getLogger(OrgJoinController.class);

    @Autowired
    private OrgJoinService orgJoinService;

    @ControllerLog(doAction = "保存/修改机构认证信息")
    @ApiOperation(value = "保存/修改机构认证信息", notes = "返回数据响应条数，正常情况为1")
    @RequiresPermissions("/orgJoinPark/saveOrUpdateOrgDetail")
    @RequestMapping(value = "/saveOrUpdateOrgDetail",method = RequestMethod.POST)
    public Result<Integer> saveOrUpdateOrgDetail(@RequestBody @Validated OrgDetailParameter orgDetailParameter) {
        logger.info("进入保存/修改机构认证信息API,入参信息：{}",orgDetailParameter.toString());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        IBPSResult ibpsResult = orgJoinService.saveOrUpdateOrgDetail(orgDetailParameter, user.getAccount());
        return new Result(ibpsResult);
    }


    @ControllerLog(doAction = "判断机构名称是否已存在")
    @ApiOperation(value = "判断机构名称是否已存在", notes = "返回结果，orgNameExist:已存在   orgNameNotExist:不存在")
    @RequiresPermissions("/orgJoinPark/orgNameIsExist")
    @RequestMapping(value = "/orgNameIsExist",method = RequestMethod.GET)
    public Result<String> orgNameIsExist(@Validated OrgNameIsExistParam orgParam) {
        return new Result( orgJoinService.orgNameIsExist(orgParam));
    }

}
