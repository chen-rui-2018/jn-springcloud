package com.jn.park.gamtopic.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.gamtopic.model.*;
import com.jn.park.gamtopic.service.CareService;
import com.jn.park.gamtopic.vo.CareDetailsVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author： chenr
 * @date： Created on 2019/4/15 17:21
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "同园社交--关注信息")
@RestController

public class CareWebController extends BaseController {
    /**
     * 日志组件
     */
    Logger logger = LoggerFactory.getLogger(CareWebController.class);
    @Autowired
    private CareService careService;


    @ControllerLog(doAction = "用户添加关注操作")
    @ApiOperation(value = "用户添加关注操作",notes = "用户点击关注,对目标用户进行关注操作")
    @RequestMapping(value = "/park/manage/care/addCareOperate",method = RequestMethod.POST)
    public Result  addCareOperate(@RequestBody  CareAddParam careAddParam){
        User user =(User) SecurityUtils.getSubject().getPrincipal();
        String careId = UUID.randomUUID().toString().replaceAll("-","");
        int i = careService.addCareOperate(careId,careAddParam,user==null?"":user.getAccount());

        return new Result(i);
    }
    @ControllerLog(doAction = "用户取消关注操作")
    @ApiOperation(value = "用户取消关注操作",notes = "用户点击取消关注,对目标用户进行取消关注操作")
    @RequestMapping(value = "/park/manage/care/cancelCareOperate",method = RequestMethod.POST)
    public Result  cancelCareOperate(@ApiParam(value="被关注者账号",name="account",required = true ,example = "wangsong") @RequestParam("account") String account){
        User user =(User) SecurityUtils.getSubject().getPrincipal();
        int i = careService.cancelCareOperate(account,user==null?"":user.getAccount());
        return new Result(i);
    }
    @ControllerLog(doAction = "用户关注列表(对象为个人账号/企业管理员账号)")
    @ApiOperation(value = "用户关注列表(对象为个人账号/企业管理员账号)",notes = "查看用户的关注者列表信息")
    @RequestMapping(value = "/park/manage/care/findCareList",method = RequestMethod.GET)
    public Result<PaginationData<List<CareUserShow>>>  findCareList(Page page ){
        User user =(User) SecurityUtils.getSubject().getPrincipal();
        PaginationData<List<CareUserShow>> list  = careService.findCareList(page,user==null?"":user.getAccount());
        return new Result(list);
    }
    @ControllerLog(doAction = "用户关注列表(对象为企业id)")
    @ApiOperation(value = "用户关注列表(对象为企业id)",notes = "查看用户的关注者列表信息")
    @RequestMapping(value = "/park/manage/care/findCompanyCareList",method = RequestMethod.GET)
    public Result<PaginationData<List<CareUserShow>>>  findCompanyCareList(Page page ){
        User user =(User) SecurityUtils.getSubject().getPrincipal();
        PaginationData<List<CareUserShow>> list  = careService.findCompanyCareList(page,user==null?"":user.getAccount());
        return new Result(list);
    }
    @ControllerLog(doAction = "用户粉丝列表")
    @ApiOperation(value = "用户粉丝列表",notes = "查看用户的粉丝列表信息")
    @RequestMapping(value = "/park/manage/care/findFansList",method = RequestMethod.GET)
    public Result<PaginationData<List<CareUserShow>>>  findFansList(Page page ){
        User user =(User) SecurityUtils.getSubject().getPrincipal();
        PaginationData<List<CareUserShow>> list  = careService.findFansList(page,user==null?"":user.getAccount());
        return new Result(list);
    }
    @ControllerLog(doAction = "企业粉丝列表")
    @ApiOperation(value = "企业粉丝列表",notes = "查看企业粉丝列表信息")
    @RequestMapping(value = "/guest/park/manage/care/findCompanyFansList",method = RequestMethod.GET)
    public Result<PaginationData<List<CareUserShow>>>  findCompanyFansList(CompanyFansListParam param ){
        Page page = new Page();
        page.setPage(param.getPage());
        page.setRows(param.getRows()==0?10:param.getRows());
        PaginationData<List<CareUserShow>> list  = careService.findFansList(page,param.getCompanyId());
        return new Result(list);
    }
    @ControllerLog(doAction = "用户关注详情")
    @ApiOperation(value = "用户关注详情",notes = "通过目标账号查找其详情(账号类型为个人)")
    @RequestMapping(value = "/park/manage/care/findCareDetails",method = RequestMethod.GET)
    public Result<CareDetailsVo>  findCareDetails(CareDetailsQueryParam param){
        User user =(User) SecurityUtils.getSubject().getPrincipal();
        CareDetailsVo vo  = careService.findCareDetails(param,user==null?"":user.getAccount());
        return new Result(vo);
    }
    @ControllerLog(doAction = "公司粉丝数(被关注数),关注状态")
    @ApiOperation(value = "公司粉丝数(被关注数),关注状态",notes = "通过公司账号,查询公司的粉丝数")
    @RequestMapping(value = "/park/manage/care/findCompanyFansNum",method = RequestMethod.GET)
    public Result<CareUserDetails>  findCompanyCareInfo(@ApiParam(value="公司账号",name="account",required = true ,example = "wangsong") @RequestParam("account") String account){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        CareUserDetails userDetails = careService.findCompanyCareInfo(account,user==null?"":user.getAccount());
        return new Result(userDetails);
    }

}
