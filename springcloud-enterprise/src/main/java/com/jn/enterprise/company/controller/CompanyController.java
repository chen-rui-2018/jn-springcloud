package com.jn.enterprise.company.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.company.model.ServiceCompany;
import com.jn.company.model.ServiceCompanyParam;
import com.jn.company.enums.CompanyExceptionEnum;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.park.activity.model.ActivityPagingParam;
import com.jn.park.activity.model.Comment;
import com.jn.park.activity.model.CommentAddParam;
import com.jn.park.api.CommentClient;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/14 16:42
 * @version： v1.0
 * @modified By:
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
    public Result<PaginationData<List<ServiceCompany>>> getCompanyList(ServiceCompanyParam serviceCompanyParam){
        return new Result<>(companyService.getCompanyList(serviceCompanyParam));
    }

    @ControllerLog(doAction = "根据用户账号/企业ID查询企业信息（用户为企业管理员）")
    @ApiOperation(value = "根据用户账号查询企业信息",notes = "用户为企业管理员")
    @RequestMapping(value = "/getCompanyDetailByAccountOrCompanyId",method = RequestMethod.GET)
    public Result<ServiceCompany> getCompanyDetailByAccountOrCompanyId(
            @ApiParam(name="accountOrCompanyId",value = "用户账号或企业ID",required = true,example = "wangsong")
            @RequestParam(value = "accountOrCompanyId") String accountOrCompanyId){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(companyService.getCompanyDetailByAccountOrId(accountOrCompanyId,user.getAccount()));
    }


    @ControllerLog(doAction = "查询当前用户企业信息（用户为企业管理员）")
    @ApiOperation(value = "查询当前用户企业信息",notes = "用户为企业管理员")
    @RequestMapping(value = "/getCompanyDetailByNowAccount",method = RequestMethod.GET)
    public Result<ServiceCompany> getCompanyDetailByNowAccount(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user == null){
            throw new JnSpringCloudException(CompanyExceptionEnum.USER_LOGIN_IS_INVALID);
        }
        return new Result<>(companyService.getCompanyDetailByAccountOrId(user.getAccount()));
    }

    @ControllerLog(doAction = "获取评论/留言信息")
    @ApiOperation(value = "获取评论/留言信息")
    @RequestMapping(value = "/getCommentInfo",method = RequestMethod.GET)
    public Result<PaginationData<List<Comment>>>  getCommentInfo(ActivityPagingParam activityPagingParam){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user == null){
            throw new JnSpringCloudException(CompanyExceptionEnum.USER_LOGIN_IS_INVALID);
        }
        activityPagingParam.setAccount(user.getAccount());
        return companyService.getCommentInfo(activityPagingParam);
    }

    @ControllerLog(doAction = "留言/留言回复")
    @ApiOperation(value = "留言/留言回复")
    @RequestMapping(value = "/commentActivity",method = RequestMethod.POST)
    public Result<Boolean> commentActivity(@RequestBody CommentAddParam commentAddParam){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user == null){
            throw new JnSpringCloudException(CompanyExceptionEnum.USER_LOGIN_IS_INVALID);
        }
        commentAddParam.setAccount(user.getAccount());
        return companyService.saveComment(commentAddParam);
    }

}
