package com.jn.enterprise.propaganda.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.enums.BusinessPromotionExceptionEnum;
import com.jn.enterprise.propaganda.model.*;
import com.jn.enterprise.propaganda.service.BusinessPromotionService;
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

import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/4/18 9:39
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "用户中心--企业宣传")
@RestController
@RequestMapping("/propaganda/businessPromotionController")
public class BusinessPromotionController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(BusinessPromotionController.class);

    @Autowired
    private BusinessPromotionService businessPromotionService;

    @ControllerLog(doAction = "企业宣传列表查询")
    @RequiresPermissions("/propaganda/businessPromotionController/getBusinessPromotionList")
    @ApiOperation(value = "企业宣传列表查询)")
    @RequestMapping(value = "/getBusinessPromotionList",method = RequestMethod.GET)
    public Result<PaginationData<List<BusinessPromotionListShow>>> getBusinessPromotionList(@Validated BusinessPromotionListParam businessPromotionListParam){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("企业宣传列表查询获取当前登录用户失败");
            return new Result(BusinessPromotionExceptionEnum.NETWORK_ANOMALY.getCode(),BusinessPromotionExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        return  new Result(businessPromotionService.getBusinessPromotionList(businessPromotionListParam,user.getAccount()));
    }

    @ControllerLog(doAction = "企业宣传详情")
    @RequiresPermissions("/propaganda/businessPromotionController/getBusinessPromotionDetails")
    @ApiOperation(value = "企业宣传详情)")
    @RequestMapping(value = "/getBusinessPromotionDetails",method = RequestMethod.GET)
    public Result<BusinessPromotionDetailsShow> getBusinessPromotionDetails(@ApiParam(value = "宣传id" ,required = true,example = "xxx123")
                                                                                @RequestParam("propagandaId") String propagandaId){
        return  new Result(businessPromotionService.getBusinessPromotionDetails(propagandaId));
    }

    @ControllerLog(doAction = "发布宣传")
    @RequiresPermissions("/propaganda/businessPromotionController/saveBusinessPromotion")
    @ApiOperation(value = "发布宣传)",notes = "返回值为响应数据条数，正常为1")
    @RequestMapping(value = "/saveBusinessPromotion",method = RequestMethod.POST)
    public Result<Integer> saveBusinessPromotion(@RequestBody @Validated BusinessPromotionDetailsParam businessPromotionDetailsParam){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("发布宣传获取当前登录用户失败");
            return new Result(BusinessPromotionExceptionEnum.NETWORK_ANOMALY.getCode(),BusinessPromotionExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        int responseNum=businessPromotionService.saveBusinessPromotion(businessPromotionDetailsParam,user.getAccount());
        return  new Result(responseNum);
    }

    @ControllerLog(doAction = "获取宣传费用规则")
    @RequiresPermissions("/propaganda/businessPromotionController/getPropagandaFeeRulesList")
    @ApiOperation(value = "获取宣传费用规则)",notes = "返回值为响应数据条数，正常为1")
    @RequestMapping(value = "/getPropagandaFeeRulesList",method = RequestMethod.GET)
    public Result<List<PropagandaFeeRulesShow>> getPropagandaFeeRulesList(){
        return  new Result(businessPromotionService.getPropagandaFeeRulesList());
    }

    @ControllerLog(doAction = "获取宣传类型")
    @RequiresPermissions("/propaganda/businessPromotionController/getPropagandaTypeList")
    @ApiOperation(value = "获取宣传类型)")
    @RequestMapping(value = "/getPropagandaTypeList",method = RequestMethod.GET)
    public Result<List<PropagandaTypeShow>> getPropagandaTypeList(){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("获取宣传类型获取当前登录用户失败");
            return new Result(BusinessPromotionExceptionEnum.NETWORK_ANOMALY.getCode(),BusinessPromotionExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        return  new Result(businessPromotionService.getPropagandaTypeList(user.getAccount()));
    }
}
