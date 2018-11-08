package com.jn.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.dao.SysGroupMapper;
import com.jn.system.dao.SysRoleMapper;
import com.jn.system.dao.SysUserMapper;
import com.jn.system.dao.TbSysUserMapper;
import com.jn.system.entity.TbSysGroup;
import com.jn.system.entity.TbSysUser;
import com.jn.system.entity.TbSysUserCriteria;
import com.jn.system.entity.TbSysUserDepartmentPost;
import com.jn.system.enums.SysStatusEnums;
import com.jn.system.model.*;
import com.jn.system.service.SysUserService;
import com.jn.system.vo.SysUserVO;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;

/**
 * 用户dao
 *
 * @author： shaobao
 * @date： Created on 2018/10/31 13:07
 * @version： v1.0
 * @modified By:
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    private Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysGroupMapper sysGroupMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private TbSysUserMapper tbSysUserMapper;

    /**
     * 添加用户
     *
     * @param sysUser
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addSysUser(SysUser sysUser) {
        sysUser.setId(UUID.randomUUID().toString());
        //用户添加,默认密码123456
        sysUser.setPassword(DigestUtils.md5Hex("123456"));
        sysUser.setCreateTime(new Date());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysUser.setCreator(user.getId());
        TbSysUser tbSysUser = new TbSysUser();
        BeanUtils.copyProperties(sysUser, tbSysUser);
        tbSysUserMapper.insert(tbSysUser);
        logger.info("message{}", "新增用户成功！，sysUserId=" + sysUser.getId());
    }

    /**
     * 分页查询用户,返回用户信息及部门岗位
     *
     * @param userSysUserPage
     * @return
     */
    @Override
    public Result findSysUserByPage(SysUserPage userSysUserPage) {
        //分页查询
        Page<Object> objects = PageHelper.startPage(userSysUserPage.getPage(), userSysUserPage.getRows());
        PaginationData getEasyUIData = null;
        //判断传过来参数是否有查询条件
        if (StringUtils.isBlank(userSysUserPage.getDepartmentId())) {
            List<SysUserVO> sysUserVOList = sysUserMapper.findSysUserByPage(userSysUserPage);
            //遍历用户,获取用户默认部门岗位
            for (SysUserVO sysUserVO : sysUserVOList) {
                sysUserVO.setPassword("");
                SysUserDepartmentPost query = new SysUserDepartmentPost();
                query.setUserId(sysUserVO.getId());
                query.setIsDefault("1");
                List<SysUserVO> sysUserVOListOne = sysUserMapper.findSysUserByPageAndOption(query);
                if (sysUserVOListOne.size() == 1) {
                    for (SysUserVO sysUserVO1 : sysUserVOListOne) {
                        sysUserVO.setSysDepartmentPostVOList(sysUserVO1.getSysDepartmentPostVOList());
                    }
                }
            }
            getEasyUIData = new PaginationData(sysUserVOList, objects.getTotal());
        } else {
            SysUserDepartmentPost query = new SysUserDepartmentPost();
            BeanUtils.copyProperties(userSysUserPage, query);
            getEasyUIData = new PaginationData(sysUserMapper.findSysUserByPageAndOption(query), objects.getTotal());
        }
        return new Result(getEasyUIData);
    }

    /**
     * 删除用户
     *
     * @param ids
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSysUser(String[] ids) {
        if (ids.length > 0) {
            for (String id : ids) {
                TbSysUser tbSysUser = tbSysUserMapper.selectByPrimaryKey(id);
                tbSysUser.setStatus(SysStatusEnums.DELETED.getKey());
                tbSysUserMapper.updateByPrimaryKey(tbSysUser);
                sysUserMapper.deleteSysUser(id);
                logger.info("message{}", "删除用户成功！，sysUserId=" + id);
            }
        } else {
            return;
        }
    }

    /**
     * 更新用户
     *
     * @param sysUser
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSysUser(SysUser sysUser) {
        sysUser.setCreateTime(new Date());
        if (StringUtils.isNotBlank(sysUser.getPassword())) {
            sysUser.setPassword(DigestUtils.md5Hex(sysUser.getPassword()));
        }
        TbSysUser tbSysUser = new TbSysUser();
        BeanUtils.copyProperties(sysUser, tbSysUser);
        TbSysUserCriteria tbSysUserCriteria = new TbSysUserCriteria();
        TbSysUserCriteria.Criteria criteria = tbSysUserCriteria.createCriteria();
        criteria.andIdEqualTo(tbSysUser.getId());
        tbSysUserMapper.updateByExampleSelective(tbSysUser, tbSysUserCriteria);
        logger.info("message{}", "更新用户成功！，sysUserId=" + sysUser.getId());
    }

    /**
     * 根据用户id获取用户已经存在的用户组及其他用户组
     *
     * @param id
     * @return
     */
    @Override
    public Result findSysGroupByUserId(String id) {
        //根据用户id查询用户组
        List<TbSysGroup> sysGroupOfUser = sysGroupMapper.findSysGroupByUserId(id);
        //获取所有用户组
        List<TbSysGroup> sysGroupAll = sysGroupMapper.findGroupAll();
        if (sysGroupOfUser != null && sysGroupOfUser.size() > 0) {
            for (TbSysGroup sysGroup : sysGroupOfUser) {
                //排除用户已经具有的用户
                if (sysGroupAll.contains(sysGroup)) {
                    sysGroupAll.remove(sysGroup);
                }
            }
        }
        //将用户具有的用户组及其他用户组返回
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sysGroupOfUser", sysGroupOfUser);
        map.put("sysGroupAll", sysGroupAll);
        return new Result(map);
    }

    /**
     * 往用户中添加用户组
     *
     * @param groupIds
     * @param userId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSysGroupToSysUser(String[] groupIds, String userId) {
        if (groupIds != null && groupIds.length > 0) {
            //清除用户中已经存在的用户组
            sysUserMapper.deleGroupOfUser(userId);
            if (groupIds.length > 0) {
                //往用户中添加新的用户组
                for (String groupId : groupIds) {
                    //设置用户用户组实体类
                    SysGroupUser sysGroupUser = new SysGroupUser();
                    sysGroupUser.setCreateTime(new Date());
                    User user = (User) SecurityUtils.getSubject().getPrincipal();
                    sysGroupUser.setCreator(user.getId());
                    sysGroupUser.setGroupId(groupId);
                    sysGroupUser.setUserId(userId);
                    sysGroupUser.setId(UUID.randomUUID().toString());
                    sysGroupUser.setStatus(SysStatusEnums.EFFECTIVE.getKey());
                    sysUserMapper.saveSysGroupToSysUser(sysGroupUser);
                }
            }
            logger.info("message{}", "用户添加用户组成功！，sysUserId=" + userId);
        }

    }

    /**
     * 根据用户id获取用户具有角色及其他角色
     *
     * @param id
     * @return
     */
    @Override
    public Result findSysRoleByUserId(String id) {
        //或取用户已经具有角色
        List<SysRole> sysRoleOfUser = sysRoleMapper.findSysRoleByUserId(id);
        List<SysRole> sysRoleAll = sysRoleMapper.findSysRoleAll();
        if (sysRoleOfUser != null && sysRoleOfUser.size() > 0) {
            for (SysRole sysRole : sysRoleOfUser) {
                if (sysRoleAll.contains(sysRole)) {
                    sysRoleAll.remove(sysRole);
                }
            }
        }
        //将用户具有的角色及其他角色返回
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sysRoleOfUser", sysRoleOfUser);
        map.put("sysRoleAll", sysRoleAll);
        return new Result(map);
    }

    /**
     * 为用户添加角色权限
     *
     * @param roleIds
     * @param userId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSysRoleToSysUser(String[] roleIds, String userId) {
        //清除用户中已经存在的角色
        sysUserMapper.deleRoleOfUser(userId);
        if (roleIds != null && roleIds.length > 0) {
            //为用户添加新的角色
            for (String roleId : roleIds) {
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setCreateTime(new Timestamp(System.currentTimeMillis()));
                User user = (User) SecurityUtils.getSubject().getPrincipal();
                sysUserRole.setCreator(user.getId());
                sysUserRole.setRoleId(roleId);
                sysUserRole.setUserId(userId);
                sysUserRole.setId(UUID.randomUUID().toString());
                sysUserRole.setStatus(SysStatusEnums.EFFECTIVE.getKey());
                sysUserMapper.saveSysRoleToSysUser(sysUserRole);
            }
            logger.info("message{}", "用户添加角色成功！，sysUserId=" + userId);
        }

    }

    /**
     * 根据用户id查询用户已经具有的部门岗位信息及用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public Result findDepartmentandPostByUserId(String userId) {
        SysUserDepartmentPost sysUserDepartmentPost = new SysUserDepartmentPost();
        sysUserDepartmentPost.setUserId(userId);
        //设置默认查询用户部门岗位为有效状态数据
        sysUserDepartmentPost.setDepartmentPostStatus(SysStatusEnums.EFFECTIVE.getKey());
        List<SysUserVO> sysUserVOList = sysUserMapper.findSysUserByPageAndOption(sysUserDepartmentPost);
        return new Result(sysUserVOList);
    }

    /**
     * 为用户添加部门岗位
     *
     * @param sysUserDepartmentPostAdd
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveDepartmentandPostOfUser(SysUserDepartmentPostAdd sysUserDepartmentPostAdd) {
        //清除用户已有岗位部门列表
        sysUserMapper.deleDepartmentandPost(sysUserDepartmentPostAdd.getUserId());
        if (sysUserDepartmentPostAdd.getSysDepartmentPostList() != null
                && sysUserDepartmentPostAdd.getSysDepartmentPostList().size() > 0) {
            //为用户添加新部门岗位信息
            for (SysDepartmentPost sysDepartmentPost : sysUserDepartmentPostAdd.getSysDepartmentPostList()) {
                TbSysUserDepartmentPost sysUserDepartmentPost = new TbSysUserDepartmentPost();
                sysUserDepartmentPost.setCreateTime(new Date());
                User user = (User) SecurityUtils.getSubject().getPrincipal();
                sysUserDepartmentPost.setCreator(user.getId());
                sysUserDepartmentPost.setId(UUID.randomUUID().toString());
                sysUserDepartmentPost.setStatus(SysStatusEnums.EFFECTIVE.getKey());
                sysUserDepartmentPost.setUserId(sysUserDepartmentPostAdd.getUserId());
                sysUserDepartmentPost.setDepartmentId(sysDepartmentPost.getDepartmentId());
                sysUserDepartmentPost.setPostId(sysDepartmentPost.getPostId());
                sysUserDepartmentPost.setIsDefault(sysDepartmentPost.getIsDefault());
                sysUserMapper.saveDepartmentandPostOfUser(sysUserDepartmentPost);
            }
            logger.info("message{}", "用户添加部门岗位成功！，sysUserId=" + sysUserDepartmentPostAdd.getUserId());
        }

    }

    /**
     * 根据用户id返回用户信息
     *
     * @param id
     * @return
     */
    @Override
    public Result findSysUserById(String id) {
        TbSysUser tbSysUser = tbSysUserMapper.selectByPrimaryKey(id);
        SysUser sysUser = new SysUser();
        if (tbSysUser != null) {
            BeanUtils.copyProperties(tbSysUser, sysUser);
            sysUser.setPassword("");
        }
        return new Result(sysUser);
    }
}
