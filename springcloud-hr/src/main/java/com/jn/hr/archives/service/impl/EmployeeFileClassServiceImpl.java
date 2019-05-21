package com.jn.hr.archives.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.StringUtils;
import com.jn.hr.archives.dao.TbManpowerEmployeeFileClassMapper;
import com.jn.hr.archives.entity.TbManpowerEmployeeFileClass;
import com.jn.hr.archives.entity.TbManpowerEmployeeFileClassCriteria;
import com.jn.hr.archives.model.EmployeeFileClass;
import com.jn.hr.archives.model.EmployeeFileClassAdd;
import com.jn.hr.archives.model.TreeModel;
import com.jn.hr.archives.service.EmployeeFileClassService;
import com.jn.hr.common.util.BeanCopyUtil;
import com.jn.hr.employee.enums.EmployeeExceptionEnums;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author dt
 * @create 2019-04-17 上午 10:06
 */
@Service
public class EmployeeFileClassServiceImpl implements EmployeeFileClassService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeFileClassServiceImpl.class);
    @Autowired
    TbManpowerEmployeeFileClassMapper tbManpowerEmployeeFileClassMapper;
    @Override
    @ServiceLog(doAction = "添加员工档案分类")
    @Transactional(rollbackFor = Exception.class)
    public EmployeeFileClass addEmployeeFileClass(EmployeeFileClassAdd employeeFileClassAdd, User user) {
        TbManpowerEmployeeFileClass tbEmployeeFile=new TbManpowerEmployeeFileClass();
        BeanUtils.copyProperties(employeeFileClassAdd,tbEmployeeFile);
        if(StringUtils.isEmpty(employeeFileClassAdd.getParentId())){
            tbEmployeeFile.setParentId("0");
            tbEmployeeFile.setLevel("1");
        }
        tbEmployeeFile.setClassId(UUID.randomUUID().toString());
        employeeFileClassAdd.setClassId(tbEmployeeFile.getClassId());
        tbManpowerEmployeeFileClassMapper.insert(tbEmployeeFile);
        logger.info("[员工档案分类管理] 新增员工档案分类成功,id:{}", tbEmployeeFile.getClassId());
        EmployeeFileClass fileClass=BeanCopyUtil.copyObject(employeeFileClassAdd,EmployeeFileClass.class);
        return fileClass;
    }

    @Override
    @ServiceLog(doAction = "修改员工档案分类")
    @Transactional(rollbackFor = Exception.class)
    public void updateEmployeeFileClass(EmployeeFileClassAdd employeeFileClassAdd, User user) {
        TbManpowerEmployeeFileClass tbFileClass=tbManpowerEmployeeFileClassMapper.selectByPrimaryKey
                (employeeFileClassAdd.getClassId());
        if(tbFileClass==null){
            logger.warn("[员工档案分类管理] 修改员工档案分类失败,修改信息不存在,classId:{}",
                    employeeFileClassAdd.getClassId());
            throw new JnSpringCloudException(EmployeeExceptionEnums.EmployeeFileClass_NOT_EXISTS);
        }
        TbManpowerEmployeeFileClass database=new TbManpowerEmployeeFileClass();
        BeanUtils.copyProperties(employeeFileClassAdd,database);
        if(StringUtils.isEmpty(employeeFileClassAdd.getParentId())){
            database.setParentId("0");
            database.setLevel("1");
        }
        tbManpowerEmployeeFileClassMapper.updateByPrimaryKeySelective(database);
        logger.info("[员工档案分类管理] 修改员工档案成功,fileId:{}", database.getClassId());
    }

    @Override
    @ServiceLog(doAction = "删除员工档案分类")
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id, User user) {
        TbManpowerEmployeeFileClass tbFile = tbManpowerEmployeeFileClassMapper.selectByPrimaryKey(id);
        if (tbFile != null) {
            tbManpowerEmployeeFileClassMapper.deleteByPrimaryKey(id);
            //递归删除所有子节点
            List<TreeModel> childrens=getEmployeeFileClassByParentId(id);
            if(!CollectionUtils.isEmpty(childrens)){
                getTreeList(childrens);
                deleteChildren(childrens);
            }

        }
        logger.info("[员工档案分类管理] 删除员工档案分类成功,id:{}", id);
    }

    private void deleteChildren(List<TreeModel> childrens){
        if(!CollectionUtils.isEmpty(childrens)){
            for (TreeModel children : childrens) {
                tbManpowerEmployeeFileClassMapper.deleteByPrimaryKey(children.getId());
                deleteChildren(children.getChildren());
            }
        }
    }

    @Override
    @ServiceLog(doAction = "查询员工档案分类")
    public List<TreeModel> getEmployeeFileClassByParentId(String parentId) {
        TbManpowerEmployeeFileClassCriteria example=new TbManpowerEmployeeFileClassCriteria();
        TbManpowerEmployeeFileClassCriteria.Criteria criteria=example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbManpowerEmployeeFileClass> tbFileClass=tbManpowerEmployeeFileClassMapper.selectByExample(example);
        List<TreeModel>  fileClassList=new ArrayList<TreeModel>();
        if(!CollectionUtils.isEmpty(tbFileClass)){
            for (TbManpowerEmployeeFileClass fileClass : tbFileClass) {
                TreeModel tree=new TreeModel();
                tree.setId(fileClass.getClassId());
                tree.setLabel(fileClass.getNodeName());
                tree.setLevel(fileClass.getLevel());
                tree.setParentId(fileClass.getParentId());
                fileClassList.add(tree);
            }
        }
        return fileClassList;
    }

    @Override
    @ServiceLog(doAction = "查询员工档案分类树")
    public List<TreeModel> getAllEmployeeFileClass() {
        List<TreeModel> list=getEmployeeFileClassByParentId("0");
        if(CollectionUtils.isEmpty(list)){
            return new ArrayList<TreeModel>();
        }
        getTreeList(list);
        return list;
    }
    private void getTreeList(List<TreeModel> list){
        for (TreeModel employeeFileClass : list) {
            List<TreeModel> childrenList=getEmployeeFileClassByParentId(employeeFileClass.getId());
            employeeFileClass.setChildren(childrenList);
            if(!CollectionUtils.isEmpty(childrenList)){
                getTreeList(childrenList);
            }
        }
    }
}
