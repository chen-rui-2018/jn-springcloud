package com.jn.enterprise.pd.personnel.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.model.PersonnelProject;
import com.jn.enterprise.pd.personnel.dao.TbPersonnelProjectMapper;
import com.jn.enterprise.pd.personnel.entity.TbPersonnelProject;
import com.jn.enterprise.pd.personnel.entity.TbPersonnelProjectCriteria;
import com.jn.enterprise.pd.personnel.service.PersonnelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Short.parseShort;

/**
 * 人才申报业务层
 *
 * @author： wzy
 * @date： Created on 2019/4/28 16:21
 * @version： v1.0
 * @modified By:
 */
@Service
public class PersonnelServiceImpl implements PersonnelService {
    private static Logger logger = LoggerFactory.getLogger(PersonnelServiceImpl.class);

    @Resource
    private TbPersonnelProjectMapper tbPersonnelProjectMapper;

    @Override
    public List<PersonnelProject> selectByPersonnelProjectList(PersonnelProject personnelProject) {

        TbPersonnelProjectCriteria declarationCriteria = new TbPersonnelProjectCriteria();
        TbPersonnelProjectCriteria.Criteria criteria = declarationCriteria.createCriteria();
        if(StringUtils.isNotEmpty(personnelProject.getName())) {  criteria.andNameLike('%'+personnelProject.getName()+'%');}
        if(StringUtils.isNotEmpty(personnelProject.getCreditCode())) {  criteria.andCreditCodeEqualTo(personnelProject.getCreditCode());}
        if(StringUtils.isNotEmpty(personnelProject.getType())) {  criteria.andTypeEqualTo(personnelProject.getType());}
        if(personnelProject.getStepId() != null) {  criteria.andStepIdEqualTo(personnelProject.getStepId());}
        if(StringUtils.isNotEmpty(personnelProject.getIndustrial())) {  criteria.andTypeEqualTo(personnelProject.getIndustrial());}
        if(StringUtils.isNotEmpty(personnelProject.getCompanyPerson())) {  criteria.andCompanyPersonLike('%'+personnelProject.getCompanyPerson()+'%');}
        if(personnelProject.getCreateTime() != null) { criteria.andCreateTimeGreaterThanOrEqualTo(personnelProject.getCreateTime());}
        List<TbPersonnelProject> list = tbPersonnelProjectMapper.selectByExample(declarationCriteria);
        List<PersonnelProject> perList = new ArrayList<>(list.size());
        for (TbPersonnelProject tb:list) {
            PersonnelProject personnelProject1 = new PersonnelProject();
            BeanUtils.copyProperties(tb,personnelProject1);
            perList.add(personnelProject1);
        }
        return perList;
    }
}

