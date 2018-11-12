package com.jn.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.dao.SysPostMapper;
import com.jn.system.dao.SysUserDepartmentPostMapper;
import com.jn.system.dao.TbSysPostMapper;
import com.jn.system.entity.TbSysPost;
import com.jn.system.entity.TbSysPostCriteria;
import com.jn.system.enums.SysStatusEnums;
import com.jn.system.model.*;
import com.jn.system.service.SysPostService;
import com.jn.system.vo.SysPostVO;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 岗位service实现
 *
 * @author： shaobao
 * @date： Created on 2018/10/31 15:55
 * @version： v1.0
 * @modified By:
 **/
@Service
public class SysPostServiceImpl implements SysPostService {

    private Logger logger = LoggerFactory.getLogger(SysPostServiceImpl.class);

    @Autowired
    private TbSysPostMapper tbSysPostMapper;
    @Autowired
    private SysPostMapper sysPostMapper;
    @Autowired
    private SysUserDepartmentPostMapper sysUserDepartmentPostMapper;


    /**
     * 查询所有岗位
     *
     * @return
     */
    @Override
    public Result findSysPostAll() {
        Result result = new Result();
        TbSysPostCriteria tbSysPostCriteria = new TbSysPostCriteria();
        TbSysPostCriteria.Criteria criteria = tbSysPostCriteria.createCriteria();
        criteria.andStatusEqualTo(SysStatusEnums.EFFECTIVE.getKey());
        List<TbSysPost> sysPostList = tbSysPostMapper.selectByExample(tbSysPostCriteria);
        result.setData(sysPostList);
        return result;
    }


    /**
     * 增加岗位
     *
     * @param sysPostAdd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addPost(SysPostAdd sysPostAdd) {
        TbSysPostCriteria tbSysPostCriteria = new TbSysPostCriteria();
        TbSysPostCriteria.Criteria criteria = tbSysPostCriteria.createCriteria();
        criteria.andPostNameEqualTo(sysPostAdd.getPostName());
        List<TbSysPost> tbSysPosts = tbSysPostMapper.selectByExample(tbSysPostCriteria);
        if (tbSysPosts != null && tbSysPosts.size() > 0) {
            return "用户名已存在";
        }
        TbSysPost tbSysPost = new TbSysPost();
        tbSysPost.setId(UUID.randomUUID().toString());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        tbSysPost.setCreator(user.getId());
        tbSysPost.setStatus(sysPostAdd.getStatus());
        tbSysPost.setCreateTime(new Date());
        tbSysPost.setPostName(sysPostAdd.getPostName());
        tbSysPostMapper.insertSelective(tbSysPost);
        logger.info("[岗位]新增岗位成功！，sysPostId:{}", tbSysPost.getId());
        return "添加成功";
    }

    /**
     * 批量删除岗位
     *
     * @param ids
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletePostBranch(String[] ids) {
        sysPostMapper.deletePostBranch(ids);
        sysUserDepartmentPostMapper.deletePostBranch(ids);
        logger.info("[岗位]批量删除岗位成功！，sysPostIds:{}", ids.toString());
    }

    /**
     * 修改岗位信息
     *
     * @param sysPost
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePost(SysPost sysPost) {
        sysPostMapper.updatePost(sysPost);
        logger.info("[岗位]修改岗位信息成功！，sysPostId:{}", sysPost.getId());
    }

    /**
     * 根据岗位id获取岗位信息
     *
     * @param id
     * @return
     */
    @Override
    public Result selectByPrimaryKey(String id) {
        TbSysPost tbSysPost = tbSysPostMapper.selectByPrimaryKey(id);
        SysPost sysPost = new SysPost();
        if (tbSysPost != null) {
            BeanUtils.copyProperties(tbSysPost, sysPost);
        }
        return new Result(sysPost);
    }

    /**
     * 分页获取岗位信息及对应的用户
     *
     * @param sysPostPage
     * @return
     */
    @Override
    public Result findByPage(SysPostPage sysPostPage) {
        Page<Object> objects = PageHelper.startPage(sysPostPage.getPage(), sysPostPage.getRows());
        List<SysPostVO> sysPostVOList = sysPostMapper.findByPage(sysPostPage);
        for (SysPostVO sysPostVO : sysPostVOList) {
            List<SysTUser> sysTUserList = sysUserDepartmentPostMapper.findUserByPostId(sysPostVO.getId());
            sysPostVO.setSysTUserList(sysTUserList);
        }
        PaginationData data = new PaginationData(sysPostVOList, objects.getTotal());
        return new Result(data);
    }

}
