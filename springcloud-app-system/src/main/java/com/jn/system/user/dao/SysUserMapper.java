package com.jn.system.user.dao;

import com.jn.system.dept.entity.TbSysUserDepartmentPost;
import com.jn.system.model.User;
import com.jn.system.model.UserPage;
import com.jn.system.user.model.SysTUser;
import com.jn.system.user.model.SysUser;
import com.jn.system.user.vo.SysUserDepartmentPostVO;
import com.jn.system.user.vo.SysUserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户dao
 *
 * @author： shaobao
 * @date： Created on 2018/10/30 16:27
 * @version： v1.0
 * @modified By:
 */
public interface SysUserMapper {

    /**
     * 当查询岗位或岗位类型为空时的查询方法
     *
     * @param userSysUserPage
     * @return
     */
    List<SysUserVO> findSysUserByPage(UserPage userSysUserPage);

    /**
     * 删除用户
     *
     * @param id
     */
    void deleteSysUser(String id);

    /**
     * 批量删除用户
     *
     * @param map
     */
    void deleteUserBranch(Map<String, Object> map);


    /**
     * 根据用户id查询用户已经具有的部门岗位信息及用户信息
     *
     * @param userId
     * @return
     */
    SysUserDepartmentPostVO findDepartmentAndPostByUserId(String userId);

    /**
     * 根据id获取用户信息
     *
     * @param id
     * @return
     */
    SysUser getUserById(String id);

    /**
     * 用户批量添加部门岗位信息
     *
     * @param list
     */
    void addDepartmentAndPostToUserBatch(List<TbSysUserDepartmentPost> list);

    /**
     * 当查询条件中,岗位后岗位类型名称不为空时查询方法
     *
     * @param sysUserPage
     * @return
     */
    List<SysUserVO> getSysUserByPageAndPost(UserPage sysUserPage);

    /**
     * 获取所有有效用户
     *
     * @return
     */
    List<User> getUserAll();

    /**
     * 根据用户账号获取用户信息
     *
     * @param accountList
     * @return
     */
    List<User> getUserInfoByAccount(@Param("accountList") List<String> accountList);

    /**
     * 根据ids查询用户信息
     *
     * @param ids
     * @return
     */
    List<User> selectUserByIds(@Param("ids") String[] ids);
}
