package com.jn.park.hatch.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.hatch.model.HatchHomeConfig;
import com.jn.park.hatch.service.HatchHomeConfigService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 众创空间配置管理
 *
 * @author： wzy
 * @date： Created on 2019/5/15 9:50
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "孵化企业-众创空间")
@RestController
@RequestMapping("/guest/hatch/incubator")
public class HatchHomeConfigController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(HatchHomeConfigController.class);
    @Autowired
    private HatchHomeConfigService hatchHomeConfigService;

    @ControllerLog(doAction = "众创空间-首页信息查询")
    @ApiOperation(value = "众创空间-首页信息查询", notes = "众创空间-首页信息查询")
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public Result<List<HatchHomeConfig>> list(@ApiParam(value = "孵化器简称",example = "白下") @RequestParam(name = "incubatorAbb", required = false) String incubatorAbb,
                                              @ApiParam(value = "当前页",required = true,example = "1") @RequestParam int page,
                                              @ApiParam(value = "每页总数",required = true,example = "8") @RequestParam int rows) {

        PaginationData<List<HatchHomeConfig>> data = hatchHomeConfigService.list(incubatorAbb,page,rows);
        return new Result(data);
    }
}
