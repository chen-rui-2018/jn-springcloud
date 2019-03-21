package com.jn.enterprise.joinpark.org.controller;

import com.jn.common.model.Result;
import com.jn.enterprise.joinpark.org.service.OrgJoinService;
import com.jn.enterprise.servicemarket.org.model.OrgDetailParameter;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/4 11:08
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "加入园区-机构认证")
@RestController
@RequestMapping("/guest/orgJoinPark")
public class OrgJoinController {

    private static Logger logger = LoggerFactory.getLogger(OrgJoinController.class);

    @Autowired
    private OrgJoinService orgJoinService;


    @ControllerLog(doAction = "保存/修改机构认证信息")
    @ApiOperation(value = "保存/修改机构认证信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/saveOrUpdateOrgDetail")
    public Result saveOrUpdateOrgDetail(@RequestBody @Validated OrgDetailParameter orgDetailParameter) {
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = orgJoinService.saveOrUpdateOrgDetail(orgDetailParameter,user.getAccount());
        logger.info("保存/修改机构认证信息成功，响应条数{}",i);
        return new Result(i);
    }


}
