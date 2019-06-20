package com.jn.enterprise.pd.personnel.service;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.model.PersonnelProject;
import com.jn.enterprise.pd.personnel.entity.TbPersonnelProject;

import java.util.List;

/**
 * 人才服务-人才申报业务层
 *
 * @author： wzy
 * @date： Created on 2019/4/28 15:05
 * @version： v1.0
 * @modified By:
 */
public interface PersonnelService {

    /**
     * 查询常年申报列表
     *
     * @param
     * @return
     */
    List<PersonnelProject> selectByPersonnelProjectList(PersonnelProject personnelProject);

}
