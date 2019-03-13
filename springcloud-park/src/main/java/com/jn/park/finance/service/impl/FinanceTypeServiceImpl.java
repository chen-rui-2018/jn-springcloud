package com.jn.park.finance.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.park.finance.dao.FinanceTypeDao;
import com.jn.park.finance.dao.TbFinanceDepartmentToTypeMapper;
import com.jn.park.finance.dao.TbFinanceTypeMapper;
import com.jn.park.finance.entity.TbFinanceDepartmentToType;
import com.jn.park.finance.entity.TbFinanceDepartmentToTypeExample;
import com.jn.park.finance.entity.TbFinanceType;
import com.jn.park.finance.entity.TbFinanceTypeExample;
import com.jn.park.finance.enums.FinanceTypeExceptionEnums;
import com.jn.park.finance.model.FinanceDepartmentToTypeModel;
import com.jn.park.finance.model.FinanceTypeModel;
import com.jn.park.finance.service.FinanceTypeService;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author： huangbq
 * @date： Created on 2019/3/7 1:53
 * @version： v1.0
 * @modified By:
 */
@Service
@Transactional
public class FinanceTypeServiceImpl implements FinanceTypeService {
    private static Logger logger = LoggerFactory.getLogger(FinanceTypeServiceImpl.class);
    @Autowired
    private TbFinanceTypeMapper tbFinanceTypeMapper;
    @Autowired
    private TbFinanceDepartmentToTypeMapper tbFinanceDepartmentToTypeMapper;
    @Autowired
    private FinanceTypeDao financeTypeDao;
    @Autowired
    private SystemClient systemClient;

    @ServiceLog(doAction = "添加修改财务项目类型")
    @Override
    public Integer saveOrUpdate(FinanceTypeModel financeTypeModel, String userAccount) {
        //校验名称是否合法
        this.checkTypeName(financeTypeModel.getFinanceName(),financeTypeModel.getId());

        TbFinanceType tbFinanceType=new TbFinanceType();
        BeanUtils.copyProperties(financeTypeModel,tbFinanceType);
        if(null==financeTypeModel.getId()){
           tbFinanceType.setCreatedTime(new Date());
           tbFinanceType.setCreatorAccount(userAccount);
           int addCount=tbFinanceTypeMapper.insertSelective(tbFinanceType);
           logger.info("【添加】财务项目类型成功，添加成功的条数为{},对应ID为{}",addCount,tbFinanceType.getId());
           return tbFinanceType.getId();
        }else{
            tbFinanceType.setModifiedTime(new Date());
            tbFinanceType.setModifierAccount(userAccount);
            int updateCount=tbFinanceTypeMapper.updateByPrimaryKeySelective(tbFinanceType);
            logger.info("【修改】财务项目类型成功，修改成功的条数为{}，对应ID为{}",updateCount,tbFinanceType.getId());
            return updateCount;
        }
    }

    @ServiceLog(doAction = "更新财务项目类型对应的部门")
    @Override
    public Integer updateDepartmentByType(Integer typeId, List<String> departmentIdList, String userAccount) {
        //1、删除 typeId类型的所有数据
        TbFinanceDepartmentToTypeExample example=new TbFinanceDepartmentToTypeExample();
        TbFinanceDepartmentToTypeExample.Criteria criteria=example.createCriteria();
        criteria.andFinanceTypeIdEqualTo(typeId).andRecordStatusEqualTo(new Byte("1"));
        TbFinanceDepartmentToType deleteRecord=new TbFinanceDepartmentToType();
        deleteRecord.setRecordStatus(new Byte("-1"));
        deleteRecord.setModifiedTime(new Date());
        deleteRecord.setModifierAccount(userAccount);
        int deleteCount=tbFinanceDepartmentToTypeMapper.updateByExampleSelective(deleteRecord,example);
        logger.info("成功删除了{}条数据，对应的财务项目类型ID为【{}】",deleteCount,typeId);

        //2、添加typeId类型的所有部门
        int addCount=0;
        List<TbFinanceDepartmentToType>tbFinanceDepartmentToTypeList=new ArrayList<>();
        for(String departmentId:departmentIdList){
            TbFinanceDepartmentToType tbFinanceDepartmentToType=new TbFinanceDepartmentToType();
            tbFinanceDepartmentToType.setDepartmentId(departmentId);
            tbFinanceDepartmentToType.setFinanceTypeId(typeId);
            tbFinanceDepartmentToType.setCreatedTime(new Date());
            tbFinanceDepartmentToType.setCreatorAccount(userAccount);
            tbFinanceDepartmentToTypeMapper.insertSelective(tbFinanceDepartmentToType);
            addCount++;
        }
        logger.info("成功添加了{}条数据，对应的财务项目类型ID为【{}】",addCount,typeId);
        return addCount;
    }


    @ServiceLog(doAction = "查看所有财务项目类型")
    @Override
    public List<FinanceTypeModel> selectTypeByDepartmentIds(String departmentIds,String name) {
        String[] departmentIdArr=departmentIds.split(",");
        for(String departmentId:departmentIdArr){
            Result dept=systemClient.selectDeptByParentId(departmentId,false);
            if (null==dept.getData()){
                throw new JnSpringCloudException(FinanceTypeExceptionEnums.TYPE_DEPT_NOT_EXIST);
            }
        }
        return financeTypeDao.selectTypeByDepartmentIds(departmentIds,name);
    }



    @ServiceLog(doAction = "查看所有部门")
    @Override
    public List<FinanceDepartmentToTypeModel>selectDepartmentByTypeId(Integer typeId){

        return financeTypeDao.selectDepartmentByTypeId(typeId);
    }

   @ServiceLog(doAction = "校验费用类型名称是否已经存在")
    private void checkTypeName(String typeName,Integer typeId){
       //修改操作时，name可能是null(不修改name)，此时路过校验
        if(null!=typeId&&null==typeName){
            return;
        }
        //新增时名称不能为空
        if(null==typeId&&null==typeName){
            throw new JnSpringCloudException(FinanceTypeExceptionEnums.TYPE_NAME_NOT_NULL);
        }
        TbFinanceTypeExample example=new TbFinanceTypeExample();
        TbFinanceTypeExample.Criteria criteria=example.createCriteria();
        criteria.andRecordStatusEqualTo(new Byte("1")).andFinanceNameEqualTo(typeName);
        //修改操作时，名字可修改为当前名称
        if(null!=typeId){
            criteria.andIdNotEqualTo(typeId);
        }
        long count=tbFinanceTypeMapper.countByExample(example);
        if(count>0){
            throw new JnSpringCloudException(FinanceTypeExceptionEnums.TYPE_NAME_EXIST);
        }
    }
}
