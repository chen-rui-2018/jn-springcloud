package com.jn.system.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.Assert;
import com.jn.common.util.encryption.EncryptUtil;
import com.jn.system.common.enums.SysExceptionEnums;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.dept.dao.SysUserDepartmentPostMapper;
import com.jn.system.dept.dao.TbSysUserDepartmentPostMapper;
import com.jn.system.dept.entity.TbSysDepartment;
import com.jn.system.dept.entity.TbSysUserDepartmentPost;
import com.jn.system.dept.model.SysDepartmentPost;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysRole;
import com.jn.system.model.User;
import com.jn.system.model.UserPage;
import com.jn.system.permission.dao.SysRoleMapper;
import com.jn.system.user.dao.*;
import com.jn.system.user.enmus.SysUserExceptionEnums;
import com.jn.system.user.entity.TbSysUser;
import com.jn.system.user.entity.TbSysUserCriteria;
import com.jn.system.user.model.*;
import com.jn.system.user.service.SysUserService;
import com.jn.system.user.vo.SysUserGroupVO;
import com.jn.system.user.vo.SysUserRoleVO;
import com.jn.system.user.vo.SysUserVO;
import com.jn.system.vo.SysDepartmentPostVO;
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
import java.util.*;
import java.util.stream.Collectors;

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
    @Autowired
    private TbSysUserDepartmentPostMapper tbSysUserDepartmentPostMapper;


    /**
     * 添加用户
     *
     * @param sysUser
     * @return
     */
    @Override
    @ServiceLog(doAction = "添加用户")
    @Transactional(rollbackFor = Exception.class)
    public void addSysUser(SysUserAdd sysUser, User user) {
        //校验岗位或部门id否有一个为空
        String departmentId = sysUser.getDepartmentId();
        String postId = sysUser.getPostId();
        String account = sysUser.getAccount();
        String warnMessage = "[用户] 新增用户失败，部门或岗位信息有一个为空！,account: {}";
        checkDepartmentIdAndPostId(departmentId, postId, account, warnMessage);

        //根据添加账号当前用户账号是否存在
        List<TbSysUser> tbSysUsers = checkAccount(account);
        if (tbSysUsers != null && tbSysUsers.size() > 0) {
            logger.warn("[用户] 新增用户失败，该用户账号已存在！,account: {}", account);
            throw new JnSpringCloudException(SysUserExceptionEnums.ADDERR_NAME_EXIST);
        }

        //生成用户实体
        TbSysUser tbSysUser = new TbSysUser();
        BeanUtils.copyProperties(sysUser, tbSysUser);
        tbSysUser.setCreatedTime(new Date());
        tbSysUser.setCreatorAccount(user.getAccount());
        if (StringUtils.isBlank(tbSysUser.getPassword())) {
            tbSysUser.setPassword( EncryptUtil.encryptSha256(RandomStringUtils.random(6, true, true)));
        }
        //添加用户信息
        tbSysUserMapper.insert(tbSysUser);
        logger.info("[用户] 新增用户信息成功！，sysUserId:{}", tbSysUser.getId());
        //如果部门岗位信息不为空
        if (StringUtils.isNotBlank(departmentId) && StringUtils.isNotBlank(postId)) {
            //为用户添加部门岗位信息
            addDepartmentPostToUser(sysUser, user, tbSysUser);
            logger.info("[用户] 用户添加部门岗位信息系成功！，sysUserId:{}", tbSysUser.getId());
        }
    }

    /**
     * 校验部门岗位id添加时是否有一个为空
     *
     * @param departmentId
     * @param postId
     * @param account
     * @param warnMessage
     */
    private void checkDepartmentIdAndPostId(String departmentId, String postId, String account, String warnMessage) {
        //判断部门岗位id是否有一个为空
        Boolean flag = (StringUtils.isNotBlank(departmentId) && StringUtils.isBlank(postId)) ||
                (StringUtils.isBlank(departmentId) && StringUtils.isNotBlank(postId));
        if (flag) {
            logger.warn(warnMessage, account);
            throw new JnSpringCloudException(SysUserExceptionEnums.ADD_DEPRTMENTPOST_ERROR);
        }
    }

    /**
     * 生成用户部门岗位关联实体
     *
     * @param sysUser
     * @param user
     * @param tbSysUser
     */
    private void addDepartmentPostToUser(SysUserAdd sysUser, User user, TbSysUser tbSysUser) {

        TbSysUserDepartmentPost sysUserDepartmentPost = new TbSysUserDepartmentPost();
        sysUserDepartmentPost.setCreatorAccount(user.getAccount());
        sysUserDepartmentPost.setId(UUID.randomUUID().toString());
        Byte recodeStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
        sysUserDepartmentPost.setRecordStatus(recodeStatus);
        sysUserDepartmentPost.setUserId(tbSysUser.getId());
        sysUserDepartmentPost.setDepartmentId(sysUser.getDepartmentId());
        sysUserDepartmentPost.setPostId(sysUser.getPostId());
        sysUserDepartmentPost.setIsDefault(SysStatusEnums.EFFECTIVE.getCode());
        sysUserDepartmentPost.setCreatedTime(new Date());

        tbSysUserDepartmentPostMapper.insertSelective(sysUserDepartmentPost);

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
        Byte recordStatus = Byte.parseByte(SysStatusEnums.DELETED.getCode());
        criteria.andRecordStatusNotEqualTo(recordStatus);
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
    public PaginationData<List<SysUserVO>> findSysUserByPage(UserPage sysUserPage) {
        //分页查询
        Page<Object> objects = PageHelper.startPage(sysUserPage.getPage(), sysUserPage.getRows());
        List<SysUserVO> sysUserVOList = null;
        if (StringUtils.isBlank(sysUserPage.getPostOrTypeName())) {
            //当查询条件中岗位或岗位类型名称为空时
            sysUserVOList = sysUserMapper.findSysUserByPage(sysUserPage);
        } else {
            //当查询条件中岗位或岗位类型名称不为空时
            sysUserVOList = sysUserMapper.getSysUserByPageAndPost(sysUserPage);
        }
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
    public void deleteSysUser(String[] ids, User user) {
        if (ids.length == 0) {
            return;
        }
        //封装删除id及更新人信息
        Map<String, Object> map = getDeleteMap(user, ids);
        sysUserMapper.deleteUserBranch(map);
        logger.info("[用户] 删除用户成功！，sysUserIds:{}", Arrays.toString(ids));
        sysUserDepartmentPostMapper.deleteUserBranch(map);
        logger.info("[用户] 删除用户关联部门岗位信息成功！，sysUserIds:{}", Arrays.toString(ids));
        sysUserRoleMapper.deleteUserBranch(map);
        logger.info("[用户] 删除用户关联角色成功！，sysUserIds:{}", Arrays.toString(ids));
        sysGroupUserMapper.deleteUserBranch(map);
        logger.info("[用户] 删除用户关联用户组成功！，sysUserIds:{}", Arrays.toString(ids));
    }

    /**
     * 更新用户
     *
     * @param sysUser
     */
    @Override
    @ServiceLog(doAction = "更新用户")
    @Transactional(rollbackFor = Exception.class)
    public void updateSysUser(SysUser sysUser, User user) {
        //判断修改信息是否存在
        TbSysUser tbSysUser1 = tbSysUserMapper.selectByPrimaryKey(sysUser.getId());
        if (tbSysUser1 == null || SysStatusEnums.DELETED.getCode().equals(tbSysUser1.getRecordStatus().toString())) {
            logger.warn("[用户] 用户修改失败,修改信息不存在,userId: {}", sysUser.getId());
            throw new JnSpringCloudException(SysExceptionEnums.UPDATEDATA_NOT_EXIST);
        } else if (StringUtils.isNotBlank(sysUser.getAccount())) {
            if (!tbSysUser1.getAccount().equals(sysUser.getAccount())) {
                //判断账号信息是否被修改
                logger.warn("[用户] 更新用户失败，用户账号不允许修改！,account: {}", sysUser.getAccount());
                throw new JnSpringCloudException(SysUserExceptionEnums.NOT_MODIFY_ACCOUNT);
            }
        }
        //判断是否修改密码
        if (StringUtils.isNotBlank(sysUser.getPassword())) {
            sysUser.setPassword(EncryptUtil.encryptSha256(sysUser.getPassword()));
        }
        //修改用户信息
        TbSysUser tbSysUser = new TbSysUser();
        BeanUtils.copyProperties(sysUser, tbSysUser);
        //设置最近一次修改时间及修改用户
        tbSysUser.setModifiedTime(new Date());
        tbSysUser.setModifierAccount(user.getAccount());
        tbSysUserMapper.updateByPrimaryKeySelective(tbSysUser);
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
    public PaginationData<SysUserGroupVO> findSysGroupByUserId(SysUserGroupPage sysUserGroupPage) {
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
        //清除用户中已经存在的用户组
        String[] ids = {userId};
        //封装删除id及更新人信息
        Map<String, Object> map = getDeleteMap(user, ids);
        sysGroupUserMapper.deleteUserBranch(map);
        logger.info("[用户] 删除用户关联用户组信息成功！，sysUserId:{}", userId);
        List<SysGroupUser> list = new ArrayList<SysGroupUser>(32);
        if (groupIds != null && groupIds.length > 0) {
            //往用户中添加新的用户组
            for (String groupId : groupIds) {
                //设置用户用户组实体类
                SysGroupUser sysGroupUser = new SysGroupUser();
                sysGroupUser.setCreatorAccount(user.getAccount());
                sysGroupUser.setGroupId(groupId);
                sysGroupUser.setUserId(userId);
                sysGroupUser.setId(UUID.randomUUID().toString());
                Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
                sysGroupUser.setRecordStatus(recordStatus);
                list.add(sysGroupUser);
            }
            sysGroupUserMapper.addGroupToUser(list);
            logger.info("[用户] 用户添加用户组成功！，sysUserId:{}", userId);
        }

    }

    /**
     * 封装删除信息
     *
     * @param user 当前用户信息
     * @param ids  用户id数组
     * @return
     */
    private Map<String, Object> getDeleteMap(User user, String[] ids) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("ids", ids);
        map.put("account", user.getAccount());
        return map;
    }

    /**
     * 根据用户id获取用户具有角色及条件分页查询用户未拥有的角色
     *
     * @param sysUserRolePage
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据用户id获取用户具有角色及条件分页查询用户未拥有的角色")
    public PaginationData<SysUserRoleVO> findSysRoleByUserId(SysUserRolePage sysUserRolePage) {
        //获取用户已经具有角色
        List<SysRole> sysRoleOfUserList = sysRoleMapper.findSysRoleByUserId(sysUserRolePage.getUserId());
        //条件分页获取用户未拥有的角色信息
        Page<Object> objects = PageHelper.startPage(sysUserRolePage.getPage(), sysUserRolePage.getRows());
        List<SysRole> otherRoleList = sysUserRoleMapper.findRoleByUserPage(sysUserRolePage);
        otherRoleList.addAll(sysRoleOfUserList);
        SysUserRoleVO sysUserRoleVO = new SysUserRoleVO(sysRoleOfUserList, otherRoleList);
        PaginationData data = new PaginationData(sysUserRoleVO, objects.getTotal());
        return data;
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
        String[] ids = {userId};
        Map<String, Object> map = getDeleteMap(user, ids);
        sysUserRoleMapper.deleteUserBranch(map);
        logger.info("[用户] 删除用户关联角色信息成功！，sysUserId:{}", userId);

        //用户添加角色信息
        List<SysUserRole> list = new ArrayList<SysUserRole>(32);
        if (roleIds != null && roleIds.length > 0) {
            //为用户添加新的角色
            for (String roleId : roleIds) {
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setCreatedTime(new Timestamp(System.currentTimeMillis()));
                sysUserRole.setCreatorAccount(user.getAccount());
                sysUserRole.setRoleId(roleId);
                sysUserRole.setUserId(userId);
                sysUserRole.setId(UUID.randomUUID().toString());
                Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
                sysUserRole.setRecordStatus(recordStatus);
                list.add(sysUserRole);
            }
            sysUserRoleMapper.insertBatch(list);
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
        String userId = sysUserDepartmentPostAdd.getUserId();
        List<TbSysUserDepartmentPost> list = new ArrayList<TbSysUserDepartmentPost>(16);
        HashSet<SysDepartmentPost> set = new HashSet<SysDepartmentPost>(16);
        if (sysUserDepartmentPostAdd.getSysDepartmentPostList() != null
                && sysUserDepartmentPostAdd.getSysDepartmentPostList().size() > 0) {
            //为用户添加新部门岗位信息
            int count = 0;
            for (SysDepartmentPost sysDepartmentPost : sysUserDepartmentPostAdd.getSysDepartmentPostList()) {
                //校验岗位或部门id否有一个为空
                String departmentId = sysDepartmentPost.getDepartmentId();
                String postId = sysDepartmentPost.getPostId();
                String warnMessage = "[用户] 用户添加部门岗位信息失败，部门或岗位信息有一个为空！,userId: {}";
                checkDepartmentIdAndPostId(departmentId, postId, userId, warnMessage);

                //生成用户关联部门岗位信息实体
                TbSysUserDepartmentPost sysUserDepartmentPost =
                        getTbSysUserDepartmentPost(user, userId, sysDepartmentPost);
                list.add(sysUserDepartmentPost);
                //判断默认部门是否超过一个
                Boolean flag =
                        SysStatusEnums.EFFECTIVE.getCode().equals(sysDepartmentPost.getIsDefault()) ? Boolean.TRUE : Boolean.FALSE;
                if (flag) {
                    count++;
                }
                //将数据添加到set中,判断用户添加的部门岗位信息是否存在重复项
                sysDepartmentPost.setIsDefault(null);
                set.add(sysDepartmentPost);
            }
            //判断部门岗位默认是否超过一个或不到一个
            if (count != 1) {
                logger.warn("[用户] 用户添加部门岗位失败,userId: {}", userId);
                throw new JnSpringCloudException(SysUserExceptionEnums.DEPARTMENTPOST_DEFAULE_NOTUNIQUE);
            }
            //判断部门岗位信息是否重复
            if (set.size() != list.size()) {
                logger.warn("[用户] 用户添加部门岗位失败,部门岗位信息重复,userId: {}", userId);
                throw new JnSpringCloudException(SysUserExceptionEnums.ADD_DEPARTMENT_POST_REPEAT);
            }
        }
        //清除用户已有岗位部门列表
        String[] ids = {userId};
        Map<String, Object> map = getDeleteMap(user, ids);
        sysUserDepartmentPostMapper.deleteUserBranch(map);
        logger.info("[用户] 删除用户关联部门岗位信息成功！，sysUserId:{}", userId);
        //用户批量添加部门岗位信息
        if (list.size() > 0) {
            sysUserMapper.addDepartmentAndPostToUserBatch(list);
        }
        logger.info("[用户] 用户添加部门岗位成功！，sysUserId:{}", userId);
    }

    /**
     * 生成用户部门岗位实体
     *
     * @param user
     * @param userId
     * @param sysDepartmentPost
     * @return
     */
    private TbSysUserDepartmentPost getTbSysUserDepartmentPost(User user, String userId, SysDepartmentPost sysDepartmentPost) {
        TbSysUserDepartmentPost sysUserDepartmentPost = new TbSysUserDepartmentPost();
        sysUserDepartmentPost.setCreatorAccount(user.getAccount());
        sysUserDepartmentPost.setId(UUID.randomUUID().toString());
        Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
        sysUserDepartmentPost.setRecordStatus(recordStatus);
        sysUserDepartmentPost.setUserId(userId);
        sysUserDepartmentPost.setDepartmentId(sysDepartmentPost.getDepartmentId());
        sysUserDepartmentPost.setPostId(sysDepartmentPost.getPostId());
        sysUserDepartmentPost.setIsDefault(sysDepartmentPost.getIsDefault());
        return sysUserDepartmentPost;
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
        TbSysUserCriteria.Criteria criteria = tbSysUserCriteria.createCriteria();
        if (com.jn.common.util.StringUtils.isNotBlank(user.getAccount())) {
            criteria.andAccountEqualTo(user.getAccount());
        }
        if(StringUtils.isNotBlank(user.getId())){
            criteria.andIdEqualTo(user.getId());
        }
        Byte recordStatus = Byte.parseByte(SysStatusEnums.DELETED.getCode());
        criteria.andRecordStatusNotEqualTo(recordStatus);
        List<TbSysUser> tbSysUsers = tbSysUserMapper.selectByExample(tbSysUserCriteria);
        List<User> users = new ArrayList<>();
        for (TbSysUser tbSysUser1 : tbSysUsers) {
            User user1 = new User();
            BeanUtils.copyProperties(tbSysUser1, user1);
            user1.setSysRole(sysRoleMapper.findSysRoleByUserId(tbSysUser1.getId()));
            user1.setSysDepartmentPostVO(sysUserDepartmentPostMapper.findDepartmentAndPostByUserId(tbSysUser1.getId()));
            users.add(user1);
        }
        return users;
    }

    /**
     * 获取所有有效用户信息
     *
     * @return
     */
    @Override
    public List<User> getUserAll() {
        List<User> userList = sysUserMapper.getUserAll();
        return userList;
    }

    /**
     * 通过用户账号,获取用户信息,多个账号,返回多个用户信息
     *
     * @param accountList 账号集合
     * @return
     */
    @Override
    @ServiceLog(doAction = "通过用户账号,获取用户信息")
    public List<User> getUserInfoByAccount(List<String> accountList) {
        if (accountList != null && accountList.size() > 0) {
            List<User> userList = sysUserMapper.getUserInfoByAccount(accountList);
            return userList;
        } else {
            return null;
        }
    }

    /**
     * 修改用户角色信息
     *
     * @param user        用户对象,传账号id都可以,都传,优先使用id操作
     * @param deleRoleIds 删除的角色id集合,不删除集合传空集合
     * @param addRoleIds  新增的角色id集合,不新增集合传空集合
     * @return
     */
    @Override
    @ServiceLog(doAction = "修改用户角色信息")
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateUserRole(User user, Set<String> deleRoleIds, Set<String> addRoleIds) {
        //1.查询用户id
        if (StringUtils.isBlank(user.getId())) {
            Assert.notNull(user.getAccount(), SysUserExceptionEnums.ACCOUNT_NOT_NULL.getMessage());
            TbSysUserCriteria tbSysUserCriteria = new TbSysUserCriteria();
            TbSysUserCriteria.Criteria criteria = tbSysUserCriteria.createCriteria();
            criteria.andAccountEqualTo(user.getAccount());
            criteria.andRecordStatusEqualTo(new Byte(SysStatusEnums.EFFECTIVE.getCode()));
            List<TbSysUser> tbSysUsers = tbSysUserMapper.selectByExample(tbSysUserCriteria);
            if (tbSysUsers != null && tbSysUsers.size() > 0) {
                user.setId(tbSysUsers.get(0).getId());
            } else {
                throw new JnSpringCloudException(SysExceptionEnums.UPDATEDATA_NOT_EXIST);
            }
        }
        String userId = user.getId();

        //2.删除用户角色
        if (deleRoleIds != null && deleRoleIds.size() > 0) {
            sysUserRoleMapper.deleteUserRole(userId, deleRoleIds);
        }

        //3.添加新的角色信息
        if (addRoleIds != null && addRoleIds.size() > 0) {
            //为了防止角色重复添加,对添加角色进行去重操作
            Set<String> roleIdSet = sysUserRoleMapper.getRoleIdByUserId(userId);
            if (roleIdSet != null && roleIdSet.size() > 0) {
                addRoleIds.removeAll(roleIdSet);
            }
            //对添加集合去重
            if (addRoleIds != null && addRoleIds.size() > 0){
                List<SysUserRole> sysUserRoleList = new ArrayList<SysUserRole>(16);
                for (String roleId : addRoleIds) {
                    SysUserRole sysUserRole = new SysUserRole();
                    sysUserRole.setId(UUID.randomUUID().toString());
                    sysUserRole.setUserId(userId);
                    sysUserRole.setRoleId(roleId);
                    sysUserRole.setRecordStatus(new Byte(SysStatusEnums.EFFECTIVE.getCode()));
                    sysUserRoleList.add(sysUserRole);
                }
                //将数据保存只数据库
                sysUserRoleMapper.insertBatch(sysUserRoleList);
            }
        }
        return true;
    }

    /**
     * 根据用户id，查询用户信息
     *
     * @param ids 用户数组
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据用户id，查询用户信息")
    public List<SysTUser> selectUserByIds(String[] ids) {
        return sysUserMapper.selectUserByIds(ids);
    }
}
