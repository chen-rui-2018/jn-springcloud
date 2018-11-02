package com.jn.system.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.service.SysGroupService;
import com.jn.system.vo.TbSysGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户组
 *
 * @author： shaobao
 * @date： Created on 2018/10/30 15:31
 * @version： v1.0
 * @modified By:
 */
@RestController
@RequestMapping("/system/sysGroup")
public class SysGroupController extends BaseController {

    @Autowired
    private SysGroupService sysGroupService;

    /**
     * 查询所有用户组
     * @return
     */
    @RequestMapping("/findSysGroupAll")
    public Result findSysGroupAll(){
        return sysGroupService.findSysGroupAll();
    }

    /**
     * 用户组添加
     * @param sysGroup 用户组
     * @return
     */
    public Result addSysGroup(TbSysGroup sysGroup){
        sysGroupService.addSysGroup(sysGroup);
        return new Result();
    }

    /**
     * 逻辑删除用户组
     * @param groupIds 用户组id数组
     * @return
     */
    public Result deleSysGroup(String[] groupIds){
        if(groupIds != null && groupIds.length > 0 ){
            sysGroupService.deleSysGroup(groupIds);
        }
        return new Result();
    }

    /**
     * 修改用户组信息
     * @param sysGroup 用户组对象
     * @return
     */
    public Result updateSysGroup(TbSysGroup sysGroup){
        sysGroupService.updateSysGroup(sysGroup);
        return new Result();
    }

    /**
     * 根据用户组id获取用户组信息
     * @param id 用户组id
     * @return
     */
    public Result findSysGroupById(String id){
        return sysGroupService.findSysGroupById(id);
    }

}
