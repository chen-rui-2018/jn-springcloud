package com.jn.system.controller;


import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.model.Resources;
import com.jn.system.service.ResourcesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 资源
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
@RestController
@RequestMapping("/system/resources")
public class ResourcesController extends BaseController {
    @Autowired
    private ResourcesService resourcesService;

    @RequiresPermissions("/system/resources/add")
    @RequestMapping(value = "/add")
    public Result add(Resources resources) {
        resourcesService.insertResources(resources);
        return new Result();
    }

    @RequiresPermissions("/system/resources/delete")
    @RequestMapping(value = "/delete")
    public Result delete(String[] id) {
        resourcesService.deleteResources(id);
        return new Result();
    }


    @RequiresPermissions("/system/resources/update")
    @RequestMapping(value = "/update")
    public Result update(Resources resources) {
        resourcesService.updateResources(resources);
        return new Result();

    }

    @RequiresPermissions("/system/resources/list")
    @RequestMapping(value = "/list")
    public Object list() {
        return resourcesService.findResources();
    }


    @RequestMapping(value = "/findResourcesEMUByResources")
    public Object findResourcesEMUByResources() {
        return resourcesService.findResourcesEMUByResources();
    }


    @RequestMapping(value = "/selectByPrimaryKey")
    public Object selectByPrimaryKey(String id) {
        return resourcesService.selectByPrimaryKey(id);
    }

}
