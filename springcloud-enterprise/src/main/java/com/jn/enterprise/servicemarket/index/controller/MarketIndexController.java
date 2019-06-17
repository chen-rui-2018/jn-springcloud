package com.jn.enterprise.servicemarket.index.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.enterprise.servicemarket.index.service.MarketIndexService;
import com.jn.enterprise.servicemarket.index.vo.DataStatisticsVO;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务超市-数据统计
 * @Author: huxw
 * @Date: 2019-6-10 15:55:48
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "服务超市-数据统计")
@RestController
@RequestMapping(value = "/guest/MarketIndexController")
public class MarketIndexController extends BaseController {

    @Autowired
    private MarketIndexService marketIndexService;

    @ControllerLog(doAction = "获取企业，机构，活动，服务专员数量")
    @ApiOperation(value = "获取企业，机构，活动，服务专员数量")
    @RequestMapping(value = "/getDataStatistics",method = RequestMethod.GET)
    public Result<DataStatisticsVO> getDataStatistics(){
        return new Result(marketIndexService.getDataStatistics());
    }

}
