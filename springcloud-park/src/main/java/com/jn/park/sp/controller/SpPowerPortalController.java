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
import com.jn.park.sp.model.SpMessageModel;
import com.jn.park.sp.service.SpPowerPortalService;
import com.jn.park.sp.vo.SpPowerBusiDetailVo;
import com.jn.park.sp.vo.SpPowerDetailVo;
import com.jn.park.sp.vo.SpPowerVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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

    @Autowired
    private SpPowerPortalService spPowerPortalService;


    @ControllerLog(doAction = "实施部门列表")
    @ApiOperation(value = "实施部门列表",notes = "返回全部的实施部门")
    @GetMapping(value = "/departList")
    @RequiresPermissions("/portal/sp/power/departList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "部门名称",example = "秦淮区")
    })
    public Result<List<SpDictDepartModel>> departList(String name){
        List<SpDictDepartModel> spDictDepartModelList = spPowerPortalService.departList(name);
        return new Result<List<SpDictDepartModel>>(spDictDepartModelList);
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
    @RequiresPermissions("/portal/sp/power/get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "权力ID",example = "1")
    })
    public Result<List<SpPowerDetailVo>> get(String id){
        Assert.notNull(id,"权力ID不能为空");
        List<SpPowerDetailVo> spPowerDetailVoList = spPowerPortalService.get(id);
        return new Result<List<SpPowerDetailVo>>(spPowerDetailVoList);
    }

    @ControllerLog(doAction = "业务明细")
    @ApiOperation(value = "业务明细",notes = "返回业务的明细内容")
    @GetMapping(value = "/getBusi")
    @RequiresPermissions("/portal/sp/power/getBusi")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "业务ID",example = "1")
    })
    public Result<SpPowerBusiDetailVo> getBusi(String id){
        Assert.notNull(id,"业务ID不能为空");
        SpPowerBusiDetailVo spPowerBusiDetailVo = spPowerPortalService.getBusi(id);
        return new Result<SpPowerBusiDetailVo>(spPowerBusiDetailVo);
    }

    @ControllerLog(doAction = " 我要留言")
    @ApiOperation(value = "我要留言", notes = "进行留言")
    @RequestMapping(value = "/SpMessage",method = RequestMethod.POST)
    @RequiresPermissions("/portal/sp/power/SpMessage")
    public Result SpMessage( SpMessageModel spMessageModel){
        //获取登录信息
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        spMessageModel.setId(UUID.randomUUID().toString());
        Integer integer = spPowerPortalService.SpMessage(spMessageModel,user);
        if (integer > 0){
            return new Result(integer);
        }
        return new Result("-1","留言失败");
    }

    @ControllerLog(doAction = "轮播广告")
    @ApiOperation(value = "轮播广告",notes = "获取最新的5例广告图")
    @RequestMapping(value = "/SpAdvertising",method = RequestMethod.GET)
    @RequiresPermissions("/portal/sp/power/SpAdvertising")
    public Result<List<SpAdModel>> getAdvertising(){
        List<SpAdModel> spAdModelList = spPowerPortalService.getAdvertising();
        return new Result<List<SpAdModel>>(spAdModelList);
    }

    @ControllerLog(doAction = "获取在线受理地址")
    @ApiOperation(value = "获取在线受理地址")
    @RequestMapping(value = "/getDealUrl",method = RequestMethod.GET)
    @RequiresPermissions("/portal/sp/power/getDealUrl")
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
