package com.jn.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.dao.*;
import com.jn.system.entity.*;
import com.jn.system.enums.SysStatusEnums;
import com.jn.system.model.*;
import com.jn.system.service.SysUserService;
import com.jn.system.vo.SysDepartmentPostVO;
import com.jn.system.vo.SysUserGroupVO;
import com.jn.system.vo.SysUserRoleVO;
import com.jn.system.vo.SysUserVO;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
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
    @Autowired
    private SysUserDepartmentPostMapper sysUserDepartmentPostMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysGroupUserMapper sysGroupUserMapper;


    /**
     * 添加用户
     *
     * @param sysUser
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addSysUser(SysUser sysUser) {
        //根据用户名查询用户名是否存在
        TbSysUserCriteria tbSysUserCriteria = new TbSysUserCriteria();
        TbSysUserCriteria.Criteria criteria = tbSysUserCriteria.createCriteria();
        criteria.andAccountEqualTo(sysUser.getAccount());
        List<TbSysUser> tbSysUsers = tbSysUserMapper.selectByExample(tbSysUserCriteria);
        if (tbSysUsers != null && tbSysUsers.size() > 0) {
            return new Result("用户名已存在");
        }
        sysUser.setId(UUID.randomUUID().toString());
        sysUser.setCreateTime(new Date());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysUser.setCreator(user.getId());
        sysUser.setPassword(DigestUtils.md5Hex(RandomStringUtils.random(6, true, true)));
        TbSysUser tbSysUser = new TbSysUser();
        BeanUtils.copyProperties(sysUser, tbSysUser);
        tbSysUserMapper.insert(tbSysUser);
        logger.info("[用户] 新增用户成功！，sysUserId:{}", sysUser.getId());
        return new Result();
    }

    /**
     * 分页查询用户,返回用户信息及部门岗位
     *
     * @param sysUserPage
     * @return
     */
    @Override
    public Result findSysUserByPage(SysUserPage sysUserPage) {
        //分页查询
        Page<Object> objects = PageHelper.startPage(sysUserPage.getPage(), sysUserPage.getRows());
        List<SysUserVO> sysUserVOList = sysUserMapper.findSysUserByPage(sysUserPage);
        PaginationData data = new PaginationData(sysUserVOList, objects.getTotal());
        return new Result(data);
    }

    /**
     * 删除用户
     *
     * @param ids
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSysUser(String[] ids) {
        sysUserMapper.deleteUserBranch(ids);
        sysUserDepartmentPostMapper.deleteUserBranch(ids);
        sysUserRoleMapper.deleteUserBranch(ids);
        sysGroupUserMapper.deleteUserBranch(ids);
        logger.info("[用户] 删除用户成功！，sysUserIds:{}", ids.toString());

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
        logger.info("[用户] 更新用户成功！，sysUserId:{}", sysUser.getId());
    }

    /**
     * 根据用户id获取用户已经存在的用户组及其他用户组
     *
     * @param id
     * @return
     */
    @Override
    public Result findSysGroupByUserId(String id) {
        SysUserGroupVO sysUserGroupVO = new SysUserGroupVO();
        //根据用户id查询用户组
        List<TbSysGroup> sysGroupOfUser = sysGroupMapper.findSysGroupByUserId(id);
        //获取所有用户组
        List<TbSysGroup> sysGroupAll = sysGroupMapper.findGroupAll();
        sysUserGroupVO.setSysGroupOfUser(sysGroupOfUser);
        sysUserGroupVO.setSysGroupAll(sysGroupAll);
        return new Result(sysUserGroupVO);
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
            logger.info("[用户] 用户添加用户组成功！，sysUserId:{}", userId);
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
        SysUserRoleVO sysUserRoleVO = new SysUserRoleVO();
        sysUserRoleVO.setSysRoleAll(sysRoleAll);
        sysUserRoleVO.setSysRoleOfUser(sysRoleOfUser);
        return new Result(sysUserRoleVO);
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
            logger.info("[用户] 用户添加角色成功！，sysUserId:{}", userId);
        }

    }

    /**
     * 根据用户id查询用户已经具有的部门岗位信息
     *
     * @param userId
     * @return
     */
    @Override
    public Result findDepartmentandPostByUserId(String userId) {
        List<SysDepartmentPostVO> sysDepartmentPostVOList = sysUserDepartmentPostMapper.findDepartmentAndPostByUserId(userId);
        for (SysDepartmentPostVO sysDepartmentPostVO : sysDepartmentPostVOList) {
            List<TbSysDepartment> tbSysDepartmentList =
                    sysUserDepartmentPostMapper.findDepartmentId(sysDepartmentPostVO.getDepartmentId());
            StringBuffer buffer = new StringBuffer();
            //对返回的部门名称数据做处理
            for (TbSysDepartment tbSysDepartment : tbSysDepartmentList) {
                buffer.append(tbSysDepartment.getId()).append(",");
            }
            String id = buffer.toString();
            sysDepartmentPostVO.setDepartmentId(id.substring(0,id.length() - 1));
        }
        return new Result(sysDepartmentPostVOList);
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
            int count = 0;
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
                if("1".equals(sysDepartmentPost.getIsDefault())){
                    count++;
                    if (count > 1){
                        throw new RuntimeException("部门岗位信息只能有一个是默认的");
                    }
                }
                sysUserMapper.saveDepartmentandPostOfUser(sysUserDepartmentPost);
            }
            logger.info("[用户] 用户添加部门岗位成功！，sysUserI:{}", sysUserDepartmentPostAdd.getUserId());
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

    /**
     * 校验账号是否存在
     *
     * @param account
     * @return
     */
    @Override
    public Result checkUserName(String account) {
        if (StringUtils.isNotBlank(account)){
            TbSysUserCriteria tbSysUserCriteria = new TbSysUserCriteria();
            TbSysUserCriteria.Criteria criteria = tbSysUserCriteria.createCriteria();
            criteria.andAccountEqualTo(account);
            List<TbSysUser> tbSysUsers = tbSysUserMapper.selectByExample(tbSysUserCriteria);
            if (tbSysUsers != null && tbSysUsers.size() > 0) {
                return new Result("false");
            }
        }
        return new Result("success");
    }
}
