package com.jn.park.sp.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.sp.enums.SpPageExceptionEnums;
import com.jn.park.sp.model.SpAdModel;
import com.jn.park.sp.model.SpDictDepartModel;
import com.jn.park.sp.service.SpPowerPortalService;
import com.jn.park.sp.vo.SpPowerBusiDetailVo;
import com.jn.park.sp.vo.SpPowerDetailVo;
import com.jn.park.sp.vo.SpPowerVo;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author： huangbq
 * @date： Created on 2019/3/24 16:30
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "对外行政审批中心-门户(匿名)")
@RestController
@RequestMapping("/guest/portal/sp/power")
public class SpPowerPortalGuestController extends BaseController {

    @Autowired
    private SpPowerPortalService spPowerPortalService;

    @ControllerLog(doAction = "(新)实施部门列表")
    @ApiOperation(value = "(新)实施部门列表",notes = "(新)实施部门列表")
    @GetMapping(value = "/departList")
    public Result<List<List<SpDictDepartModel>>> departList(){
        List<List<SpDictDepartModel>> spDictDepartModelList = spPowerPortalService.departList();
        return new Result<>(spDictDepartModelList);
    }

    @ControllerLog(doAction = "权力清单列表")
    @ApiOperation(value = "权力清单列表",notes = "返回全部的权力清单(包含孩子)")
    @GetMapping(value = "/list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "权力名称(模糊搜索)",example = "1"),
            @ApiImplicitParam(name = "parentId",value = "父节点ID",example = "100100"),
            @ApiImplicitParam(name = "departId",value = "实施部门ID",example = "1"),
            @ApiImplicitParam(name = "type",value = "权力类型",example = "1"),
            @ApiImplicitParam(name = "code",value = "权力编码",example = "0100381002")
    })
    public Result<PaginationData<List<SpPowerVo>>> list(String name, String parentId, String departId, String type, String code, @ApiParam(value = "分页参数",required = true) Page page){
        if (page.getRows() > 0 && page.getPage() > 0){
            PaginationData data = spPowerPortalService.findByPage(name,parentId,departId,type,code,page);
            return new Result<PaginationData<List<SpPowerVo>>>(data);
        }else {
            throw new JnSpringCloudException(SpPageExceptionEnums.PAGE_NOT_NULL);
        }

    }

    @ControllerLog(doAction = "权力明细")
    @ApiOperation(value = "权力明细",notes = "返回权力的明细内容")
    @GetMapping(value = "/get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "权力ID",example = "1")
    })
    public Result<List<SpPowerDetailVo>> get(String id){
        Assert.notNull(id,"权力ID不能为空");
        List<SpPowerDetailVo> spPowerDetailVoList = spPowerPortalService.get(id);
        return new Result<>(spPowerDetailVoList);
    }

    @ControllerLog(doAction = "业务明细")
    @ApiOperation(value = "业务明细",notes = "返回业务的明细内容")
    @GetMapping(value = "/getBusi")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "业务ID",example = "1")
    })
    public Result<SpPowerBusiDetailVo> getBusi(String id){
        Assert.notNull(id,"业务ID不能为空");
        SpPowerBusiDetailVo spPowerBusiDetailVo = spPowerPortalService.getBusi(id);
        return new Result<>(spPowerBusiDetailVo);
    }


    @ControllerLog(doAction = "轮播广告")
    @ApiOperation(value = "轮播广告",notes = "获取最新的5例广告图")
    @RequestMapping(value = "/SpAdvertising",method = RequestMethod.GET)
    public Result<List<SpAdModel>> getAdvertising(){
        List<SpAdModel> spAdModelList = spPowerPortalService.getAdvertising();
        return new Result<>(spAdModelList);
    }

    @ControllerLog(doAction = "获取在线受理地址")
    @ApiOperation(value = "获取在线受理地址")
    @RequestMapping(value = "/getDealUrl",method = RequestMethod.GET)
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id" , value = "权力ID" , example = "559447847364198400")
    })
    public void getDealUrl(HttpServletResponse response,String id){
        Assert.notNull(id,"权力ID不能为空");
        String url = spPowerPortalService.getDealUrl(id);
        try {
            response.sendRedirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
