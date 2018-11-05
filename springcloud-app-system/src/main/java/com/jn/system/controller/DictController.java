package com.jn.system.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.GetEasyUIData;
import com.jn.common.model.Result;
import com.jn.system.model.Dict;
import com.jn.system.model.DictPage;
import com.jn.system.service.DictService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 字典类
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
@RestController
@RequestMapping("/system/dict")
public class DictController extends BaseController {
    @Autowired
    private DictService dictService;

    /**
     * 获取列表
     * @param dict
     * @return
     */
    @RequiresPermissions("/system/dict/list")
    @RequestMapping(value = "/list")
    public GetEasyUIData list(DictPage dict) {
        return dictService.findTByPage(dict);
    }

    /**
     * 字典新增
     * @param dict
     * @return
     */
    @RequiresPermissions("/system/dict/add")
    @RequestMapping(value = "/add")
    public Result add(Dict dict) {
        dictService.insertDict(dict);
        return new Result();
    }

    /**
     * 字典更新
     * @param dict
     * @return
     */
    @RequiresPermissions("/system/dict/update")
    @RequestMapping(value = "/update")
    public Result update(Dict dict) {
        Assert.notNull(dict.getId(),"字典ID不能为空");
        dictService.updateByPrimaryKeyDict(dict);
        return new Result();
    }

    /**
     * 字典删除
     * @param id
     * @return
     */
    @RequiresPermissions("/system/dict/delete")
    @RequestMapping(value = "/delete")
    public Result delete(String[] id) {
        dictService.deleteByPrimaryKeyDict(id);
        return new Result();

    }
    /**
     *  查找列表
     * @param dict
     * @return
     */
    @RequestMapping(value = "/findDictByDict")
    public List<Dict> findDictByDict(Dict dict) {
        return dictService.findTByT(dict);
    }

    /**
     * 通过主键找字典
     * @param id
     * @return
     */
    @RequestMapping(value = "/selectByPrimaryKey")
    public Dict selectByPrimaryKey(String id) {
        return dictService.selectByPrimaryKey(id);
    }

}
