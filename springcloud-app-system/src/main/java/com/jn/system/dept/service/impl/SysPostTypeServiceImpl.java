package com.jn.system.dept.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.common.enums.SysExceptionEnums;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.dept.dao.TbSysPostMapper;
import com.jn.system.dept.dao.TbSysPostTypeMapper;
import com.jn.system.dept.entity.TbSysPost;
import com.jn.system.dept.entity.TbSysPostCriteria;
import com.jn.system.dept.entity.TbSysPostType;
import com.jn.system.dept.entity.TbSysPostTypeCriteria;
import com.jn.system.dept.enums.SysPostExceptionEnums;
import com.jn.system.dept.model.SysPostType;
import com.jn.system.dept.model.SysPostTypePage;
import com.jn.system.dept.service.SysPostTypeService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 岗位类型管理service实现
 *
 * @author： shaobao
 * @date： Created on 2018/12/10 11:37
 * @version： v1.0
 * @modified By:
 **/
@Service
public class SysPostTypeServiceImpl implements SysPostTypeService {

    private static Logger logger = LoggerFactory.getLogger(SysPostTypeServiceImpl.class);

    @Autowired
    private TbSysPostTypeMapper tbSysPostTypeMapper;
    @Autowired
    private TbSysPostMapper tbSysPostMapper;

    /**
     * 增加岗位类型
     *
     * @param tbSysPostType 岗位类型增加实体
     */
    @Override
    @ServiceLog(doAction = "增加岗位类型")
    @Transactional(rollbackFor = Exception.class)
    public void add(TbSysPostType tbSysPostType) {
        String postTypeName = tbSysPostType.getPostTypeName();
        //校验添加岗位类型名称是否已经存在
        String flag = checkPostTypeName(postTypeName);
        if (SysReturnMessageEnum.FAIL.getMessage().equals(flag)) {
            logger.warn("[岗位类型] 新增岗位类型失败，该岗位类型名称已存在！,postTypeName: {}", postTypeName);
            throw new JnSpringCloudException(SysExceptionEnums.ADDERR_NAME_EXIST);
        }
        //添加岗位类型
        tbSysPostTypeMapper.insertSelective(tbSysPostType);
        logger.info("[岗位类型] 添加岗位类型成功,postTypeId:{}", tbSysPostType.getId());
    }

    /**
     * 列表查询岗位类型
     *
     * @param postTypePage 岗位类型分页实体
     * @return
     */
    @Override
    @ServiceLog(doAction = "列表查询岗位类型")
    public PaginationData getPostTypeByPage(SysPostTypePage postTypePage) {
        String postTypeName = postTypePage.getPostTypeName();
        Byte status = postTypePage.getRecordStatus();

        //条件分页查询
        Page<Object> objects = PageHelper.startPage(postTypePage.getPage(), postTypePage.getRows());
        TbSysPostTypeCriteria tbSysPostTypeCriteria = new TbSysPostTypeCriteria();
        //设置排序及查询条件
        tbSysPostTypeCriteria.setOrderByClause("created_time desc,id desc");
        TbSysPostTypeCriteria.Criteria criteria = tbSysPostTypeCriteria.createCriteria();
        Byte recordStatus = Byte.parseByte(SysStatusEnums.DELETED.getCode());
        criteria.andRecordStatusNotEqualTo(recordStatus);
        if (StringUtils.isNotBlank(postTypeName)) {
            //根据岗位类型名称,模糊查询
            criteria.andPostTypeNameLike("%" + postTypeName + "%");
        }
        if (status != null) {
            //根据岗位类型状态查询
            criteria.andRecordStatusEqualTo(status);
        }
        List<TbSysPostType> tbSysPostTypes = tbSysPostTypeMapper.selectByExample(tbSysPostTypeCriteria);
        return new PaginationData(tbSysPostTypes, objects.getTotal());
    }

    /**
     * 校验岗位类型名称是否存在
     *
     * @param postTypeName 岗位类型分页实体
     * @return
     */
    @Override
    @ServiceLog(doAction = "校验岗位类型名称是否存在")
    public String checkPostTypeName(String postTypeName) {
        if (StringUtils.isNotBlank(postTypeName)) {
            //设置查询条件
            TbSysPostTypeCriteria tbSysPostTypeCriteria = new TbSysPostTypeCriteria();
            TbSysPostTypeCriteria.Criteria criteria = tbSysPostTypeCriteria.createCriteria();
            Byte recordStatus = Byte.parseByte(SysStatusEnums.DELETED.getCode());
            criteria.andRecordStatusNotEqualTo(recordStatus);
            criteria.andPostTypeNameEqualTo(postTypeName);
            List<TbSysPostType> tbSysPostTypes = tbSysPostTypeMapper.selectByExample(tbSysPostTypeCriteria);
            //如果查询结果不为空,返回fail
            if (tbSysPostTypes != null && tbSysPostTypes.size() > 0) {
                return SysReturnMessageEnum.FAIL.getMessage();
            }
        }
        //返回名称乐意用
        return SysReturnMessageEnum.SUCCESS.getMessage();
    }

    /**
     * 修改岗位类型信息
     *
     * @param postType
     * @param user     当前用户信息
     */
    @Override
    @ServiceLog(doAction = "修改岗位类型")
    @Transactional(rollbackFor = Exception.class)
    public void update(SysPostType postType, User user) {
        String postTypeName = postType.getPostTypeName();
        String postTypeId = postType.getId();
        TbSysPostType tbSysPostType1 = tbSysPostTypeMapper.selectByPrimaryKey(postTypeId);
        //1.判断修改信息是否存在
        if (tbSysPostType1 == null || SysStatusEnums.DELETED.getCode().equals(tbSysPostType1.getRecordStatus().toString())) {
            logger.warn("[岗位类型] 岗位类型修改失败,修改信息不存在,postTypeId: {}", postTypeId);
            throw new JnSpringCloudException(SysExceptionEnums.UPDATEDATA_NOT_EXIST);
        }

        //2.判断是否修改了岗位类型状态
        if (SysStatusEnums.EFFECTIVE.getCode().equals(tbSysPostType1.getRecordStatus()) &&
                SysStatusEnums.INVALID.getCode().equals(postType.getRecordStatus().toString())) {
            //如果修改状态,判断当前岗位类型是否正在被使用,若正在被使用,不允许修改
            List<TbSysPost> tbSysPosts = getTbSysPosts(postTypeId);
            if (tbSysPosts != null && tbSysPosts.size() > 0) {
                logger.warn("[岗位类型] 修改岗位类型失败，岗位类型正在被使用,不允许修改为无效！,postTypeId: {}",
                        postTypeId);
                throw new JnSpringCloudException(SysPostExceptionEnums.UPDATE_STATUS_ERR);
            }
        }

        //3.判断名称是否修改,若修改,判断修改后的名称是否已经存在
        Boolean flag = tbSysPostType1.getPostTypeName().equals(postTypeName);
        if (!flag) {
            String result = checkPostTypeName(postTypeName);
            if (SysReturnMessageEnum.FAIL.getMessage().equals(result)) {
                logger.warn("[岗位类型] 修改岗位类型失败，该岗位类型名称已存在！,postTypeId: {}", postTypeId);
                throw new JnSpringCloudException(SysExceptionEnums.UPDATEERR_NAME_EXIST);
            }
        }

        //4.对岗位类型信息进行修改
        TbSysPostType tbSysPostType = new TbSysPostType();
        BeanUtils.copyProperties(postType, tbSysPostType);
        //设置最近更新人信息
        tbSysPostType.setModifiedTime(new Date());
        tbSysPostType.setModifierAccount(user.getAccount());
        tbSysPostTypeMapper.updateByPrimaryKeySelective(tbSysPostType);
        logger.info("[岗位类型] 修改岗位类型成功,postTypeId:{}", tbSysPostType.getId());
    }

    /**
     * 删除岗位类型
     *
     * @param postTypeId
     * @param user       当前用户信息
     * @return
     */
    @Override
    @ServiceLog(doAction = "删除岗位类型")
    @Transactional(rollbackFor = Exception.class)
    public Result delete(String postTypeId, User user) {
        Result result = new Result();
        if (StringUtils.isNotBlank(postTypeId)) {
            //判断该岗位类型,是否正在被岗位使用
            List<TbSysPost> tbSysPosts = getTbSysPosts(postTypeId);
            //如果岗位类型正在被使用,则不允许删除
            if (tbSysPosts != null && tbSysPosts.size() > 0) {
                logger.info("[岗位类型] 删除岗位类型失败,岗位类型正在被使用,不允许删除,postTypeId:{}", postTypeId);
                result.setCode(SysPostExceptionEnums.DELETE_ERR_POSTTYPE.getCode());
                result.setResult(SysPostExceptionEnums.DELETE_ERR_POSTTYPE.getMessage());
                return result;
            } else {
                //没有被使用,进行删除操作
                TbSysPostType tbSysPostType = tbSysPostTypeMapper.selectByPrimaryKey(postTypeId);
                if (tbSysPostType != null) {
                    Byte recordStatus = Byte.parseByte(SysStatusEnums.DELETED.getCode());
                    tbSysPostType.setRecordStatus(recordStatus);
                    tbSysPostType.setModifiedTime(new Date());
                    tbSysPostType.setModifierAccount(user.getAccount());
                    tbSysPostTypeMapper.updateByPrimaryKeySelective(tbSysPostType);
                }
            }
        }
        logger.info("[岗位类型] 删除岗位类型成功,postTypeId:{}", postTypeId);
        return result;
    }

    /**
     * 根据岗位类型id获取岗位信息
     *
     * @param postTypeId
     * @return
     */
    private List<TbSysPost> getTbSysPosts(String postTypeId) {
        TbSysPostCriteria tbSysPostCriteria = new TbSysPostCriteria();
        TbSysPostCriteria.Criteria criteria = tbSysPostCriteria.createCriteria();
        Byte recordStatus = Byte.parseByte(SysStatusEnums.DELETED.getCode());
        criteria.andRecordStatusNotEqualTo(recordStatus);
        criteria.andPostTypeIdEqualTo(postTypeId);
        return tbSysPostMapper.selectByExample(tbSysPostCriteria);
    }

    /**
     * 获取所有岗位类型
     *
     * @return
     */
    @Override
    @ServiceLog(doAction = "获取所有岗位类型")
    public List<TbSysPostType> getPostTypeAll() {
        TbSysPostTypeCriteria tbSysPostTypeCriteria = new TbSysPostTypeCriteria();
        //设置排序及查询条件
        tbSysPostTypeCriteria.setOrderByClause("created_time desc,id desc");
        TbSysPostTypeCriteria.Criteria criteria = tbSysPostTypeCriteria.createCriteria();
        Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
        criteria.andRecordStatusEqualTo(recordStatus);
        tbSysPostTypeCriteria.createCriteria();
        //进行查询
        List<TbSysPostType> tbSysPostTypes = tbSysPostTypeMapper.selectByExample(tbSysPostTypeCriteria);
        return tbSysPostTypes;
    }
}
