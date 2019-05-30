package com.jn.oa.goods.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.oa.goods.service.GoodsService;
import com.jn.oa.goods.vo.GoodsApplicationVo;
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

/**
 * 物品管理控制层
 *
 * @author： shaobao
 * @date： Created on 2019/5/29 19:30
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "物品管理")
@RestController
@RequestMapping("/oa/goods")
public class GoodsController extends BaseController {

    @Autowired
    private GoodsService goodsService;

    @ControllerLog(doAction = "更新物品数量")
    @RequiresPermissions("/oa/goods/updateGoodsAccount")
    @ApiOperation(value = "更新物品数量", notes = "用户物品申请流程后置处理")
    @RequestMapping(value = "/updateGoodsAccount", method = RequestMethod.POST)
    public Result updateGoodsAccount(@Validated @RequestBody GoodsApplicationVo goodsApplicationVo) {
        //获取当前用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        goodsService.updateGoodsAccount(goodsApplicationVo, user);
        return new Result();
    }

}
