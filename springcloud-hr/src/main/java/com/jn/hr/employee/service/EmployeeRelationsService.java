package com.jn.hr.employee.service;

import com.jn.common.model.Result;
import com.jn.hr.employee.model.EmployeeRelationsConfirmParam;
import com.jn.hr.employee.model.EmployeeRelationsPositiveParam;
import com.jn.hr.employee.model.EmployeeRelationsQuitParam;
import com.jn.hr.employee.model.EmployeeRelationsRetireParam;
import com.jn.system.model.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 员工关系业务层
 *
 * @author： wzy
 * @date： Created on 2019/6/11 20:18
 * @version： v1.0
 * @modified By:
 */
public interface EmployeeRelationsService {

    Result updateBecomeStatus(EmployeeRelationsPositiveParam employeeRelationsPositiveParam,User user);

    Result updateRetireStatus(EmployeeRelationsRetireParam employeeRelationsRetireParam,User user);

    Result updateQuitStatus(EmployeeRelationsQuitParam employeeRelationsQuitParam,User user);

    Result confirmationAdmis(EmployeeRelationsConfirmParam employeeRelationsConfirmParam,User user);
}
