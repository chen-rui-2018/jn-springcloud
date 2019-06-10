package com.jn.system.dict.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.system.common.enums.SysExceptionEnums;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.dict.dao.SysDictModuleMapper;
import com.jn.system.dict.dao.TbSysDictMapper;
import com.jn.system.dict.dao.TbSysDictModuleMapper;
import com.jn.system.dict.entity.TbSysDict;
import com.jn.system.dict.entity.TbSysDictCriteria;
import com.jn.system.dict.entity.TbSysDictModule;
import com.jn.system.dict.entity.TbSysDictModuleCriteria;
import com.jn.system.dict.enums.SysDictExceptionEnums;
import com.jn.system.dict.model.SysDictModule;
import com.jn.system.dict.model.SysDictModulePage;
import com.jn.system.dict.service.SysDictModuleService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 模块管理service
 *
 * @author： shaobao
 * @date： Created on 2019/1/25 14:35
 * @version： v1.0
 * @modified By:
 **/
@Service
public class SysDictModuleServiceImpl implements SysDictModuleService {

    private static final Logger logger = LoggerFactory.getLogger(SysDictServiceImpl.class);

    @Autowired
    private TbSysDictModuleMapper tbSysModuleMapper;
    @Autowired
    private TbSysDictMapper tbSysDictMapper;
    @Autowired
    private SysDictModuleMapper sysDictModuleMapper;

    /**
     * 添加模块
     *
     * @param tbSysModule
     */
    @Override
    @ServiceLog(doAction = "添加模块")
    @Transactional(rollbackFor = Exception.class)
    public void add(TbSysDictModule tbSysModule) {
        //1.判断模块编码是否已经存在
        TbSysDictModuleCriteria tbSysModuleCriteria = new TbSysDictModuleCriteria();
        TbSysDictModuleCriteria.Criteria criteria = tbSysModuleCriteria.createCriteria();
        Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
        criteria.andRecordStatusEqualTo(recordStatus);
        criteria.andModuleCodeEqualTo(tbSysModule.getModuleCode());
        List<TbSysDictModule> tbSysModules = tbSysModuleMapper.selectByExample(tbSysModuleCriteria);
        if (tbSysModules != null && tbSysModules.size() > 0) {
            logger.warn("[模块] 添加失败,模块编码已存在！，moduleCode:{}", tbSysModule.getModuleCode());
            throw new JnSpringCloudException(SysDictExceptionEnums.MODULE_KEY_REPEAAT);
        }

        //2.添加数据
        tbSysModuleMapper.insertSelective(tbSysModule);
        logger.info("[模块] 添加成功,moduleId: {}", tbSysModule.getId());
    }

    /**
     * 更新模块
     *
     * @param tbSysModule
     */
    @Override
    @ServiceLog(doAction = "更新模块")
    @Transactional(rollbackFor = Exception.class)
    public void update(TbSysDictModule tbSysModule) {
        String moduleId = tbSysModule.getId();
        String moduleCode = tbSysModule.getModuleCode();

        //1.判断更新数据是否存在
        TbSysDictModule tbSysModule1 = tbSysModuleMapper.selectByPrimaryKey(moduleId);
        if (tbSysModule1 == null || SysStatusEnums.DELETED.equals(tbSysModule1.getRecordStatus().toString())) {
            logger.warn("[数据字典] 修改失败,修改信息不存在,moduleId: {}", moduleId);
            throw new JnSpringCloudException(SysExceptionEnums.UPDATEDATA_NOT_EXIST);
        }

        //2.禁止修改模块编码
        if (!tbSysModule1.getModuleCode().equals(moduleCode)) {
            logger.warn("[数据字典] 修改失败,模块编码不允许修改,moduleId: {}", moduleId);
            throw new JnSpringCloudException(SysDictExceptionEnums.NOT_MODIFY_MODULE_KEY);
        }

        //3.更新数据
        tbSysModuleMapper.updateByPrimaryKeySelective(tbSysModule);
        logger.info("[模块] 修改成功,moduleId: {}", tbSysModule.getId());
    }

    /**
     * 逻辑删除模块
     *
     * @param moduleId 模块id
     * @param user     当前用户
     */
    @Override
    @ServiceLog(doAction = "逻辑删除模块")
    @Transactional(rollbackFor = Exception.class)
    public void delete(String moduleId, User user) {
        //1.判断当前模块是否被数据字典正在使用,使用,不允许删除
        TbSysDictModule tbSysModule = tbSysModuleMapper.selectByPrimaryKey(moduleId);
        if (tbSysModule != null && SysStatusEnums.EFFECTIVE.getCode().equals(tbSysModule.getRecordStatus().toString())) {
            //查询数据字典表
            TbSysDictCriteria tbSysDictCriteria = new TbSysDictCriteria();
            TbSysDictCriteria.Criteria criteria = tbSysDictCriteria.createCriteria();
            Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
            criteria.andRecordStatusEqualTo(recordStatus);
            criteria.andModuleCodeEqualTo(tbSysModule.getModuleCode());
            List<TbSysDict> tbSysDicts = tbSysDictMapper.selectByExample(tbSysDictCriteria);
            //如果查询数据不为空,不允许删除模块
            if (tbSysDicts != null && tbSysDicts.size() > 0) {
                logger.warn("[数据字典] 删除失败,模块正在被数据字典使用,不允许删除,moduleId: {}", moduleId);
                throw new JnSpringCloudException(SysDictExceptionEnums.NOT_ALLOWED_DELETE_MODULE);
            }
        }

        //2.逻辑删除模块
        Byte recordStatus = Byte.parseByte(SysStatusEnums.DELETED.getCode());
        tbSysModule.setRecordStatus(recordStatus);
        tbSysModuleMapper.updateByPrimaryKeySelective(tbSysModule);
        logger.info("[模块] 模块删除成功,moduleId: {}", moduleId);
    }

    /**
     * 获取全部模块
     *
     * @return
     */
    @Override
    @ServiceLog(doAction = "获取全部模块")
    public List<SysDictModule> getAll() {
        TbSysDictModuleCriteria tbSysModuleCriteria = new TbSysDictModuleCriteria();
        //设置排序
        tbSysModuleCriteria.setOrderByClause("created_time asc,id asc");
        TbSysDictModuleCriteria.Criteria criteria = tbSysModuleCriteria.createCriteria();
        Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
        criteria.andRecordStatusEqualTo(recordStatus);
        List<TbSysDictModule> tbSysModules = tbSysModuleMapper.selectByExample(tbSysModuleCriteria);
        List<SysDictModule> list = new ArrayList<SysDictModule>(16);
        for (TbSysDictModule tbSysModule : tbSysModules) {
            SysDictModule sysDictModule = new SysDictModule();
            BeanUtils.copyProperties(tbSysModule, sysDictModule);
            list.add(sysDictModule);
        }
        return list;
    }

    /**
     * 条件分页查询模块列表
     *
     * @param sysDictModulePage 查询条件
     * @return
     */
    @Override
    @ServiceLog(doAction = "条件分页查询模块列表")
    public PaginationData<List<SysDictModule>> getModuleByPage(SysDictModulePage sysDictModulePage) {
        Page<Object> objects = PageHelper.startPage(sysDictModulePage.getPage(), sysDictModulePage.getRows());
        List<SysDictModule> sysDictModuleList = sysDictModuleMapper.getModuleByPage(sysDictModulePage);
        PaginationData data = new PaginationData(sysDictModuleList, objects.getTotal());
        return data;
    }
}
