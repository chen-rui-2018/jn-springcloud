package com.jn.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.GetEasyUIData;
import com.jn.common.util.StringUtils;
import com.jn.system.dao.TbSysUserMapper;
import com.jn.system.dao.UserMapper;
import com.jn.system.dao.UserRoleMapper;
import com.jn.system.entity.TbSysUser;
import com.jn.system.entity.TbSysUserCriteria;
import com.jn.system.model.User;
import com.jn.system.model.UserAdd;
import com.jn.system.model.UserPage;
import com.jn.system.model.UserRole;
import com.jn.system.service.UserService;
import com.jn.system.vo.UserVO;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**
 * 用户
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;


    @Autowired
    private TbSysUserMapper tbSysUserMapper;

    @Override
    @Transactional
    public void insertUser(UserAdd user) {
        String[] roleId = user.getRoleId();
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        user.setId(UUID.randomUUID().toString());
        userMapper.insert(user);
        if (roleId == null) {
            return;
        }
        for (int i = 0; i < roleId.length; i++) {
            userRoleMapper.insert(new UserRole(UUID.randomUUID().toString()
                    , user.getId(), roleId[i]));
        }
    }

    @Override
    @Transactional
    public void updateUser(UserAdd user) {
        String[] roleId = user.getRoleId();
        if (!"".equals(user.getPassword())) {
            user.setPassword(DigestUtils.md5Hex(user.getPassword()));
            userMapper.updateByPrimaryKey(user);
        }
        userMapper.updateNoPasswordByPrimaryKey(user);

        userRoleMapper.deleteByT(new UserRole[]{new UserRole(null, user.getId(), null)});


        if (roleId == null) {
            return;
        }
        for (int i = 0; i < roleId.length; i++) {
            userRoleMapper.insert(new UserRole(UUID.randomUUID().toString()
                    , user.getId(), roleId[i]));
        }
    }

    @Override
    @Transactional
    public void deleteUser(String[] id) {
        UserRole[] u = new UserRole[id.length];
        for (int i = 0; i < id.length; i++) {
            u[i] = new UserRole(null, id[i], null);
        }
        userRoleMapper.deleteByT(u);
        userMapper.deleteBy(id);

    }

    @Override
    public User selectByPrimaryKey() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        User u = userMapper.selectByPrimaryKey(user.getId());
        u.setPassword("");
        return u;
    }

    @Override
    public void updatePassword(UserAdd user) {
        if (!"".equals(user.getPassword())) {
            user.setPassword(DigestUtils.md5Hex(user.getPassword()));
            userMapper.updateByPrimaryKey(user);
        }
        userMapper.updateNoPasswordByPrimaryKey(user);
    }

    @Override
    public GetEasyUIData findTByPage(UserPage user) {
        Page<Object> objects = PageHelper.startPage(user.getPage(), user.getRows());
        return new GetEasyUIData(userMapper.findTByPage(user)
                , objects.getTotal());
    }


    @Override
    public UserVO selectByPrimaryKey(String id) {
        UserVO u = userMapper.selectVOByPrimaryKey(id);
        u.setPassword("");
        u.setUserRoleList(userRoleMapper.findTByT(new UserRole(null, id, null)));
        return u;
    }

    @Override
    public List<User> findTByT(User user) {
        TbSysUserCriteria tbSysUserCriteria = new TbSysUserCriteria();
        if (StringUtils.isNotBlank(user.getAccount())){
            tbSysUserCriteria.createCriteria().andAccountLike(user.getAccount());
        }
        List<TbSysUser> tbSysUsers = tbSysUserMapper.selectByExample(tbSysUserCriteria);
        List<User> users = new ArrayList<>();
        for (TbSysUser tbSysUser1 : tbSysUsers) {
            User user1 = new User();
            BeanUtils.copyProperties(tbSysUser1,user1);
            users.add(user1);
        }
        return users;
    }

    @Override
    public void deleteByT(UserRole[] u) {
        userRoleMapper.deleteByT(u);

    }

}
