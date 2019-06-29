package com.jn.enterprise.servicemarket.org.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.org.model.OrgColleagueParam;
import com.jn.enterprise.servicemarket.org.model.UserRoleInfo;

import java.util.List;

/**
 * 机构同事
 * @Author: yangph
 * @Date: 2019/2/26 10:10
 * @Version v1.0
 * @modified By:
 */
public interface OrgColleagueService {
    /**
     * 机构同事列表查询
     * @param account  当前登录用户账号
     * @param orgColleagueParam 机构同事列表查询入参（是否分页）
     * @return
     */
    PaginationData getOrgColleagueList(String account, OrgColleagueParam orgColleagueParam);

    /**
     * 设置为联系人
     * @param loginAccount  当前登录用户
     * @param account 设置为联系人的账号
     * @return
     */
    int setAsContact(String loginAccount,String account);

    /**
     * 取消联系人
     * @param loginAccount 当前登录用户
     * @param account 取消联系人的账号
     * @return
     */
    int cancelAsContact(String loginAccount,String account);

    /**
     * 删除联系人或专员
     * @param loginAccount 登录用户账号
     * @param accountList 删除联系人或专员的账号
     * @return
     */
    int deleteContactOrAdvisor(String loginAccount,String[] accountList);

    /**
     * 根据指定角色获取用户的角色信息（角色id,角色名称，角色所属用户组id,角色所属用户组名称）
     * @param accountList 账号集合
     * @param roleName    指定角色名称（可以是部分名称）
     * @return
     */
    List<UserRoleInfo> getUserRoleInfoList(List<String> accountList, String roleName);

    /**
     * 修改机构下用户角色
     * @param account    用户账号
     * @param delRoleId  要删除的角色
     * @param addRoleId  要修改的角色
     */
    Boolean updateOrgUserRole(String account, String delRoleId, String addRoleId);
}
