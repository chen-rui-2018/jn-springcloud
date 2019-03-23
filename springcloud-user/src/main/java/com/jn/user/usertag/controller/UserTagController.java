package com.jn.user.usertag.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.user.userjoin.enums.UserJoinExceptionEnum;
import com.jn.user.usertag.model.TagCode;
import com.jn.user.usertag.service.UserTagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户标签
 * @author： jiangyl
 * @date： Created on 2019/3/6 16:47
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "用户标签")
@RestController
@RequestMapping("/guest/userTag")
public class UserTagController extends BaseController {

    @Autowired
    private UserTagService userTagService;

    @ControllerLog(doAction = "获取用户字典列表")
    @ApiOperation(value = "获取用户字典列表",httpMethod = "POST",response = Result.class)
    @RequestMapping(value = "/getTagCodeList")
    public Result<List<TagCode>> getTagCodeList(){
        List<TagCode> tagCodeList = userTagService.getTagCodeList();
        return new Result(tagCodeList);
    }

}
