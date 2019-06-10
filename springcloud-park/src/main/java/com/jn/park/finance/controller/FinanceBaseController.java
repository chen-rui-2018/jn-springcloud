package com.jn.park.finance.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.system.model.User;
import com.jn.system.vo.SysDepartmentPostVO;
import org.apache.shiro.SecurityUtils;

import java.util.List;
import java.util.stream.Collectors;

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
     * @param departmentId
     */
    protected void checkUserDepartmentId(String departmentId){
        if(StringUtils.isBlank(departmentId)){
            return;
        }
        boolean flag=false;
        for(SysDepartmentPostVO departmentPostVO:getUser().getSysDepartmentPostVO()){
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
     * 用户所属的部门ID，多个ID用,隔开
     * @return
     */
    protected String getUserDepartmentIds(){
        List<String>deaprtmentIdList= getUser().getSysDepartmentPostVO().stream().map(e->e.getDepartmentId()).collect(Collectors.toList());
        return StringUtils.join(deaprtmentIdList.toArray(),",");
    }

    /**
     * 是否为财务部
     * @return
     */
    protected boolean isFinanceDepartmentUser(){
        //todo
        for(SysDepartmentPostVO departmentPostVO:getUser().getSysDepartmentPostVO()){
            if(departmentPostVO.getDepartmentId().indexOf("财务部")>-1){
                return true;
            }
        }
        return false;
    }
}
