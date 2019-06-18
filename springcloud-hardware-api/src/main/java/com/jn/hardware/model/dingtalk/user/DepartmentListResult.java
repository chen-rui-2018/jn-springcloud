package com.jn.hardware.model.dingtalk.user;

import com.jn.hardware.model.dingtalk.BaseResult;

import java.io.Serializable;
import java.util.List;

/**
 * 钉钉：获取部门列表信息出参实体类
 *
 * @Author： cm
 * @Date： Created on 2019/6/17 11:00
 * @Version： v1.0
 * @Modified By:
 */
public class DepartmentListResult extends BaseResult implements Serializable {
    private static final long serialVersionUID = 1586962837591086605L;

    private List<DepartmentInfo> department;

    public List<DepartmentInfo> getDepartment() {
        return department;
    }

    public void setDepartment(List<DepartmentInfo> department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "DepartmentListResult{" +
                "department=" + department +
                '}';
    }
}
