package com.jn.oa.addressBook.service;

import com.jn.common.model.Result;
import com.jn.system.model.User;
import com.jn.system.model.UserPage;

/**
 * @author： shaobao
 * @date： Created on 2019/3/8 18:19
 * @version： v1.0
 * @modified By:
 **/
public interface AddressBookService {
    /**
     * 获取用户信息详情
     *
     * @param userAccount 用户账号
     * @return
     */
    Result<User> getUserInfo(String userAccount);

    /**
     * 条件分页获取用户列表
     *
     * @param userPage
     * @return
     */
    Result list(UserPage userPage);

    /**
     * 获取部门树信息
     *
     * @return
     */
    Result getDeptTree();
}
