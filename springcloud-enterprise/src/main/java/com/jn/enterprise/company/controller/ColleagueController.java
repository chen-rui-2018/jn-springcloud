package com.jn.enterprise.company.controller;

import com.codingapi.tx.annotation.TxTransaction;
import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.company.enums.CompanyExceptionEnum;
import com.jn.enterprise.company.model.ColleagueListParam;
import com.jn.enterprise.company.model.ColleagueUpdateParam;
import com.jn.enterprise.company.model.StaffListParam;
import com.jn.enterprise.company.service.StaffService;
import com.jn.enterprise.company.vo.ColleagueListVO;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： huxw
 * @date： Created on 2019-4-9 10:53:30
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "用户中心-我的企业-企业同事")
@RestController
@RequestMapping("/enterprise/ColleagueController")
public class ColleagueController extends BaseController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private UserExtensionClient userExtensionClient;

    @ControllerLog(doAction = "同事列表")
    @ApiOperation(value = "同事列表（pc/app-同事列表）", notes = "按手机号或名称（模糊查询）[分页查询]")
    @RequestMapping(value = "/getColleagueList",method = RequestMethod.GET)
    @RequiresPermissions("/enterprise/ColleagueController/getColleagueList")
    public Result<ColleagueListVO> getColleagueList(@Validated ColleagueListParam colleagueListParam){
        User user = checkUserValid();
        StaffListParam staffListParam = new StaffListParam();
        BeanUtils.copyProperties(colleagueListParam, staffListParam);
        return new Result(staffService.getColleagueList(staffListParam, user.getAccount()));
    }

    @TxTransaction(isStart = true)
    @ControllerLog(doAction = "批量删除同事")
    @ApiOperation(value = "批量删除同事（pc/app-删除同事）", notes = "企业管理员，返回数据响应条数")
    @RequestMapping(value = "/delColleague",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/ColleagueController/delColleague")
    public Result<Integer> delColleague(String[] accounts){
        Assert.notNull(accounts, CompanyExceptionEnum.PARAM_IS_NULL.getMessage());
        User user = checkUserValid();
        return new Result(staffService.delMoreStaffs(accounts, user.getAccount()));
    }

    @TxTransaction(isStart = true)
    @ControllerLog(doAction = "设置联系人")
    @ApiOperation(value = "设置联系人（pc-设为联系人）", notes = "企业管理员，返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/setContact",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/ColleagueController/setContact")
    public Result<Integer> setContact(String account){
        Assert.notNull(account, CompanyExceptionEnum.PARAM_IS_NULL.getMessage());
        User user = checkUserValid();
        return new Result(staffService.setOrCancelContact(account, user.getAccount(), true));
    }

    @TxTransaction(isStart = true)
    @ControllerLog(doAction = "取消联系人")
    @ApiOperation(value = "取消联系人（pc-取消联系人）", notes = "企业管理员，返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/cancelContact",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/ColleagueController/cancelContact")
    public Result<Integer> cancelContact(String account){
        Assert.notNull(account, CompanyExceptionEnum.PARAM_IS_NULL.getMessage());
        User user = checkUserValid();
        return new Result(staffService.setOrCancelContact(account, user.getAccount(), false));
    }

    @TxTransaction(isStart = true)
    @ControllerLog(doAction = "编辑同事信息")
    @ApiOperation(value = "编辑同事信息", notes = "编辑自己的信息", hidden = true)
    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    public Result updateUserInfo(@Validated @RequestBody ColleagueUpdateParam colleagueUpdateParam){
        User user = checkUserValid();
        UserInfo userInfo = new UserInfo();
        userInfo.setAccount(user.getAccount());
        BeanUtils.copyProperties(colleagueUpdateParam, userInfo);
        return userExtensionClient.saveOrUpdateUserInfo(userInfo);
    }

    @TxTransaction(isStart = true)
    @ControllerLog(doAction = "离开企业")
    @ApiOperation(value = "离开企业", notes = "企业管理员不能离开企业，返回数据响应条数")
    @RequestMapping(value = "/leaveCompany",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/ColleagueController/leaveCompany")
    public Result<Integer> leaveCompany(){
        User user = checkUserValid();
        return new Result(staffService.leaveCompany(user.getAccount()));
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
