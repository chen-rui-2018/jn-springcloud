package com.jn.user.address.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.user.address.model.UserAddressParam;
import com.jn.user.address.model.UserAddressVO;
import com.jn.user.address.model.UserDefaultAddressParam;
import com.jn.user.usertag.model.TagCode;

import java.util.List;

/**
 * 前端用户地址
 * @author： jiangyl
 * @date： Created on 2019/3/6 16:48
 * @version： v1.0
 * @modified By:
 */
public interface UserAddressService {

    /**
     * 获取当前用户地址列表
     * @param account
     * @param page
     * @return
     */
    PaginationData<List<UserAddressVO>> getUserAddressList(Page page,String account);

    /**
     * 活动用户默认收货地址
     * @return
     */
    UserAddressVO getUserDefaultAddress(String account);

    /**
     * 根据地址ID查询地址详情
     * @param addressId
     * @return
     */
    UserAddressVO getUserAddressById(String addressId);

    /**
     * 保存/修改用户地址信息
     * @param userAddressParam
     * @param account
     * @return 返回地址ID
     */
    String saveOrUpdateUserAddressInfo(UserAddressParam userAddressParam,String account);

    /**
     * 处理用户默认地址
     * @param userDefaultAddressParam
     * @param account
     * @return
     */
    int saveUserDefaultAddress(UserDefaultAddressParam userDefaultAddressParam,String account);

    /**
     * 删除用户地址信息
     * @param addressId
     * @param account
     * @return
     */
    int deleteUserAddress(String addressId,String account);

}
