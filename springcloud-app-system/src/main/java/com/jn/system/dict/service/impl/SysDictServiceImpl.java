package com.jn.system.dict.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.common.util.cache.RedisCacheFactory;
import com.jn.common.util.cache.service.Cache;
import com.jn.system.common.enums.SysExceptionEnums;
import com.jn.system.common.enums.SysLevelEnums;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.dict.dao.SysDictMapper;
import com.jn.system.dict.dao.TbSysDictMapper;
import com.jn.system.dict.domain.SysDictProperties;
import com.jn.system.dict.entity.TbSysDict;
import com.jn.system.dict.entity.TbSysDictCriteria;
import com.jn.system.dict.enums.SysDictExceptionEnums;
import com.jn.system.dict.model.*;
import com.jn.system.dict.service.SysDictService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysDictInvoke;
import com.jn.system.model.User;
import com.jn.system.vo.SysDictKeyValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 数据字典服务层实现
 *
 * @author： shaobao
 * @date： Created on 2019/1/24 16:19
 * @version： v1.0
 * @modified By:
 **/
@Service
public class SysDictServiceImpl implements SysDictService {

    private static final Logger logger = LoggerFactory.getLogger(SysDictServiceImpl.class);

    @Autowired
    private TbSysDictMapper tbSysDictMapper;
    @Autowired
    private SysDictMapper sysDictMapper;
    @Autowired
    private RedisCacheFactory redisCacheFactory;

    @Autowired
    private SysDictProperties dictProperties;
    /**
     * 数据字典缓存名称
     */
    private static final String SYSTEM_DICT_INFO = "system_dict_info";


    /**
     * 新增数据字典
     *
     * @param tbSysDict 数据字典对象
     */
    @Override
    @ServiceLog(doAction = "新增数据字典")
    @Transactional(rollbackFor = Exception.class)
    public void add(TbSysDict tbSysDict) {
        //1.判断添加的数据字典键在分组中是否已经存在
        Boolean flag = checkDictKey(tbSysDict);
        if (flag) {
            logger.warn("[数据字典] 数据字典添加失败，数据字典键已存在！,dictKey: {}", tbSysDict.getDictKey());
            throw new JnSpringCloudException(SysDictExceptionEnums.ADDERR_KEY_REPEAAT);
        }

        //2.设置添加数据字典排序
        Integer sortMax = sysDictMapper.getMaxSort(tbSysDict);
        if (sortMax != null) {
            tbSysDict.setSort(sortMax + 1);
        } else {
            //如果查询不到数据,直接设置排序为1
            tbSysDict.setSort(Integer.parseInt(SysLevelEnums.FIRST_LEVEL.getCode()));
        }

        //3.将数据保存只数据库
        tbSysDictMapper.insertSelective(tbSysDict);

        //4.清除缓存中对应分组数据
        removeCache(tbSysDict);
        logger.info("[数据字典] 添加成功,dictId: {}", tbSysDict.getId());
    }

    /**
     * 修改数据字典
     *
     * @param tbSysDict
     */
    @Override
    @ServiceLog(doAction = "修改数据字典")
    @Transactional(rollbackFor = Exception.class)
    public void update(TbSysDict tbSysDict) {
        String dictId = tbSysDict.getId();
        String dictKey = tbSysDict.getDictKey();
        //1.根据id查询修改数据是否已经存在
        TbSysDict tbSysDict1 = tbSysDictMapper.selectByPrimaryKey(dictId);
        if (tbSysDict1 == null || SysStatusEnums.DELETED.equals(tbSysDict1.getRecordStatus().toString())) {
            logger.warn("[数据字典] 修改失败,修改信息不存在,dictId: {}", dictId);
            throw new JnSpringCloudException(SysExceptionEnums.UPDATEDATA_NOT_EXIST);
        }

        //2.判断修改数据字典键在分组中是否已经存在
        if (!tbSysDict1.getDictKey().equals(dictKey)) {
            //调用校验数据字典键方法
            Boolean flag = checkDictKey(tbSysDict);
            if (flag) {
                logger.warn("[数据字典] 数据字典修改失败，数据字典键已存在！,dictId: {}", dictId);
                throw new JnSpringCloudException(SysDictExceptionEnums.UPDATEERR_KEY_REPEAAT);
            }
        }

        //3.修改数据字典
        tbSysDictMapper.updateByPrimaryKeySelective(tbSysDict);

        //4.清除缓存中对应分组数据
        removeCache(tbSysDict);
        logger.info("[数据字典] 修改成功,dictId: {}", dictId);
    }

    /**
     * 清除数据字典对应分组缓存数据
     *
     * @param tbSysDict
     */
    private void removeCache(TbSysDict tbSysDict) {
        StringBuffer buffer = new StringBuffer();
        String code = buffer.append(tbSysDict.getModuleCode())
                .append(tbSysDict.getParentGroupCode())
                .append(tbSysDict.getGroupCode()).toString();
        Cache<Object> cache = redisCacheFactory.getCache(SYSTEM_DICT_INFO, dictProperties.getExpire());
        cache.remove(code);
    }

    /**
     * 逻辑删除数据字典
     *
     * @param dictId 数据字典id
     * @param user   当前用户
     */
    @Override
    @ServiceLog(doAction = "逻辑删除数据字典")
    @Transactional(rollbackFor = Exception.class)
    public void delete(String dictId, User user) {
        //1.获取要删除的数据
        TbSysDict tbSysDict = tbSysDictMapper.selectByPrimaryKey(dictId);
        if (tbSysDict == null) {
            return;
        }

        //2.更新最新更新人及最新更新时间
        tbSysDict.setModifiedTime(new Date());
        tbSysDict.setModifierAccount(user.getAccount());
        Byte recordStatus = Byte.parseByte(SysStatusEnums.DELETED.getCode());
        tbSysDict.setRecordStatus(recordStatus);
        tbSysDictMapper.updateByPrimaryKeySelective(tbSysDict);

        //3.清除缓存中对应分组数据
        removeCache(tbSysDict);
        logger.info("[数据字典] 删除成功,dictId: {}", dictId);
    }

    /**
     * 数据字典分组排序
     *
     * @param sysDictList 数据字典集合
     * @param user        当前用户
     */
    @Override
    @ServiceLog(doAction = "数据字典分组排序")
    @Transactional(rollbackFor = Exception.class)
    public void sortByGroup(List<SysDictEdit> sysDictList, User user) {
        if (sysDictList == null || sysDictList.size() == 0) {
            return;
        }
        //2.使用map封装修改参数
        Map<String, Object> map = new HashMap<String, Object>(16);
        map.put("list", sysDictList);
        map.put("account", user.getAccount());
        sysDictMapper.sortByGroup(map);

        //2.清除缓存中对应分组数据
        TbSysDict tbSysDict = tbSysDictMapper.selectByPrimaryKey(sysDictList.get(0).getId());
        removeCache(tbSysDict);
        logger.info("[数据字典] 数据字典分组排序成功,排序数据:{}", sysDictList);
    }

    /**
     * 条件分页查询数据字典列表
     *
     * @param sysDictPage 查询条件
     * @return
     */
    @Override
    @ServiceLog(doAction = "条件分页查询数据字典列表")
    public PaginationData<List<SysDict>> getDictByPage(SysDictPage sysDictPage) {
        Page<Object> objects = PageHelper.startPage(sysDictPage.getPage(), sysDictPage.getRows());
        List<SysDict> sysDictList = sysDictMapper.getDictByPage(sysDictPage);
        PaginationData date = new PaginationData(sysDictList, objects.getTotal());
        return date;
    }

    /**
     * 数据字典调用接口
     *
     * @param sysDictInvoke
     * @return
     */
    @Override
    @ServiceLog(doAction = "数据字典调用接口")
    public List<SysDictKeyValue> getDict(SysDictInvoke sysDictInvoke) {
        //1.拼接编码
        StringBuffer buffer = new StringBuffer();
        String code = buffer.append(sysDictInvoke.getModuleCode())
                .append(sysDictInvoke.getParentGroupCode())
                .append(sysDictInvoke.getGroupCode()).toString();

        //2.获取缓存实例,从缓存中获取数据字典
        Cache<Object> cache = redisCacheFactory.getCache(SYSTEM_DICT_INFO, dictProperties.getExpire());
        List<SysDictKeyValue> dictList = (List<SysDictKeyValue>) cache.get(code);
        if (dictList != null && dictList.size() > 0) {
            return dictList;
        }

        //3.若是缓存中没有数据,查询数据库
        List<TbSysDict> tbSysDicts = getTbSysDicts(sysDictInvoke);
        //如果查询数据不为空
        if (tbSysDicts == null || tbSysDicts.size() == 0) {
            return null;
        }

        //4.封装返回数据
        List<SysDictKeyValue> list = new ArrayList<SysDictKeyValue>();
        for (TbSysDict tbSysDict : tbSysDicts) {
            SysDictKeyValue dict = new SysDictKeyValue();
            dict.setKey(tbSysDict.getDictKey());
            dict.setLable(tbSysDict.getDictValue());
            list.add(dict);
        }

        //5.将数据存入缓存,返回数据
        cache.put(code, list);
        return list;
    }

    /**
     * 分组排序搜索功能
     *
     * @param sysDictInvoke
     * @return
     */
    @Override
    public List<TbSysDict> sortSearch(SysDictInvoke sysDictInvoke) {
        List<TbSysDict> tbSysDicts = getTbSysDicts(sysDictInvoke);
        return tbSysDicts;
    }

    /**
     * 根据数据字典模块编码父分组编码分组编码查询数据字典
     *
     * @param sysDictInvoke
     * @return
     */
    private List<TbSysDict> getTbSysDicts(SysDictInvoke sysDictInvoke) {
        TbSysDictCriteria tbSysDictCriteria = new TbSysDictCriteria();
        //设置排序
        tbSysDictCriteria.setOrderByClause("sort ASC");
        //设置查询条件
        TbSysDictCriteria.Criteria criteria = tbSysDictCriteria.createCriteria();
        Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
        criteria.andRecordStatusEqualTo(recordStatus);
        criteria.andModuleCodeEqualTo(sysDictInvoke.getModuleCode());
        criteria.andParentGroupCodeEqualTo(sysDictInvoke.getParentGroupCode());
        criteria.andGroupCodeEqualTo(sysDictInvoke.getGroupCode());
        if(StringUtils.isNotBlank(sysDictInvoke.getKey())){
            criteria.andDictKeyEqualTo(sysDictInvoke.getKey());
        }
        return tbSysDictMapper.selectByExample(tbSysDictCriteria);
    }
    /**
     *根据条件查询数据字典的值
     * @param sysDictInvoke
     * @return
     */
    @Override
    public String selectDictValueByCondition(SysDictInvoke sysDictInvoke){
        List<TbSysDict> tbSysDictList=getTbSysDicts(sysDictInvoke);
        if(tbSysDictList!=null && tbSysDictList.size()>0){
            return tbSysDictList.get(0).getDictValue();
        }
        return null;
    }


    /**
     * 校验数据字典键在分组中是否已经存在
     *
     * @param tbSysDict 数据字典对象
     * @return
     */
    private Boolean checkDictKey(TbSysDict tbSysDict) {
        //设置查询条件
        TbSysDictCriteria tbSysDictCriteria = new TbSysDictCriteria();
        TbSysDictCriteria.Criteria criteria = tbSysDictCriteria.createCriteria();
        Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
        criteria.andRecordStatusEqualTo(recordStatus);
        criteria.andModuleCodeEqualTo(tbSysDict.getModuleCode());
        criteria.andParentGroupCodeEqualTo(tbSysDict.getParentGroupCode());
        criteria.andGroupCodeEqualTo(tbSysDict.getGroupCode());
        criteria.andDictKeyEqualTo(tbSysDict.getDictKey());
        List<TbSysDict> tbSysDicts = tbSysDictMapper.selectByExample(tbSysDictCriteria);
        //如果查询数据不为空,返回true,否则返回false
        if (tbSysDicts != null && tbSysDicts.size() > 0) {
            return true;
        }
        return false;
    }
}
