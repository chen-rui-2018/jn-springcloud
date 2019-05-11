package com.jn.enterprise.company.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.company.enums.CompanyExceptionEnum;
import com.jn.enterprise.company.model.ReviewStaffParam;
import com.jn.enterprise.company.model.StaffListParam;
import com.jn.enterprise.company.service.StaffService;
import com.jn.enterprise.company.vo.StaffListVO;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@Api(tags = "用户中心-我的企业-员工管理")
@RestController
@RequestMapping("/enterprise/StaffController")
public class StaffController extends BaseController {

    @Autowired
    private StaffService staffService;

    @ControllerLog(doAction = "员工列表")
    @ApiOperation(value = "员工列表（pc-员工列表）", notes = "按手机号或名称（模糊查询）[分页查询]")
    @RequestMapping(value = "/getStaffList",method = RequestMethod.GET)
    @RequiresPermissions("/enterprise/StaffController/getStaffList")
    public Result<PaginationData<List<StaffListVO>>> getStaffList(@Validated StaffListParam staffListParam){
        User user = checkUserValid();
        return new Result(staffService.getStaffList(staffListParam, user.getAccount()));
    }

    @ControllerLog(doAction = "员工审核")
    @ApiOperation(value = "员工审核（app/pc-员工审核）", notes = "返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/reviewStaff",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/StaffController/reviewStaff")
    public Result<Integer> reviewStaff(@Validated @RequestBody ReviewStaffParam reviewStaffParam){
        User user = checkUserValid();
        return new Result(staffService.reviewStaff(reviewStaffParam, user.getAccount()));
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
