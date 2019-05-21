package com.jn.park.customer.service;

/**
 * @Author: yangph
 * @Date: 2019/5/16 22:38
 * @Version v1.0
 * @modified By:
 */
public interface ClientRoleAndExecutePersonService {
    /**
     * 添加角色和用户信息
     * @param roleName      角色名称
     * @param loginAccount  用户账号
     * @return
     */
    int addRoleAndExecutePersonInfo(String roleName,String loginAccount);
}
