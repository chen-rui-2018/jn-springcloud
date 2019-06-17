package com.jn.enterprise.propaganda.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
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
import org.json.simple.JSONObject;
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
    @ApiOperation(value = "(企业宣传列表查询)")
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
    @ApiOperation(value = "(企业宣传详情)")
    @RequestMapping(value = "/getBusinessPromotionDetails",method = RequestMethod.GET)
    public Result<BusinessPromotionDetailsShow> getBusinessPromotionDetails(@ApiParam(value = "宣传id" ,required = true,example = "xxx123")
                                                                                @RequestParam("propagandaId") String propagandaId){
        return  new Result(businessPromotionService.getBusinessPromotionDetails(propagandaId));
    }

    @ControllerLog(doAction = "发布宣传")
    @RequiresPermissions("/propaganda/businessPromotionController/saveBusinessPromotion")
    @ApiOperation(value = "(发布宣传)",notes = "返回值为响应数据条数，正常为1")
    @RequestMapping(value = "/saveBusinessPromotion",method = RequestMethod.POST)
    public Result<Integer> saveBusinessPromotion(@RequestBody @Validated BusinessPromotionDetailsParam businessPromotionDetailsParam){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("发布宣传获取当前登录用户失败");
            return new Result(BusinessPromotionExceptionEnum.NETWORK_ANOMALY.getCode(),BusinessPromotionExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        int responseNum=businessPromotionService.saveBusinessPromotion(businessPromotionDetailsParam,user.getAccount());
        logger.info("-----发布宣传成功，数据响应条数：{{}}------",responseNum);
        return  new Result(responseNum);
    }

    @ControllerLog(doAction = "获取宣传费用规则")
    @RequiresPermissions("/propaganda/businessPromotionController/getPropagandaFeeRulesList")
    @ApiOperation(value = "(获取宣传费用规则)",notes = "返回值为响应数据条数，正常为1")
    @RequestMapping(value = "/getPropagandaFeeRulesList",method = RequestMethod.GET)
    public Result<List<PropagandaFeeRulesShow>> getPropagandaFeeRulesList(){
        return  new Result(businessPromotionService.getPropagandaFeeRulesList());
    }

    @ControllerLog(doAction = "获取宣传类型")
    @RequiresPermissions("/propaganda/businessPromotionController/getPropagandaTypeList")
    @ApiOperation(value = "(获取宣传类型)")
    @RequestMapping(value = "/getPropagandaTypeList",method = RequestMethod.GET)
    public Result<List<PropagandaTypeShow>> getPropagandaTypeList(){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("获取宣传类型获取当前登录用户失败");
            return new Result(BusinessPromotionExceptionEnum.NETWORK_ANOMALY.getCode(),BusinessPromotionExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        return  new Result(businessPromotionService.getPropagandaTypeList(user.getAccount()));
    }

    @ControllerLog(doAction = "撤销申请")
    @RequiresPermissions("/propaganda/businessPromotionController/cancelApprove")
    @ApiOperation(value = "(撤销申请)",notes ="propagandaId:宣传id,返回数据响应条数，正常为1" )
    @RequestMapping(value = "/cancelApprove",method = RequestMethod.POST)
    public Result<Integer> cancelApprove(String propagandaId){
        Assert.notNull(propagandaId, BusinessPromotionExceptionEnum.PROPAGANDA_ID_NOT_NULL.getMessage());
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("取消申请获取当前登录用户失败");
            return new Result(BusinessPromotionExceptionEnum.NETWORK_ANOMALY.getCode(),BusinessPromotionExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        return  new Result(businessPromotionService.cancelApprove(propagandaId,user.getAccount()));
    }

    @ControllerLog(doAction = "修改企业宣传")
    @RequiresPermissions("/propaganda/businessPromotionController/updateBusinessPromotion")
    @ApiOperation(value = "(修改企业宣传)",notes ="propagandaId:宣传id,返回数据响应条数，正常为1" )
    @RequestMapping(value = "/updateBusinessPromotion",method = RequestMethod.POST)
    public Result<Integer> updateBusinessPromotion(@RequestBody @Validated BusinessPromotionDetailsParam businessPromotionDetailsParam){
        Assert.notNull(businessPromotionDetailsParam.getId(), BusinessPromotionExceptionEnum.PROPAGANDA_ID_NOT_NULL.getMessage());
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("修改企业宣传获取当前登录用户失败");
            return new Result(BusinessPromotionExceptionEnum.NETWORK_ANOMALY.getCode(),BusinessPromotionExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        int responseNum=businessPromotionService.updateBusinessPromotion(businessPromotionDetailsParam,user.getAccount());
        logger.info("-----修改企业宣传成功，数据响应条数：{{}}------",responseNum);
        return  new Result(responseNum);
    }

    @ControllerLog(doAction = "提交审核")
    @RequiresPermissions("/propaganda/businessPromotionController/submitAudit")
    @ApiOperation(value = "提交审核",notes ="propagandaId:宣传id" )
    @RequestMapping(value = "/submitAudit",method = RequestMethod.POST)
    public Result<JSONObject> submitAudit(String propagandaId){
        Assert.notNull(propagandaId, BusinessPromotionExceptionEnum.PROPAGANDA_ID_NOT_NULL.getMessage());
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("提交审核获取当前登录用户失败");
            return new Result(BusinessPromotionExceptionEnum.NETWORK_ANOMALY.getCode(),BusinessPromotionExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        return  new Result(businessPromotionService.submitAudit(propagandaId, user.getAccount()));
    }

    @ControllerLog(doAction = "获取宣传区域信息")
    @RequiresPermissions("/propaganda/businessPromotionController/getPropagandaAreaList")
    @ApiOperation(value = "(获取宣传区域信息)")
    @RequestMapping(value = "/getPropagandaAreaList",method = RequestMethod.GET)
    public Result<List<PropagandaAreaShow>> getPropagandaAreaList(){
        return  new Result(businessPromotionService.getPropagandaAreaList());
    }

    @ControllerLog(doAction = "生成订单号")
    @RequiresPermissions("/propaganda/businessPromotionController/getOrderNumber")
    @ApiOperation(value = "(生成订单号)")
    @RequestMapping(value = "/getOrderNumber",method = RequestMethod.GET)
    public Result<String> getOrderNumber(){
        return  new Result(businessPromotionService.getOrderNumber());
    }


    @RequiresPermissions("/propaganda/businessPromotionController/createBill")
    @ApiOperation(value = "(创建账单)",notes = "返回账单号，请求成功后，携带账单号跳转至支付方法选择页")
    @RequestMapping(value = "/createBill",method = RequestMethod.POST)
    public Result<String> createBill(@RequestBody @Validated CreateBillParam createBillParam){
        logger.info("进入创建账单API,入参：{}",createBillParam.toString());
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("创建账单获取当前登录用户失败");
            return new Result(BusinessPromotionExceptionEnum.NETWORK_ANOMALY.getCode(),BusinessPromotionExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        return  new Result(businessPromotionService.createBill(createBillParam,user.getAccount(),user.getName()));
    }

    @ControllerLog(doAction = "根据账单号修改支付状态")
    @RequiresPermissions("/propaganda/businessPromotionController/updatePayStatus")
    @ApiOperation(value = "根据账单号修改支付状态",notes = "orderCode:账单号，支付成功后回调方法,返回数据响应条数，正常为1")
    @RequestMapping(value = "/updatePayStatus",method = RequestMethod.POST)
    public Result<Integer> updatePayStatus(@RequestBody String orderCode){
        logger.info("根据账单号修改支付状态API,入参：{}",orderCode);
        Assert.notNull(orderCode,BusinessPromotionExceptionEnum.ORDER_CODE_NOT_NULL.getMessage());
        int resNum= businessPromotionService.updatePayStatus(orderCode);
        logger.info("-------------根据账单号修改支付状态成功，数据响应条数：{}---------------",resNum);
        return  new Result(resNum);
    }

}
