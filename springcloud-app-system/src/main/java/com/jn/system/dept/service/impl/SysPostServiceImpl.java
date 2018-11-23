package com.jn.system.dept.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.system.dept.dao.SysPostMapper;
import com.jn.system.dept.dao.SysUserDepartmentPostMapper;
import com.jn.system.common.enums.SysExceptionEnums;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.dept.dao.TbSysPostMapper;
import com.jn.system.dept.entity.TbSysPost;
import com.jn.system.dept.entity.TbSysPostCriteria;
import com.jn.system.dept.model.SysPost;
import com.jn.system.dept.model.SysPostAdd;
import com.jn.system.dept.model.SysPostPage;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.system.dept.service.SysPostService;
import com.jn.system.dept.vo.SysPostVO;
import org.apache.commons.lang3.StringUtils;
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
    @ServiceLog(doAction = "查询所有岗位")
    public List<TbSysPost> findSysPostAll() {
        TbSysPostCriteria tbSysPostCriteria = new TbSysPostCriteria();
        TbSysPostCriteria.Criteria criteria = tbSysPostCriteria.createCriteria();
        criteria.andStatusEqualTo(SysStatusEnums.EFFECTIVE.getCode());
        List<TbSysPost> sysPostList = tbSysPostMapper.selectByExample(tbSysPostCriteria);
        return sysPostList;
    }


    /**
     * 增加岗位
     *
     * @param sysPostAdd
     */
    @Override
    @ServiceLog(doAction = "增加岗位")
    @Transactional(rollbackFor = Exception.class)
    public void addPost(SysPostAdd sysPostAdd,User user) {
        List<TbSysPost> tbSysPosts = checkName(sysPostAdd.getPostName());
        if (tbSysPosts != null && tbSysPosts.size() > 0) {
            logger.info("[岗位] 新增岗位失败，该岗位名称已存在！,postName: {}",sysPostAdd.getPostName());
            throw new JnSpringCloudException(SysExceptionEnums.ADDERR_NAME_EXIST);
        }
        TbSysPost tbSysPost = new TbSysPost();
        tbSysPost.setId(UUID.randomUUID().toString());
        tbSysPost.setCreator(user.getId());
        tbSysPost.setStatus(sysPostAdd.getStatus());
        tbSysPost.setCreateTime(new Date());
        tbSysPost.setPostName(sysPostAdd.getPostName());
        tbSysPostMapper.insertSelective(tbSysPost);
        logger.info("[岗位] 新增岗位成功！，sysPostId:{}", tbSysPost.getId());
    }

    /**
     * 用于岗位名称校验
     *
     * @param postName
     * @return
     */
    private List<TbSysPost> checkName(String postName) {
        TbSysPostCriteria tbSysPostCriteria = new TbSysPostCriteria();
        TbSysPostCriteria.Criteria criteria = tbSysPostCriteria.createCriteria();
        criteria.andPostNameEqualTo(postName);
        criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getCode());
        return tbSysPostMapper.selectByExample(tbSysPostCriteria);
    }

    /**
     * 批量删除岗位
     *
     * @param ids
     */
    @Override
    @ServiceLog(doAction = "批量删除岗位")
    @Transactional(rollbackFor = Exception.class)
    public void deletePostBranch(String[] ids) {
        sysPostMapper.deletePostBranch(ids);
        sysUserDepartmentPostMapper.deletePostBranch(ids);
        logger.info("[岗位] 批量删除岗位成功！，sysPostIds:{}", ids.toString());
    }

    /**
     * 修改岗位信息
     *
     * @param sysPost
     */
    @Override
    @ServiceLog(doAction = "修改岗位信息")
    @Transactional(rollbackFor = Exception.class)
    public void updatePost(SysPost sysPost) {
        TbSysPostCriteria tbSysPostCriteria = new TbSysPostCriteria();
        TbSysPostCriteria.Criteria criteria = tbSysPostCriteria.createCriteria();
        criteria.andPostNameEqualTo(sysPost.getPostName());
        criteria.andIdNotEqualTo(sysPost.getId());
        criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getCode());
        List<TbSysPost> tbSysPosts = tbSysPostMapper.selectByExample(tbSysPostCriteria);
        if (tbSysPosts != null && tbSysPosts.size() > 0) {
            logger.info("[岗位] 修改岗位失败，该岗位名称已存在！,postName: {}",sysPost.getPostName());
            throw new JnSpringCloudException(SysExceptionEnums.UPDATEERR_NAME_EXIST);
        }
        sysPostMapper.updatePost(sysPost);
        logger.info("[岗位] 修改岗位信息成功！，sysPostId:{}", sysPost.getId());
    }

    /**
     * 根据岗位id获取岗位信息
     *
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据岗位id获取岗位信息")
    public SysPost selectByPrimaryKey(String id) {
        TbSysPost tbSysPost = tbSysPostMapper.selectByPrimaryKey(id);
        SysPost sysPost = new SysPost();
        if (tbSysPost != null) {
            BeanUtils.copyProperties(tbSysPost, sysPost);
        }
        return sysPost;
    }

    /**
     * 分页获取岗位信息及对应的用户
     *
     * @param sysPostPage
     * @return
     */
    @Override
    @ServiceLog(doAction = "分页获取岗位信息及对应的用户")
    public PaginationData findByPage(SysPostPage sysPostPage) {
        Page<Object> objects = PageHelper.startPage(sysPostPage.getPage(), sysPostPage.getRows());
        List<SysPostVO> sysPostVOList = sysPostMapper.findByPage(sysPostPage);
        PaginationData data = new PaginationData(sysPostVOList, objects.getTotal());
        return data;
    }

    /**
     * 校验岗位名称是否已存在
     *
     * @param postName
     * @return
     */
    @Override
    @ServiceLog(doAction = "校验岗位名称是否已存在")
    public String checkPostName(String postName) {
        if (StringUtils.isNotBlank(postName)) {
            List<TbSysPost> tbSysPosts = checkName(postName);
            if (tbSysPosts != null && tbSysPosts.size() > 0) {
                return SysReturnMessageEnum.FAIL.getMessage();
            }
        }
        return SysReturnMessageEnum.SUCCESS.getMessage();
    }

}
