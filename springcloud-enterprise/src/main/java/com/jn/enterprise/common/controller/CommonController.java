package com.jn.enterprise.common.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.common.enums.CommonExceptionEnum;
import com.jn.enterprise.common.service.CommonService;
import com.jn.enterprise.common.vo.CodeVO;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author： huxw
 * @date： Created on 2019-4-3 14:52:40
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "企业服务-公共")
@RestController
@RequestMapping("/guest/CommonController")
public class CommonController extends BaseController {

    @Autowired
    private CommonService codeService;

    @ControllerLog(doAction = "码表-数据列表")
    @ApiOperation(value = "码表-数据列表", notes = "根据分组ID获取数据列表")
    @RequestMapping(value = "/getServiceCodeList",method = RequestMethod.GET)
    public Result<List<CodeVO>> getRecruitList(@Validated @RequestParam @ApiParam(name="groupId",value = "分组ID", required = true) String groupId){
        Assert.notNull(groupId, CommonExceptionEnum.CODE_GROUP_ID_IS_NULL.getMessage());
        return new Result(codeService.getCodeList(groupId));
    }

}
