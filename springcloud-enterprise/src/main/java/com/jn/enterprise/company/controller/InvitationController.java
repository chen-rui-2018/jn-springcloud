package com.jn.enterprise.company.controller;

import com.codingapi.tx.annotation.TxTransaction;
import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.company.enums.CompanyExceptionEnum;
import com.jn.enterprise.company.model.AcceptInviteParam;
import com.jn.enterprise.company.model.StaffInviteParam;
import com.jn.enterprise.company.model.StaffListParam;
import com.jn.enterprise.company.service.StaffService;
import com.jn.enterprise.company.vo.StaffAuditVO;
import com.jn.enterprise.company.vo.UserExtensionInfoVO;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
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

import java.util.List;

/**
 * @author： huxw
 * @date： Created on 2019-4-9 10:53:30
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "用户中心-我的企业-企业邀请")
@RestController
@RequestMapping("/enterprise/InvitationController")
public class InvitationController extends BaseController {

    @Autowired
    private StaffService staffService;

    @ControllerLog(doAction = "邀请列表")
    @ApiOperation(value = "邀请列表（pc/app-邀请列表）", notes = "获取邀请员工列表[不支持分页查询]")
    @RequestMapping(value = "/getInviteStaffList",method = RequestMethod.GET)
    @RequiresPermissions("/enterprise/StaffController/getInviteStaffList")
    public Result<PaginationData<List<UserExtensionInfoVO>>> getInviteStaffList(@Validated StaffInviteParam staffInviteParam){
        User user = checkUserValid();
        StaffListParam staffListParam = new StaffListParam();
        BeanUtils.copyProperties(staffInviteParam, staffListParam);
        return new Result(staffService.getInviteStaffList(staffListParam, user.getAccount()));
    }

    @ControllerLog(doAction = "批量邀请员工")
    @ApiOperation(value = "批量邀请员工（pc/app-邀请员工）", notes = "企业管理员发送邀请")
    @RequestMapping(value = "/inviteStaff",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/InvitationController/inviteStaff")
    public Result<Integer> inviteStaff(String[] accounts){
        User user = checkUserValid();
        Integer res = staffService.inviteStaff(accounts, user);
        //TODO 调用消息推送接口 huxw

        return new Result(res);
    }

    @ControllerLog(doAction = "再次邀请员工")
    @ApiOperation(value = "再次邀请员工（pc-再次邀请）", notes = "企业管理员再次发送邀请")
    @RequestMapping(value = "/inviteStaffAgain",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/InvitationController/inviteStaffAgain")
    public Result<Integer> inviteStaffAgain(String staffId){
        User user = checkUserValid();
        Integer res = staffService.inviteStaffAgain(staffId, user.getAccount());
        //TODO 调用消息推送接口 huxw

        return new Result(res);
    }

    @TxTransaction(isStart = true)
    @ControllerLog(doAction = "接受邀请")
    @ApiOperation(value = "接受邀请（pc/app-接受邀请）", notes = "返回数据响应条数，正常情况为1(account仅为测试字段，实际是当前用户)")
    @RequestMapping(value = "/acceptInvite",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/InvitationController/acceptInvite")
    public Result<Integer> acceptInvite(@Validated @RequestBody AcceptInviteParam acceptInviteParam){
        User user = checkUserValid();
        acceptInviteParam.setAccount(user.getAccount());
        return new Result(staffService.acceptInvite(acceptInviteParam));
    }

    @ControllerLog(doAction = "拒绝邀请")
    @ApiOperation(value = "拒绝邀请（pc/app-拒绝邀请）", notes = "返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/refuseInvite",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/InvitationController/refuseInvite")
    public Result<Integer> refuseInvite(String comId){
        User user = checkUserValid();
        return new Result(staffService.refuseInvite(comId, user.getAccount()));
    }

    @ControllerLog(doAction = "待审核列表")
    @ApiOperation(value = "待审核列表（app-待审核列表）", notes = "获取待审核列表[不支持分页查询]")
    @RequestMapping(value = "/getAuditStatus",method = RequestMethod.GET)
    @RequiresPermissions("/enterprise/InvitationController/getAuditStatus")
    public Result<StaffAuditVO> getAuditStatus(){
        User user = checkUserValid();
        return new Result(staffService.getAuditStatus(user.getAccount()));
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
