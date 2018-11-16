package com.jn.system.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.model.*;
import com.jn.system.service.SysPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequiresPermissions("/system/sysPost/findSysPostAll")
    @ApiOperation(value = "查询所有岗位", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findSysPostAll")
    public Result findSysPostAll() {
        return sysPostService.findSysPostAll();
    }

    @RequiresPermissions("/system/sysPost/add")
    @ApiOperation(value = "添加岗位", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/add")
    public Result add(@Validated @RequestBody SysPostAdd sysPostAdd) {
        String result = sysPostService.addPost(sysPostAdd);
        return new Result(result);
    }

    @RequiresPermissions("/system/sysPost/delete")
    @ApiOperation(value = "逻辑删除岗位信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/delete")
    public Result delete(@Validated @RequestBody SysPostDelete sysPostDelete) {
        Assert.noNullElements(sysPostDelete.getPostIds(), "岗位id不能为空");
        sysPostService.deletePostBranch(sysPostDelete.getPostIds());
        return new Result();
    }

    @RequiresPermissions("/system/sysPost/update")
    @ApiOperation(value = "修改岗位信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/update")
    public Result update(@Validated @RequestBody SysPost sysPost) {
        Assert.notNull(sysPost.getId(), "岗位id不能为空");
        sysPostService.updatePost(sysPost);
        return new Result();
    }

    @RequiresPermissions("/system/sysPost/selectByPrimaryKey")
    @ApiOperation(value = "根据岗位id获取岗位信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/selectByPrimaryKey")
    public Result selectByPrimaryKey(String id) {
        return sysPostService.selectByPrimaryKey(id);
    }


    @RequiresPermissions("/system/sysPost/list")
    @ApiOperation(value = "分页获取岗位信息及岗位对应的用户", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/list")
    public Result list(@Validated @RequestBody SysPostPage sysPostPage) {
        return sysPostService.findByPage(sysPostPage);
    }

    @RequiresPermissions("/system/sysPost/checkPostName")
    @ApiOperation(value = "校验岗位名称是否存在,false表示岗位名称已经存在,success表示可以使用", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/checkPostName")
    public Result checkPostName(String postName){
        return sysPostService.checkPostName(postName);
    }

}
