package com.jn.user.address.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.user.address.model.UserAddressParam;
import com.jn.user.address.model.UserAddressVO;
import com.jn.user.address.model.UserDefaultAddressParam;
import com.jn.user.address.service.UserAddressService;
import com.jn.user.usertag.model.TagCode;
import com.jn.user.usertag.service.UserTagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前端用户地址
 * @author： jiangyl
 * @date： Created on 2019/3/6 16:47
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "我的-用户地址")
@RestController
@RequestMapping("/guest/user/address")
public class UserAddressController extends BaseController {

    @Autowired
    private UserAddressService userAddressService;

    @ControllerLog(doAction = "获取当前用户地址列表")
    @ApiOperation(value = "获取当前用户地址列表【前端用户使用】",notes = "查询当前用户地址列表信息，分页查询")
    @RequestMapping(value = "/getMyAddress",method = RequestMethod.GET)
    public Result<PaginationData<List<UserAddressVO>>> getMyAddress(Page page){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        return new Result( userAddressService.getUserAddressList(page,user.getAccount()));
    }


    @ControllerLog(doAction = "获取当前用户默认地址")
    @ApiOperation(value = "获取当前用户默认地址【前端用户使用】",notes = "查询当前用户默认地址，若无默认地址，则为最后更新的那条")
    @RequestMapping(value = "/getUserDefaultAddress",method = RequestMethod.GET)
    public Result<UserAddressVO> getUserDefaultAddress(){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        return new Result( userAddressService.getUserDefaultAddress(user.getAccount()));
    }

    @ControllerLog(doAction = "根据地址ID查询地址详细信息")
    @ApiOperation(value = "根据地址ID查询地址详细信息")
    @RequestMapping(value = "/getUserAddressById",method = RequestMethod.GET)
    public Result<UserAddressVO> getUserAddressById(@ApiParam(name = "addressId", value = "地址ID", required = true,example = "3ew34***")
                                                        @RequestParam(value = "addressId")String addressId){
        return new Result( userAddressService.getUserAddressById(addressId));
    }

    @ControllerLog(doAction = "新增/修改用户地址")
    @ApiOperation(value = "新增/修改用户地址",notes = "传ID表示修改地址，新增ID必须为空")
    @RequestMapping(value = "/saveOrUpdateUserAddressInfo",method = RequestMethod.POST)
    public Result<String> saveOrUpdateUserAddressInfo(@RequestBody UserAddressParam userAddressParam){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        return new Result( userAddressService.saveOrUpdateUserAddressInfo(userAddressParam,user.getAccount()));
    }

    @ControllerLog(doAction = "设置/取消用户默认收货地址")
    @ApiOperation(value = "设置/取消用户默认收货地址",notes = "isDefault：传0为取消默认，传1为默认地址。[默认地址设置成功后，会将其他的地址都设为非默认]")
    @RequestMapping(value = "/saveUserDefaultAddress",method = RequestMethod.POST)
    public Result<Integer> saveUserDefaultAddress(@RequestBody UserDefaultAddressParam userDefaultAddressParam){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        return new Result( userAddressService.saveUserDefaultAddress(userDefaultAddressParam,user.getAccount()));
    }

    @ControllerLog(doAction = "删除用户收货地址")
    @ApiOperation(value = "删除用户收货地址",notes = "返回值为响应数据条数，正常情况为1")
    @RequestMapping(value = "/deleteUserAddress",method = RequestMethod.POST)
    public Result<Integer> deleteUserAddress(@ApiParam(name = "addressId", value = "地址ID", required = true,example = "3ew34***")
                                                String addressId){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        return new Result( userAddressService.deleteUserAddress(addressId,user.getAccount()));
    }

}
