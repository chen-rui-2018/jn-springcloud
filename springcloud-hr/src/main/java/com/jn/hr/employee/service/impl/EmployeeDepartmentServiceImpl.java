package com.jn.hr.employee.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.StringUtils;
import com.jn.hr.common.enums.HrExceptionEnums;
import com.jn.hr.common.util.BeanCopyUtil;
import com.jn.hr.employee.dao.TbManpowerDepartmentMapper;
import com.jn.hr.employee.entity.TbManpowerDepartment;
import com.jn.hr.employee.entity.TbManpowerDepartmentCriteria;
import com.jn.hr.employee.model.EmployeeDepartment;
import com.jn.hr.employee.model.EmployeeDepartmentAdd;
import com.jn.hr.employee.service.EmployeeDepartmentService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @author dt
 * @create 2019-04-19 上午 8:33
 */
@Service
public class EmployeeDepartmentServiceImpl implements EmployeeDepartmentService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDepartmentServiceImpl.class);
    @Autowired
    TbManpowerDepartmentMapper tbManpowerDepartmentMapper;
    @Override
    @ServiceLog(doAction = "添加组织架构")
    @Transactional(rollbackFor = Exception.class)
    public EmployeeDepartment addEmployeeDepartment(EmployeeDepartmentAdd employeeDepartmentAdd, User user) {
        TbManpowerDepartment tbEmployeeFile=new TbManpowerDepartment();
        BeanUtils.copyProperties(employeeDepartmentAdd,tbEmployeeFile);
        if(!checkDepartmentName(employeeDepartmentAdd.getDepartmentId(),employeeDepartmentAdd.getDepartmentName())){
            throw new JnSpringCloudException(HrExceptionEnums.ADDERR_NAME_EXIST);
        }
        tbEmployeeFile.setDepartmentId(UUID.randomUUID().toString());
        employeeDepartmentAdd.setDepartmentId(tbEmployeeFile.getDepartmentId());
        tbManpowerDepartmentMapper.insert(tbEmployeeFile);
        logger.info("[组织架构管理] 新增组织架构成功,id:{}", employeeDepartmentAdd.getDepartmentId());
        EmployeeDepartment employeeDepartment=BeanCopyUtil.copyObject(employeeDepartmentAdd,EmployeeDepartment.class);
        return employeeDepartment;
    }

    @Override
    @ServiceLog(doAction = "修改组织架构")
    @Transactional(rollbackFor = Exception.class)
    public void updateEmployeeDepartment(EmployeeDepartmentAdd employeeDepartmentAdd, User user) {
        TbManpowerDepartment tbFileClass=tbManpowerDepartmentMapper.selectByPrimaryKey
                (employeeDepartmentAdd.getDepartmentId());
        if(tbFileClass==null){
            logger.warn("[组织架构管理] 修改组织架构失败,修改信息不存在,departmentId:{}",
                    employeeDepartmentAdd.getDepartmentId());
            throw new JnSpringCloudException(HrExceptionEnums.UPDATEDATA_NOT_EXIST);
        }
        if(!checkDepartmentName(employeeDepartmentAdd.getDepartmentId(),employeeDepartmentAdd.getDepartmentName())){
            throw new JnSpringCloudException(HrExceptionEnums.UPDATEERR_NAME_EXIST);
        }
        TbManpowerDepartment database=new TbManpowerDepartment();
        BeanUtils.copyProperties(employeeDepartmentAdd,database);
        tbManpowerDepartmentMapper.updateByPrimaryKeySelective(database);
        logger.info("[组织架构管理] 修改员工档案成功,departmentId:{}", database.getDepartmentId());
    }

    @Override
    @ServiceLog(doAction = "删除组织架构")
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id, User user) {
        TbManpowerDepartment tbFile = tbManpowerDepartmentMapper.selectByPrimaryKey(id);
        if (tbFile != null) {
            tbManpowerDepartmentMapper.deleteByPrimaryKey(id);
        }
        logger.info("[组织架构管理] 删除组织架构成功,id:{}", id);
    }

    @Override
    @ServiceLog(doAction = "查询组织架构")
    public List<EmployeeDepartment> getEmployeeDepartments() {
        TbManpowerDepartmentCriteria example=new TbManpowerDepartmentCriteria();
        TbManpowerDepartmentCriteria.Criteria criteria=example.createCriteria();
        List<TbManpowerDepartment> tbFileClass=tbManpowerDepartmentMapper.selectByExample(example);
        List<EmployeeDepartment>  fileClassList= BeanCopyUtil.copyList(tbFileClass, EmployeeDepartment.class);
        return fileClassList;
    }

    public boolean checkDepartmentName(String departmentId,String departmentName){
        TbManpowerDepartmentCriteria example=new TbManpowerDepartmentCriteria();
        TbManpowerDepartmentCriteria.Criteria criteria=example.createCriteria();
        criteria.andDepartmentNameEqualTo(departmentName);
        if(!StringUtils.isBlank(departmentId)){
            criteria.andDepartmentIdNotEqualTo(departmentId);
        }
        List<TbManpowerDepartment> tbFileClass=tbManpowerDepartmentMapper.selectByExample(example);
        return CollectionUtils.isEmpty(tbFileClass) ? true : false;
    }
}
