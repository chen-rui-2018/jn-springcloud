package com.jn.enterprise.propaganda.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.enums.BusinessPromotionExceptionEnum;
import com.jn.enterprise.propaganda.model.BusinessHomePageParam;
import com.jn.enterprise.propaganda.model.BusinessPromotionDetailsShow;
import com.jn.enterprise.propaganda.model.BusinessPromotionListShow;
import com.jn.enterprise.propaganda.service.BusinessPromotionService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/4/30 9:12
 * @Version v1.0
 * @modified By:
 *
 */
@Api(tags = "门户--各个首页宣传")
@RestController
@RequestMapping("/guest/businessHomePageController")
public class BusinessHomePageController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(BusinessPromotionController.class);

    @Autowired
    private BusinessPromotionService businessPromotionService;

    @ControllerLog(doAction = "门户各首页企业宣传列表查询")
    @ApiOperation(value = "(门户各首页企业宣传列表查询)")
    @RequestMapping(value = "/getBusinessPromotionList",method = RequestMethod.GET)
    public Result<PaginationData<List<BusinessPromotionListShow>>> getBusinessPromotionList(@Validated BusinessHomePageParam businessHomePageParam){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("企业宣传列表查询获取当前登录用户失败");
            return new Result(BusinessPromotionExceptionEnum.NETWORK_ANOMALY.getCode(),BusinessPromotionExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        return  new Result(businessPromotionService.getBusinessPromotionList(businessHomePageParam,user.getAccount()));
    }

    @ControllerLog(doAction = "门户各首页企业宣传详情")
    @ApiOperation(value = "(门户各首页企业宣传详情)")
    @RequestMapping(value = "/getBusinessPromotionDetails",method = RequestMethod.GET)
    public Result<BusinessPromotionDetailsShow> getBusinessPromotionDetails(@ApiParam(value = "宣传id" ,required = true,example = "xxx123")
                                                                            @RequestParam("propagandaId") String propagandaId){
        return  new Result(businessPromotionService.getBusinessPromotionDetails(propagandaId));
    }
}
