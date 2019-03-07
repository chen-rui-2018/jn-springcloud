package com.jn.park.finance.service;

import com.jn.common.model.PaginationData;
import com.jn.park.finance.model.FinanceTypeModel;

import java.util.List;

/**财务费用类型service
 * @author： huangbq
 * @date： Created on 2019/3/6 23:28
 * @version： v1.0
 * @modified By:
 */
public interface FinanceTypeService {
    /**
     * 添加修改财务项目类型
     * @param financeTypeModel
     * @return
     */
    Integer saveOrUpdate(FinanceTypeModel financeTypeModel,String userAccount);

    /**
     * 更新财务项目类型对应的部门
     * @param typeId
     * @param departmentIdList
     * @return
     */
    Integer updateDepartmentByType(Integer typeId, List<String>departmentIdList,String userAccount);

    /**
     * 更新部门对应的财务项目类型
     * @param departmentId
     * @param typeIdList
     * @param userAccount
     * @return
     */
    Integer updateTypeByDepartment(String departmentId, List<Integer>typeIdList,String userAccount);

    /**
     * 查看所有财务项目类型
     * @param departmentId
     * @return
     */
    List<FinanceTypeModel>selectByDepart(String departmentId);
}
