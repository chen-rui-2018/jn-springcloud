package com.jn.system.dept.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.system.dept.entity.TbSysPost;
import com.jn.system.dept.model.SysPost;
import com.jn.system.dept.model.SysPostAdd;
import com.jn.system.dept.model.SysPostPage;
import com.jn.system.dept.service.SysPostService;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 岗位管理
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "岗位管理")
@RestController
@RequestMapping("/system/sysPost")
public class SysPostController extends BaseController {

    @Autowired
    private SysPostService sysPostService;

    @ControllerLog(doAction = "查询所有岗位")
    @RequiresPermissions("/system/sysPost/findSysPostAll")
    @ApiOperation(value = "查询所有岗位", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findSysPostAll")
    public Result findSysPostAll() {
        List<TbSysPost> sysPostAll = sysPostService.findSysPostAll();
        return new Result(sysPostAll);
    }

    @ControllerLog(doAction = "添加岗位")
    @RequiresPermissions("/system/sysPost/add")
    @ApiOperation(value = "添加岗位", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/add")
    public Result add(@Validated @RequestBody SysPostAdd sysPostAdd) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //封装岗位对象
        TbSysPost tbSysPost = new TbSysPost();
        BeanUtils.copyProperties(sysPostAdd, tbSysPost);
        tbSysPost.setId(UUID.randomUUID().toString());
        tbSysPost.setCreatorAccount(user.getAccount());
        tbSysPost.setCreatedTime(new Date());
        sysPostService.addPost(tbSysPost);
        return new Result();
    }

    @ControllerLog(doAction = "逻辑删除岗位信息")
    @RequiresPermissions("/system/sysPost/delete")
    @ApiOperation(value = "逻辑删除岗位信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/delete")
    public Result delete(String[] postIds) {
        Assert.noNullElements(postIds, "岗位id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysPostService.deletePostBranch(postIds, user);
        return new Result();
    }

    @ControllerLog(doAction = "修改岗位信息")
    @RequiresPermissions("/system/sysPost/update")
    @ApiOperation(value = "修改岗位信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/update")
    public Result update(@Validated @RequestBody SysPost sysPost) {
        Assert.notNull(sysPost.getId(), "岗位id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysPostService.updatePost(sysPost, user);
        return new Result();
    }

    @ControllerLog(doAction = "根据岗位id获取岗位信息")
    @RequiresPermissions("/system/sysPost/selectByPrimaryKey")
    @ApiOperation(value = "根据岗位id获取岗位信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/selectByPrimaryKey")
    public Result selectByPrimaryKey(String id) {
        SysPost sysPost = sysPostService.selectByPrimaryKey(id);
        return new Result(sysPost);
    }

    @ControllerLog(doAction = "条件分页获取岗位信息列表")
    @RequiresPermissions("/system/sysPost/list")
    @ApiOperation(value = "条件分页获取岗位信息列表", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/list")
    public Result list(@Validated @RequestBody SysPostPage sysPostPage) {
        PaginationData data = sysPostService.findByPage(sysPostPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "校验岗位名称是否存在,fail表示名称已存在,success表示可以使用")
    @ApiOperation(value = "校验岗位名称是否存在,fail表示名称已存在,success表示可以使用", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/checkPostName")
    @RequiresPermissions("/system/sysPost/checkPostName")
    public Result checkPostName(String postName) {
        String result = sysPostService.checkPostName(postName);
        return new Result(result);
    }

}
