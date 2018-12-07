package com.jn.portals.user.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.portals.user.service.SildeValidationService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 滑动验证
 * @Author: yangph
 * @Date: 2018/11/30 16:59
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "滑动验证图片生成、滑动结果验证")
@RestController
public class SildeValidationController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(SildeValidationController.class);

    @Autowired
    private SildeValidationService sildeValidationService;

    @ControllerLog(doAction = "滑动验证图片生成")
    @ApiOperation(value = "滑动验证图片生成", httpMethod = "POST", response = Result.class,
                  notes="oriWidth：源文件宽度，默认为590,传递的值为1-885 有效，其余值无效，使用默认值    " +
                        "oriHeight：源文件高度，默认为360,传递值为1-540 有效，其余值无效，使用默认值")
    @RequestMapping(value = "/guest/slideValidation")
    public Result slideValidation(String oriWidth, String oriHeight){
        Result result = sildeValidationService.slideValidation(oriWidth, oriHeight);
        return  result;
    }

    @ControllerLog(doAction = "校验前端滑动操作结果")
    @ApiOperation(value = "校验前端滑动操作结果",notes = "verifyKey:校验key    xCoord：x移动距离",
                 httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/guest/verificationOption")
    public Result verificationOption(String verifyKey, String xCoord){
        Result result = sildeValidationService.verificationOption(verifyKey, xCoord);
        return  result;
    }
}
