package com.jn.park.finance.service.impl;

import com.jn.park.finance.dao.FinanceTypeMapper;
import com.jn.park.finance.dao.TbFinanceDepartmentToTypeMapper;
import com.jn.park.finance.dao.TbFinanceTypeMapper;
import com.jn.park.finance.entity.TbFinanceDepartmentToType;
import com.jn.park.finance.entity.TbFinanceDepartmentToTypeExample;
import com.jn.park.finance.entity.TbFinanceType;
import com.jn.park.finance.model.FinanceTypeModel;
import com.jn.park.finance.service.FinanceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class FinanceTypeServiceImpl implements FinanceTypeService {
    @Autowired
    private TbFinanceTypeMapper tbFinanceTypeMapper;
    @Autowired
    private TbFinanceDepartmentToTypeMapper tbFinanceDepartmentToTypeMapper;
    @Autowired
    private FinanceTypeMapper financeTypeMapper;
    @Override
    public Integer saveOrUpdate(FinanceTypeModel financeTypeModel, String userAccount) {
        TbFinanceType tbFinanceType=new TbFinanceType();
        BeanUtils.copyProperties(financeTypeModel,tbFinanceType);
        Integer count=0;
        if(null==financeTypeModel.getId()){
           tbFinanceType.setCreatedTime(new Date());
           tbFinanceType.setCreatorAccount(userAccount);
           return tbFinanceTypeMapper.insertSelective(tbFinanceType);
        }else{
            tbFinanceType.setModifiedTime(new Date());
            tbFinanceType.setModifierAccount(userAccount);
            return tbFinanceTypeMapper.updateByPrimaryKeySelective(tbFinanceType);
        }
    }

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
        tbFinanceDepartmentToTypeMapper.updateByExampleSelective(deleteRecord,example);
        //2、添加typeId类型的所有部门
        int i=0;
        List<TbFinanceDepartmentToType>tbFinanceDepartmentToTypeList=new ArrayList<>();
        for(String departmentId:departmentIdList){
            TbFinanceDepartmentToType tbFinanceDepartmentToType=new TbFinanceDepartmentToType();
            tbFinanceDepartmentToType.setDepartmentId(departmentId);
            tbFinanceDepartmentToType.setFinanceTypeId(typeId);
            tbFinanceDepartmentToType.setCreatedTime(new Date());
            tbFinanceDepartmentToType.setCreatorAccount(userAccount);
            tbFinanceDepartmentToTypeMapper.insert(tbFinanceDepartmentToType);
            i++;
        }

        return i;
    }

    @Override
    public Integer updateTypeByDepartment(String departmentId, List<Integer> typeIdList, String userAccount) {
        //1、删除 typeId类型的所有数据
        TbFinanceDepartmentToTypeExample example=new TbFinanceDepartmentToTypeExample();
        TbFinanceDepartmentToTypeExample.Criteria criteria=example.createCriteria();
        criteria.andDepartmentIdEqualTo(departmentId).andRecordStatusEqualTo(new Byte("1"));
        TbFinanceDepartmentToType deleteRecord=new TbFinanceDepartmentToType();
        deleteRecord.setRecordStatus(new Byte("-1"));
        deleteRecord.setModifiedTime(new Date());
        deleteRecord.setModifierAccount(userAccount);
        tbFinanceDepartmentToTypeMapper.updateByExampleSelective(deleteRecord,example);
        //2、添加typeId类型的所有部门
        int i=0;
        List<TbFinanceDepartmentToType>tbFinanceDepartmentToTypeList=new ArrayList<>();
        for(Integer typeId:typeIdList){
            TbFinanceDepartmentToType tbFinanceDepartmentToType=new TbFinanceDepartmentToType();
            tbFinanceDepartmentToType.setDepartmentId(departmentId);
            tbFinanceDepartmentToType.setFinanceTypeId(typeId);
            tbFinanceDepartmentToType.setCreatedTime(new Date());
            tbFinanceDepartmentToType.setCreatorAccount(userAccount);
            tbFinanceDepartmentToTypeMapper.insert(tbFinanceDepartmentToType);
            i++;
        }

        return i;
    }

    @Override
    public List<FinanceTypeModel> selectByDepart(String departmentId) {
        return financeTypeMapper.selectByDepart(departmentId);
    }
}
