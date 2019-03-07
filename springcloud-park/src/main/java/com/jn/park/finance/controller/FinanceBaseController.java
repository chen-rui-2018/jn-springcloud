package com.jn.park.finance.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.system.model.User;
import com.jn.system.vo.SysDepartmentPostVO;
import org.apache.shiro.SecurityUtils;

/**
 * @author： huangbq
 * @date： Created on 2019/3/7 20:11
 * @version： v1.0
 * @modified By:
 */
public abstract class FinanceBaseController extends BaseController {
    protected User getUser(){
        return  (User) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 校验departmentId是否属于用户所属的部门
     * @param user
     * @param departmentId
     */
    protected void checkDepartmentId(User user,String departmentId){
        boolean flag=false;
        for(SysDepartmentPostVO departmentPostVO:user.getSysDepartmentPostVO()){
            if(StringUtils.equals(departmentId,departmentPostVO.getDepartmentId())){
                flag=true;
                break;
            }
        }
        if(!flag){
            throw new JnSpringCloudException(new Result("-1","你不属于此部门"));
        }
    }

    /**
     * 是否为财务部
     * @param user
     * @return
     */
    protected boolean isFinanceDepartment(User user){
        //todo
        for(SysDepartmentPostVO departmentPostVO:user.getSysDepartmentPostVO()){
            if(departmentPostVO.getDepartmentId().indexOf("财务部")>-1){
                return true;
            }
        }
        return false;
    }
}
