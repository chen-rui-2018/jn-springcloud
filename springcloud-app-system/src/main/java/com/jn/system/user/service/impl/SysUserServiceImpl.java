package com.jn.system.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.system.common.enums.SysExceptionEnums;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.user.enmus.SysUserExceptionEnums;
import com.jn.system.dept.dao.SysUserDepartmentPostMapper;
import com.jn.system.dept.entity.TbSysDepartment;
import com.jn.system.dept.entity.TbSysUserDepartmentPost;
import com.jn.system.dept.model.SysDepartmentPost;
import com.jn.system.dept.vo.SysDepartmentPostVO;
import com.jn.system.model.User;
import com.jn.system.permission.dao.SysRoleMapper;
import com.jn.system.permission.model.SysRole;
import com.jn.system.user.dao.*;
import com.jn.system.user.entity.TbSysUser;
import com.jn.system.user.entity.TbSysUserCriteria;
import com.jn.system.user.model.*;
import com.jn.system.user.service.SysUserService;
import com.jn.system.user.vo.SysUserGroupVO;
import com.jn.system.user.vo.SysUserRoleVO;
import com.jn.system.user.vo.SysUserVO;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    private static Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

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
    @ServiceLog(doAction = "添加用户")
    @Transactional(rollbackFor = Exception.class)
    public void addSysUser(SysUser sysUser, User user) {
        //根据用户名查询用户账号是否存在
        List<TbSysUser> tbSysUsers = checkAccount(sysUser.getAccount());
        if (tbSysUsers != null && tbSysUsers.size() > 0) {
            logger.warn("[用户] 新增用户失败，该用户账号已存在！,account: {}", sysUser.getAccount());
            throw new JnSpringCloudException(SysExceptionEnums.ADDERR_NAME_EXIST);
        }
        sysUser.setId(UUID.randomUUID().toString());
        sysUser.setCreateTime(new Date());
        sysUser.setCreator(user.getId());
        sysUser.setPassword(DigestUtils.md5Hex(RandomStringUtils.random(6, true, true)));
        TbSysUser tbSysUser = new TbSysUser();
        BeanUtils.copyProperties(sysUser, tbSysUser);
        tbSysUserMapper.insert(tbSysUser);
        logger.info("[用户] 新增用户成功！，sysUserId:{}", sysUser.getId());
    }

    /**
     * 用于做账号校验
     *
     * @param account
     * @return
     */
    private List<TbSysUser> checkAccount(String account) {
        TbSysUserCriteria tbSysUserCriteria = new TbSysUserCriteria();
        TbSysUserCriteria.Criteria criteria = tbSysUserCriteria.createCriteria();
        criteria.andAccountEqualTo(account);
        criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getCode());
        return tbSysUserMapper.selectByExample(tbSysUserCriteria);
    }

    /**
     * 条件分页查询用户
     *
     * @param sysUserPage
     * @return
     */
    @Override
    @ServiceLog(doAction = "条件分页查询用户")
    public PaginationData findSysUserByPage(SysUserPage sysUserPage) {
        //分页查询
        Page<Object> objects = PageHelper.startPage(sysUserPage.getPage(), sysUserPage.getRows());
        List<SysUserVO> sysUserVOList = sysUserMapper.findSysUserByPage(sysUserPage);
        PaginationData data = new PaginationData(sysUserVOList, objects.getTotal());
        return data;
    }

    /**
     * 逻辑删除用户
     *
     * @param ids
     */
    @Override
    @ServiceLog(doAction = "删除用户")
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
    @ServiceLog(doAction = "更新用户")
    @Transactional(rollbackFor = Exception.class)
    public void updateSysUser(SysUser sysUser) {
        //判断修改信息是否存在
        SysUser sysUser1 = sysUserMapper.getUserById(sysUser.getId());
        if (sysUser1 == null){
            logger.warn("[用户] 用户修改失败,修改信息不存在,userId: {}", sysUser.getId());
            throw new JnSpringCloudException(SysExceptionEnums.UPDATEDATA_NOT_EXIST);
        }
        //判断账号信息是否被修改
        if (StringUtils.isNotBlank(sysUser.getAccount())) {
            TbSysUser tbSysUser = tbSysUserMapper.selectByPrimaryKey(sysUser.getId());
            if (!sysUser.getAccount().equals(tbSysUser.getAccount())) {
                logger.warn("[用户] 更新用户失败，该用户账号已存在！,account: {}", sysUser.getAccount());
                throw new JnSpringCloudException(SysUserExceptionEnums.NOT_MODIFY_ACCOUNT);
            }
        }
        //判断是否修改密码
        if (StringUtils.isNotBlank(sysUser.getPassword())) {
            sysUser.setPassword(DigestUtils.md5Hex(sysUser.getPassword()));
        }
        //修改用户信息
        TbSysUser tbSysUser = new TbSysUser();
        BeanUtils.copyProperties(sysUser, tbSysUser);
        TbSysUserCriteria tbSysUserCriteria = new TbSysUserCriteria();
        TbSysUserCriteria.Criteria criteria = tbSysUserCriteria.createCriteria();
        criteria.andIdEqualTo(tbSysUser.getId());
        tbSysUserMapper.updateByExampleSelective(tbSysUser, tbSysUserCriteria);
        logger.info("[用户] 更新用户成功！，sysUserId:{}", sysUser.getId());
    }

    /**
     * 查询用户已经具有的用户组信息,且条件分页获取用户未拥有的用户组信息
     *
     * @param sysUserGroupPage
     * @return
     */
    @Override
    @ServiceLog(doAction = "查询用户已经具有的用户组信息,且条件分页获取用户未拥有的用户组信息")
    public PaginationData findSysGroupByUserId(SysUserGroupPage sysUserGroupPage) {
        //根据用户id查询用户组
        List<SysGroup> sysGroupOfUserList = sysGroupMapper.findSysGroupByUserId(sysUserGroupPage.getUserId());
        //条件分页获取用户未拥有用户组信息
        Page<Object> objects = PageHelper.startPage(sysUserGroupPage.getPage(), sysUserGroupPage.getRows());
        List<SysGroup> otherGroupList = sysGroupUserMapper.findGroupByPage(sysUserGroupPage);
        otherGroupList.addAll(sysGroupOfUserList);
        SysUserGroupVO sysUserGroupVO = new SysUserGroupVO(sysGroupOfUserList, otherGroupList);
        PaginationData data = new PaginationData(sysUserGroupVO, objects.getTotal());
        return data;
    }

    /**
     * 往用户中添加用户组
     *
     * @param groupIds
     * @param userId
     */
    @Override
    @ServiceLog(doAction = "往用户中添加用户组")
    @Transactional(rollbackFor = Exception.class)
    public void saveSysGroupToSysUser(String[] groupIds, String userId, User user) {
        if (groupIds != null && groupIds.length > 0) {
            //清除用户中已经存在的用户组
            sysUserMapper.deleGroupOfUser(userId);
            if (groupIds.length > 0) {
                //往用户中添加新的用户组
                for (String groupId : groupIds) {
                    //设置用户用户组实体类
                    SysGroupUser sysGroupUser = new SysGroupUser();
                    sysGroupUser.setCreator(user.getId());
                    sysGroupUser.setGroupId(groupId);
                    sysGroupUser.setUserId(userId);
                    sysGroupUser.setId(UUID.randomUUID().toString());
                    sysGroupUser.setStatus(SysStatusEnums.EFFECTIVE.getCode());
                    sysUserMapper.saveSysGroupToSysUser(sysGroupUser);
                }
            }
            logger.info("[用户] 用户添加用户组成功！，sysUserId:{}", userId);
        }

    }

    /**
     * 根据用户id获取用户具有角色及条件分页查询用户未拥有的角色
     *
     * @param sysUserRolePage
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据用户id获取用户具有角色及条件分页查询用户未拥有的角色")
    public SysUserRoleVO findSysRoleByUserId(SysUserRolePage sysUserRolePage) {
        //获取用户已经具有角色
        List<SysRole> sysRoleOfUserList = sysRoleMapper.findSysRoleByUserId(sysUserRolePage.getUserId());
        //条件分页获取用户未拥有的角色信息
        List<SysRole> otherRoleList = sysUserRoleMapper.findRoleByUserPage(sysUserRolePage);
        otherRoleList.addAll(sysRoleOfUserList);
        SysUserRoleVO sysUserRoleVO = new SysUserRoleVO(sysRoleOfUserList, otherRoleList);
        return sysUserRoleVO;
    }

    /**
     * 为用户添加角色权限
     *
     * @param roleIds
     * @param userId
     */
    @Override
    @ServiceLog(doAction = "为用户添加角色权限")
    @Transactional(rollbackFor = Exception.class)
    public void saveSysRoleToSysUser(String[] roleIds, String userId, User user) {
        //清除用户中已经存在的角色
        sysUserMapper.deleRoleOfUser(userId);
        if (roleIds != null && roleIds.length > 0) {
            //为用户添加新的角色
            for (String roleId : roleIds) {
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setCreateTime(new Timestamp(System.currentTimeMillis()));
                sysUserRole.setCreator(user.getId());
                sysUserRole.setRoleId(roleId);
                sysUserRole.setUserId(userId);
                sysUserRole.setId(UUID.randomUUID().toString());
                sysUserRole.setStatus(SysStatusEnums.EFFECTIVE.getCode());
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
    @ServiceLog(doAction = "根据用户id查询用户已经具有的部门岗位信息")
    public List<SysDepartmentPostVO> findDepartmentandPostByUserId(String userId) {
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
            sysDepartmentPostVO.setDepartmentId(id.substring(0, id.length() - 1));
        }
        return sysDepartmentPostVOList;
    }

    /**
     * 为用户添加部门岗位
     *
     * @param sysUserDepartmentPostAdd
     * @return
     */
    @Override
    @ServiceLog(doAction = "为用户添加部门岗位")
    @Transactional(rollbackFor = Exception.class)
    public void saveDepartmentAndPostOfUser(SysUserDepartmentPostAdd sysUserDepartmentPostAdd, User user) {
        //清除用户已有岗位部门列表
        sysUserMapper.deleDepartmentandPost(sysUserDepartmentPostAdd.getUserId());
        if (sysUserDepartmentPostAdd.getSysDepartmentPostList() != null
                && sysUserDepartmentPostAdd.getSysDepartmentPostList().size() > 0) {
            //为用户添加新部门岗位信息
            int count = 0;
            for (SysDepartmentPost sysDepartmentPost : sysUserDepartmentPostAdd.getSysDepartmentPostList()) {
                TbSysUserDepartmentPost sysUserDepartmentPost = new TbSysUserDepartmentPost();
                sysUserDepartmentPost.setCreator(user.getId());
                sysUserDepartmentPost.setId(UUID.randomUUID().toString());
                sysUserDepartmentPost.setStatus(SysStatusEnums.EFFECTIVE.getCode());
                sysUserDepartmentPost.setUserId(sysUserDepartmentPostAdd.getUserId());
                sysUserDepartmentPost.setDepartmentId(sysDepartmentPost.getDepartmentId());
                sysUserDepartmentPost.setPostId(sysDepartmentPost.getPostId());
                sysUserDepartmentPost.setIsDefault(sysDepartmentPost.getIsDefault());
                if ("1".equals(sysDepartmentPost.getIsDefault())) {
                    count++;
                    if (count > 1) {
                        logger.warn("[用户] 用户添加部门岗位失败,userId: {}", sysUserDepartmentPostAdd.getUserId());
                        throw new JnSpringCloudException(SysUserExceptionEnums.DEPARTMENTPOST_DEFAULE_NOTUNIQUE);
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
    @ServiceLog(doAction = "根据用户id返回用户信息")
    public SysUser findSysUserById(String id) {
        TbSysUser tbSysUser = tbSysUserMapper.selectByPrimaryKey(id);
        SysUser sysUser = new SysUser();
        if (tbSysUser != null) {
            BeanUtils.copyProperties(tbSysUser, sysUser);
            sysUser.setPassword("");
        }
        return sysUser;
    }

    /**
     * 校验账号是否存在
     *
     * @param account
     * @return
     */
    @Override
    @ServiceLog(doAction = "校验账号是否存在")
    public String checkUserName(String account) {
        if (StringUtils.isNotBlank(account)) {
            List<TbSysUser> tbSysUsers = checkAccount(account);
            if (tbSysUsers != null && tbSysUsers.size() > 0) {
                return SysReturnMessageEnum.FAIL.getMessage();
            }
        }
        return SysReturnMessageEnum.SUCCESS.getMessage();
    }

    @ServiceLog(doAction = "获取用户")
    @Override
    public List<User> findTByT(User user) {
        TbSysUserCriteria tbSysUserCriteria = new TbSysUserCriteria();
        if (com.jn.common.util.StringUtils.isNotBlank(user.getAccount())) {
            tbSysUserCriteria.createCriteria().andAccountLike(user.getAccount());
        }
        List<TbSysUser> tbSysUsers = tbSysUserMapper.selectByExample(tbSysUserCriteria);
        List<User> users = new ArrayList<>();
        for (TbSysUser tbSysUser1 : tbSysUsers) {
            User user1 = new User();
            BeanUtils.copyProperties(tbSysUser1, user1);
            users.add(user1);
        }
        return users;
    }
}
