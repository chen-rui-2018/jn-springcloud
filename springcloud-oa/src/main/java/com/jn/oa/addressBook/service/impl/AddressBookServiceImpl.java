package com.jn.oa.addressBook.service.impl;

import com.jn.common.model.Result;
import com.jn.oa.addressBook.domain.AddressBookProperties;
import com.jn.oa.addressBook.service.AddressBookService;
import com.jn.oa.common.enums.OaStatusEnums;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.system.model.UserPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 通讯录管理service层实现
 *
 * @author： shaobao
 * @date： Created on 2019/3/8 18:20
 * @version： v1.0
 * @modified By:
 **/
@Service
public class AddressBookServiceImpl implements AddressBookService {

    @Autowired
    private SystemClient systemClient;

    @Autowired
    private AddressBookProperties addressBookProperties;

    /**
     * 获取用户信息详情
     *
     * @param userAccount 用户账号
     * @return
     */
    @Override
    @ServiceLog(doAction = "获取用户信息详情")
    public Result<User> getUserInfo(String userAccount) {
        User user1 = new User();
        user1.setAccount(userAccount);
        Result<User> result = systemClient.getUser(user1);
        return result;
    }

    /**
     * 条件分页获取用户列表
     *
     * @param userPage 分页条件
     * @return
     */
    @Override
    @ServiceLog(doAction = "条件分页获取用户列表")
    public Result list(UserPage userPage) {
        //只获取有效用户,所以设置查询状态为有效
        userPage.setRecordStatus(new Byte(OaStatusEnums.EFFECTIVE.getCode()));
        //从配置文件中读取园区用户用户组的id
        String userGroupId = addressBookProperties.getUserGroupId();
        userPage.setUserGroupId(userGroupId);
        Result result = systemClient.getUserByPage(userPage);
        return result;
    }

    /**
     * 获取部门树信息
     *
     * @return
     */
    @Override
    @ServiceLog(doAction = "获取部门树信息")
    public Result getDeptTree() {
        Result result = systemClient.selectDeptByParentId(null, true);
        return result;
    }
}
