package com.jn.hardware.model.dingtalk.user;

import com.jn.hardware.enums.dingtalk.DepartmentUserOrderEnum;
import com.jn.hardware.model.dingtalk.BaseResult;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 钉钉：获取部门用户详细信息传参实体
 *
 * @Author： cm
 * @Date： Created on 2019/6/15 15:32
 * @Version： v1.0
 * @Modified By:
 */
public class DepartmentUserInfoParam extends BaseResult implements Serializable {
    private static final long serialVersionUID = -7477849403489434269L;

    /**
     * 通讯录语言(默认zh_CN另外支持en_US)
     */
    private String lang="";
    @NotBlank(message = "部门id不能为空")
    private String department_id;
    @NotNull(message = "offset不能为空，与size参数同时设置时才生效，此参数代表偏移量,偏移量从0开始")
    private Long offset;
    @NotNull(message="分页大小不能为空，与offset参数同时设置时才生效，最小1，最大100条")
    private Long size;
    /**
     * 支持分页查询，部门成员的排序规则，默认 是按自定义排序；
     * entry_asc：代表按照进入部门的时间升序，
     * entry_desc：代表按照进入部门的时间降序，
     * modify_asc：代表按照部门信息修改时间升序，
     * modify_desc：代表按照部门信息修改时间降序，
     * custom：代表用户定义(未定义时按照拼音)排序
     */
    private DepartmentUserOrderEnum departmentUserOrder;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public DepartmentUserOrderEnum getDepartmentUserOrder() {
        return departmentUserOrder;
    }

    public void setDepartmentUserOrder(DepartmentUserOrderEnum departmentUserOrder) {
        this.departmentUserOrder = departmentUserOrder;
    }

    @Override
    public String toString() {
        return "DepartmentUserInfoParam{" +
                "lang='" + lang + '\'' +
                ", department_id='" + department_id + '\'' +
                ", offset=" + offset +
                ", size=" + size +
                ", departmentUserOrder=" + departmentUserOrder +
                '}';
    }
}
