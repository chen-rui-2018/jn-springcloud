package com.jn.park.sp.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.sp.model.SpDictDepartModel;
import com.jn.park.sp.vo.SpPowerBusiDetailVo;
import com.jn.park.sp.vo.SpPowerDetailVo;
import com.jn.park.sp.vo.SpPowerVo;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author： huangbq
 * @date： Created on 2019/3/24 16:30
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "对外行政审批中心-门户(新)")
@RestController
@RequestMapping("/portal/sp/power")
public class SpPowerPortalController extends BaseController {

    @ControllerLog(doAction = "实施部门列表")
    @ApiOperation(value = "实施部门列表",notes = "返回全部的实施部门")
    @GetMapping(value = "/departList")
    @RequiresPermissions("/portal/sp/power/departList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "部门名称",example = "1")
    })
    public Result<List<SpDictDepartModel>> departList(String name){
        return new Result<List<SpDictDepartModel>>();
    }

    @ControllerLog(doAction = "权力清单列表")
    @ApiOperation(value = "权力清单列表",notes = "返回全部的权力清单(包含孩子)")
    @GetMapping(value = "/list")
    @RequiresPermissions("/portal/sp/power/list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "权力名称(模糊搜索)",example = "1"),
            @ApiImplicitParam(name = "parentId",value = "父节点ID",example = "100100"),
            @ApiImplicitParam(name = "departId",value = "实施部门ID",example = "1"),
            @ApiImplicitParam(name = "type",value = "权力类型",example = "1"),
            @ApiImplicitParam(name = "code",value = "权力编码",example = "0100381002")
    })
    public Result<PaginationData<List<SpPowerVo>>> list(String name, String parentId, String departId, String type, String code, @ApiParam("分页参数") Page page){
        return new Result<PaginationData<List<SpPowerVo>>>();
    }


    @ControllerLog(doAction = "权力明细")
    @ApiOperation(value = "权力明细",notes = "返回权力的明细内容")
    @GetMapping(value = "/get")
    @RequiresPermissions("/portal/sp/power/get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "权力ID",example = "1")
    })
    public Result<List<SpPowerDetailVo>> get(String id){
        return new Result<List<SpPowerDetailVo>>();
    }

    @ControllerLog(doAction = "业务明细")
    @ApiOperation(value = "业务明细",notes = "返回业务的明细内容")
    @GetMapping(value = "/getBusi")
    @RequiresPermissions("/portal/sp/power/getBusi")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "业务ID",example = "1")
    })
    public Result<SpPowerBusiDetailVo> getBusi(String id){
        return new Result<SpPowerBusiDetailVo>();
    }
}
