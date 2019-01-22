package com.jn.system.dept.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.system.common.enums.SysExceptionEnums;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.dept.dao.SysPostMapper;
import com.jn.system.dept.dao.SysUserDepartmentPostMapper;
import com.jn.system.dept.dao.TbSysPostMapper;
import com.jn.system.dept.entity.TbSysPost;
import com.jn.system.dept.entity.TbSysPostCriteria;
import com.jn.system.dept.model.SysPost;
import com.jn.system.dept.model.SysPostPage;
import com.jn.system.dept.service.SysPostService;
import com.jn.system.log.annotation.ServiceLog;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

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

    private static Logger logger = LoggerFactory.getLogger(SysPostServiceImpl.class);

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
        tbSysPostCriteria.setOrderByClause("created_time desc");
        TbSysPostCriteria.Criteria criteria = tbSysPostCriteria.createCriteria();
        Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
        criteria.andRecordStatusEqualTo(recordStatus);
        List<TbSysPost> sysPostList = tbSysPostMapper.selectByExample(tbSysPostCriteria);
        return sysPostList;
    }


    /**
     * 增加岗位
     *
     * @param tbSysPost
     */
    @Override
    @ServiceLog(doAction = "增加岗位")
    @Transactional(rollbackFor = Exception.class)
    public void addPost(TbSysPost tbSysPost) {
        List<TbSysPost> tbSysPosts = checkName(tbSysPost.getPostName());
        if (tbSysPosts != null && tbSysPosts.size() > 0) {
            logger.warn("[岗位] 新增岗位失败，该岗位名称已存在！,postName: {}", tbSysPost.getPostName());
            throw new JnSpringCloudException(SysExceptionEnums.ADDERR_NAME_EXIST);
        }
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
        Byte recordStatus = Byte.parseByte(SysStatusEnums.DELETED.getCode());
        criteria.andRecordStatusNotEqualTo(recordStatus);
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
        logger.info("[岗位] 批量删除岗位成功！，sysPostIds:{}", Arrays.toString(ids));
        sysUserDepartmentPostMapper.deletePostBranch(ids);
        logger.info("[岗位] 批量删除岗位关联用户信息成功！，sysPostIds:{}", Arrays.toString(ids));
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
        String postName = sysPost.getPostName();
        //判断被修改信息是否存在
        TbSysPost sysPost1 = tbSysPostMapper.selectByPrimaryKey(sysPost.getId());
        if (sysPost1 == null || SysStatusEnums.DELETED.getCode().equals(sysPost1.getRecordStatus().toString())) {
            logger.warn("[部门] 岗位修改失败,修改信息不存在,postId: {}", sysPost.getId());
            throw new JnSpringCloudException(SysExceptionEnums.UPDATEDATA_NOT_EXIST);
        } else {
            //判断名称是否被修改
            if (!sysPost1.getPostName().equals(postName)) {
                //名称被修改,判断修改的名称数据库是都已经存在
                String flag = checkPostName(postName);
                if (SysReturnMessageEnum.FAIL.getMessage().equals(flag)) {
                    //数据库已经存在名称,则不允许修改
                    logger.warn("[岗位] 修改岗位失败，该岗位名称已存在！,postName: {}", sysPost.getPostName());
                    throw new JnSpringCloudException(SysExceptionEnums.UPDATEERR_NAME_EXIST);
                }
            }
        }
        //对信息进行修改操作
        TbSysPost tbSysPost = new TbSysPost();
        BeanUtils.copyProperties(sysPost, tbSysPost);
        tbSysPostMapper.updateByPrimaryKeySelective(tbSysPost);
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
     * 条件分页获取岗位信息列表
     *
     * @param sysPostPage
     * @return
     */
    @Override
    @ServiceLog(doAction = "条件分页获取岗位信息列表")
    public PaginationData findByPage(SysPostPage sysPostPage) {
        Page<Object> objects = PageHelper.startPage(sysPostPage.getPage(), sysPostPage.getRows());
        List<SysPost> sysPostList = sysPostMapper.findByPage(sysPostPage);
        PaginationData data = new PaginationData(sysPostList, objects.getTotal());
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
