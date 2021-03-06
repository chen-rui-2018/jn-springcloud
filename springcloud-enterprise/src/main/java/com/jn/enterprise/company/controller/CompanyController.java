package com.jn.enterprise.company.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.company.model.ServiceCompany;
import com.jn.company.model.ServiceCompanyParam;
import com.jn.company.model.ServiceEnterpriseParam;
import com.jn.enterprise.company.enums.CompanyExceptionEnum;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.company.vo.CompanyContactVO;
import com.jn.enterprise.company.vo.CompanyDetailsVo;
import com.jn.park.activity.model.ActivityPagingParam;
import com.jn.park.activity.model.Comment;
import com.jn.park.activity.model.CommentAddParam;
import com.jn.park.care.model.ServiceEnterpriseCompany;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/14 16:42
 * @version： v1.0
 * @modified By: huxw tangry chenr
 */
@Api(tags = "企业服务")
@RestController
@RequestMapping("/guest/company")
public class CompanyController extends BaseController {

    @Autowired
    private CompanyService companyService;


    @ControllerLog(doAction = "查询企业列表")
    @ApiOperation(value = "查询企业列表")
    @RequestMapping(value = "/getCompanyList",method = RequestMethod.GET)
    public Result<PaginationData<List<ServiceCompany>>> getCompanyList(@Validated ServiceCompanyParam serviceCompanyParam){
        return new Result<>(companyService.getCompanyList(serviceCompanyParam));
    }

    @ControllerLog(doAction = "查询企业列表-新版")
    @ApiOperation(value = "查询企业列表-新版")
    @RequestMapping(value = "/getCompanyNewList",method = RequestMethod.GET)
    public Result<PaginationData<List<ServiceEnterpriseCompany>>> getCompanyNewList(@Validated ServiceEnterpriseParam serviceEnterpriseParam){
        User user =(User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(companyService.getCompanyNewList(serviceEnterpriseParam,user==null?"":user.getAccount()));
    }

    @ControllerLog(doAction = "查询企业详情-新版")
    @ApiOperation(value = "查询企业详情-新版")
    @RequestMapping(value = "/getCompanyDetails",method = RequestMethod.GET)
    public Result<CompanyDetailsVo> getCompanyDetails(@ApiParam(name = "companyId", value = "企业id", required = true) @RequestParam(value = "companyId") String companyId){
        User user =(User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(companyService.getCompanyDetails(companyId,user==null?"":user.getAccount()));
    }

    @ControllerLog(doAction = "根据用户账号/企业ID查询企业信息（用户为企业管理员）")
    @ApiOperation(value = "根据用户账号/企业ID查询企业信息",notes = "用户为企业管理员")
    @RequestMapping(value = "/getCompanyDetailByAccountOrCompanyId",method = RequestMethod.GET)
    public Result<ServiceCompany> getCompanyDetailByAccountOrCompanyId(
            @ApiParam(name="accountOrCompanyId",value = "用户账号或企业ID",required = true,example = "wangsong")
            @RequestParam(value = "accountOrCompanyId") String accountOrCompanyId){
        String account = null;
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user != null) {
            account = user.getAccount();
        }
        return new Result<>(companyService.getCompanyDetailByAccountOrId(accountOrCompanyId, account));
    }

    @ControllerLog(doAction = "查询当前用户企业信息（用户为企业管理员）")
    @ApiOperation(value = "查询当前用户企业信息",notes = "用户为企业管理员")
    @RequestMapping(value = "/getCompanyDetailByNowAccount",method = RequestMethod.GET)
    public Result<ServiceCompany> getCompanyDetailByNowAccount(){
        User user = checkUserValid();
        return new Result<>(companyService.getCompanyDetailByAccountOrId(user.getAccount()));
    }

    @ControllerLog(doAction = "获取评论/留言信息")
    @ApiOperation(value = "获取评论/留言信息")
    @RequestMapping(value = "/getCommentInfo",method = RequestMethod.GET)
    public Result<PaginationData<List<Comment>>>  getCommentInfo(@Validated ActivityPagingParam activityPagingParam){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        activityPagingParam.setAccount(user==null?"":user.getAccount());
        return companyService.getCommentInfo(activityPagingParam);
    }

    @ControllerLog(doAction = "留言/留言回复")
    @ApiOperation(value = "留言/留言回复")
    @RequestMapping(value = "/commentActivity",method = RequestMethod.POST)
    public Result<Boolean> commentActivity(@Validated @RequestBody CommentAddParam commentAddParam){
        User user = checkUserValid();
        commentAddParam.setAccount(user.getAccount());
        return companyService.saveComment(commentAddParam);
    }

    @ControllerLog(doAction = "获取企业在线联系人账号")
    @ApiOperation(value = "获取企业在线联系人账号", notes = "根据企业ID获取在线联系人账号 [返回联系人账号，如企业没有设置联系人返回企业管理员]")
    @RequestMapping(value = "/getCompanyContactAccount",method = RequestMethod.GET)
    public Result<CompanyContactVO> getCompanyContactAccount(@RequestParam(required = false) String comId){
        Assert.notNull(comId, CompanyExceptionEnum.PARAM_IS_NULL.getMessage());
        return new Result(companyService.getCompanyContactAccount(comId));
    }

    /**
     * 判断当前账号是否有效
     * @return
     */
    public User checkUserValid() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user == null){
            throw new JnSpringCloudException(CompanyExceptionEnum.USER_LOGIN_IS_INVALID);
        }
        return user;
    }
}
